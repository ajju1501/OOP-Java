import java.util.ArrayList;

public class Vehicle{
    int vehicleID;
    String model;
    double rentalRice;
    boolean isRented;

    public Vehicle(int v,String m,double r,boolean i){
        this.vehicleID = v;
        this.model = m;
        this.rentalRice = r;
        this.isRented = i;
    }
    public boolean isRented(){
        return this.isRented;
    }
    public boolean rentVehicle(){
        if(this.isRented==false){
            isRented=true;
            return true;
        }
        return false;
    }
    public void returnVehicle(){
        this.isRented=false;
    }
    public int getVehicleID(){
        return this.vehicleID;
    }
}
class Rental{
    int rentalID;
    int VehicleID;
    String customerName;
    int rentalDuration;

    public Rental(int rid,int vid,String n,int d){
        this.VehicleID = vid;
        this.rentalID = rid;
        this.customerName = n;
        this.rentalDuration = d;
    }

    public String getRentalDetails(){
        return "Vehicle ID: "+this.VehicleID+" CustomerName: "+this.customerName +" Duration: "+this.rentalDuration;
    }
}
class RentalService{
    ArrayList<Vehicle> vehicles;
    ArrayList<Rental> rentals;

    public RentalService(ArrayList<Vehicle> v){
        this.vehicles = v;
        this.rentals = new ArrayList<>();
    }

    public boolean createRental(Rental r){
        for (Vehicle v : vehicles) {
            if((v.vehicleID==r.VehicleID)){
                rentals.add(r);
                v.isRented=true;
                return true;
            }
        }
        return false;
    }
    public boolean endRental(int i){
        for (Rental rental : rentals) {
            if(rental.rentalID==i){
                int vid = i;
                for(Vehicle v:vehicles){
                    if(v.vehicleID==vid){
                        v.returnVehicle();
                        return true;
                    }
                }
            }
        }
        return false;
    }
}