package org.pgr112.solutions.sol3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BookSolutionTest {

    @Test
    public void testTask5(){
        BookSolution b1 = new BookSolution("Dune", "Frank Herbert", 700);
        b1.setNumberOfpages(750);

        assertEquals(750, b1.getNumberOfpages());
        assertTrue(b1.getTitle().equalsIgnoreCase("Dune"));
        assertTrue(b1.getAuthor().equalsIgnoreCase("Frank Herbert"));

    }

    @Test
    public void testTask6(){
        BookSolution b1 = new BookSolution("Dune", "Frank Herbert", 700);
        b1.setNumberOfpages(750);
        assertEquals(750, b1.getNumberOfpages());

        BookSolution b2 = new BookSolution();
        b2.setAuthor("Isaac Asimov");
        b2.setTitle("Foundation");
        b2.setNumberOfpages(600);

        assertEquals(600, b2.getNumberOfpages());
        assertTrue(b2.getTitle().equalsIgnoreCase("Foundation"));
        assertTrue(b2.getAuthor().equalsIgnoreCase("Isaac Asimov"));

    }

    @Test
    public void testTask8(){
        BookSolution b1 = new BookSolution("Dune", "Frank Herbert", 700);
        b1.setGenre(Genre.OTHER);

        BookSolution b2 = new BookSolution("Lord of the Rings", "J.R.R. Tolkien", 650);
        b2.setGenre(Genre.FANTASY);

        assertEquals(Genre.OTHER, b1.getGenre());
        assertEquals(Genre.FANTASY, b2.getGenre());
    }


    private BookRegister initializeBookRegister(){
        BookRegister br = new BookRegister();

        br.addBook(new BookSolution("Dune", "Frank Herbert", 750, Genre.OTHER));

        br.addBook(new BookSolution("Fellowship of the Ring", "J.R.R. Tolkien", 750, Genre.FANTASY));
        br.addBook(new BookSolution("The Two Towers", "J.R.R. Tolkien", 750, Genre.FANTASY));
        br.addBook(new BookSolution("Return of the King", "J.R.R. Tolkien", 750, Genre.FANTASY));

        br.addBook(new BookSolution("Guards! Guards!", "Terry Pratchett", 750, Genre.FANTASY));

        return br;
    }

    @Test
    public void testExtraTask2all(){
        BookRegister register = initializeBookRegister();
        BookSolution[] all = register.allRegisteredBooks();

        assertEquals("Dune", all[0].getTitle());
        assertEquals("Terry Pratchett", all[4].getAuthor());

        /*
        Note: you can include many more tests here, checking that each book:
        - has all the information it was included with
        - is in the right position in the returned array
         */
    }

    @Test
    public void testExtraTask2genre(){
        BookRegister register = initializeBookRegister();
        BookSolution[] all = register.booksInGenre(Genre.FANTASY);

        assertEquals(Genre.FANTASY, all[0].getGenre());
        /*
        Note: again, many more checks are possible here.
         */
    }

    @Test
    public void testExtraTask2author(){
        BookRegister register = initializeBookRegister();
        BookSolution[] all = register.booksByAuthor("J.R.R. Tolkien");

        assertEquals("J.R.R. Tolkien", all[0].getAuthor());
        /*
        Note: again, many more checks are possible here.
         */
    }

    @Test
    public void testExtraTask3(){
        BookRegister register = new BookRegister();
        BookSolution b1 = new BookSolution("Guards! Guards!", "Terry Pratchett", 750, Genre.FANTASY);
        b1.addChapter(new Chapter("Chapter 1", 50));
        b1.addChapter(new Chapter("Chapter 2", 75));
        b1.addChapter(new Chapter("Chapter 3", 50));

        BookSolution b2 = new BookSolution("Dune", "Frank Herbert", 750, Genre.OTHER);
        b2.addChapter(new Chapter("Chapter 1", 150));
        b2.addChapter(new Chapter("Chapter 2", 175));
        b2.addChapter(new Chapter("Chapter 3", 250));

        register.addBook(b1);
        register.addBook(b2);

        ArrayList<BookSolution> shortBooks = register.booksWithReadingTimeLessThan(400);

        assertTrue(shortBooks.get(0).getTitle().equalsIgnoreCase("Guards! Guards!"));
        assertTrue(shortBooks.get(0).getAuthor().equalsIgnoreCase("Terry Pratchett"));
        assertTrue(shortBooks.get(0).readingTime() <= 400);

        ArrayList<BookSolution> longBooks = register.booksWithReadingTimeLessThan(2000);
        assertTrue(longBooks.get(0).getTitle().equalsIgnoreCase("Guards! Guards!"));
        assertTrue(longBooks.get(0).getAuthor().equalsIgnoreCase("Terry Pratchett"));
        assertTrue(longBooks.get(0).readingTime() <= 400);

        assertTrue(longBooks.get(1).getTitle().equalsIgnoreCase("Dune"));
        assertTrue(longBooks.get(1).getAuthor().equalsIgnoreCase("Frank Herbert"));
        assertTrue(longBooks.get(1).readingTime() <= 2000);

    }


}
