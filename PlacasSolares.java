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
    //inicializamos el array list aqui fuera ya que lo vamos a usar en el metodo de buscar casa
    private static ArrayList<Casa> casas = new ArrayList<>();
    /*creo este metodo para comprobar si hay un dni igual al que nos dan, si lo hay nos devuelve la casa entera,
     si no lo hay nos devolvera un null */
    public static Casa buscarCasa(String nifCasa) {
        /*recorremos el arrayList y le añadimos una condicion que mientras el NIF que esta recorriendo 
        coincida con el que nostros le pasamos devuelva la casa de ese NIF */
        for (int i = 0; i < casas.size(); i++) {
            if (casas.get(i).getNIF().equalsIgnoreCase(nifCasa)) {
                return casas.get(i);
            }
        }
        // de lo contrario que no encuentre ningun NIF que coincida con el que nosotros le pasamos devuelva null
        return null;
    }

    public static void main(String[] args) throws IOException {
        // inicializamos un input con bufferedReader para que los usuarios introduzcan los parametros
        BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
        // definimos el nombre del arrayList
        casas = new ArrayList<>();
        /*Creo un booleano para saber si el NIF estara repetido o no para que no agregen dos casas 
        con el mismo NIF*/
        boolean NIFRepe;
        // Y otro booleano para el quit 
        boolean quit = false;
        
        do {
            /*esta sera la entrada y lo hacemos sin salto de linea para que luego el usario 
            introduzca los parametros en le misma linea*/
            System.out.print("> ");
            String parametro = consola.readLine();
            /*hacemos un split para separar los parametros que añadira el usuario*/
            String[] respuesta = parametro.split(" ");
            //Casa casa = buscarCasa(respuesta[1]);
            /*como el parametro 0 siempre va a ser los parametros que indican lo que 
            queremos hacer abrimos el switch com el parametro 0 y le ponemos el lowerCase
            para que todo lo que escriba el usuario lo convierta a minusculas y asi si añade
            mayusculas entre medio o todo lo contara como valido*/
            switch (respuesta[0].toLowerCase()) {
                /*comencamos con los casos y empezamos con el addcasa, si el usuario en el 
                parametro 0 escribe addcasa de cualquier manera(mayusculas o minusculas) entrara aqui y hara lo que definimos*/
                case "addcasa":
                    /*primero comprobamos si nos pone los parametros que necesitamos para hacer el addcasa, para ello necesita 
                    4 parametros, mientras la longitud de respuesta sea = a 4 nos ara el addcasa */
                    Casa casa = buscarCasa(respuesta[1]);
                    if (respuesta.length == 4) {
                        /*definimos que nifRepe por defecto esta en false ya que si lo comprueba y encuentra un NIF igual se
                        quedara en true y nos dara un falso resultado a la hora de comprobar otro NIF*/
                        NIFRepe = false;
                        /*como todo lo que nos devuelve el bufferedeReader es un string, tenemos que convertirlo a su tipo en 
                        este caso int.*/
                        int numero = Integer.parseInt(respuesta[3]);
                        /*aqui estamos diciendo que mientras el arraylist contenga casas es decir no este vacio entre */
                        if (casas.isEmpty() == false) {
                            /*y mientras casa sea diferente de null es decir que en el metodo de buscarCasa haya encontrado un NIF igual al 
                            que le hemos dado nos cambie el booleano a true para saber que ya existe una casa con ese nif y asi no dejar que 
                            cree otra casa con ese nif*/
                            if(casa != null){
                                    NIFRepe = true;  
                            }
                        }
                        /*aqui seguimos comprobando condiciones y le decimos que mientras el numero que es un parametro puesto por
                        el usuario sea mayor o igual a 10 entre*/
                        if (numero >= 10) {
                            /*Comporbamos el Nif y para que lo cuente como bueno tiene que tener una longitud de 9 si es asi entrara*/
                            if (respuesta[1].length() == 9) {
                                /*Y por ultima comprobacion mientras el booleano de nif repe sea falso es decir no haya encontrado
                                ningun nif igual al recorer las casas entrara y añadira la casa con los parametros indicados */
                                if (NIFRepe == false) {
                                    Casa miCasa = new Casa(respuesta[1], respuesta[2], numero);
                                    //añadimos la casa en el arrayList de casas
                                    casas.add(miCasa);
                                    // y mostramos un mensaje como que se ha registrado correctamente 
                                    System.out.println("OK: Casa registrada.");
                                } else { 
                                    System.out.println("ERROR: Ja hi ha una casa registrada amb aquest nif");
                                }
                            } else {
                                System.out.println("ERROR: No es un NIF valido");
                            }
                        } else { 
                            System.out.println("ERROR: Superficie incorrecta. Ha de ser més gran de 10.");
                        }
                    } else {//si no es el numero de parametros correcto nos escribira este error:
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                    }
                    break;
                //cremos otro caso para el addplaca para que cuando se llame a este caso se añada una placa si cumple los requisitos
                case "addplaca":
                    //llamamos al metodo buscar casa para que compruebe el nif que le pasamos 
                    casa = buscarCasa(respuesta[1]);
                    // convertimos los Strings a los tipos correspondientes, en este caso dos integers y un float
                    int superficie = Integer.parseInt(respuesta[2]);
                    float precio = Float.parseFloat(respuesta[3]);
                    int potencia = Integer.parseInt(respuesta[4]);
                    /* y comenzamos con las comprobaciones, mientras se introduzcan 5 parametros inlcluyendo el 
                    addplaca seguira comprobando las demas condiciones*/
                    if (respuesta.length == 5) {
                        // si ha encontrado un nif igual al que le pasamos, es decir es diferente de null entra en la condicion
                        if (casa != null) {
                            // y mientras que la superficie, el precio y la potencia sean mayor que 0 se podra añadir la placa
                            if (superficie > 0) {
                                if (precio > 0) {
                                    if (potencia > 0) {
                                        /*y por ultima comprobacion en el addplaca llamamos a la funcion que calcula la superficie que 
                                        nos queda en esa casa, y mientras ese numero sea mayor o igual que la superficie que le pasamos
                                        añadira la placa*/
                                        if (casa.superficieRestante() >= superficie) {
                                            PlacaSolar miPlaca = new PlacaSolar(superficie, precio, potencia);
                                            /*llamamos la funcion de afegirPlaca que añade las placas en el arrayList de placas que esta 
                                            en la clase de casa y le pasamos el parametro de miPlaca es decir la placa que estamos añadiendo ahora */
                                            casa.afegirPlaca(miPlaca);
                                            //Y mostramos un mensaje conforme la placa se ha añadido correctamente
                                            System.out.println("OK: Placa añadida a la casa.");
                                        } else {// si la superficie que le pasamos es mayor que la que nos queda en la casa nos mostrara mensaje de error
                                            System.out.println("ERROR: No hi ha espai disponible per a instal·lar aquesta placa.");
                                        }
                                    } else {// si la potencia, el precio y la superficie no es mayor que 0 nos mostrara los siguentes mensajes de error
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
                    } else {// y si no le pasamos todos los parametros de addplaca mostrara este error:
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                    }
                    break;
                /*hacemos otro caso para añadir un aparell, cuando el usuario escriba addaparell con mayusculas o 
                 minusculas mientras cumpla las condiciones indicadas*/
                case "addaparell":
                    casa = buscarCasa(respuesta[1]);
                    /*para que nos añada un aparell lo que tenemos que hacer es comprobar que el usuario haya 
                    introducido 4 parametros*/
                    if (respuesta.length == 4) {
                        //convertimos los parametros necesarios de String a su tipo, en este caso solo hay que pasar uno a integer
                        potencia = Integer.parseInt(respuesta[3]);
                        // si encuentra un NIF igual al que le pasamos es decir esdecir no nos devuelve un null seguimos comprobando
                        if(casa != null){
                            //Y mientras la potencia sea mayor que 0 añadira el aparell 
                            if (potencia > 0){
                                Aparell miAparell = new Aparell(respuesta[2], potencia);
                                /*llamamos la funcion de afegirAparell que añade los aparells en el arrayList de aparell que esta 
                                en la clase de casa y le pasamos el parametro de miAparell es decir el aparell que estamos añadiendo ahora */
                                casa.afegirAparell(miAparell);
                                //Y mostramos mensaje conforme se ha añadido correctamente 
                                System.out.println("OK: Aparell añadida a la casa.");
                            }else{
                                System.out.println("ERROR: Potencia incorrecta. Ha de ser més gran de 0.");
                            }
                        }else{
                            System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                        }
                    }else{
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                    }
                    break;
               /* creamos otro caso para encender el interuptor general de la casa */
                case "oncasa":
                    casa = buscarCasa(respuesta[1]);
                    /*para encender el intrerruptor general lo unico que necesitamos es que pongan onCasa y el 
                    NIF es decir mientras pongan dos parametros entrara*/
                    if (respuesta.length == 2) {
                        if(casa != null){
                            /* el interruptor general solo se encendera si esta apagado osea si ya esta encendido mostrara mensaje de error, 
                            mientras este apagado es decir en false lo encendera y mostrara un mensaje conforme lo ha encendido*/
                            if (casa.isInteruptor() == false) {
                                casa.setInteruptor(true);
                                System.out.println("OK: Interruptor encès.");

                            }else{
                                System.out.println("ERROR: La casa ja té l'interruptor encès.");
                            }
                        }else{
                              System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                        }
                    }else{
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                    }
                case "onaparell":
                    casa = buscarCasa(respuesta[1]);
                    if (respuesta.length == 3 ) {
                         if(casa != null){
                             if (casa.isInteruptor() == true) {
                                    for (int i= 0; i < casa.getAparells().size(); i++){
                                        if(casa.getNIF().equals(respuesta[1])){
                                            // hacer metodo en la clase casa que recorra araylist de apparells y compare la descripcion (miAparell.getDescripcion())
                                            
                                        }
                                    }
                             }else{
                                 System.out.println("ERROR: No es pot encendre l'aparell. L'interruptor general està apagat.");
                             }
                         }else{
                              System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                        }
                    }else{
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
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
