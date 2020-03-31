package com.example.drawnavigation;

public class DataNote {

    String text;
    String comment;
    String start_date;
    String end_date;
    String imageUrl;

    public DataNote(String text, String start_date, String end_date, String imageUrl)
    {
        this.text = text;
        this.comment = comment;
        this.start_date = start_date;
        this.end_date = end_date;
        this.imageUrl = imageUrl;
    }

    public String getText()
    {
        return text;
    }

    public String getComment()
    {
        return comment;
    }

    public String getStart_date()
    {
        return start_date;
    }

    public String getEnd_date() { return end_date; }

    public String getImageUrl() {
        return imageUrl;
    }
}
