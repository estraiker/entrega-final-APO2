package UI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public  class PanelDerechoSuperior extends JPanel implements ActionListener {

    JButton botonGuardar;
    JLabel NombreLabel, Artistas, paisLabel;
    JPanel Derechosuperior;
    JTextField NombreField, paisField;


    public PanelDerechoSuperior() {
        setLayout(new BorderLayout());

        //Derechosuperior = new JPanel(new GridLayout(2, 2, 10, 10));
        Derechosuperior = new JPanel();
        Derechosuperior.setLayout(new BoxLayout(Derechosuperior, BoxLayout.Y_AXIS));


        NombreLabel = new JLabel("Nombre");
        NombreField = new JTextField();
        NombreField.setPreferredSize(new Dimension(200, 10));

        paisLabel = new JLabel("Pais");
        paisField = new JTextField();




        Artistas = new JLabel("Artistas");

        this.add(Artistas);



        botonGuardar = new JButton("Guardar");
        botonGuardar.addActionListener(this);
        botonGuardar.setActionCommand("GUARDAR");

        this.add(botonGuardar);

        Derechosuperior.add(Artistas);
        Derechosuperior.add(Box.createRigidArea(new Dimension(10, 10)));
        Derechosuperior.add(NombreLabel);
        Derechosuperior.add(NombreField);
        Derechosuperior.add(Box.createRigidArea(new Dimension(10, 10)));
        Derechosuperior.add(paisLabel);
        Derechosuperior.add(paisField);
        Derechosuperior.add(Box.createRigidArea(new Dimension(10, 10)));
        Derechosuperior.add(botonGuardar);

        this.add(Derechosuperior);





    }
    @Override
    public void actionPerformed(ActionEvent e) {

        //obtener etiqueta dle elemento que disparo el evento:
        String command = e.getActionCommand();

        switch (command) {

            case "GUARDAR":
                guardarArtista();
                break;

        }

    }
    public void guardarArtista() {
        String nombre = NombreField.getText();
        String pais = paisField.getText();

        if (nombre.isEmpty() || pais.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese el nombre del artista");
        }

        String rutaArtista = "src/main/resources/artista.txt";

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArtista))) {
            escritor.write(": " + nombre);
            escritor.write("  pais: " + pais);
            JOptionPane.showMessageDialog(this, "Artista guardado correctamente");


        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el Artista");
        }


    }






}
