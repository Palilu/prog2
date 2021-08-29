package ejercicio04;

import java.util.List;

import static java.util.function.Predicate.not;

public class Season {

    private List<Episode> episodes;

    public Season(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public Long getEpisodesSeen() {
        return episodes.stream().filter(Episode::getSeen).count();
    }

    public Double getAverageRating() {
        return episodes.stream()
                .filter(Episode::getSeen)
                .map(Episode::getRating)
                .mapToInt(i -> i)
                .average()
                .orElse(0D);
    }

    public Boolean hasSeenAll() {
        return episodes.stream()
                .filter(not(Episode::getSeen))
                .findAny()
                .isEmpty();
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }
}
