package com.example.horsetrack.groovy.horsetrackgroovy;

import org.junit.jupiter.api.Test;

class CommandParserTest {
    CommandParser commandParser = new CommandParser();

    @Test
    void invalid_command(){
        CommandInfo info = commandParser.parse("no-match-value", "some-input");
        assert !info.isValid();
        assert !info.isQuit();
        assert !info.isRestock();
        assert !info.isReSetWinningHorse();
        assert !info.isBet();
        assert "Invalid Command:no-match-value some-input" == info.message;
    }

    @Test
    void bet_valid_amount(){
        CommandInfo info = commandParser.parse("3", "5");
        assert info.isValid();
        assert !info.isQuit();
        assert !info.isRestock();
        assert !info.isReSetWinningHorse();
        assert info.isBet();
        assert 3 == info.betHorse
        assert 5 == info.betAmount;
        assert  "" == info.message;
    }

    @Test
    void bet_invalid_amount(){
        CommandInfo info = commandParser.parse("3", "2.5");
        assert !info.isValid();
        assert !info.isQuit();
        assert !info.isRestock();
        assert !info.isReSetWinningHorse();
        assert info.isBet();
        assert "Invalid Bet: 2.5" == info.message;
    }

    @Test
    void reset_winning_upper_case_invalid_amount(){
        CommandInfo info = commandParser.parse("W", "2.5");
        assert !info.isValid();
        assert !info.isQuit();
        assert !info.isRestock();
        assert info.isReSetWinningHorse();
        assert !info.isBet();
        assert "Invalid Bet Amount: 2.5" == info.message;
    }

    @Test
    void reset_winning_lower_case_invalid_amount(){
        CommandInfo info = commandParser.parse("w", "2.5");
        assert !info.isValid();
        assert !info.isQuit();
        assert !info.isRestock();
        assert info.isReSetWinningHorse();
        assert !info.isBet();
        assert "Invalid Bet Amount: 2.5" == info.message;
    }

    @Test
    void reset_winning_lower_case(){
        CommandInfo info = commandParser.parse("w", "2");
        assert info.isValid();
        assert !info.isQuit();
        assert !info.isRestock();
        assert info.isReSetWinningHorse();
        assert !info.isBet();
        assert  "" == info.message;
    }

    @Test
    void reset_winning_upper_case(){
        CommandInfo info = commandParser.parse("W", "2");
        assert info.isValid();
        assert !info.isQuit();
        assert !info.isRestock();
        assert info.isReSetWinningHorse();
        assert !info.isBet();
        assert  "" == info.message;
    }

    @Test
    void quit_upper_case(){
        CommandInfo info = commandParser.parse("Q", "");
        assert info.isValid();
        assert info.isQuit();
        assert !info.isRestock();
        assert !info.isReSetWinningHorse();
        assert !info.isBet();
        assert  "" == info.message;
    }

    @Test
    void quit_lower_case(){
        CommandInfo info = commandParser.parse("q", "");
        assert info.isValid();
        assert info.isQuit();
        assert !info.isRestock();
        assert !info.isReSetWinningHorse();
        assert !info.isBet();
        assert  "" == info.message;
    }

    @Test
    void restock_lower_case(){
        CommandInfo info = commandParser.parse("r", "");
        assert info.isValid();
        assert !info.isQuit();
        assert info.isRestock();
        assert !info.isReSetWinningHorse();
        assert !info.isBet();
        assert  "" == info.message;
    }

    @Test
    void restock_upper_case(){
        CommandInfo info = commandParser.parse("R", "");
        assert info.isValid();
        assert !info.isQuit();
        assert info.isRestock();
        assert !info.isReSetWinningHorse();
        assert !info.isBet();
        assert  "" == info.message;
    }


}