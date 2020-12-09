package cs2030.simulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Shop {
    //field
    private final List<Server> serverList;

    public List<Server> getServerList() {
        return serverList;
    }

    //constructors
    public Shop(List<Server> serverList){
        this.serverList = serverList;
    }
    public Shop(int size){
        //List<Integer> list = Arrays.asList(1,2,3,4,5);
        List<Integer> list = Stream.iterate(1,i->i<=9,i->i+1).collect(Collectors.toList());
        this.serverList = list.stream().filter(x->x<=size)
                .map(x->Server.newServer(x,true, false, 0,0))
                .collect(Collectors.toList());
    }
    public Shop replace(Server newServer){
        Server replacedServer = serverList.stream().findFirst().get();
        int listSize = serverList.size();
        List<Server> newServerList = new ArrayList<>();
        newServerList.addAll(serverList);
        List<Server> returnList = newServerList.stream().map(x->{
            if(x.getidentifier()==replacedServer.getidentifier()){
                return newServer;
            }else{
                return x;
            }
        }).collect(Collectors.toList());
        return new Shop(returnList);
    }
    public Optional<Server> find(Function<Server,Boolean> function){
        Optional<Server> returnServer = this.serverList.stream().filter(x->function.apply(x)).findFirst();
        return returnServer;
    }


    @Override
    public String toString(){
        return this.serverList.toString();
    }
}
