public interface State {
    void publish(Document doc);
    void review(Document doc);
}
