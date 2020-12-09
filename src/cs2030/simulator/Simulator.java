package cs2030.simulator;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Simulator {
    private final List<Customer> customerList;
    private final PriorityQueue<Event> PriorityQueueForEvent;
    private final PriorityQueue<Event> PriorityQueueForDisplay;
    private final Shop shop;
    private final Supplier<Double> RandomServingTime;
    private final int maxQueueLength;

    public Simulator(ArrayList<Double> customerArrivingTimes,
                     int maxQueueLength,
                     int noOfServer,
                     Supplier<Double> RandomServingTime) {

        this.customerList = initalizeCustomerList(customerArrivingTimes, RandomServingTime);
        this.maxQueueLength = maxQueueLength;
        this.PriorityQueueForEvent = new PriorityQueue<>(new TimeComparator());
        this.PriorityQueueForDisplay = new PriorityQueue<>(new TimeComparator());
        this.shop = new Shop(noOfServer);
        this.RandomServingTime = RandomServingTime;
    }

    public List<Customer> initalizeCustomerList(ArrayList<Double> customerArrivals, Supplier<Double> serviceTime) {
        List<Integer> list = Stream.iterate(1, i -> i <= customerArrivals.size(), i -> i + 1).collect(Collectors.toList());
        List<Customer> custList = new ArrayList<>();
        list.stream().filter(x -> x <= list.size())
                .forEach(x -> {
                    // System.out.println(serviceTime.get()+"no"+x);
                    Customer cust = new Customer(x, customerArrivals.get(x - 1), serviceTime);
                    custList.add(cust);
                });
        return custList;
    }


    public void start() {
        int noOfServedCustomer = 0;
        int noOfNotServedCustomer = 0;
        int numOfCustomer = 0;
        double totalWaitTime = 0.0;
        Shop newShop = this.shop;
        for (Customer customer : customerList) {
            ArriveEvent arriveEvent = new ArriveEvent(customer,maxQueueLength);
            PriorityQueueForEvent.offer(arriveEvent);
        }
        //int i=0;
        while (PriorityQueueForEvent.peek() != null) {
            //System.out.println(i);
            //i++;
            Event event = this.PriorityQueueForEvent.poll();
            PriorityQueueForDisplay.offer(event);

            if (event instanceof ArriveEvent) {
                numOfCustomer = numOfCustomer + 1;
                Pair<Shop, Event> newPair = event.execute(newShop);
                newShop = newPair.first();
                PriorityQueueForEvent.offer(newPair.second());
            }
            else if (event instanceof Wait) {
                Pair<Shop, Event> newPair = event.execute(newShop);
                newShop = newPair.first();
                PriorityQueueForEvent.offer(newPair.second());
            }else if (event instanceof serveEvent) {
                noOfServedCustomer++;
                totalWaitTime += event.getTime() - event.getCustomer().getArrivingTime();
                Pair<Shop, Event> newPair = event.execute(newShop);
                newShop = newPair.first();
                PriorityQueueForEvent.offer(newPair.second());
            }  else if (event instanceof Done) {
                Pair<Shop, Event> newPair = event.execute(newShop);
                newShop = newPair.first();
            } else if (event instanceof Leave) {
                noOfNotServedCustomer++;
            }
        }
        for (Event e : PriorityQueueForDisplay) {
            System.out.println(e);
        }
        double averageTime;
        if (noOfServedCustomer == 0) {
            averageTime = 0;
        } else {
            averageTime = totalWaitTime / noOfServedCustomer;
        }
        System.out.println(String.format("[%.3f %d %d]", averageTime, noOfServedCustomer, noOfNotServedCustomer));
    }
}