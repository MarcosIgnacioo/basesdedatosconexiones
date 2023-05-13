package org.example;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class SistemaFormulario {

    private JFrame frame;
    private JTextField nombresTf;
    private JTextField apellidosTf;
    private JTextField empresaTF;
    private JTextField cargoTf;
    private JTextField nombreDeUsuarioTf;
    private JPasswordField passwordPf;
    private JPasswordField passwordConfirmarPf;
    private JTextField correoTf;
    private FileWriter archivo;


    //crearArchivo(archivo);
    String nombres ;
    String apellidos;
    String cargo ;
    String empresa ;
    String nombreDeUsuario;
    String password ;
    String passwordConf ;
    String correo ;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SistemaFormulario window = new SistemaFormulario();
                    window.frame.setVisible(true);
                    window.frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public SistemaFormulario() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panelSuperior = new JPanel();
        panel.add(panelSuperior, BorderLayout.NORTH);

        JLabel lblNewLabel_9 = new JLabel("New label");
        lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
        panelSuperior.add(lblNewLabel_9);

        JLabel lblNewLabel_10 = new JLabel("New label");
        panelSuperior.add(lblNewLabel_10);

        JLabel lblNewLabel_11 = new JLabel("SISTEMA DE SEGUIMIENTO A GRADUADOS DEL IAEN");
        panelSuperior.add(lblNewLabel_11);

        JPanel panelInferior = new JPanel();
        panel.add(panelInferior, BorderLayout.SOUTH);

        JLabel lblNewLabel_12 = new JLabel("New label");
        panelInferior.add(lblNewLabel_12);

        JLabel lblNewLabel_13 = new JLabel("Formulario de inscripción al sistema");
        panelInferior.add(lblNewLabel_13);

        JPanel panelCentral = new JPanel();
        frame.getContentPane().add(panelCentral, BorderLayout.CENTER);
        panelCentral.setLayout(new BorderLayout(0, 0));

        JPanel panel_4 = new JPanel();
        panelCentral.add(panel_4, BorderLayout.SOUTH);
        panel_4.setLayout(new GridLayout(2, 1, 0, 0));

        JCheckBox checkBoxTerminos = new JCheckBox("He leído y acepto los términos del sistema");
        checkBoxTerminos.setHorizontalAlignment(SwingConstants.CENTER);
        panel_4.add(checkBoxTerminos);


        JPanel panelFormularioParteUno = new JPanel();
        panelCentral.add(panelFormularioParteUno, BorderLayout.CENTER);
        panelFormularioParteUno.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        JPanel panelFormularioParteDos = new JPanel();
        panelFormularioParteUno.add(panelFormularioParteDos);
        panelFormularioParteDos.setLayout(new GridLayout(4, 2, 0, 0));

        gbc.gridy = 0;
        gbc.gridx = 0;

        JLabel nombreLbl = new JLabel("Nombres", JLabel.CENTER);
        panelFormularioParteUno.add(nombreLbl,gbc);

        gbc.gridy = 0;
        gbc.gridx = 1;
        nombresTf = new JTextField();
        panelFormularioParteUno.add(nombresTf,gbc);
        nombresTf.setPreferredSize(new Dimension(100,20));
        nombresTf.setMaximumSize(new Dimension(50,20));
        nombresTf.setMinimumSize(new Dimension(50,20));
        nombresTf.setColumns(10);


        gbc.gridy = 1;
        gbc.gridx = 0;

        JLabel apellidosLbl = new JLabel("Apellidos", JLabel.CENTER);
        panelFormularioParteUno.add(apellidosLbl,gbc);

        gbc.gridy = 1;
        gbc.gridx = 1;

        apellidosTf = new JTextField();
        apellidosTf.setPreferredSize(new Dimension(100,100));
        panelFormularioParteUno.add(apellidosTf,gbc);
        apellidosTf.setColumns(10);


        gbc.gridy = 2;
        gbc.gridx = 0;

        JLabel empresaLbl = new JLabel("Empresa/Institución", JLabel.CENTER);
        panelFormularioParteUno.add(empresaLbl,gbc);

        gbc.gridy = 2;
        gbc.gridx = 1;

        empresaTF = new JTextField();
        panelFormularioParteUno.add(empresaTF,gbc);
        empresaTF.setColumns(10);

        gbc.gridy = 3;
        gbc.gridx = 0;

        JLabel ambitoEmpresaLbl = new JLabel("Ámbito de la empresa", JLabel.CENTER);
        panelFormularioParteUno.add(ambitoEmpresaLbl, gbc);

        gbc.gridy = 3;
        gbc.gridx = 1;

        JComboBox comboBox = new JComboBox();
        panelFormularioParteUno.add(comboBox,gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;

        JLabel cacrgoLbl = new JLabel("Cargo", JLabel.CENTER);
        panelFormularioParteUno.add(cacrgoLbl,gbc);

        gbc.gridy = 4;
        gbc.gridx = 1;

        cargoTf = new JTextField();
        panelFormularioParteUno.add(cargoTf,gbc);
        cargoTf.setColumns(10);


        JLabel nombreDeUsuarioLbl = new JLabel("Nombre de usuario", JLabel.CENTER);
        panelFormularioParteDos.add(nombreDeUsuarioLbl);

        nombreDeUsuarioTf = new JTextField();
        panelFormularioParteDos.add(nombreDeUsuarioTf);
        nombreDeUsuarioTf.setColumns(10);

        JLabel passwordLbl = new JLabel("Contraseña", JLabel.CENTER);
        panelFormularioParteDos.add(passwordLbl);

        passwordPf = new JPasswordField();
        panelFormularioParteDos.add(passwordPf);

        JLabel passwordConfLbl = new JLabel("Confirmar contraseña", JLabel.CENTER);
        panelFormularioParteDos.add(passwordConfLbl);

        passwordConfirmarPf = new JPasswordField();
        panelFormularioParteDos.add(passwordConfirmarPf);

        JLabel correoLbl = new JLabel("Correo", JLabel.CENTER);
        panelFormularioParteDos.add(correoLbl);

        correoTf = new JTextField();
        panelFormularioParteDos.add(correoTf);
        correoTf.setColumns(10);
        System.out.println(
                correoTf.getSize());

        JPanel panelFormularioParteTres = new JPanel();
        panelFormularioParteUno.add(panelFormularioParteTres);
        panelFormularioParteTres.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel avisoNombreUsuarioLbl = new JLabel("El nombre de usuario es con el que se identificara en el sistema", JLabel.CENTER);
        panelFormularioParteTres.add(avisoNombreUsuarioLbl);

        JLabel avisoPasswordLbl = new JLabel("Para la contraseña procure utilizar combinaciones alfanuméricas", JLabel.CENTER);
        panelFormularioParteTres.add(avisoPasswordLbl);


        JButton enviarFormularioBtn = new JButton("Enviar formulario");
        panel_4.add(enviarFormularioBtn);
        enviarFormularioBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //crearArchivo(archivo);
                if (checkBoxTerminos.isSelected()){
                    nombres = nombresTf.getText();
                    apellidos = apellidosTf.getText();
                    empresa = empresaTF.getText();
                    cargo = cargoTf.getText();
                    nombreDeUsuario = nombreDeUsuarioTf.getText();
                    password = new String(passwordPf.getPassword());
                    passwordConf = new String(passwordConfirmarPf.getPassword());
                    correo = correoTf.getText();
                    if (password.equals(passwordConf)){
                        rellenarArchivo();
                    }
                    else{
                        System.out.println("las contraseñas no coinciden");
                    }
                }
                else{
                    System.out.println("accepte los terminos y condiciones");
                }
                /*escribirArchivo(archivo,nombresTf.getText());
                escribirArchivo(archivo,apellidosTf.getText());
                escribirArchivo(archivo,empresaTF.getText());
                escribirArchivo(archivo,nombreDeUsuarioTf.getText());
                escribirArchivo(archivo,new String(passwordPf.getPassword()));
                escribirArchivo(archivo,new String(passwordConfirmarPf.getPassword()));
                escribirArchivo(archivo,correoTf.getText());*/
            }
        });
    }
    public void rellenarArchivo(){
        if (comprobarFormulario(nombres,apellidos,empresa,cargo,nombreDeUsuario,password,passwordConf,correo)){
            escribirArchivo(archivo,nombres);
            escribirArchivo(archivo,apellidos);
            escribirArchivo(archivo,empresa);
            escribirArchivo(archivo,cargo);
            escribirArchivo(archivo,nombreDeUsuario);
            escribirArchivo(archivo,password);
            escribirArchivo(archivo,passwordConf);
            escribirArchivo(archivo,correo);
        }
        else{

        }
    }

    public void escribirArchivo(FileWriter archivo, String contenido){
        try {
            archivo = new FileWriter("archivoSistema.txt", true);
            BufferedWriter escritor = new BufferedWriter(archivo);
            escritor.write(contenido);
            escritor.newLine();
            escritor.close();
            System.out.println("Archivo creado exitosamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el archivo.");
            e.printStackTrace();
        }
    }
    public boolean contieneNumeros(String cadena){
        for (int i = 0; i<10; i++){
            if (cadena.contains(String.valueOf(i))){
                return true;
            }
        }
        return false;
    }

    public boolean contieneLetrasEspacios(String cadena){
            Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
            Matcher matcher = patron.matcher(cadena);
            boolean contieneSoloLetrasYEspacios = matcher.matches();
            if (contieneSoloLetrasYEspacios) {
                return true;
            } else {
                return false;
            }
    }

    public boolean contieneLetrasEspaciosNumeros(String cadena){
        Pattern patron = Pattern.compile("^[a-zA-Z0-9 ]+$");
        Matcher matcher = patron.matcher(cadena);
        boolean contieneSoloLetrasYEspacios = matcher.matches();
        if (contieneSoloLetrasYEspacios) {
            return true;
        } else {
            return false;
        }
    }
    public boolean contieneLetrasEspaciosNumerosCaracteresSinEspacios(String cadena){
        Pattern patron = Pattern.compile("^[a-zA-Z0-9!@#$%]+$");
        Matcher matcher = patron.matcher(cadena);
        boolean contieneSoloLetrasYEspacios = matcher.matches();
        if (contieneSoloLetrasYEspacios) {
            return true;
        } else {
            return false;
        }
    }
    public boolean comprobarCorreo(String cadena){
        String correosBaneados[] = {"fakemail.com", "000000pay.com", "zzz.com", "zxo.us", " "};
        for (int i = 0; i<correosBaneados.length; i++){
            if (cadena.contains(correosBaneados[i])){
                System.out.println("owowowo");
                return false;
            }
        }
        return true;
    }
    public boolean comprobarFormulario(String nombres, String apellidos,String empresa ,String cargo, String nombreDeUsuario, String passwoord, String passwordConf, String correo){
        /*
                    *
            Nombres ( solo permitir letras y espacios )
            Apellidos ( solo permitir letras y espacios )
            Empresa. ( permitir letras, números y espacios solamente )
            Ámbito de la empresa  ( lista de elementos precargamos en el input )
            Cargo       ( solo permitir letras y espacios )
            Nombre de usuario    ( permitir letras, números y espacios solamente )
            Contraseña.  ( letras, números y carácter especial, no espacios )
            Repetir contraseña.  ( letras, números y carácter especial, no espacios )
            Correo electrónico   ( validar que no acepte fakemail.com, 000000pay.com, zzz.com, zxo.us, tampoco espacios )
        * */
        boolean comprobacionNombre = contieneLetrasEspacios(nombres);
        boolean comprobacionApellidos = contieneLetrasEspacios(apellidos);
        boolean comprobacionEmpresa = contieneLetrasEspaciosNumeros(empresa);
        boolean comprobacionCargo = contieneLetrasEspacios(cargo);
        boolean comprobacionNombreUsuario =contieneLetrasEspaciosNumeros(nombreDeUsuario) ;
        boolean comprobacionPassword = contieneLetrasEspaciosNumerosCaracteresSinEspacios(passwoord);
        boolean comprobacionPasswordConf = contieneLetrasEspaciosNumerosCaracteresSinEspacios(passwordConf) ;
        boolean comprobacionCorreo = comprobarCorreo(correo);

        if (comprobacionNombre && comprobacionApellidos && comprobacionEmpresa && comprobacionCargo && comprobacionNombreUsuario
            && comprobacionPassword && comprobacionPasswordConf && comprobacionCorreo){
                return true;
        }
        else{
            if (comprobacionNombre == false){
                System.out.println("El nombre esta mal escrito");
            }
            if (comprobacionApellidos == false){
                System.out.println("El apellido esta mal escrito");
            }
            if (comprobacionEmpresa == false){
                System.out.println("El empresa esta mal escrito");
            }
            if (comprobacionCargo == false){
                System.out.println("El cargo esta mal escrito");
            }
            if (comprobacionNombreUsuario == false){
                System.out.println("El nombre de usuario esta mal escrito");
            }
            if (comprobacionPassword == false){
                System.out.println("La contraseña esta mal escrita");
            }
            if (comprobacionPasswordConf == false){
                System.out.println("La comprobacion de la contraseña esta mal escrita");
            }
            if (comprobacionCorreo == false){
                System.out.println("El correo esta mal escrito");
            }
            return false;
        }
    }
}

