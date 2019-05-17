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

    /**
     * Gets the name
     * @return the name as the String
     */
    public String getRepName() {
        return repName;
    }

    /**
     * Gets the position
     * @return the position as a String
     */
    public String getPosition() {
        return position;
    }

    /**
     * Gets the party
     * @return the party as a String
     */
    public String getParty() {
        return party;
    }

    /**
     * Gets the number of years in office
     * @return the number of years in office as a String
     */
    public String getYearsInOffice() {
        return yearsInOffice;
    }

    /**
     * Gets the description
     * @return the description as a String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the source of the image
     * @return the source of the image as a String
     */
    public String getImage() {
        return image;
    }


}
