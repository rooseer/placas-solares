/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.placassolares;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Casa {
    private String NIF;
    private String nom;
    private int superficie;
    private boolean interuptor;
    private ArrayList<PlacaSolar> placas;
    private ArrayList<Aparell> aparell;
    
    public Casa(String NIF, String nom, int superficie){
        this.NIF = NIF;
        this.nom = nom;
        this.superficie = superficie;
        interuptor = true;
        placas = new ArrayList<PlacaSolar>();
        aparell = new ArrayList<Aparell>();
    }  
    public String getNIF(){
         return this.NIF;
     }
    public String getNom(){
         return this.nom;
     }
    public int getSuperficie(){
         return this.superficie;
     }
    public boolean isInteruptor(){
         return this.interuptor;
     }
    public ArrayList<PlacaSolar> getPlacas(){
        return this.placas;
    }
    public ArrayList<Aparell> getAparells(){
        return this.aparell;
    }
    // hacenos un metodo para comrpobar si podemos añadir una placa mas o no
    public int superficieRestante(){
        int superficieSum = 0;
        //recorremos el arraylist de placas y vamos sumando la superficie
        for(int i = 0; i < placas.size(); i++){
             superficieSum += placas.get(i).getSuperficie();
        }
        int superficieRestante = this.superficie - superficieSum;
        return superficieRestante;
    }
    // hacemos un setter de interruptor para poder cambiar el estado desde el main
    public void setInteruptor(boolean estado) {
    this.interuptor = estado;
}
    //hacemos un metodo para afegir la placa que le pasamos al arraylist de placas
    public void afegirPlaca(PlacaSolar miPlaca){
        placas.add(miPlaca);
    }
    // y otro metodo para añadir el aparell que le pasamos
     public void afegirAparell(Aparell miAparell){
        aparell.add(miAparell);
    }
     // creamos un metodo para buscar el aparell con esa descripcion y nos devuelva el aparell entero, si no lo encientra que me devuelva null
    public Aparell buscarAparell(String miDescripcion){
       for(int i = 0; i < aparell.size(); i++){
           if(aparell.get(i).getDescripcion().equalsIgnoreCase(miDescripcion)){
               return aparell.get(i);
           }
       }return null;
    }
    //creamos un metodo para calcular la potencia total que tiene una casa para saber cuantos aparells pueden estar encendidos
    public int potenciaPlacas(){
        int potenciaTotal = 0;
        for(int i = 0; i < placas.size(); i++){
            potenciaTotal += placas.get(i).getPotencia();
        }
        return potenciaTotal;
    }
    //creamos un metodo que nos devuelva la potencia total dels aparells que esten encendidos para que si es mayor que la potencia de las placas salten los plomos
    public int potenciaAparells(){
        int potenciaTotal = 0;
        for(int i= 0; i< aparell.size();i++){
            if(aparell.get(i).isInteruptor()== true)
            potenciaTotal += aparell.get(i).getConsumo();
        }
        return potenciaTotal;
    }
    //creamos un metodo para saber cuanto dinero se han gastado en todas las placas en esa casa 
    public float inversion(){
        float inversionTotal = 0;
        for(int i = 0; i < placas.size(); i++){   
            inversionTotal += placas.get(i).getPrecio();
        }     
        return inversionTotal;
    }
}
 
