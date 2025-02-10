import java.util.ArrayList;

public class Review {
    int reviewID;
    int productID;
    String reviewText;
    int rating;

    public Review(int r,int p,String review,int rating){
        this.reviewID =r;
        this.productID =p;
        this.reviewText = review;
        this.rating = rating;
    }

    public String getReviewSummary(){
        return this.reviewText + " Rating: "+this.rating;
    }
}
class Product{
    int productID;
    String name;
    double price;

    public Product(int p,String n,double price){
        this.productID = p;
        this.name = n;
        this.price = price;
    }

    public String getProductInfo(){
        return "Name: "+this.name+"Price: "+this.price;
    }
}
class ReviewManager{
    ArrayList<Review> reviews;

    public ReviewManager(ArrayList<Review> review){
        this.reviews = new ArrayList<>();
    }

    public void addReview(Review r){
        reviews.add(r);
    }

    public ArrayList<Review> getReviewsByProduct(int p){
        ArrayList<Review> reviewlist = new ArrayList<>();
        for (Review r : reviews) {
            if(r.productID==p){
                reviewlist.add(r);
            }
        }
        return reviewlist;
    }
    
}