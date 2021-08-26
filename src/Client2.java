import java.io.*;
import java.net.Socket;

public class Client2 {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 8082);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("GET /two HTTP/1.1");

        String line = in.readLine();
        while(line != null) {
            System.out.println(line);
            line = in.readLine();
        }

        in.close();
        out.close();
        socket.close();
    }
}
