import javax.swing.*;  // Pour les composants graphiques (JFrame, JButton, JTextField, etc.)
import java.awt.*;     // Pour la gestion de la disposition (layout)
import java.awt.event.*; // Pour gérer l'action du bouton

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
