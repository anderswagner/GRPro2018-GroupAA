import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class MediaParser {
    private String moviesFileName;
    private String seriesFileName;

    public MediaParser(String moviesFileName, String seriesFileName){
        this.moviesFileName = moviesFileName;
        this.seriesFileName = seriesFileName;
    }

    /**
     *
     * @return an arrayList of all possible medias
     */
    public List<Media> GetAllMedias() throws IOException{
        return null;
    }

    /**
     *
     * @return an arrayList of all the movies parsed
     */
    public List<Movie> GetMovies() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(moviesFileName));
        List<Movie> movies = readMovies(br);
        br.close();
        return movies;
    }

    /**
     *
     * @return an arrayList of all the series parsed
     */
    public List<Series> GetSeries() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(seriesFileName));
        List<Series> series = readSeries(br);
        br.close();
        return series;
    }

    /**
     *
     * @param br BufferedReader which has the filename to already read from
     * @return a List with movies from the file
     */
    private List<Movie> readMovies(BufferedReader br){
        List<Movie> movies = new ArrayList<>();
        try{
            String line = br.readLine();
            while(br.ready() && line != null){
                line = br.readLine();

                //Split lines with ;
                String[] info = line.split(";");

                //Each line is name;year;category1;category2;...;rating;
                String name = info[0].trim();

                int year = getParsedInt(info[1]);

                //Get the categories from a custom string
                ArrayList<String> categoryList = getCategories(info[2]);

                float rating = getParsedFloat(info[3]);

                //Create new Movie object and apply to list
                movies.add(new Movie(name, categoryList, year, rating));
            }
        } catch (IOException e){
            return null;
        }
        return movies;
    }

    /**
     *
     * @param br BufferedRead which has the filename to read from
     * @return A list with series from the file
     */
    private List<Series> readSeries(BufferedReader br){
        List<Series> series = new ArrayList<>();
        try{
            String line = br.readLine();
            while (br.ready() && line != null){
                line = br.readLine();

                String[] info = line.split(";");

                String name = info[0].trim();

                String[] years = info[1].split("-");
                int yearFrom = getParsedInt(years[0]);
                int yearTo = 0;
                if (years.length > 1)yearTo = getParsedInt(years[1]);

                ArrayList<String> categoryList = getCategories(info[2]);

                float rating = getParsedFloat(info[3]);

                ArrayList<Integer> seasons = new ArrayList<Integer>();
                for (int restStrings = 4; restStrings < info.length; restStrings++) {
                    String[] splitNumbers = info[restStrings].split(",\\-");
                    for (int numbers = 0; numbers < splitNumbers.length/2; numbers++) {
                        seasons.add(getParsedInt(splitNumbers[++numbers]));
                    }
                }

                series.add(new Series(name,categoryList,yearFrom,yearTo,rating,convertIntegers(seasons)));
            }
        } catch (IOException e){
            return null;
        }
        return series;
    }

    private ArrayList<String> getCategories(String unSplitString){
        //Split with ,
        String[] categoriesStrings = unSplitString.split(",");
        //Convert to ArrayList
        ArrayList<String> categoryList = new ArrayList<>( Arrays.asList(categoriesStrings));
        return categoryList;
    }

    private int getParsedInt(String value){
        int parsedInt = 0;
        if (tryParseInt(value.trim()))
            parsedInt = Integer.parseInt(value.trim());
        return parsedInt;
    }

    private float getParsedFloat(String value){
        value = value.replaceAll(",",".");
        float parsedFloat = 0;
        if (tryParseFloat(value.trim()))
            parsedFloat = Float.parseFloat(value.trim());
        return parsedFloat;
    }

    private boolean tryParseInt(String value){
        try{
            Integer.parseInt(value);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    private boolean tryParseFloat(String value){
        try{
            Float.parseFloat(value);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public static int[] convertIntegers(List<Integer> integers){
        int[] returnValue = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < returnValue.length; i++) {
            returnValue[i] = iterator.next();
        }
        return returnValue;
    }
}
