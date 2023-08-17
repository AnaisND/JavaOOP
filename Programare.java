public class Programare implements Comparable{
    private String Disciplina;
    private int Zi;
    private int Interval;
    private Tip Tipul;
    private String Formatie;

    public Programare(String Linie){
        this.Disciplina = Linie.split(",")[0];
        this.Zi = Integer.parseInt(Linie.split(",")[1]);
        this.Interval = Integer.parseInt(Linie.split(",")[2]);
        this.Tipul = Tip.valueOf(Linie.split(",")[3]);
        this.Formatie = Linie.split(",")[4];
    }

    public String getDisciplina() {
        return Disciplina;
    }

    public void setDisciplina(String disciplina) {
        Disciplina = disciplina;
    }

    public int getZi() {
        return Zi;
    }

    public void setZi(int zi) {
        Zi = zi;
    }

    public int getInterval() {
        return Interval;
    }

    public void setInterval(int interval) {
        Interval = interval;
    }

    public Tip getTipul() {
        return Tipul;
    }

    public void setTipul(Tip tipul) {
        Tipul = tipul;
    }

    public String getFormatie() {
        return Formatie;
    }

    public void setFormatie(String formatie) {
        Formatie = formatie;
    }

    @Override
    public int compareTo(Object o) {
        Programare O = (Programare)o;
        if(this.getZi()==O.getZi()){
            return Integer.compare(this.getInterval(),O.getInterval());
        }
        else{
            return Integer.compare(this.getZi(),O.getZi());
        }
    }

    @Override
    public String toString() {
        return Disciplina + " - " + Zi + " - " + Interval + " - " + Tipul + " - " + Formatie;
    }
}
