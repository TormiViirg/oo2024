//3:Koostatud uus klass toidukomponendi tarbeks, mis lisab sellele (koguse ja seob selle toiduainega).
public class ToiduKomponent {
    double kogus;
    ToiduAine toiduaine;

    public ToiduKomponent(double kogus, ToiduAine toiduaine) {
        this.kogus = kogus;
        this.toiduaine = toiduaine;
    }
//5:arvutab kõigi eelnevalt omavahel seotud muutujate põhjal rasvakoguse grammides
    public double arvutaRasvakogus() {
        return (this.kogus * this.toiduaine.rasvadeProtsent) / 100.0;
    }

    public double arvutaValkudeKogus() {
        return (this.kogus * this.toiduaine.valkudeProtsent) / 100.0;
    }

    public double arvutaSysivesikuteKogus() {
        return (this.kogus * this.toiduaine.sysivesikuteProtsent) / 100.0;
    }
}