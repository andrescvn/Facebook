/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfacebook;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PostUpdate;
import facebook4j.conf.ConfigurationBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author acomesanavila
 */
public class Metodos {

    static Facebook facebook;

    public void autorizar() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthAppId("1488249597859934")
                .setOAuthAppSecret("47f744f194f375b7e66369e2c2d2b911")
                .setOAuthAccessToken("EAAVJjhyeGF4BANGt6ugqZAFXD51Hkah8YxHYW8JSQ9jLiaqPqO7i94iLZArI4vqhgt6qf6FKFHC5838To0DMZA4BnGAi8bBWtj0vqHL9DULXNSKATaBYBfZCWgUy3Rz5ZAR8TXTZAk32NGiAdFIuUDJQCH23O0g7XK97xdWkMopmVTNff0p8TLZCZBt23nKYDMoZD")
                .setOAuthPermissions("email,publish_stream,publish_actions");
        FacebookFactory ff = new FacebookFactory(cb.build());
        facebook = ff.getInstance();
    }

    public void publicar(String mensaje) {
        try {
            facebook.postStatusMessage(mensaje);
        } catch (FacebookException ex) {
            System.out.println("error 1" + ex.getMessage());
        }
    }

    public void like() {
        try {
  
            facebook.likePost(facebook.getId());
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void foto(){
        try {
            PostUpdate post = null;
            try {
                post = new PostUpdate(new URL("http://facebook4j.org"))
                        .picture(new URL(JOptionPane.showInputDialog("URL")))
                        .name(JOptionPane.showInputDialog("titulo"))
                        .caption(JOptionPane.showInputDialog("subtitulo"))
                        .description(JOptionPane.showInputDialog("descripcion"));
            } catch (MalformedURLException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            }
            facebook.postFeed(post);
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
