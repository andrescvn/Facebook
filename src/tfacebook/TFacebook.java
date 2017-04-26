/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfacebook;

import javax.swing.JOptionPane;



/**
 *
 * @author acomesanavila
 */
public class TFacebook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Metodos tf= new Metodos();
        int op;
        tf.autorizar();
        do {
         op=Integer.parseInt(JOptionPane.showInputDialog("opcion"));  
         switch(op){
             case 1:
                 tf.publicar(JOptionPane.showInputDialog("mensaje"));
                 break;
             case 2:
                 tf.foto();
                 break;
             case 3:
                 tf.buscartema(JOptionPane.showInputDialog("tema"));
                 break;
             case 4:
                 tf.comentarioFoto(JOptionPane.showInputDialog("Mensaje"));
                 break;
         }
        }while(op!=0);

    }
}
