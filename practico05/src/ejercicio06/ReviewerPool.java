package ejercicio06;

import java.util.List;

public class ReviewerPool {

    private List<Reviewer> reviewers;

    public ReviewerPool(List<Reviewer> reviewers) {
        this.reviewers = reviewers;
    }

    public Reviewer getReviewer(Paper paper) {
        return reviewers.stream()
                .filter(reviewer -> reviewer.assign(paper))
                .findFirst()
                .orElse(null);
    }
}
