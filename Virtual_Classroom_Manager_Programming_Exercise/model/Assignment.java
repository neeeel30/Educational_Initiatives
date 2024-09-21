package model;

import java.util.ArrayList;
import java.util.List;

public class Assignment {
    private String details;
    private List<String> submittedBy; // Tracks which students have submitted this assignment

    public Assignment(String details) {
        this.details = details;
        this.submittedBy = new ArrayList<>();
    }

    public String getDetails() {
        return details;
    }

    public List<String> getSubmittedBy() {
        return submittedBy;
    }
}
