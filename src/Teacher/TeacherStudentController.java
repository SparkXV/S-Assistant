package Teacher;

import dbUtil.dbConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Admin.StudentData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TeacherStudentController implements Initializable
{
  @FXML
  private Button btnshow;
  @FXML
  private TableView<StudentData> sttable;
  @FXML
  private TableColumn<StudentData, String> idcolumn;
  @FXML
  private TableColumn<StudentData, String> firstnamecolumn;
  @FXML
  private TableColumn<StudentData, String> lastnamecolumn;
  @FXML
  private TableColumn<StudentData, String> emailcolumn;
  @FXML
  private TableColumn<StudentData, String> dobcolumn;
  private ObservableList<StudentData> data;
  public dbConnection dc;
  
  public void initialize(URL url, ResourceBundle rb)
  {
    this.dc = new dbConnection();
  }
  
  @SuppressWarnings({ "rawtypes", "unchecked" })
  @FXML
  private void showstudents(ActionEvent event)
  {
    try
    {
      Connection conn = dbConnection.getConnection();
      this.data = FXCollections.observableArrayList();
      
      ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM students");
      while (rs.next()) 
      {
        this.data.add(new StudentData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
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
    
    this.sttable.setItems(null);
    this.sttable.setItems(this.data);
  }
   
}

