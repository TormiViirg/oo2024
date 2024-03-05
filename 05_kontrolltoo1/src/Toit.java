import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
//6:klass toidu jaoks, seob omavahel roa(valmis toidu) nimetuse ja selle millega see juba varem seotud kõik on ja toidukomponendi ja kõik millega see omaltpoolt seotud on, et saaks hiljem mainis kasutada sedataolist listi,
public class Toit {
    String nimetus;
    ArrayList<ToiduKomponent> komponendid;

    public Toit(String nimetus) {
        this.nimetus = nimetus;
        this.komponendid = new ArrayList<>();
    }

    public void lisaKomponent(ToiduKomponent komponent) {
        this.komponendid.add(komponent);
    }
    //7:Küsib siin toidu klassist toidukomponentide  valkude, rasvade ja süsivesikute kogused ja liidab samad tüübid kokku nii mitu korda kui neid on saades koguValkudekoguse, koguRasvadeKoguse ja koguSysiveikute koguse
    public void arvutaToitainetekogusRoas() {
        double koguValkudeKogus = 0;
        double koguRasvadeKogus = 0;
        double koguSysivesikuteKogus = 0;

        for (ToiduKomponent komponent : komponendid) {
            koguValkudeKogus += komponent.arvutaValkudeKogus();
            koguRasvadeKogus += komponent.arvutaRasvakogus();
            koguSysivesikuteKogus += komponent.arvutaSysivesikuteKogus();
        }
    }
    public void kirjutaAndmedFaili(String failiNimi) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(failiNimi))) {
            for (ToiduKomponent komponent : komponendid) {
                ToiduAine toiduaine = komponent.toiduaine;
                pw.println(toiduaine.nimetus + ";" + toiduaine.valkudeProtsent + ";" + toiduaine.rasvadeProtsent + ";" + toiduaine.sysivesikuteProtsent + ";" + komponent.kogus);
            }
        }
    }

    public String getNimetus() {
        return null;
    }

    public void arvutaJaPrindiToitaineteKogused() {
    }
}
