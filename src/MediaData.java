import java.io.IOException;
import java.util.List;

public class MediaData{
    public List<Movie> movies;

    private MediaParser mediaParser;

    public MediaData(){
        mediaParser = new MediaParser("ExternalData/film.txt", "ExternalData/serier.txt");
        try{
            movies = mediaParser.GetMovies();
            System.out.println(movies.get(0));
        } catch (IOException e){
            System.out.println(e.getMessage() + " couldn't parse objects");
        }
    }
}