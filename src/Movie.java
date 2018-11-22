import java.util.List;

public class Movie extends Media {

    /**
     *
     * @param name
     * @param categories
     * @param year
     * @param rating
     */
    public Movie(String name, List<String> categories, int year, float rating){
        this.name = name;
        this.categories = categories;
        this.year = year;
        this.rating = rating;
    }
}
