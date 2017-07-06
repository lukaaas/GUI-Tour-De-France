package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FunctionsWindow {
	public static void createFunctionsWindow() {
		Stage primaryStage = new Stage();
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 800, 500);
		scene.getStylesheets().add("application.css");
		Image image = new Image("file:background.jpg");
		ImageView view = new ImageView();
		view.setImage(image);
		view.setFitHeight(500);
		view.setFitWidth(800);
		root.getChildren().add(view);

		// Neue VBox f�r die Men�bar
		VBox vbox = new VBox();
		vbox.setMinWidth(800);
		
		// Neue Men�bar anlegen
		MenuBar menuBar = new MenuBar();
		menuBar.setMinWidth(800);

		// Erster Men�punkt: Tabellen
		Menu mn_Tables = new Menu("Tabellen");
		// Auswahlpunkt: Tabellen anlegen
		MenuItem mn_Tables_TabellenAnlegen = new MenuItem("Tabellen anlegen");
		mn_Tables.getItems().add(mn_Tables_TabellenAnlegen);

		// Zweiter Men�punkt: Import
		Menu mn_Import = new Menu("Import");
		// Auswahlpunkt f�r User/Tipps-Import
		MenuItem submenu_import_UserUndTipps = new MenuItem("User und Tipps importieren");
		// Auswahlpunkt f�r Fahrer/Teams/Etappen
		MenuItem submenu_import_FahrerTeamsEtappen = new MenuItem("Fahrer, Teams und Etappen importieren");
		// Die Auswahlpunkte dem Men� hinzuf�gen
		mn_Import.getItems().addAll(submenu_import_UserUndTipps, submenu_import_FahrerTeamsEtappen);

		// Dritter Men�punkt: Ergebnisse
		Menu mn_Ergebnisse = new Menu("Ergebnisse");
		// Auswahlpunkt f�r die Eingabe von Ergebnissen
		MenuItem submenu_ErgebnisseEingeben = new MenuItem("Ergebnisse eingeben");
		// Auswahlpunkt f�r die Ausgabe der Ergebnisse
		MenuItem submenu_ErgebnisseAusgeben = new MenuItem("Ergebnisse ausgeben");
		// Die Auswahlpunkte dem Men� hinzuf�gen
		mn_Ergebnisse.getItems().addAll(submenu_ErgebnisseEingeben, submenu_ErgebnisseAusgeben);

		// Vierter Men�punkt: Ranking
		Menu mn_Ranking = new Menu("Ranking");
		// Auswahlpunkt f�r das Erstellen des Rankings
		MenuItem mn_RankingErstellen = new MenuItem("Ranking erstellen");
		// Auswahlpunkt f�r das Ausgeben des Rankings
		MenuItem mn_RankingAusgeben = new MenuItem("Ranking ausgeben");
		// Auswahlpunkte dem Men� hinzuf�gen
		mn_Ranking.getItems().addAll(mn_RankingErstellen, mn_RankingAusgeben);

		// F�nfter Men�punkt: Teamwertung
		Menu mn_Teamwertung = new Menu("Teamwertung");
		// Auswahlpunkt zur Ausgabe der Teamwertung
		MenuItem mn_TeamwertungAusgeben = new MenuItem("Teamwertung ausgeben");
		// Auswahlpunkt dem Men� hinzuf�gen
		mn_Teamwertung.getItems().add(mn_TeamwertungAusgeben);

		// Sechster Men�punkt: Etappenplan
		Menu mn_Etappenplan = new Menu("Etappenplan");
		// Auswahlpunkt zur Ausgabe des Etappenplans
		MenuItem submenu_EtappenplanAusgeben = new MenuItem("Etappenplan ausgeben");
		// Auswahlpunkt dem Men� hinzuf�gen
		mn_Etappenplan.getItems().add(submenu_EtappenplanAusgeben);

		// Alle F�nf Hauptmen�s der Men�bar hinzuf�gen
		menuBar.getMenus().addAll(mn_Tables, mn_Import, mn_Ergebnisse, mn_Ranking, mn_Teamwertung, mn_Etappenplan);

		// Die Men�bar der VBox hinzuf�gen
		vbox.getChildren().add(menuBar);

		root.getChildren().add(vbox);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Datenbankfunktionen");
		primaryStage.show();

		// Funktion zum Reiter "Tabellen Anlegen"
		mn_Tables_TabellenAnlegen.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				DatabaseFunctions.createNewTables();
			}
		});

		// Funktion zum Reiter "User und Tipps importieren"
		submenu_import_UserUndTipps.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (vbox.getChildren().size() >= 2)
					vbox.getChildren().remove(1);
				vbox.getChildren().add(VBOX_Import_UserTipps.vbox_Import_UserTipps());
			}
		});

		submenu_import_FahrerTeamsEtappen.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (vbox.getChildren().size() >= 2)
					vbox.getChildren().remove(1);
				vbox.getChildren().add(VBOX_Import_EtappenFahrerTeams.vbox_Import_EtappenFahrerTeams());
			}
		});

		mn_Etappenplan.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				StageWindow.createFunctionsWindow();
			}
		});

	}

}
