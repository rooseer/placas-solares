/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.placassolares;

/**
 *
 * @author Admin
 */
public class Aparell {
    private String descripcion;
    private int consumo;
    private boolean interuptor;
    
    public Aparell(String descripcion, int potencia){
        this.descripcion = descripcion;
        this.consumo = consumo;
    }  
    public String getDescripcion(){
         return this.descripcion;
     }
    public boolean getInteruptor(){
         return this.interuptor;
     }
    public int getConsumo(){
         return this.consumo;
     }
}
