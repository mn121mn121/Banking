package account;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {


	public static void main(String args[])
	{
		System.out.println("Main main");
		launch(args);
	}

	@Override
	public void init() throws Exception {
		System.out.println("Main init");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("Main start");

		FXMLLoader loader = new FXMLLoader(getClass().getResource("handling_account.fxml"));
		VBox rootNode = loader.load();
		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0,menuBar);
		Scene scene = new Scene(rootNode);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Account Handling");
		primaryStage.show();

	}

	private MenuBar createMenu() {
		MenuBar menuBar = new MenuBar();
		Menu menuAbout = new Menu("About");
		Menu menuMore = new Menu("More");

		MenuItem quit = new MenuItem("Quit");
		menuMore.getItems().addAll(quit);

		quit.setOnAction(event -> {
			Platform.exit();
		});

		MenuItem aboutApp = new MenuItem("About App");
		MenuItem aboutMe = new MenuItem("About Me");

		aboutApp.setOnAction(event -> showAbout("About App","About the Application","--About App--"));
		aboutMe.setOnAction(event -> showAbout("About Me","About the developer- Manasvi","--About Me--"));

		menuAbout.getItems().addAll(aboutApp, new SeparatorMenuItem(), aboutMe);

		menuBar.getMenus().addAll(menuAbout, menuMore);
		return menuBar;
	}

	private void showAbout(String title, String headerText, String info) {
		Alert dialog = new Alert(Alert.AlertType.INFORMATION);
		dialog.setTitle(title);
		dialog.setHeaderText(headerText);
		dialog.setContentText(info);

		ButtonType ok = new ButtonType("OK");
		dialog.getButtonTypes().setAll(ok);
		dialog.showAndWait();
	}

	@Override
	public void stop() throws Exception{
		System.out.println("Main Stop");
		super.stop();
	}
}
