package Admin;

import dbUtil.dbConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminTeacherController implements Initializable
{
  @FXML
  private TextField id;
  @FXML
  private TextField firstname;
  @FXML
  private TextField lastname;
  @FXML
  private TextField email;
  @FXML
  private DatePicker dob;
  @FXML
  private TableView<TeacherData> teachertable;
  @FXML
  private TableColumn<TeacherData, String> idcolumn;
  @FXML
  private TableColumn<TeacherData, String> firstnamecolumn;
  @FXML
  private TableColumn<TeacherData, String> lastnamecolumn;
  @FXML
  private TableColumn<TeacherData, String> emailcolumn;
  @FXML
  private TableColumn<TeacherData, String> dobcolumn;
  @FXML
  private Button loadbutton;
  private ObservableList<TeacherData> data;
  
  public dbConnection dc;
  
  public void initialize(URL url, ResourceBundle rb)
  {
    this.dc = new dbConnection();
  }
  
  @SuppressWarnings({ "rawtypes", "unchecked" })
  @FXML
  private void loadTeacherData(ActionEvent event)
  {
    try
    {
      Connection conn = dbConnection.getConnection();
      this.data = FXCollections.observableArrayList();
      
      ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM teachers");
      while (rs.next()) {
        this.data.add(new TeacherData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
      }
    }
    catch (SQLException e)
    {
      System.err.println("Error " + e);
    }
    this.idcolumn.setCellValueFactory(new PropertyValueFactory("ID"));
    this.firstnamecolumn.setCellValueFactory(new PropertyValueFactory("firstName"));
    this.lastnamecolumn.setCellValueFactory(new PropertyValueFactory("lastName"));
    this.emailcolumn.setCellValueFactory(new PropertyValueFactory("email"));
    this.dobcolumn.setCellValueFactory(new PropertyValueFactory("DOB"));
    
    this.teachertable.setItems(null);
    this.teachertable.setItems(this.data);
  }
  
  @FXML
  private void addTeacher(ActionEvent event)
  {
    String sql = "INSERT INTO `teachers`(`id`, `fname`, `lname`, `email`, `DOB`) VALUES (? , ?, ?, ?, ?)";
    try
    {
      Connection conn = dbConnection.getConnection();
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, this.id.getText());
      stmt.setString(2, this.firstname.getText());
      stmt.setString(3, this.lastname.getText());
      stmt.setString(4, this.email.getText());
      stmt.setString(5, this.dob.getEditor().getText());
      
      stmt.execute();
      conn.close();
    }
    catch (SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
  }
  
  @FXML
  private void clearFields(ActionEvent event)
  {
    this.id.setText("");
    this.firstname.setText("");
    this.lastname.setText("");
    this.email.setText("");
    this.dob.setValue(null);
  }
  @FXML
  private void deleterowfromtable(ActionEvent event) throws ClassNotFoundException,SQLException{
  
	  String sql="delete from teachers where id= ?";
	  Connection conn;
	try 
	{
		conn = dbConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,this.id.getText());
		stmt.execute();
		conn.close();
	} 
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
   }
}

