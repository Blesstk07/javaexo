import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculatrice {
    public static void main(String[] args) {
        // ---- FENÊTRE PRINCIPALE ----
        JFrame frame = new JFrame("Calculatrice avancée");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // centre à l'écran
        frame.setLayout(new BorderLayout(10, 10));

        // ---- ÉCRAN D’AFFICHAGE ----
        JTextField ecran = new JTextField();
        ecran.setEditable(false);
        ecran.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        ecran.setHorizontalAlignment(JTextField.RIGHT);
        ecran.setBackground(Color.BLACK);
        ecran.setForeground(Color.GREEN);
        ecran.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(ecran, BorderLayout.NORTH);

        // ---- PANNEAU DE BOUTONS ----
        JPanel panneauBoutons = new JPanel();
        panneauBoutons.setLayout(new GridLayout(5, 4, 10, 10));

        String[] boutons = {
            "7", "8", "9", "÷",
            "4", "5", "6", "×",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "√", "%", "±"
        };

        // ---- VARIABLES POUR LES CALCULS ----
        final double[] premierNombre = {0};
        final String[] operation = {""};
        final boolean[] nouvelleOperation = {true};

        // ---- CRÉATION DES BOUTONS ----
        for (String texte : boutons) {
            JButton btn = new JButton(texte);
            btn.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
            btn.setFocusPainted(false);

            // Couleurs selon le type
            if (texte.matches("[0-9.]")) {
                btn.setBackground(Color.DARK_GRAY);
                btn.setForeground(Color.WHITE);
            } else if (texte.equals("C") || texte.equals("√") || texte.equals("%") || texte.equals("±")) {
                btn.setBackground(Color.ORANGE);
                btn.setForeground(Color.WHITE);
            } else {
                btn.setBackground(Color.LIGHT_GRAY);
                btn.setForeground(Color.BLACK);
            }

            // Effet au survol
            btn.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    btn.setBackground(btn.getBackground().darker());
                }
                public void mouseExited(MouseEvent evt) {
                    // Revenir à la couleur d'origine
                    if (texte.matches("[0-9.]")) btn.setBackground(Color.DARK_GRAY);
                    else if (texte.equals("C") || texte.equals("√") || texte.equals("%") || texte.equals("±")) btn.setBackground(Color.ORANGE);
                    else btn.setBackground(Color.LIGHT_GRAY);
                }
            });

            // ---- ACTIONS DES BOUTONS ----
            btn.addActionListener(e -> {
                String valeur = ((JButton)e.getSource()).getText();

                // Chiffres et point
                if (valeur.matches("[0-9.]")) {
                    if (nouvelleOperation[0]) {
                        ecran.setText("");
                        nouvelleOperation[0] = false;
                    }
                    ecran.setText(ecran.getText() + valeur);
                }

                // Opérations + - × ÷
                else if (valeur.matches("[÷×\\-+]")) {
                    premierNombre[0] = Double.parseDouble(ecran.getText());
                    operation[0] = valeur;
                    nouvelleOperation[0] = true;
                }

                // Égal
                else if (valeur.equals("=")) {
                    double second = Double.parseDouble(ecran.getText());
                    double resultat = 0;
                    switch (operation[0]) {
                        case "+": resultat = premierNombre[0] + second; break;
                        case "-": resultat = premierNombre[0] - second; break;
                        case "×": resultat = premierNombre[0] * second; break;
                        case "÷": resultat = second != 0 ? premierNombre[0] / second : 0; break;
                    }
                    ecran.setText(String.valueOf(resultat));
                    nouvelleOperation[0] = true;
                }

                // Effacer
                else if (valeur.equals("C")) {
                    ecran.setText("");
                    premierNombre[0] = 0;
                    operation[0] = "";
                }

                // Racine carrée
                else if (valeur.equals("√")) {
                    double num = Double.parseDouble(ecran.getText());
                    ecran.setText(String.valueOf(Math.sqrt(num)));
                    nouvelleOperation[0] = true;
                }

                // Pourcentage
                else if (valeur.equals("%")) {
                    double num = Double.parseDouble(ecran.getText());
                    ecran.setText(String.valueOf(num / 100));
                    nouvelleOperation[0] = true;
                }

                // Changer le signe ±
                else if (valeur.equals("±")) {
                    double num = Double.parseDouble(ecran.getText());
                    ecran.setText(String.valueOf(-num));
                }
            });

            panneauBoutons.add(btn);
        }

        frame.add(panneauBoutons, BorderLayout.CENTER);

        // ---- AFFICHAGE ----
        frame.setVisible(true);
    }
}
