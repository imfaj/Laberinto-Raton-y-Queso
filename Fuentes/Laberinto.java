/**
 * Clase Laberinto.
 * 
 * @author imfaj
 * @version 12/Julio/2016
 *
 */
//Se importa el Secure.Random para la generacion de una matriz diferente en todos los casos.
import java.security.SecureRandom;

public class Laberinto {

 // Matriz laberinto, es la matriz que funcionara como laberinto en el juego.
 private int laberinto[][];
 // Variable fila, El numero de filas por defecto de la matriz es 30.
 private int fila;
 // Variable columna, El numero de columnas por defecto de la matriz es 30.
 private int columna;
 //Variables que me indican la posicion en fila y en columna del raton en el laberinto
 private int filaRaton, columnaRaton;

 SecureRandom random = new SecureRandom();

 /**
  * Metodo constructor. Genera los valores de la fila y columna de la matriz, por defecto en 30 ambas.
  */
 public Laberinto() {
  this.fila = 30;
  this.columna = 30;
 }
 /**
  * Metodo Laberinto Este recibe los parametros para designar la cantidad de filas y columnas.
  * @param fila
  * @param columna
  */

 public Laberinto(int fila, int columna) {
  setFila(fila);
  setColumna(columna);
 }

 /**
  * Metodo setFila, asigna el valor dado por el usuario para las filas.
  * 
  * @param fila
  */
 public void setFila(int fila) {
  this.fila = fila;
 }

 /**
  * Metodo getFila. Retorna la variable fila.
  * 
  * @return fila
  */
 public int getFila() {
  return this.fila;
 }

 /**
  * Metodo setColuman, asigna el valor dado por el usuario para las columnas.
  * 
  * @param columna
  */
 public void setColumna(int columna) {
  this.columna = columna;
 }

 /**
  * Metodo getColumna. Retorna la variable columna
  * 
  * @return columna
  */
 public int getColumna() {
  return this.columna;
 }

 /**
  * Metodo laberintoAleatorio.Genera el laberinto con casillas vacias (0) y
  * con pared (1) Ubica al queso (3) y al raton (4) en lugares al azar.
  */
 public void laberintoAleatorio() {
  laberinto = new int[getFila()][getColumna()];

  for (int filaC = 0; filaC < getFila(); filaC++) {

   for (int columnaC = 0; columnaC < getColumna(); columnaC++) {

    laberinto[filaC][columnaC] = random.nextInt(100);
    if (laberinto[filaC][columnaC] < 55) {
     laberinto[filaC][columnaC] = 0;
    } else {
     laberinto[filaC][columnaC] = 1;
    }
   }
  }
  // El valor 3 representa el queso
  laberinto[random.nextInt(getFila() - 1)][getColumna() - 1] = 3;
  // El valor 4 representa al raton
  laberinto[random.nextInt(getFila() - 1)][0] = 4;
 }

 /**
  * Metodo imprimirLaberinto. Imprime la matriz correspondiente al laberinto utilizando numeros.
  * 
  */
 public void imprimirLaberinto() {
  System.out.println("\nEl Laberinto creado es: :");

  for (int filaC = 0; filaC < getFila(); filaC++) {

   for (int columnaC = 0; columnaC < getColumna(); columnaC++) {

    System.out.print("\t" + laberinto[filaC][columnaC]);
   }
   System.out.println();
  }
 }

 /**
  * Metodo imprimeLaberintoJuego . Imprime el laberinto a jugar representado por simbolos, paredes y casillas abiertas
  */
 public void imprimeLaberintoJuego() {
  String cadena = "";
  try {
   //Designa el tiempo en milisegundos para la impresion del laberinto
   Thread.sleep(1000);
   System.out.print("  -- El laberinto -- \n");
   for (int indice = 0; indice < laberinto.length; indice++) {
    System.out.print(" --- --- --- --- --- \n");
    for (int indiceSecundario = 0; indiceSecundario < laberinto[0].length; indiceSecundario++) {
     switch (laberinto[indice][indiceSecundario]) {
     case 0:
      cadena = "|   ";
      break;
     case -1:
      cadena = "|   ";
      break;
     case 1:
      cadena = "| # ";
      break;
     case 2:
      cadena = "| $ ";
      break;
     case 3:
      cadena = "| Q ";
      break;
     case 4:
      cadena = "| R ";
      break;
     }
     System.out.print(cadena);
    }
    System.out.print("|\n");
   }
   System.out.print(" --- --- --- --- --- \n");
  } catch (InterruptedException excepcionEnElHilo) {
   System.out.print("Error al intentar detener el hilo.\n" + excepcionEnElHilo.getMessage());
  }
  System.out.flush();
 }

 /**
  * Metodo buscarRaton . Ubica la posicion en la matriz del valor
  * correspondiente al raton.
  */
 public void buscarRaton() {
  for (int filaC = 0; filaC < laberinto.length; filaC++) {
   for (int columnaC = 0; columnaC < laberinto[filaC].length; columnaC++) {
    // El numero 4 representa al raton.
    if (laberinto[filaC][columnaC] == 4) {
     filaRaton = filaC;
     columnaRaton = columnaC;
    }
   }
  }
 }

 /**
  * Metodo getColumnaRaton. Retorna el valor de la columna en que esta el raton
  * 
  * @return columnaRaton
  */
 public int getColumnaRaton() {
  return this.columnaRaton;
 }

 /**
  * Metodo getValorPosicionMov Retorna el valor de la posicion solicitada
  * 
  * @return laberinto[fila][columna]
  */
 public int getValorPosicionMov(int fila, int columna) {
  return this.laberinto[fila][columna];
 }

 /**
  * Metodo getFilaRaton Retorna el valor de la fila en que esta el raton.
  * 
  * @return filaRaton
  */
 public int getFilaRaton() {
  return this.filaRaton;
 }

 /**
  * Metodo asignarValor . Modifica el valor de algun valor de la matriz.
  */
 public void asignarValor(int fila, int columna, int valor) {
  laberinto[fila][columna] = valor;
 }
}