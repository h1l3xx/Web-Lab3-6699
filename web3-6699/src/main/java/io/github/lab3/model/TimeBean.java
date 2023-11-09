package io.github.lab3.model;


import java.io.Serializable;
import java.time.LocalDateTime;


public class TimeBean implements Serializable {

    public LocalDateTime getNowTime() {
        return LocalDateTime.now();
    }

}
