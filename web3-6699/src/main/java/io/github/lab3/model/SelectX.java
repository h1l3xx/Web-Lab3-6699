package io.github.lab3.model;

import java.io.Serializable;

public class SelectX implements Serializable {

    double lastValue = 0;

    public void setValue(double value){
        lastValue = value;
    }


    public Double getValue() {
        return lastValue;
    }

    public double getLastValue() {
        return lastValue;
    }

    public void setLastValue(double lastValue) {
        this.lastValue = lastValue;
    }
}
