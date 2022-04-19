
package Pokemones;

public class Pokemones {
    private String nombre;
    private int vida;
    private int nivel;
    //private JLabel imagenPokemon;

    public Pokemones(String nombre, int vida, int nivel /*JLabel imagenPokemon*/) {
        this.nombre = nombre;
        this.vida = vida;
        this.nivel = nivel;
        //this.imagenPokemon = imagenPokemon;
                
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
    
    
    

}
