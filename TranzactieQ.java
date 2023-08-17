public class TranzactieQ
{
    private int Cod;
    private int Q;
    private String Tip;
    private int Nr;

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

    public int getNr() {
        return Nr;
    }

    public void setNr(int nr) {
        Nr = nr;
    }

    public TranzactieQ(int cod, int q, String tip) {
        Cod = cod;
        Q = q;
        Tip = tip;
        Nr = 1;
    }

    @Override
    public String toString() {
        return Cod + " - " + Q + " - " + Tip + " - " +Nr;
    }
}
