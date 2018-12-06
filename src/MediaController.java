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

    public List<Media> getMovies(){
        return mediaData.getMovies();
    }

    public List<Media> getSeries(){
        return mediaData.getSeries();
    }

    public View getView(){
        return view;
    }
}