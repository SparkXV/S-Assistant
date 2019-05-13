package login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class loginController implements Initializable{

	@FXML
    private Button btnAdmin;
	@FXML
    private Button btnTeacher;
	@FXML
    private Button btnStudent;
	
    @FXML
	private void handleButtonClicks(javafx.event.ActionEvent mouseEvent)
    {
    	if (mouseEvent.getSource() == btnAdmin) 
    	{
            loadStage("/login/loginadmin.fxml");
        }
    	if (mouseEvent.getSource() == btnTeacher) 
    	{
            loadStage("/login/loginteacher.fxml");
        }
        if (mouseEvent.getSource() == btnStudent)
        {
            loadStage("/login/loginstudent.fxml");
        }
    }
    
	private void loadStage(String fxml) 
	{
		// TODO Auto-generated method stub
		try 
		{
			Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } 
		
		catch (IOException e) 
		{
            e.printStackTrace();
        }
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	   
	
	

}
