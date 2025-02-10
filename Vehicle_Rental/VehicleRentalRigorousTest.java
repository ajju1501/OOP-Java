import java.util.ArrayList;
 import java.util.Arrays;
 public class VehicleRentalRigorousTest {
 public static void main(String[] args) {
 // Create a vehicle and test rental/return functionality
 Vehicle vehicle = new Vehicle(1, "Sedan", 40.0, false);
 System.out.println("Vehicle rented (should be true): " + vehicle.rentVehicle());
 System.out.println("Vehicle rented again (should be false): " + vehicle.rentVehicle());
 vehicle.returnVehicle();
 System.out.println("Vehicle available after return: " + (!vehicle.isRented()));
 // Create rental records
 Rental rental = new Rental(1, vehicle.getVehicleID(), "Anna", 3);
 RentalService service = new RentalService(new ArrayList<>(Arrays.asList(vehicle)));
boolean createRental = service.createRental(rental);
 System.out.println("Rental created: " + createRental);
 // End the rental and check vehicle availability
 boolean endRental = service.endRental(1);
 System.out.println("Rental ended: " + endRental);
 System.out.println("Vehicle available after ending rental: " + (!vehicle.isRented()));
    }
 }