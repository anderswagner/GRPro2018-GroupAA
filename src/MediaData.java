import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class MediaData{
    private List<Movie> movies;
    private List<Series> series;
    private Map<String,Media> allMedia;
    private List<User> users;

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
        users = new ArrayList<User>();
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

    private void CreateNewUser(String username, String password, Boolean admin){
        for (User user: users) {
            //if (user.userName.equals(username))

        }
    }
}