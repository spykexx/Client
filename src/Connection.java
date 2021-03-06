import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

public class Connection {
        private Socket socket = null;
        private InetSocketAddress ISA = new InetSocketAddress("localhost", 919);
        private ObjectInputStream in = null;
        private ObjectOutputStream out = null;
        private List<Customer> customerL = null;
        private List<Purchase> purchaseL = null;
    public Connection() throws Exception{
        }
    public Connection(Customer e, Purchase p) throws Exception{
        socket = new Socket();
        socket.connect(ISA);
        receive();
        if(customerL.size() != 0) {
            e.setCustNumber(customerL.get(customerL.size() - 1).getCustNumber() + 1);
            p.setTransactionID(purchaseL.get(purchaseL.size() - 1).getTransactionID() + 1);
        }else{
            e.setCustNumber(1);
            p.setTransactionID(1);
        }
        send(e);
        send(p);
        receive();
    }
    public void receive() throws Exception{
        in = new ObjectInputStream(socket.getInputStream());
        customerL = (List<Customer>) in.readObject();
        purchaseL = (List<Purchase>) in.readObject();

    }
    public void send(Customer e) throws Exception{
        out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(e);
        out.flush();
    }
    public void send(Purchase p)throws Exception{
        out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(p);
        out.flush();
    }

    public List<Customer> returnCust(){
        return customerL;
    }
    public List<Purchase> returnPur(){
        return purchaseL;
    }


    public String returnList(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < customerL.size(); i++){
            sb.append(customerL.get(i).toString() + "\n" + "   " + purchaseL.get(i).toString());
        }
        return sb.toString();
    }

}
