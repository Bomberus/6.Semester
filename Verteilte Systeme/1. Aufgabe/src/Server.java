import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        //An Port 13000 binden:
        try {
            serverSocket = new ServerSocket(7575);
        } catch (IOException e) {
            System.out.println("Binden an Port  13000 schlug fehl: " + e.getMessage());
            System.exit(-1);
        }

        //In einer Endlosschleife auf eingehende Anfragen warten.
        while (true) {
            try {
                //Blocken, bis eine Anfrage kommt:
                System.out.println("ServerSocket - accepting");
                Socket clientSocket = serverSocket.accept();

                //Wenn die Anfrage da ist, dann wird ein Thread gestartet, der
                //die weitere Verarbeitung übernimmt.
                System.out.println("ServerSocket - accept done");

                Thread threadHandler = new Thread(new DateHandler(clientSocket));
                threadHandler.start();

                System.out.println("ServerSocket - Thread started, next client please...");
            } catch (IOException e) {
                System.out.println("'accept' auf Port 13000 fehlgeschlagen");
                System.exit(-1);
            }

        }
    }
}
