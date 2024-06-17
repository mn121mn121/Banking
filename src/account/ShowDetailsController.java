package account;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ResourceBundle;

public class ShowDetailsController implements Initializable {

	@FXML
	public TextField acc_no;

	@FXML
	public PasswordField pass;

	@FXML
	public Button submit;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		submit.setOnAction(event -> {
			if(search())
				System.out.println("Found Details");
			else
				show_alert();
		});
	}

	private void show_alert() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Wrong input");
		alert.setHeaderText("Invalid Account Number / Password");
		alert.setContentText("Provided account number or password or both are wrong.");
		alert.showAndWait();
	}

	private boolean search() {
		String toSearch=acc_no.getText()+":"+pass.getText();
		try {
			RandomAccessFile raf = new RandomAccessFile("Bank.txt","rw");
			long pos=0,l=raf.length();
			String s,details;
			while(pos<l)
			{
				raf.seek(pos);
				s=raf.readLine();
				details=s.substring(0,19);
				System.out.println(details+"\n");
				if(details.equals(toSearch))
				{
					show_found(pos);
					raf.close();
					return true;
				}
				pos+=29;
			}
			raf.close();
		}catch (Exception e)
		{
			System.err.println(e);
		}
		return false;
	}

	private void show_found(long pos){
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Details");
		alert.setHeaderText("Account Details");
		try{
			RandomAccessFile raf = new RandomAccessFile("Bank.txt","rw");
			raf.seek(pos);
			String accno = acc_no.getText();
			String amount = raf.readLine().substring(20,28);
			alert.setContentText("Account Number: "+accno+"\nAmount: "+Integer.parseInt(amount));
			alert.showAndWait();

		}
		catch(Exception e)
		{
			System.err.println(e);
		}
	}
}
