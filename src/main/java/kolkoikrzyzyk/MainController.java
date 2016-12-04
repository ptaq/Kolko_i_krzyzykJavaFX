package kolkoikrzyzyk;



import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import javafx.scene.paint.Color;


/**
 * Created by ptaq on 30.11.2016.
 */
public class MainController {

    @FXML                    //wstrzykniecie poszczegolnych labeli na ktorych bedzie wyswietlane X albo O
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private Label l4;
    @FXML
    private Label l5;
    @FXML
    private Label l6;
    @FXML
    private Label l7;
    @FXML
    private Label l8;
    @FXML
    private Label l9;
    @FXML
    private Label koniec;  //element łączący model z controllerem. Za jakego pomocą steruje zakonczenie grą
                           //w widoku nie jest widoczny, jego rozmiar to 0

    private Model model = new Model();              //utworzenie instancji klas Model




    @FXML
    public void initialize() {


        model.nowaGra();

       Label label[] = {l1,l2,l3,l4,l5,l6,l7,l8,l9};                 //zgrupowanie wszystkich wstrzyknietych labeli w tablie

        int i = 0;
        for(Label x:label){                                          //bindowanie tablicy label z lista Propertisow z klasy Model
            x.textProperty().bindBidirectional(model.plansza.get(i));
            i++;
        }

        koniec.textProperty().bindBidirectional(model.wygranaProperty());          //zbindowanie niewidocznego labela koniec z StringProperty wygrana w kklasie Model

        koniec.textProperty().addListener((observable, oldValue, newValue) -> {           //nalozenie listenera na niewidoczny label
            if (newValue.equals("remis")) {                                               //dzieki niemu mozna uaktualniac dane w kontrolerze
                for (Label x : label) x.setDisable(true);                                 //w zaleznosci od wartosci neWValue jest podejmowana konkretna akcja
            } else if (newValue.equals("") == false) {
                label[Character.getNumericValue(newValue.charAt(0))].setTextFill(Color.RED);
                label[Character.getNumericValue(newValue.charAt(1))].setTextFill(Color.RED);
                label[Character.getNumericValue(newValue.charAt(2))].setTextFill(Color.RED);
                for (Label x : label) x.setDisable(true);

            }
        });

        if(l1.isDisable()==true)for(Label x:label){              //jesli pierwszy z guzikow jest Disable to oznacza ze gra jest
            x.setDisable(false);                                 //uruchomiona od nowa i trzeba wlaczyc wszystkie guziki oraz
            x.setTextFill(Color.BLACK);                          //zmienic czionke spowrotem na black
        }



}


    public void onCickMouse(MouseEvent e){                       //metoda obslugujca klikniecie myszy w dany label
        Label label = (Label) e.getSource();                     //zamiana obieku e na obiek typu Label
        String id = label.getId();                               //uzyskanie id konkretnego kliknietegoa labela

        switch(id){                                              //w zalesnosci od wartosci zmiennej id zmiennej KtorePole z klasy Model
            case "l1":                                           //przypisywana jest konkretna wartosc
                model.setKtorePole(0);
                break;
            case "l2":
                model.setKtorePole(1);
                break;
            case "l3":
                model.setKtorePole(2);
                break;
            case "l4":
                model.setKtorePole(3);
                break;
            case "l5":
                model.setKtorePole(4);
                break;
            case "l6":
                model.setKtorePole(5);
                break;
            case "l7":
                model.setKtorePole(6);
                break;
            case "l8":
                model.setKtorePole(7);
                break;
            case "l9":
                model.setKtorePole(8);
                break;
        }
        model.graj();                  //uruchomienie moetody graj z klasy MOdel








    }





    public void onClickExit(ActionEvent actionEvent) {            //metoda obsluguje wyjscie z gornego menu
        Platform.exit();
        System.exit(0);
    }

    public void onClickNewGame(ActionEvent actionEvent) {         //metoda resetujaca gre

        initialize();

    }
}







