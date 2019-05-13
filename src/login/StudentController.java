package login;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.LoginModel;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
	
	LoginModel loginModel = new LoginModel();
	

    @FXML
    private PasswordField password;
    
    @FXML
    private TextField name;

    @FXML
    private Button btnlogin;
    
    @FXML
    private void handleButtonClicks(javafx.event.ActionEvent event)
    {
    	try
        {
          if (this.loginModel.isLogin(this.name.getText(), this.password.getText()))
          {
            if(event.getSource()==btnlogin) 
                       studentLogin();
          }
         
        }
        catch (Exception localException) {}
    }

    final Label message = new Label("");

	private void studentLogin()
     {
    	 try
    	    {
    	      Stage studentStage = new Stage();
    	      FXMLLoader studentLoader = new FXMLLoader();
    	      Pane studentroot = (Pane)studentLoader.load(getClass().getResource("/Student/Student.fxml").openStream());
    	      
    	      
    	      Scene studentscene = new Scene(studentroot);
    	      
    	      studentStage.setScene(studentscene);
    	      studentStage.setTitle("Student Dashboard");
    	      studentStage.setResizable(true);
    	      studentStage.show();
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