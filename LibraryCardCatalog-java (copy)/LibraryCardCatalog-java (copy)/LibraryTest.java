
import java.util.ArrayList;


/**
 * Test class to manually test every method of CardCatalog.
 */
public class LibraryTest {

    public static void main(String[] args) {
        System.out.println("==================== Testing addACard() ====================");
        testAddACard();

        System.out.println("\n==================== Testing getATitle() ====================");
        testGetATitle();

        System.out.println("\n==================== Testing getAnAuthor() ====================");
        testGetAnAuthor();

        System.out.println("\n==================== Testing getSubject() ====================");
        testGetSubject();

        System.out.println("\n==================== Testing removeATitle() ====================");
        testRemoveATitle();

        System.out.println("\n==================== Testing printTheCatalog() ====================");
        testPrintTheCatalog();
    }

    // --------------------- Test Cases for addACard() ---------------------
    public static void testAddACard() {
        // Test Case 1: Add to an empty catalog.
        CardCatalog catalog1 = new CardCatalog();
        catalog1.addACard(new Card("Animal Farm", "George Orwell", "Dystopia"));
        System.out.println("Test Case 1: Expected catalog order:");
        System.out.println("  Title: Animal Farm | Author: George Orwell | Subject: Dystopia");
        System.out.println("Actual catalog:");
        catalog1.printTheCatalog();

        // Test Case 2: Add a card that should appear at the beginning.
        CardCatalog catalog2 = new CardCatalog();
        catalog2.addACard(new Card("Moby Dick", "Herman Melville", "Adventure"));
        catalog2.addACard(new Card("A Tale of Two Cities", "Charles Dickens", "Historical"));
        System.out.println("\nTest Case 2: Expected catalog order:");
        System.out.println("  Title: A Tale of Two Cities | Author: Charles Dickens | Subject: Historical");
        System.out.println("  Title: Moby Dick | Author: Herman Melville | Subject: Adventure");
        System.out.println("Actual catalog:");
        catalog2.printTheCatalog();

        // Test Case 3: Add a card that should appear in the middle.
        CardCatalog catalog3 = new CardCatalog();
        catalog3.addACard(new Card("A Farewell to Arms", "Ernest Hemingway", "War"));
        catalog3.addACard(new Card("The Great Gatsby", "F. Scott Fitzgerald", "Drama"));
        catalog3.addACard(new Card("Brave New World", "Aldous Huxley", "Dystopia"));
        System.out.println("\nTest Case 3: Expected catalog order:");
        System.out.println("  Title: A Farewell to Arms | Author: Ernest Hemingway | Subject: War");
        System.out.println("  Title: Brave New World | Author: Aldous Huxley | Subject: Dystopia");
        System.out.println("  Title: The Great Gatsby | Author: F. Scott Fitzgerald | Subject: Drama");
        System.out.println("Actual catalog:");
        catalog3.printTheCatalog();

        // Test Case 4: Add a card with a title that matches (case-insensitive).
        CardCatalog catalog4 = new CardCatalog();
        catalog4.addACard(new Card("Hamlet", "William Shakespeare", "Tragedy"));
        catalog4.addACard(new Card("hamlet", "Someone Else", "Drama"));
        System.out.println("\nTest Case 4: Expected catalog (both entries, order may vary but adjacent):");
        System.out.println("  Title: Hamlet | Author: William Shakespeare | Subject: Tragedy");
        System.out.println("  Title: hamlet | Author: Someone Else | Subject: Drama");
        System.out.println("Actual catalog:");
        catalog4.printTheCatalog();
    }

    // --------------------- Test Cases for getATitle() ---------------------
    public static void testGetATitle() {
        // Test Case 1: Card exists with exact title.
        CardCatalog catalog1 = new CardCatalog();
        catalog1.addACard(new Card("1984", "George Orwell", "Dystopia"));
        System.out.println("Test Case 1: Searching for title \"1984\"");
        Card found = catalog1.getATitle("1984");
        System.out.println("Expected: Title: 1984 | Author: George Orwell | Subject: Dystopia");
        System.out.println("Actual: " + (found != null ? found : "Not Found"));

        // Test Case 2: Card does not exist.
        CardCatalog catalog2 = new CardCatalog();
        catalog2.addACard(new Card("To Kill a Mockingbird", "Harper Lee", "Drama"));
        System.out.println("\nTest Case 2: Searching for title \"The Catcher in the Rye\"");
        found = catalog2.getATitle("The Catcher in the Rye");
        System.out.println("Expected: Not Found");
        System.out.println("Actual: " + (found != null ? found : "Not Found"));

        // Test Case 3: Case-insensitive matching.
        CardCatalog catalog3 = new CardCatalog();
        catalog3.addACard(new Card("The Hobbit", "J.R.R. Tolkien", "Fantasy"));
        System.out.println("\nTest Case 3: Searching for title \"the hobbit\" (lowercase)");
        found = catalog3.getATitle("the hobbit");
        System.out.println("Expected: Title: The Hobbit | Author: J.R.R. Tolkien | Subject: Fantasy");
        System.out.println("Actual: " + (found != null ? found : "Not Found"));

        // Test Case 4: Multiple cards with the same title.
        CardCatalog catalog4 = new CardCatalog();
        catalog4.addACard(new Card("Dune", "Frank Herbert", "Science Fiction"));
        catalog4.addACard(new Card("Dune", "Another Author", "Different Subject"));
        System.out.println("\nTest Case 4: Searching for title \"Dune\" with multiple entries (should return first)");
        found = catalog4.getATitle("Dune");
        System.out.println("Expected: First inserted Dune card (Frank Herbert)");
        System.out.println("Actual: " + (found != null ? found : "Not Found"));
    }

