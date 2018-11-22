import java.util.List;

public class Series extends Media {

    protected int yearTo;
    protected int[] seasonEpisodes;

    /**
     * Currently only implements same number of episodes per season!
     * @param name name of the series
     * @param categories categories of media
     * @param year year of release
     * @param rating rating on IMDB
     */
    public Series(String name, List<String> categories, int year, int yearTo, float rating, int[] seasonEpisodes){
        this.name = name;
        this.categories = categories;
        this.year = year;
        this.rating = rating;
        this.yearTo = yearTo;
        this.seasonEpisodes = seasonEpisodes;
    }
}