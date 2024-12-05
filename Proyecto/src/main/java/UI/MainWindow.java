package UI;




import javax.swing.*;
import java.awt.*;


public class MainWindow  extends JFrame {


    PanelIzquierdo miPanelIzquierdo;
    PanelDerechoSuperior miPanelDerecho;
    PanelDerechoInferior miPanelDerechoInferior;



    public MainWindow() {


        miPanelIzquierdo = new PanelIzquierdo();
        miPanelDerecho = new PanelDerechoSuperior();
        miPanelDerechoInferior = new PanelDerechoInferior();


        this.add(miPanelIzquierdo);
        this.add(miPanelDerecho);
        this.add(miPanelDerechoInferior);

        setLayout(new BorderLayout());
        add(miPanelIzquierdo, BorderLayout.WEST);
        add(miPanelDerecho, BorderLayout.EAST);
        add(miPanelDerechoInferior, BorderLayout.CENTER);



        this.setSize(600, 600);
        this.setTitle("Gestor de colecciones de música");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);





    }
}