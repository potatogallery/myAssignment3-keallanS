/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.meass3;

import java.util.Collections;
import java.util.Iterator;

/**
 *Keallan Saunders 219169357
 *RMFiles.java
 *08/06/2021
 */
public class RMFiles {
    public static void main(String[] args) {
     ReadingMeth ab = new ReadingMeth();
        ab.openFile();
        ab.readtheFile();
        ab.sortID();
        ab.closeFile();
        ab.openetxtFile();
        
        suppAr cb = new suppAr(); 
        cb.openFile1();
        cb.readtheFile1();
        cb.sortID1();
        cb.closeFile1();
        cb.openetxtFile1();
    
    
    
    }
}
    


