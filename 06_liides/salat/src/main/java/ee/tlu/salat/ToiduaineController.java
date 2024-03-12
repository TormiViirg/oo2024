package ee.tlu.salat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToiduaineController {
    //localhost:8080/tere/M
    @GetMapping("tere/{nimi}")
    public String hello(@PathVariable String nimi){
        return "Tere" + nimi;
    }
    //localhost:8080/tere/M
    @GetMapping("korruta/{arv1}/{arv2}")
    public int multiply(@PathVariable int arv1, @PathVariable int arv2){
        return arv1 * arv2;
    }
}
//frontendi viga kui 4 algab, 5ga backendi viga
