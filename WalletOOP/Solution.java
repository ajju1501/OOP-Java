import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        wallet w= new wallet();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String input = sc.nextLine();
            String[] myarray = input.split(" ");
            if (myarray.length>1) {
                if(myarray[0].equals("deposit")){
                    System.out.println(w.deposit(Double.parseDouble(myarray[1])));
                    continue;
                        
                }
                else if(myarray[0].equals("withdraw")){
                    System.out.println(w.withdraw(Double.parseDouble(myarray[1])));
                    continue;
                }
                double d = Double.parseDouble(myarray[0]);
                System.out.println(w.initializewallet(d,d,Double.parseDouble(myarray[1])));
            }
            if(myarray.length==1){
                if (myarray[0].equals("getBalance")) {
                    System.out.println("Current Balance: "+w.getBalance());
                    continue;
                }
                else if(myarray[0].equals("getTransactions")){
                    w.display();
                    continue;
                }
            }
        }
    }
}

class Tranaction{
    String type;
    double amount=0.0;
    double fee;

    public Tranaction(String t,double a,double f){
        this.type=t;
        this.amount=a;
        this.fee = f;
    }
}
class wallet{
    double balance;
    ArrayList<Tranaction> transaction;
    double withdrawallimit;
    double withdrawfeeper;

    public String initializewallet(double d,double wdl,double wdf){
        this.withdrawallimit =wdl;
        this.withdrawfeeper=wdf;
        this.transaction = new ArrayList<Tranaction>();
        return "Wallet initialized with withdrawalLimit: "+d+", withdrawalFeePercentage: "+this.withdrawfeeper+"%";
    }

    public String deposit(double amount){
        if(amount<=0){
            return "Deposit of "+amount+" failed. Balance remains: "+this.balance;
        }
        String d = "DEPOSIT";
        this.balance+=amount;
        Tranaction trans = new Tranaction(d,amount,0.0);
        this.transaction.add(trans);
        return "Deposit of "+amount+" successful. Current balance: "+this.balance;
    }
    public String withdraw(double amount){
        if(amount<0 || amount>this.balance || amount>withdrawallimit){
            return "Withdrawal of "+amount+" failed. Balance remains: "+this.balance;
        }
        this.balance-=amount;
        String w = "WITHDRAW";
        double fee = amount*(this.withdrawfeeper/100);
        this.balance-=fee;
        Tranaction trans = new Tranaction(w,amount,fee);
        transaction.add(trans);
        return "Withdrawal of "+amount+" successful with a fee of "+fee+". Current balance: "+this.balance;

    }

    public double getBalance(){
        return this.balance;
    }
    public ArrayList<Tranaction> getTransaction(){
        return transaction;
    }
    public void display(){
        int i=1;
        System.out.println("Transaction History:");
        for (Tranaction t : transaction) {
            System.out.println(i+". "+t.type+" "+t.amount+" (Fee: "+t.fee+")");
            i+=1;
        }
    }
}
