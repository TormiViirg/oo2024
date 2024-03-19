package ee.tlu.salat;

import lombok.AllArgsConstructor;
import lombok.Getter;

//koosneb toiduainest ja temaga seotud kogusest toidu sees
//Klassikomplekt -> Kartul+omadused ja mitu g (entity)
@AllArgsConstructor
@Getter
//@noargs constructor kui tahad setteriga väärtused anda
public class Toidukomponent {
    ToiduaineEntity toiduaine;
    int kogus;
}
