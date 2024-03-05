import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Sisesta andmed antud formaadis eralades need omavahel tühikutega: "+/n+"Algmudeli number, pikkus(mm), kõrgus(mm), puuliik, maksumus(ümardatud täisarvuni), valitud esindus tarneks"+/n+"Näide korrektsest sisestusest:HK-47-KO-TO-R2 1000 500 Jalakas 1200 29 Elva");
        String sisend = scanner.nextLine();
        // Jagame sisendi tühikute järgi
        String[] andmed = sisend.split(" ");

        String algMudeliNumber = andmed[0];
        int pikkus = Integer.parseInt(andmed[1]);
        int laius = Integer.parseInt(andmed[2]);
        String puuLiik = andmed[3];
        int maksumus = Integer.parseInt(andmed[3]);
        String tarneEsindus = andmed[4];

        Nouded nouded = new Nouded(algMudeliNumber, pikkus, laius, puuLiik);
        Tellimus tellimus = new Tellimus(nouded, maksumus, tarneEsindus);

        // Kui on vaja muuta poe nime või teha allahindlust, võiks lisada täiendava loogika
        // Näiteks, küsides kasutajalt, kas ta soovib neid tegevusi teha

        tellimus.naitaTellimusAndmeid();
    }
}
