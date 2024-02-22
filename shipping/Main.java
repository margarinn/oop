import java.io.PrintStream;

abstract class Mainn {
    private double maxLoad;

    public Mainn(double maxLoad) {
        this.maxLoad = maxLoad;
    }

    public abstract double calcFuelEfficiency();

    public abstract double calcTripDistance();

    public double getMaxLoad() {
        return maxLoad;
    }
}

class Company {
    private static Company instance;
    private Mainn[] fleet;
    private int fleetSize;

    private Company() {
        fleet = new Mainn[100]; // assuming a maximum of 100 vehicles
        fleetSize = 0;
    }

    public static Company getCompany() {
        if (instance == null) {
            instance = new Company();
        }
        return instance;
    }

    public void addVehicle(Mainn vehicle) {
        if (fleetSize < fleet.length) {
            fleet[fleetSize] = vehicle;
            fleetSize++;
        } else {
            System.out.println("Fleet is full. Cannot add more vehicles.");
        }
    }

    public int getFleetSize() {
        return fleetSize;
    }

    public Mainn getVehicle(int index) {
        if (index >= 0 && index < fleetSize) {
            return fleet[index];
        } else {
            return null;
        }
    }
}

class Truck extends Mainn {
    public Truck(double maxLoad) {
        super(maxLoad);
    }

    public double calcFuelEfficiency() {
        // Implement the calculation for fuel efficiency for a truck
        return 0.0;
    }

    public double calcTripDistance() {
        // Implement the calculation for trip distance for a truck
        return 0.0;
    }
}

class RiverBadge extends Mainn {
    public RiverBadge(double maxLoad) {
        super(maxLoad);
    }

    public double calcFuelEfficiency() {
        // Implement the calculation for fuel efficiency for a RiverBadge
        return 0.0;
    }

    public double calcTripDistance() {
        // Implement the calculation for trip distance for a RiverBadge
        return 0.0;
    }
}

class FuelNeedReport {
    public void generateText(PrintStream output) {
        Company c = Company.getCompany();
        Mainn v;
        double fuel;
        double totalFuel = 0.0;

        for (int i = 0; i < c.getFleetSize(); i++) {
            v = c.getVehicle(i);

            fuel = v.calcFuelEfficiency() * v.calcTripDistance();

            output.println("Vehicle " + v.getClass().getSimpleName() + " needs " + fuel + " liters of fuel.");
            totalFuel += fuel;
        }
        output.println("Total Fuel needs is " + totalFuel + " liters ");
    }
}

public class Main {
    public static void main(String[] args) {
        Company c = Company.getCompany();

        c.addVehicle(new Truck(10000.0));
        c.addVehicle(new Truck(15000.0));
        c.addVehicle(new RiverBadge(500000.0));
        c.addVehicle(new Truck(9500.0));
        c.addVehicle(new RiverBadge(750000.0));

        FuelNeedReport report = new FuelNeedReport();
        report.generateText(System.out);
    }