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
        do {
         op=Integer.parseInt(JOptionPane.showInputDialog("opcion"));  
         switch(op){
             case 1:
                 tf.autorizar();
                 break;
             case 2:
                 tf.publicar(JOptionPane.showInputDialog("mensaje"));
                 break;
         }
        }while(op!=0);

    }
}
