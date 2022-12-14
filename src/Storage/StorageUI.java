package Storage;

import javax.swing.JOptionPane;

import Users.Account;
import application.Buttons;
import application.LoggedForm;
import application.LoginForm;
import enums.Roles;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StorageUI {
public static void buttonVisibility(String string,Button button) {
	if(Account.getInstance().getRole().equalsIgnoreCase(string) || Account.getInstance().getRole().equalsIgnoreCase(Roles.ADMIN.name())) {
		button.setVisible(true);
	}else {
		button.setVisible(false);
	}
}
public static void profileSettings(GridPane grid,final Stage stage) {
	Button logOutVButton = new Button("Log out");
	Label welcomeLabel = new Label("Welcome,");
	Label roleLabel = new Label("Role: " + Account.getInstance().getRole());
	roleLabel.setFont(new Font("Ariel", 20));
	roleLabel.setPrefSize(400, 10);
	welcomeLabel.setFont(new Font("Ariel", 20));
	Text username = new Text(Account.getInstance().getUsername());
	Font font = Font.font("Ariel", FontWeight.BOLD, 20);
	username.setFont(font);
	logOutVButton.setPrefSize(80, 40);
	logOutVButton.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent e) {
			Account.resetInstance();
			stage.close();
			JOptionPane.showMessageDialog(null, "See you next time!");
			LoginForm f = new LoginForm();
			f.formLoad(new Stage());
		}
	});
	grid.add(logOutVButton, 0, 3);
	grid.add(roleLabel, 0, 2);
	grid.add(welcomeLabel, 0, 0);
	grid.add(username, 0, 1);
}
public static void userManagement(HBox hbox,GridPane grid,int x,int y) {
	Buttons.addUserButton(hbox, grid, x, y);
	Buttons.searchUserButton(hbox, grid, x, y);
	Buttons.removeUserButton(hbox, grid, x, y);
	Buttons.refreshButton(hbox, grid, x, y);
	Buttons.editButton(hbox, grid, x, y);
	grid.add(hbox, x, y);
}
public static void checkAvailability(VBox vbox,GridPane grid) {
	if(vbox != null) {
		ObservableList<Node> children = grid.getChildren();
		children.remove(vbox);
	}
}
public static void homePage(HBox hbox,GridPane grid,int x,int y,LoggedForm loggedForm) {
	Buttons.wineProdButton(hbox, grid, loggedForm);
	Buttons.adminButton(hbox, grid, loggedForm);
	Buttons.hostButton(hbox, grid, loggedForm);
	grid.add(hbox, x, y);
}

public static void storageManagement(HBox hbox,GridPane grid,int x,int y) {
	
	grid.add(hbox, x, y);
}


}
