package com.company;

public class Person {
    private String Nom;
    private String Prenom;
    private int age;


    private String Addresse;
    private int ID;
    String type;

    public  Client() {
    }

    public Client(String name, String addresse, int ID,String t) {
        Name = name;
        Addresse = addresse;
        this.ID = ID;
        if(t.equalsIgnoreCase("guest")){
            this.type="Guest";
        }
        else{
            this.type="Client";
        }

    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAddresse(String addresse) {
        Addresse = addresse;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public String getAddresse() {
        return Addresse;
    }

    public int getID() {
        return ID;
    }
    @Override
    public String toString() {
        return "Client{" +
                "Name='" + Name + '\'' +
                ", Addresse='" + Addresse + '\'' +
                ", ID=" + ID +
                '}';
    }
}
