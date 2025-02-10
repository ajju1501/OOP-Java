import java.util.ArrayList;
public class Solution{
    public static void main(String[] args) {
        
    }
}
class Song {
    String title;
    String artist;
    String album;
    String genre;
    int duration;

    public Song(String t,String a,String al,String g,int d){
        this.title =t;
        this.artist = a;
        this.album = al;
        this.genre =g;
        this.duration =d;
    }
    public String displayDetails(){
        return "Title: "+this.title+", Artist: "+this.artist+", Album: "+this.album+", Genre: "+this.genre+", Duration: "+this.duration;
    }
}

class Playlist{
    String name;
    ArrayList<Song> songs;

    public Playlist(String n){
        this.name =n;
        this.songs = new ArrayList<>();
    }
    public void addSong(Song s){
        songs.add(s);
    }
    public boolean removeSong(String s){
        for(int i=0;i<songs.size();i++){
            String t = songs.get(i).title;
            if(t.equals(s)){
                songs.remove(i);
                return true;
            } 
        }
        return false;
    }
    public ArrayList<Song> getSongs(){
        return songs;
    }
    public ArrayList<Song> filterSongs(String c,String a){
        ArrayList<Song> array = new ArrayList<>();
        if(c.equals("artist")){
            for(Song s:songs){
                if(s.artist.equalsIgnoreCase(a)){
                    array.add(s);
                }
            }
        }
        else if(c.equals("genre")){
            for(Song s:songs){
                if(s.genre.equalsIgnoreCase(a)){
                    array.add(s);
                }
            }
        }
        return array;
    }

    public ArrayList<Song> searchSongs(String g){
        ArrayList<Song> array = new ArrayList<>();
            for(Song s:songs){
                if(s.artist.equalsIgnoreCase(g)){
                    array.add(s);
                }
                else if(s.title.equalsIgnoreCase(g)){
                    array.add(s);
                }
                else if(s.album.equalsIgnoreCase(g)){
                    array.add(s);
                }
                else if(s.genre.equalsIgnoreCase(g)){
                    array.add(s);
                }
            }
        return array;
    }
}
class PlaylistManager{
    ArrayList<Playlist> playlists;

    public PlaylistManager(){
        this.playlists = new ArrayList<>();
    }

    public void createPlaylist(String name){
        Playlist pl = new Playlist(name);
        playlists.add(pl);
    }
    public boolean deletePlaylist(String n){
        for(Playlist p:playlists){
            if(p.name.equals(n)){
                playlists.remove(p);
                return true;
            }
        }
        return false;
    }
    public Playlist getPlaylist(String name){
        for(Playlist p:playlists){
            if(p.name.equals(name)){
                return p;
            }
        }
        return null;
    }
    public ArrayList<String> listPlaylists(){
        ArrayList<String> array = new ArrayList<>();
        for(Playlist p:playlists){
                array.add(p.name);
        }
        return array;
    }
    public ArrayList<Song> crossPlaylistSearch(String key){
        ArrayList<Song> array = new ArrayList<>();
        for(Playlist p:playlists){
            for(Song s:p.songs){
                if(s.album.equals(key)){
                    array.add(s);
                }
                else if(s.title.equals(key)){
                    array.add(s);
                }
                else if(s.genre.equals(key)){
                    array.add(s);
                }
                else if(s.artist.equals(key)){
                    array.add(s);
                }
            }
        }
        return array;
    }
}
