import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client1 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8082);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("GET /one HTTP/1.1");
        out.println();

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
