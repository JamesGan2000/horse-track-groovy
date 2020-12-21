package com.example.horsetrack.groovy.horsetrackgroovy;

class HorseTrackViewHelper {
    static String displayInitialHorseInfo(){
        displayCurrentHorseInfo(HorseTrackInitalizer.initialHorseOdds())
    }

    static String displayInitialInventory(){
        displayCurrentInventory(HorseTrackInitalizer.initialInventory())
    }

    static String displayCurrentHorseInfo(List<HorseOdd> list){
        "Horses:<br/>" + list.collect(){HorseOdd item -> item.toString()}.join("<br/>")
    }

    static String displayPayoutInfo(List<InventoryItem> list){
        "Dispensing:<br/>" + list.collect(){InventoryItem item -> item.toString()}.join("<br/>")
    }

    static String displayCurrentInventory(List<InventoryItem> list){
        "Inventory:<br/>" + list.collect(){InventoryItem item -> item.toString()}.join("<br/>")
    }
}
