package com.example.drawnavigation.model;

public class ScholarshipModel {
    String title ;
    String date;
    String short_description;
    //    String description;
    public ScholarshipModel(String title, String date, String short_description) {
//        this.id = id;
        this.title = title;
        this.date = date;
        this.short_description = short_description;
//        this.description = description;

    }

    public String getTitle()
    {
        return title;
    }
    public String getDate()
    {
        return date;
    }
    public String getShort_description()
    {
        return short_description;
    }
//    public String getDescription()
//    {
//        return description;
//    }

}


