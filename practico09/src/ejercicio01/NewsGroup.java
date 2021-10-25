package ejercicio01;

import ejercicio01.filters.NewsFilter;

import java.util.*;
import java.util.stream.Collectors;

public class NewsGroup extends NewsNode {
    private String description;
    private String image;
    private List<NewsNode> elements;

    public NewsGroup(String description, String image) {
        this.description = description;
        this.image = image;
        this.elements = new ArrayList<>();
    }

    @Override
    public Integer getNewsCount() {
        return elements.stream()
                .collect(Collectors.summingInt(NewsNode::getNewsCount));
    }

    @Override
    public NewsNode copyWith(NewsFilter filter) {
        NewsGroup copy = new NewsGroup(description, image);
        var filteredElements = elements.stream()
                .map(element -> element.copyWith(filter))
                .map(Optional::ofNullable)
                .flatMap(Optional::stream)
                .collect(Collectors.toList());
        copy.addElements(filteredElements);
        return copy;
    }

    @Override
    public List<News> getNews(NewsFilter filter) {
        return elements.stream()
                .map(node -> node.getNews(filter))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public String getPath(String prefix) {
        String basePath = prefix + "/" + this.description;
        StringBuilder pathBuilder = new StringBuilder();
        // Se imprime a si mismo
        pathBuilder.append(basePath);
        pathBuilder.append(System.lineSeparator());
        // Imprime cada hijo con su path como prefijo
        elements.forEach(element -> {
            pathBuilder.append(element.getPath(basePath));
        });
        return pathBuilder.toString();
    }

    public void addElements(List<NewsNode> elements) {
        this.elements.addAll(elements);
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }
}
