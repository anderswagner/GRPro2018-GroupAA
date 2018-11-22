import java.util.List;

public class Series extends Media {

    protected int seasons;
    protected int episodesPerSeason;

    /**
     * Currently only implements same number of episodes per season!
     * @param name name of the series
     * @param categories categories of media
     * @param year year of release
     * @param rating rating on IMDB
     * @param seasons seasons of this series
     * @param episodesPerSeason number of episodes for every season
     */
    public Series(String name, List<String> categories, int year, float rating, int seasons, int episodesPerSeason){
        this.name = name;
        this.categories = categories;
        this.year = year;
        this.rating = rating;
        this.seasons = seasons;
        this.episodesPerSeason = episodesPerSeason;
    }
}
