package com.example.horsetrack.groovy.horsetrackgroovy;

class InventoryItem {
    Integer dollar;
    Integer count;

    InventoryItem(Integer dollar, Integer count) {
        this.dollar = dollar;
        this.count = count;
    }

    Integer value(){
        return dollar * count;
    }

    Integer plus(InventoryItem item){
        value() + item.value()
    }

    @Override
    public String toString() {
        return '$' + dollar + ", " + count;
    }
    
}
