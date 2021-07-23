package com.example.demo.stringtest;

public class Student {

    private int id;
    private String name;

    public Student(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 17 + id;
        hash = hash * 31 + name.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (obj == this){
            return true;
        }
        if (obj instanceof Student) {
            Student sd = (Student) obj;
            return sd.name.equals(name) && sd.id == id;
        }
        return false;
    }

}