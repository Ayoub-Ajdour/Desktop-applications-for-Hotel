package com.company;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
public abstract class Stay extends Client{
    private static Date Start;
    private static Date End;



    public Stay(String name, String addresse, int ID, Date start, Date end,String type) throws ParseException {
        super(name, addresse, ID,type);
         this.Start=start;
         this.End=end;
       /* SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy", Locale.FRENCH);
        Start=sdf.parse(start);
        End=sdf.parse(end);*/

    }

    public Stay(Date start, Date end) {
        Start = start;
        End = end;
    }

    public Date getStart() {
        return Start;
    }

    public Date getEnd() {
        return End;
    }

    public void setStart(Date start) {
        Start = start;
    }

    public void setEnd(Date end) {
        End = end;
    }
    public abstract void CalculatePrice();

    @Override
    public String toString() {
        return "Stay{" +
                "Name="+getName()+
                "Adresse="+getAddresse()+
                "ID=" + getID() +
                ", Start=" + Start +
                ", End=" + End +
                '}';
    }

}
