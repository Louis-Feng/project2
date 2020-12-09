package cs2030.simulator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new ArriveEvent(new Customer(1, 1.0)).execute(new Shop(List.of(new Server(1,false,true,2.0)))).second());

    }}
