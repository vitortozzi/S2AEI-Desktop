/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Tabelas.Usuario;

/**
 *
 * @author Vítor
 */
public class Sessao {
    private static Sessao instance = null;  
   private Usuario usuario;  
  
   private Sessao(){  
   }  
  
   public void setUsuario(Usuario usuario){  
      this.usuario = usuario;  
   }  
  
   public Usuario getUsuario(){  
       return usuario;  
   }  
   public static Sessao getInstance(){  
         if(instance == null){  
               instance = new Sessao();  
         }  
        return instance;  
   }
}
