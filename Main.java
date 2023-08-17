import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Programare> Programari = new ArrayList<>();
        try (var f = new BufferedReader(new FileReader("Fisiere/Orar.txt"))) {
            Programari = f.lines().map(Programare::new).collect(Collectors.toList());
        } catch (Exception e) {
            e.fillInStackTrace();
        }

        //System.out.println(Programari);
        int c = 0;
        int s = 0;
        for (Programare i : Programari) {
            if (i.getTipul() == Tip.CURS) {
                c++;
            } else {
                s++;
            }
        }
        //System.out.println("Numar cursuri: "+c);
        //System.out.println("Numar seminare: "+s);

        List<Disciplina> Discipline = new ArrayList<>();
        try (var f = new BufferedReader(new FileReader("Fisiere/Orar.txt"))) {
            Discipline = f.lines().map(Disciplina::new).collect(Collectors.toList());
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        for (Disciplina j : Discipline) {
            for (Programare i : Programari) {
                if (i.getDisciplina().equals(j.getNume())) {
                    if (i.getTipul() == Tip.CURS) {
                        j.setCursuri(j.getCursuri() + 1);
                    } else if (i.getTipul() == Tip.SEMINAR) {
                        j.setSeminare(j.getSeminare() + 1);
                    }
                }
            }
        }
        for(int a=0;a<Discipline.size();a++){
            if(Discipline.get(a).getCursuri()<1){
                Discipline.remove(a);
            }
        }
        for(int a=0;a<Discipline.size();a++) {
            if (Discipline.get(a).getSeminare() < 2) {
                Discipline.remove(a);
            }
        }
        for(int a=0;a<Discipline.size()-1;a++) {
            for(int b=a+1;b<Discipline.size();b++){
                if(Discipline.get(a).getNume().equals(Discipline.get(b).getNume())){
                    Discipline.remove(Discipline.get(b));
                }
            }
        }
        for(Programare i : Programari){
            int b = 0;
            for(Disciplina j : Discipline){
                if(i.getDisciplina().equals(j.getNume())){
                    b = 1;
                }
            }
            if(b==1){System.out.println(i);}
        }
        Programari.sort(Programare::compareTo);
        /*try{
            FileOutputStream fout = new FileOutputStream("Fisiere/Programari.dat");
            DataOutputStream dout = new DataOutputStream(fout);
            for(int a=0;a<Programari.size();a++){
                dout.writeUTF(Programari.get(a).toString());
            }
            dout.close();
        }
        catch(Exception e){e.fillInStackTrace();}*/
        try{
            FileInputStream fin = new FileInputStream("Fisiere/Programari.dat");
            DataInputStream din = new DataInputStream(fin);
            String S = din.readUTF();
            System.out.println(S);
            din.close();
        }
        catch(Exception e){e.fillInStackTrace();}
    }
}