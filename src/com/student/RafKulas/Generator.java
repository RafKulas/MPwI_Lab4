package com.student.RafKulas;

public interface Generator<T> {
    void printGenerated();
    Generator<T> generate();
    T nextGenerated();
}
