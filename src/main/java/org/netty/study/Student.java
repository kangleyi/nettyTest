package org.netty.study;

import java.io.Serializable;

public class Student implements Serializable {


int id;
    String name;


    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
