package Admin;

import javafx.scene.control.TextField;

import javafx.scene.control.Button;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


import dbUtil.dbConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminNoticeBoardController implements Initializable 
{

    @FXML
    private DatePicker date;

    @FXML
    private TextField inf;
    
    @FXML
    private Button btnclear;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnloaddata;

    @FXML
    private Button btnRemove;
    
    @FXML
    private TableView<NoticeBoardData> nb;
    
    @FXML
    private TableColumn<NoticeBoardData, String> datecolumn;
    @FXML
    private TableColumn<NoticeBoardData, String> infcolumn;

    
    
    public dbConnection dc;
    private ObservableList<NoticeBoardData> data;
    
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		this.dc = new dbConnection();
	}
	
      @SuppressWarnings({ "rawtypes", "unchecked" })
      @FXML
      private void loadNoticeBoardData(ActionEvent event)
      {
        try
        {
          Connection conn = dbConnection.getConnection();
          this.data = FXCollections.observableArrayList();
          
          ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM notice");
          while (rs.next()) 
          {
            this.data.add(new NoticeBoardData(rs.getString(1), rs.getString(2)));
          }
        }
        catch (SQLException e)
        {
          System.err.println("Error " + e);
        }
        this.datecolumn.setCellValueFactory(new PropertyValueFactory("date"));
        this.infcolumn.setCellValueFactory(new PropertyValueFactory("inf"));
        this.nb.setItems(null);
        this.nb.setItems(this.data);
      }

    @FXML
    private void addAnnouncements(ActionEvent event) 
    {
    	String sql = "INSERT INTO notice(`date`, `inf`) VALUES (? , ?)";
        try
        {
          Connection conn = dbConnection.getConnection();
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1, this.date.getEditor().getText());
          stmt.setString(2, this.inf.getText());
          
          
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
      this.date.setValue(null);
      this.inf.setText("");
    
    }

    @FXML
    private void removeAnnouncements(ActionEvent event) throws ClassNotFoundException,SQLException{
    
  	  String sql="delete from notice where date= ?";
  	  Connection conn;
  	try 
  	{
  		conn = dbConnection.getConnection();
  		PreparedStatement stmt = conn.prepareStatement(sql);
  		stmt.setString(1,this.date.getEditor().getText());
  		stmt.execute();
  		conn.close();
  	} 
  	catch (SQLException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	}
  	  
  	  
  	  /*studenttable.getItems().removeAll(studenttable.getSelectionModel().getSelectedItem());*/
    }



}
