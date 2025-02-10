import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        String[] myarray1 = input1.split(" ");
        Hotel he = new Hotel(Integer.parseInt(myarray1[0]));
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            Hotel h = new Hotel();
            String[] myarray = input.split(" ");
            if(myarray.length==1){
                if(myarray[0].equals("print")){
                    he.printReservations();
                }
            }
            else if(myarray.length==2){
                if(myarray[0].equals("build")){
                    he.buildRooms(Integer.parseInt(myarray[1]));
                    System.out.println("Added "+Integer.parseInt(myarray[1])+" more rooms.");
                }
                else if(myarray[0].equals("reserve")){
                    int n=he.reserveRoom(myarray[1]);
                    if(n==-1){
                        System.out.println("Hotel is full. No room available for "+myarray[1]);
                    }else{
                        System.out.println(myarray[1]+" reserved Room "+n);
                    }
                    
                }
                else if(myarray[0].equals("cancel")){
                    he.cancelReservations(myarray[1]);
                    System.out.println("Cancelled reservations for "+myarray[1]);
                }
            }
            else if(myarray.length==3){
                int n = he.reserveRoom(myarray[1],Integer.parseInt(myarray[2]));
                if (n==-1){
                    System.out.println("Room " + myarray[2] + " is already occupied.");
                }
                else{
                    System.out.println(myarray[1]+" reserved Room "+n);
                }
                
            }
        }
        
    }
}
class Reservation{
    String name;
    int roomnumber;

    public Reservation(String n){
        this.name = n;
    }
    public Reservation(String name,int r){
        this.name = name;
        this.roomnumber = r;
    }
    public int setRoom(int newRoom){
        return this.roomnumber =newRoom; 
    }
    public String setName(String newName){
        return this.name = newName;
    }
    public int getRoom(){
        return this.roomnumber;
    }
    public String getName(){
        return this.name;
    }
}
class Hotel{
    ArrayList<Reservation> rooms = new ArrayList<>(5);

    public Hotel(){
        this.rooms = new ArrayList<>(5);
    }
    public Hotel(int numRooms){
        for(int i=0;i<numRooms;i++){
            this.rooms.add(new Reservation(null, i + 1));
        }
    }
    public void buildRooms(int num){
        int n = rooms.size();
        for(int i=n;i<n+num;i++){
            rooms.add(new Reservation(null, i + 1));
        }
    }
    public int reserveRoom(String person){
        for(Reservation r:rooms){
            if(r.name==null){
                r.name = person;
                return r.roomnumber;
            }
        }
        return -1;
    }
    public int reserveRoom(String person, int roomNum){
        for (Reservation r : rooms) {
            if (r.name == null){
                if(r.roomnumber==roomNum){
                    r.setName(person);
                    return roomNum;   
                }
                             
            }
        }
        if (roomNum > rooms.size()|| roomNum <= 0) {
            System.out.println("Invalid room number.");
            return -1;
        }
        // rooms.add(new Reservation(person, roomNum));
        // return roomNum;
        return -1;
    }
    public void cancelReservations(String person){
        for(Reservation r:rooms){
            if(r.name != null && r.name.equals(person)){
                r.name=null;
                return;
            }
        }
    }
    public void printReservations(){
        System.out.println("Current Reservations:");
        int reserve = 0;
        for(Reservation r:rooms){
            if(!(r.name==null)){
                System.out.println(r.name+" - Room "+r.roomnumber);
                reserve++;
            }
        }
        System.out.println("Total Reservations: "+reserve);
        System.out.println("Available Rooms: "+(rooms.size()-reserve));
    }
}
