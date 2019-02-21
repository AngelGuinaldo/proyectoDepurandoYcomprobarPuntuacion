package Codigo;

import Excepciones.FueraDeRango;
import Excepciones.ListaVacia;
import Utilidades.Pedir;
import java.util.ArrayList;

public class MetodosAuxiliares {

    public int contarBolasPorDelante(int posicion, ArrayList<Bola> ristraBolas, int acumulador2) {
        for (int i = posicion - 1; i >= 0; i--) { //cuenta las bolas que hay despues del disparo iguales a la bola disparada(cuenta la bola disparada)
            try {
                if (ristraBolas.get(posicion).getColor().equals(ristraBolas.get(i).getColor())) {
                    acumulador2++;
                    System.out.println(ristraBolas.get(posicion).getColor() + " 2 " + (acumulador2 - 1) + " " + ristraBolas.get(i).getColor());
                } else {
                    break;
                }
            } catch (Exception ex) {
                //no hace nada, impide que el programa rompa si intenta acceder a una posicion inexistente
            }

        }
        return acumulador2;
    }

    public int contarBolasDetras(int posicion, ArrayList<Bola> ristraBolas, int acumulador, int longitud) {
        for (int i = posicion + 1; i <= longitud; i++) {//cuenta las bolas que hay antes del disparo iguales a la bola disparada(cuenta la bola disparada)
//          System.out.println(ristraBolas.get(i));System.out.println(ristraBolas.get(posicion));
            try {
                if (ristraBolas.get(posicion).getColor().equals(ristraBolas.get(i).getColor())) {
                    acumulador++;
                    System.out.println(ristraBolas.get(posicion).getColor() + " 1 " + (acumulador - 1) + " " + ristraBolas.get(i).getColor());
                } else {
                    break;
                }
            } catch (Exception ex) {
                //no hace nada, impide que el programa rompa si intenta acceder a una posicion inexistente
            }
        }
        return acumulador;
    }

    public int pedirPosicion(int longitud) throws FueraDeRango {
        boolean numero = true;
        int posicion = 0;
        do {
            numero = true;
            try {
                posicion = Pedir.pedirInt("A que posicion quiere disparar?") - 1;//indicar la posicion a la que disparar
            } catch (NumberFormatException ex) {
                System.out.println("No es una posicion");
                numero = false;
            }
        } while (numero != true);
                if (posicion < 0) {
            throw new FueraDeRango("Disparo fallido");
        }
        if (posicion > longitud) {//comprueba que el disparo sea a la ristra de bolas y si no lanza una excepcion fuera de rango
            throw new FueraDeRango("Disparo fallido");
        }
        return posicion;
    }
}
