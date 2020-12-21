package com.example.horsetrack.groovy.horsetrackgroovy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HorseTrackViewHelperTest {

    @Test
    void display_inventory(){
        String expected = "Inventory:<br/>\$1, 10<br/>\$5, 10<br/>\$10, 10<br/>\$20, 10<br/>\$100, 10"
        assert expected == HorseTrackViewHelper.displayCurrentInventory(HorseTrackInitalizer.initialInventory())
    }

    @Test
    void displayInitialHorseInfo(){
        String expected = "Horses:<br/>1, That DarnGray Cat, 5, won<br/>2, Fort Utopia, 10, lost<br/>3, Count Sheep, 9, lost<br/>4, Ms Traitour, 4, lost<br/>5, Real Princess, 3, lost<br/>6, Pa Kettle, 5, lost<br/>7, Gin Stinger, 6, lost"
        assert expected == HorseTrackViewHelper.displayInitialHorseInfo();
    }

}