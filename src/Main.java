import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


//import java.util.*;
//
//class Main {
//    private  final List<Customer> customerList = new ArrayList<>();
//    private  final List<Server> serverList = new ArrayList<>();
//    private final PriorityQueue PQ = new PriorityQueue(30);
//    public void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int numOfServers = sc.nextInt();
//
//        for(int i=1;i<=numOfServers;i++){
//            serverList.add(new Server(i,true,false,0));
//        }
//        int j = 1;
//
//        while (sc.hasNextDouble()) {
//            double arrivalTime = sc.nextDouble();
//            customerList.add(new Customer(j, arrivalTime));
//            j++;
//        }
//        for(int k=0;k<customerList.size();k++){
//            double minNextAvailableTime = 0;
//            boolean anyAvailable = false;
//            boolean allhasNextWaiting = true;
//            for(int z=0;z<serverList.size();z++){
//                if(serverList.get(z).getnextAvailableTime()<minNextAvailableTime){
//                    minNextAvailableTime = serverList.get(z).getnextAvailableTime();
//                }
//            }
//            for(int x=0;x<serverList.size();x++){
//                if(serverList.get(x).getisAvailable()){
//                    anyAvailable = true;
//                    break;
//                }
//                else{continue;}
//            }
//            for(int y=0;y<serverList.size();y++){
//                if(!serverList.get(y).gethasWaitingCustomer()){
//                    allhasNextWaiting = false;
//                    break;
//                }
//                else{continue;}}
//            if(!anyAvailable && allhasNextWaiting & customerList.get(k).getArrivingTime()<minNextAvailableTime){
//                ArriveEvent arriveEvent = new ArriveEvent(customerList.get(k),serverList);
//                PQ.add(arriveEvent);
//                PQ.add(new Leave(customerList.get(k),serverList));
//            }
//            else{
//                ArriveEvent arriveEvent = new ArriveEvent(customerList.get(k),serverList);
//                PQ.add(arriveEvent);
//                for(int i=0;i<serverList.size();i++){
//                    if(serverList.get(i).getisAvailable()){
//                        Event serveevent = new serveEvent(customerList.get(k),serverList,serverList.get(i));
//                        PQ.add(serveevent);
//                        Event doneevent = serveevent.execute();
//                        PQ.add(doneevent);
//                        serverList.set(i,new Server(serverList.get(i).getidentifier(),false,true,customerList.get(k).getArrivingTime()+1));
//                        break;
//                    }
//            }
//                for(int p=0;p<serverList.size();p++){
//                    Event wait = new Wait(customerList.get(k),serverList,serverList.get(p));
//                    PQ.add(wait);
//                    Event serveevent = new serveEvent(customerList.get(k),serverList,serverList.get(i));
//                    PQ.add(serveevent);
//                    Event doneevent = serveevent.execute();
//                    PQ.add(doneevent);
//                    serverList.set(i,new Server(serverList.get(i).getidentifier(),false,true,customerList.get(k).getArrivingTime()+1));
//                    break;
//                }
//
//
//        }
//    }
//
//
//
//
//
//
//
//
//    public void simulate(Customer customer, List<Server>serverList){
//        int numServed=0;
//        double startWaitTime = 0;
//        double totalWaitTime = 0;
//        double endWaitTime = 0;
//        boolean isWait = false;
//        double timeStart = 0;
//        double timeEnd = 0;
//        int serverID;
//        int serveEventserverID;
//
//            ArriveEvent arriveEvent = new ArriveEvent(customer,serverList);
//            PQ.add(arriveEvent);
//
//            Event event = arriveEvent.execute();
//            if(event instanceof serveEvent){
//                PQ.add(event);
//                serveEventserverID = ((serveEvent) event).getServer().getidentifier();
//                Event done = event.execute();
//                PQ.add(done);
//                return new
//
//            }
//            if(event instanceof Wait){
//                PQ.add(event);
//                serverID = ((Wait) event).getServer().getidentifier();
//            }
//            if(event instanceof Leave){
//                PQ.add(event);
//            }
//            for(int i=0;i<serverList.size();i++){
//                if(serverList.get(i).getisAvailable()){
//                    //serverList.get(i).geisAvailable = false;
//                    Event serveEvent = arriveEvent.execute();
//                    timeStart = serveEvent.timeGet();
//                    eventPriorityQueue.add(serveevent);
//                    Event doneevent = serveevent.execute();
//                    timeEnd = serveevent.timeGet();
//                    serverList.get(i).getnextAvailableTime() = timeEnd ;
//                    eventPriorityQueue.add(doneevent);
//                    continue;
//                }
//            }
//        }
//
//
//    }
//
//
//}
//public static void main(String[] args) {
//    //System.out.println(new ArriveEvent(new Customer(1, 1.0)).execute(new Shop(List.of(new Server(1,false,true,2.0)))).first());
////    List<Integer> list = Stream.iterate(1, i->i<=9, i->i+1).collect(Collectors.toList());
////    System.out.println(list);
//    Event e = new ArriveEvent(new Customer(1, 1.0));
//    Shop shops = new Shop(List.of(new Server(1, false, false, 1), new Server(2, false, false, 1.0)));
//    Pair<Shop,Event> p = e.execute(shops);
//    System.out.println(p.first());
//    System.out.println(p.second());
//
//        }}
import cs2030.simulator.Simulator;
import cs2030.simulator.RandomGeneratorGetter;
import cs2030.simulator.Pair;

import cs2030.simulator.Simulator;
import cs2030.simulator.RandomGeneratorGetter;
import cs2030.simulator.Pair;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        int baseSeed   ;
        int noOfServer   ;
        int maxQueueLength ;
        int noOfCustomer ;
        double arrivingRate   ;
        double serviceRate  ;
        try{


            baseSeed   = Integer.parseInt(args[0]);
            noOfServer   = Integer.parseInt(args[1]);
            maxQueueLength = Integer.parseInt(args[2]);
            noOfCustomer = Integer.parseInt(args[3]);
            arrivingRate   = Double.parseDouble(args[4]);
            serviceRate         = Double.parseDouble(args[5]);
        }
        catch (Exception ex){
            baseSeed   = Integer.parseInt(args[0]);
            noOfServer   = Integer.parseInt(args[1]);
            noOfCustomer = Integer.parseInt(args[2]);
            arrivingRate   = Double.parseDouble(args[3]);
            serviceRate         = Double.parseDouble(args[4]);
            maxQueueLength = 1;
            }

    //        int baseSeed   = 1;
//        int noOfServer   = 2;
//        int maxQueueLength = 2;
//        int noOfCustomer = 10;
//        double arrivingRate   = 1.0;
//        double serviceRate         = 1.0;
        ArrayList<Double> customerArrivingTimes = new ArrayList<>();
        RandomGeneratorGetter RG = new RandomGeneratorGetter(baseSeed, arrivingRate, serviceRate, 0);

        //List<Integer> list = Stream.iterate(1,i->i<=noOfCustomer,i->i+1).collect(Collectors.toList());
       // list.stream().filter(x->x<=list.size())
                IntStream.range(1,noOfCustomer+1)
                .forEach(x -> {
                    if (x == 1) {
                        customerArrivingTimes.add(0.0);
                    } else {
                        customerArrivingTimes.add(customerArrivingTimes.get(customerArrivingTimes.size() - 1) + RG.genInterArrivalTime());
                    }
                });
        Supplier<Double> RandomServingTime = () -> RG.genServiceTime();
        Simulator simulator = new Simulator(customerArrivingTimes,maxQueueLength, noOfServer, RandomServingTime);
        simulator.start();

    }
}