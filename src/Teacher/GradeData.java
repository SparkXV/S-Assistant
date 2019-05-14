package Teacher;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GradeData
{
  private final StringProperty ID;
  private final StringProperty firstName;
  private final StringProperty lastName;
  private final StringProperty email;
  private final StringProperty DOB;
  private final StringProperty Grade;
  
  public GradeData(String id, String firstname, String lastname, String email, String dob,String grade)
  {
    this.ID = new SimpleStringProperty(id);
    this.firstName = new SimpleStringProperty(firstname);
    this.lastName = new SimpleStringProperty(lastname);
    this.email = new SimpleStringProperty(email);
    this.DOB = new SimpleStringProperty(dob);
    this.Grade=new SimpleStringProperty(grade);
  }
  
  public String getID()
  {
    return (String)this.ID.get();
  }
  
  public String getFirstName()
  {
    return (String)this.firstName.get();
  }
  
  public String getLastName()
  {
    return (String)this.lastName.get();
  }
  
  public String getEmail()
  {
    return (String)this.email.get();
  }
  
  public String getDOB()
  {
    return (String)this.DOB.get();
  }
  public String getgrade()
  {
    return (String)this.Grade.get();
  }
  
  public void setID(String value)
  {
    this.ID.set(value);
  }
  
  public void setFirstName(String value)
  {
    this.firstName.set(value);
  }
  
  public void setLastName(String value)
  {
    this.lastName.set(value);
  }
  
  public void setEmail(String value)
  {
    this.email.set(value);
  }
  
  public void setDOB(String value)
  {
    this.DOB.set(value);
  }
  public void setgrade(String value)
  {
    this.Grade.set(value);
  }
  
  public StringProperty idProperty()
  {
    return this.ID;
  }
  
  public StringProperty firstNameProperty()
  {
    return this.firstName;
  }
  
  public StringProperty lastNameProperty()
  {
    return this.lastName;
  }
  
  public StringProperty emailProperty()
  {
    return this.email;
  }
  
  public StringProperty dobProperty()
  {
    return this.DOB;
  }
  public StringProperty gradeProperty()
  {
    return this.Grade;
  }
}
