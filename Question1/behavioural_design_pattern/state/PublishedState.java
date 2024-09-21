public class PublishedState implements State {

    @Override
    public void publish(Document doc) {
        System.out.println("Published: Document is already published.");
    }

    @Override
    public void review(Document doc) {
        System.out.println("Published: Cannot review a published document.");
    }
}
