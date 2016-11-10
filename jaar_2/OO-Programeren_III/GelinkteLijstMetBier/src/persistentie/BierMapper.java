/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistentie;

import domein.Bier;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sebastiaan
 */
public class BierMapper {
    public List<Bier> leesBieren(File besnaam) {
        
        List<Bier> bieren = new ArrayList<>();
        
        try(Scanner sc = new Scanner(besnaam)) {
            
            Files.lines(besnaam.toPath()).forEach( regel -> {
                String name = sc.next();
                sc.next();
                double alc = sc.nextDouble();
                sc.nextLine();
                bieren.add(new Bier(name, alc));
            });
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return bieren;
    }
}
