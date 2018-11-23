public class InvalidMediaException extends RuntimeException {
    private Media invalidMedia;

    public InvalidMediaException(Media media){
        super();
        this.invalidMedia = media;
    }

    public Media getMedia(){
        return invalidMedia;
    }
}
