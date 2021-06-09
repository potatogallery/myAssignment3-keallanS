/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.meass3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Keallan Saunders 219169357
 * suppAr.java
 * 08/06/2021
 * 
 */

public class suppAr {
    
    ObjectInputStream input;
    Object bus;
    Customer duster;
    Supplier pliers;
    private FileReader dumb;
    private FileWriter bum;
    private BufferedReader stupid;
    private BufferedWriter bw;
    ArrayList<Supplier>supplierArray = new ArrayList<Supplier>();
    
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 /////////////////////////////////////////////////////// SUPPLIER ////////////////////////////////////////////////////////////////////////////////////////////
    public void openFile1()
    {
        try   {input = new ObjectInputStream(new FileInputStream("stakeholder.ser"));
        System.out.println("***the SPP file is now open***");
        }
        catch(IOException ioe)  {System.out.println("file cannot open!"+ ioe.getMessage());}
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////// open text file ///////////////////////////////////////////////////////////////////////////
    public void openetxtFile1(){
         try{
           bum = new FileWriter("supplierOutFile.txt");  
           bw = new BufferedWriter (bum);
           
           bw.write("=========*===========================*        * SUPPLIER *        *=======================*==============="+"\n");
           bw.write(String.format("%-15s %-15s %-20s %-15s \n", "ID","Name","Product Type","Product Description"));
           bw.write("==========*==========================*============================*=======================*===============");
           for (int i = 0; i < supplierArray.size(); i++) {
           bw.write(String.format("\n"+ "%-15s %-15s %-15s %-15s \n", supplierArray.get(i).getStHolderId(), supplierArray.get(i).getName(), supplierArray.get(i).getProductType(), supplierArray.get(i).getProductDescription()));
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
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////// read file ///////////////////////////////////////////////////////////////////////////
    
       public void readtheFile1() {

          try{
            while(true)
            {
            for(int j = 0; j < 11; j++)
            {
               bus=input.readObject();
               if(bus.getClass() == Supplier.class)  
               { pliers = (Supplier) bus;        supplierArray.add(pliers);         System.out.println(pliers); }
            
          }
            }
          }
        catch(IOException | ClassNotFoundException ioe) {   System.out.println("file cannot open!" + ioe.getMessage());  }
       finally {     closeFile1();      System.out.println("*** file is closed ***");   }
          sortID1();
       }
       public void sortID1(){
             
            // while(true){
               // Object bus = input.readObject();
               // String jacob = "Customer";
              //  String kez = bus.getClass().getSimpleName();
                
                String[] nacon = new String [supplierArray.size()];
                ArrayList<Supplier> ssnewArray = new ArrayList<Supplier>();
            
                int hateThisAsg = supplierArray.size();
                for(int i = 0; i < hateThisAsg; i++){
                    nacon[i] = supplierArray.get(i).getName();
            }
                Arrays.sort(nacon);
                for(int i = 0; i < hateThisAsg;i++){
                    for(int j = 0;j < hateThisAsg; j++){
                         if (nacon[i].equals(supplierArray.get(j).getName()))
                         {
                         ssnewArray.add(supplierArray.get(j));
                         }
                }
                }
                supplierArray = ssnewArray;
       }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////// Close File //////////////////////////////////////////////////////////////////////////////
public void closeFile1()
    {
        try  {input.close();}
        catch(IOException ioe)  {System.out.println("file cannot close!" + ioe.getMessage());}
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////// END OF CODE //////////////////////////////////////////////////////////////////////////////////