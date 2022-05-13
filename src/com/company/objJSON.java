package com.company;
import java.io.Serializable;

public class objJSON implements Serializable {
    String name;
    int id;
    public objJSON(String name, int id) {
        this.name = name;
        this.id = id;
    }
}