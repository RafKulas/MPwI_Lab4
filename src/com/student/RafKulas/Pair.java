package com.student.RafKulas;

public class Pair<X, Y> {
    private final X x_val;
    private final Y y_val;

    public Pair(X x_val, Y y_val) {
        this.x_val = x_val;
        this.y_val = y_val;
    }

    public X getX_val() {
        return x_val;
    }

    public Y getY_val() {
        return y_val;
    }
}
