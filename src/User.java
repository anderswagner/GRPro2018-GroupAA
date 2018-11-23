import java.util.ArrayList;
public class User{
    ArrayList<Movie> myMovieList;
    ArrayList<Series> mySeriesList;
    String userName;
    
    public User(String userName){
        if(userName==null){this.userName=userName;}else{
        throw new IllegalArgumentException("Username already taken");}
        myMovieList = new ArrayList<Movie>();
        mySeriesList = new ArrayList<Series>();
    }
    public void addToMyList(Media media){
        if(media instanceof Movie){
            myMovieList.add((Movie)media);}
        else if (media instanceof Series){
            mySeriesList.add((Series)media);
        }
    }
    public void removeFromMyList(Media media){
        if(media instanceof Movie){
            myMovieList.remove((Movie)media);}
        else if (media instanceof Series){
            mySeriesList.remove((Series)media);
        }
    }
    public String getUserName(){return userName;}
}