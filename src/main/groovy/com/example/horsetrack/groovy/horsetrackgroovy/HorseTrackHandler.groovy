package com.example.horsetrack.groovy.horsetrackgroovy;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
class HorseTrackHandler {
    private CommandParser commandParser = new CommandParser();

    String handle(String param1, String param2){
        CommandInfo commandInfo = commandParser.parse(param1, param2);
        if(!commandInfo.valid){
            commandInfo.message;
        }else if(commandInfo.quit){
            commandInfo.message = "QUIT";
        }else {
            List<InventoryItem> balances = HorseTrackHelper.balances;
            List<HorseOdd> horseInfos = HorseTrackHelper.horseInfos;

            if(commandInfo.restock){
                HorseTrackHelper.restockCashInventory();
                commandInfo.message =
                        HorseTrackViewHelper.displayCurrentInventory(balances) + "<br/>" +
                        HorseTrackViewHelper.displayCurrentHorseInfo(horseInfos);
            }else if(commandInfo.reSetWinningHorse){
                HorseOdd horseOdd = HorseTrackHelper.findByHorseNumber(Integer.valueOf(param2));
                if(horseOdd == null){
                    commandInfo.message = "Invalid Horse Number:" + param2;
                }else{
                    HorseTrackHelper.resetWinningHorse(Integer.valueOf(param2));
                    commandInfo.message =
                            HorseTrackViewHelper.displayCurrentInventory(balances) + "<br/>" +
                            HorseTrackViewHelper.displayCurrentHorseInfo(horseInfos);
                }
            }else if(commandInfo.bet){
                BetResult betResult = HorseTrackHelper.bet(commandInfo.betHorse, commandInfo.betAmount);
                if(!betResult.horseFound){
                    commandInfo.message = "Invalid Horse Number:" + commandInfo.betHorse;
                }else if(!betResult.matchingHorse.win){
                    commandInfo.message = "No Payout:" + betResult.matchingHorse.horseName;
                }else if(betResult.winningAmount > HorseTrackHelper.cashBalance()){
                    commandInfo.message = 'Insufficient Funds: $' + betResult.winningAmount;
                }else{
                    List<InventoryItem> list = HorseTrackHelper.cashOut(betResult.winningAmount);
                    commandInfo.message = "Payout:" + betResult.matchingHorse.horseName + ', $' +
                            betResult.winningAmount + "<br/>" +
                            HorseTrackViewHelper.displayPayoutInfo(list) + "<br/>" +
                            HorseTrackViewHelper.displayCurrentInventory(balances) + "<br/>" +
                            HorseTrackViewHelper.displayCurrentHorseInfo(horseInfos);
                }
            }
        }

        commandInfo.message;
    }

}
