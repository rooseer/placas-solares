/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.placassolares;

/**
 *
 * @author Admin
 */
public class PlacaSolar {
    private int superficie;
    private float precio;
    private int potencia;

    
    public PlacaSolar(int superficie, float precio, int potencia){
        this.superficie = superficie;
        this.precio = precio;
        this.potencia = potencia;
    }  
    public int getSuperficie(){
         return this.superficie;
     }
    public float getPrecio(){
         return this.precio;
     }
    public int getPotencia(){
         return this.potencia;
     }
    
}
