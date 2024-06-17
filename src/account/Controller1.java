package account;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller1 implements Initializable {

	@FXML
	public Button button1;

	@FXML
	public Button button2;

	@FXML
	public Button button3;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		try
		{
			button1.setOnAction(event -> openNewScreen("Create New Account","new_acc.fxml"));
			button2.setOnAction(event -> openNewScreen("Show Details","showDetails.fxml"));
			button3.setOnAction(event -> openNewScreen("Deposit / Withdraw","depoWithd.fxml"));
		}
		catch (Exception e)
		{
			System.err.println("Failed to Open the new screen");
		}
	}

	private void openNewScreen(String title, String fxmlFileName){

		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
			VBox rootNode = loader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(rootNode));
			stage.setTitle(title);
			stage.setResizable(false);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.showAndWait();
		}
		catch (Exception e) {
			System.err.println("Failed to open New Window");
		}
	}
}
