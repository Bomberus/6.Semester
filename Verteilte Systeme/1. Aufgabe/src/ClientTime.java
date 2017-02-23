import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClientTime {
    public static void main(String[] args) {
        System.out.println ("Text eingeben, 'Enter' schickt ihn zum Server. Eingabe von 'X' zum Beenden!");

        // Tastatureingaben werden eingelesen:
        BufferedReader reader = new BufferedReader ( new InputStreamReader (System.in));

        //Server-Verbindung aufbauen:
        Socket socketServer = null;
        try
        {
            socketServer = new Socket ("localhost", 7575);
        }
        catch (UnknownHostException ex)
        {
            System.out.println("UnknownHostException bei Verbindung zu Host 'localhost', Port 7575: " + ex.getMessage());
            System.exit(-1);
        }
        catch (IOException ex)
        {
            System.out.println("IOException bei Verbindung zu Host 'localhost', Port 7575: " + ex.getMessage());
            System.exit(-1);
        }

        try
        {
            //Eingabe-Reader/Ausgabe-Writer erzeugen:
            PrintWriter out = new PrintWriter(socketServer.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socketServer.getInputStream()));
            //Solange der User etwas eingibt (und danach Enter drückt), werden die Daten
            //zum Server geschickt. Eingabe von "X" beendet alles.
            String textInput = null;
            while ( (textInput = reader.readLine() ) != null && !"END".equals(textInput.toUpperCase()))
            {
                System.out.println("Client-Eingabe: " + textInput);

                //Ab zum Server:
                out.println(textInput);
                out.flush();

                System.out.println("Warten auf Server-Antwort...");
                //Server schickt uns "toUpper" der Eingabe:
                String textServer = in.readLine();
                System.out.println("Server-Antwort: " + textServer);
            }
            //User hat "X" eingegeben: Socket dichtmachen.
            socketServer.close();
        }
        catch (IOException e)
        {
            System.out.println ("IOException: " + e.getMessage());
            System.exit(-1);
        }
    }
}
