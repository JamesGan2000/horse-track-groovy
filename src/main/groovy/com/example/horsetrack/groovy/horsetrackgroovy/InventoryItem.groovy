package com.example.horsetrack.groovy.horsetrackgroovy;

class InventoryItem {
    Integer dollar;
    Integer count;

    InventoryItem(Integer dollar, Integer count) {
        this.dollar = dollar;
        this.count = count;
    }

    Integer value(){
        dollar * count;
    }

    @Override
    public String toString() {
        '$' + dollar + ", " + count;
    }
    
}
