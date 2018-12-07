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
        mediaParser = new MediaParser("ExternalData/film.txt", "ExternalData/serier.txt");
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

    public ArrayList<ArrayList<Media>> search(String searchString){
        ArrayList<ArrayList<Media>>  mediasWithString = new ArrayList<ArrayList<Media>>();
        mediasWithString.add(searchMediaType(movies, searchString));
        mediasWithString.add(searchMediaType(series, searchString));
        return mediasWithString;
    }

    private <M extends Media> ArrayList<Media> searchMediaType(List<M> toSearchThrough, String searchString){
        ArrayList<Media> SearchedMedia = new ArrayList<>();
        for(M specificMedia : toSearchThrough){
            boolean foundMedia = false;
            for (String category: specificMedia.getCategories()){
                if(category.contains(searchString)){
                    foundMedia = true;
                }
            }
            if(specificMedia.getName().contains(searchString)){
                foundMedia = true;
            }
            if (foundMedia) {
                SearchedMedia.add(specificMedia);}
        }
        return SearchedMedia;
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