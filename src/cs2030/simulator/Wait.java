package cs2030.simulator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Wait extends Event{
    //private final Server server;

    public Wait(Customer customer, List<Server> serverList, Server server,int serverID){
        super(customer.getArrivingTime(),customer,x->{
            List<Server> newServerList = new ArrayList<>();
            newServerList.addAll(x.getServerList());
            double servingTime = customer.getRandomServiceTime().get();
            int currentLength = server.getCurrentLength();
            int newLength = currentLength ;
            Server s;
            if(newLength == 0){
                s= new Server(server.getidentifier(),false,false, server.getnextAvailableTime()+ servingTime,0);
            }
            else{
                s= new Server(server.getidentifier(),false,true, server.getnextAvailableTime()+ servingTime,newLength);
            }
            //newServerList.set(modifiedIndex,s);
            List<Server> newnewServerList = newServerList.stream().map(a->{
                if(a.equals(server)){
                    a = s;
                    return a;
                }
                else{
                    return a;
                }
            }).collect(Collectors.toList());
            return Pair.of(new Shop(newnewServerList),
                    new serveEvent(customer,x.getServerList(),s,server.getnextAvailableTime()
                            ,server.getidentifier()));

            },serverID);

;
    }

    public String toString(){
        return String.format("%.3f %d waits to be served by server %d",super.getCustomer().getArrivingTime(),super.getCustomer().getid(),super.getServerID());
    }



}
//    public Event execute(){
//        //System.out.format("%.3f %d served by %d",this.server.nextAvailableTime,super.customer.id,this.server.identifier);
//        return new serveEvent(this.getCustomer(), getServerList(),this.server);
//    }
////    public double timeGet(){
//        return super.getCustomer().getArrivingTime();
//    }
//    public Server getServer(){
//        return this.server;
//    }