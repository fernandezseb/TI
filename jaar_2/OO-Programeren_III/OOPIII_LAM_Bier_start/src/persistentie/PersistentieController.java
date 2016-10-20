/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistentie;

import domein.Bier;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author hr047
 */
public class PersistentieController
{
    private BierMapper bierMapper;    
    

    public List<Bier> inlezenBieren(String naamBestand)
    {
        if(bierMapper == null)
            bierMapper = new BierMapper();
        return bierMapper.inlezenBieren(naamBestand);
    }

}
