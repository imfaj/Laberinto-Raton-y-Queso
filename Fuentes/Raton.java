/**
 * Clase Raton. Se encarga de mover la ubicacion del raton
 * 
 * @author imfaj
 * @version 12/Julio/2016 
 */
import javax.swing.JOptionPane;

public class Raton {
 //Creacion del objeto miObjetoLaberinto
 Laberinto miObjetoLaberinto = new Laberinto();
 //variable movimiento. Influye en el movimiento del raton.
 private int movimiento = 0;

 /**
  * Metodo setLaberinto, asigna el mismo objeto usado en interaccion a Raton
  * 
  * @param miObjetoLaberinto
  */
 public void setLaberinto(Laberinto miObjetoLaberinto) {
  this.miObjetoLaberinto = miObjetoLaberinto;
 }

 /**
  * Metodo getLaberinto
  * 
  * @return miObjetoLaberinto
  */
 public Laberinto getLaberinto() {
  return this.miObjetoLaberinto;
 }

 /**
  * Metodo setMovimiento, asigna el valor de movimiento
  * 
  * @param movimiento
  */
 public void setMovimiento(int movimiento) {
  this.movimiento = movimiento;
 }
 /**
  * Metodo getMovimiento
  * 
  * @return movimiento
  */
 public int getMovimiento() {
  return this.movimiento;
 }
/**
 * Metodo camina . Segun el dato ingresado por el usuario mueve al raton hacia otr casilla.
 */
 public void camina() {
  // Variables que brindan la posicion del raton en la matriz Laberinto
  int columnaRaton, filaRaton;
  //Solicita la ubicacion en columna al objeto laberinto
  columnaRaton = getLaberinto().getColumnaRaton();
  //Solicita la ubicacion en fila al objeto laberinto
  filaRaton = getLaberinto().getFilaRaton();
  // Bloque Switch , determina los casos para donde se movera el raton.
  switch (getMovimiento()){
  // Movimiento hacia Arriba
  case 8: {
   // Si la posicion en fila del raton es mayor que la fila 0
   if (filaRaton > 0) {
    if (getLaberinto().getValorPosicionMov((filaRaton - 1), columnaRaton) == 1) {
     JOptionPane.showMessageDialog(null, "Hay una pared en esa casilla.");
     // Si el valor es igual a 3, el queso esta alli
    } else if(getLaberinto().getValorPosicionMov((filaRaton - 1), columnaRaton) == 3) {
     JOptionPane.showMessageDialog(null, "Felicidades ha encontrado el Queso!!");
    } else if(getLaberinto().getValorPosicionMov((filaRaton - 1), columnaRaton) == 0){
     // mueve al raton a la casilla indicada
     getLaberinto().asignarValor((filaRaton - 1), columnaRaton, 4);
     // Deja la celda anterior libre.
     getLaberinto().asignarValor(filaRaton, columnaRaton, 0);
    }
    // Si la posicion fila del raton es menor a 0
   } else {
    JOptionPane.showMessageDialog(null, "Esta en el limite superior del Laberinto.");
   }
  }
  break;
  // Movimiento hacia Abajo
  case 2: {
   
   if (filaRaton < ((getLaberinto().getFila()) - 1)) {
    if (getLaberinto().getValorPosicionMov((filaRaton + 1), columnaRaton) == 1) {
     JOptionPane.showMessageDialog(null, "Hay una pared en esa casilla.");
    } else {
     if (getLaberinto().getValorPosicionMov((filaRaton + 1), columnaRaton) == 3) {
      JOptionPane.showMessageDialog(null, "Felicidades ha encontrado el Queso!!");
     } else {
      getLaberinto().asignarValor((filaRaton + 1), columnaRaton, 4);
      getLaberinto().asignarValor(filaRaton, columnaRaton, 0);
     }
    }

   } else {
    JOptionPane.showMessageDialog(null, "Esta en el limite inferior del Laberinto.");
   }
  }
  break;
  // Movimiento hacia la derecha
  case 6: {
   if (columnaRaton < ((getLaberinto().getColumna()) - 1)) {
    if (getLaberinto().getValorPosicionMov(filaRaton, (columnaRaton + 1)) == 1) {
     JOptionPane.showMessageDialog(null, "Hay una pared en esa casilla.");
    } else {
     if (getLaberinto().getValorPosicionMov(filaRaton, (columnaRaton + 1)) == 3) {
      JOptionPane.showMessageDialog(null, "Felicidades ha encontrado el Queso!!");
     } else {
      getLaberinto().asignarValor(filaRaton, (columnaRaton + 1), 4);
      getLaberinto().asignarValor(filaRaton, columnaRaton, 0);
     }
    }

   } else {
    JOptionPane.showMessageDialog(null, "Esta en el limite Derecho del Laberinto.");
   }
  }// Movimiento hacia la izquierda
  
  break;
  case 4: {
 
   if (columnaRaton > 0) {
    if (getLaberinto().getValorPosicionMov(filaRaton, (columnaRaton - 1)) == 1) {
     JOptionPane.showMessageDialog(null, "Hay una pared en esa casilla.");
    } else {
     if (getLaberinto().getValorPosicionMov(filaRaton, (columnaRaton - 1)) == 3) {
      JOptionPane.showMessageDialog(null, "Felicidades ha encontrado el Queso!!");
     } else {
      getLaberinto().asignarValor(filaRaton, (columnaRaton - 1), 4);
      getLaberinto().asignarValor(filaRaton, columnaRaton, 0);
     }
    }
   } else {
    JOptionPane.showMessageDialog(null, "Esta en el limite Izquierdo del Laberinto.");
   }
  }// Caso para volver al menu principal
  break;
  default: {
   JOptionPane.showMessageDialog(null, "Opcion no valida");
  }
  }

 }
 /**
  * Metodo ayuda . En caso de que el usuario lo solicite, este metodo cambiara el valor
  * de una casilla con pared (Valor 1) a uno sin pared (Valor 0).
  */
 public void ayuda(){
  //Variables que indican la fila y la columna en las que esta el raton.
 int columnaRaton, filaRaton;
 //Solicita la ubicacion en columna al objeto laberinto
 columnaRaton = getLaberinto().getColumnaRaton();
 //Solicita la ubicacion en fila al objeto laberinto
 filaRaton = getLaberinto().getFilaRaton();
 // bloque switch para decidir que pared se demuele
 switch (getMovimiento()){
 
 // Para demoler pared superior
 case 8: {
  if (filaRaton > 0) {
   if (getLaberinto().getValorPosicionMov((filaRaton - 1), columnaRaton) == 1) {
    getLaberinto().asignarValor((filaRaton - 1), columnaRaton, 0);
   } else if(getLaberinto().getValorPosicionMov((filaRaton - 1), columnaRaton) == 3) {
    JOptionPane.showMessageDialog(null, "No es necesario demoler,alli esta el queso.");
   } else if(getLaberinto().getValorPosicionMov((filaRaton - 1), columnaRaton) == 0){
    JOptionPane.showMessageDialog(null, "No hay una pared en esa casilla.");
   }
  } else {
   JOptionPane.showMessageDialog(null, "Esta en el limite superior del Laberinto.");
  }
 }
 break;
 // Para demoler pared inferior.
 case 2: {
  
  if (filaRaton < ((getLaberinto().getFila()) - 1)) {
   if (getLaberinto().getValorPosicionMov((filaRaton + 1), columnaRaton) == 1) {
    getLaberinto().asignarValor((filaRaton + 1), columnaRaton, 0);
   } else {
    if (getLaberinto().getValorPosicionMov((filaRaton + 1), columnaRaton) == 3) {
     JOptionPane.showMessageDialog(null, "No es necesario demoler,alli esta el queso.");
    } else {
        JOptionPane.showMessageDialog(null, "No hay una pared en esa casilla.");
    }
   }

  } else {
   JOptionPane.showMessageDialog(null, "Esta en el limite inferior del Laberinto.");
  }
 }
 break;
 // Para demoler la pared ubicada a la derecha.
 case 6: {
  if (columnaRaton < ((getLaberinto().getColumna()) - 1)) {
   if (getLaberinto().getValorPosicionMov(filaRaton, (columnaRaton + 1)) == 1) {
    getLaberinto().asignarValor(filaRaton, (columnaRaton + 1), 0);
   } else {
    if (getLaberinto().getValorPosicionMov(filaRaton, (columnaRaton + 1)) == 3) {
     JOptionPane.showMessageDialog(null, "No es necesario demoler,alli esta el queso.");
    } else {
        JOptionPane.showMessageDialog(null, "No hay una pared en esa casilla.");
    }
   }

  } else {
   JOptionPane.showMessageDialog(null, "Esta en el limite Derecho del Laberinto.");
  }
 } 
 break;
//Para demoler la pared izquierda.
 case 4: {

  if (columnaRaton > 0) {
   if (getLaberinto().getValorPosicionMov(filaRaton, (columnaRaton - 1)) == 1) {
    getLaberinto().asignarValor(filaRaton, (columnaRaton - 1), 0);
   } else {
    if (getLaberinto().getValorPosicionMov(filaRaton, (columnaRaton - 1)) == 3) {
     JOptionPane.showMessageDialog(null, "No hay una pared en esa casilla.");
    } else {
        JOptionPane.showMessageDialog(null, "No hay una pared en esa casilla.");
    }
   }
  } else {
   JOptionPane.showMessageDialog(null, "Esta en el limite Izquierdo del Laberinto.");
  }
 }
 break;
 //Dato no valido para ningun caso
 default: {
  JOptionPane.showMessageDialog(null, "Opcion no valida");
 }  break;
 }

}
}