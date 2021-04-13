package com.example.aosp_end.bean;

public class Classinfo {
    private int id;
    private String class_name;
    private int state;
    private int add_row;
    private int del_row;
    private int version_id;
    private int code_row;

    public Classinfo(int id, String class_name, int state, int add_row, int del_row, int version_id, int code_row) {
        this.id = id;
        this.class_name = class_name;
        this.state = state;
        this.add_row = add_row;
        this.del_row = del_row;
        this.version_id = version_id;
        this.code_row = code_row;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getAdd_row() {
        return add_row;
    }

    public void setAdd_row(int add_row) {
        this.add_row = add_row;
    }

    public int getDel_row() {
        return del_row;
    }

    public void setDel_row(int del_row) {
        this.del_row = del_row;
    }

    public int getVersion_id() {
        return version_id;
    }

    public void setVersion_id(int version_id) {
        this.version_id = version_id;
    }

    public int getCode_row() {
        return code_row;
    }

    public void setCode_row(int code_row) {
        this.code_row = code_row;
    }

    @Override
    public String toString() {
        return "Classinfo{" +
                "id=" + id +
                ", class_name='" + class_name + '\'' +
                ", state=" + state +
                ", add_row=" + add_row +
                ", del_row=" + del_row +
                ", version_id=" + version_id +
                ", code_row=" + code_row +
                '}';
    }
}
