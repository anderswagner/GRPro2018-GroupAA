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
    public List<Series> GetSeries(){
        return null;
    }

    /**
     *
     * @param br BufferedReader which has the filename to already read from
     * @return a List with movie objects
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

                //Try parsing before applying the value
                int year = 0;
                if (tryParseInt(info[1].trim()))
                     year = Integer.parseInt(info[1].trim());

                //Split with ,
                String[] categoriesStrings = info[2].split(",");
                //Convert to ArrayList
                ArrayList<String> categoryList = new ArrayList<>( Arrays.asList(categoriesStrings));

                //Translate from commas to dots
                info[3] = info[3].replaceAll(",",".");

                //Try parsing before applying the value
                float rating = 0;
                if (tryParseFloat(info[3].trim()))
                    rating = Float.parseFloat(info[3].trim());

                //Create new Movie object and apply to list
                movies.add(new Movie(name, categoryList, year, rating));
            }
        } catch (IOException e){
            return null;
        }
        return movies;
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
}
