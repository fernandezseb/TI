/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistentie;

import domein.Bier;
import domein.MyList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sebastiaan
 */
public class PersistentieController {
    
    private BierMapper bierMapper;
    
    public List<Bier> leesBieren(File besnaam) {
        if(Objects.isNull(bierMapper)) {
            bierMapper = new BierMapper();
        }
        return bierMapper.leesBieren(besnaam);
    }
    
    public <T extends Serializable> void persisteerMyList(MyList<T> li, File besnaam) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(besnaam))) {
            
            oos.writeObject(li);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PersistentieController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PersistentieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
