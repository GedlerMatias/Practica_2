/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;
import Tienda.VentanaTienda;
import JuegoMemoria.VentanaMemoria;
import Jugador.Jugador;
import Pokemones.ListaPokemones;
import Pokemones.Pokemones;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Gedlr
 */
public class VentanaJuego extends JFrame{
   
    public JPanel panel;
    
    private Pokemones [] listaPokemones = new Pokemones[151];
    private JLabel [] imagenesPokemones = new JLabel[151];
    private Pokemones [] mascotasDelJugador = new Pokemones[10];
    private JMenuItem informacion;
    private JMenuBar barraMenu;
    
    //generar botones que tendran acciones 
    private JButton botonReportes;
    private JButton botonTienda;
    private JButton botonCurar;
    private JButton botonExplorar;
    private JButton botonAlimentar;
    private JComboBox listaMascotasBox; 
    //objetos para obteners listas
    private final ListaPokemones obtenerPokemones = new ListaPokemones();
    public String nombreJugador;
    public Jugador jugador = new Jugador(100, "");

    public VentanaJuego(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        //cerrar ventana == terminar proceso 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("ENTRASTE AL JUEGO: " + nombreJugador);
        //guardar el nombre del juagdor 
        jugador.setNombreJugador(nombreJugador);
        
        //FULL SCREEN
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        //recibir los pokemones creados
        listaPokemones = obtenerPokemones.crearPokemones();
        imagenesPokemones = obtenerPokemones.imagenesPokemones();
        //CREAR PERFIL DE JUGADOR 
        
        
        //añadir la barra Menu
        barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);
        JMenu menuInformacion = new JMenu("AYUDA");
        barraMenu.add(menuInformacion);
        //agregamos los items del menu 
        informacion = new JMenuItem("INFO. JUEGO");
        menuInformacion.add(informacion);
        
        //llenamos la ventana con las funciones y elementos 
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        
        
        //configurar el panel principal
        panel = new JPanel();
        panel.setLayout(null);
        getContentPane().add(panel);
        
