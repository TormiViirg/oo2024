package ee.tlu.salat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//jpa moodulist pärinev hibernate
//chatgpa võib kogematta importida javax.persistance.Table
@Getter //pole parema klõpsu jama vaja see shortcut, tasuta intelij ei toeta kõiki springi funktsionaalsusi
@AllArgsConstructor
@Table(name = "toiduaine") //nimetuse vahetus vabatahtlik
@Entity//andmebaasi panekuks
@NoArgsConstructor //andmebaasi panekuks
//mudel andmebaasi kujuga
public class ToiduaineEntity {
    @Id //alati unikaalne - kustutamiseks, võtmiseks, muutmiseks
    String nimetus;
    int valk;
    int rasv;
    int sysivesik;
}
//public ToiduaineEntity(String nimetus, int valk, int rasv, int sysivesik) {
        //this.nimetus = nimetus;
       // this.valk = valk;
        //this.rasv = rasv;
       // this.sysivesik = sysivesik;
   // } mvn repository
