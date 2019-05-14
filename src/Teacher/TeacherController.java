package Teacher;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TeacherController implements Initializable {

    @FXML
    private Button btngrade;

    @FXML
    private Button btnstudents;

    @FXML
    private Button btnupdate;
    
    @FXML
    private void handleButtonClicks(ActionEvent mouseEvent) {
        if (mouseEvent.getSource() == btnstudents) 
        {
            loadStage("/Teacher/Students.fxml");
        } 
        else if (mouseEvent.getSource() == btngrade) 
        {
            loadStage("/Teacher/Grade.fxml");
        } 
        else if (mouseEvent.getSource() == btnupdate) 
        {
            loadStage("/Teacher/NoticeBoard.fxml");
        }
     
    }

    private void loadStage(String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
