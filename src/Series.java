import java.util.Calendar;
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

    public int getYearTo(){
        return yearTo;
    }

    public int getRunningYears(){
        if (yearTo != 0)
            return yearTo-year;
        else
            return Calendar.getInstance().get(Calendar.YEAR) - year;
    }

    public int getSeasons(){
        return seasonEpisodes.length;
    }

    public int getTotalEpisodes(){
        int sum = 0;
        for (int i: seasonEpisodes) {
            sum+=i;
        }
        return sum;
    }

    public int getEpisodesInSeason(int season){
        try{
            return seasonEpisodes[season-1];
        } catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Title: ");
        res.append(name);
        res.append(", Years running: ");
        res.append(year);
        res.append("-");
        if (yearTo != 0)
            res.append(yearTo);

        res.append(", Categories: ");
        for(String category : categories){
            res.append(category);
            res.append(", ");
        }
        res.append("Rating: ");
        res.append(rating);
        //Sæsoner her!!
        res.append(", Seasons: ");
        res.append(seasonEpisodes.length);
        res.append(", Total Episodes: ");
        res.append(getTotalEpisodes());
        res.append(", Episodes in seasons: ");
        for (int i = 0; i < seasonEpisodes.length; i++) {
            res.append(i);
            res.append(": ");
            res.append(seasonEpisodes[i]);
            if (i != seasonEpisodes.length)
                res.append(", ");
        }
        return "" + res;
    }
}