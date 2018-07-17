/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import classes.Servidor;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author ariel
 */
public class Cliente {

    static Socket cliente;
    
    
    public static ObjectOutputStream out;
    public static ObjectInputStream in;
    public static Servidor ServidorLogado;

    public static void main(String[] args) throws IOException {
        try {
            cliente = new Socket("localhost", 12345);
            cliente.setSoTimeout(15000);
            out = new ObjectOutputStream(cliente.getOutputStream());
            in = new ObjectInputStream(cliente.getInputStream());
            System.out.println ("Conectado");
            Login c = new Login(true);
            
            c.setVisible(true);
        } catch (IOException ex){
            System.out.println ("Erro: "+ex);
            Login c = new Login(false);
            c.setVisible(true);
        }

        
    }

}
