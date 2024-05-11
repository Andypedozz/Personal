package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.LOGIN_EXIT;
import model.Model;
import javafx.scene.Node;

public class LoginController {
	
	// GRAPHICS
	@FXML
	TextField usernameField;
	
	@FXML
	PasswordField passwordField;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	// MODEL
	private Model model;
	
	public void login(ActionEvent e) throws Exception {
		String username = usernameField.getText();
		String password = passwordField.getText();
		LOGIN_EXIT exit = this.model.getLogger().login(username, password);
		switch(exit) {
		case LOGGED:
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
			root = loader.load();	
			MenuController menuController = loader.getController();
			menuController.setModel(model);
			menuController.displayInfo();
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			break;
		case NOT_FOUND:
			this.notFound();
			break;
		case NULL_CREDENTIALS:
			this.nullCredentials();
		case ALREADY_LOGGED:
			break;
		}
	}
	
	private void nullCredentials() {
		System.out.println("Empty credentials");
	}

	public void start() {
		this.model.start();
	}
	
	private void notFound() {
		System.out.println("Account not found!");
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
	public Model getModel() {
		return this.model;
	}
}
