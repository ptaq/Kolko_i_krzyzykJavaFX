package kolkoikrzyzyk;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

/**
 * Created by ptaq on 30.11.2016.
 */
public class Model {

    final private String KRZYZYK = "X";             //Stała łańcuchowa o wartosci X oraz O
    final private String KOLKO = "O";

    private ArrayList<StringProperty> plansza;              //referencja do ArrayList zawierajacej dane typu StringProperty
    private int ktorePole;                          //zmienna do ktorej przekazywane jest klikniete pole z metody onCickMouse z klasy kontrolera
    private String aktualnyGracz;                   //ktory kracz aktualnie wykonuje ruch X albo O
    private int wolnePole;                          //zmienna okreslajaca ile jest jeszcze wolnych pol do klikniecia

    private StringProperty wygrana;                 //propertis sluzacy do obslugi metody wygrana. Powiazany z label koniec w klasie kontrolera


    public void nowaGra() {                           //nadanie wartosci poczatkowych zmiennym potrzebnym do gry


        ArrayList<StringProperty> y = new ArrayList<>();
        for (int i = 0; i < 9; i++) y.add(new SimpleStringProperty(""));


        aktualnyGracz = KRZYZYK;
        setPlansza(y);
        wolnePole = 9;
        wygrana = new SimpleStringProperty("");


    }

    public void graj() {                                    //glowa metoda obslugujaca rozgrywke

        if (wolnePole == 0) System.out.println("REMIS");
        else if (plansza.get(ktorePole).getValue() == "") {
            plansza.get(ktorePole).setValue(aktualnyGracz);

            wolnePole--;
            wygrana();
            if (aktualnyGracz == KRZYZYK) aktualnyGracz = KOLKO;
            else aktualnyGracz = KRZYZYK;

        }
    }

    private void wygrana() {          //metoda sprawdzajaca czy rozgrywka zakonczya sie poprzez wygrana jednego z graczy czy przez brak wolnych pol


        if (plansza.get(0).getValue().equals(aktualnyGracz) && plansza.get(1).getValue().equals(aktualnyGracz) && plansza.get(2).getValue().equals(aktualnyGracz))
            wygrana.setValue("012");     //nadaje zmiennej StringProperty odpowiednia wartosc a ta poprzez zboindowanei przekazuje je do labela koniec w klasie kontrolera
            //Label koniec ma nalozony listener ktory obsluguje zmiany wystepujace w wartosci ktore przechowuje. W zależnosci od wariantu wygranej
            //przekazuje string z konkretnymi danymi, ktore sa obslugiwane w listenerze.
        else if (plansza.get(3).getValue().equals(aktualnyGracz) && plansza.get(4).getValue().equals(aktualnyGracz) && plansza.get(5).getValue().equals(aktualnyGracz))
            wygrana.setValue("345");

        else if (plansza.get(6).getValue().equals(aktualnyGracz) && plansza.get(7).getValue().equals(aktualnyGracz) && plansza.get(8).getValue().equals(aktualnyGracz))
            wygrana.setValue("678");

        else if (plansza.get(0).getValue().equals(aktualnyGracz) && plansza.get(3).getValue().equals(aktualnyGracz) && plansza.get(6).getValue().equals(aktualnyGracz))
            wygrana.setValue("036");

        else if (plansza.get(1).getValue().equals(aktualnyGracz) && plansza.get(4).getValue().equals(aktualnyGracz) && plansza.get(7).getValue().equals(aktualnyGracz))
            wygrana.setValue("147");

        else if (plansza.get(2).getValue().equals(aktualnyGracz) && plansza.get(5).getValue().equals(aktualnyGracz) && plansza.get(8).getValue().equals(aktualnyGracz))
            wygrana.setValue("258");

        else if (plansza.get(2).getValue().equals(aktualnyGracz) && plansza.get(4).getValue().equals(aktualnyGracz) && plansza.get(6).getValue().equals(aktualnyGracz))
            wygrana.setValue("246");

        else if (plansza.get(0).getValue().equals(aktualnyGracz) && plansza.get(4).getValue().equals(aktualnyGracz) && plansza.get(8).getValue().equals(aktualnyGracz))
            wygrana.setValue("048");

        else if (wolnePole == 0) wygrana.setValue("remis");
    }

    public void setPlansza(ArrayList<StringProperty> plansza) {
        this.plansza = plansza;
    }

    public void setKtorePole(int ktorePole) {
        this.ktorePole = ktorePole;
    }


    public StringProperty wygranaProperty() {
        return wygrana;
    }

    public ArrayList<StringProperty> getPlansza() {
        return plansza;
    }
}
