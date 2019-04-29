package com.example.appsforgood;

import android.widget.ImageButton;

public class RepObject {

    //Data
    private String repName;
    private String position;
    private String party;
    private String yearsInOffice;
    private String description;
    private String image;

    //Constructors
    public RepObject(String repName, String position, String party, String yearsInOffice, String description,String image) {
        this.repName = repName;
        this.position = position;
        this.party = party;
        this.yearsInOffice = yearsInOffice;
        this.description = description;
        this.image = image;
    }

    //Methods

    public String getrepName() {

        return repName;
    }

    public String getposition() {

        return position;
    }

    public String getparty() {

        return party;
    }

    public String getyearsInOffice() {

        return yearsInOffice;
    }

    public String getDescription() {

        return description;
    }

    public String getImage() {

        return image;
    }


}
