public class Suusad {
    String pikkus;
    String brand;
    boolean onLaenutatud;

    public Suusad(String pikkus, String brand) {
        this.pikkus = pikkus;
        this.brand = brand;
        this.onLaenutatud = false;
    }

    public void laenuta() {
        if (!onLaenutatud) {
            onLaenutatud = true;
            System.out.println(pikkus + " on nüüd laenutatud.");
        } else {
            System.out.println(pikkus + " on juba laenutatud.");
        }
    }

    public void tagasta() {
        if (onLaenutatud) {
            onLaenutatud = false;
            System.out.println(pikkus + " on tagastatud.");
        } else {
            System.out.println(pikkus + " ei ole laenutatud.");
        }
    }
}
