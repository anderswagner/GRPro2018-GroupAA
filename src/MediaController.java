import java.util.List;

public class MediaController{
    private MediaData mediaData;
    private View view;

    private static final MediaController controller = new MediaController();

    private MediaController(){
        mediaData = new MediaData();
        //view = new View();
    }

    public static MediaController getController(){
        return controller;
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
        if (view != null)
            return view;
        else{
            view = new View();
            return getView();
        }

    }

    public boolean CreateUser(String username, String password, boolean admin){
        try{
            mediaData.CreateNewUser(username, password, admin);
            return true;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}