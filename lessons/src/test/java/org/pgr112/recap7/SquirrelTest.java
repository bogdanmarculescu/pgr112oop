package org.pgr112.recap7;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class SquirrelTest {

    //private int squirrelCount = 0;

    @Test
    public void squirrelTest1(){
        Squirrel s1 = new Squirrel();

        String userName = "User Squirrel"; // This comes from some source of data.
        Squirrel s2 = new Squirrel(userName);

        assertFalse(Objects.equals(s1.getName(), s2.getName()));
        if(!Objects.equals(s1.getName(), s2.getName())){
            System.out.println("Yep, they're not equal");
        }
        else{
            System.out.println("Oh dear! They're equal");
        }

        String jokeName = suggestSquirrelName(true, 13);
        Squirrel s3 = new Squirrel(jokeName);

        assertEquals("SecretSquirrel13", s3.getName());

        String seriousSquirrelName = suggestSquirrelName(false, 42);
        Squirrel s4 = new Squirrel(seriousSquirrelName);
        assertEquals("Squirrel42", s4.getName());
    }

    public String suggestSquirrelName(boolean joke, int squirrelCount){
        if( joke ) {
            return "SecretSquirrel" + squirrelCount;
        }
        return "Squirrel" + squirrelCount;
    }
}
