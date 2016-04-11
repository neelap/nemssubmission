package com.nems.revctx.resources.submission;

/**
 * Created by NE281900 on 4/11/2016.
 */
public class Test {
    private String id;
    private String name;

    public Test(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Test() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