        //generar los componentes de la ventana 
        insertarBotones();
        insertarEtiquetas();
        iniciarActionListeners();
    }
    
    public void insertarEtiquetas(){
        
        //saludo inicial
        JLabel etiquetaPrincipal = new JLabel("!EL JUEGO HA INICIADO¡");
        etiquetaPrincipal.setFont(new Font("serif", Font.PLAIN, 40));
        etiquetaPrincipal.setBounds(575, 0, 500, 35);
        panel.add(etiquetaPrincipal);
        
        //muestra las mascotas
        JLabel mascotas = new JLabel("TUS MASCOTAS:");
        mascotas.setOpaque(true);
        mascotas.setBackground(java.awt.Color.cyan);
        mascotas.setFont(new Font("serif", Font.PLAIN, 25));
        mascotas.setBounds(75, 10, 200, 35);
        panel.add(mascotas);
        
        //mostrar el dinero actual
        JLabel etiquetaDinero = new JLabel(" TU ORO: " + jugador.getDinero());
        etiquetaDinero.setFont(new Font("serif", Font.PLAIN, 25));
        etiquetaDinero.setBounds(1330, 0, 200, 30);
        etiquetaDinero.setOpaque(true);
        etiquetaDinero.setBackground(java.awt.Color.cyan);
        panel.add(etiquetaDinero);
        
        JLabel etiquetaTienda = new JLabel("IR A LA TIENDA");
        etiquetaTienda.setFont(new Font("serif", Font.PLAIN, 25));
        etiquetaTienda.setBounds(285, 450, 200, 30);
        etiquetaTienda.setOpaque(true);
        etiquetaTienda.setBackground(java.awt.Color.ORANGE);
        panel.add(etiquetaTienda);
        
        JLabel etiquetaExplorar = new JLabel("IR A EXPLORAR");
        etiquetaExplorar.setFont(new Font("serif", Font.PLAIN, 25));
        etiquetaExplorar.setBounds(535, 450, 190, 30);
        etiquetaExplorar.setOpaque(true);
        etiquetaExplorar.setBackground(java.awt.Color.ORANGE);
        panel.add(etiquetaExplorar);
        
        JLabel etiquetaCurar = new JLabel("CURAR MASCOTA");
        etiquetaCurar.setFont(new Font("serif", Font.PLAIN, 25));
        etiquetaCurar.setBounds(758, 450, 190, 30);
        etiquetaCurar.setOpaque(true);
        etiquetaCurar.setBackground(java.awt.Color.ORANGE);
        panel.add(etiquetaCurar);
        
        JLabel etiquetaAlimentar = new JLabel("ALIMENTAR MASCOTA");
        etiquetaAlimentar.setFont(new Font("serif", Font.PLAIN, 25));
        etiquetaAlimentar.setBounds(995, 450, 190, 30);
        etiquetaAlimentar.setOpaque(true);
        etiquetaAlimentar.setBackground(java.awt.Color.ORANGE);
        panel.add(etiquetaAlimentar);
        
        JLabel etiquetaReportes = new JLabel("VER REPORTES");
        etiquetaReportes.setFont(new Font("serif", Font.PLAIN, 25));
        etiquetaReportes.setBounds(1350, 120, 190, 30);
        etiquetaReportes.setOpaque(true);
        etiquetaReportes.setBackground(java.awt.Color.ORANGE);
        panel.add(etiquetaReportes);
        
        
        
        //imagen de fondo
        ImageIcon imagen = new ImageIcon("imagenesTecnicas/fondoSecundario.jpg");
        JLabel imagenFondoPrincipal = new JLabel();
        imagenFondoPrincipal.setBounds(0, 0, 1550, 800);
        imagenFondoPrincipal.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(imagenFondoPrincipal.getWidth(), imagenFondoPrincipal.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(imagenFondoPrincipal);
        
        
    }
    //400 a 285 (115 menos)
    public void insertarBotones(){
        ImageIcon imagenTienda = new ImageIcon("imagenesTecnicas/logoTienda.png");
        botonTienda = new JButton();
        botonTienda.setBounds(285, 500, 200, 200);
        botonTienda.setIcon(new ImageIcon(imagenTienda.getImage().getScaledInstance(botonTienda.getWidth(), botonTienda.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(botonTienda);
        
        botonCurar = new JButton();
        botonCurar.setBounds(770, 500, 190, 200);
        ImageIcon imagenCurar = new ImageIcon("imagenesTecnicas/curar.jpg");
        botonCurar.setIcon(new ImageIcon(imagenCurar.getImage().getScaledInstance(botonCurar.getWidth(), botonCurar.getHeight(), Image.SCALE_SMOOTH))); //la imagen tendra el mismo tamaño del boton
        panel.add(botonCurar);
        
        botonExplorar = new JButton();
        botonExplorar.setBounds(535, 500, 190, 200);
        ImageIcon imagenExplorar = new ImageIcon("imagenesTecnicas/explorar.jpg");
        botonExplorar.setIcon(new ImageIcon(imagenExplorar.getImage().getScaledInstance(botonExplorar.getWidth(), botonExplorar.getHeight(), Image.SCALE_SMOOTH))); //la imagen tendra el mismo tamaño del boton
        panel.add(botonExplorar);
        
        botonAlimentar = new JButton();
        botonAlimentar.setBounds(1009, 500, 190, 200);
        ImageIcon imagenAlimentar = new ImageIcon("imagenesTecnicas/alimentar.jpg");
        botonAlimentar.setIcon(new ImageIcon(imagenAlimentar.getImage().getScaledInstance(botonAlimentar.getWidth(), botonAlimentar.getHeight(), Image.SCALE_SMOOTH))); //la imagen tendra el mismo tamaño del boton
        panel.add(botonAlimentar);
        
        botonReportes = new JButton();
        botonReportes.setBounds(1400, 150, 120, 120);
        ImageIcon imagenReportes = new ImageIcon("imagenesTecnicas/logoReportes.png");
        botonReportes.setIcon(new ImageIcon(imagenReportes.getImage().getScaledInstance(botonReportes.getWidth(), botonReportes.getHeight(), Image.SCALE_SMOOTH))); //la imagen tendra el mismo tamaño del boton
        panel.add(botonReportes);
        
        //mascotas deplegables
        String [] nombresMascotas = {};
        listaMascotasBox = new JComboBox(nombresMascotas);
        listaMascotasBox.setBounds(75, 50, 120, 35);
        panel.add(listaMascotasBox);
        
        listaMascotasBox.addItem(listaPokemones[0].getNombre());
        
    }
    
    public void iniciarActionListeners(){
        //crear los objetos de acciones
        ActionListener  activarBotonTienda = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                //llamar la ventana de tienda 
                VentanaTienda ventanaTienda = new VentanaTienda();
                mascotasDelJugador=ventanaTienda.iniciarComponentes(jugador.getDinero(), mascotasDelJugador);
                ventanaTienda.setVisible(true);
                jugador.setDinero(ventanaTienda.regresarDinero());
                System.out.println(jugador.getDinero());
                     
            }
        };
        botonTienda.addActionListener(activarBotonTienda);
        
        ActionListener  activarBotonExplorar = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent a){
                //llamar la ventana de juegoMemoria 
                VentanaMemoria ventanaMemoria = new VentanaMemoria(); 
                ventanaMemoria.setVisible(true);
            }
        };
        botonExplorar.addActionListener(activarBotonExplorar);
    }
}
