package Codigo;

import Excepciones.FueraDeRango;
import Excepciones.ListaVacia;
import java.util.ArrayList;

public interface IRistra {
    void nuevaBola(Bola bola);
    int longitud();
    void mostrarAñadiendoDerecha();
    ArrayList<Bola> invertir();
    void mostrarConFormato(ArrayList<Bola> bola);
    ArrayList<Bola> disparar(Bola bola)throws FueraDeRango,ListaVacia ;
    void explotar(int posicion, int acumulador, int acumulador2) throws ListaVacia;
//    int puntuacion(int bolasJuntas);
    void concatenarExplosiones(Bola bola, int control) throws FueraDeRango, ListaVacia;
}
