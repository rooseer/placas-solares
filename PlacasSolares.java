/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.placassolares;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PlacasSolares {

    private static ArrayList<Casa> casas = new ArrayList<>();

    public static Casa buscarCasa(String nifCasa) {
        for (int i = 0; i < casas.size(); i++) {
            if (casas.get(i).getNIF().equalsIgnoreCase(nifCasa)) {
                return casas.get(i);
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
        casas = new ArrayList<>();
        boolean NIFRepe;
        boolean quit = false;
        do {
            System.out.print("> ");
            String parametro = consola.readLine();
            String[] respuesta = parametro.split(" ");
            switch (respuesta[0].toLowerCase()) {
                case "addcasa":
                    if (respuesta.length == 4) {
                        NIFRepe = false;
                        int numero = Integer.parseInt(respuesta[3]);
                        Casa casa = buscarCasa(respuesta[1]);
                        if (casas.isEmpty() == false) {
                            if(casa != null){
                                    NIFRepe = true;  
                            }
                        }
                        if (numero >= 10) {
                            if (respuesta[1].length() == 9) {
                                if (NIFRepe == false) {
                                    Casa miCasa = new Casa(respuesta[1], respuesta[2], numero);
                                    casas.add(miCasa);
                                    System.out.println("OK: Casa registrada.");
                                } else {
                                    System.out.println("ERROR: Este NIF ya esta registrado");
                                }
                            } else {
                                System.out.println("ERROR: No es un NIF valido");
                            }
                        } else {
                            System.out.println("ERROR: Superficie incorrecta. Ha de ser més gran de 10.");
                        }
                    } else {
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                    }
                    break;
                case "addplaca":
                    int superficie = Integer.parseInt(respuesta[2]);
                    float precio = Float.parseFloat(respuesta[3]);
                    int potencia = Integer.parseInt(respuesta[4]);
                    if (respuesta.length == 5) {
                        Casa casa = buscarCasa(respuesta[1]);
                        if (casa != null) {
                            if (superficie > 0) {
                                if (precio > 0) {
                                    if (potencia > 0) {
                                        if (casa.superficieRestante() >= superficie) {
                                            PlacaSolar miPlaca = new PlacaSolar(superficie, precio, potencia);
                                            casa.afegirPlaca(miPlaca);
                                            System.out.println("OK: Placa añadida a la casa.");
                                        } else {
                                            System.out.println("ERROR: No hi ha espai disponible per a instal·lar aquesta placa.");
                                        }
                                    } else {
                                        System.out.println("ERROR: Potencia incorrecta. Ha de ser més gran de 0.");
                                    }
                                } else {
                                    System.out.println("ERROR: Precio incorrecta. Ha de ser més gran de 0.");
                                }
                            } else {
                                System.out.println("ERROR: Superficie incorrecta. Ha de ser més gran de 0.");
                            }
                        } else {
                            System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                        }
                    } else {
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                    }
                    break;
                case "addaparell":
                    if (respuesta.length == 4) {

                    }
                case "list":

                    break;
                case "quit":
                    quit = true;
                    break;

            }
        } while (!quit);

    }

}
