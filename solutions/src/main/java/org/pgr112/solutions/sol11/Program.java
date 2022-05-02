package org.pgr112.solutions.sol11;

import java.awt.Color;
import java.util.*;

public class Program {

    private final ShapeStorage storage;
    Set<Shape> shapes;

    public Program(ShapeStorage storage) throws Exception {
        this.storage = storage;
        shapes = storage.retrieveShapes();
    }

    public void start() throws Exception {
        System.out.println("Hi, and welcome!");
        System.out.println("These are you options:");
        try (Scanner scanner = new Scanner(System.in)) {
            scanner.useLocale(Locale.US);
            int choice = 0;
            while (choice != 5) {
                printMainMenu();
                choice = getValidUserChoice(scanner);
                switch (choice) {
                    case 1: drawAllShapes(); break;
                    case 2: printAreaSumForAllSquares(); break;
                    case 3: addFigure(scanner); break;
                    case 4: moveFigure(scanner); break;
                    case 5: quitProgram(); break;
                }
            }
        }
    }

    private void moveFigure(Scanner scanner) {
        System.out.println("What figure would you like to move?");
        List<Shape> shapeList = new ArrayList<>(shapes);
        for (int i = 0; i<shapeList.size(); i++) {
            System.out.println("Shape "+i+":"+shapeList.get(i));
        }
        int index = readIntAndCr(scanner);
        System.out.println("How far left (negative value moves right)?");
        double left = readDoubleAndCr(scanner);
        shapeList.get(index).moveLeft(left);
        System.out.println("How far down (negative value moves up)?");
        double down = readDoubleAndCr(scanner);
        shapeList.get(index).moveDown(down);
        System.out.println("Shape moved. Updated values:");
        System.out.println(shapeList.get(index));
    }

    private void addFigure(Scanner scanner) {
        System.out.println("Add 1:Circle, 2:Rectangle, 3:Square");
        int choice = readIntAndCr(scanner);
        switch (choice){
            case 1: addCircle(scanner); break;
            case 2: addRectangle(scanner); break;
            case 3: addSquare(scanner); break;
            default: throw new RuntimeException("Invalid choice");
        }
    }

    private void addSquare(Scanner scanner) {
        System.out.println("Enter side length:");
        int side = scanner.nextInt();
        Color color = getColorFromUser(scanner);
        System.out.println("Filled? (true/false)");
        boolean filled = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Upper left corner:");
        MovablePoint upperLeft = getMovablePointFromUser(scanner);
        System.out.println("Bottom right corner:");
        MovablePoint bottomRight = getMovablePointFromUser(scanner);
        shapes.add(new Square(side, color, filled, upperLeft, bottomRight));
    }

    private void addRectangle(Scanner scanner) {
        System.out.println("Enter width:");
        int width = readIntAndCr(scanner);
        System.out.println("Enter length:");
        int length = readIntAndCr(scanner);
        Color color = getColorFromUser(scanner);
        System.out.println("Filled? (true/false)");
        boolean filled = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Upper left corner:");
        MovablePoint upperLeft = getMovablePointFromUser(scanner);
        System.out.println("Bottom right corner:");
        MovablePoint bottomRight = getMovablePointFromUser(scanner);
        shapes.add(new Rectangle(width, length, color, filled, upperLeft, bottomRight));
    }

    private int readIntAndCr(Scanner scanner){
        int i = scanner.nextInt();
        scanner.nextLine();
        return i;
    }

    private double readDoubleAndCr(Scanner scanner){
        double d = scanner.nextDouble();
        scanner.nextLine();
        return d;
    }

    private void addCircle(Scanner scanner) {
        System.out.println("Enter radius:");
        int radius = readIntAndCr(scanner);
        Color color = getColorFromUser(scanner);
        System.out.println("Filled? (true/false)");
        boolean filled = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Center point:");
        MovablePoint center = getMovablePointFromUser(scanner);
        shapes.add(new Circle(radius, color, filled, center));
    }

    private Color getColorFromUser(Scanner scanner){
        System.out.println("Enter red color:");
        int red = readIntAndCr(scanner);
        System.out.println("Enter green color:");
        int green = readIntAndCr(scanner);
        System.out.println("Enter blue color:");
        int blue = readIntAndCr(scanner);
        return new Color(red, green, blue);
    }

    private MovablePoint getMovablePointFromUser(Scanner scanner) {
        System.out.println("Enter x-value:");
        int x = readIntAndCr(scanner);
        System.out.println("Enter y-value");
        int y = readIntAndCr(scanner);
        return new MovablePoint(x,y);
    }

    private void quitProgram() throws Exception {
        storage.storeShapes(shapes);
        System.out.println("Bye!");
    }

    private void printAreaSumForAllSquares() {
        System.out.print("Sum of area of all squares:");
        double totalArea = 0;
        for (Shape s :
                shapes) {
            if (s instanceof Square) {
                totalArea += s.getArea();
            }
        }
        System.out.println(totalArea);
    }

    private void drawAllShapes() {
        for (Shape s :
                shapes) {
            s.draw();
        }
    }

    private int getValidUserChoice(Scanner scanner) {
        int choice = -1;
        while (choice < 0 || choice > 5) {
            try {
                String s = scanner.nextLine();
                choice = Integer.parseInt(s);
            } catch (Exception e) {
                System.out.println("Please enter a valid NUMBER...");
            }
            if (choice < 0 || choice > 5) {
                System.out.println("Valid numbers: (1-5)...");
            }
        }
        return choice;
    }

    private void printMainMenu() {
        System.out.println("1: Draw all shapes");
        System.out.println("2: Area of all squares");
        System.out.println("3: Add shape");
        System.out.println("4: Move shape");
        System.out.println("5: Quit");
    }


}
