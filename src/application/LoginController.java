package application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private ComboBox<String> roleCombo;
    @FXML private Button loginBtn;
    @FXML private Label errorLabel;

    Database db = new Database();

    @FXML
    public void initialize() {
        roleCombo.setItems(FXCollections.observableArrayList("ADMIN", "TEACHER"));
        roleCombo.getSelectionModel().selectFirst();
    }

    @FXML
    void handleLogin(ActionEvent event) {
        String user = usernameField.getText();
        String pass = passwordField.getText();
        String role = roleCombo.getValue();

        if (user == null || pass == null || user.isEmpty() || pass.isEmpty()) {
            errorLabel.setText("Please fill all fields.");
            return;
        }

        boolean isValid = db.authenticateUser(user, pass, role);

        if (isValid) {
            errorLabel.setText("Login Successful! Redirecting...");
            try {
                Stage stage = (Stage) loginBtn.getScene().getWindow();
                if ("TEACHER".equals(role)) {
                    // Load Teacher Kiosk (the old Sample.fxml for now)
                    BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			        Scene scene = new Scene(root,1350,720);
                    stage.setScene(scene);
                } else if ("ADMIN".equals(role)) {
                    // Load Admin Dashboard
                    VBox root = (VBox)FXMLLoader.load(getClass().getResource("AdminDashboard.fxml"));
			        Scene scene = new Scene(root,1350,720);
                    stage.setScene(scene);
                }
            } catch (Exception e) {
                e.printStackTrace();
                errorLabel.setText("Failed to load dashboard: " + e.getMessage());
            }
        } else {
            errorLabel.setText("Invalid credentials!");
        }
    }
}
