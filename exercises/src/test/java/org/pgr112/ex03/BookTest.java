package org.pgr112.ex03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void testConstructor1(){
        Book b1 = new Book("Dune", "Frank Herbert", 700);
        b1.setNumberOfpages(750);

        assertEquals(750, b1.getNumberOfpages());
        //assertTrue(b1.getTitle().equalsIgnoreCase("Dune"));
        //assertTrue(b1.getAuthor().equalsIgnoreCase("Frank Herbert"));

    }
}
