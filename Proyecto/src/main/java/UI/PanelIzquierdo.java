package UI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class PanelIzquierdo extends JPanel implements ActionListener {

    JButton botonCrear;
    JPanel izquierdo, derecho;
    JTextField listanueva;
    JLabel Playlist;
    JTextArea  lista;

    public PanelIzquierdo() {


        setLayout(new BorderLayout());


        izquierdo = new JPanel();
        izquierdo.setLayout(new BoxLayout(izquierdo, BoxLayout.Y_AXIS));



        botonCrear = new JButton("Crear");
        //le agrego un action listener (una funcion que responde por los eventos) al boton:
        botonCrear.addActionListener(this);
        //establecemos un nombe de comando para el botón
        botonCrear.setActionCommand("CREAR");

        this.add(botonCrear);


        listanueva = new JTextField("Lista nueva");
        listanueva.addActionListener(this);
        listanueva.setActionCommand("LISTANUEVA");

        this.add(listanueva);

        Playlist= new JLabel("Playlist");


        this.add(Playlist);

        lista = new JTextArea("");
        lista.setPreferredSize(new Dimension(200, 10));

        this.add(lista);

        izquierdo.add(Playlist);
        izquierdo.add(Box.createRigidArea(new Dimension(10, 10)));
        izquierdo.add(lista);
        izquierdo.add(Box.createRigidArea(new Dimension(10, 10)));
        izquierdo.add(listanueva);
        izquierdo.add(Box.createRigidArea(new Dimension(10, 10)));
        izquierdo.add(botonCrear);



        add(izquierdo, BorderLayout.WEST);

        this.add(izquierdo);

        derecho = new JPanel(new BorderLayout());

        PanelDerechoSuperior PanelDerechosuperior = new PanelDerechoSuperior();
        PanelDerechoInferior PanelDerechoInferior = new PanelDerechoInferior();


        derecho.add(PanelDerechosuperior, BorderLayout.NORTH);
        derecho.add(PanelDerechoInferior, BorderLayout.SOUTH);



    }



    @Override

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botonCrear) {
            String text = listanueva.getText();
            cargarArchivosYMostrar();
            guardarInfo("src/main/resources/Lista.txt");

            lista.append(text + "\n");

            // Limpiar el JTextField listanueva
            listanueva.setText("");
        }

    }
    public void guardarInfo(String ruta){
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ruta))) {
            escritor.write("playlist: "+listanueva.getText());
            JOptionPane.showMessageDialog(this, "Se ha guardado correctamente");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,"no se pudo guardar la Playlist"+ e.getMessage());

        }
    }
    private void cargarArchivosYMostrar() {
        try {
            // Leer contenido de artista.txt y Lista.txt
            String contenidoCancion = new String(Files.readAllBytes(Paths.get("src/main/resources/titulo cancion.txt")));

            // mostrar el contenido
            String contenidoFinal ="\n"+  contenidoCancion +"\n";

            // muestrar en el JTextArea
            lista.setText(contenidoFinal); // Usar setText para reemplazar el contenido del JTextArea
        } catch (IOException e) {
            // En caso de error, mostrar un mensaje en el JTextArea
            lista.setText("Error al leer los archivos.");

        }
    }





}
