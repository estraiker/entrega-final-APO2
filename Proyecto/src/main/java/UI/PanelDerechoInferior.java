package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PanelDerechoInferior extends Panel implements ActionListener {

    JLabel Canciones, tituloLabel;
    JTextField tituloField;
    JButton Agregar;
    JPanel Derechoinferior;



    public PanelDerechoInferior() {
        setLayout(new BorderLayout());

        Derechoinferior = new JPanel();
        Derechoinferior.setLayout(new BoxLayout(Derechoinferior, BoxLayout.Y_AXIS));



        tituloLabel = new JLabel("Titulo");
        tituloField = new JTextField();

        Canciones = new JLabel("Canciones");

        this.add(Canciones);

        Agregar = new JButton("Agregar");
        Agregar.addActionListener(this);

        this.add(Agregar);

        Derechoinferior.add(Canciones);
        Derechoinferior.add(Box.createRigidArea(new Dimension(10, 10)));
        Derechoinferior.add(tituloLabel);
        Derechoinferior.add(tituloField);
        Derechoinferior.add(Box.createRigidArea(new Dimension(10, 10)));
        Derechoinferior.add(Agregar);

        this.add(Derechoinferior);





    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //obtener etiqueta dle elemento que disparo el evento:
        String command = e.getActionCommand();

        switch (command) {

            case "Agregar":
                guardartitulo();
                break;
        }

    }

    public void guardartitulo() {
        String titulo = tituloField.getText();

        if (titulo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese el titulo de la cancion");
        }

        String rutatitulo = "src/main/resources/titulo cancion.txt";

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutatitulo))) {
            escritor.write("cancion: " + titulo);
            JOptionPane.showMessageDialog(this, "titulo guardado correctamente");


        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el titulo");
        }
    }

    }
