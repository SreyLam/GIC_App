package com.example.drawnavigation.model;

public class PartnershipModel {
    String name ;
    String logo;
//    String website;


    public PartnershipModel(String name, String logo) {
//        this.id = id;
        this.name = name;
        this.logo = logo;
//        this.website = website;

    }

    public String getName()
    {
        return name;
    }

    public String getLogo() { return logo; }
//    public String getWebsite() { return website; }


}



