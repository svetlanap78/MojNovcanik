import java.util.ArrayList;

public class Racun {
    private String brRacuna;
    private int stanje;
    private ArrayList<Transakcija> transakcije;

    private static int brojacRacuna = 0;

    public Racun(int stanje) {
        this.brRacuna = brojacRacuna + "";
        this.stanje = stanje;
        this.transakcije = new ArrayList<>();
        brojacRacuna++;
    }

    public Racun(){
        this.stanje = 0;
        this.brRacuna = brojacRacuna + "";
        this.transakcije = new ArrayList<>();
        brojacRacuna++;
    }

    public String getBrRacuna() {
        return brRacuna;
    }

    public void setBrRacuna(String brRacuna) {
        this.brRacuna = brRacuna;
    }

    public int getStanje() {
        return stanje;
    }

    public void setStanje(int stanje) {
        this.stanje = stanje;
    }

    public ArrayList<Transakcija> getTransakcije() {
        return transakcije;
    }

    public void setTransakcije(ArrayList<Transakcija> transakcije) {
        this.transakcije = transakcije;
    }
}

