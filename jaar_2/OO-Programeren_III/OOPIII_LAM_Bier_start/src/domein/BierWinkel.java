package domein;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import persistentie.BierMapper;
import persistentie.PersistentieController;

public class BierWinkel
{

    private final List<Bier> bieren;
    private PersistentieController pc=new PersistentieController();

    public BierWinkel()
    {
        bieren = pc.inlezenBieren("bieren.txt");
    }

    public List<Bier> getBieren()
    {
        return bieren;
    }
   
    

    public long geefAantalBierenMetMinAlcoholPercentage(double percentage)
    {
        
        return bieren.stream().filter(bier -> bier.getAlcoholgehalte() >= percentage).count();
    }

    
    
    public List<Bier> geefAlleBierenMetMinAlcoholPercentage(double percentage)
    {
        return bieren.stream().filter(bier -> bier.getAlcoholgehalte() >= percentage).collect(Collectors.toList());
    }

    //Bier met hoogst aantal graden

    public Bier geefBierMetHoogsteAlcoholPercentage()
    {
         return bieren.stream().max(Comparator.comparing(Bier::getAlcoholgehalte)).get();
    }

    //Bier met laagst aantal graden
    public Bier geefBierMetLaagsteAlcoholPercentage()
    {
         return bieren.stream().min(Comparator.comparing(Bier::getAlcoholgehalte)).get();
    }

    /*Zorg ervoor dat het resultaat gesorteerd wordt op alcoholgehalte van hoog naar laag, 
     en bij gelijk aantal graden op naam (alfabetisch).
     */
    public List<Bier> sorteerOpAlcoholGehalteEnNaam()
    {
        Function<Bier,Double> byAlcohol = Bier::getAlcoholgehalte;
        Function<Bier,String> byNaam = Bier::getNaam;
        
        Comparator<Bier> sorterenOpAlcholDaarnaOpNaam = Comparator.comparing(byAlcohol).reversed().thenComparing(byNaam);
         return bieren.stream().sorted(sorterenOpAlcholDaarnaOpNaam).collect(Collectors.toList());
         

    }

    //Alle brouwerijen
    public String geefAlleNamenBrouwerijen()
    {
         return bieren.stream().map(Bier::getBrouwerij).distinct().collect(Collectors.joining("\n"));
    }
    
    //Alle brouwerijen die het woord "van" bevatten
    public String geefAlleNamenBrouwerijenMetWoord(String woord)
    {
         return bieren.stream().filter(bier -> bier.getBrouwerij().contains(woord)).collect(Collectors.toList()).toString();
    }

    public String geefNamenBieren()
    {
         return bieren.stream().map(Bier::getNaam).distinct().collect(Collectors.joining("%n"));
    }

    public Map<String, List<Bier>> opzettenOverzichtBierenPerSoort()
    {
         return bieren.stream().collect(Collectors.groupingBy(Bier::getSoort));
    }

    public Map<String, Long> opzettenAantalBierenPerSoort()
    {
        return bieren.stream().collect(Collectors.groupingBy(Bier::getSoort, Collectors.counting()));
    }
}
