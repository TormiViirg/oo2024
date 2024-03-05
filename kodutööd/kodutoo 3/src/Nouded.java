public class Nouded {
    private String algMudeliNumber;
    private int pikkus;
    private int laius;
    private String puuLiik;

    public Nouded(String algMudeliNumber, int pikkus, int laius, String puuLiik) {
        this.algMudeliNumber = algMudeliNumber;
        this.pikkus = pikkus;
        this.laius = laius;
        this.puuLiik = puuLiik;
    }

    // Getterid
    public String getAlgMudeliNumber() {
        return algMudeliNumber;
    }

    public int getPikkus() {
        return pikkus;
    }
    public int getLaius() {
        return laius;
    }

    public String getPuuLiik() {
        return puuLiik;
    }
}

