import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui2 extends JFrame {
    private JPanel master;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField description;
    private JTextField price;
    private JButton submit;
    private JTable infoTable;
    Customer customer;
    Purchase purchase;
    private Object[] data = new Object[5];
    private String[] colName = {"ID", "First Name", "Last Name", "Description", "Price"};
    DefaultTableModel tableModel;

    public Gui2() {
        $$$setupUI$$$();
        setContentPane(master);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (getFirstName().getText().equals("") || getLastName().getText().equals("") ||
                        getDescription().getText().equals("") || getPrice().getText().equals("")) {

                } else {
                    customer = new Customer(getFirstName().getText(), getLastName().getText());
                    purchase = new Purchase(getDescription().getText(), Double.parseDouble(getPrice().getText()));
                    try {
                        Connection connect = new Connection(returnCustomer(), returnPurchase());
                        tableModel.setRowCount(0);
                        for (int i = 0; i < connect.returnCust().size(); i++) {
                            data[0] = connect.returnCust().get(i).getCustNumber();
                            data[1] = connect.returnCust().get(i).getFirstName();
                            data[2] = connect.returnCust().get(i).getLastName();
                            data[3] = connect.returnPur().get(i).getDescription();
                            data[4] = connect.returnPur().get(i).getPrice();
                            tableModel.addRow(data);

                        }

                    } catch (Exception i) {
                        i.printStackTrace();
                    }
                }
            }
        });
    }

    public Customer returnCustomer() {
        return customer;
    }

    public Purchase returnPurchase() {
        return purchase;
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

    private void createUIComponents() {
        tableModel = new DefaultTableModel() {
            Class[] types = {Integer.class, String.class, String.class, String.class, Double.class};

            @Override
            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            @Override
            public int getColumnCount() {
                return colName.length;
            }

            @Override
            public String getColumnName(int column) {
                return colName[column];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        infoTable = new JTable(tableModel);
    }

    private void $$$setupUI$$$() {
        createUIComponents();
        master = new JPanel();
        master.setLayout(new GridBagLayout());
        master.setBackground(new Color(-14136495));
        master.setMinimumSize(new Dimension(70, 200));
        master.setPreferredSize(new Dimension(600, 200));
        final JLabel label1 = new JLabel();
        label1.setFont(new Font(label1.getFont().getName(), label1.getFont().getStyle(), 20));
        label1.setText("First Name:");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipady = 10;
        master.add(label1, gbc);
        final JLabel label2 = new JLabel();
        label2.setFont(new Font(label2.getFont().getName(), label2.getFont().getStyle(), 20));
        label2.setText("Last Name: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipady = 10;
        master.add(label2, gbc);
        final JLabel label3 = new JLabel();
        label3.setFont(new Font(label3.getFont().getName(), label3.getFont().getStyle(), 20));
        label3.setText("Description: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipady = 10;
        master.add(label3, gbc);
        final JLabel label4 = new JLabel();
        label4.setFont(new Font(label4.getFont().getName(), label4.getFont().getStyle(), 20));
        label4.setText("Price: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipady = 10;
        master.add(label4, gbc);
        firstName = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 0.08;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        master.add(firstName, gbc);
        lastName = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 0.08;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        master.add(lastName, gbc);
        description = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 0.08;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        master.add(description, gbc);
        price = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weightx = 0.08;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        master.add(price, gbc);
        final JSeparator separator1 = new JSeparator();
        separator1.setMinimumSize(new Dimension(0, 0));
        separator1.setOrientation(1);
        separator1.setPreferredSize(new Dimension(0, 0));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.01;
        gbc.fill = GridBagConstraints.VERTICAL;
        master.add(separator1, gbc);
        submit = new JButton();
        submit.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 4;
        master.add(submit, gbc);
        final JScrollPane scrollPane1 = new JScrollPane();
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridheight = 4;
        gbc.weightx = 0.15;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 15, 0, 0);
        master.add(scrollPane1, gbc);
        scrollPane1.setViewportView(infoTable);
    }

    public JComponent $$$getRootComponent$$$() {
        return master;
    }
}
