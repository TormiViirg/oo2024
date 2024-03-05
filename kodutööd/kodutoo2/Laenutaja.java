public class Laenutaja {
    String nimi;
    int laenutatudSuusad;

    public Laenutaja(String nimi) {
        this.nimi = nimi;
        this.laenutatudSuusad = 0;
    }

    public void laenutaSuusad() {
        laenutatudSuusad++;
        System.out.println(nimi + " laenutas suusad. Kokku on laenutatud järgnev arv suuski: " + laenutatudSuusad);
    }

    public void tagastaSuusad() {
        if (laenutatudSuusad > 0) {
            laenutatudSuusad--;
            System.out.println(nimi + " tagastas suusa paari. Veel on tagastada: " + laenutatudSuusad);
        } else {
            System.out.println(nimi + " ei ole veel meilt suuski laenutanud.");
        }
    }
}
