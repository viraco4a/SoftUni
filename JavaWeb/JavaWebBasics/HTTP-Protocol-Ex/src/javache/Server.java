package javache;

import javache.handlers.ConnectionHandler;
import javache.handlers.RequestHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.FutureTask;

public class Server {
    private static final String LISTENING_MESSAGE = "Listening on port: ";
    private static final int SOCKET_TIMEOUT_MILLISECONDS = 5000;
    private static final String TIMEOUT_DETECTION_MESSAGE = "Timeout detected!";

    private ServerSocket server;
    private int port;
    private int timeouts;

    public Server(int port) {
        this.port = port;
        this.timeouts = 1;
    }

    public void run() throws IOException {
        this.server = new ServerSocket(this.port);
        System.out.println(LISTENING_MESSAGE + this.port);

        this.server.setSoTimeout(SOCKET_TIMEOUT_MILLISECONDS);

        while (true){
            try (Socket clientSocket = this.server.accept()){
                clientSocket.setSoTimeout(SOCKET_TIMEOUT_MILLISECONDS);

                ConnectionHandler connectionHandler =
                        new ConnectionHandler(clientSocket, new RequestHandler());
                FutureTask<?> task = new FutureTask<>(connectionHandler, null);
                task.run();
            } catch (SocketTimeoutException e) {
                System.out.println(String.format("%s. %s",
                        this.timeouts,
                        TIMEOUT_DETECTION_MESSAGE));
                this.timeouts++;
            }
        }
    }
}
