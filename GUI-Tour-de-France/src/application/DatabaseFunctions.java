package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;

public class DatabaseFunctions {
	public static Connection connectToServer(String ipAdresse, String benutzerName, String passwort) {
		try {
			return DriverManager.getConnection(ipAdresse, benutzerName, passwort);
		} catch (SQLInvalidAuthorizationSpecException e1) {
			Alert al_wrongPassword = new Alert(Alert.AlertType.WARNING, "Benutzername oder Passwort falsch.",
					ButtonType.OK);
			al_wrongPassword.setTitle("Fehler!");
			al_wrongPassword.show();
		} catch (SQLException e) {
			Alert al_connectionFailed = new Alert(Alert.AlertType.ERROR, "Verbindung konnte nicht hergestellt werden.",
					ButtonType.OK);
			al_connectionFailed.setTitle("Fehler!");
			al_connectionFailed.show();
		}
		return null;
	}

	public static void createNewDatabase(Connection conn) {
		try {
			Statement st = conn.createStatement();
			st.execute("drop database if exists tourdefrance2017");
			st.executeQuery("create database tourdefrance2017");
			Alert al_DBCreationSuccessful = new Alert(AlertType.INFORMATION,
					"Erstellen der Datenbank 'tourdefrance2017' erfolgreich.", ButtonType.OK);
			al_DBCreationSuccessful.setTitle("Hinweis");
			al_DBCreationSuccessful.showAndWait();
		} catch (SQLException e) {
			Alert al_DBCreationFailed = new Alert(AlertType.ERROR, "Erstellen der Datenbank fehlgeschlagen.",
					ButtonType.OK);
			al_DBCreationFailed.setTitle("Fehler");
			al_DBCreationFailed.show();
		}
	}

