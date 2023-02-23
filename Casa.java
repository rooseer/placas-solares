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
        placas = new ArrayList<>();
        aparell = new ArrayList<>();
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
    public boolean getInteruptor(){
         return this.interuptor;
     }
    public int superficieRestante(){
        int superficieSum = 0;
        for(int i = 0; i < placas.size(); i++){
             superficieSum += placas.get(i).getSuperficie();
        }
        int superficieRestante = this.superficie - superficieSum;
        return superficieRestante;
    }
    public void afegirPlaca(PlacaSolar miPlaca){
        placas.add(miPlaca);
    }
 }
 
