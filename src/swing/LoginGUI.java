package swing;

import domain.Usuario;
import exepciones.CampoVacioException;
import exepciones.InicioSesionException;
import exepciones.InvalidUsernameAndPasswordException;
import exepciones.InvalidUsernameException;
import jdk.nashorn.internal.scripts.JO;
import org.json.JSONException;

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
    private JButton btnRegistrarse;
    private JLabel jlabelUsuario;
    private JLabel jlabelPassword;
    private JLabel jlabelRegistrarse;
    private String nombreUsuario,contrasena;
    private JComboBox jcomboLogin;
    private JLabel jlabelComboLogin;
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
        this.setSize(350, 550);                                 // colocamos tamanio a la ventana (ancho, alto)
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
        jPanel.setBounds(0,0,350,550);
        jPanel.setLayout(null);

        textFieldUsername = new javax.swing.JTextField();
        textFieldUsername.setBounds(90,265,170,30);

        passwordField = new javax.swing.JPasswordField();
        passwordField.setBounds(90,320,170,30);

        btnSalir = new javax.swing.JButton();
        btnSalir.setBounds(10,20,70,25);
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                btnSalirActionPerformed(evt);
            }
        });

        btnLoguearse = new javax.swing.JButton();
        btnLoguearse.setBounds(90,380,170,40);
        btnLoguearse.setText("Iniciar Sesion");
        btnLoguearse.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                btnLoguearseActionPerformed(evt);
            }
        });

        btnRegistrarse = new javax.swing.JButton();
        btnRegistrarse.setBounds(90,450,170,40);
        btnRegistrarse.setText("Registrarse");

        btnRegistrarse.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                btnRegistrarseActionPerformed(evt);
            }
        });


        jlabelUsuario = new javax.swing.JLabel("Ingrese su Usuario: ");
        jlabelUsuario.setBounds(90,240,170,30);

        jlabelPassword = new javax.swing.JLabel("Ingrese su Contrasena: ");
        jlabelPassword.setBounds(90,295,170,30);

        jlabelRegistrarse =new javax.swing.JLabel("No tienes una cuenta? Click aqui");
        jlabelRegistrarse.setBounds(90,425,170,30);

        jcomboLogin = new JComboBox();
        jcomboLogin.setBounds(90,130,170,30);
        jcomboLogin.addItem("Administrador");
        jcomboLogin.addItem("Empleado");
        jcomboLogin.addItem("Conserje");

        jlabelComboLogin = new javax.swing.JLabel("Loguearse como: ");
        jlabelComboLogin.setBounds(90,100,170,30);

        jPanel.add(jlabelComboLogin);
        jPanel.add(jcomboLogin);
        jPanel.add(jlabelRegistrarse);
        jPanel.add(btnRegistrarse);
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
     *  Antes se hacia uso del metodo getText en el JPasswordField debido a que supuestamente aveces da errores
     *  Por ese motivo ahora es un metodo descontinuado que no deberia usarse (aunque funciona xD)
     *  Ejemplo:
     *
     *  String contrasenia =passwordField.getText()};
     *
     *   La manera correcta de obtener los valores de un JPasswordField es la siguiente:
     * @param evt
     */
    private void btnLoguearseActionPerformed(java.awt.event.ActionEvent evt){
        Usuario us = new Usuario();
        int tipoUsuario=0;

        char []caracteresContrasenia=passwordField.getPassword();//el metodo getPassword es el nuevo metodo que sustituye a getText en los JPaswordField y retorna un arreglo de caracteres por eso creo uno primero  y  despues hago la asignacion
        String contrasenia="";//declaro una variable llamada contrasenia para guardar en ella el arreglo de caracteres
        for (int i=0;i<caracteresContrasenia.length;i++) //Hago un for para recorrer el arreglo
        {
            contrasenia+=caracteresContrasenia[i];//uno todas las letras de cada posicion del arreglo para solo obtener una variable string con la contraseña
        }

        //Me fijo que tipo de usuario fue seleccionado en el jcombobox para leer mi fichero json

        int varSelected = jcomboLogin.getSelectedIndex();
        if(varSelected == 0){
            JOptionPane.showMessageDialog(null,"Administrador");
            tipoUsuario=0;
        }else if(varSelected == 1){
            JOptionPane.showMessageDialog(null,"Empleado");
            tipoUsuario=1;
        }else if(varSelected == 2){
            JOptionPane.showMessageDialog(null,"Conserje");
            tipoUsuario=2;
        }

        //Cargo a mi usuario con datos para efectuar el login
        try{
            us.leerDatosUsuario(tipoUsuario);
        } catch(JSONException e){
            e.printStackTrace();
        }

        //Ahora podemos usar esa variable contrasenia para enviarla como parametro en el metodo

            try {
                us.loguearse(textFieldUsername.getText(),contrasenia);
                JOptionPane.showMessageDialog(null,"Te has logeado como administrador");
                AdministradorGUI adminGUI = new AdministradorGUI();
                adminGUI.setVisible(true);
                this.dispose(); //cierro la ventana actual
            } catch (CampoVacioException e) {
                JOptionPane.showMessageDialog(null,"Debe completar todos los campos");
            } catch (InvalidUsernameException e) {
                JOptionPane.showMessageDialog(null,"Usuario incorrecto");
            } catch (InvalidUsernameAndPasswordException e) {
                JOptionPane.showMessageDialog(null,"Usuario o contrasenia incorrectos");
            }catch (InicioSesionException ex){
                JOptionPane.showMessageDialog(null,"No has podido iniciar sesion"+ex.informa());
            }

        }

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt){
        RegistrarPasajeroGUI registroGUI = new RegistrarPasajeroGUI();
        registroGUI.setVisible(true);
        this.dispose();
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