	public static String createNewTables() {
		try {

			Statement stAnlegen = Main.databaseConnection.createStatement();
			String disableKeyChecks = "SET FOREIGN_KEY_CHECKS=0;";
			String enableKeyChecks = "SET FOREIGN_KEY_CHECKS=1;";
			Statement dbkc = Main.databaseConnection.prepareStatement(disableKeyChecks);
			dbkc.executeQuery(disableKeyChecks);

			// L�schen bereits vorhandener Tabellen
			stAnlegen.execute("drop table if exists user");
			stAnlegen.execute("drop table if exists fahrer");
			stAnlegen.execute("drop table if exists etappen");
			stAnlegen.execute("drop table if exists teams");
			stAnlegen.execute("drop table if exists ranking");
			stAnlegen.execute("drop table if exists tipps");
			stAnlegen.execute("drop table if exists etappenart");

			// Anlegen der Tabellen
			stAnlegen.execute(
					"create table user(userID INT(11) NOT NULL AUTO_INCREMENT, userName VARCHAR(100), sessionID VARCHAR(50), vorname VARCHAR(50), nachname VARCHAR(50), passwort VARCHAR(50), angelegt TIMESTAMP DEFAULT CURRENT_TIMESTAMP, Primary KEY(userID));");
			stAnlegen.execute(
					"create table etappenart(artID INT(11) AUTO_INCREMENT, bezeichnung VARCHAR(50) DEFAULT NULL, PRIMARY KEY(artID));");
			stAnlegen.execute(
					"create table fahrer(fahrerID INT(11) NOT NULL AUTO_INCREMENT, startnummer INT(11), fahrerVorname VARCHAR(50), fahrerNachname VARCHAR(50), team INT(11), aktiv TINYINT(1) DEFAULT 1, gesamtzeit TIME DEFAULT NULL, etappensiege INT(11) DEFAULT 0, punkteGruen INT(11) DEFAULT 0, punkteBerg INT(11) DEFAULT 0, PRIMARY KEY(fahrerID));");
			stAnlegen.execute(
					"create table etappen(etappenID INT(11) AUTO_INCREMENT, etappennummer INT(11), datum DATETIME , startort VARCHAR(50), zielort VARCHAR (50), laenge DOUBLE, art INT(11), fahrerPlatz1 VARCHAR(50) DEFAULT NULL, siegerzeit TIME DEFAULT NULL, fahrerPlatz2 VARCHAR(50) DEFAULT NULL, fahrerPlatz3 VARCHAR(50) DEFAULT NULL, teamPlatz1 VARCHAR(50) DEFAULT NULL, teamPlatz2 VARCHAR(50) DEFAULT NULL, teamPlatz3 VARCHAR(50) DEFAULT NULL, fahrerGelb VARCHAR(50) DEFAULT NULL, fahrerGruen VARCHAR(50) DEFAULT NULL, fahrerBerg VARCHAR(50), dopingFahrer VARCHAR(50) DEFAULT NULL, dopingTeam VARCHAR(50) DEFAULT NULL, PRIMARY KEY(etappenID), FOREIGN KEY(art) REFERENCES etappenart(artID));");
			stAnlegen.execute(
					"create table teams(teamID INT(11) AUTO_INCREMENT, teamName VARCHAR(50), teamBuildUrl VARCHAR(100) DEFAULT NULL, PRIMARY KEY(teamID));");
			stAnlegen.execute(
					"create table ranking(rankingID INT(11) AUTO_INCREMENT, datum DATETIME, userID INT(11), punkte INT(11) DEFAULT 0, platz INT(11) DEFAULT 0, PRIMARY KEY(rankingID), FOREIGN KEY (userID) REFERENCES user(userID) );");
			stAnlegen.execute(
					"create table tipps(tippID INT(11) AUTO_INCREMENT, userID INT(11), etappenID INT(11) , fahrerPlatz1 VARCHAR(50) DEFAULT NULL, fahrerPlatz2 VARCHAR(50) DEFAULT NULL,fahrerPlatz3 VARCHAR(50) DEFAULT NULL,teamPlatz1 VARCHAR(50) DEFAULT NULL,teamPlatz2 VARCHAR(50) DEFAULT NULL, teamPlatz3 VARCHAR(50) DEFAULT NULL,fahrerGelb VARCHAR(50) DEFAULT NULL, fahrerGruen VARCHAR(50) DEFAULT NULL,fahrerBerg VARCHAR(50) DEFAULT NULL,fahrerDoping VARCHAR(50) DEFAULT NULL, teamDoping VARCHAR(50) DEFAULT NULL, PRIMARY KEY(tippID), FOREIGN KEY(userID) REFERENCES user(userID), FOREIGN KEY (etappenID) REFERENCES etappen(etappenID) );");

			// Die Tabelle "etappenart" mit Initialwerten f�llen
			stAnlegen.executeQuery("INSERT INTO `etappenart`(`bezeichnung`) VALUES ('Einzelzeitfahren');");
			stAnlegen.executeQuery("INSERT INTO `etappenart`(`bezeichnung`) VALUES ('Flachetappe');");
			stAnlegen.executeQuery("INSERT INTO `etappenart`(`bezeichnung`) VALUES ('Gebirge');");
			stAnlegen.executeQuery("INSERT INTO `etappenart`(`bezeichnung`) VALUES ('H�gelig');");

			dbkc.executeQuery(enableKeyChecks);

			Alert al_DBCreationSuccessful = new Alert(AlertType.INFORMATION,
					"Erstellen der Tabellen 'tourdefrance2017' erfolgreich.", ButtonType.OK);
			al_DBCreationSuccessful.setTitle("Hinweis");
			al_DBCreationSuccessful.showAndWait();

		} catch (SQLException e) {

			Alert al_DBCreationFailed = new Alert(AlertType.ERROR, "Erstellen der Tabellen fehlgeschlagen.",
					ButtonType.OK);
			al_DBCreationFailed.setTitle("Fehler");
			al_DBCreationFailed.show();
			e.printStackTrace();
		}
		return null;
	}

	public static Connection connectToDatabase(Connection conn, String databaseName, String username, String password) {
		try {
			// Verbindung �ber die Datenbank-URL in Kombination mit
			// Benutzername und Passwort
			Connection databaseConnection = Main.databaseConnection = DriverManager.getConnection(
					Main.serverConnection.getMetaData().getURL() + "/" + databaseName, username, password);
			return databaseConnection;

		} catch (SQLInvalidAuthorizationSpecException e1) {
			Alert al_wrongPasswordOrUsername = new Alert(AlertType.WARNING, "Benutzername oder Passwort falsch.",
					ButtonType.OK);
			al_wrongPasswordOrUsername.setTitle("Fehler");
			al_wrongPasswordOrUsername.show();
		} catch (SQLException e) {
			Alert al_DBConnectionFailed = new Alert(AlertType.ERROR, "Verbindung zur Datenbank fehlgeschlagen.",
					ButtonType.OK);
			al_DBConnectionFailed.setTitle("Fehler");
			al_DBConnectionFailed.show();
		}
		return null;
	}

