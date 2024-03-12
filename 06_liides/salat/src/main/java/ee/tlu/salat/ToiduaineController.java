package ee.tlu.salat;
//controller suhtleb frontendiga
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ToiduaineController {
    //localhost:8080/tere/M
    List<String> toiduained = new ArrayList<>();//immiteerime andmebaasi

    @GetMapping("toiduained")
    public List<String> saaToiduained(){
        return toiduained;
    }
    //postmapping ei saa browseris teha
    @PostMapping("toiduained/{toiduaine}")
    public List<String> lisaToiduained(@PathVariable String toiduaine){
        toiduained.add(toiduaine);
        return toiduained;
    }

    @DeleteMapping("toiduained/{index}")
    public List<String> kustutaToiduained(@PathVariable int index){
        toiduained.remove(index);
        return toiduained;
    }

    @PutMapping("toiduained/{index}/{newValue}")
    public List<String> muudaToiduained(@PathVariable int index, @PathVariable String newValue ){
        toiduained.set(index, newValue);
        return toiduained;
    }
    //CRUD create read(kõiki ühte kindlat) update delete
    @GetMapping("toiduained/{index}")
    public String saaYksToiduaine(@PathVariable int index) {
        toiduained.get(index);
        return toiduained.get(index);
    }
    /*@GetMapping("tere/{nimi}")
    public String hello(@PathVariable String nimi){
        return "Tere" + nimi;
    //localhost:8080/tere/M
    @GetMapping("korruta/{arv1}/{arv2}")
    public int multiply(@PathVariable int arv1, @PathVariable int arv2){
        return arv1 * arv2;
    }*/
}
//frontendi viga kui 4 algab, 5ga backendi viga
