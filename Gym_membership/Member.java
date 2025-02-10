import java.util.ArrayList;

public class Member {
    int memberID;
    String name;
    String membership;

    public Member(int mmid,String n,String m){
        this.memberID=mmid;
        this.name=n;
        this.membership=m;
    }

    public String getMemberInfo(){
        return "MemberID: "+this.memberID+" Name: "+this.name+" Membership: "+this.membership;
    }
    public int getMemberID(){
        return this.memberID;
    }
}
class MembershipPlan{
    int planID;
    String planName;
    double fee;

    public MembershipPlan(int p,String pn,double fee){
        this.planID=p;
        this.planName=pn;
        this.fee = fee;

    }
    public String getPlanDetails(){
        return "Plan Name: "+this.planName+"Fee"+this.fee;
    }
    public int getPlanID(){
        return this.planID;
    }
}

class Gym{
    ArrayList<Member> members;
    ArrayList<MembershipPlan> plans;

    public Gym(ArrayList<Member> m,ArrayList<MembershipPlan> p){
        this.members = new ArrayList<>();
        this.plans = new ArrayList<>();
    }
    public void registerMember(Member m){
        members.add(m);
    }

    public boolean assignPlan(int mid,int pid){
        for(Member m:members){
            for(MembershipPlan p:plans){
                m.memberID=p.planID;
                return true;
            }
            
        }
        return false;
    }
}
