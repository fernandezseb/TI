package testen;

import domein.MyStack;
import exceptions.EmptyListException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import javax.sql.rowset.serial.SerialArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestStackGeneriek {

    private MyStack<String> woordenStack;
    private MyStack<Double> decGetallenStack;

    @Before
    public void before() {
        woordenStack = new MyStack<>("woordenStack");
        decGetallenStack = new MyStack<>("decGetallenStack");
    }

    @Test
    public void stackLeeg() {
        Assert.assertTrue(woordenStack.isEmpty());
        Assert.assertTrue(decGetallenStack.isEmpty());
    }

    @Test(expected = EmptyListException.class)
    public void legeStackElementVerwijderen() {
        woordenStack.pop();
    }

//TODO	Stap3
//Maak een generieke testmethode
//------------------------------
	
     @Test
     public void woordenToevoegenVerwijderen() 
     {
     woordenStack.push("lekker");
     woordenStack.push("zijn");
     woordenStack.push("wafels");

     Assert.assertEquals("wafels", woordenStack.pop());
     Assert.assertFalse(woordenStack.isEmpty());
     Assert.assertEquals("zijn", woordenStack.pop());
     Assert.assertFalse(woordenStack.isEmpty());
			
     Assert.assertEquals("lekker", woordenStack.pop());
     Assert.assertTrue(woordenStack.isEmpty());
     }
		
     @Test
     public void decGetallenToevoegenVerwijderen() 
     {
     decGetallenStack.push(12.5);
     decGetallenStack.push(24.3);
     decGetallenStack.push(30.5);
     decGetallenStack.push(40.5);
			
     Assert.assertEquals(new Double(40.5), decGetallenStack.pop());
     Assert.assertFalse(decGetallenStack.isEmpty());
     Assert.assertEquals(new Double(30.5), decGetallenStack.pop());
     Assert.assertFalse(decGetallenStack.isEmpty());
     Assert.assertEquals(new Double(24.3), decGetallenStack.pop());
     Assert.assertFalse(decGetallenStack.isEmpty());
			
     Assert.assertEquals(new Double(12.5), decGetallenStack.pop());
     Assert.assertTrue(decGetallenStack.isEmpty());
     }
     
     @Test
     public void toevoegenVerwijderenTesten()
     {
         String[] woorden = {"lekker", "zijn", "wafels"};
         Double[] decGetallen = {12.5, 24.3, 30.5, 40.5};
         itemsToevoegenVerwijderen(woordenStack, woorden);
         itemsToevoegenVerwijderen(decGetallenStack, decGetallen);
     }

    private <E extends Serializable> void itemsToevoegenVerwijderen(MyStack<E> stapeltje, E[] items) {
        Arrays.stream(items).forEach(stapeltje::push);
        List<E> listExpected = Arrays.asList(items);
        Collections.reverse(listExpected);
        
        listExpected.stream().limit(listExpected.size() -1).forEach(
                expected -> {
                    Assert.assertEquals(expected, stapeltje.pop());
                    Assert.assertFalse(stapeltje.isEmpty());
                }
        );
        
        Assert.assertEquals(listExpected.get(listExpected.size() - 1), stapeltje.pop());
        Assert.assertTrue(stapeltje.isEmpty());
        
    }


}
