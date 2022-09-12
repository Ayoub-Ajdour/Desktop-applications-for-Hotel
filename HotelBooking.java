package com.company;
import java.awt.datatransfer.SystemFlavorMap;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

public class HotelBooking extends Stay{
    enum RoomType{Single,Double,Family};
    private int NumRoom;
    private int nbrMAXroom=60;
    private static int roomSmS=46;
    private static int roomSmD=51;
    private static int roomSmF=56;
    private static int roomNSMS=1;
    private static int roomNSMD=16;
    private static int roomNSMF=31;
    private static Date Start;
    private static Date End;
    private long NumNights;
    private RoomType Rec;
    private Boolean Smoking;
    private int prixOfNight;
    private int prixTotale;

    public boolean o;

    //colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    public HotelBooking(String name, String addresse, int ID, Date start, Date end, String rec, Boolean smoking,int Nu,boolean o,String type) throws ParseException {
        super(name, addresse, ID, start, end,type);
        this.o=o;
        this.NumRoom=Nu;
        this.Start = super.getStart();
        this.End = super.getEnd();

        long diff = End.getTime() - Start.getTime();
        TimeUnit time = TimeUnit.DAYS;
        this.NumNights = time.convert(diff, TimeUnit.MILLISECONDS);

        Smoking = smoking;

        if(rec.equals("Single")){
            this.Rec=RoomType.Single;
            this.prixOfNight=100;
          /*if(smoking==false && roomNSMS<16)
            {
                NumRoom=roomNSMS++;
            }
            else if(smoking==true && roomNSMS<51)
            {
                NumRoom=roomSmS++;
            }
            else
            {
                System.out.println("Les chambres de type "+Rec+" est complaite ");
            }*/
        }
        else if(rec.equalsIgnoreCase("Double")){
            this.Rec=RoomType.Double;
            prixOfNight=150;
            /*if(smoking==false && roomNSMD<31)
            {
                NumRoom=roomNSMD++;
            }
            else if(smoking==true && roomSmD<56)
            {
                NumRoom=roomSmD++;
            }
            else
            {
                System.out.println("Les chambres de type "+Rec+" est complaite ");
            }*/
        }
        else if(rec.equalsIgnoreCase("Family"))
        {
            this.Rec= RoomType.Family;
            prixOfNight=250;
            /*if(smoking==false && roomNSMF<46)
            {
                NumRoom=roomNSMF++;
            }
            else if(smoking==true && roomSmF<61)
            {
                NumRoom=roomSmF++;
            }
             else
            {
                System.out.println("Les chambres de type "+Rec+" est complaite ");
            }*/
        }
        else
        {
            System.out.println("Veuillez écrit un de ces type là  SVP {Single / Double / Family}");
        }
        if(getType().equalsIgnoreCase("guest")){
            prixOfNight*=2;
        }

    }


    public void setNumRoom(int numRoom) {
        NumRoom = numRoom;
    }

    public void setStart(Date start) {
        Start = start;
    }

    public void setEnd(Date end) {
        End = end;
    }

    public void setNumNights(int numNights) {
        NumNights = numNights;
    }

    public void setRec(String rec) {
        if(rec.equalsIgnoreCase("Single")){
            this.Rec=RoomType.Single;
            prixOfNight=100;
        }
        else if(rec.equalsIgnoreCase("Double")){
            this.Rec=RoomType.Double;
            prixOfNight=150;
        }
        else if(rec.equalsIgnoreCase("Family"))
        {
            this.Rec= RoomType.Family;
            prixOfNight=250;
        }
        else
        {
            System.out.println("Veuillez écrit un de ces type là  SVP {Single / Double / Family}");
        }
        if(getType().equalsIgnoreCase("guest")){
            prixOfNight*=2;
        }
    }

    public void setSmoking(Boolean smoking) {
        Smoking = smoking;
    }

    public int getNumRoom() {
        return NumRoom;
    }

    public Date getStart() {
        return Start;
    }

    public Date getEnd() {
        return End;
    }

    public long getNumNights() {
        return NumNights;
    }

    public RoomType getRec() {
        return Rec;
    }

    public Boolean getSmoking() {
        return Smoking;
    }

    public double getPrixOfNight() {
        return prixOfNight;
    }

    public void setPrixOfNight(int prixDay) {
        prixOfNight = prixDay;
    }
    public void CalculatePrice() {

    prixTotale= (int) (NumNights*prixOfNight);
    }

    @Override
    public String toString() {
        return "____________________________"+getType()+"_______________________________________________________________\n"+
                " Nom :"+getName()+
                "\t ID=" + getID() +
                "\t Adresse="+getAddresse()+
                "\n Le numéro de votre chambre est [ " + NumRoom +
                " ]\n Start=" + Start +
                ", End=" + End +
                "\n nombre des jours=" + NumNights +
                ", Type de votre chambre [" + Rec +
                "], Smoking=" + Smoking +
                "\t,prix d'une nuit  est : " + prixOfNight +" € "+
                "\n prixTotale est " + prixTotale+" € " ;
    }


}
