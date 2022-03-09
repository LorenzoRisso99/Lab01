package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private TextArea txtVelocita;
    
    @FXML
    private Button btnCancella;
    
    long inizio;
    long fine;
    

    @FXML
    void doInsert(ActionEvent event) {
    	inizio = System.nanoTime();
    	String parola = txtParola.getText();
    	elenco.addParola(parola);
    	txtResult.setText(elenco.getElenco().toString());
    	txtParola.clear();
    	fine = System.nanoTime();
    	txtVelocita.setText("Tempo : " + (inizio-fine)/1e9);
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	inizio = System.nanoTime();
    	txtResult.clear();
    	txtParola.clear();
    	elenco.reset();
    	fine = System.nanoTime();
    	txtVelocita.setText("Tempo : " + (inizio-fine)/1e9);
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	inizio = System.nanoTime();
    	elenco.cancellaParola(txtResult.getSelectedText());
    	txtResult.setText(elenco.getElenco().toString());
    	fine = System.nanoTime();
    	txtVelocita.setText("Tempo : " + (inizio-fine)/1e9);
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
