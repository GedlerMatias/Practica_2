
package Principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class VentanaPrincipal extends JFrame{
    public JPanel panelPrincipal;
    public JTextField capturarNombre;
    public JLabel mostrarNombre;
    public JButton boton1;
    
    public VentanaPrincipal(){
        //terminar proceso al cerrar la ventana 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("JUEGO MASCOTAS Y LABERINTOS");
        //COLOCAR EL PANTALLA COMPLETA 
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);//con eso podemos unicar los componentes usando setBounds
        
        IniciarComponentes();
    }
    
    private void IniciarComponentes(){
        panelPrincipal = new JPanel();
        //se crea el panel y se añade a la ventana
        panelPrincipal.setBackground(Color.pink);
        panelPrincipal.setLayout(null);
        getContentPane().add(panelPrincipal);
        
        
        colocarJLabels();
        colocarBotones();
        colocarTextFields();
    }
    
    private void colocarJLabels(){
        //crear las etiquetas (JLabel) y se aguega al panel1
        JLabel etiqueta1 = new JLabel("¡Bienvenido al Juego!");
        etiqueta1.setFont(new Font("serif", Font.PLAIN, 45));
        
        
        //etiqueta1.setOpaque(true); //para cambiar color de fondo y pemita
        //etiquetetiqueta1.setOpaque(true); //para cambiar color de fondo y pemitaa1.setBackground(Color.magenta);//color fondo
        etiqueta1.setBounds(600, 10, 400, 45);//tamaño
        panelPrincipal.add(etiqueta1);
        
        JLabel etiqueta2 = new JLabel("Ingresa tu nombre: ");
        etiqueta2.setFont(new Font("serif", Font.PLAIN, 25));
        etiqueta2.setOpaque(true);
        etiqueta2.setBackground(java.awt.Color.cyan);
        etiqueta2.setBounds(660, 400, 200, 45);
        panelPrincipal.add(etiqueta2);
        
        /* mostrarNombre = new JLabel("aqui se mostrara");
        mostrarNombre.setBounds(650, 500, 250, 35);
        mostrarNombre.setFont(new Font("arial",1,20));
        mostrarNombre.setOpaque(true);
        mostrarNombre.setBackground(Color.magenta);
        panelPrincipal.add(mostrarNombre);*/
        
        //imagen coin el logo
        ImageIcon imagenLogo = new ImageIcon("imagenesTecnicas/logoPokemon.png");
        JLabel fondoLogo = new JLabel();
        fondoLogo.setBounds(555,40,500,350);
        fondoLogo.setIcon(new ImageIcon(imagenLogo.getImage().getScaledInstance(fondoLogo.getWidth(), fondoLogo.getHeight(), Image.SCALE_SMOOTH)));
        panelPrincipal.add(fondoLogo);
        
        //generar Imagen de fondo del panel inicial
        ImageIcon imagen = new ImageIcon("imagenesTecnicas/fondoPrincipal.jpg");
        JLabel imagenFondoPrincipal = new JLabel();
        imagenFondoPrincipal.setBounds(0, 0, 1545, 800);
        imagenFondoPrincipal.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(imagenFondoPrincipal.getWidth(), imagenFondoPrincipal.getHeight(), Image.SCALE_SMOOTH)));
        panelPrincipal.add(imagenFondoPrincipal);
    }
    
    private void colocarTextFields(){
        //mostrar el nombre usando el boton1
        capturarNombre = new JTextField();
        capturarNombre.setBounds(660, 450, 200, 30);
        panelPrincipal.add(capturarNombre);
    }
    
    private void colocarBotones(){
         //boton para guardar nommbre agregandole imagen
        boton1 = new JButton();
        boton1.setBounds(650, 550, 250, 135);
        ImageIcon botonStart = new ImageIcon("imagenesTecnicas/botonStart.png");
        boton1.setIcon(new ImageIcon(botonStart.getImage().getScaledInstance(boton1.getWidth(), boton1.getHeight(), Image.SCALE_SMOOTH))); //la imagen tendra el mismo tamaño del boton
        panelPrincipal.add(boton1);
        //crear un objeto accion
        ActionListener activarBoton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                String nombreJugador;
                nombreJugador = capturarNombre.getText();
                //llamar un nuevo frame con el juego iniciado
                VentanaJuego ventanaJuego = new VentanaJuego(nombreJugador);
                ventanaJuego.setVisible(true);    
            }    
        };
        boton1.addActionListener(activarBoton);//metodo que añade un oyente de accion al apretar el boton
    }
}