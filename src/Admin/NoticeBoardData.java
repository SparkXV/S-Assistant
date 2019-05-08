package Admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class NoticeBoardData
{
  private final StringProperty date;
  private final StringProperty inf;
  
  public NoticeBoardData(String Date, String Inf)
  {
    this.date = new SimpleStringProperty(Date);
    this.inf =  new SimpleStringProperty(Inf);
  }
  
  public String getdate()
  {
    return (String)this.date.get();
  }
  
  public String getinf()
  {
    return (String)this.inf.get();
  }
  
  public void setdate(String value)
  {
    this.date.set(value);
  }
  
  public void setinf(String value)
  {
    this.inf.set(value);
  }
  
  public StringProperty dateProperty()
  {
    return this.date;
  }
  
  public StringProperty infProperty()
  {
    return this.inf;
  }
}
