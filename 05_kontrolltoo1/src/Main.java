import java.io.IOException;

/*1:Koosta klass toiduaine tarbeks (nimetus, valkude, rasvade ja süsivesikute protsent ehk int tüüpi muutuja). 2:Loo "main funktsioonis" mõni toiduaine (nt. kartul, hapukoor, vorst). 3:Koosta uus klass toidukomponendi tarbeks (kogus, viit toiduainele).4: Loo mõned toidukomponendid (nt. 100 g kartuleid, 30 g hapukoort, 50 g vorsti). 5:Lisa toidukomponendile käsklus selle sees leiduva rasvakoguse arvutamiseks.
*6: Koosta klass toidu jaoks (nimetus, viit toidukomponendile).7: Lisa toidule käsklused küsimaks sisalduvate valkude, rasvade ja süsivesikute kogust. 8:Loo "main funktsioonis" toit (nt. kartulisalat), küsi salatis leiduvate toitainete kogused.*/
/* 9:Võimalda toidu andmeid kirjutada tekstifaili(desse) ja 10:lugeda tagasi. Võib eeldada, et toiduaine, toidukomponendi ning toidu nimetus on unikaalne, et ei tekiks failide juures üle kirjutamist.*/
public class Main {
    public static void main(String[] args) {
        // 2: Loodud toiduained valgu rasvade ja süsivesikute protsentidega toiduaine jaoks kuna see vajalik info hiljem
        ToiduAine kartul = new ToiduAine("Kartul", 2, 0, 17);
        ToiduAine hapukoor = new ToiduAine("Hapukoor", 3, 20, 4);
        ToiduAine vorst = new ToiduAine("Vorst", 12, 25, 1);

        // 4: Loodud toidukomponendid lisab seotud väärtused toidukomponendile
        ToiduKomponent kartulKomponent = new ToiduKomponent(100, kartul);
        ToiduKomponent hapukoorKomponent = new ToiduKomponent(30, hapukoor);
        ToiduKomponent vorstKomponent = new ToiduKomponent(50, vorst);
        System.out.println("Toiduained loodud.");

        // 8: Loob toidu 7. punkti jaoks ja lisab sellele muutujale komponentid mille toitaine kogused arvutab 7. punktis kirjeldatud valemeid kasutades all ja salvestab tulemuse mällu
        Toit kartulisalat = new Toit("Kartulisalat");
        kartulisalat.lisaKomponent(kartulKomponent);
        kartulisalat.lisaKomponent(hapukoorKomponent);
        kartulisalat.lisaKomponent(vorstKomponent);
        // Arvutab ja salvestab toitainete kogused
        kartulisalat.arvutaToitainetekogusRoas();

        try {
            Toit taastatudToit = ToitAndmeteHaldur.loeToitFailist("toiduvaljund.txt");
            // Näitame taastatud toidu andmeid
            System.out.println("Taastatud toidu nimetus: " + taastatudToit.getNimetus());
            taastatudToit.arvutaJaPrindiToitaineteKogused();
        } catch (IOException e) {
            System.err.println("Faili lugemisel tekkis viga: " + e.getMessage());
        }
    }
}
