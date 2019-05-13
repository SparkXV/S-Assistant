package login;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

public class TeacherController implements Initializable {
	
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
                       teacherLogin();
            
          }
         
        }
        catch (Exception localException) {}
    }

    

	private void teacherLogin()
     {
    	 try
    	    {
    	      Stage teacherStage = new Stage();
    	      FXMLLoader teacherLoader = new FXMLLoader();
    	      Pane teacherroot = (Pane)teacherLoader.load(getClass().getResource("/Teacher/Teacher.fxml").openStream());
    	      
    	      
    	      Scene teacherscene = new Scene(teacherroot);
    	      
    	      teacherStage.setScene(teacherscene);
    	      teacherStage.setTitle("Teacher Panel");
    	      teacherStage.setResizable(true);
    	      teacherStage.show();
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