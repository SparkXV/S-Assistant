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

//import Admin.AdminController;

public class AdminController implements Initializable {
	
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
                       adminLogin();
            
          }
         
        }
        catch (Exception localException) {}
    }

	private void adminLogin()
     {
    	 try
    	    {
    	      Stage adminStage = new Stage();
    	      FXMLLoader adminLoader = new FXMLLoader();
    	      Pane adminroot = (Pane)adminLoader.load(getClass().getResource("/Admin/Admin.fxml").openStream());
    	      //AdminController adminController = (AdminController)adminLoader.getController();
    	      
    	      Scene adminscene = new Scene(adminroot);
    	      
    	      adminStage.setScene(adminscene);
    	      adminStage.setTitle("Admin Dashboard");
    	      adminStage.setResizable(true);
    	      adminStage.show();
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