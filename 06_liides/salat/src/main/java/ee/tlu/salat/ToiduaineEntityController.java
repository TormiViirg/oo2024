package ee.tlu.salat;
//controller suhtleb frontendiga
//backed oluline scaleability ja turvalisuse jaoks ei näe koodi
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")

//localhost:8080/api/toiduained/Vorst/23/45/14
//localhost:8080/api/toiduained?/index=0Vorst/23/45/14
//listi sees nüüd salvestab objekte

// ["Kartul", "Vorst"]; vana eelmises
// [{nimi: "Kartul, valk: 0}, {nimi: "Vorst"}] nüüd see
// localhost/api/toiduained
public class ToiduaineEntityController {
    //@Autowired
    //ToiduaineRepository toiduaineRepository;
    ToiduaineRepository toiduaineRepository;
    public ToiduaineEntityController(ToiduaineRepository toiduaineRepository){
        this.toiduaineRepository = toiduaineRepository;
        //spring täidab ise
    }
    //List<ToiduaineEntity> toiduained = new ArrayList<>();//immiteerime andmebaasi
    @GetMapping("toiduained")
    public List<ToiduaineEntity> saaToiduained() {
        return toiduaineRepository.findAll();
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
            return toiduaineRepository.findAll();
        }
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduaineRepository.findAll().add(toiduaine);
        return toiduaineRepository.findAll();
    }
//objekti sees kutusd punktiga
    //kõige tavalisem post put requestide puhul eelista seda
    @PostMapping("toiduained")
    public List<ToiduaineEntity> lisaToiduained(@RequestBody ToiduaineEntity toiduaineEntity) {
        if (toiduaineEntity.valk + toiduaineEntity.rasv+ toiduaineEntity.sysivesik > 100){
            return toiduaineRepository.findAll();
        }
        //ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduaineRepository.findAll().add(toiduaineEntity);
        return toiduaineRepository.findAll();
    }

    @DeleteMapping("toiduained/{nimi}")
    public List<ToiduaineEntity> kustutaToiduainel(@PathVariable String nimi) {
        toiduaineRepository.deleteById(nimi);
        return toiduaineRepository.findAll();
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
        toiduaineRepository.save(toiduaine);
        return toiduaineRepository.findAll();
    }

    //CRUD create read(kõiki või ühte kindlat) update delete
    @GetMapping("toiduained/{index}")
    public ToiduaineEntity saaYksToiduaine(@PathVariable String nimi) {
        return toiduaineRepository.findById(nimi).get();
    }
    @GetMapping("toiduainete-koguarv")
    public int toiduaineteKoguarv(){
        return toiduaineRepository.findAll().size();
    }
}
//frontendi viga kui 4 algab, 5ga backendi viga
