package testen;

import domein.MyList;
import exceptions.EmptyListException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMyListNietGeneriek {

    private MyList<String> woordenLijst;

    @Before
    public void before() {
        woordenLijst = new MyList<>("woordenlijst");
    }

    @Test
    public void lijstLeeg() {
        if (!woordenLijst.isEmpty()) {
            Assert.fail("List is niet leeg");
        }
        // OF
        Assert.assertEquals(true, woordenLijst.isEmpty());
        // OF
        Assert.assertTrue(woordenLijst.isEmpty());

    }

    @Test
    public void woordenVooraanToevoegen() {
        woordenLijst.insertAtFront("lekker");
        woordenLijst.insertAtFront("zijn");
        woordenLijst.insertAtFront("wafels");

        Assert.assertFalse(woordenLijst.isEmpty());
    }
    
    @Test
    public void woordToevoegenVerwijderen() {
        woordenLijst.insertAtFront("wafels");
        Assert.assertEquals("wafels", woordenLijst.removeFromFront());
        Assert.assertTrue(woordenLijst.isEmpty());
        
        woordenLijst.insertAtBack("zijn");
        Assert.assertEquals("zijn", woordenLijst.removeFromFront());
        Assert.assertTrue(woordenLijst.isEmpty());
        
        woordenLijst.insertAtBack("zeer");
        Assert.assertEquals("zeer", woordenLijst.removeFromFront());
        Assert.assertTrue(woordenLijst.isEmpty());
        
        woordenLijst.insertAtFront("lekker");
        Assert.assertEquals("lekker", woordenLijst.removeFromFront());
        Assert.assertTrue(woordenLijst.isEmpty());
    }

    @Test
    public void woordenAchteraanToevoegen() {
        woordenLijst.insertAtBack("wafels");
        woordenLijst.insertAtBack("zijn");
        woordenLijst.insertAtBack("lekker");

        Assert.assertFalse(woordenLijst.isEmpty());
    }

    @Test
    public void woordenDoorElkaarToevoegenVerwijderen() {
        woordenLijst.insertAtFront("zijn");
        woordenLijst.insertAtBack("zeer");
        woordenLijst.insertAtBack("lekker");
        woordenLijst.insertAtFront("wafels");

        Assert.assertFalse(woordenLijst.isEmpty());

        Assert.assertEquals("wafels", woordenLijst.removeFromFront());
        Assert.assertEquals("zijn", woordenLijst.removeFromFront());

        woordenLijst.insertAtBack("einde");

        Assert.assertEquals("zeer", woordenLijst.removeFromFront());
        Assert.assertEquals("lekker", woordenLijst.removeFromFront());

        woordenLijst.insertAtFront("begin");

        Assert.assertEquals("begin", woordenLijst.removeFromFront());
        Assert.assertEquals("einde", woordenLijst.removeFromFront());

        Assert.assertTrue(woordenLijst.isEmpty());
    }

    @Test
    public void woordenVerwijderen() {
        woordenLijst.insertAtFront("lekker");
        woordenLijst.insertAtFront("zijn");
        woordenLijst.insertAtFront("wafels");
        Assert.assertFalse(woordenLijst.isEmpty());
        Assert.assertEquals("wafels", woordenLijst.removeFromFront());
        Assert.assertEquals("zijn", woordenLijst.removeFromFront());
        Assert.assertEquals("lekker", woordenLijst.removeFromFront());
        Assert.assertTrue(woordenLijst.isEmpty());
    }

    @Test(expected = EmptyListException.class)
    public void legeLijstElementVerwijderen() {
        woordenLijst.removeFromFront();
    }

    @Test
    public void toonLijst() {
        woordenLijst.insertAtFront("lekker");
        woordenLijst.insertAtFront("zijn");
        woordenLijst.insertAtFront("wafels");
        String zin = woordenLijst.toString().replaceAll("\\s+", " ").trim();
        Assert.assertEquals("The woordenlijst is: wafels zijn lekker", zin);
    }

    @Test
    public void toonLegeLijst() {
        String zin = woordenLijst.toString().replaceAll("\\s+", " ").trim();
        Assert.assertEquals("woordenlijst is empty", zin);
    }
}
