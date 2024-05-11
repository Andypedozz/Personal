package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Model;

public class MenuController {
	
	@FXML
	Label usernameLabel;
	@FXML
	Label nameLabel;
	@FXML
	Label genderLabel;
	@FXML
	Label ageLabel;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private Model model;
	
	public void displayInfo() {
		this.usernameLabel.setText("Username: "+model.getAccountManager().getUsedData().get(0).getUsername());
		this.nameLabel.setText("Name: "+model.getAccountManager().getUsedData().get(0).getUser().getName());
		this.genderLabel.setText("Gender: "+model.getAccountManager().getUsedData().get(0).getUser().getGender());
		this.ageLabel.setText("Age: "+model.getAccountManager().getUsedData().get(0).getUser().getAge());
	}
	
	public void actualStatistics(ActionEvent event) throws Exception{
		System.out.println("Statistics screen");
	}
	
	public void settings(ActionEvent event) throws Exception{
		System.out.println("Settings screen");
	}
	
	public void progress(ActionEvent event) throws Exception{
		System.out.println("Progress screen");
	}
	
	public void dailyRecords(ActionEvent event) throws Exception{
		System.out.println("Records screen");
	}
	
	public void setModel(Model model) {
		this.model = model;
	}
	
	public void logout(ActionEvent event) throws Exception{
		model.getLogger().disconnect();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
		root = loader.load();	
		LoginController loginController = loader.getController();
		loginController.setModel(model);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
