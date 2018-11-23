import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class MediaData{
    private List<Movie> movies;
    private List<Series> series;
    private Map<String,Media> allMedia;

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
        System.out.println(series.get(4));
    }

    public String GetImageString(String mediaName){
        return allMedia.get(mediaName).getImageFilename();
    }
    public ArrayList<ArrayList<Media>> search(String searchString){
        ArrayList<ArrayList<Media>>  mediasWithString = new ArrayList<ArrayList<Media>>();
        mediasWithString.add(new ArrayList<Media>());
        mediasWithString.add(new ArrayList<Media>());
        for(Media specificMovie : movies){
            boolean foundMovie = false;
            for (String category: specificMovie.getCategories()){
                if(category.contains(searchString)){
                    foundMovie = true;
                }
            }
            if(specificMovie.getName().contains(searchString)){
                foundMovie = true;
            }
            if (foundMovie=true){mediasWithString.get(0).add(specificMovie);}
        }
        for(Media specificSeries : series){
            boolean foundMovie = false;
            for (String category: specificSeries.getCategories()){
                if(category.contains(searchString)){
                    foundMovie = true;
                }
            }
            if(specificSeries.getName().contains(searchString)){
                foundMovie = true;
            }
            if (foundMovie=true){mediasWithString.get(1).add(specificSeries);}
        }
            return mediasWithString;
    }
    
}