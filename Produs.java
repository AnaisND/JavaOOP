import java.util.Comparator;

public class Produs implements Comparator
{
    private int Cod;
    private String Nume;
    private double Pret;

    public int getCod() {
        return Cod;
    }

    public void setCod(int cod) {
        Cod = cod;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public double getPret() {
        return Pret;
    }

    public void setPret(double pret) {
        Pret = pret;
    }

    public Produs(int cod, String nume, double pret) {
        Cod = cod;
        Nume = nume;
        Pret = pret;
    }

    public Produs(String linie) {
        Cod = Integer.parseInt(linie.split(",")[0]);
        Nume = linie.split(",")[1];
        Pret = Double.parseDouble(linie.split(",")[2]);
    }

    @Override
    public String toString() {
        return Cod + " - " + Nume + " - " + Pret;
    }

    @Override
    public int compare(Object o1, Object o2) {
        Produs O1 = (Produs) o1;
        Produs O2 = (Produs) o2;
        return (O1.Nume).compareTo(O2.getNume());
    }
}
