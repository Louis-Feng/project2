package cs2030.simulator;

public class RandomGeneratorGetter {
    private final RandomGenerator RG;

    public RandomGeneratorGetter(int baseSeed, double arrivingRate, double serviceRate, double a) {
        this.RG = new RandomGenerator(baseSeed, arrivingRate, serviceRate, a);
    }

    public double genInterArrivalTime() {
        return this.RG.genInterArrivalTime();
    }

    public double genServiceTime() {
        return this.RG.genServiceTime();
    }
}
