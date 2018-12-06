import java.util.List;

public class MediaController{
    private MediaData mediaData;
    private View view;
    public MediaController(){
        view = new View();
        mediaData = new MediaData();
    }

    public MediaData getData(){
        return mediaData;
    }

    public List<Movie> getMovies(){
        return mediaData.getMovies();
    }

    public List<Series> getSeries(){
        return mediaData.getSeries();
    }

    public View getView(){
        return view;
    }
}