package Student;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Teacher.GradeData;
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

public class StudentGradeController implements Initializable{
	 
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
    private TableColumn<GradeData, String> dobcolumn;


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
}