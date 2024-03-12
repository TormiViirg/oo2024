package ee.tlu.salat;
//controller suhtleb frontendiga
//backed oluline scaleability ja turvalisuse jaoks ei näe koodi
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class ToiduaineEntityController {
    //localhost:8080/api/toiduained/Vorst/23/45/14
    //localhost:8080/api/toiduained?/index=0Vorst/23/45/14
    //listi sees nüüd salvestab objekte
    List<ToiduaineEntity> toiduained = new ArrayList<>();//immiteerime andmebaasi

    // localhost
    @GetMapping("saa-Toiduained")
    public List<ToiduaineEntity> saaToiduained() {
        return toiduained;
    }

    //postmapping ei saa browseris teha
    // järjekord tähtis
    //ei saa järjekorda muuta ja ei saa vahele jätta
    @PostMapping("toiduained/{nimi}/{valk}/{rasv}/{sysivesik}")
    public List<ToiduaineEntity> lisaToiduained(
            @PathVariable String nimi,
            @PathVariable int valk,
            @PathVariable int rasv,
            @PathVariable int sysivesik
    ) {
        if (valk + rasv+ sysivesik >100){
            return toiduained;
        }
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduained.add(toiduaine);
        return toiduained;
    }

    @DeleteMapping("toiduained/{index}")
    public List<ToiduaineEntity> kustutaToiduained(@PathVariable int index) {
        toiduained.remove(index);
        return toiduained;
    }
// siin saab vahele jätta
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
        toiduained.get(index);
        return toiduained.get(index);
    }
}
//frontendi viga kui 4 algab, 5ga backendi viga
