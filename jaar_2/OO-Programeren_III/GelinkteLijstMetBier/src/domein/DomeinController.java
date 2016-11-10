
package domein;

import java.io.File;
import java.util.List;
import persistentie.PersistentieController;

/**
 *
 * @author sebastiaan
 */
public class DomeinController {
    public void persisteerBierGegevensAlsObject(String tekstFileNaam, String objectFileNaam) {
        PersistentieController pc = new PersistentieController();
        List<Bier> li = pc.leesBieren(new File(tekstFileNaam));
        
        MyList<Bier> myLi = new MyList<>();
        
        li.forEach(elem -> myLi.insertAtBack(elem));
        pc.persisteerMyList(myLi, new File(objectFileNaam));
    }
}
