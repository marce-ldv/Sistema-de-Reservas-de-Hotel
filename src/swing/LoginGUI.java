package swing;

import domain.Usuario;
import jdk.nashorn.internal.scripts.JO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginGUI extends JFrame implements ActionListener{

    private JPanel jPanel;
    private JTextField textFieldUsername;
    private JPasswordField passwordField;
    private JButton btnSalir;
    private JButton btnLoguearse;
    private JLabel jlabelUsuario;
    private JLabel jlabelPassword;
    private JLabel jlabelFondo;
    private String nombreUsuario,contrasena;
    Component confirmacion;

    /**
     * Constructor que llama al constructor por defecto de la clase padre JFrame
     * llamada a los metodos configurar ventana e inicializar componentes.
     */
    public LoginGUI() {
        super();                    // usamos el contructor de la clase padre JFrame
        configurarVentana();        // configuramos la ventana
        inicializarComponentes();   // inicializamos los atributos o componentes
        this.textFieldUsername.setFocusable(true);
    }

    /**
     * Este metodo se encarga de configurar la ventana principal
     * @param
     */
    private void configurarVentana() {
        this.setTitle("Login");                   // colocamos titulo a la ventana
        this.setSize(800, 600);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
    }

    /**
     * Este metodo se encarga de inicializar los componentes
     * es decir crear paneles, instanciar JLabels, crear botones, etc
     * @param
     */
    private void inicializarComponentes() {
        // creamos los componentes
        setIconImage(getIconImage());
        jPanel = new JPanel();
        jPanel.setBounds(0,0,800,600);
        jPanel.setLayout(null);

        textFieldUsername = new javax.swing.JTextField();
        textFieldUsername.setBounds(300,330,170,30);
        //textFieldUsername.setText("Ingrese su usuario: ");

        passwordField = new javax.swing.JPasswordField();
        passwordField.setBounds(300,390,170,30);

        btnSalir = new javax.swing.JButton();
        btnSalir.setBounds(20,20,70,25);
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                btnSalirActionPerformed(evt);
            }
        });

        btnLoguearse = new javax.swing.JButton();
        btnLoguearse.setBounds(300,450,170,40);
        btnLoguearse.setText("Iniciar Sesion");
        btnLoguearse.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                btnLoguearseActionPerformed(evt);
            }
        });

        jlabelUsuario = new javax.swing.JLabel("Usuario: ");
        jlabelUsuario.setBounds(300,300,170,30);

        jlabelPassword = new javax.swing.JLabel("Contrasena: ");
        jlabelPassword.setBounds(300,360,170,30);

        jlabelFondo = new javax.swing.JLabel();
        jlabelFondo.setForeground(new java.awt.Color(255, 255, 255));
        //jlabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("resources/blueE.jpg")));
        jlabelFondo.setMaximumSize(new java.awt.Dimension(800, 600));
        jlabelFondo.setMinimumSize(new java.awt.Dimension(800, 600));

        jPanel.add(jlabelFondo);
        jPanel.add(textFieldUsername);
        jPanel.add(passwordField);
        jPanel.add(btnSalir);
        jPanel.add(btnLoguearse);
        jPanel.add(jlabelUsuario);
        jPanel.add(jlabelPassword);
        this.add(jPanel);
    }

    /**
     * Este metodo se encarga de devolver un objeto de tipo Image
     * Lo utilizamos para setear un icono a la ventana del jframe actual
     * @param
     */
    @Override
    public Image getIconImage() {
        Image miImagen;
        miImagen = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("resources/userIcon.png"));

        return miImagen; //devuelve una imagen
    }

    public Image getImageBackground() {
        Image miImagen;
        miImagen = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("resources/blueE.jpg"));

        return miImagen; //devuelve una imagen
    }

    /**
     * Este metodo es un metodo abstracto que esta sobreescrito de la implementacion de la
     * interfaz ActionListener
     * @param
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre = textFieldUsername.getText();                                 // obtenemos el contenido de la caja de texto
        JOptionPane.showMessageDialog(this, "probando actionPErformed");    // mostramos un mensaje (frame, mensaje)
    }

    /**
     * En este metodo se ejecutara al presionar el boton btnSalir
     * @param
     */
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt){
        JOptionPane.showMessageDialog(null,"Has salido");
        dispose();
    }

    /**
     * En este metodo se ejecutara al presionar el boton btnSalir
     * @param
     */
    private void btnLoguearseActionPerformed(java.awt.event.ActionEvent evt){
        Usuario us = new Usuario();

        /*
         *
         *   Antes se hacia uso del metodo getText en el JPasswordField debido a que supuestamente aveces da errores
         *  Por ese motivo ahora es un metodo descontinuado que no deberia usarse (aunque funciona xD)
         *  Solo lo pongo como ejemplo:
         *
         *  String contrasenia =passwordField.getText()};
         *
         *   La manera correcta de obtener los valores de un JPasswordField es la siguiente:
         * */
        char []caracteresContrasenia=passwordField.getPassword();//el metodo getPassword es el nuevo metodo que sustituye a getText en los JPaswordField y retorna un arreglo de caracteres por eso creo uno primero  y  despues hago la asignacion
        String contrasenia="";//declaro una variable llamada contrasenia para guardar en ella el arreglo de caracteres
        for (int i=0;i<caracteresContrasenia.length;i++) //Hago un for para recorrer el arreglo
        {
            contrasenia+=caracteresContrasenia[i];//uno todas las letras de cada posicion del arreglo para solo obtener una variable string con la contraseña
        }
        /*
         * Ahora podemos usar esa variable contrasenia para enviarla como parametro en el metodo
         * */

        if(us.loguearse(textFieldUsername.getText(),contrasenia)){
            JOptionPane.showMessageDialog(null,"Te has logeado como administrador");
            AdministradorGUI adminGUI = new AdministradorGUI();
            adminGUI.setVisible(true);
            //this.dispose(); //cierro la ventana actual
        }else{
            JOptionPane.showMessageDialog(null,"No has podido iniciar sesion");
        }
    }

    /**
     * Main method, utiliza la interfaz Runnable para que podamos ejecutar
     * varios hilos a la vez y el programa no tenga que esperar el fin de la ejecucion de cada hilo
     * En el metodo run se le da una visibilidad de true
     * @param args
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }

}
