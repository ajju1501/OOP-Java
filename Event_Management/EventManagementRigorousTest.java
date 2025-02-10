import java.util.ArrayList;
public class EventManagementRigorousTest {
public static void main(String[] args) {
// Create an event with capacity 2
Event event = new Event(1, "Tech Conference", "Hall A", 2);
// Create participants
Participant participant1 = new Participant(101, "Mike", "mike@example.com");
Participant participant2 = new Participant(102, "Anna", "anna@example.com");
Participant participant3 = new Participant(103, "John", "john@example.com");
EventManager em = new EventManager(new ArrayList<>(), new ArrayList<>());
em.getEvents().add(event);
// Register participants (first two should succeed; third should fail if capacity reached)
boolean reg1 = em.registerParticipant(1, participant1);
boolean reg2 = em.registerParticipant(1, participant2);
boolean reg3 = em.registerParticipant(1, participant3);
System.out.println("Participant 101 registered: " + reg1);
System.out.println("Participant 102 registered: " + reg2);
System.out.println("Participant 103 registered (should fail): " + reg3);
// List participants
System.out.println("Participants for event 1:");
for (Participant p : em.listParticipants(1)) {
    System.out.println(p.getName());
}
   }
}