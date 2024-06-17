package account;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ResourceBundle;

public class DepoWithdController implements Initializable {

	@FXML
	public Button submit;

	@FXML
	public ChoiceBox choice;

	@FXML
	public TextField acc_no;

	@FXML
	public PasswordField pass;

	@FXML
	public TextField enteredAmt;

	private boolean isDeposit = true;
	private long pos;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		choice.getItems().addAll("Deposit","Withdraw");
		choice.setValue("Deposit");

		choice.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> isDeposit = newValue.equals("Deposit")));

		submit.setOnAction(event -> {
			if(search())
			{
				try {
					RandomAccessFile raf = new RandomAccessFile("Bank.txt", "rw");
					raf.seek(pos);
					String s=raf.readLine();
					raf.close();
					try{
						int amt= Integer.parseInt(s.substring(20,28));
						int amount = Integer.parseInt(enteredAmt.getText());
						if(amount>90000000)
							show_alert("Invalid Input","Invalid Amount","Total amount in the account should not exceed 9,00,00,000 (Nine Crores).");
						else if(amount<50)
							show_alert("Invalid Input","Invalid Amount","The least (minimum) amount should be 50 (Fifty).");
						else if(isDeposit)
						{
							if(amt+amount>90000000)
								show_alert("Invalid Input","Invalid Amount","Total amount in the account should not exceed 9,00,00,000 (Nine Crores).");
							else
								update(amt+amount);
						}
						else
						{
							if(amount>amt)
								show_alert("Invalid Input","Not enough amount in the account","Amount to be withdrawn should be less than the amount present in the account.");
							else
								update(amt-amount);
						}
					}
					catch(NumberFormatException e)
					{
						System.out.println("Wrong amount entered");
						show_alert("Invalid Input","Invalid amount","Amount should be numbers and should not exceed 9,00,00,000 (Nine crores).");
					}
				}
				catch (FileNotFoundException e)
				{
					System.err.println("File Not Found");
				}
				catch (Exception e)
				{
					System.err.println(e);
				}
			}
			else
			show_alert("Invalid Input","Wrong Account No. / Password","Provided account no. or password or both are wrong.");
		});
	}

	private void update(int amt) {
		try
		{
			RandomAccessFile raf = new RandomAccessFile("Bank.txt","rw");
			raf.seek(pos+20);
			String amount=""+amt;
			if(amount.length()<8)
			{
				int l=8-amount.length();
				for(int i=1;i<=l;i++)
					amount="0"+amount;
			}
			raf.writeBytes(amount);
			raf.close();
		}
		catch (Exception e)
		{
			System.err.println(e);
		}
		show_success("Success","Transaction Completed",""+Integer.parseInt(enteredAmt.getText())+((isDeposit)?" deposited":" withdrawn")+" successfully.\nVisit Again!");
	}

	private void show_success(String title, String headerText, String info) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(info);
		alert.showAndWait();
	}

	private void show_alert(String title, String headerText, String info) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(info);
		alert.showAndWait();
	}

	private boolean search() {
		String toSearch=acc_no.getText()+":"+pass.getText();
		try {
			RandomAccessFile raf = new RandomAccessFile("Bank.txt","rw");
			pos=0;
			long l=raf.length();
			String s,details;
			while(pos<l)
			{
				raf.seek(pos);
				s=raf.readLine();
				details=s.substring(0,19);
				System.out.println(details+"\n");
				if(details.equals(toSearch))
				{
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
}
