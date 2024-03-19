package ee.tlu.salat;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;// vaata et awtst ei impordi
//cv-sse pane postgre
@RestController
public class ToiduKomponentController {
    List<Toidukomponent> toidukomponendid = new ArrayList<>();
    @PostMapping("toiduainekomponent")
    public List<Toidukomponent> lisaToidukomponent(@RequestBody Toidukomponent komponent){
        toidukomponendid.add(komponent);
        return toidukomponendid;
    }

    @PutMapping("toiduainekomponent/{index}")
    public List<Toidukomponent> muudaToidukomponent(@PathVariable int index, @RequestParam Toidukomponent komponent){
        toidukomponendid.set(index, komponent);
        return toidukomponendid;
    }
}
