import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Server
{
    public static void HandleClient(Socket socket, List<Raport> R)
    {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());)
        {
            String Produs = bufferedReader.readLine();
            String[] Parti = Produs.split(",");
            String NumeProdus = Parti[1];
            double Valoare = 0;
            for(Raport i : R)
            {
                if(i.getNume().equals(NumeProdus))
                {
                    Valoare = i.ValoareStoc();
                }
            }
            printWriter.println(Valoare);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args)
    {
        List<Produs> Produse = new ArrayList<Produs>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("data\\Produse"))) {
            Produse = bufferedReader.lines().map(Produs::new).collect(Collectors.toList());
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<TranzactieQ> TranzactiiQ = new ArrayList<TranzactieQ>();
        try(FileReader fileReader = new FileReader("data\\Tranzactii.json")){
            JSONArray JSONTranzactiiQ = new JSONArray(new JSONTokener(fileReader));
            for(int i=0;i<JSONTranzactiiQ.length();i++){
                JSONObject JSONTranzactieQ = JSONTranzactiiQ.getJSONObject(i);
                TranzactieQ TQ = new TranzactieQ(JSONTranzactieQ.getInt("codProdus"), JSONTranzactieQ.getInt("cantitate"), JSONTranzactieQ.getString("tip"));
                TranzactiiQ.add(TQ);
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Collections.sort(TranzactiiQ, new Comparator<TranzactieQ>() {
            @Override
            public int compare(TranzactieQ o1, TranzactieQ o2) {
                if(o1.getCod() > o2.getCod()){return 1;}
                else if(o1.getCod() < o2.getCod()){return -1;}
                else {return 0;}
            }
        });
        for(int i=0; i<TranzactiiQ.size()-1; i++)
        {
            for(int j=i+1; j<TranzactiiQ.size(); j++)
            {
                if(TranzactiiQ.get(i).getCod() == TranzactiiQ.get(j).getCod())
                {
                    TranzactiiQ.get(i).setNr(TranzactiiQ.get(i).getNr() + 1);
                }
            }
        }
        for(int i=0; i<TranzactiiQ.size()-1; i++)
        {
            for(int j=i+1; j<TranzactiiQ.size(); j++)
            {
                if(TranzactiiQ.get(i).getCod() == TranzactiiQ.get(j).getCod())
                {
                    TranzactiiQ.get(j).setNr(0);
                }
            }
        }
        List<TranzactieQ> TFinale = new ArrayList<>();
        for(int i=0; i<TranzactiiQ.size()-1; i++)
        {
            if(TranzactiiQ.get(i).getNr() != 0)
            {
                TFinale.add(TranzactiiQ.get(i));
            }
        }
        List<Raport> Raporturi = new ArrayList<>();
        if(Produse.size() == TFinale.size())
        {
            for(Produs i : Produse)
            {
                for(TranzactieQ j : TFinale)
                {
                    if(i.getCod() == j.getCod())
                    {
                        Raport R = new Raport(i.getNume(), j.getNr(), i.getPret());
                        Raporturi.add(R);
                    }
                }
            }
        }


        int PORT = 8080;
        try(ServerSocket serverSocket = new ServerSocket(PORT);)
        {
            while(true)
            {
                Socket Client = serverSocket.accept();
                Thread ThreadClient = new Thread(() -> HandleClient(Client, Raporturi));
                ThreadClient.start();
                break;
            }
            serverSocket.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
