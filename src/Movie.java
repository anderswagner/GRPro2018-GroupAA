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

    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Title: ");
        res.append(name);
        res.append(", Year: ");
        res.append(year);
        res.append(", Categories: ");
        for(String category : categories){
            res.append(category);
            res.append(", ");
        }
        res.append("Rating: ");
        res.append(rating);
        return "" + res;
    }
}