	public static List<String> getAvailableDatabases(Connection conn) {
		List<String> listOfAvailableDatabases = new LinkedList<String>();

		try {
			// ResultSet mit allen Datenbanken erstellen
			ResultSet rs = Main.serverConnection.getMetaData().getCatalogs();

			// Jeden Datenbanknamen in die Liste speichern
			while (rs.next()) {
				listOfAvailableDatabases.add(rs.getString("TABLE_CAT"));
			}
		} catch (SQLException e) {
			Alert al_DBConnectionFailed = new Alert(AlertType.ERROR, "Datenbankliste konnte nicht erstellt werden.",
					ButtonType.OK);
			al_DBConnectionFailed.setTitle("Fehler");
			al_DBConnectionFailed.show();
		}
		return listOfAvailableDatabases;
	}

	// Funktion, um Daten aus einer CSV-Datei einzulesen
	// Der Parameter "table" bestimmt, in welche Tabelle eingef�gt wird, was
	// sich auf das SQL-Statement auswirkt

	public static void importFromCSV(String fileAddress, String table) {
		try {
			// FileReader f�r die CSV-Datei erstellen, der �ber die absolute
			// Adresse zugreift
			FileReader fr = new FileReader(fileAddress);
			BufferedReader br = new BufferedReader(fr, 500);

			PreparedStatement stm = null;
			String line;
			String[] lineSplit;
			String sqlString;

			// Jede Zeile einlesen und die durch Tabulatoren getrennten
			// Eintr�ge in einem Stringarray speichern.
			// Dann die Eintr�ge in die Tabelle der Datenbank eintragen.
			while (true) {
				line = br.readLine();
				if (line == null)
					break;
				lineSplit = line.split("	");
				sqlString = "";

				// F�r jede Zeile werden die einzelnen Eintr�ge in die
				// jeweiligen Tabellenspalten eingetragen
				// Je nachdem welcher String "table" als Parameter �bergeben
				// wurde, �ndert sich nur das SQL-Statement
				switch (table) {
				case "user":
					sqlString = "INSERT INTO `user`(`userName`, `sessionID`,`vorname`, `nachname`, `passwort`) VALUES ('"
							+ lineSplit[1] + "','" + lineSplit[2] + "','" + lineSplit[3] + "','" + lineSplit[4] + "','"
							+ lineSplit[5] + "');";
					stm = Main.databaseConnection.prepareStatement(sqlString);
					stm.executeQuery();
					break;

				case "tipps":
					sqlString = "INSERT INTO `tipps`(`userID`, `etappenID`, `fahrerPlatz1`, `fahrerPlatz2`, `fahrerPlatz3`, `teamPlatz1`, `teamPlatz2`, `teamPlatz3`, `fahrerGelb`, `fahrerGruen`, `fahrerBerg`, `fahrerDoping`, `teamDoping`) VALUES ('"
							+ Integer.parseInt(lineSplit[1]) + "','" + Integer.parseInt(lineSplit[2]) + "', '"
							+ lineSplit[3] + "', '" + lineSplit[4] + "', '" + lineSplit[5] + "', '" + lineSplit[6]
							+ "', '" + lineSplit[7] + "', '" + lineSplit[8] + "', '" + lineSplit[9] + "', '"
							+ lineSplit[10] + "', '" + lineSplit[11] + "', '" + lineSplit[12] + "', '" + lineSplit[13]
							+ "');";
					stm = Main.databaseConnection.prepareStatement(sqlString);
					stm.executeQuery();
					break;

				case "etappen":
					sqlString = "INSERT INTO `etappen`(`etappennummer`, `datum`, `startort`, `zielort`, `laenge`, `art`) VALUES (?,?,?,?,?,?);";
					stm = Main.databaseConnection.prepareStatement(sqlString);
					stm.setInt(1, Integer.parseInt(lineSplit[1]));
					stm.setTimestamp(2, java.sql.Timestamp.valueOf(lineSplit[2]));
					stm.setString(3, lineSplit[3]);
					stm.setString(4, lineSplit[4]);
					stm.setDouble(5, Double.parseDouble(lineSplit[5]));
					stm.setInt(6, Integer.parseInt(lineSplit[6]));
					stm.executeQuery();
					break;

				case "fahrer":
					sqlString = "INSERT INTO `fahrer`(`startnummer`, `fahrerVorname`, `fahrerNachname`, `team`, `aktiv`) VALUES ('"
							+ Integer.parseInt(lineSplit[1]) + "', '" + lineSplit[2] + "', '" + lineSplit[3] + "', '"
							+ Integer.parseInt(lineSplit[4]) + "', '" + Integer.parseInt(lineSplit[5]) + "')";
					stm = Main.databaseConnection.prepareStatement(sqlString);
					stm.executeQuery();
					break;

				case "teams":
					sqlString = "INSERT INTO `teams`(`teamName`, `teamBuildUrl`) VALUES ('" + lineSplit[1] + "', '"
							+ lineSplit[2] + "' );";
					stm = Main.databaseConnection.prepareStatement(sqlString);
					stm.executeQuery();
					break;
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public static String openFileChooser() {
		Stage stage = new Stage();
		String directory;
		FileChooser fileChooser = new FileChooser();
		File selectedDirectory = fileChooser.showOpenDialog(stage);

		if (selectedDirectory == null) {
			directory = "Keine Datei ausgew�hlt";
		} else {
			directory = selectedDirectory.getAbsolutePath();
		}
		return directory;
	}

	public static String getStageTableString() {
		try {
			if (Main.databaseConnection == null || Main.databaseConnection.isClosed()) {
				return ERROR_UNABLE_TO_LOAD_DATA;
			}
			Statement statement = Main.databaseConnection.createStatement();
			List<String[]> stages = new ArrayList<>();
			int[] longestElements = new int[7];
			stages.add(new String[] { "Etappe", "Datum", "Uhrzeit", "Startort", "Zielort", "Länge", "Etappenart" });
			for (int i = 0; i < longestElements.length; i++) {
				longestElements[i] = stages.get(0)[i].length();
			}

			ResultSet resultSet = statement
					.executeQuery("SELECT etappenID, datum, startort, zielort, laenge, bezeichnung"
							+ " FROM etappen, etappenart" + " WHERE artID = art" + " ORDER BY etappenID");

			while (resultSet.next()) {
				String[] line = new String[7];
				line[0] = String.valueOf(resultSet.getInt("etappenID"));
				java.sql.Date date = resultSet.getDate("datum");
				LocalDateTime localDateTime = LocalDateTime
						.from(Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()));
				line[1] = localDateTime.format(DateTimeFormatter.ofPattern("dd.MM.uuuu"));
				line[2] = localDateTime.format(DateTimeFormatter.ofPattern("HH:mm"));
				line[3] = resultSet.getString("startort");
				line[4] = resultSet.getString("zielort");
				line[5] = resultSet.getString("laenge");
				line[6] = resultSet.getString("bezeichnung");
				for (int i = 0; i < longestElements.length; i++) {
					longestElements[i] = Math.max(line[i].length(), longestElements[i]);
				}
				stages.add(line);
			}

			String[] separator = new String[7];
			for (int i = 0; i < longestElements.length; i++) {
				String string = "";
				for (int s = 0; s < longestElements[i] + 3; s++) {
					string += "=";
				}
				separator[i] = string;
				longestElements[i] += 3;
			}

			stages.add(0, separator);
			stages.add(2, separator);

			StringBuilder builder = new StringBuilder();
			for (String[] line : stages) {
				for (int i = 0; i < line.length; i++) {
					builder.append(line[i]);
					if (i < line.length - 1) {
						for (int s = 0; s < longestElements[i] - line[i].length(); s++) {
							builder.append(" ");
						}
					}
				}
				builder.append("\n");
			}

			return builder.toString();

		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}
		return ERROR_UNABLE_TO_LOAD_DATA;
	}

	private static final String ERROR_UNABLE_TO_LOAD_DATA = "Daten konnten nicht geladen werden";

}
