package lambda;

interface Shape {
    void draw();
}

interface Addable {
    int addition(int a, int b);
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a square");
    }
}

public class LambdaExample {
    public static void main(String[] args) {
        Shape rectangle = () -> System.out.println("Drawing a rectangle");
        rectangle.draw();

        Shape circle = () -> System.out.println("Drawing a circle");
//        circle.draw();

        Shape square = () -> System.out.println("Drawing a square");
//        square.draw();

        print(circle);
        print(square);
        print(() -> System.out.println("Drawing a triangle"));

        Addable add = (a, b) -> (a+b);
        int result = add.addition(10, 20);
        System.out.println(result);
    }

    public static void print(Shape shape) {
        shape.draw();
    }
}
