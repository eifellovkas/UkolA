package com.github.eifellovkas.Ukol1.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.github.eifellovkas.Ukol1.logika.Hra;
import com.github.eifellovkas.Ukol1.logika.Slovo;
import com.github.eifellovkas.Ukol1.main.Start;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Controller extends GridPane {
	private Map<String, Slovo> tlacitka;
	private Hra hra;
	private List<Slovo> slovicka;
	private boolean hadani = false;
	
	@FXML private Button	button1;
	@FXML private Button  	button2;
	@FXML private Button  	button3;
	@FXML private Button  	button4;
	@FXML private Button  	button5;
	@FXML private Button  	button6;
	@FXML private Tooltip  	tooltip1;
	@FXML private Tooltip  	tooltip2;
	@FXML private Tooltip  	tooltip3;
	@FXML private Tooltip  	tooltip4;
	@FXML private Tooltip  	tooltip5;
	@FXML private Tooltip  	tooltip6;
	@FXML private ImageView  	obr1;
	@FXML private ImageView  	obr2;
	@FXML private ImageView 	obr3;
	@FXML private ImageView 	obr4;
	@FXML private ImageView		obr5;
	@FXML private ImageView  	obr6;
	@FXML private Button  	hadej;
	@FXML private TextArea	textVystup;

	
	public void odesliPrikaz() {
		textVystup.clear();
		String odpoved = 	"Správně: " + hra.getDobre() + "\n" +
							"Špatně: " + hra.getSpatne();
		textVystup.appendText(odpoved);
	}
	
public void inicializuj(Hra hra, Start start) {
	this.hra = hra;
	tlacitka = new HashMap<String, Slovo>();
	slovicka = hra.getSlovicka();
	
	tlacitka.put(button1.getId(), slovicka.get(0));
	String URL = slovicka.get(0).getURL();
	Image obr = new Image (getClass().getResourceAsStream(URL));
	obr1.setImage(obr);
	tooltip1.setText(tlacitka.get("button1").getNazevCz());
	
	tlacitka.put(button2.getId(), slovicka.get(1));
	URL = slovicka.get(1).getURL();
	obr = new Image (getClass().getResourceAsStream(URL));
	obr2.setImage(obr);
	tooltip2.setText(tlacitka.get("button2").getNazevCz());
	
	tlacitka.put(button3.getId(), slovicka.get(2));
	URL = slovicka.get(2).getURL();
	obr = new Image (getClass().getResourceAsStream(URL));
	obr3.setImage(obr);
	tooltip3.setText(tlacitka.get("button3").getNazevCz());
	
	tlacitka.put(button4.getId(), slovicka.get(3));
	URL = slovicka.get(3).getURL();
	obr = new Image (getClass().getResourceAsStream(URL));
	obr4.setImage(obr);
	tooltip4.setText(tlacitka.get("button4").getNazevCz());
	
	tlacitka.put(button5.getId(), slovicka.get(4));
	URL = slovicka.get(4).getURL();
	obr = new Image (getClass().getResourceAsStream(URL));
	obr5.setImage(obr);
	tooltip5.setText(tlacitka.get("button5").getNazevCz());
	
	tlacitka.put(button6.getId(), slovicka.get(5));
	URL = slovicka.get(5).getURL();
	obr = new Image (getClass().getResourceAsStream(URL));
	obr6.setImage(obr);
	tooltip6.setText(tlacitka.get("button6").getNazevCz());
	
}
	@FXML public void clickHadej(ActionEvent arg0) {
		if (!hadani) {
			hra.vyberSlovo();
			String slovo = hra.getHadane();
			hadej.setText(slovo);
			hadani = true;
		}
	}
	
	@FXML public void hadej(ActionEvent arg0) {
		if (hadani) {
			String hadane = ((Node) arg0.getTarget()).getId();
			hadane = tlacitka.get(hadane).getNazevEn();
			if (hadej.getText().equals(hadane)) {
				hra.setSkore(hadane);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Výsledek hádání");
				alert.setHeaderText(null);
				alert.setContentText("Správně!");
				alert.showAndWait();
			}
			else 
			{	
				hra.setSkore(hadane);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Výsledek");
				alert.setHeaderText("Špatně!");
				alert.showAndWait();
			}
		hadani = false;
		hadej.setText("hádej");
		this.odesliPrikaz();
		}
	}
	
}
	


