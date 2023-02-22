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
    
    public Casa(String NIF, String nom, int superficie){
        this.NIF = NIF;
        this.nom = nom;
        this.superficie = superficie;
        interuptor = true;
        ArrayList<PlacaSolar> placas = new ArrayList<>();
        ArrayList<Aparell> aparell = new ArrayList<>();
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
    public int superficieRestante(int superficiePlacas){
        int superficieRestante = this.superficie - superficiePlacas;
        return superficieRestante;
    }
 }
 
