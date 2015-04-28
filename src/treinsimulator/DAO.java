/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treinsimulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bernard
 */
public class DAO {

    private static ArrayList<Station> stationLijst = new ArrayList<>();
    private static ArrayList<Lijn> lijnenLijst = new ArrayList<>();

    public static void readLists() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("stationlijst.ini")));
            String huidig = br.readLine();
            while (!huidig.equals("[Stations]")) {
                huidig = br.readLine();
            }
            huidig=br.readLine();
            while (!huidig.equals("STOP")) {
                if (!huidig.isEmpty() && huidig.charAt(0) != ';') {
                    String currentLine = huidig ;
                    if (currentLine.contains("\\")){
                        currentLine=currentLine.substring(0,currentLine.length()-1);
                        huidig = br.readLine();
                        while (huidig.isEmpty() || huidig.contains(";")){
                            huidig =br.readLine();
                        }
                        currentLine+=huidig;
                    }
                    String[] lines = currentLine.split(" ");
                    stationLijst.add(new Station(lines[0],Integer.parseInt(lines[1])));
                }
                huidig = br.readLine();
            }
            /*while(!huidig.equals("[Reizigers]")){
            
             }
             while()*/
        } catch (FileNotFoundException fnfe) {
            System.out.println("Een .ini bestand is niet gevonden.");
        } catch (IOException io) {
            System.out.println("Probleem met het inlezen van een .ini bestand.");
        }
    }
    
    public static void schrijfStations(){
        for (Station s : stationLijst){
            System.out.println(s.getStadsnaam()+" heeft "+s.getOverstaptijd()+" min overstaptijd.\n");
        }
    }
    
}
