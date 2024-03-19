package ee.tlu.salat;

import org.springframework.data.jpa.repository.JpaRepository;

//interface kuna me ei lähe isegi midagi tegema, teeme alamklassiks
//igale tabelile oma repositry
public interface ToiduaineRepository extends JpaRepository<ToiduaineEntity, String> {
}
