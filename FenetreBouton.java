import javax.swing.*;
import java.awt.event.*; // pour les événements

public class FenetreBouton {
    public static void main(String[] args) {
        JFrame fenetre = new JFrame("Fenêtre interactive");
        fenetre.setSize(400, 300);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton bouton = new JButton("Clique-moi !");
        fenetre.add(bouton);

        // Ajouter l'action au clic
        bouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(fenetre, "Bravo ! Tu as été piraté !");
            }
        });

        fenetre.setVisible(true);
    }
}
