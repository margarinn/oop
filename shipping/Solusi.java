public abstract class Vehicle {
    public abstract double calcFUelEfficiency();
    public abstract double calcTripDistance();
}

public class Truck extends Vehicle {
    public Truck(double max_load){...}

    public double calcFUelEfficiency() {
        // calculate fuel consumption of a truck with the load

    }
    public double calcTripDistance() {
        // calculate the distance on highway

    }
}