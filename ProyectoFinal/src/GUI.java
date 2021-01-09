import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
    private JButton boton;
    private JPanel panel;


    static class pruebaAccion implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JFrame frame2 = new JFrame();
            frame2.setVisible(true);
        }
    }
    GUI (){
        this.panel = new JPanel();
        this.setContentPane(panel);
        this.boton= new JButton("Continuar");
        this.panel.add(boton);
        boton.addActionListener(new pruebaAccion());
        this.setTitle("JFrame Titulo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(420,420);
        setVisible(true);
}

}
