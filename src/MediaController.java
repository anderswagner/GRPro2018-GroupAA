import java.util.List;

public class MediaController{
    private MediaData mediaData;

    private static final MediaController controller = new MediaController();

    private MediaController(){
        mediaData = new MediaData();

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
    public List<Media> getPersonalList(){
        return mediaData.getPersonalList();
    }
    public void AddToPersonalList(Media m){
        mediaData.AddToPersonalList(m);
    }
    public void RemoveFromPersonalList(Media m){
        mediaData.RemoveFromPersonalList(m);
    }

    public void getView(){
        new View();
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

    public boolean TryLogin(String username, String password){
        try{
            return mediaData.TryLogin(username, password);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}