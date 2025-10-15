import javax.swing.*;  // Pour les composants graphiques (JFrame, JButton, JTextField, etc.)
import java.awt.*;     // Pour la gestion de la disposition (layout)
import java.awt.event.*; // Pour gérer l'action du bouton

/* --- Classe de calcul (logique) --- */
class Renumeration {
    private int nombreHeures;
    private String grade;
    private int tauxHoraire;

    public int determinertaux() {
        if (grade.equalsIgnoreCase("A")) {
            tauxHoraire = 5;
        } else if (grade.equalsIgnoreCase("CT")) {
            tauxHoraire = 7;
        } else if (grade.equalsIgnoreCase("PA")) {
            tauxHoraire = 10;
        } else if (grade.equalsIgnoreCase("PF")) {
            tauxHoraire = 12;
        } else if (grade.equalsIgnoreCase("PO")) {
            tauxHoraire = 15;
        } else if (grade.equalsIgnoreCase("PE")) {
            tauxHoraire = 17;
        } else {
            tauxHoraire = 0;
        }
        return tauxHoraire;
    }

    public int calculerRem() {
        return nombreHeures * tauxHoraire;
    }

    public Renumeration(int nH, String gr) {
        nombreHeures = nH;
        grade = gr;
        tauxHoraire = determinertaux();
    }
}

/* --- Interface Graphique --- */
public class TestRenumeration extends JFrame {

    private JTextField txtHeures;
    private JComboBox<String> comboGrade;
    private JLabel lblResultat;

    public TestRenumeration() {
        setTitle("Calcul de Rémunération");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centre la fenêtre
        setLayout(new GridLayout(4, 2, 5, 5)); // 4 lignes, 2 colonnes

        add(new JLabel("Nombre d'heures :"));
        txtHeures = new JTextField();
        add(txtHeures);

        add(new JLabel("Grade :"));
        comboGrade = new JComboBox<>(new String[]{"A", "CT", "PA", "PF", "PO", "PE"});
        add(comboGrade);

        JButton btnCalculer = new JButton("Calculer");
        add(btnCalculer);

        // Centrer la fenêtre à l'écran
        setLocationRelativeTo(null);

        lblResultat = new JLabel("Résultat : ");
        add(lblResultat);

        btnCalculer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int heures = Integer.parseInt(txtHeures.getText());
                String grade = comboGrade.getSelectedItem().toString();
                Renumeration r = new Renumeration(heures, grade);
                lblResultat.setText("Résultat : " + r.calculerRem());
            }
        });
    }

    public static void main(String[] args) {
        new TestRenumeration().setVisible(true);
    }
}
