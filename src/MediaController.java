public class MediaController{
    private MediaData mediaData;
    private View view;
    public MediaController(){
        view = new View();
        mediaData = new MediaData();
    }

    public MediaData getData(){
        return mediaData;
    }

    public View getView(){
        return view;
    }
}