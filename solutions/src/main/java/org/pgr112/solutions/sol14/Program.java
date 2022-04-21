package org.pgr112.solutions.sol14;

import org.pgr112.solutions.sol14.dtos.CircleDao;
import org.pgr112.solutions.sol14.dtos.RectangleDao;
import org.pgr112.solutions.sol14.shapes.Circle;
import org.pgr112.solutions.sol14.shapes.MovablePoint;
import org.pgr112.solutions.sol14.shapes.Rectangle;
import org.pgr112.solutions.sol14.shapes.Shape;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public ArrayList<String> menu = new ArrayList<>();

    public Program(){
        super();
        //initSomeShapes();
        initializeMenu();
    }

    public void initializeMenu(){
        menu.add(0, "Exit");
        menu.add(1, "Display Menu");
        menu.add(2, "Display All Shapes");
        menu.add(3, "Display Circles");
        menu.add(4, "Display Rectangles");
        menu.add(5, "Add Circle");
        menu.add(6, "Add Rectangle");
    }

    public void initSomeShapes(){
        Circle c1 = new Circle();
        c1.setColor("BLUE");
        c1.setRadius(3.14);
        c1.setCenter(new MovablePoint(2, 3));
        CircleDao circleDao = new CircleDao();
        try {
            circleDao.save(c1);
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

        Rectangle r1 = new Rectangle();
        r1.setColor("RED");
        r1.setFilled(true);
        r1.setLength(3);
        r1.setWidth(2);
        r1.setTopLeft(new MovablePoint(-1, -1));
        r1.setBottomRight(new MovablePoint(2, 1));
        RectangleDao rectangleDao = new RectangleDao();
        try {
            rectangleDao.save(r1);
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    public void displayMenu(){
        for (int i = 0; i < menu.size(); i++){
            System.out.println("" + i + " -> " + menu.get(i));
        }
    }

    public void runProgram(){
        displayMenu();

        // Initialize scanner
        Scanner inputs = new Scanner(System.in);
        String input = "1";

        while(!input.equalsIgnoreCase("0")){
            input = inputs.nextLine();
            switch (input){
                // case 0 - exit
                case "0": {
                    System.out.println("Exiting...");
                    break;
                }
                // case 1 - display menu
                case "1": {
                    System.out.println("Menu");
                    displayMenu();
                    break;
                }
                // case 2 - display shapes
                case "2": {
                    System.out.println("Displaying all shapes");
                    displayShapes();
                    break;
                }
                case "3": {
                    System.out.println("Displaying Circles");
                    displayCircles();
                    break;
                }
                case "4": {
                    System.out.println("Display Rectangle");
                    displayRectangles();
                    break;
                }
                case "5": {
                    System.out.println("Add Circle");
                    addCircle(inputs);
                    break;
                }
                case "6": {
                    System.out.println("Add Rectangle");
                    addRectangle(inputs);
                    break;
                }
                default : { // if the input is unknown, I would rather not crash to whole program
                    System.out.println("What on Earth are you on about?"); // inform the user
                    System.out.println("Just type \"1\" to see what I can actually do.");   // provide some guidance
                    System.out.println("Or type \"0\" to Exit.");   // provide some guidance
                    break;
                }
            }
        }
    }

    public void displayCircles(){
        CircleDao circles = new CircleDao();
        ArrayList<Circle> circles1 = new ArrayList<>();
        try {
            circles1 = circles.listAll();
            for(Circle c : circles1){
                System.out.println(c.toString());
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    public void displayRectangles(){
        RectangleDao rectangles = new RectangleDao();
        ArrayList<Rectangle> r1 = new ArrayList<>();
        try {
            r1 = rectangles.listAll();
            for(Rectangle c : r1){
                System.out.println(c.toString());
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    public void displayShapes(){
        CircleDao circles = new CircleDao();
        RectangleDao rectangles = new RectangleDao();

        ArrayList<Shape> shapes = new ArrayList<>();
        try {
            shapes.addAll(circles.listAll());
            shapes.addAll(rectangles.listAll());
            for (Shape s1 : shapes){
                System.out.println(s1.toString());
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    public void addCircle(Scanner sc){
        Circle circle = readCircleFromInput(sc);
        CircleDao cd = new CircleDao();
        try{
            cd.save(circle);
        }
        catch (SQLException sqlException){sqlException.printStackTrace();}

        System.out.println("Added!");
    }

    public Circle readCircleFromInput(Scanner sc){
        System.out.println("Adding a new Circle:");

        System.out.println("Color:");
        String color = sc.nextLine();

        System.out.println("Filled? Y/N");
        boolean filled = false;
        String fillS = sc.nextLine();
        if(fillS.equalsIgnoreCase("y") ||
        fillS.equalsIgnoreCase("true")){
            filled = true;
        }

        System.out.println("Center - X:");
        String centerX = sc.nextLine();
        int cx = 0;
        try{
            cx = Integer.parseInt(centerX);
        }
        catch (Exception e){ e.printStackTrace(); }

        System.out.println("Center - Y:");
        String centerY = sc.nextLine();
        int cy = 0;
        try{
            cy = Integer.parseInt(centerY);
        }
        catch (Exception e){ e.printStackTrace(); }

        System.out.println("Radius: ");
        String ra = sc.nextLine();
        double rad = 0;
        try{
            rad = Double.parseDouble(ra);
        }
        catch (Exception e){ e.printStackTrace(); }

        Circle result = new Circle();
        result.setColor(color);
        result.setFilled(filled);
        result.setRadius(rad);
        result.setCenter(new MovablePoint(cx, cy));

        return result;
    }

    public void addRectangle(Scanner sc){
        Rectangle rectangle = readRectangleFromInput(sc);
        RectangleDao rd = new RectangleDao();
        try{
            rd.save(rectangle);
        }
        catch (SQLException sqlException){sqlException.printStackTrace();}

        System.out.println("Added!");
    }

    public Rectangle readRectangleFromInput(Scanner sc){
        System.out.println("Adding a rectangle:");

        System.out.println("Color: ");
        String color = sc.nextLine();

        System.out.println("Filled? Y/N");
        boolean filled = false;
        String fillS = sc.nextLine();
        if(fillS.equalsIgnoreCase("y") ||
                fillS.equalsIgnoreCase("true")){
            filled = true;
        }

        System.out.println("Length: ");
        String le = sc.nextLine();
        double length = 0;
        try{
            length = Double.parseDouble(le);
        }
        catch (Exception e){ e.printStackTrace(); }

        System.out.println("Width: ");
        String wi = sc.nextLine();
        double width = 0;
        try{
            width = Double.parseDouble(wi);
        }
        catch (Exception e){ e.printStackTrace(); }

        System.out.println("TopLeft - X:");
        String tx = sc.nextLine();
        int tlx = 0;
        try{
            tlx = Integer.parseInt(tx);
        }
        catch (Exception e){ e.printStackTrace(); }

        System.out.println("TopLeft - Y:");
        String ty = sc.nextLine();
        int tly = 0;
        try{
            tly = Integer.parseInt(ty);
        }
        catch (Exception e){ e.printStackTrace(); }

        System.out.println("BottomRight - X:");
        String bx = sc.nextLine();
        int blx = 0;
        try{
            blx = Integer.parseInt(bx);
        }
        catch (Exception e){ e.printStackTrace(); }

        System.out.println("BottomRight - Y:");
        String by = sc.nextLine();
        int bly = 0;
        try{
            bly = Integer.parseInt(by);
        }
        catch (Exception e){ e.printStackTrace(); }

        Rectangle result = new Rectangle();
        result.setColor(color);
        result.setFilled(filled);
        result.setWidth(width);
        result.setLength(length);

        result.setTopLeft(new MovablePoint(tlx, tly));
        result.setBottomRight(new MovablePoint(blx, bly));

        return result;
    }


}
