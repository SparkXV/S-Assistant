package Student;


import javafx.scene.control.Button;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Admin.NoticeBoardData;
import dbUtil.dbConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentNoticeBoardController implements Initializable 
{
    @FXML
    private Button btnshow;
    
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
      private void showinf(ActionEvent event)
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

}
