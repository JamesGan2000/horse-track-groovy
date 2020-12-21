package com.example.horsetrack.groovy.horsetrackgroovy;

class HorseTrackHelper {
    static List<HorseOdd> horseInfos = HorseTrackInitalizer.initialHorseOdds();
    static List<InventoryItem> balances = HorseTrackInitalizer.initialInventory();

    static void restockCashInventory(){
        balances = HorseTrackInitalizer.initialInventory();
    }

    static BetResult bet(Integer horseNumber, Integer betAmount){
        BetResult betResult = new BetResult();
        betResult.setMatchingHorse(findByHorseNumber(horseNumber));

        if(betResult.horseFound){
            if(betResult.matchingHorse.win){
                betResult.winningAmount = betResult.matchingHorse.odds * betAmount;
            }
        }
        return betResult;
    }

    static void resetWinningHorse(Integer horseNumber){
        for (HorseOdd horseInfo : horseInfos) {
            horseInfo.win = horseInfo.horseNumber.equals(horseNumber);
        }
    }

    static HorseOdd findByHorseNumber(Integer horseNumber){
        for (HorseOdd horseInfo : horseInfos) {
            if(horseInfo.horseNumber.equals(horseNumber)){
                return horseInfo;
            }
        }
        return null;
    }

    static List<InventoryItem> cashOut(Integer payAmount){
        Integer remainingPayoutAmount = payAmount;

        List<InventoryItem> payoutInfo = new ArrayList<>();

        for (int i = balances.size() - 1; i >= 0; i--) {
            if(remainingPayoutAmount < 1){
                return payoutInfo;
            }

            InventoryItem s = balances.get(i);
            Integer count = s.count;

            int value1 = remainingPayoutAmount / s.dollar;

            int min = Math.min(count, value1);
            s.count = s.count - min;

            remainingPayoutAmount -= min * s.dollar;

            payoutInfo.add(new InventoryItem(s.dollar, min));
        }

        return payoutInfo;
    }

    static Integer cashBalance(){
        balances.sum {it.value()} as Integer
    }
}
