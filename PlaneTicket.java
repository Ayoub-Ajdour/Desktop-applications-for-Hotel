package com.company;

import java.text.ParseException;
import java.util.Date;

public class PlaneTicket extends Stay{

    private String Reference;

    public PlaneTicket(String name, String addresse, int ID, Date start, Date end,String R,String type) throws ParseException {
        super(name, addresse, ID, start, end,type);
        this.Reference=R;
    }

    public void setReference(String reference) {
        Reference = reference;
    }
    public String getReference() {
        return Reference;
    }

    @Override
    public String toString() {
        return " Reference est " + Reference;
    }

    @Override
    public void CalculatePrice() {

    }



}
