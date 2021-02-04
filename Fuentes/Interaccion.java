/**
 * Clase Interaccion, interactua con el usuario para la
 * realizacion del laberinto
 * @author imfaj
 * @version 12/Julio/2016 
 * @see Raton
 * @see Laberinto
 */

//Se importa JOptionPane para la lectura de datos
import javax.swing.JOptionPane;

public class Interaccion {
 /**
  * metodo principal donde se piden los datos y se interactua con el usuario
  * .
  * 
  * @param args
  */
 public static void main(String[] args) {
  // se declaran objetos para comunicarse con las clases raton y laberinto
  Laberinto miObjetoLaberinto = new Laberinto();
  Raton miObjetoRaton = new Raton();
  miObjetoRaton.setLaberinto(miObjetoLaberinto);
  // se declaran e inicializan variables para el nombre del raton, las
  // dimensiones de la matriz y las funcionalidades
  String nombre = " ";
  int movimiento = 0;
  int fila = 0, columna = 0, opcionMenu = 0, opcionSalir = 0;
  // se imprime titulo del juego
  JOptionPane.showMessageDialog(null, "\tJuego: Laberinto, Queso y Raton\n");
  // se imprimen las instrucciones del juego
  JOptionPane.showMessageDialog(null,
    "El juego consiste en guiar al raton en su busqueda del queso a traves del laberinto.\nPara empezar se pedira un nombre para el raton y las dimensiones del laberinto deseado\n y posteriormente se mostraran opciones para el jugador.\n NOTA: Existe una opcion llama Ayuda, utilicela con prudencia y cuando la necesite. \n Esperamos disfrute el juego!");
  try {
   // se da nombre al raton
   String nombreAux = JOptionPane.showInputDialog("Ingrese un nombre para el raton: ");
   nombre = nombreAux;
   // se dn dimensiones a la matriz
   String filaAux = JOptionPane.showInputDialog("Ingrese la cantidad de filas que tendra el laberinto: ");
   fila = Integer.parseInt(filaAux);
   String columnaAux = JOptionPane
     .showInputDialog("Ingrese la cantidad de columnas que tendra el laberinto: ");
   columna = Integer.parseInt(columnaAux);
   // se asigna el valor a Fila
   miObjetoLaberinto.setFila(fila);
   // Asigna el valor a columna
   miObjetoLaberinto.setColumna(columna);
   // Llama al metodo para crear el laberinto Aleatorio
   miObjetoLaberinto.laberintoAleatorio();

   // Se hace uso de un bloque while para que el menu se repita
   while (opcionSalir != 3) {
    // se imprime menu
    String opcionMenuAux = JOptionPane.showInputDialog(
      "Ingrese segun la funcionalidad deseada:\n1) Mostrar matriz del laberinto (Ver Consola) \n2) Mostrar el laberinto (Ver Consola) \n3) Jugar \n4) Finalizar  \n 5)Ayuda ");
    opcionMenu = Integer.parseInt(opcionMenuAux);
    switch (opcionMenu) {
    // Caso para imprimir la matriz del laberinto
    case 1: {
     miObjetoLaberinto.imprimirLaberinto();
     break;
    }
    // Caso para imprimir el laberinto representado con simbolos
    case 2: {
     miObjetoLaberinto.imprimeLaberintoJuego();
     break;
    }
    // Caso jugar. Despliega menu con direcciones a las cuales
    // moverse
    case 3: {
     miObjetoLaberinto.buscarRaton();
     String movimientoAux = JOptionPane.showInputDialog("Hacia donde desea mover a " + nombre
       + " ? \n 8) Hacia Arriba \n 2) Hacia Abajo \n 6) Hacia la Derecha \n 4) Hacia la Izquierda");
     movimiento = Integer.parseInt(movimientoAux);
     miObjetoRaton.setMovimiento(movimiento);
     miObjetoRaton.camina();
     break;
    }
    // Caso para finalizar el juego.
    case 4: {
     JOptionPane.showMessageDialog(null, "Gracias por jugar!");
     opcionSalir = 3;
     break;
    }
    // Caso para solicitar ayuda. Permite demoler una pared.
    case 5: {
     miObjetoLaberinto.buscarRaton();
     miObjetoRaton.ayuda();
     String movimientoAux = JOptionPane.showInputDialog(" Hacia que direccion desea demoler?"
       + " ? \n 8) Hacia Arriba \n 2) Hacia Abajo \n 6) Hacia la Derecha \n 4) Hacia la Izquierda");
     movimiento = Integer.parseInt(movimientoAux);
     miObjetoRaton.setMovimiento(movimiento);
     break;
    }
    }
   }
   // Se controla error en caso de introducir valor invalido
  } catch (java.lang.NumberFormatException errorJOption) {
   JOptionPane.showMessageDialog(null, "Solicito Cancelar");
   JOptionPane.showMessageDialog(null, "Gracias por jugar!");
   opcionSalir = 3;
   movimiento = 5;
   miObjetoRaton.setMovimiento(movimiento);
  }
 }
}
