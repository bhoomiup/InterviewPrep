package DesinPatterns.FactoryDP;

public class ShapeFactory {

    Shape getShape(String shape){
        return switch (shape) {
            case "CIRCLE" -> new Circle();
            case "SQUARE" -> new Square();
            default -> null;
        };
    }
}
