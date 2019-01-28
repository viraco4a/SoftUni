import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;

    private ServerSocket tcpListener;

    public Server(int port) {
        this.port = port;
    }

    private String getResponse(){
        return "HTTP/1.1 200 OK" + System.lineSeparator()
                + "Host: SoftUni Server 2019" + System.lineSeparator()
                + "Content-Type: text/html" + System.lineSeparator()
                + System.lineSeparator()
                + "<center><h1>Hello World!</h1></center>";
    }

    public void run() throws IOException {
        this.tcpListener = new ServerSocket(this.port);

        System.out.println("Listening on: http://localhost:" + this.port);

        while (true){
            Socket clientConnection = this.tcpListener.accept();
            System.out.println("CLIENT CONNECTED!");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                    clientConnection.getInputStream()
            ));

            String requestContent = "";
            String line = "";

            while ((line = reader.readLine()) != null && line.length() > 0){
                requestContent += line + System.lineSeparator();
            }

            System.out.println(requestContent);

            OutputStream outputStream = clientConnection.getOutputStream();

            outputStream.write(this.getResponse().getBytes());

            reader.close();
            outputStream.close();
        }
    }
}
