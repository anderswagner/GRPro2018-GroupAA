import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class MediaData{
    private List<Movie> movies;
    private List<Series> series;
    private Map<String,Media> allMedia;
    private Map<String,User> users;
    private User currentUser;
    private List<Media> personalList;
    private MediaParser mediaParser;

    public MediaData(){
        mediaParser = new MediaParser("ExternalData/film.txt", "ExternalData/serier.txt");
        allMedia = new HashMap<String,Media>();
        personalList = new ArrayList<Media>();
        try{
            movies = mediaParser.GetMovies();
            series = mediaParser.GetSeries();
        } catch (IOException e){
            System.out.println(e.getMessage() + " couldn't parse objects");
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            for(Media specificMovie : movies){
                allMedia.put(specificMovie.getName(),specificMovie);
            }
            for(Media specificSeries : series) {
                allMedia.put(specificSeries.getName(), specificSeries);
            }
        }
        users = new HashMap();
    }
    
    public List<Media> getPersonalList(){
        return personalList;
    }
    public void AddToPersonalList(Media m){
        personalList.add(m);
    }
    public void RemoveFromPersonalList(Media m){
        personalList.remove(m);
    }
    public List<Movie> getMovies(){

        return movies;
    }

    public List<Series> getSeries(){
        return series;
    }

    public String GetImageString(String mediaName){
        return allMedia.get(mediaName).getImageFilename();
    }

    public void CreateNewUser(String username, String password, Boolean admin) throws IllegalArgumentException{
        if (users.containsKey(username))
            throw new IllegalArgumentException("Username already exists " + username);
        users.put(username, new User(username, password, admin));
        currentUser = users.get(username);
    }

    public boolean TryLogin(String username, String password){
        if (users.containsKey(username)) {
            boolean loggedIn = users.get(username).checkPassword(password);
            if (loggedIn)
                currentUser = users.get(username);
            return loggedIn;
        } else
            throw new IllegalArgumentException("Username doesn't exist " + username);
    }

    public void addToUserList(Media media){
        if (currentUser != null)
            currentUser.addToMyList(media);
    }

    public void removeFromUserList(Media media){
        if (currentUser != null)
            currentUser.removeFromMyList(media);
    }
}