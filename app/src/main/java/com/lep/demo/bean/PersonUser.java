package com.lep.demo.bean;

import java.io.Serializable;

/**
 * Created by android on 2017/10/31.
 */

public class PersonUser implements Serializable {
    private String name;
    private String age;
    private boolean hasObj;

    public PersonUser(String name, String age, boolean hasObj, String sex) {
        this.name = name;
        this.age = age;
        this.hasObj = hasObj;
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasObj() {
        return hasObj;
    }

    public void setHasObj(boolean hasObj) {
        this.hasObj = hasObj;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "PersonUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hasObj=" + hasObj +
                ", sex='" + sex + '\'' +
                '}';
    }
}
