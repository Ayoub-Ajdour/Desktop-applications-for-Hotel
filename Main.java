package com.company;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ParseException, IOException, ClassNotFoundException {
        Scanner s = new Scanner(System.in);
        int GGtest = 0;
        do {
            int Gtest,Gt;
            boolean testPalan_Ticket=false;
            boolean testStay=false;
            do {
                System.out.print(" Taper 1 pour ajouter une nouveau réservation ou 0 pour affichage : ");
                Gtest = s.nextInt();
            } while (Gtest != 1 && Gtest != 0);



            if (Gtest == 1) {
                do {
                    System.out.println(" êtes-vous un guest ? ");
                    System.out.println("1 pour oui | 0 pour non ");
                    Gt = s.nextInt();
                } while (Gt != 1 && Gt != 0);
                System.out.print("Donner votre nom ");
                String nameS = s.next();
                System.out.print("Donner votre ID ");
                int IdS = s.nextInt();
                System.out.print("Donner votre Adresse ");
                String AdresseS = s.next();


                System.out.println("Donner date de debut sous la forme ENGLISH (MM/dd/yyyy)");
                String DebutS = s.next();
                System.out.println("Donner date de fin sous la forme ENGLISH (MM/dd/yyyy)");
                String FinS = s.next();
                int j;
                String statue = null;
                do {
                    System.out.println("Tappez 1 si vous avez Single ou  2 si vous avez Double ou 3 si plus");
                    j = s.nextInt();
                    if (j == 1) {
                        statue = "Single";
                    } else if (j == 2) {
                        statue = "Double";
                    } else if (j == 3) {
                        statue = "Family";
                    } else {
                        System.out.println("Votre choix est hors nos choix");
                    }
                } while (j > 4 || j < 0);
                int z;
                Boolean smokingS;
                do {
                    System.out.println(" Fumes-vous \nif yes print 1 else print 0");
                    z = s.nextInt();
                } while (z != 1 && z != 0);
                if (z == 1) {
                    smokingS = true;
                } else {
                    smokingS = false;
                }
                int a;
                do {
                    System.out.println("Aviez-vous un billet d'avion");
                    System.out.println("if yes print 1 else print 0");
                    a = s.nextInt();
                } while (a != 1 && a != 0);
                voyage v1;
                if (a == 1) {
                    System.out.println("Saisir vovtre reference : ");
                    String Palan_Ticket = s.next();
                    if (Gt == 1) {
                        v1 = new voyage(nameS, AdresseS, IdS, DebutS, FinS, statue, smokingS, "guest", Palan_Ticket);

                    } else {
                        v1 = new voyage(nameS, AdresseS, IdS, DebutS, FinS, statue, smokingS, "client", Palan_Ticket);
                    }
                } else {
                    if (Gt == 1) {
                        v1 = new voyage(nameS, AdresseS, IdS, DebutS, FinS, statue, smokingS, "guest");
                    } else {
                        v1 = new voyage(nameS, AdresseS, IdS, DebutS, FinS, statue, smokingS, "client");
                    }
                }

/*
        voyage test1,test2,test3,test4,test5,test6,test7,test8,test9,test10,test11,test12,test13,test14;
                //TEST GUEST************************************************************************************************************************
                test1=new voyage("Ayoub1","Agadir1",1,"01/23/2022","01/25/2022","Single",true,"guest");
                test2=new voyage("Ayoub2","Agadir2",2,"01/24/2022","01/27/2022","Double",true,"guest");
                test3=new voyage("Ayoub3","Agadir3",3,"01/24/2022","01/27/2022","Family",true,"guest");
                test4=new voyage("Ayoub4","Agadir4",4,"01/24/2022","01/27/2022","Single",false,"guest");
                test5=new voyage("Ayoub5","Agadir5",5,"01/23/2022","01/26/2022","Double",false,"guest");
                test6=new voyage("Ayoub6","Agadir1",6,"01/23/2022","01/25/2022","Family",false,"guest");
                //TEST CLIENT************************************************************************************************************************
                test7=new voyage("Ayoub7","Agadir6",7,"01/23/2022","01/26/2022","Single",true,"client");
                test8=new voyage("Ayoub8","Agadir1",8,"01/23/2022","01/25/2022","Double",true,"client");
                test10=new voyage("Ayoub10","Agadir1",10,"01/23/2022","01/25/2022","Single",false,"client");
                test9=new voyage("Ayoub9","Agadir7",9,"01/23/2022","01/26/2022","Family",true,"client");
                test11=new voyage("Ayoub11","Agadir8",11,"01/23/2022","01/26/2022","Double",false,"client");
                test12=new voyage("Ayoub12","Agadir1",12,"01/23/2022","01/25/2022","Family",false,"client");
                //TEST GUEST************************************************************************************************************************
                test13=new voyage("Ayoub13","Agadir13",15,"01/23/2022","01/26/2022","Single",true,"guest","PARIS");
                test14=new voyage("Ayoub14","Agadir14",14,"01/23/2022","01/25/2022","Double",true,"client","TANGER");
*/
                //// SERISIALISATION

                try {
                    //FileWriter fstream = new FileWriter("A:\\\\projeeect11.txt",true);
                    FileWriter fstream = new FileWriter("A:\\\\p.txt", true);
                    BufferedWriter out = new BufferedWriter(fstream);
                    out.write(v1.toString() + "\n");
                   /* out.write(test1.toString()+"\n");
                    out.write(test2.toString()+"\n");
                    out.write(test3.toString()+"\n");
                    out.write(test4.toString()+"\n");
                    out.write(test5.toString()+"\n");
                    out.write(test5.toString()+"\n");
                    out.write(test6.toString()+"\n");
                    out.write(test7.toString()+"\n");
                    out.write(test8.toString()+"\n");
                    out.write(test9.toString()+"\n");
                    out.write(test10.toString()+"\n");
                    out.write(test11.toString()+"\n");
                    out.write(test12.toString()+"\n");
                    out.write(test13.toString()+"\n");
                    out.write(test14.toString()+"\n");*/
                    out.close();
                } catch (Exception e) {
                    System.err.println("Error while writing to file: " +
                            e.getMessage());
                }
                /*FileOutputStream fos = new FileOutputStream("A:\\projeeect1.txt");
                ObjectOutputStream os = new ObjectOutputStream(fos);
                os.writeObject(v1);
                System.out.println("da5el");
                os.close();*/
                //**  }
                //// DESERIALISATION

               /* try {
                    File myObj = new File("A:\\\\TESTAAT.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        System.out.println(data);
                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            */}
            else {
                try {
                    File myObj = new File("A:\\\\p.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        System.out.println(data);
                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }


                /*FileInputStream FIS = new FileInputStream("A:\\projeeect11.txt");
                ObjectInputStream ois = new ObjectInputStream(FIS);
                voyage P_Affichage = (voyage) ois.readObject();
                P_Affichage.Affichage();
                System.out.println("yes");*/
            }


            System.out.println("Vous voulez sorté ou non ? SI oui tapé 0 sion taper un autre nomrbe");
            GGtest=s.nextInt();
        }while(GGtest!=0);
    }
}
