public class Main {
    public static void main(String[] args) {

        Suusad suusad1 = new Suusad("200cm", "Fisher");
        Suusad suusad2 = new Suusad("190cm", "Fisher");

        suusad1.laenuta();
        suusad2.laenuta();
        suusad2.tagasta();

        Laenutaja laenutaja1 = new Laenutaja("Taavi");
        Laenutaja laenutaja2 = new Laenutaja("Tormi");

        laenutaja1.laenutaSuusad();
        laenutaja2.laenutaSuusad();

        laenutaja1.tagastaSuusad();
        laenutaja2.tagastaSuusad();
    }
}
