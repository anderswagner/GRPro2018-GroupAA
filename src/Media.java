import java.util.List;
public abstract class Media{
    protected String name;
    protected List<String> categories;
    protected int year;
    protected float rating;
    
    /**
     *
     * @return the name of the media
     */
    public String getName(){
        return name;
    }

    /**
     *
     * @return all the categories of the show
     */
    public List<String> getCategories(){
        return categories;
    }

    /**
     *
     * @return the year of release
     */
    public int getYear(){
        return year;
    }

    /**
     *
     * @return the IMDB rating of the media
     */
    public float getRating(){
        return rating;
    }

    /**
     * Checks if the media is a specific category
     * @param categoryToCheck the category to check for
     * @return wether or not the media is the specific category being checked for
     */
    public boolean isCategory(String categoryToCheck){
        for(String category : categories){
            if (categoryToCheck.equals(category))
                return true;
        }
        return false;
    }

    /**
     *
     * @return file URL to the image poster of the media
     */
    public String getImageFilename(){
        throw new UnsupportedOperationException("Not implemented yet");
    }
}