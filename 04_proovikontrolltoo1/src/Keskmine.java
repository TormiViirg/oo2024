import java.util.ArrayList;
import java.util.List;

public class Keskmine {
    List<Double> arvud =new ArrayList<>();
    List<Double> arvudKeskmised = new ArrayList<>();

    public Keskmine(List<Double> arvudAlguses) {
        arvud = arvudAlguses; // [4,7,8]
        arvutaLibisevKeskmine(); // [6.333]
    }

    public void lisaArv(Double arv){
        Double viimane = arvud.get(arvud.size() - 1);
        Double eelViimane = arvud.get(arvud.size() - 2);
        Double keskmine = (viimane + eelViimane + arv) / 3;
        arvudKeskmised.add(keskmine);

        arvud.add(arv);
    }
    public List<Double> saaArvudKeskmised(){
        return arvudKeskmised;
    }
    public List<Double> arvutaLibisevKeskmine(){
        //double aritmeetilineKeskmine = (arv1 + arv2 + arv3) / 3;
        for (int i = 0; i < arvud.size() - 2; i++) {
            double summa = arvud.get(i) + arvud.get(i+ 1) + arvud.get(i + 2);
            double libisevKeskmine = summa / 3;
            arvudKeskmised.add(libisevKeskmine);
        }
        return arvudKeskmised;
    }
}
