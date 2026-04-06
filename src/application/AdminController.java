package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Node;

public class AdminController {

    @FXML private Label totalStudentsLabel;
    @FXML private Label todayAttendanceLabel;

    Database db = new Database();

    @FXML
    public void initialize() {
        int total = db.getTotalStudents();
        int today = db.getTodayAttendanceCount();

        totalStudentsLabel.setText(String.valueOf(total));
        todayAttendanceLabel.setText(String.valueOf(today));
    }

    @FXML
    void handleLogout(ActionEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            VBox root = (VBox)FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(root, 1350, 720);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
