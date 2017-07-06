package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class VBOX_Import_EtappenFahrerTeams {
	public static VBox vbox_Import_EtappenFahrerTeams() {

		VBox vbox_Import_EtappenFahrerTeams = new VBox();
		VBox vbox_Import_EtappenFahrerTeams_LiveData = new VBox();
		VBox vbox_Import_EtappenFahrerTeams_TestData = new VBox();

		ToggleGroup tg_DataImport = new ToggleGroup();
		RadioButton rb_TestDataImport = new RadioButton("Testdaten importieren");
		RadioButton rb_LiveDataImport = new RadioButton("Livedaten importieren");
		rb_LiveDataImport.setToggleGroup(tg_DataImport);
		rb_TestDataImport.setToggleGroup(tg_DataImport);

		vbox_Import_EtappenFahrerTeams.getChildren().addAll(rb_LiveDataImport, rb_TestDataImport);

		// JavaFX FÜR DIE EINGABE VON TESTDATEN
		VBox vbox_chooseEtappenCSV = new VBox();
		Label lb_chooseEtappenCSV = new Label("Wählen Sie die CSV-Datei für den Import der Etappen:");
		HBox hbox_directoryEtappen = new HBox();
		Button bt_chooseDirectoryEtappen = new Button("Durchsuchen...");
		TextField tf_directoryEtappen = new TextField();
		hbox_directoryEtappen.getChildren().addAll(bt_chooseDirectoryEtappen, tf_directoryEtappen);
		vbox_chooseEtappenCSV.getChildren().addAll(lb_chooseEtappenCSV, hbox_directoryEtappen);
		VBox vbox_chooseFahrerCSV = new VBox();
		Label lb_chooseFahrerCSV = new Label("Wählen Sie die CSV-Datei für den Import der Fahrer:");
		HBox hbox_directoryFahrer = new HBox();
		Button bt_chooseDirectoryFahrer = new Button("Durchsuchen...");
		TextField tf_directoryFahrer = new TextField();
		hbox_directoryFahrer.getChildren().addAll(bt_chooseDirectoryFahrer, tf_directoryFahrer);
		vbox_chooseFahrerCSV.getChildren().addAll(lb_chooseFahrerCSV, hbox_directoryFahrer);
		VBox vbox_chooseTeamsCSV = new VBox();
		Label lb_chooseTeamsCSV = new Label("Wählen Sie die CSV-Datei für den Import der Teams:");
		HBox hbox_directoryTeams = new HBox();
		Button bt_chooseDirectoryTeams = new Button("Durchsuchen...");
		TextField tf_directoryTeams = new TextField();
		hbox_directoryTeams.getChildren().addAll(bt_chooseDirectoryTeams, tf_directoryTeams);
		vbox_chooseTeamsCSV.getChildren().addAll(lb_chooseTeamsCSV, hbox_directoryTeams);
		vbox_Import_EtappenFahrerTeams_TestData.getChildren().addAll(vbox_chooseEtappenCSV, vbox_chooseFahrerCSV,
				vbox_chooseTeamsCSV);

		// JavaFX FÜR DIE EINGABEN VON LIVEDATEN
		VBox vbox_chooseEtappenCSV_live = new VBox();
		Label lb_chooseEtappenCSV_live = new Label("Geben Sie die URL der CSV-Datei für den Import der Etappen an:");
		TextField tf_directoryetappenCSV_live = new TextField();
		vbox_chooseEtappenCSV_live.getChildren().addAll(lb_chooseEtappenCSV_live, tf_directoryetappenCSV_live);

		VBox vbox_chooseFahrerCSV_live = new VBox();
		Label lb_chooseFahrerCSV_live = new Label("Geben Sie die URL der CSV-Datei für den Import der Fahrer an:");
		TextField tf_directoryFahrerCSV_live = new TextField();
		vbox_chooseFahrerCSV_live.getChildren().addAll(lb_chooseFahrerCSV_live, tf_directoryFahrerCSV_live);

		VBox vbox_chooseTeamsCSV_live = new VBox();
		Label lb_chooseTeamsCSV_live = new Label("Geben Sie die URL der CSV-Datei für den Import der Teams an:");
		TextField tf_directoryTeamsCSV_live = new TextField();
		vbox_chooseTeamsCSV_live.getChildren().addAll(lb_chooseTeamsCSV_live, tf_directoryTeamsCSV_live);
		vbox_Import_EtappenFahrerTeams_LiveData.getChildren().addAll(vbox_chooseEtappenCSV_live,
				vbox_chooseFahrerCSV_live, vbox_chooseTeamsCSV_live);

		vbox_Import_EtappenFahrerTeams.getChildren().add(vbox_Import_EtappenFahrerTeams_TestData);
		vbox_Import_EtappenFahrerTeams.getChildren().add(vbox_Import_EtappenFahrerTeams_LiveData);
		vbox_Import_EtappenFahrerTeams_LiveData.setVisible(false);
		vbox_Import_EtappenFahrerTeams_TestData.setVisible(false);

		// Button um den Import zu starten
		Button bt_executeImport = new Button("Daten importieren");
		vbox_Import_EtappenFahrerTeams.getChildren().add(bt_executeImport);
		vbox_Import_EtappenFahrerTeams.setMinSize(800, 400);

		rb_LiveDataImport.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				vbox_Import_EtappenFahrerTeams_LiveData.setVisible(true);
				vbox_Import_EtappenFahrerTeams_TestData.setVisible(false);
			}
		});

		rb_TestDataImport.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				vbox_Import_EtappenFahrerTeams_TestData.setVisible(true);
				vbox_Import_EtappenFahrerTeams_LiveData.setVisible(false);
			}
		});

		bt_chooseDirectoryEtappen.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				tf_directoryEtappen.setText(DatabaseFunctions.openFileChooser());
			}
		});

		bt_chooseDirectoryFahrer.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				tf_directoryFahrer.setText(DatabaseFunctions.openFileChooser());
			}
		});

		bt_chooseDirectoryTeams.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				tf_directoryTeams.setText(DatabaseFunctions.openFileChooser());
			}
		});

		bt_executeImport.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (rb_TestDataImport.isSelected() == true) {
					try {
						DatabaseFunctions.importFromCSV(tf_directoryEtappen.getText(), "etappen");
						DatabaseFunctions.importFromCSV(tf_directoryFahrer.getText(), "fahrer");
						DatabaseFunctions.importFromCSV(tf_directoryTeams.getText(), "teams");

						Alert al_ImportSuccessful = new Alert(Alert.AlertType.INFORMATION, "Import erfolgreich.",
								ButtonType.OK);
						al_ImportSuccessful.setTitle("Hinweis");
						al_ImportSuccessful.show();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

				if (rb_LiveDataImport.isSelected() == true) {
					try {
						DatabaseFunctions.importFromCSV(tf_directoryetappenCSV_live.getText(), "etappen");
						DatabaseFunctions.importFromCSV(tf_directoryFahrerCSV_live.getText(), "fahrer");
						DatabaseFunctions.importFromCSV(tf_directoryTeamsCSV_live.getText(), "teams");

						Alert al_ImportSuccessful = new Alert(Alert.AlertType.INFORMATION, "Import erfolgreich.",
								ButtonType.OK);
						al_ImportSuccessful.setTitle("Hinweis");
						al_ImportSuccessful.show();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		return vbox_Import_EtappenFahrerTeams;

	}
}
