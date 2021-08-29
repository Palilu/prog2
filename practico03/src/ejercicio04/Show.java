package ejercicio04;

import java.util.List;

import static java.util.function.Predicate.not;

public class Show extends Titled {

    private String creator;
    private String category;
    private List<Season> seasons;

    public Show(String title, String description, String creator, String category, List<Season> seasons) {
        super(title, description);
        this.creator = creator;
        this.category = category;
        this.seasons = seasons;
    }

    public Long getEpisodesSeen() {
        return seasons.stream()
                .map(Season::getEpisodesSeen)
                .reduce(0L, Long::sum);
    }

    public Double getAverageRating() {
        return seasons.stream()
                .map(Season::getAverageRating)
                .mapToDouble(i -> i)
                .average()
                .orElse(0D);
    }

    public Boolean hasSeenAll() {
        return seasons.stream()
                .filter(not(Season::hasSeenAll))
                .findAny()
                .isEmpty();
    }
}
