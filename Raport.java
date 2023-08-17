public class Raport
{
    private String Nume;
    private int Nr;

    private double Pret;

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public int getNr() {
        return Nr;
    }

    public void setNr(int nr) {
        Nr = nr;
    }

    public double getPret() {
        return Pret;
    }

    public void setPret(double pret) {
        Pret = pret;
    }

    public Raport(String nume, int nr, double pret) {
        Nume = nume;
        Nr = nr;
        Pret = pret;
    }

    public double ValoareStoc()
    {
        return Nr*Pret;
    }

    @Override
    public String toString() {
        return Nume + " - " + Nr;
    }
}
