public class Tellimus {
    private Nouded nouded;
    private int maksumus;
    private String tarneEsindus;

    public Tellimus(Nouded nouded, int maksumus, String tarneEsindus) {
        this.nouded = nouded;
        this.maksumus = maksumus;
        this.tarneEsindus = tarneEsindus;
    }

    // Meetod arvuti andmete väljastamiseks
    public void naitaTellimusAndmeid() {
        System.out.println("Laua andmed:");
        System.out.println("Nimetus: " + nouded.getAlgMudeliNumber());
        System.out.println("Pikkus ja laius: " + nouded.getPikkus()+"*"+nouded.getLaius());
        System.out.println("Maksumus: " + maksumus + " eurot");
        System.out.println("Kuhu tuleb toode tarnida: " + tarneEsindus);
    }

    public Nouded getInfo() {
        return nouded;
    }

    public int getMaksumus() {
        return maksumus;
    }

    public String getTarneEsindus() {
        return tarneEsindus;
    }

    public void muudaTarneEsindust(String uusTarneEsindus) {
        this.tarneEsindus = uusTarneEsindus;
    }
}

