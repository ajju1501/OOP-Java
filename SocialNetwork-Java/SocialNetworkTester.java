import java.util.*;

// Main class to test all methods
public class SocialNetworkTester {
    public static void main(String[] args) {
        System.out.println("=== Testing Person class ===");
        
        // Create a Person instance.
        Person john = new Person("John", Arrays.asList("The Movie: The Game", "The Legend of Corgi"));
        System.out.println("Initial games for John: " + john.getFavoriteGames());
        System.out.println("John's name: " + john.getName());

        // Test addGame method.
        john.addGame("New Adventure");
        System.out.println("After adding 'New Adventure': " + john.getFavoriteGames());
        // Attempt to add duplicate game.
        john.addGame("New Adventure");
        System.out.println("After attempting to add 'New Adventure' again: " + john.getFavoriteGames());

        // Test removeGame method.
        john.removeGame("The Movie: The Game");
        System.out.println("After removing 'The Movie: The Game': " + john.getFavoriteGames());

        System.out.println("\n=== Testing SocialNetwork class ===");
        SocialNetwork network = new SocialNetwork();

        // Test addUser.
        network.addUser(john);
        Person alice = new Person("Alice",Arrays.asList("Dinosaur Diner", "The Movie: The Game"));
        Person bob = new Person("Bob",Arrays.asList("The Legend of Corgi", "Dinosaur Diner"));
        network.addUser(alice);
        network.addUser(bob);

        System.out.println("Users in network after adding John, Alice, Bob:");
        System.out.println(network);

        // Test getUser method.
        Person retrievedAlice = network.getUser("Alice");
        System.out.println("Retrieved user: " + retrievedAlice);

        // Test updatePerson method.
        network.updatePerson(alice);
        System.out.println("After updating current person to Alice, current person: " + network.getCurrentPerson());

        // Test getUsersWhoLike method.
        List<String> dinosaurFans = network.getUsersWhoLike("Dinosaur Diner");
        System.out.println("Users who like 'Dinosaur Diner': " + dinosaurFans);
        List<String> corgiFans = network.getUsersWhoLike("The Legend of Corgi");
        System.out.println("Users who like 'The Legend of Corgi': " + corgiFans);

        // Test removeUser method.
        network.removeUser("Alice");
        System.out.println("After removing Alice from network:");
        System.out.println(network);

        // Test removeUser on a non-existing user.
        network.removeUser("NonExistent");

        // Test updatePerson with a non-existent user.
        network.updatePerson(alice);

        // Further test: Attempt to add a user that already exists.
        network.addUser(bob);
    }
}
