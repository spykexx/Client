import javax.swing.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws Exception {
        Gui2 g = new Gui2();

        g.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        g.setResizable(false);
        g.setSize(800,400);
        g.setLocationRelativeTo(null);
        g.setVisible(true);
        //Connection connect = new Connection();
    }

}
