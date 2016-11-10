/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domein.MyStack;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author Sebastiaan
 */
public class StartUp {

    /**
     * Quick 'n' dirty version
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        
        try(Scanner sc = new Scanner(new File("Sleutelwoorden.txt"));
                Formatter format = new Formatter(new File("Sleutelwoorden_omgekeerde_volgorde.txt"))) {
            while(sc.hasNext()) {
                stack.push(sc.nextLine());
            }
            
            while(!stack.isEmpty()) {
                format.format("%s%n", stack.pop());
            }
         } catch (FileNotFoundException ex) {
            System.err.println("Foutje");
        }
        
    }
    
}
