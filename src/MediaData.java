import java.util.List;

public class MediaData{
    public List<Media> medias;

    private MediaParser mediaParser;

    public MediaData(){
        mediaParser = new MediaParser();
        medias = mediaParser.GetAllMedias();
    }
}