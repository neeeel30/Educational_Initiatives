public class MainComposite {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();

        CompositeGraphic compositeGraphic = new CompositeGraphic();
        compositeGraphic.add(circle);
        compositeGraphic.add(rectangle);

        compositeGraphic.draw();
    }
}