package com.example.drawnavigation.model;

public class SeminarModel {
//    private int id;
    private String name ;
    private String image;
    private String detail;
    private String datetime;

//    public SeminarModel(){
//
//    }

    public SeminarModel() {
//        this.id = id;
        this.name = name;
        this.detail = detail;
        this.image = image;
        this.datetime = datetime;

    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }

    public String getImage() {
        return image;
    }

    public String getDatetime() {
        return datetime;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDetail(String detail) { this.detail = detail; }


    public void setImage(String image) {
        this.image = image;
    }


    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }



}
