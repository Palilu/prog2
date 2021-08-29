package ejercicio04;

public class Episode extends Titled {

    private Boolean seen;
    private Integer rating;

    public Episode(String title, String description, Boolean seen, Integer rating) {
        super(title, description);
        this.seen = seen;
        setRating(rating);
    }

    public Boolean getSeen() {
        return seen;
    }

    public Integer getRating() {
        return rating;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
    }

    public void setRating(Integer rating) {
        this.rating = this.seen ? rating : -1;;
    }
}
