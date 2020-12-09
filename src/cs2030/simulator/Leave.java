package cs2030.simulator;

import java.util.List;

public class Leave extends Event {
    public Leave(Customer customer,int serverID) {
        super(customer.getArrivingTime(),customer,x->{
            return Pair.of(x,null);
        },serverID);
    }
//    public double timeGet(){
//        return super.getCustomer().getArrivingTime();
//    }
//
//    @Override
//    public Event execute() {
//        return null;
//    }

    @Override
    public String toString() {
        return String.format("%.3f %d leaves", super.getCustomer().getArrivingTime(), super.getCustomer().getid());

    }
}