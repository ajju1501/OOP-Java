import java.util.ArrayList;
import java.util.List;

public class Solution{
    public static void main(String[] args) {
        
    }
}
class Person{
    String name;
    List<String> games;

    public Person(String name, List<String>games ){
        this.name=name;
        this.games = new ArrayList<>(games);
    }

    public void addGame(String game){
        if (games.contains(game)) {
            return;
        }
        games.add(game);
    }
    public void removeGame(String game){
        for (String g: games) {
            if(g.equals(game)){
                games.remove(g);
                return;
            }
        }
    }
    public List<String> getFavoriteGames(){
        return this.games;
    }
    public String getName(){
        return this.name;
    }
    public String toString(){
        return "Person{name='"+this.name+"', games="+this.games+"}";
    }
}
class SocialNetwork{
    Person person;
    ArrayList<Person> users;

    public SocialNetwork(){
        this.users = new ArrayList<>();
    }

    public void addUser(Person user){
        if (users.contains(user)) {
            System.out.println("User with name "+user.name.substring(0, 1).toUpperCase() + user.name.substring(1)+" already exists.");
            return;
        }
        users.add(user);
    }
    public void removeUser(String name){
        for (Person p : users) {
            if(p.name.equals(name)){
                users.remove(p);
                return;
            }
        }
        System.out.println("User with name NonExistent not found.");
    }
    public Person getUser(String name){
        for (Person person : users) {
            if(person.name.equals(name)){
                return person;
            }
        }
        return null;

    }
    public void updatePerson(Person person){
        if(users.contains(person)){
            this.person = person;
            return;
        }
        System.out.println("User "+person.name.substring(0, 1).toUpperCase() + person.name.substring(1)+" is not in the network.");
    }
    public Person getCurrentPerson(){
        return this.person;
    }
    public ArrayList<String> getUsersWhoLike(String game){
        ArrayList<String> array = new ArrayList<>();
        for (Person p : users) {
            if (p.games.contains(game)) {
                array.add(p.name);
            }
        }
        return array;
    }
    public String toString(){
        String res = "SocialNetwork{current person=null, users=[";
        for (Person person : users) {
            res+=person+", ";
        }
        return res.substring(0,res.length()-2)+"]}";
    }
}