package cs2030.simulator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class serveEvent extends Event {
    //private final Server returnServer;
    //private final double servingTime;
    //private final double serveTime;
    public serveEvent(Customer customer, List<Server> servers, Server server,double serveTime,int serverID) {
        super(serveTime, customer, x->{
            List<Server> newServerList = new ArrayList<>();
            newServerList.addAll(x.getServerList());
            //int modifiedIndex = servers.indexOf(server);
            Server s;
            int currentLength = server.getCurrentLength();
//            int newLength = currentLength - 1;
//            if(newLength == 0){
//                s= new Server(server.getidentifier(),false,server.gethasWaitingCustomer(), server.getnextAvailableTime(),0);
//            }
//            else{
//                s= new Server(server.getidentifier(),false,server.gethasWaitingCustomer(), server.getnextAvailableTime(),newLength);
//            }
            if(currentLength>0){
                int newLength = currentLength - 1;
                s= new Server(server.getidentifier(),false,server.gethasWaitingCustomer(), server.getnextAvailableTime(),newLength);
            }
            else{
                s= new Server(server.getidentifier(),false,server.gethasWaitingCustomer(), server.getnextAvailableTime(),0);
            }

            //Server s= new Server(server.getidentifier(),false,server.gethasWaitingCustomer(), server.getnextAvailableTime(),server.getCurrentLength());
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
            return Pair.of(new Shop(newnewServerList),
                    new Done(server.getnextAvailableTime(),customer,x.getServerList(),
                            s,
                            server.getidentifier()));
        },serverID);
        //this.returnServer = new Server(server.getidentifier(),false,false, this.getTime()+servingTime);

    }

//    public Event execute(){
//       // System.out.format("%.3f %d done serving by %d",super.customer.arrivingTime + 1,super.customer.id,this.server.identifier);
//        return new Done(super.getCustomer(),getServerList(),this.server);
//
//    }
//    public Server getServer(){
//        return this.server;
//    }
//    public double timeGet(){
//        return Math.max(this.server.getnextAvailableTime(),super.getCustomer().getArrivingTime());
//    }
    public String toString(){
        // qn
        return String.format("%.3f %d served by server %d",this.getTime(),super.getCustomer().getid(),super.getServerID());
    }

}
