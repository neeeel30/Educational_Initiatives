public class Document {
    private State state;

    public Document() {
        state = new DraftState(); // Initial state
    }

    public void setState(State state) {
        this.state = state;
        System.out.println("Document state changed to: " + state.getClass().getSimpleName());
    }

    public void publish() {
        state.publish(this);
    }

    public void review() {
        state.review(this);
    }
}
