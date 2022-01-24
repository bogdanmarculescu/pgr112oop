package org.pgr112.solutions.sol8;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShapeTests {

    @Test
    public void task4andlater(){
        HashMap<String, Shape> shapeMap = new HashMap<>();

        addRandomShapes(shapeMap, 0, 10);

        // A quick sanity check that the map has 10 elements
        assertEquals(10, shapeMap.size());

        //task 5 - print info about all the objects
        // Remember we have to look at the collection of values

        System.out.println("Task 5:");
        for(Shape sh : shapeMap.values()){
            System.out.println(sh.toString());
        }

        //task 6 - check object we know exists
        // Let's create a new one, just to be sure.
        Square testSquare = new Square(2.0);
        shapeMap.put("testSquare", testSquare);

        // Add some more shapes
        addRandomShapes(shapeMap, 12, 16);

        String testString = shapeMap.get("testSquare").toString();

        // Tasks says print:
        System.out.println(testString);

        // Let's run an assert too
        assertTrue(testString.contains("Square"));
        assertTrue(testString.contains("Side"));
    }

    @Test
    public void testIterator(){
        HashMap<String, Shape> map = new HashMap<>();
        addRandomShapes(map, 1, 12);

        // An iterator will give us elements of a collection, one at a time.
        // Each element only once.
        Iterator iterator = map.values().iterator();

        // while there are still elements to see
        while(iterator.hasNext()){
            // Remember, WE know it's a Shape, but the compiler needs to be told.
            Shape current = (Shape) iterator.next();
            // We don't know more about what shapes were generated, but all shapes should have positive area and perimeter
            assertTrue(current.getPerimeter() >= 0);
            assertTrue(current.getArea() >= 0);
        }
    }

    @Test
    public void testEnhancedFor(){
        HashMap<String, Shape> map = new HashMap<>();
        addRandomShapes(map, 1, 12);

        for (Map.Entry<String, Shape> entry : map.entrySet()){
            // Remember, this is an Entry. I.e. a key-value pair.
            Shape current = entry.getValue();
            // We don't know more about what shapes were generated, but all shapes should have positive area and perimeter
            assertTrue(current.getPerimeter() >= 0);
            assertTrue(current.getArea() >= 0);
        }
    }

    @Test
    public void testForEach(){
        HashMap<String, Shape> map = new HashMap<>();
        addRandomShapes(map, 1, 12);

        map.forEach((k, v) -> {
            // For each entry, we label the Key as "k", and the Value as "v"
            assertTrue(v.getPerimeter() >= 0);
            assertTrue(v.getArea() >= 0);
        });
    }

    @Test
    public void testAreaLimit(){
        double areaLimit = 2.1;
        // this should be larger than the area of the default shapes
        // except circle
        // Square = 1 * 1
        // Rectangle = 1 * 2
        // Circle = PI * 1

        HashMap<String, Shape> map = new HashMap<>();
        addRandomShapes(map, 0, 16);

        for(Shape sh : map.values()){
            if(sh.getArea() >= areaLimit){
                // the condition is met
                System.out.println(sh.toString() + " -> Area: " + sh.getArea());
                // check my earlier claim that it will be a circle.
                assertTrue(sh.toString().contains("Circle"));
            }
        }

    }

    @Test
    public void testAreaLimitStream(){
        // You can learn more about streams later. Here's a quick preview.
        double areaLimit = 2.1;
        // this should be larger than the area of the default shapes
        // except circle
        // Square = 1 * 1
        // Rectangle = 1 * 2
        // Circle = PI * 1

        HashMap<String, Shape> map = new HashMap<>();
        addRandomShapes(map, 0, 16);
        System.out.println("Using streams: ");

        boolean allCircles = map.values().stream()
                .filter(sh -> sh.getArea() >= areaLimit) //Filter only the elements that meet the condition
                .peek(sh -> System.out.println(sh.toString() + " Area: " + sh.getArea()))
                .allMatch(sh -> sh.toString().contains("Circle")); // verifying that all remaining elements are circles

        assertTrue(allCircles);
    }

    public void addRandomShapes(HashMap<String, Shape> hash, int startIndex, int stopIndex){
        for (int i = startIndex; i < stopIndex; i++){
            // generate a random shape, put it in the map
            hash.put("shape" + i, generateRandomShape());
        }
    }

    public Shape generateRandomShape(){
        Random rand = new Random();

        // Remember, this gives us a random int, from 0 (inclusive) to the int (exclusive)
        int choice = rand.nextInt(4);
        switch (choice){
            case 0 -> {
                return new Circle();
            }
            case 1 -> {
                return new Rectangle();
            }
            case 2 -> {
                return new Square();
            }
            case 3 -> {
                return new EquilateralTriangle();
            }
        }
        // this SHOULD be unreachable, i.e. the method should return before this
        // But just in case:
        return new Circle();
    }


}
