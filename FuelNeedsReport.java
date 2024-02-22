public class FuelNeedsReport {
    public void generateText (PrintStream output){
        Company c = Company.getCompany();
        Vehicle v;
        double fuel;
        double total_fuel = 0.0;

        for ( int i = 0; i < c.getFleetSize(); i++ ) {
            v = c.getVehicle(i);

            // Fuel needed for the trip
            fuel = v.calcTripDistance() / v.calcFuelEfficiency();

            output.println("Vehicle " + v.getName() + " needs " + fuel + " liters of fuel.");
            total_fuel += fuel;
        }
        output.println("Total fuel need is " + toal_fuel + " liters.");
    }
}