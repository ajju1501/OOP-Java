import java.util.ArrayList;


class Transaction{
    int transactionID;
    String accountnumber;
    double amount;
    String transactiontype;

    public Transaction(int transactionID,String accountnumber,double amount,String transactiontype){
        this.transactionID= transactionID;
        this.accountnumber = accountnumber;
        this.amount = amount;
        this.transactiontype = transactiontype;
    }

    public String getTransactionDetails(){
        return "Transaction ID: "+this.transactionID+" Account number: "+this.accountnumber+" Amount: "+this.amount+" Transaction type: "+this.transactiontype;
    }
}

public class BankAccount{
    String accountnumber;
    double balance;
    double limit; 
    ArrayList<Transaction> transacations;

    public BankAccount(String accountnumber,double balance,String s){
        this.accountnumber = accountnumber;
        this.balance = balance;
        this.limit = balance;
        this.transacations = new ArrayList<>();
    }

    public boolean performTransaction(Transaction transaction){
        if(transaction.transactiontype.equals("withdrawal")){
            if((transaction.amount<this.balance)&&(balance>0)){
                transacations.add(transaction);
                this.balance-=transaction.amount;
                // System.out.println("Withdrawal processed: "+transaction.amount);
                // System.out.println("Balance after withdrawal: "+this.balance);
                return true;
            }
        }
        else if(transaction.transactiontype.equals("deposit")){
            if(transaction.amount>this.limit){
                // System.out.println("Invalid withdrawal processed (should be false): " + transaction.amount);
                return false;
            }
            this.balance +=transaction.amount;
            transacations.add(transaction);
            // System.out.println("Deposit processed: "+transaction.amount);
            // System.out.println("Balance after deposit: "+this.balance);
            return true;
        }
        
        return false;
    }

    public double getBalance(){
        return this.balance;
    }
    public ArrayList<Transaction> listTransactions(){
        return this.transacations;
    }
}