    // --------------------- Test Cases for getAnAuthor() ---------------------
    public static void testGetAnAuthor() {
        // Test Case 1: Single card by author.
        CardCatalog catalog1 = new CardCatalog();
        catalog1.addACard(new Card("Pride and Prejudice", "Jane Austen", "Romance"));
        System.out.println("Test Case 1: Searching for author \"Jane Austen\"");
        ArrayList<Card> authorCards = catalog1.getAnAuthor("Jane Austen");
        System.out.println("Expected: 1 card - Pride and Prejudice");
        System.out.println("Actual:");
        for (Card c : authorCards) {
            System.out.println(c);
        }

        // Test Case 2: Multiple cards by same author.
        CardCatalog catalog2 = new CardCatalog();
        catalog2.addACard(new Card("Emma", "Jane Austen", "Romance"));
        catalog2.addACard(new Card("Sense and Sensibility", "Jane Austen", "Romance"));
        System.out.println("\nTest Case 2: Searching for author \"Jane Austen\" (multiple entries)");
        authorCards = catalog2.getAnAuthor("Jane Austen");
        System.out.println("Expected: 2 cards - Emma and Sense and Sensibility");
        System.out.println("Actual:");
        for (Card c : authorCards) {
            System.out.println(c);
        }

        // Test Case 3: No cards by the given author.
        CardCatalog catalog3 = new CardCatalog();
        catalog3.addACard(new Card("The Odyssey", "Homer", "Epic"));
        System.out.println("\nTest Case 3: Searching for author \"Jane Austen\" when none exist");
        authorCards = catalog3.getAnAuthor("Jane Austen");
        System.out.println("Expected: Empty list");
        System.out.println("Actual: " + (authorCards.isEmpty() ? "Empty list" : authorCards));

        // Test Case 4: Case-insensitive author matching.
        CardCatalog catalog4 = new CardCatalog();
        catalog4.addACard(new Card("Great Expectations", "Charles Dickens", "Fiction"));
        System.out.println("\nTest Case 4: Searching for author \"charles dickens\" (lowercase)");
        authorCards = catalog4.getAnAuthor("charles dickens");
        System.out.println("Expected: 1 card - Great Expectations");
        System.out.println("Actual:");
        for (Card c : authorCards) {
            System.out.println(c);
        }
    }

    // --------------------- Test Cases for getSubject() ---------------------
    public static void testGetSubject() {
        // Test Case 1: Single card by subject.
        CardCatalog catalog1 = new CardCatalog();
        catalog1.addACard(new Card("The Shining", "Stephen King", "Horror"));
        System.out.println("Test Case 1: Searching for subject \"Horror\"");
        ArrayList<Card> subjectCards = catalog1.getSubject("Horror");
        System.out.println("Expected: 1 card - The Shining");
        System.out.println("Actual:");
        for (Card c : subjectCards) {
            System.out.println(c);
        }

        // Test Case 2: Multiple cards on the same subject.
        CardCatalog catalog2 = new CardCatalog();
        catalog2.addACard(new Card("It", "Stephen King", "Horror"));
        catalog2.addACard(new Card("Carrie", "Stephen King", "Horror"));
        System.out.println("\nTest Case 2: Searching for subject \"Horror\" (multiple entries)");
        subjectCards = catalog2.getSubject("Horror");
        System.out.println("Expected: 2 cards - It and Carrie");
        System.out.println("Actual:");
        for (Card c : subjectCards) {
            System.out.println(c);
        }

        // Test Case 3: No cards for a given subject.
        CardCatalog catalog3 = new CardCatalog();
        catalog3.addACard(new Card("The Great Gatsby", "F. Scott Fitzgerald", "Drama"));
        System.out.println("\nTest Case 3: Searching for subject \"Science Fiction\" when none exist");
        subjectCards = catalog3.getSubject("Science Fiction");
        System.out.println("Expected: Empty list");
        System.out.println("Actual: " + (subjectCards.isEmpty() ? "Empty list" : subjectCards));

        // Test Case 4: Case-insensitive subject matching.
        CardCatalog catalog4 = new CardCatalog();
        catalog4.addACard(new Card("Foundation", "Isaac Asimov", "Science Fiction"));
        System.out.println("\nTest Case 4: Searching for subject \"science fiction\" (lowercase)");
        subjectCards = catalog4.getSubject("science fiction");
        System.out.println("Expected: 1 card - Foundation");
        System.out.println("Actual:");
        for (Card c : subjectCards) {
            System.out.println(c);
        }
    }

