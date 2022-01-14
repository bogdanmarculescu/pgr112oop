package org.pgr112.lesson6;

import org.junit.jupiter.api.Test;
import org.pgr112.solutions.sol4.BookRegister;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SomeExplanationsTest {

    @Test
    public void initializeTest(){
        SomeExplanations se = new SomeExplanations();
        BookRegister br = se.initializeBookRegister();
        BookRegister br2 = se.initializeBookRegister(15);

        assertTrue(br.getNumberOfBooks() == 5);

        assertTrue(br2.getNumberOfBooks() == 15);
    }
}
