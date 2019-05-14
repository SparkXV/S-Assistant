package Teacher;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dbUtil.dbConnection;
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

public class TeacherGradeController implements Initializable{
	 
	    @FXML
	    private TextField fname;

	    @FXML
	    private TextField lname;

	    @FXML
	    private DatePicker dob;

	    @FXML
	    private TextField grade;
	
	    @FXML
	    private TextField id;

	    @FXML
	    private TextField email;

    @FXML
    private TableColumn<GradeData, String> lnamecolumn;

    @FXML
    private Button btnclear;

    @FXML
    private TableColumn<GradeData, String> dobcolumn;

    @FXML
    private Button btnremove;

    @FXML
    private Button btnAdd;

    @FXML
    private TableColumn<GradeData, String> fnamecolumn;

    @FXML
    private Button btnload;

    @FXML
    private TableColumn<GradeData, String> idcolumn;

    @FXML
    private TableColumn<GradeData, String> emailcolumn;

    @FXML
    private TableView<GradeData> gt;

    @FXML
    private TableColumn<GradeData, String> gradecolumn;
    private ObservableList<GradeData> data;
    public dbConnection dc;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.dc = new dbConnection();
		
	}
    @FXML
    private void addgrade(ActionEvent event) {
    	String sql = "INSERT INTO `grade`(`id`, `fname`, `lname`, `email`, `DOB`, `Grade`) VALUES (? , ?, ?, ?, ?, ?)";
        try
        {
          Connection conn = dbConnection.getConnection();
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1, this.id.getText());
          stmt.setString(2, this.fname.getText());
          stmt.setString(3, this.lname.getText());
          stmt.setString(4, this.email.getText());
          stmt.setString(5, this.dob.getEditor().getText());
          stmt.setString(6, this.grade.getText());
          
          stmt.execute();
          conn.close();
        }
        catch (SQLException e)
        {
          System.err.println("Got an exception!");
          System.err.println(e.getMessage());
        }

    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@FXML
    private void showgrade(ActionEvent event) {
    	try
        {
          Connection conn = dbConnection.getConnection();
          this.data = FXCollections.observableArrayList();
          
          ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM grade");
          while (rs.next()) 
          {
            this.data.add(new GradeData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6)));
          }
        }
        catch (SQLException e)
        {
          System.err.println("Error " + e);
        }
        this.idcolumn.setCellValueFactory(new PropertyValueFactory("ID"));
        this.fnamecolumn.setCellValueFactory(new PropertyValueFactory("firstName"));
        this.lnamecolumn.setCellValueFactory(new PropertyValueFactory("lastName"));
        this.emailcolumn.setCellValueFactory(new PropertyValueFactory("email"));
        this.dobcolumn.setCellValueFactory(new PropertyValueFactory("DOB"));
        this.gradecolumn.setCellValueFactory(new PropertyValueFactory("Grade"));
        
        this.gt.setItems(null);
        this.gt.setItems(this.data);

    }

    @FXML
    private void clearfield(ActionEvent event) {
    	this.id.setText("");
        this.fname.setText("");
        this.lname.setText("");
        this.email.setText("");
        this.dob.setValue(null);
        this.grade.setText("");
       
    }
  
    
    @FXML
    void removedata(ActionEvent event)
    {
    String sql="delete from grade where id= ?";
  	Connection conn;
  	try 
  	{
  		conn = dbConnection.getConnection();
  		PreparedStatement stmt = conn.prepareStatement(sql);
  		stmt.setString(1,this.id.getText());
  		stmt.execute();
  		conn.close();
  	} 
  	catch (SQLException e) 
  	{
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	}

    }
}