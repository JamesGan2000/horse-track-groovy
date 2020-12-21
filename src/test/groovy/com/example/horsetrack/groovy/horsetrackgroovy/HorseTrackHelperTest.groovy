package com.example.horsetrack.groovy.horsetrackgroovy

import org.junit.jupiter.api.Test

class HorseTrackHelperTest {

    @Test
    void sum_value(){
        assert 1360 == HorseTrackHelper.cashBalance();
    }
}
