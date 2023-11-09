package io.github.lab3.model;

public class AreaResultChecker {
    public static boolean getResult(double x, double y, double r) {
        if (x>=0 && y>=0){
            return x * x + y * y <= r * r;
        }else if (x<=0 && y<=0){
            return Math.abs(x) <= r && Math.abs(y) <= r;
        }else if (x>=0 && y<=0){
            return x - r - y <= 0;
        }else{
            return false;
        }
    }
}
