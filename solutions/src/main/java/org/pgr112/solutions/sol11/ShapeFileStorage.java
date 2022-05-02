package org.pgr112.solutions.sol11;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ShapeFileStorage implements ShapeStorage{

    private final String fileName;

    public ShapeFileStorage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public Set<Shape> retrieveShapes() throws Exception {
        Set<Shape> shapes = new HashSet<>();
        try(Scanner scanner = new Scanner(new File(fileName))){
            scanner.useLocale(Locale.US);
            while(scanner.hasNextLine()){
                String shapeType = scanner.nextLine();
                switch (shapeType) {
                    case "Circle": {
                        Circle circle = readCircle(scanner);
                        shapes.add(circle);
                        break;
                    }
                    case "Rectangle": {
                        Rectangle rectangle = readRectangle(scanner);
                        shapes.add(rectangle);
                        break;
                    }
                    case "Square": {
                        Square square = readSquare(scanner);
                        shapes.add(square);
                        break;
                    }
                    default: throw new RuntimeException("Unknown shape found!");
                }
            }
        }
        return shapes;
    }

    private Square readSquare(Scanner scanner) {
        double side = readDoubleAndCr(scanner);
        Color color = readColor(scanner);
        boolean filled = readBooleanAndCr(scanner);
        MovablePoint topLeft = readMovablePoint(scanner);
        MovablePoint bottomRight = readMovablePoint(scanner);
        return new Square(side, color, filled, topLeft, bottomRight);
    }

    private Rectangle readRectangle(Scanner scanner) {
        double width = readDoubleAndCr(scanner);
        double length = readDoubleAndCr(scanner);
        Color color = readColor(scanner);
        boolean filled = readBooleanAndCr(scanner);
        MovablePoint topLeft = readMovablePoint(scanner);
        MovablePoint bottomRight = readMovablePoint(scanner);
        return new Rectangle(width, length, color, filled, topLeft, bottomRight);
    }

    private double readDoubleAndCr(Scanner scanner) {
        double d = scanner.nextDouble();
        scanner.nextLine();
        return d;
    }

    private Circle readCircle(Scanner scanner) {
        int radius = readIntAndCr(scanner);
        Color color = readColor(scanner);
        boolean filled = readBooleanAndCr(scanner);
        MovablePoint center = readMovablePoint(scanner);
        return new Circle(radius, color, filled, center);
    }

    private MovablePoint readMovablePoint(Scanner scanner) {
        double x = readDoubleAndCr(scanner);
        double y = readDoubleAndCr(scanner);
        return new MovablePoint(x,y);
    }

    private Color readColor(Scanner scanner) {
        int r = readIntAndCr(scanner);
        int g = readIntAndCr(scanner);
        int b = readIntAndCr(scanner);
        return new Color(r,g,b);
    }

    private int readIntAndCr(Scanner scanner){
        int i = scanner.nextInt();
        scanner.nextLine();
        return i;
    }

    private boolean readBooleanAndCr(Scanner scanner){
        boolean b = scanner.nextBoolean();
        scanner.nextLine();
        return b;
    }

    @Override
    public void storeShapes(Set<Shape> shapes) throws Exception {
        try(FileWriter fileWriter = new FileWriter(fileName)){
            for (Shape s :
                    shapes) {
                if(s instanceof Circle){
                    writeCircleToFile(fileWriter, (Circle) s);
                } else if(s instanceof Square){
                    writeSquareToFile(fileWriter, (Square) s);
                } else if(s instanceof Rectangle){
                    writeRectangleToFile(fileWriter, (Rectangle) s);
                }
            }
        }
    }

    private void writeRectangleToFile(FileWriter fileWriter, Rectangle r) throws IOException {
        fileWriter.write("Rectangle\n");
        fileWriter.write(r.getWidth()+"\n");
        fileWriter.write(r.getLength()+"\n");
        writeColor(fileWriter, r.getColor());
        fileWriter.write(r.isFilled()+"\n");
        writeMovablePoint(fileWriter, r.getTopLeft());
        writeMovablePoint(fileWriter, r.getBottomRight());
    }

    private void writeSquareToFile(FileWriter fileWriter, Square s) throws IOException {
        fileWriter.write("Square\n");
        fileWriter.write(s.getSide()+"\n");
        writeColor(fileWriter, s.getColor());
        fileWriter.write(s.isFilled()+"\n");
        writeMovablePoint(fileWriter, s.getTopLeft());
        writeMovablePoint(fileWriter, s.getBottomRight());
    }

    private void writeCircleToFile(FileWriter fileWriter, Circle c) throws IOException {
        fileWriter.write("Circle\n");
        fileWriter.write(c.getRadius()+"\n");
        writeColor(fileWriter, c.getColor());
        fileWriter.write(c.isFilled()+"\n");
        writeMovablePoint(fileWriter, c.getCenter());
    }

    private void writeMovablePoint(FileWriter fileWriter, MovablePoint mp) throws IOException {
        fileWriter.write(mp.getX() + "\n");
        fileWriter.write(mp.getY() + "\n");
    }

    private void writeColor(FileWriter fileWriter, Color c) throws IOException {
        fileWriter.write(c.getRed()+"\n");
        fileWriter.write(c.getGreen()+"\n");
        fileWriter.write(c.getBlue()+"\n");
    }
}
