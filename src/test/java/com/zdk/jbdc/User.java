package com.zdk.jbdc;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 3226312103017947198L;
    private String name;
    private String  id;
    private String  age;
    private String  gender;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
