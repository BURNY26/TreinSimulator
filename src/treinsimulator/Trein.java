/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treinsimulator;

/**
 *
 * @author Bernard
 */
//Trein houdt geen statistische gegevens bij en mogen bij aankomst verdwijnen uit het systeem
//Trein wordt geïdentificeerd door een combinatie van de lijn ,richting en zijn vertrekuur
public class Trein {

//vtijd geeft aan op welk tijdstip de volgende gebeurtenis plaatsvindt
    String vtijd;
    String vertrekuur;
    Lijn l;
    //richting kan oftewel 'A' of 'B' zijn 
    //A ,van voor naar achter in de lijst van stations. B vice versa
    char richting;
    
    public Trein(){
        
    }
    
    public Trein(Lijn l, char r, String vertrekuur){
        this.l = l;
        richting = r;
        this.vertrekuur = vertrekuur;
    }
}


//opmerking: is richting hier niet overbodig want het zit eigelijk al in de var. l ?
