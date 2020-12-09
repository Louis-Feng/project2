package cs2030.simulator;

import java.util.function.Supplier;

public class Customer {
    private final int id;
    private final double arrivingTime;
    private final Supplier<Double> randomServiceTime;

    public Customer(int id , double arrivingTime,Supplier<Double> randomServiceTime){
        this.arrivingTime = arrivingTime;
        this.id = id;
        this.randomServiceTime = randomServiceTime;
    }
    //default
    public Customer(int id , double arrivingTime){
        this.arrivingTime = arrivingTime;
        this.id = id;
        this.randomServiceTime = () -> 1.0;
    }

    public double getArrivingTime(){return this.arrivingTime;}
    public Customer getCustomer(){return this;}
    public int getid(){return this.id;}
    public Supplier<Double> getRandomServiceTime() {
        return randomServiceTime;
    }
    @Override
    public String toString(){
        return String.format("%d arrives at %.1f",this.id,this.arrivingTime);

    }
}
