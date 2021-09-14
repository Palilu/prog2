package ejercicio06;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Reviewer {

    private String name;
    private ReviewerType reviewerType;
    private List<String> fieldsOfExpertise = new ArrayList<>();
    private List<Paper> assignedPapers = new ArrayList<>();

    public Reviewer(String name, ReviewerType reviewerType, List<String> fieldsOfExpertise) {
        this.name = name;
        this.reviewerType = reviewerType;
        this.fieldsOfExpertise = fieldsOfExpertise;
    }

    /**
     * 02 qué trabajos pueden asignarse un evaluador particular
     *
     * @param papers
     */
    public List<Paper> getAssignablePapers(List<Paper> papers) {
        return papers.stream()
                .filter(paper -> paper.isSuitable(this))
                .collect(Collectors.toList());
    }

    /**
     * 03 cuántos trabajos tiene un evaluador determinado
     */
    public Integer getPapersAmount() {
        return assignedPapers.size();
    }

    /**
     * 04 determinar si un evaluador dado es general o experto.
     */
    public Boolean isExpert() {
        return this.reviewerType == ReviewerType.EXPERT;
    }


    public Boolean assign(Paper paper) {
        if (paper.isSuitable(this)) {
            assignedPapers.add(paper);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public List<String> getFieldsOfExpertise() {
        return new ArrayList<>(fieldsOfExpertise);
    }

    public String getName() {
        return name;
    }

    public ReviewerType getReviewerType() {
        return reviewerType;
    }

    public List<Paper> getAssignedPapers() {
        return assignedPapers;
    }
}
