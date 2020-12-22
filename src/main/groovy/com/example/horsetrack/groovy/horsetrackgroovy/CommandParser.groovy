package com.example.horsetrack.groovy.horsetrackgroovy;

import org.apache.dubbo.common.utils.StringUtils;

class CommandParser {
    CommandInfo parse(String param1, String param2){
        CommandInfo commandInfo = new CommandInfo();
        commandInfo.param1 =  param1;
        commandInfo.param2 = param2;

        if("R".equalsIgnoreCase(param1)){
            commandInfo.valid = true;
            commandInfo.restock = true;
        }else if("Q".equalsIgnoreCase(param1)){
            commandInfo.valid = true;
            commandInfo.quit = true;
        }else if("W".equalsIgnoreCase(param1)){
            commandInfo.reSetWinningHorse = true;
            if(StringUtils.isInteger(param2)){
                commandInfo.valid = true;
            }else{
                commandInfo.message = "Invalid Bet Amount: " + param2;
            }
        }else if(StringUtils.isInteger(param1)){
            commandInfo.bet = true;
            if(StringUtils.isInteger(param2)){
                commandInfo.valid = true;
                commandInfo.betHorse = Integer.valueOf(param1);
                commandInfo.betAmount = Integer.valueOf(param2);
            }else{
                commandInfo.message = "Invalid Bet: " + param2;
            }
        }else if(StringUtils.isBlank(param1) && StringUtils.isBlank(param2)){
            commandInfo.valid = true;
            commandInfo.start = true;
        }else{
            commandInfo.valid = false;
            commandInfo.message = "Invalid Command:" + param1 + " " + param2;
        }
        commandInfo;
    };
}
