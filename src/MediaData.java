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
    private MediaParser mediaParser;

    public MediaData(){
        mediaParser = new MediaParser("C:/Users/Vikto/Desktop/AA/GRPro2018-GroupAA/ExternalData/film.txt", "C:/Users/Vikto/Desktop/AA/GRPro2018-GroupAA/ExternalData/serier.txt");
        allMedia = new HashMap<String,Media>();
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
        CreateNewUser("admin","",true);
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

    public void AddToPersonalList(Media media){
        if (currentUser != null)
            currentUser.addToMyList(media);
    }

    public void RemoveFromPersonalList(Media media){
        if (currentUser != null)
            currentUser.removeFromMyList(media);
    }

    public List<Media> getPersonalList(){
        if (currentUser != null){
            return currentUser.getList();
        }
        return null;
    }
}