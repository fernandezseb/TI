/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domein.MyList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Sebastiaan
 */
public class StartUp2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyList<String> list = new MyList<>("lijstje");
        
        
        try(Scanner sc = new Scanner(new File("Sleutelwoorden.txt"));
                Formatter format = new Formatter(new File("Sleutelwoorden_eindigend_op_e.txt"))) {
            while(sc.hasNext()) {
                list.insertAtFront(sc.nextLine());
            }
            
            list.forEach(elem -> {if (elem.endsWith("e")) format.format("%s%n", elem); });
         } catch (FileNotFoundException ex) {
            System.err.println("Foutje");
        }
    }
    
}
