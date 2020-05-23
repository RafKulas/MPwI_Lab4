package com.student.RafKulas;

public interface Generator<T> {
    void print();
    void generate();
    T nextGenerated();
}
