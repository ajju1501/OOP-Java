import java.util.ArrayList;


class Card{
    String title;
    String author;
    String subject;

    public Card(String t,String a,String s){
        this.title=t;
        this.author=a;
        this.subject=s;
    }
    public String toString(){
        return "  Title: "+this.title+" | Author: "+this.author+" | Subject: "+this.subject;
    }
}
class CardCatalog{
    ArrayList<Card> card;

    public CardCatalog(){
        this.card =new ArrayList<>();
    }

    public void addACard(Card book){
        card.add(book);
        sorting();
    }
    private void sorting(){
        for (int i = 0; i < this.card.size() - 1; i++) {
            for (int j = 0; j < this.card.size() - i - 1; j++) {
                Card task1 = this.card.get(j);
                Card task2 = this.card.get(j+1);
                if (task1.title.compareTo(task2.title) > 0) {
                    card.set(j, task2);
                    card.set(j + 1, task1);
                }
            }
        }
    }
    public Card getATitle(String title){
        for(Card i:card){
            if(i.title.equalsIgnoreCase(title)){
                return i;
            }
        }
        return null;
    }
    public ArrayList<Card> getAnAuthor(String author){
        ArrayList<Card> list = new ArrayList<>();
        for(Card i:card){
            if(i.author.equalsIgnoreCase(author)){
                list.add(i);
            }
        }
        return list;
    }
    public ArrayList<Card> getSubject(String subject){
        ArrayList<Card> arr = new ArrayList<>();
        for(Card i:card){
            if(i.subject.equalsIgnoreCase(subject)){
               arr.add(i);
            }
        }
        return arr;
    }
    public boolean removeATitle(String title){
        for(Card c:card){
            if(c.title.equalsIgnoreCase(title)){
                card.remove(c);
                return true;
            }
        }
        return false;
    }

    public void printTheCatalog(){
        for(Card i:card){
                System.out.println(i);
        }
        // System.out.println(this.card.toString());
    }
}
