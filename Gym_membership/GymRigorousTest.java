import java.util.ArrayList;
public class GymRigorousTest {
public static void main(String[] args) {
// Create members and membership plans
Member member1 = new Member(1, "David", "monthly");
Member member2 = new Member(2, "Linda", "yearly");
MembershipPlan plan1 = new MembershipPlan(101, "Standard", 50.0);
MembershipPlan plan2 = new MembershipPlan(102, "Premium", 80.0);
Gym gym = new Gym(new ArrayList<>(), new ArrayList<>());
gym.registerMember(member1);
gym.registerMember(member2);
// Test assigning plans (assume assignPlan uses IDs to match a plan to a member)
boolean assign1 = gym.assignPlan(member1.getMemberID(), plan1.getPlanID());
boolean assign2 = gym.assignPlan(member2.getMemberID(), plan2.getPlanID());
System.out.println("Plan assigned to David: " + assign1);
System.out.println("Plan assigned to Linda: " + assign2);
// Attempt assigning plan to non-existent member
boolean assignInvalid = gym.assignPlan(999, plan1.getPlanID());
System.out.println("Plan assignment to non-existent member: " + assignInvalid);
   }
}