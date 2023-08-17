public class Tranzactie
{
    private int Cod;
    private int Q;
    private String Tip;

    public int getCod() {
        return Cod;
    }

    public void setCod(int cod) {
        Cod = cod;
    }

    public int getQ() {
        return Q;
    }

    public void setQ(int q) {
        Q = q;
    }

    public String getTip() {
        return Tip;
    }

    public void setTip(String tip) {
        Tip = tip;
    }

    public Tranzactie(int cod, int q, String tip) {
        Cod = cod;
        Q = q;
        Tip = tip;
    }

    @Override
    public String toString() {
        return Cod + " - " + Q + " - " + Tip;
    }
}
