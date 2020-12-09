package cs2030.simulator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Done extends Event{
    //private final Server server;
    public Done(double eventTime,Customer customer, List<Server> servers ,Server server,int serverID) {
        super(eventTime, customer, x->{
            List<Server> newServerList = new ArrayList<>();
            newServerList.addAll(x.getServerList());
            //int modifiedIndex = servers.indexOf(server);
            Server s= new Server(server.getidentifier(),true,server.gethasWaitingCustomer(), server.getnextAvailableTime(),server.getCurrentLength());
            //newServerList.set(modifiedIndex,s );
            List<Server> newnewServerList = newServerList.stream().map(a->{
                if(a.equals(server)){
                    a = s;
                    return a;
                }
                else{
                    return a;
                }
            }).collect(Collectors.toList());
            return Pair.of(new Shop(newnewServerList), null);
        },serverID);
        //this.server = new Server(server.getidentifier(),true,server.gethasWaitingCustomer(), server.getnextAvailableTime());
    }

    @Override
//    public Event execute() {
//        return null;
//    }
//    public double timeGet(){
//        return Math.max(this.server.getnextAvailableTime()+1,super.getCustomer().getArrivingTime()+1);
//    }
    public String toString() {
        return String.format("%.3f %d done serving by server %d",this.getTime(),super.getCustomer().getid(),super.getServerID());
    }
   
}
