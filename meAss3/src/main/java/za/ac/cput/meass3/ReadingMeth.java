/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.meass3;

import static com.sun.tools.javac.tree.TreeInfo.args;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.util.Collections.*;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.StringTokenizer;
import java.util.function.Supplier;

/**
 * Keallan Saunders 219169357
 * ReadingMeth.java
 * 08/06/2021
 */
public class ReadingMeth {
    ObjectInputStream input;
    
    
    Object bus;
    Customer duster;
    Supplier pliers;
    private FileReader dumb;
    private FileWriter bum;
    private BufferedReader stupid;
    private BufferedWriter bw;
    
    ArrayList<Customer>customerArray = new ArrayList<Customer>();
    //ArrayList<Supplier>supplierArray = new ArrayList<Supplier>();

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////// CUSTOMER /////////////////////////////////////////////////////////////////////////////////
    public void openFile()
    {
        try   {input = new ObjectInputStream(new FileInputStream("stakeholder.ser"));
        //dumb = new FileReader("customerOutFile.txt");
        //stupid = new BufferedReader (dumb);
        System.out.println("***the file is now open***");
        }
        catch(IOException ioe)  {System.out.println("file cannot open!"+ ioe.getMessage());}
        //catch(IOException ioe){System.out.println("Opening");}
    }
    ////////////////////////////////////////////// text file /////////////////////////////////////////////////////////////////////////////////
     public void openetxtFile(){
         try{
           bum = new FileWriter("customerOutFile.txt");  
           bw = new BufferedWriter (bum);
           
           bw.write("=========*=============        * CUSTOMER        *================*==============="+"\n");
           bw.write(String.format("%-15s %-15s %-15s %-15s %-15s\n", "ID","Name","Surname","Date of Birth","Age"));
           bw.write("==========*=============*=========================*===============*===============");
           for (int i = 0; i < customerArray.size(); i++) {
           bw.write(String.format("\n" + "%-15s %-15s %-15s %-15s  \n", customerArray.get(i).getStHolderId(), customerArray.get(i).getFirstName(), customerArray.get(i).getSurName(), customerArray.get(i).getDateOfBirth()));
}
         
         }
         catch(IOException fnfe){
             System.out.println(fnfe);
             System.exit(1);
         }
         try{
            bw.close( ); 
}
    catch (IOException ioe){
            System.out.println("customer file doesnt wanna close " + ioe.getMessage());
            System.exit(1);
}
     }
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////
     
     
   //////////////////////////////////// readdddd///////////////////////////////////////////////////////////////  
    public void readtheFile() {
        try{
            
         while(true)
            {
               Object bus = input.readObject();
               String jacob = "Customer";
               
               String kez = bus.getClass().getSimpleName() ;
               
               if (kez.equals(jacob))
               {customerArray.add((Customer)bus);}

               else{
                  {System.out.println("The arrays sorting has failed");}
            }
            }
        }
        catch(EOFException eofe){System.out.println("Customer ending");}
        catch(IOException | ClassNotFoundException ioe) {   System.out.println("file cannot open!" + ioe.getMessage());  }
        
        
       finally {     closeFile();      System.out.println("*** file is closed ***");   }
        sortID();
            }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    ///////////////////////////////////customer sort //////////////////////////////////////////////////////////////////
    public void sortID(){
             
            // while(true){
               // Object bus = input.readObject();
               // String jacob = "Customer";
              //  String kez = bus.getClass().getSimpleName();
                
                String[] nacon = new String [customerArray.size()];
                ArrayList<Customer> ssnewArray = new ArrayList<Customer>();
            
                int hateThisAsg = customerArray.size();
                for(int i = 0; i < hateThisAsg; i++){
                    nacon[i] = customerArray.get(i).getStHolderId();
            }
                Arrays.sort(nacon);
                for(int i = 0; i < hateThisAsg;i++){
                    for(int j = 0;j < hateThisAsg; j++){
                         if (nacon[i].equals(customerArray.get(j).getStHolderId()))
                         {
                         ssnewArray.add(customerArray.get(j));
                         }
                }
            }
          customerArray = ssnewArray;
            }
             
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
/////////////////////////////////////////// close file /////////////////////////////////////////////////////////////////    
    public void closeFile()
    {
        try  {input.close();}
        catch(IOException ioe)  {System.out.println("file cannot close!" + ioe.getMessage());}
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////    END OF CODE       ////////////////////////////////////////////////////////////////////////
  