package com.company;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.Vector;
public class voyage implements Serializable {
    enum RoomType {Single, Double, Family};


    //Vector HotelB = new Vector();
    private String Name;
    private String Addresse;
    private int ID;
    private int NumRoom = 0;
    private static String Start;
    private static String End;
    private String R;
    private Boolean Smoking;
    private static Boolean a;
    private static int cntr=0;

    private static int roomSmS = 46;
    private static int roomSmSG = 70;
    private static int roomSmD = 51;
    private static int roomSmDG = 75;
    private static int roomSmF = 56;
    private static int roomSmFG = 78;
    private static int roomNSMS = 7;
    private static int roomNSMSG = 60;
    private static int roomNSMD = 16;
    private static int roomNSMDG = 65;
    private static int roomNSMF = 31;
    private static int roomNSMFG = 68;
    private static Vector<HotelBooking> e = new Vector<HotelBooking>();
    private static Vector<PlaneTicket> ee = new Vector<PlaneTicket>();
    private static Vector<Client> eee=new Vector<Client>();



    public voyage(String name, String addresse, int ID, String start, String end, String r, Boolean smoking,String CorG) throws ParseException {
        //Vector<HotelBooking> e = new Vector<HotelBooking>();
        a = false;
        Name = name;
        Addresse = addresse;
        this.ID = ID;
        // Start = start;
        //End = end;
        R = r;
        Smoking = smoking;

        Date Datectuele = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date Deb = sdf.parse(start);
        Date Fin = sdf.parse(end);


        Deb.setYear(Deb.getYear());
        Deb.setMonth(Deb.getMonth() + 1);
        Deb.setDate(Deb.getDay() - 8);

        Fin.setYear(Fin.getYear());
        Fin.setMonth(Fin.getMonth() + 1);
        Fin.setDate(Fin.getDay() - 8);


        // Calcule la differance de time actuelle et time de début
        long diff1 = Deb.getTime() - Datectuele.getTime();
        TimeUnit time1 = TimeUnit.DAYS;
        diff1 = time1.convert(diff1, TimeUnit.MILLISECONDS);

        // Calcule differance de time END et time Start
        long diff2 = Fin.getTime() - Deb.getTime();
        TimeUnit time2 = TimeUnit.DAYS;
        diff2 = time2.convert(diff2, TimeUnit.MILLISECONDS);

        if (diff2 <= 0 || diff1 < 0) {
            if (diff1 < 0) {
                System.out.println("La date que vous avez ajouté est depaser !");
            } else {
                System.out.println("La durée entre ces deux times est impossible !!!!");
            }
        } else {
            if(CorG.equalsIgnoreCase("client")){


                if (R.equals("Single")) {
                    if (smoking == false && roomNSMS < 16) {
                        NumRoom = roomNSMS++;
                        a = true;


                    } else if (smoking == true && roomSmS < 51) {


                        NumRoom = roomSmS++;
                        a = true;

                    } else {
                        System.out.println("Les chambres de type " + R + " sont complaites ");
                        a = false;

                    }
                } else if (R.equals("Double")) {
                    if (smoking == false && roomNSMD < 31) {
                        NumRoom = roomNSMD++;
                        a = true;
                    } else if (smoking == true && roomSmD < 56) {
                        NumRoom = roomSmD++;
                        a = true;

                    } else {
                        System.out.println("Les chambres de type " + R + " sont complaites ");
                        a = false;

                    }

                } else if (R.equals("Family")) {
                    if (smoking == false && roomNSMF < 46) {
                        NumRoom = roomNSMF++;
                        a = true;

                    } else if (smoking == true && roomSmF < 61) {
                        NumRoom = roomSmF++;
                        a = true;

                    } else {
                        System.out.println("Les chambres de type " + R + " sont complaites ");
                        a = false;

                    }
                } else {
                    System.out.println("Veuillez écrit un de ces type là  SVP {Single / Double / Family}");
                    a = false;
                }

            }
            else
            {

                if (R.equals("Single")) {
                    if (smoking == false && roomNSMSG <65) {
                        NumRoom = roomNSMSG++;
                        a = true;


                    } else if (smoking == true && roomSmSG < 75) {


                        NumRoom = roomSmSG++;
                        a = true;

                    } else {
                        System.out.println("Les chambres de type " + R + " sont complaites ");
                        a = false;

                    }
                } else if (R.equals("Double")) {
                    if (smoking == false && roomNSMDG < 68) {
                        NumRoom = roomNSMD++;
                        a = true;
                    } else if (smoking == true && roomSmDG < 78) {
                        NumRoom = roomSmDG++;
                        a = true;

                    } else {
                        System.out.println("Les chambres de type " + R + " sont complaites ");
                        a = false;

                    }

                } else if (R.equals("Family")) {
                    if (smoking == false && roomNSMFG < 70) {
                        NumRoom = roomNSMFG++;
                        a = true;

                    } else if (smoking == true && roomSmFG < 80) {
                        NumRoom = roomSmFG++;
                        a = true;

                    } else {
                        System.out.println("Les chambres de type " + R + " sont complaites ");
                        a = false;

                    }
                } else {
                    System.out.println("Veuillez écrit un de ces type là  SVP {Single / Double / Family}");
                    a = false;
                }
            }
        }


        if (a) {
            HotelBooking h=new HotelBooking(name, addresse, ID, Deb, Fin, R, smoking, NumRoom,false,CorG);
            e.addElement(h);
            e.elementAt(cntr).CalculatePrice();
            cntr++;
        }


    }
    public voyage(String name, String addresse, int ID, String start, String end, String r, Boolean smoking,String CorG,String PlaneTickett) throws ParseException {
        //Vector<HotelBooking> e = new Vector<HotelBooking>();
        a = false;
        Name = name;
        Addresse = addresse;
        this.ID = ID;
        // Start = start;
        //End = end;
        R = r;
        Smoking = smoking;

        Date Datectuele = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date Deb = sdf.parse(start);
        Date Fin = sdf.parse(end);


        Deb.setYear(Deb.getYear());
        Deb.setMonth(Deb.getMonth() + 1);
        Deb.setDate(Deb.getDay() - 8);

        Fin.setYear(Fin.getYear());
        Fin.setMonth(Fin.getMonth() + 1);
        Fin.setDate(Fin.getDay() - 8);


        // Calcule la differance de time actuelle et time de début
        long diff1 = Deb.getTime() - Datectuele.getTime();
        TimeUnit time1 = TimeUnit.DAYS;
        diff1 = time1.convert(diff1, TimeUnit.MILLISECONDS);

        // Calcule differance de time END et time Start
        long diff2 = Fin.getTime() - Deb.getTime();
        TimeUnit time2 = TimeUnit.DAYS;
        diff2 = time2.convert(diff2, TimeUnit.MILLISECONDS);

        // System.out.println(diff1+"\t"+diff2);
        // System.out.println(diff1 +"\t"+diff2 + "\n" +Deb+"\t"+Fin+"\t"+Datectuele);
        if (diff2 <= 0 || diff1 < 0) {
            if (diff1 < 0) {
                System.out.println("La date que vous avez ajouté est depaser !");
            } else {
                System.out.println("La durée entre ces deux times est impossible !!!!");
            }
        } else {
            if (R.equals("Single")) {
                if (smoking == false && roomNSMS < 16) {
                    NumRoom = roomNSMS++;
                    a = true;


                } else if (smoking == true && roomSmS < 51) {


                    NumRoom = roomSmS++;
                    a = true;

                } else {
                    System.out.println("Les chambres de type " + R + " sont complaites ");
                    a = false;

                }
            } else if (R.equals("Double")) {
                if (smoking == false && roomNSMD < 31) {
                    NumRoom = roomNSMD++;
                    a = true;
                } else if (smoking == true && roomSmD < 56) {
                    NumRoom = roomSmD++;
                    a = true;

                } else {
                    System.out.println("Les chambres de type " + R + " sont complaites ");
                    a = false;

                }

            } else if (R.equals("Family")) {
                if (smoking == false && roomNSMF < 46) {
                    NumRoom = roomNSMF++;
                    a = true;

                } else if (smoking == true && roomSmF < 61) {
                    NumRoom = roomSmF++;
                    a = true;

                } else {
                    System.out.println("Les chambres de type " + R + " sont complaites ");
                    a = false;

                }
            } else {
                System.out.println("Veuillez écrit un de ces type là  SVP {Single / Double / Family}");
                a = false;
            }

        }


        if (a) {
            PlaneTicket p=new PlaneTicket(name,PlaneTickett,ID,Deb,Fin,PlaneTickett,CorG);
            HotelBooking h=new HotelBooking(name, addresse, ID, Deb, Fin, R, smoking, NumRoom,true,CorG);
            ee.addElement(p);
            e.addElement(h);
            e.elementAt(cntr).CalculatePrice();
            cntr++;
        }


    }



    @Override
    public String toString() {
        String a="";
        int j=0;
        for(int i=0;i<e.size();i++)
        {
            a=a+"\n"+e.elementAt(i).toString();
            if(e.elementAt(i).o==true){
                a=a+"\n"+ee.elementAt(j).toString();
                j++;
            }
            a+="\n__________________________________________________________________________________________________\n";
        }

        return a;
    }
}

