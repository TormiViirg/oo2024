import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ToitAndmeteHaldur {

    public static Toit loeToitFailist(String failiNimi) throws IOException {
        Toit taastatudToit = new Toit("Taastatud Toit"); // Või loe toidu nimi failist, kui see on seal olemas

        try (BufferedReader br = new BufferedReader(new FileReader(failiNimi))) {
            String rida;
            while ((rida = br.readLine()) != null) {
                String[] andmed = rida.split(";");
                if (andmed.length == 5) {
                    String nimetus = andmed[0];
                    int valkudeProtsent = Integer.parseInt(andmed[1]);
                    int rasvadeProtsent = Integer.parseInt(andmed[2]);
                    int sysivesikuteProtsent = Integer.parseInt(andmed[3]);
                    double kogus = Double.parseDouble(andmed[4]);

                    // Iga toidukomponendi jaoks luuakse uued ToiduAine ja ToiduKomponent objektid
                    ToiduAine toiduaine = new ToiduAine(nimetus, valkudeProtsent, rasvadeProtsent, sysivesikuteProtsent);
                    ToiduKomponent komponent = new ToiduKomponent(kogus, toiduaine);
                    taastatudToit.lisaKomponent(komponent);
                }
            }
        }
        return taastatudToit;
    }
}
