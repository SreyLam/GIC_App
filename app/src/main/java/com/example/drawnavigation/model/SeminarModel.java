package com.example.drawnavigation.model;

public class SeminarModel {
//    private int id;
//String text;
    String name ;
    String start_date;
    String end_date;
    String imageUrl;
    String detail;


    public SeminarModel(String name, String start_date, String end_date, String imageUrl) {
//        this.id = id;
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.imageUrl = imageUrl;
        this.detail = detail;

    }

    public String getName()
    {
        return name;
    }



    public String getStart_date()
    {
        return start_date;
    }

    public String getEnd_date() { return end_date; }

    public String getImageUrl() {
        return imageUrl;
    }
    public String getDetail()
    {
        return detail;
    }

}
