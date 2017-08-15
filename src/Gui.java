import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Spykexx on 8/12/2017.
 */
public class Gui extends JFrame {
    private JPanel master;
    private JPanel custG;
    private JPanel transG;
    private JTextArea output;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField description;
    private JTextField price;
    private JButton submit;
    private JTextArea tAPanel;
    Customer customer;
    Purchase purchase;



    public Gui() throws Exception{
        master = new JPanel(new GridLayout(4, 2, 10, 40));
        custG = new JPanel(new GridLayout(2, 2, 10, 30));
        transG = new JPanel(new GridLayout(2, 2, 10, 30));
        tAPanel= new JTextArea(4, 10);
        JLabel lFName = new JLabel("First Name: ");
        JLabel lLName = new JLabel("Last Name: ");
        output = new JTextArea(10, 10);
        firstName = new JTextField("First Name", 5);
        lastName = new JTextField("Last Name", 5);
        description = new JTextField("Description", 5);
        price = new JTextField("00.00", 5);
        JLabel ldescrip = new JLabel("Item Description: ");
        JLabel lprice = new JLabel("Price: ");
        submit = new JButton("Submit");
        JScrollPane JSP = new JScrollPane(output);
        custG.add(lFName);
        custG.add(firstName);
        custG.add(lLName);
        custG.add(lastName);
        transG.add(ldescrip);
        transG.add(description);
        transG.add(lprice);
        transG.add(price);
        tAPanel.add(JSP);
        master.add(custG);
        master.add(transG);
        master.add(submit);
        master.add(JSP);
        this.getContentPane().add(master);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(getFirstName().getText().equals("") || getLastName().getText().equals("") ||
                        getDescription().getText().equals("") || getPrice().getText().equals("")) {

                } else{
                    customer = new Customer(getFirstName().getText(), getLastName().getText());
                    purchase = new Purchase(getDescription().getText(), Double.parseDouble(getPrice().getText()));
                    try {
                        Connection connect = new Connection(returnCustomer(), returnPurchase());

                        output.setText(connect.returnList().replace("[", "").replace("]", "").replace(",", ""));
                        //output.getDocument().remove(0, 1); //removes the very first line that is blank
                    } catch (Exception i) {
                        i.printStackTrace();
                    }
                }
            }
        });
    }

    public Customer returnCustomer(){
        return customer;
    }
    public Purchase returnPurchase() { return purchase;}

    public JTextArea getOutput() {
        return output;
    }

    public void setOutput(String s) {
        this.output.setText(s);
    }

    public JTextField getFirstName() {
        return firstName;
    }

    public void setFirstName(JTextField firstName) {
        this.firstName = firstName;
    }

    public JTextField getLastName() {
        return lastName;
    }

    public void setLastName(JTextField lastName) {
        this.lastName = lastName;
    }

    public JTextField getDescription() {
        return description;
    }

    public void setDescription(JTextField description) {
        this.description = description;
    }

    public JTextField getPrice() {
        return price;
    }

    public void setPrice(JTextField price) {
        this.price = price;
    }
}
