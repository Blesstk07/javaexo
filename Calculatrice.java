import javax.swing.*;

public class Calculatrice {
    public static void main(String[] args) {
        // Création de la fenêtre principale
        JFrame frame = new JFrame("Calculatrice avancée");

        // Définir la taille
        frame.setSize(400, 500);

        // Fermer le programme quand on clique sur la croix
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Centrer la fenêtre à l'écran
        frame.setLocationRelativeTo(null);

        // ---- ÉCRAN D’AFFICHAGE ----
        JTextField ecran = new JTextField();
        ecran.setEditable(false);           // L'utilisateur ne peut pas taper dedans
        ecran.setFont(new Font("Comic Sans MS", Font.BOLD, 30));  // Taille du texte
        ecran.setHorizontalAlignment(JTextField.RIGHT);   // Texte aligné à droite

        // On ajoute l’écran en haut de la fenêtre
        frame.add(ecran, BorderLayout.NORTH);

        // Rendre la fenêtre visible
        frame.setVisible(true);
    }
}
