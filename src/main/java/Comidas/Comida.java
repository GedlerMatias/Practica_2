/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comidas;

import Tienda.TIENDA;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Gedlr
 */
public class Comida extends TIENDA{
    private final String nombre;
    private final double peticionesComida;

    public Comida(String nombre, double peticionesComida, int precio) {
        super(precio);
        this.nombre = nombre;
        this.peticionesComida = peticionesComida;
    }

   

    
    //crea las comidas con nombre y beneficio
    public Comida [] generarComidas(){
        Comida [] listaComidas = new Comida[3];
        Comida manzana = new Comida("Manzana", 1, 10);
        Comida cereal = new Comida("Cereal", 7, 30);
        Comida waffle = new Comida("Waffle", 10, 50);
        listaComidas[0] = manzana;
        listaComidas[1]=cereal;
        listaComidas[2]=waffle;
        return listaComidas;
        
    }
    //crear las comidas y regresa un array con las IMAGENES
    public JLabel [] generarImagenesComidas(){
        JLabel [] imagenesComida = new JLabel[3];
        
        ImageIcon imagenManzana = new ImageIcon("imagenesTecnicas/manzana.png");
        JLabel etiquetaManzana = new JLabel();
        etiquetaManzana.setIcon(new ImageIcon(imagenManzana.getImage().getScaledInstance(etiquetaManzana.getWidth(), etiquetaManzana.getHeight(), Image.SCALE_SMOOTH)));
        
        ImageIcon imagenCereal = new ImageIcon("imagenesTecnicas/cereal.png");
        JLabel etiquetaCereal = new JLabel();
        etiquetaCereal.setIcon(new ImageIcon(imagenCereal.getImage().getScaledInstance(etiquetaCereal.getWidth(), etiquetaCereal.getHeight(), Image.SCALE_SMOOTH)));
        
        ImageIcon imagenWaffle = new ImageIcon("imagenesTecnicas/manzana.png");
        JLabel etiquetaWaffle = new JLabel();
        etiquetaCereal.setIcon(new ImageIcon(imagenWaffle.getImage().getScaledInstance(etiquetaCereal.getWidth(), etiquetaCereal.getHeight(), Image.SCALE_SMOOTH)));
    
        imagenesComida[0]=etiquetaManzana;
        imagenesComida[1]=etiquetaCereal;
        imagenesComida[2]=etiquetaWaffle;
        
        return imagenesComida;
    }
}
