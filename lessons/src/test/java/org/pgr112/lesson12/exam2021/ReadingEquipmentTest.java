package org.pgr112.lesson12.exam2021;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReadingEquipmentTest {

    @Test
    public void equipmentTest(){
        Program program = new Program();

        assertTrue(program.getEquipmentMap().size() > 0);

    }
}
