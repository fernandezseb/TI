package domein;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DomeinController
{

    private BierWinkel bierWinkel;

    public DomeinController()
    {
        bierWinkel = new BierWinkel();
    }

    
    public long geefAantalBierenMetMinAlcoholPercentage(double percentage)
    {
        return bierWinkel.geefAantalBierenMetMinAlcoholPercentage(percentage);
    }
    
    public List<String> geefLijstAlleBierenMetMinAlcoholPercentage(double percentage)
    {
        List<Bier> bieren = bierWinkel.geefAlleBierenMetMinAlcoholPercentage(percentage);
        return bieren.stream().map(Bier::toString).collect(Collectors.toList());
    }
    
    public List<String> geefAlleBieren()
    {
        
        List<Bier> bieren = bierWinkel.getBieren();
        return bieren.stream().map(Bier::toString).collect(Collectors.toList());
    }
    
    public String geefNamenBieren()
    {
        return bierWinkel.getBieren().stream()
                .map(Bier::getNaam).distinct()
                .collect(Collectors.joining("%n"));
    }
    
    public String geefBierMetHoogsteAlcoholPercentage()
    {
        return bierWinkel.geefBierMetHoogsteAlcoholPercentage().toString();
    }
    
    public String geefBierMetLaagsteAlcoholPercentage()
    {
        return bierWinkel.geefBierMetLaagsteAlcoholPercentage().toString();
    }
    
    public List<String> sorteerOpAlcoholGehalteEnNaam()
    {
       return bierWinkel.sorteerOpAlcoholGehalteEnNaam().stream()
               .map(Bier::toString).collect(Collectors.toList());
    }
    
    public String geefAlleNamenBrouwerijen()
    {
        return bierWinkel.getBieren().stream()
                .map(Bier::getBrouwerij)
                .collect(Collectors.joining("%n"));
    }
    
    public String geefAlleNamenBrouwerijenMetWoord(String woord)
    {
        return bierWinkel.geefAlleBrouwerijenMetWoord(woord)
                .stream().map(Bier::getBrouwerij)
                .distinct()
                .collect(Collectors.joining("%n"));
    }

    public String opzettenAantalBierenPerSoort()
    {   //naar BierWinkel --> map<String, Long>
        return overzichtToString(bierWinkel.opzettenAantalBierenPerSoort());
    }

    public String opzettenOverzichtBierenPerSoort()
    {  // naar BierWinkel --> map<String, List<Bier>>
        return overzichtToString(bierWinkel.opzettenOverzichtBierenPerSoort());
    }

    private <K, V> String overzichtToString(Map<K, V> map)
    {  //hulp voor map --> String
         return map.entrySet().stream()
                 .map(e -> e.getKey() + "=" + e.getValue() )
                 .collect(Collectors.joining("\n"));
    }


}
