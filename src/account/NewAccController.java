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

public class NewAccController implements Initializable {

	@FXML
	public Button submit;

	@FXML
	public TextField acc_no;

	@FXML
	public PasswordField pass;

	@FXML
	public PasswordField confirm_pass;

	private long pos;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		submit.setOnAction(event -> {
			if(submitAction())
				show_success("Completed","Account created successfully.");
			else
				show_alert("Error","Failed to create Account");
		});
	}

	private void show_success(String headerText, String info) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Success");
		alert.setHeaderText(headerText);
		alert.setContentText(info);
		alert.showAndWait();
	}

	private boolean submitAction() {

		System.out.println("Inside submitAction function");
		String account_num = acc_no.getText();
		if(account_num.length()!=12)
			return show_alert("Invalid Account Number","Account Number size should be 12.");

		//checking if the provided account number is available from before
		if(check(account_num))
			return show_alert("Invalid Account Number","Provided Account Number Already exists.");

		String password=pass.getText();
		if(password.length()!=6)
			return show_alert("Wrong Password","Password size should be 6.");
		String confirm_password = confirm_pass.getText();
		if(!password.equals(confirm_password))
			return show_alert("Wrong Input","Entered password and confirm password should match.");

		create_acc(account_num, password);

		return true;
	}

	private boolean show_alert(String headerText,String message)
	{
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(headerText);
		alert.setContentText(message);
		alert.showAndWait();
		return  false;
	}

	private boolean check(String account_num)
	{
		System.out.println("Inside check function");
		try
		{
			RandomAccessFile raf = new RandomAccessFile("Bank.txt","rw");
			pos=0;
			long l=raf.length();
			String s,accno;
			while(pos<l)
			{
				raf.seek(pos);
				s=raf.readLine();
				accno=s.substring(0,12);
				if(accno.equals(account_num)){
					raf.close();
					return true;
				}
				pos+=29;
			}
			return false;
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
		return false;
	}

	private void create_acc(String acc, String password)
	{
		try
		{
			RandomAccessFile raf = new RandomAccessFile("Bank.txt","rw");
			pos=raf.length();
			raf.seek(pos);
			String details = acc+":"+password+":00000000\n";
			raf.writeBytes(details);
		}
		catch(Exception e) {
			System.err.println(e);
		}
	}
}
