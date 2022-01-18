package org.pgr112.solutions.sol5;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArtistTest {

    @Test
    public void testConstructor(){
        Artist a = new Artist(
                "Bruce Dickinson",
                LocalDate.parse("1958-08-07"),
                "Worksop",
                "UK"
        );

        assertTrue(a.getArtistName().equalsIgnoreCase("Bruce Dickinson"));
    }

    @Test
    public void testArtistReader(){

        ArrayList<Artist> artists = new ArrayList<>();
        Artist a = new Artist(
                "Bruce Dickinson",
                LocalDate.parse("1958-08-07"),
                "Worksop",
                "UK"
        );
        artists.add(a);

        assertEquals(1, artists.size());

    }
}
