public class ReviewState implements State {

    @Override
    public void publish(Document doc) {
        System.out.println("Review: Publishing the document.");
        doc.setState(new PublishedState());
    }

    @Override
    public void review(Document doc) {
        System.out.println("Review: Already in review.");
    }
}
