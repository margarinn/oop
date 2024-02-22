public class ShippingMain{
    public static void main(String[] args){
        Company c = Company.getCompany();

        // populating the company with fleet and vehicles
        c.addVehicle( new Truck(10000.0) );
        c.addVehicle( new Truck(15000.0) );
        c.addVehicle( new RiverBadge(500000.0) );
        c.addVehicle( new Truck(9500.0) );
        c.addVehicle( new RiverBadge(750000.0) );

        FuelNeedsReport report = new FuelNeedsReport();
        report.generateText(System.out);
    }
}