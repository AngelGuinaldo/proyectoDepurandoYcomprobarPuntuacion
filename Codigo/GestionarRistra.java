package Codigo;

import Excepciones.FueraDeRango;
import Excepciones.ListaVacia;

public class GestionarRistra {

    private Bola bola;
    private Ristra ristraBolas = new Ristra();

    public void avanzarRistra() {//avanza una posicion la ristra de bolas añadiendo una nueva bola
        bola = new Bola();
        ristraBolas.nuevaBola(bola);

    }

    public void dispararBola(Bola bola) {
        try {//intenta disparar una bola contra la ristra y lanza la excepcion si no consigue alcanzarla
            ristraBolas.disparar(bola);
            System.out.println("Disparada");
        } catch (FueraDeRango ex) {
            System.out.println(ex.getMessage());
        } catch (ListaVacia ex){
            System.out.println(ex.getMessage());
        }
    }

    public int tamaño() {
        return ristraBolas.longitud();
    }

    public void mostrarRistra() {
        ristraBolas.mostrarConFormato(ristraBolas.invertir());

    }
    
    public int getPuntuacion(){
        return ristraBolas.getPuntuacion();
    }

}
