import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Tellimus> tellimused = new ArrayList<>();

        while (true) {
            System.out.println("Sisesta andmed antud formaadis eralades need omavahel tühikutega: " +
                    "\nAlgmudeli number, pikkus(mm), laius(mm), puuliik, maksumus(ümardatud täisarvuni), valitud esindus tarneks " +
                    "\nNäide korrektsest sisestusest:HK-47-KO-TO-R2 1000 500 Jalakas 1200 Elva" +
                    "\nSisesta 'lõpeta', et lõpetada tellimuste sisestamine.");
            String sisend = scanner.nextLine();

            if (sisend.equalsIgnoreCase("lõpeta")) {
                break;
            }

            String[] andmed = sisend.split(" ");
            if (andmed.length < 6) {
                System.out.println("Vigane sisend, palun proovi uuesti.");
                continue;
            }

            String algMudeliNumber = andmed[0];
            int pikkus = Integer.parseInt(andmed[1]);
            int laius = Integer.parseInt(andmed[2]);
            String puuLiik = andmed[3];
            int maksumus = Integer.parseInt(andmed[4]);
            String tarneEsindus = andmed[5];

            Nouded nouded = new Nouded(algMudeliNumber, pikkus, laius, puuLiik);
            Tellimus tellimus = new Tellimus(nouded, maksumus, tarneEsindus);

            tellimused.add(tellimus);
        }

        for (Tellimus tellimus : tellimused) {
            tellimus.naitaTellimusAndmeid();
        }
    }
}
