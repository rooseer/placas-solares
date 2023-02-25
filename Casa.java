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
    //definimos lo que tiene una casa
    private String NIF;
    private String nom;
    private int superficie;
    private boolean interuptor;
    private ArrayList<PlacaSolar> placas;
    private ArrayList<Aparell> aparell;
    /* en el constructor para añadir una casa solo necesitaremos que nos faciliten el nif el nombre y la superficie*/
    public Casa(String NIF, String nom, int superficie){
        this.NIF = NIF;
        this.nom = nom;
        this.superficie = superficie;
        interuptor = true;
        placas = new ArrayList<>();
        aparell = new ArrayList<>();
    }  
    // y hacemos los get para poder acceder a ellos desde otras clases
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
    public ArrayList<Aparell> getAparells() {
        return aparell;
    }
    /* creamos un metodo que nos calcule la superficie que le queda a esa casa para saber si cabe la placaSolar*/
    public int superficieRestante(){
        //definimos una variable para sumar la superficie total con todas las placas que hay en la casa y le decimos que por defecto vale 0
        int superficieSum = 0;
        // recorremos el arraylist de placas donde se guardan todas las suprerficies y las vamos sumando a la variable creada antes
        for(int i = 0; i < placas.size(); i++){
             superficieSum += placas.get(i).getSuperficie();
        }
        /*lo que nos queda es restarle la superficie total de todas las placas que hay e la casa menos la superficie de la casa*/
        int superficieRestante = this.superficie - superficieSum;
        // y devolvemos la superficie que le queda 
        return superficieRestante;
    }
    //hacemos un setter para cambiarle el estado al interruptor
    public void setInteruptor(boolean estado) {
    this.interuptor = estado;
    }
    // creamos un metodo para añadir la placa que nos pasan al arrayList de placas 
    public void afegirPlaca(PlacaSolar miPlaca){
        placas.add(miPlaca);
    }
    // y otro metodo para añadir el aparell que nos pasan al arrayList de aparell
    public void afegirAparell(Aparell miAparell){
        aparell.add(miAparell);
    }
    /*public String buscarDescripcionAparell(String miDescripcion){
        for (int i=0; i < aparell.size(); i++){
            if(aparell.get(i).getDescripcion()){
        }
    }*/
 }
 
