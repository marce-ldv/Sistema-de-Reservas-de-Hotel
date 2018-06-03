package swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginGUI extends JFrame implements ActionListener{

    private JTextField textFieldUsername;
    private JPasswordField passwordField;
    private JButton btnSalir;
    private JButton btnLoguearse;
    private JLabel jlabelUsuario;
    private JLabel jlabelPassword;

    public LoginGUI() {
        super();                    // usamos el contructor de la clase padre JFrame
        configurarVentana();        // configuramos la ventana
        inicializarComponentes();   // inicializamos los atributos o componentes
    }

    private void configurarVentana() {
        this.setTitle("Login");                   // colocamos titulo a la ventana
        this.setSize(800, 600);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
    }

    private void inicializarComponentes() {
        // creamos los componentes
        setIconImage(getIconImage());
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

        jlabelUsuario = new javax.swing.JLabel("Usuario: ");
        jlabelUsuario.setBounds(300,300,170,30);

        jlabelPassword = new javax.swing.JLabel("Contrasena: ");
        jlabelPassword.setBounds(300,360,170,30);

        this.add(textFieldUsername);
        this.add(passwordField);
        this.add(btnSalir);
        this.add(btnLoguearse);
        this.add(jlabelUsuario);
        this.add(jlabelPassword);
    }

    @Override
    public Image getIconImage() {
        Image retValue;
        retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("resources/userIcon.png"));

        return retValue; //devuelve una imagen
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre = textFieldUsername.getText();                                 // obtenemos el contenido de la caja de texto
        JOptionPane.showMessageDialog(this, "probando actionPErformed");    // mostramos un mensaje (frame, mensaje)
    }

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt){
        dispose();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }

}
