public class Korisnik {
    private String ime;
    private String username;
    private String password;
    private Racun racun;

    public Korisnik(String ime, String username, String password, Racun racun) {
        this.ime = ime;
        this.username = username;
        this.password = password;
        this.racun = racun;
    }

    public String getIme() {
        return ime;
    }

    public void dodajTransakciju(Transakcija t){
        racun.getTransakcije().add(t);
        racun.setStanje(racun.getStanje() - t.getIznos());
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }
}
