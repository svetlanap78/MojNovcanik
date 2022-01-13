public class Transakcija {
    private int iznos;
    private String opis;
    private String kategorija;

    public Transakcija(int iznos, String opis, String kategorija) {
        this.iznos = iznos;
        this.opis = opis;
        this.kategorija = kategorija;
    }

    public int getIznos() {
        return iznos;
    }

    public void setIznos(int iznos) {
        this.iznos = iznos;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    @Override
    public String toString() {
        return "Transakcija{" +
                "iznos=" + iznos +
                ", opis='" + opis + '\'' +
                ", kategorija='" + kategorija + '\'' +
                '}';
    }
}
