/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import javax.swing.JOptionPane;

/**
 *
 * @author acomesanavila
 */
public class Base {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        int op;
      Metodos met = new Metodos();
//        met.conexion();
//        do{
//        op=Integer.parseInt(JOptionPane.showInputDialog("1)Conectar con base de datos \n 2)Crear tabla \n 3)Introducir datos \n4)Busqueda \n5)Cambio de datos \n6)Borrado \n7)Salir"));
//        
//        switch(op){
//            case 1:
//                met.crearTabla();
//                break;
//            case 2:
//                met.insertarDatos();
//                break;
//            case 3:
//                met.busqueda();
//                break;
//            case 4:
//                met.update();
//                break;
//            case 5:
//                met.delete();
//                break;
//            case 6:
//                met.cerrarConexion();
//                System.exit(0);
//        }
//        }while(op!=6);
//
//}
met.conexion();
//met.insertarDatos();
Tabla t= new Tabla();
t.setVisible(true);
}
}