import java.util.List;
import java.util.ArrayList;
public abstract class Media{
    protected String name;
    protected List<String> categories;
    protected int year;
    protected float rating;

    public String getName(){
        return name;
    }

    public List<String> getCategories(){
        return categories;
    }

    public int getYear(){
        return year;
    }

    public float getRating(){
        return rating;
    }

    public boolean isCategory(String categoryToCheck){
        for(String category : categories){
            if (categoryToCheck.equals(category))
                return true;
        }
        return false;
    }
}