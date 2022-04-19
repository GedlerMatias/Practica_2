/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jugador;

import Pokemones.Pokemones;

/**
 *
 * @author Gedlr
 */
public class Jugador {
    private int dinero;
    Pokemones [] mascotas = new Pokemones[10];
    private String nombreJugador;

    public Jugador(int dinero, String nombreJugador) {
        this.dinero = dinero;
        this.nombreJugador = nombreJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        
    }
    
    
    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public Pokemones[] getMascotas() {
        return mascotas;
    }

    public void setMascotas(Pokemones[] mascotas) {
        this.mascotas = mascotas;
    }
    
    
}
