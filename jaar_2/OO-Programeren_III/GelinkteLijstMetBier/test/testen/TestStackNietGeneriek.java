package testen;

import domein.MyStack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import exceptions.EmptyListException;

public class TestStackNietGeneriek {

    private MyStack<String> woordenStack;

    @Before
    public void before() {
        woordenStack = new MyStack<>("woordenStack");
    }

    @Test
    public void stackLeeg() {
        Assert.assertTrue(woordenStack.isEmpty());
    }

    @Test
    public void woordenToevoegen() {
        woordenStack.push("lekker");
        woordenStack.push("zijn");
        woordenStack.push("wafels");
         Assert.assertFalse(woordenStack.isEmpty());
    }
    
    @Test
    public void woordenDoorElkaarToevoegenVerwijderen() {
        woordenStack.push("lekker");
        woordenStack.push("zijn");
        
        Assert.assertEquals("zijn", woordenStack.pop());
        woordenStack.push("wafels");
        
        Assert.assertEquals("wafels", woordenStack.pop());
        Assert.assertEquals("lekker", woordenStack.pop());
        Assert.assertTrue(woordenStack.isEmpty());
    }
    
    @Test
    public void woordenVerwijderen() {
        woordenStack.push("lekker");
        woordenStack.push("zijn");
        woordenStack.push("wafels");
        Assert.assertFalse(woordenStack.isEmpty());
        Assert.assertEquals("wafels", woordenStack.pop());
        Assert.assertEquals("zijn", woordenStack.pop());
        Assert.assertEquals("lekker", woordenStack.pop());
        Assert.assertTrue(woordenStack.isEmpty());
    }
    
    @Test(expected = EmptyListException.class)
    public void legeStackElementVerwijderen() {
        woordenStack.pop();
    }

    @Test
    public void toonStack() {
        woordenStack.push("lekker");
        woordenStack.push("zijn");
        woordenStack.push("wafels");
        String zin = woordenStack.toString().replaceAll("\\s+", " ").trim();
        Assert.assertEquals("The woordenStack is: wafels zijn lekker", zin);
    }

    @Test
    public void toonLegeStack() {
        String zin = woordenStack.toString().replaceAll("\\s+", " ").trim();
        Assert.assertEquals("woordenStack is empty", zin);
    }
}
