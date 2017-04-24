/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfacebook;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.conf.ConfigurationBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                .setOAuthAccessToken("EAAVJjhyeGF4BAMZA2UWZAxVe5xqpjQWZA2ZCSn8KMH3GJHLhy0UCnSZB32F2nFNauPgG7PfYpCtFZBpVH4CXng7FfChjt3qkZBtkMUOztHZBZA0pCnjClyyqVULc11EXr3IJjqByQd40GIyvSstYZBnYau0y9lKqNYjReZAZBpQoV6ZBSf74w8S8EgA5CYS4DF2amh6MZD")
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
}
