package org.pgr112.solutions.sol3;

public class Main {
    public static void main(String[] args){
        BookRegister br = new BookRegister();

        BookSolution b1 = new BookSolution();
        BookSolution b2 = new BookSolution("Foundation", "I Asimov",650 );

        br.addBook(b1);
        br.addBook(b2);

        System.out.println(br.getNumberOfBooks());
    }
}
