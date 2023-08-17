import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)
    {
        //Citire lista de produse
        List<Produs> Produse = new ArrayList<Produs>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("data\\Produse"))) {
            Produse = bufferedReader.lines().map(Produs::new).collect(Collectors.toList());
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Citire lista tranzactii
        List<Tranzactie> Tranzactii = new ArrayList<Tranzactie>();
        try(FileReader fileReader = new FileReader("data\\Tranzactii.json")){
            JSONArray JSONTranzactii = new JSONArray(new JSONTokener(fileReader));
            for(int i=0;i<JSONTranzactii.length();i++){
                JSONObject JSONTranzactie = JSONTranzactii.getJSONObject(i);
                Tranzactie T = new Tranzactie(JSONTranzactie.getInt("codProdus"), JSONTranzactie.getInt("cantitate"), JSONTranzactie.getString("tip"));
                Tranzactii.add(T);
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
/*
        //1
        System.out.println(Produse.size());

        //2 - ordine alfabetica
        Collections.sort(Produse, new Comparator<Produs>() {
            @Override
            public int compare(Produs o1, Produs o2) {
                return (o1.getNume()).compareTo(o2.getNume());
            }
        });
        for(Produs i : Produse){
            System.out.println(i);
        }
*/
        //3
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

        //4
        /*double Sold = 0;
        for(Raport i : Raporturi)
        {
            Sold = Sold + i.ValoareStoc();
        }
        for(Raport i : Raporturi)
        {
            System.out.println(i.toString()+ " - " +i.ValoareStoc());
        }
        System.out.println(Sold);*/


    }
}