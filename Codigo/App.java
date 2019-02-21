package Codigo;

import Excepciones.ListaVacia;
import static Utilidades.Constantes.FIN;
import javax.swing.JOptionPane;

public class App {

    public App(){
        String[] inicio = {"INICIAR PARTIDA", "EXIT"};
        int iniciar = JOptionPane.showOptionDialog(
                null,
                "Elegir nivel",
                null,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                inicio,
                null
        );

        switch (iniciar) {
            case 0:

                String[] opciones = {"PRINCIPIANTE", "INTERMEDIO", "AVANZADO"};
                int opcion = JOptionPane.showOptionDialog(
                        null,
                        "Elegir nivel",
                        null,
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        opciones,
                        null
                );

                GestionarRistra ristra = new GestionarRistra();
                Bola bola = new Bola();

                do {
                    boolean disparada = false;

                    switch (opcion) {
                        case 0:

                            ristra.avanzarRistra();
                            ristra.mostrarRistra();
                            System.out.println("\033[30m\nBola a disparar: " + bola.toString());

                            String[] elecciones = {"SI", "NO", "EXIT"};
                            int eleccion = JOptionPane.showOptionDialog(
                                    null,
                                    "Desea disparar una bola??",
                                    null,
                                    JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE,
                                    null,
                                    elecciones,
                                    null
                            );
                            switch (eleccion) {
                                case 0:
                                    ristra.dispararBola(bola);
                                    bola = new Bola();
                                    break;
                                case 2:
                                    JOptionPane.showMessageDialog(null, "Has abandonado las partida\nPuntuacion: " + ristra.getPuntuacion());
                                    System.out.println("\033[30m");
                                    System.exit(FIN);
                                default:
                                    break;
                            }

                            break;

                        case 1:
                            break;
                        case 2:
                            break;
                        default:
                            break;
                    }

                } while (ristra.tamaño() < FIN);
                ristra.mostrarRistra();

                JOptionPane.showMessageDialog(null, "HAS PERDIDO \nPuntuacion: " + ristra.getPuntuacion());
                System.out.println("\033[30m");
                System.out.println("");
                break;
            default:
                break;
        }

    }

}
