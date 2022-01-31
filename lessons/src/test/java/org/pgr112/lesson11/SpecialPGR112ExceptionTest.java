package org.pgr112.lesson11;

import org.junit.jupiter.api.Test;
import org.pgr112.lesson11.gc.Person;
import org.pgr112.lesson11.gc.SpecialPGR112Exception;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpecialPGR112ExceptionTest {

    @Test
    public void simpleExceptionTest(){

        boolean thrown = false;

        try{
            thrown = true;
            throw new IllegalArgumentException("This is what you wanted?");
        }
        catch (IllegalArgumentException ex){
            //ex.printStackTrace();
            try {
                throw new SpecialPGR112Exception("This is a wrapped exception", ex);
            }
            catch(SpecialPGR112Exception special){
                special.printStackTrace();
            }
        }
        finally {
            assertTrue(thrown);
        }

    }
}
