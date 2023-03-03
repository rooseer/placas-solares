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
    
    public Aparell(String descripcion, int consumo){
        this.descripcion = descripcion;
        this.consumo = consumo;
        this.interuptor = false;
    }  
    public String getDescripcion(){
         return this.descripcion;
     }
    public boolean isInteruptor(){
         return this.interuptor;
     }
    public int getConsumo(){
         return this.consumo;
     }
    public void setInteruptor(boolean estado) {
        this.interuptor = estado;
    }
}
