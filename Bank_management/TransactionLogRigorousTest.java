import java.util.ArrayList;
public class TransactionLogRigorousTest {
public static void main(String[] args) {
// Create a bank account and test transactions
BankAccount account = new BankAccount("ACC001", 1000.0, "checking");
// Create transactions: deposit and withdrawal
Transaction deposit = new Transaction(1, "ACC001", 250.0, "deposit");
Transaction withdrawal = new Transaction(2, "ACC001", 100.0, "withdrawal");
Transaction invalidWithdrawal = new Transaction(3, "ACC001", 2000.0, "withdrawal");
// Process deposit
boolean depositProcessed = account.performTransaction(deposit);
System.out.println("Deposit processed: " + depositProcessed);
System.out.println("Balance after deposit: " + account.getBalance());
// Process valid withdrawal
boolean withdrawalProcessed = account.performTransaction(withdrawal);
System.out.println("Withdrawal processed: " + withdrawalProcessed);
System.out.println("Balance after withdrawal: " + account.getBalance());
// Process invalid withdrawal (should fail)
boolean invalidProcessed = account.performTransaction(invalidWithdrawal);
System.out.println("Invalid withdrawal processed (should be false): " + invalidProcessed);
// List all transactions
System.out.println("Transaction log:");
for (Transaction t : account.listTransactions()) {
    System.out.println(t.getTransactionDetails());
}
   }
}