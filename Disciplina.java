public class Disciplina {
    private String Nume;
    private int Cursuri;
    private int Seminare;

    public Disciplina(String Linie){
        this.Nume = Linie.split(",")[0];
        this.Cursuri = 0;
        this.Seminare = 0;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public int getCursuri() {
        return Cursuri;
    }

    public void setCursuri(int cursuri) {
        Cursuri = cursuri;
    }

    public int getSeminare() {
        return Seminare;
    }

    public void setSeminare(int seminare) {
        Seminare = seminare;
    }

    @Override
    public String toString() {
        return Nume + " - " + Cursuri + " - " + Seminare;
    }
}
