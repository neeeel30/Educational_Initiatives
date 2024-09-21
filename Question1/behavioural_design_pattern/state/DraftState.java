public class DraftState implements State {

    @Override
    public void publish(Document doc) {
        System.out.println("Draft: Moving to review state.");
        doc.setState(new ReviewState());
    }

    @Override
    public void review(Document doc) {
        System.out.println("Draft: Cannot move to review directly, publish first.");
    }
}
