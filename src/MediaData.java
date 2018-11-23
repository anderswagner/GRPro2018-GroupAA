import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        } finally {
            for(Media specificMovie : movies){
                allMedia.put(specificMovie.getName(),specificMovie);
            }
            for(Media specificSeries : series){
                allMedia.put(specificSeries.getName(),specificSeries);
            }
        }
    }

    public String GetImageString(String mediaName){
        return allMedia.get(mediaName).getImageFilename();
    }
}