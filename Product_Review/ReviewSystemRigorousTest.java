 import java.util.ArrayList;
 public class ReviewSystemRigorousTest {
 public static void main(String[] args) {
 // Create reviews for a product
 Review review1 = new Review(1, 101, "Great product!", 5);
 Review review2 = new Review(2, 101, "Not bad", 4);
 Review review3 = new Review(3, 102, "Poor quality", 2);
 // Create product objects
 Product product1 = new Product(101, "Smart Watch", 199.99);
 Product product2 = new Product(102, "Fitness Tracker", 99.99);
 // Create ReviewManager and add reviews
 ReviewManager rm = new ReviewManager(new ArrayList<>());
 rm.addReview(review1);
 rm.addReview(review2);
 rm.addReview(review3);
 // Display review summaries for product1 and product2
 System.out.println("Reviews for product 101:");
 for (Review r : rm.getReviewsByProduct(101)) {
     System.out.println(r.getReviewSummary());
 }
 System.out.println("Reviews for product 102:");
 for (Review r : rm.getReviewsByProduct(102)) {
     System.out.println(r.getReviewSummary());
 }
 // Display product info
 System.out.println("Product 101 info: " + product1.getProductInfo());
 System.out.println("Product 102 info: " + product2.getProductInfo());
    }
 }