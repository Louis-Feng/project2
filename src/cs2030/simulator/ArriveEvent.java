package cs2030.simulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ArriveEvent extends Event{
    public ArriveEvent(Customer customer,int maxQueueLength) {
        super(customer.getArrivingTime(), customer, x -> {
            if(!x.find(y->y.isAvailable()).equals(Optional.empty())){
                Server server = x.getServerList().stream().filter(z->z.isAvailable()).findFirst().get();
                List<Server> newServerList = new ArrayList<>();
                newServerList.addAll(x.getServerList());
                double servingTime = customer.getRandomServiceTime().get();
                int currentLength = server.getCurrentLength();
                Server s;
                if(currentLength == 0){
                    s= new Server(server.getidentifier(),false,false, customer.getArrivingTime()+ servingTime,0);
                }
                else{
                    s= new Server(server.getidentifier(),false,true, customer.getArrivingTime()+ servingTime,currentLength);
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
                return Pair.of(x,new serveEvent(customer,x.getServerList(),s
                        ,customer.getArrivingTime(),x.getServerList().stream().filter(y->y.isAvailable()).findFirst().get().getidentifier()));
            }
            if(!x.find(z->z.hasVacancy(maxQueueLength)).equals(Optional.empty())){
                int serverID = x.getServerList().stream()
                        .filter(z->z.hasVacancy(maxQueueLength))
                        .findFirst()
                        .get().getidentifier();
                boolean serverIsAvailable = x.getServerList().get(serverID-1).getisAvailable();
                boolean serverHasWaitingCustomer = x.getServerList().get(serverID-1).gethasWaitingCustomer();
                double serverNextAvailableTime = x.getServerList().get(serverID-1).getnextAvailableTime();
                int serverCurrentLength = x.getServerList().get(serverID-1).getCurrentLength();
                Server newServer;
                if(serverHasWaitingCustomer==true){
                    newServer = new Server(serverID,serverIsAvailable,serverHasWaitingCustomer,serverNextAvailableTime,serverCurrentLength+1);
                }
                else{
                    newServer = new Server(serverID,serverIsAvailable,true,serverNextAvailableTime,serverCurrentLength+1);

                }
                List<Server> newServerList = new ArrayList<>();
                newServerList.addAll(x.getServerList());
                List<Server> newnewServerList = newServerList.stream().map(a->{
                    if(a.getidentifier()==serverID){
                        a = newServer;
                        return a;
                    }
                    else{
                        return a;
                    }
                }).collect(Collectors.toList());
                x = x.replace(newServer);
                Event e = new Wait(customer,newnewServerList,newServer,serverID);
                return Pair.of(x,e);
            }

            return Pair.of(x,new Leave(customer,-1));
        },-1);
    }
    public ArriveEvent(Customer customer) {
        super(customer.getArrivingTime(), customer, x -> {
            if(!x.find(y->y.isAvailable()).equals(Optional.empty())){
                Server server = x.getServerList().stream().filter(z->z.isAvailable()).findFirst().get();
                List<Server> newServerList = new ArrayList<>();
                newServerList.addAll(x.getServerList());
                double servingTime = customer.getRandomServiceTime().get();
                int currentLength = server.getCurrentLength();
                Server s;
                if(currentLength == 0){
                    s= new Server(server.getidentifier(),false,false, customer.getArrivingTime()+ servingTime,0);
                }
                else{
                    s= new Server(server.getidentifier(),false,true, customer.getArrivingTime()+ servingTime,currentLength);
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
                return Pair.of(x,new serveEvent(customer,x.getServerList(),s
                        ,customer.getArrivingTime(),x.getServerList().stream().filter(y->y.isAvailable()).findFirst().get().getidentifier()));
            }
            if(!x.find(z->z.hasVacancy(1)).equals(Optional.empty())){
                int serverID = x.getServerList().stream()
                        .filter(z->z.hasVacancy(1))
                        .findFirst()
                        .get().getidentifier();
                boolean serverIsAvailable = x.getServerList().get(serverID-1).getisAvailable();
                boolean serverHasWaitingCustomer = x.getServerList().get(serverID-1).gethasWaitingCustomer();
                double serverNextAvailableTime = x.getServerList().get(serverID-1).getnextAvailableTime();
                int serverCurrentLength = x.getServerList().get(serverID-1).getCurrentLength();
                Server newServer;
                if(serverHasWaitingCustomer==true){
                    newServer = new Server(serverID,serverIsAvailable,serverHasWaitingCustomer,serverNextAvailableTime,serverCurrentLength+1);
                }
                else{
                    newServer = new Server(serverID,serverIsAvailable,serverHasWaitingCustomer,serverNextAvailableTime,serverCurrentLength+1);

                }
                List<Server> newServerList = new ArrayList<>();
                newServerList.addAll(x.getServerList());
                List<Server> newnewServerList = newServerList.stream().map(a->{
                    if(a.getidentifier()==serverID){
                        a = newServer;
                        return a;
                    }
                    else{
                        return a;
                    }
                }).collect(Collectors.toList());
                x = x.replace(newServer);
                Event e = new Wait(customer,newnewServerList,newServer,serverID);
                return Pair.of(x,e);
            }

            return Pair.of(x,new Leave(customer,-1));
        },-1);
    }


    @Override
    public String toString() {
        //return this.customer.arrivingTime + this.customer.id + " arrives";
        return String.format("%.3f %d arrives", super.getCustomer().getArrivingTime(), super.getCustomer().getid());
    }
}






