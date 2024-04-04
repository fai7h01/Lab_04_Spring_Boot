package com.cydeo.enums;

import java.util.Random;

public enum QuantityType {
    OUNCE, LB, TBSP;

    public QuantityType randomQuantityType(){
        int pick = new Random().nextInt(QuantityType.values().length);
        return QuantityType.values()[pick];
    }
}
