package com.example.drawnavigation.model;

public class ScholarshipModel {
    Integer id;
    String title ;
    String date;
    String short_description;
//    String description;
    String flag;

    //    String description;
    public ScholarshipModel(Integer id,String title, String date, String short_description,String flag ) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.short_description = short_description;
        this.flag = flag;
//        this.description = description;

    }

    public Integer getId()
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


