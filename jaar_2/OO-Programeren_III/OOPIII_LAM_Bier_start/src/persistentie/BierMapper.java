package persistentie;

import domein.Bier;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BierMapper
{

    public List<Bier> inlezenBieren(String naamBestand)
    {
        List<Bier> bieren = new ArrayList<>();
        try {
            //TODO
            Scanner input = new Scanner(new FileInputStream(naamBestand));
//            while(input.hasNext()){
//                bieren.add(new Bier(input.next(),input.next(),input.nextDouble(),input.nextDouble(),input.nextLine()));
//            }
            Files.lines(Paths.get(naamBestand)).forEach(regel->{
                Scanner scanner = new Scanner(regel);
                bieren.add(new Bier(input.next(),input.next(),input.nextDouble(),input.nextDouble(),input.nextLine()));
            });
        } catch (FileNotFoundException ex) {
            System.err.println("Kan bestand niet vinden.");
        } catch (IOException ex) {
            System.err.println("Kan bestand niet vinden.");
        }
        return bieren;
    }


}
