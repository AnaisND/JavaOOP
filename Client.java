import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client
{
    private static final int PORT = 8080;
    private static final String URL = "localhost";

    public static void main(String[] args)
    {
        try(Socket socket = new Socket(URL, PORT);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);)
        {
            String CodProdus = "1,Stafide 200g,6.03";
            printWriter.println(CodProdus);

            String StockVal = bufferedReader.readLine();
            System.out.println(StockVal);
            bufferedReader.close();
            printWriter.close();
            socket.close();
        }
        catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
