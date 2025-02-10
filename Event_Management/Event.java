import java.util.ArrayList;

public class Event {
    int eventID;
    String eventName;
    String location;
    int capacity;

    public Event(int e,String n,String l,int c){
        this.eventID = e;
        this.eventName = n;
        this.location = l;
        this.capacity = c;
    }

    public boolean isEventFull(){
        int capacity = this.capacity;
        return false;
    }
}

class Participant{
    int participantID;
    String name;
    String email;

    public Participant(int i,String n,String e){
        this.participantID = i;
        this.name = n;
        this.email = e;
    }

    public String getParticipantInfo(){
        return "Participant ID: "+this.participantID+" Name: "+this.name+" Email: "+this.email;
    }
    public String getName(){
        return this.name;
    }
}

class EventManager{
    ArrayList<Event> events;
    ArrayList<Participant> participants;

    public EventManager(ArrayList<Event> e, ArrayList<Participant> p){
        this.events = e;
        this.participants = p;
    }

    public boolean registerParticipant(int eventID,Participant participant){
        for(Event e:events){
            if(e.capacity!=0){
                if(e.eventID == eventID){
                    participants.add(participant);
                    e.capacity-=1;
                    return true;
                }
            }
        }
        return false;
    }
    public  ArrayList<Participant> listParticipants(int eventID){
        ArrayList<Participant> array = new ArrayList<>();
        for(Event e:events){
            if(e.eventID==eventID){
                for(Participant p:participants){
                    array.add(p);
                } 
            }
        }
        return array;
    }
    public ArrayList<Event> getEvents(){
        return events;
    }
}