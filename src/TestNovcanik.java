import java.util.ArrayList;
import java.util.Scanner;

public class TestNovcanik {

    public static void main(String[] args){

        System.out.println("===========DOBRODOSLI U APLIKACIJU MOJNOVCANIK");

        ArrayList<Korisnik> korisnici = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        String unos;

        while(true){

            System.out.println("Ukucajte login ako zelite da se ulogujete ili singin ako zelite da se registrujete ili exit ako zelite da izadjete iz programa");
            unos = sc.next();

            if(unos.equals("signin")){
                System.out.println("Unesite ime korisnika");
                String ime = sc.nextLine();
                System.out.println("Unesite korisnicko ime");
                String username = sc.next();
                System.out.println("Unesite zelneju lozinku");
                String password = sc.next();

                korisnici.add(new Korisnik(ime,username,password,new Racun()));

            }else if(unos.equals("login")){
                System.out.println("Unesite username i lozinu(u dva zasebna reda");
                String username = sc.next();
                String password = sc.next();

                boolean logovanje = false;
                int i = 0;
                for(Korisnik k : korisnici){
                    if(k.getIme().equals(username) && k.getPassword().equals(password)) {
                        System.out.println("Uspesno logovanje");
                        logovanje = true;
                        while(true) {
                            System.out.println("Ukucajte kupovina za kupovinu, stanje za ispis stanja,isplata za isplatu, uplata za uplatu, ili izlaz za izlaz sa naloga");
                            unos = sc.next();
                            if(unos.equals("kupovina")){
                                System.out.println("Unesite naziv artikla koji kupujete");
                                String artikal = sc.nextLine();
                                System.out.println("UNesite cenu artikla");
                                int cena = sc.nextInt();
                                System.out.println("Unesite kategoriju proizvoda(hrana/racun/odeca)");
                                String kategorija = sc.next();

                                Transakcija t = new Transakcija(cena,artikal,kategorija);

                                if(cena > korisnici.get(i).getRacun().getStanje()) {
                                    System.out.println("Nemate dovojno novca za kupovinu");
                                }
                                else
                                {
                                    korisnici.get(i).dodajTransakciju(t);
                                    System.out.println("Izvrsena transakcija " + t.toString());
                                }
                            }else if(unos.equals("stanje")){
                                System.out.println("Tranutno na racunu raspolazete sa " + korisnici.get(i).getRacun().getStanje());
                                System.out.println("Prethodne transakcije:");
                                for(Transakcija t : korisnici.get(i).getRacun().getTransakcije()){
                                    System.out.println(t.toString());
                                }
                            }else if(unos.equals("isplata")){
                                System.out.println("Unesite koliko novca zelite da isplatite");
                                int iznos = sc.nextInt();

                                if(iznos > korisnici.get(i).getRacun().getStanje()){
                                    System.out.println("Nemate dovoljno novca za navedenu isplatu");
                                }else{
                                    korisnici.get(i).getRacun().setStanje(korisnici.get(i).getRacun().getStanje()-iznos);
                                    System.out.println("Novo stanje " + korisnici.get(i).getRacun().getStanje());
                                }

                            }else if(unos.equals("uplata")){
                                System.out.println("Unesite koliko novca zelite da uplatite");
                                int iznos = sc.nextInt();

                                if(iznos > korisnici.get(i).getRacun().getStanje()){
                                    System.out.println("Nemate dovoljno novca za navedenu uplatu");
                                }else{
                                    korisnici.get(i).getRacun().setStanje(korisnici.get(i).getRacun().getStanje()+iznos);
                                    System.out.println("Novo stanje " + korisnici.get(i).getRacun().getStanje());
                                }
                            }else{
                                System.out.println("Nepodrzana komanda");
                                System.exit(1);
                            }
                        }
                    }
                    i++;
                }
                if(!logovanje){
                    System.out.println("Ne postoji korisnik za unete kredencijale");
                }

            }else if (unos.equals("exit")){
                System.exit(1);
            }else{
                System.out.println("Nepodrzana komanda");
                System.exit(1);
            }
        }
    }
}
