//1:Klass toiduaine tarbeks (nimetus, valkude, rasvade ja süsivesikute protsent (int tüüpi muutuja).
public class ToiduAine {
    String nimetus;
    int valkudeProtsent;
    int rasvadeProtsent;
    int sysivesikuteProtsent;

    public ToiduAine(String nimetus, int valkudeProtsent, int rasvadeProtsent, int sysivesikuteProtsent) {
        this.nimetus = nimetus;
        this.valkudeProtsent = valkudeProtsent;
        this.rasvadeProtsent = rasvadeProtsent;
        this.sysivesikuteProtsent = sysivesikuteProtsent;
    }
}