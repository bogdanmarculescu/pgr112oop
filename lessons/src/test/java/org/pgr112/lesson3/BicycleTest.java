package org.pgr112.lesson3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BicycleTest {

    @Test
    public void testConstructor1(){
        Bicycle b1 = new Bicycle(5, 1);
        b1.speedUp(5);
        b1.changeGear(-1);

        assertTrue(b1.getGear() > 0);
        assertEquals(10, b1.speed);
    }
}