    // --------------------- Test Cases for removeATitle() ---------------------
    public static void testRemoveATitle() {
        // Test Case 1: Remove an existing card.
        CardCatalog catalog1 = new CardCatalog();
        catalog1.addACard(new Card("The Catcher in the Rye", "J.D. Salinger", "Fiction"));
        System.out.println("Test Case 1: Removing title \"The Catcher in the Rye\"");
        boolean removed = catalog1.removeATitle("The Catcher in the Rye");
        System.out.println("Expected: true; catalog should now be empty.");
        System.out.println("Actual: " + removed);
        System.out.println("Catalog after removal:");
        catalog1.printTheCatalog();

        // Test Case 2: Remove when title does not exist.
        CardCatalog catalog2 = new CardCatalog();
        catalog2.addACard(new Card("Lord of the Flies", "William Golding", "Allegory"));
        System.out.println("\nTest Case 2: Removing title \"Animal Farm\" (does not exist)");
        removed = catalog2.removeATitle("Animal Farm");
        System.out.println("Expected: false; catalog should remain unchanged.");
        System.out.println("Actual: " + removed);
        System.out.println("Catalog after attempted removal:");
        catalog2.printTheCatalog();

        // Test Case 3: Case-insensitive removal.
        CardCatalog catalog3 = new CardCatalog();
        catalog3.addACard(new Card("Frankenstein", "Mary Shelley", "Horror"));
        System.out.println("\nTest Case 3: Removing title \"frankenstein\" (lowercase)");
        removed = catalog3.removeATitle("frankenstein");
        System.out.println("Expected: true; catalog should now be empty.");
        System.out.println("Actual: " + removed);
        System.out.println("Catalog after removal:");
        catalog3.printTheCatalog();

        // Test Case 4: Remove when multiple cards have the same title.
        CardCatalog catalog4 = new CardCatalog();
        catalog4.addACard(new Card("Dune", "Frank Herbert", "Science Fiction"));
        catalog4.addACard(new Card("Dune", "Another Author", "Different Genre"));
        System.out.println("\nTest Case 4: Removing title \"Dune\" when multiple exist");
        removed = catalog4.removeATitle("Dune");
        System.out.println("Expected: true; one Dune should be removed, leaving one remaining.");
        System.out.println("Actual: " + removed);
        System.out.println("Catalog after removal:");
        catalog4.printTheCatalog();
    }

    // --------------------- Test Cases for printTheCatalog() ---------------------
    public static void testPrintTheCatalog() {
        // Test Case 1: Print an empty catalog.
        CardCatalog catalog1 = new CardCatalog();
        System.out.println("Test Case 1: Printing an empty catalog");
        System.out.println("Expected: \"The catalog is empty.\"");
        System.out.println("Actual:");
        catalog1.printTheCatalog();

        // Test Case 2: Print a catalog with a single card.
        CardCatalog catalog2 = new CardCatalog();
        catalog2.addACard(new Card("Fahrenheit 451", "Ray Bradbury", "Dystopia"));
        System.out.println("\nTest Case 2: Printing a catalog with one card");
        System.out.println("Expected: One card printed - Fahrenheit 451");
        System.out.println("Actual:");
        catalog2.printTheCatalog();

        // Test Case 3: Print a catalog with multiple cards in sorted order.
        CardCatalog catalog3 = new CardCatalog();
        catalog3.addACard(new Card("Brave New World", "Aldous Huxley", "Dystopia"));
        catalog3.addACard(new Card("1984", "George Orwell", "Dystopia"));
        catalog3.addACard(new Card("Animal Farm", "George Orwell", "Political Satire"));
        System.out.println("\nTest Case 3: Printing a catalog with multiple cards (sorted order)");
        System.out.println("Expected order (alphabetical by title):");
        System.out.println("  Title: 1984 ...");
        System.out.println("  Title: Animal Farm ...");
        System.out.println("  Title: Brave New World ...");
        System.out.println("Actual:");
        catalog3.printTheCatalog();

        // Test Case 4: Print after removing a card.
        CardCatalog catalog4 = new CardCatalog();
        catalog4.addACard(new Card("The Hobbit", "J.R.R. Tolkien", "Fantasy"));
        catalog4.addACard(new Card("The Lord of the Rings", "J.R.R. Tolkien", "Fantasy"));
        System.out.println("\nTest Case 4: Removing \"The Hobbit\" then printing catalog");
        boolean removed = catalog4.removeATitle("The Hobbit");
        System.out.println("Removal expected: true. Actual: " + removed);
        System.out.println("Expected catalog:");
        System.out.println("  Title: The Lord of the Rings | Author: J.R.R. Tolkien | Subject: Fantasy");
        System.out.println("Actual catalog:");
        catalog4.printTheCatalog();
    }
}

