/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author Brandon Godinez
 */
public class Examen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            File file = new File("owid-covid-data.csv");
            BufferedReader br = new BufferedReader(new FileReader(file)); 
            String st;
            ArrayList<GTMSumCasos> listaCasos = new ArrayList();
            st = br.readLine();
            while ((st = br.readLine()) != null){
                String[] data = st.split(",");
                GTMSumCasos objCasos = new GTMSumCasos();
                objCasos.iso_code= data[0];
                objCasos.continent = data[1];
                objCasos.location = data[2];
                objCasos.date = data[3];
                
                Casos objCaso = new Casos();
                objCaso.total_cases = Integer.valueOf(data[4]);
                
                boolean existe=false;
                
                for(GTMSumCasos e : listaCasos ){
                    if(e.iso_code.compareTo(objCasos.iso_code)==0){
                        e.casos.add(objCaso);
                        existe=true;
                        break;
                    }
                }
                
                if(!existe){
                    objCasos.casos.add(objCaso);
                    listaCasos.add(objCasos);
                }
                
            }
            int sumCasos = 0;
            
            GTMSumCasos sumacasos = null;
            
            Iterator<GTMSumCasos> iterator = listaCasos.iterator();
            while (iterator.hasNext()) {
                GTMSumCasos emp = iterator.next();
                if (emp.iso_code.compareTo("GTM")==0){
                    if (emp.casos.size()>0) {
                        int total = 0;
                        for(Casos objP : emp.casos){
                            total = total + objP.total_cases;
                        }
                        if(total>sumCasos){
                            sumCasos = total;
                            sumacasos = emp;
                        }
                    }
                }
            }
            System.out.println("Sus respuestas son:\n\n");
            System.out.println("Serie I: La suma de la columna total_cases es: " + String.valueOf(sumCasos));
            
        }catch(Exception e){
            System.out.println("error:"+e.getMessage());
        }
        
  //--------------------------------------------------------------------------//
  
        try{
            File file = new File("owid-covid-data.csv");
            BufferedReader br = new BufferedReader(new FileReader(file)); 
            String st;
            ArrayList<GTMSumCasos> listaCasos = new ArrayList();
            st = br.readLine();
            while ((st = br.readLine()) != null){
                String[] data = st.split(",");
                GTMSumCasos objCasos = new GTMSumCasos();
                objCasos.iso_code= data[0];
                objCasos.continent = data[1];
                objCasos.location = data[2];
                objCasos.date = data[3];
                
                Casos objCaso = new Casos();
                objCaso.total_cases = Integer.valueOf(data[4]);
                
                boolean existe=false;
                
                for(GTMSumCasos e : listaCasos ){
                    if(e.continent.compareTo(objCasos.continent)==0 && e.date.compareTo(objCasos.date) == 0) {
                        e.casos.add(objCaso);
                        existe=true;
                        break;
                    }
                }
                
                if(!existe){
                    objCasos.casos.add(objCaso);
                    listaCasos.add(objCasos);
                }
                
            }
            int sumCasos = 0;
            
            GTMSumCasos sumacasos = null;
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            Date date1 = sdf.parse("2020-01");
            
            Iterator<GTMSumCasos> iterator = listaCasos.iterator();
            while (iterator.hasNext()) {
                GTMSumCasos emp = iterator.next();
                
                Date date3 = sdf.parse(emp.date);         
                
                ArrayList total1 = new ArrayList();
                
                if (emp.continent.compareTo("Europe") == 0 && date3.compareTo(date1) == 0){
                    if (emp.casos.size()>0) {
                        int total = 0;
                        
                        for(Casos objP : emp.casos){
                            total = total + objP.total_cases;
                            System.out.println(total + objP.total_cases);
                            
                        }
                        //total1.add(total);                    
                        
                        //System.out.println(sum);                        
                        
                        if(total>sumCasos){
                            sumCasos = total;
                            sumacasos = emp;
                        }
                    }
                }
            }
            
            System.out.println("Serie II: La suma de la columna total_cases para Europa es: " + String.valueOf(sumCasos));
            
        }catch(Exception e){
            System.out.println("error:"+e.getMessage());
        }
    }
    
}
