package ejercicio02;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TextParser {

    private Map<String, Long> wordCount;
    private List<String> wordsSortedByCount;

    public TextParser(String text) {
        // Borramos los caracteres especiales
        text = text.replaceAll("[^a-zA-ZáéíóúÁÉÍÓÚ ]", "");
        // Pasamos el texto a lower case
        text = text.toLowerCase();
        // Creamos un mapa donde la key es la palabra y el valor la cantidad de ocurrencias
        wordCount = Arrays.asList(text.split(" ")).stream()
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // Ordenamos las entradas por ocurrencias de mayor a menor y guardamos el resultado
        wordsSortedByCount = new ArrayList<>(wordCount.entrySet()).stream()
                .sorted(new WordCountComparator())
                .map(Entry::getKey)
                .collect(Collectors.toList());
    }

    public Integer getWordCount() {
        return wordCount.size();
    }

    public List<String> getTop(Integer top) {
        return wordsSortedByCount.subList(0, top);
    }

    public List<String> getLast(Integer last) {
        return wordsSortedByCount.subList(wordsSortedByCount.size() - last, wordsSortedByCount.size())
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public Long getOccurrences(String word) {
        return wordCount.containsKey(word.toLowerCase()) ? wordCount.get(word.toLowerCase()) : 0;
    }

    public List<String> getSortedWords() {
        // Podría guardar este resultado ordenado tambien
        return wordCount.keySet().stream().sorted().collect(Collectors.toList());
    }

    public List<String> getWordsSortedByOccurrences() {
        return new ArrayList<>(wordsSortedByCount);
    }
}
