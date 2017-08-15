import java.io.Serializable;


/**
 * Created by Spykexx on 8/12/2017.
 */
public class Customer implements Serializable{
    private String firstName;
    private String lastName;
    private int custNumber;
    static final long serialVersionUID = 133L;
    Customer(String fName, String lName){
        setFirstName(fName);
        setLastName(lName);
    }

    Customer(int ID, String fName, String lName){
        setCustNumber(ID);
        setFirstName(fName);
        setLastName(lName);
    }

    public String getFirstName() {
        return firstName.replaceAll("\\s", "");
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName.replaceAll("\\s", "");
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCustNumber() {
        return custNumber;
    }

    public void setCustNumber(int custNumber) {
        this.custNumber = custNumber;
    }

    @Override
    public String toString() {
        return  "Customer: " + getCustNumber() + " " + getFirstName() + " " + getLastName() + " ";
    }
}
