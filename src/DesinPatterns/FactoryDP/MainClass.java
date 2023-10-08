package DesinPatterns.FactoryDP;

public class MainClass {

    public static void main(String[] args) {
        ShapeFactory s = new ShapeFactory();
        Shape shapeObj = s.getShape("CIRCLE");
        shapeObj.draw();
    }

}
