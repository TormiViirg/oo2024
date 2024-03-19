package ee.tlu.salat;
//controller suhtleb frontendiga
//backed oluline scaleability ja turvalisuse jaoks ei näe koodi
import lombok.Getter;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

//localhost:8080/api/toiduained/Vorst/23/45/14
//localhost:8080/api/toiduained?/index=0Vorst/23/45/14
//listi sees nüüd salvestab objekte

// ["Kartul", "Vorst"]; vana eelmises
// [{nimi: "Kartul, valk: 0}, {nimi: "Vorst"}] nüüd see
// localhost/api/toiduained
public class ToiduaineEntityController {
    List<ToiduaineEntity> toiduained = new ArrayList<>();//immiteerime andmebaasi
    @GetMapping("toiduained")
    public List<ToiduaineEntity> saaToiduained() {
        return toiduained;
    }
    //localhost:8080/api/toiduained/Vorst/15/5/1
    //postmapping ei saa browseris teha
    // järjekord tähtis
    //ei saa järjekorda muuta isegi mitte kogemata ja ei saa vahele jätta
    @PostMapping("toiduained/{nimi}/{valk}/{rasv}/{sysivesik}")
    public List<ToiduaineEntity> lisaToiduained(
            @PathVariable String nimi,
            @PathVariable int valk,
            @PathVariable int rasv,
            @PathVariable int sysivesik
            //url api end pointi
            // automaagika kui see pikem jama varjant ei pea pikka kirjutama
            //kasuta läbivalt ühte projektis
            //postman tunnetab ära kui request param saad linnukestega valida
            ) {
        if (valk + rasv+ sysivesik > 100){
            return toiduained;
        }
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduained.add(toiduaine);
        return toiduained;
    }
//objekti sees kutusd punktiga
    //kõige tavalisem post put requestide puhul eelista seda
    @PostMapping("toiduained")
    public List<ToiduaineEntity> lisaToiduained(@RequestBody ToiduaineEntity toiduaineEntity) {
        if (toiduaineEntity.valk + toiduaineEntity.rasv+ toiduaineEntity.sysivesik > 100){
            return toiduained;
        }
        //ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduained.add(toiduaineEntity);
        return toiduained;
    }

    @DeleteMapping("toiduained/{index}")
    public List<ToiduaineEntity> kustutaToiduainel(@PathVariable int index) {
        toiduained.remove(index);
        return toiduained;
    }
// siin saab vahele jätta
    // localhost:8080/api/toiduained/Vorst/15/5/1
    // localhost:8080/api/toiduained?index=0&nimi=Vorst&valk=15&rasv=5&sysivesik=1
    @PutMapping("toiduained")
    public List<ToiduaineEntity> muudaToiduained(
            @RequestParam int index,
            @RequestParam String nimi,
            @RequestParam int valk,
            @RequestParam int rasv,
            @RequestParam int sysivesik
    ) {
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduained.set(index, toiduaine);
        return toiduained;
    }

    //CRUD create read(kõiki või ühte kindlat) update delete
    @GetMapping("toiduained/{index}")
    public ToiduaineEntity saaYksToiduaine(@PathVariable int index) {
        return toiduained.get(index);
    }
    @GetMapping("toiduainete-koguarv")
    public int toiduaineteKoguarv(){
        return toiduained.size();
    }
}
//frontendi viga kui 4 algab, 5ga backendi viga
