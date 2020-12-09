package cs2030.simulator;

import java.util.List;
import java.util.function.Function;

public abstract class Event {
    private final double time;
    private final Customer customer ;
    private final Function<Shop,Pair<Shop,Event>> func;
    private final int serverID;

    public int getServerID() {
        return serverID;
    }


    public Event(double time, Customer customer,  Function<Shop,Pair<Shop,Event>> func,int serverID) {
        this.customer = customer;
        this.time = time;
        this.func = func;
        this.serverID = serverID;
    }
    public  Customer getCustomer(){return this.customer;}
    public Function<Shop, Pair<Shop, Event>> getFunction() {
        return func;
    }
    public double getTime() {
        return time;
    }

    public Function<Shop, Pair<Shop, Event>> getFunc() {
        return func;
    }

    final Pair<Shop, Event> execute(Shop shop) { // declared final to avoid overriding
        return this.func.apply(shop); // func is the Function property
    }
}
