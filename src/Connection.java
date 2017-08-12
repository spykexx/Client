import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by Spykexx on 8/12/2017.
 */
public class Connection {
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
    public Connection() throws Exception{
        socket =new Socket();
        socket.connect(new InetSocketAddress("localhost",919));

        send("Hello");

        send("Meow");
        receive();
        socket.close();
        }

    public void receive() throws Exception{
        in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //in.readLine();
        System.out.println(in.readLine());

    }
    public void send(String s) throws Exception{
        out=new PrintWriter(socket.getOutputStream());
        out.println(s);
        out.flush();
    }
}
