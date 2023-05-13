
package org.example;
import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormularioThrow {

    private JFrame frame;
    private JTextField nombresTf;
    private JTextField apellidosTf;
    private JTextField empresaTf;
    private JTextField cargoTf;
    private JTextField nombreDeUsuarioTf;
    private JPasswordField passwordPf;
    private JPasswordField passwordConfirmarPf;
    private JTextField correoTf;
    private JComboBox ambitoEmpresaCB;
    private FileWriter archivo;
    String ambitosEmpresariales[] = {"Educación", "Pikmin 4", "Zumaya", "Tears of the kingdom"};


    //crearArchivo(archivo);
    String nombres ;
    String apellidos;
    String cargo ;
    String empresa ;
    String nombreDeUsuario;
    String password ;
    String passwordConf ;
    String correo ;
    String ambito;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormularioThrow window = new FormularioThrow();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private FormularioThrow() {
        frame = new JFrame();
        frame.setBounds(100, 100, 900, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelSuperior = new JPanel();
            frame.getContentPane().add(panelSuperior, BorderLayout.NORTH);
            panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));
            JLabel headerLbl = new JLabel("\nSlSTEMA DE SEGUIMIENTO A \nGRADUADOS DEL lAEN", JLabel.CENTER);
                headerLbl.setFont(new Font("Arial", Font.ITALIC, 24));
                headerLbl.setPreferredSize(new Dimension(616,70));

            JLabel subHeaderLbl = new JLabel("FORMULARIO DE INSCRIPCIÓN AL SISTEMA");
            subHeaderLbl.setFont(new Font("Arial", Font.BOLD, 24));
            subHeaderLbl.setForeground(Color.blue);

            JLabel subSubHeaderLbl = new JLabel("       Todos los campos son obligatorios");
                subSubHeaderLbl.setFont(new Font("Arial", Font.BOLD, 12));
                subSubHeaderLbl.setForeground(Color.red);

                headerLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
            subHeaderLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
            subSubHeaderLbl.setAlignmentX(Component.LEFT_ALIGNMENT);
            panelSuperior.add(headerLbl);
            panelSuperior.add(subHeaderLbl);
            panelSuperior.add(subSubHeaderLbl);

        JPanel panelFormulario = new JPanel();
        frame.getContentPane().add(panelFormulario, BorderLayout.CENTER);
        panelFormulario.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 18, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0; // Permitir expansión horizontal
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        panelFormulario.add(new JLabel("   Nombres"), gbc);

        gbc.gridy = 1;
        panelFormulario.add(new JLabel("   Apellidos"), gbc);

        gbc.gridy = 2;
        panelFormulario.add(new JLabel("   Empresa"), gbc);

        gbc.gridy = 3;
        panelFormulario.add(new JLabel("   Ámbito de la empresa"), gbc);

        gbc.gridy = 4;
        panelFormulario.add(new JLabel("   Cargo"), gbc);

        gbc.gridy = 5;
        panelFormulario.add(new JLabel("   Nombre de usuario"), gbc);

        gbc.gridy = 6;
        panelFormulario.add(new JLabel("   Contraseña"), gbc);

        gbc.gridy = 7;
        panelFormulario.add(new JLabel("   Confirmar contraseña"), gbc);

        gbc.gridy = 8;
        panelFormulario.add(new JLabel("   Correo"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        nombresTf = new JTextField();
        panelFormulario.add(nombresTf, gbc);

        gbc.gridy = 1;
        apellidosTf = new JTextField(20);
        panelFormulario.add(apellidosTf, gbc);

        gbc.gridy = 2;
        empresaTf = new JTextField(20);
        panelFormulario.add(empresaTf, gbc);

        gbc.gridy = 3;
        ambitoEmpresaCB = new JComboBox(ambitosEmpresariales);
        panelFormulario.add(ambitoEmpresaCB, gbc);

        gbc.gridy = 4;
        cargoTf = new JTextField(20);
        panelFormulario.add(cargoTf, gbc);

        gbc.gridy = 5;
        nombreDeUsuarioTf = new JTextField(20);
        panelFormulario.add(nombreDeUsuarioTf, gbc);

        gbc.gridy = 6;
        passwordPf = new JPasswordField(20);
        panelFormulario.add(passwordPf, gbc);

        gbc.gridy = 7;
        passwordConfirmarPf = new JPasswordField(20);
        panelFormulario.add(passwordConfirmarPf, gbc);

        gbc.gridy = 8;
        correoTf = new JTextField(20);
        panelFormulario.add(correoTf,gbc);

        // Añade los demás campos de texto aquí

        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        panelFormulario.add(new JLabel("El nombre de usuario es con el que se identificará en el sistema"), gbc);

        gbc.gridy = 7;
        panelFormulario.add(new JLabel("Para la contraseña, procure utilizar combinaciones alfanuméricas"), gbc);

        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.Y_AXIS));
        frame.getContentPane().add(panelInferior, BorderLayout.SOUTH);

        JCheckBox terminosCondicionesCB = new JCheckBox("He leído y acepto los términos del sistema");
        terminosCondicionesCB.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelInferior.add(terminosCondicionesCB);

        JButton enviarFormularioBtn = new JButton("Enviar formulario");
        enviarFormularioBtn.setAlignmentX(Component.CENTER_ALIGNMENT); // para que se centre aunque el boxlayout este hecho para verticalidadGOD
        panelInferior.add(enviarFormularioBtn);
        enviarFormularioBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (terminosCondicionesCB.isSelected()){
                    nombres = nombresTf.getText();
                    apellidos = apellidosTf.getText();
                    empresa = empresaTf.getText();
                    cargo = cargoTf.getText();
                    nombreDeUsuario = nombreDeUsuarioTf.getText();
                    password = new String(passwordPf.getPassword());
                    passwordConf = new String(passwordConfirmarPf.getPassword());
                    correo = correoTf.getText();
                    ambito = (String) ambitoEmpresaCB.getSelectedItem();
                    if (password.equals(passwordConf)){
                        try {
                            rellenarArchivo();
                        } catch (InvalidStringException ex) {
                            ex.printStackTrace();
                            throw new RuntimeException();
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No coinciden las contras", "c", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else{
                    System.out.println("accepte los terminos y condiciones");
                }
            }
        });
    }

    public void rellenarArchivo() throws InvalidStringException {
        if (comprobarFormulario(nombres,apellidos,empresa,cargo,nombreDeUsuario,password,passwordConf,correo)){
            escribirArchivo(archivo,nombres);
            escribirArchivo(archivo,apellidos);
            escribirArchivo(archivo,ambito);
            escribirArchivo(archivo,empresa);
            escribirArchivo(archivo,cargo);
            escribirArchivo(archivo,nombreDeUsuario);
            escribirArchivo(archivo,password);
            escribirArchivo(archivo,passwordConf);
            escribirArchivo(archivo,correo);
        }
    }

    public void escribirArchivo(FileWriter archivo, String contenido){
        try {
            archivo = new FileWriter("src/archivoSistema.txt", true);
            BufferedWriter escritor = new BufferedWriter(archivo);
            escritor.write(contenido);
            escritor.newLine();
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean contieneLetrasEspacios(String cadena) throws InvalidStringException {
        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
        Matcher matcher = patron.matcher(cadena);
        boolean contieneSoloLetrasYEspacios = matcher.matches();
        if (contieneSoloLetrasYEspacios) {
            System.out.println("todo good");
            return true;
            } else {
            throw new InvalidStringException("La cadena contiene caracteres inválidos o numeros.");
        }
    }


    public boolean contieneLetrasEspaciosNumeros(String cadena) throws InvalidStringException {
        Pattern patron = Pattern.compile("^[a-zA-Z0-9 ]+$");
        Matcher matcher = patron.matcher(cadena);
        boolean contieneSoloLetrasYEspacios = matcher.matches();
        if (contieneSoloLetrasYEspacios) {
            return true;
        } else {
            throw new InvalidStringException("La cadena contiene caracteres inválidos.");
        }
    }
    public boolean contieneLetrasEspaciosNumerosCaracteresSinEspacios(String cadena) throws InvalidStringException {
        Pattern patron = Pattern.compile("^[a-zA-Z0-9!@#$%]+$");
        Matcher matcher = patron.matcher(cadena);
        boolean contieneSoloLetrasYEspacios = matcher.matches();
        if (contieneSoloLetrasYEspacios) {
            return true;
        } else {
            throw new InvalidStringException("La cadena contiene espacios.");
        }
    }
    public boolean comprobarCorreo(String cadena) throws InvalidStringException {
        String correosBaneados[] = {"fakemail.com", "000000pay.com", "zzz.com", "zxo.us", " "};
        for (int i = 0; i<correosBaneados.length; i++){
            if (cadena.contains(correosBaneados[i])){
                throw new InvalidStringException("La cadena contiene correos baneados o espacios.");
            }
        }
        return true;
    }

    public boolean comprobarFormulario(String nombres, String apellidos,String empresa ,String cargo, String nombreDeUsuario, String passwoord, String passwordConf, String correo) throws InvalidStringException {
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
            return false;
        }
    }
    class InvalidStringException extends Exception {
        public InvalidStringException(String message) {
            super(message);
        }
    }

}
