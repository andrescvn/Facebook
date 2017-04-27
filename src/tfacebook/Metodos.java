/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfacebook;

import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Group;
import facebook4j.PostUpdate;
import facebook4j.ResponseList;
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
/**
 * permission to use facebook api
 */
    public void autorizar() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthAppId("1488249597859934")
                .setOAuthAppSecret("47f744f194f375b7e66369e2c2d2b911")
                .setOAuthAccessToken("EAAVJjhyeGF4BAHDWQ3uoZCTFFlKTRMIjcYp6M9JOFBqgVNX1OCZB67bnKhs9Yt2po7V3GMfUWvZBWjxUNFKnwwzRVCgYrZAI2db0F1AG6tkJPKG7z28R1NvSsdDwq8eXonjWKolDxz7yTFZAzZCiTdzporRIM4L8YZD")
                .setOAuthPermissions("email,publish_stream,publish_actions");
        FacebookFactory ff = new FacebookFactory(cb.build());
        facebook = ff.getInstance();
    }
/**
 * make a post
 * @param mensaje massege that u wanna post
 */
    public void publicar(String mensaje) {
        try {
            facebook.postStatusMessage(mensaje);
        } catch (FacebookException ex) {
            System.out.println("error 1" + ex.getMessage());
        }
    }

    public void like() {//no se puede hacer
        try {
  
            facebook.likePost(facebook.getId());
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * post a pic
     */
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
    /** 
     * make a commet
     * @param mensaje message that u want to send
     */
    public void comentarioFoto(String mensaje){
        try {
            facebook.commentPhoto("502857733438316", mensaje);
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * find all post from a group
     * @param mensaje group to find
     */
    public void buscartema(String mensaje){
        try {
            ResponseList<Group> results = facebook.searchGroups(mensaje);
            for(int i=0;i<results.size();i++)
                System.out.println(results.get(i));
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * commets that a post have
     */
    public void comentariospost(){
        try {
           ResponseList<Comment> results = facebook.getCommentReplies("100011422827368");
             for(int i=0;i<results.size();i++)
                System.out.println(results.get(i));
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
