public class Main {
    public static void main(String[] args) {
        Document document = new Document();

        document.review(); // Should not work, as the document is in draft.
        document.publish(); // Moves to review state.
        document.review(); // Already in review.
        document.publish(); // Moves to published state.
        document.review(); // Cannot review after publishing.
    }
}
