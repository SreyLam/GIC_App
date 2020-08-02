package com.example.drawnavigation.model;

public class ScholarshipModel {
    String id;
    String title ;
    String date;
    String short_description;
//    String description;
    String flag;

    //    String description;
    public ScholarshipModel(String id,String title, String date, String short_description,String flag ) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.short_description = short_description;
        this.flag = flag;
//        this.description = description;

    }

    public String getId()
    {
        return id;
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
    public String getFlag()
    {
        return flag;
    }
//    public String getDescription()
//    {
//        return description;
//    }

}


