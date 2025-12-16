import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FacturationGUI extends JFrame {

    private JTextField txtNomClient, txtTelephone, txtNomArticle, txtQuantite, txtPrix;
    private DefaultTableModel model;

    public FacturationGUI() {
        setTitle("Facturation Supermarché");
        setSize(750, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ===== PANEL CLIENT =====
        JPanel panelClient = new JPanel(new GridLayout(2, 2, 10, 10));
        panelClient.setBorder(BorderFactory.createTitledBorder("Informations du Client"));

        txtNomClient = new JTextField();
        txtTelephone = new JTextField();

        panelClient.add(new JLabel("Nom du client :"));
        panelClient.add(txtNomClient);
        panelClient.add(new JLabel("Téléphone :"));
        panelClient.add(txtTelephone);

        // ===== PANEL ARTICLES =====
        JPanel panelArticle = new JPanel(new GridLayout(4, 2, 10, 10));
        panelArticle.setBorder(BorderFactory.createTitledBorder("Ajouter un Article"));

        txtNomArticle = new JTextField();
        txtQuantite = new JTextField();
        txtPrix = new JTextField();

        panelArticle.add(new JLabel("Nom de l'article :"));
        panelArticle.add(txtNomArticle);
        panelArticle.add(new JLabel("Quantité :"));
        panelArticle.add(txtQuantite);
        panelArticle.add(new JLabel("Prix unitaire ($) :"));
        panelArticle.add(txtPrix);

        JButton btnAjouter = new JButton("Ajouter l'article");
        btnAjouter.addActionListener(this::ajouterArticle);

        panelArticle.add(new JLabel());
        panelArticle.add(btnAjouter);

        // ===== TABLEAU =====
        model = new DefaultTableModel(new String[]{"Article", "Quantité", "Prix", "Total"}, 0);
        JTable table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);

        // ===== BOUTON FACTURE =====
        JButton btnFacture = new JButton("Afficher la Facture");
        btnFacture.addActionListener(this::afficherFacture);

        // ===== AJOUT DANS LA FENÊTRE =====
        add(panelClient, BorderLayout.NORTH);
        add(panelArticle, BorderLayout.WEST);
        add(scroll, BorderLayout.CENTER);
        add(btnFacture, BorderLayout.SOUTH);

        setVisible(true);
    }

    // ===== MÉTHODE : Ajouter un article au tableau =====
    private void ajouterArticle(ActionEvent e) {
        try {
            String nom = txtNomArticle.getText();
            int qte = Integer.parseInt(txtQuantite.getText());
            double prix = Double.parseDouble(txtPrix.getText());
            double total = qte * prix;

            model.addRow(new Object[]{nom, qte, prix, total});

            // Reset champs
            txtNomArticle.setText("");
            txtQuantite.setText("");
            txtPrix.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer des valeurs valides !");
        }
    }

    // ===== MÉTHODE : Générer et afficher la facture =====
    private void afficherFacture(ActionEvent e) {

        StringBuilder facture = new StringBuilder();

        String client = txtNomClient.getText();
        String telephone = txtTelephone.getText();

        facture.append("===== FACTURE SUPERMARCHÉ =====\n");
        facture.append("Client : ").append(client).append("\n");
        facture.append("Téléphone : ").append(telephone).append("\n\n");
        facture.append(String.format("%-15s %-10s %-10s %-10s\n",
                "Article", "Quantité", "Prix", "Total"));

        double totalHT = 0;

        for (int i = 0; i < model.getRowCount(); i++) {
            String nom = model.getValueAt(i, 0).toString();
            int qte = Integer.parseInt(model.getValueAt(i, 1).toString());
            double prix = Double.parseDouble(model.getValueAt(i, 2).toString());
            double total = Double.parseDouble(model.getValueAt(i, 3).toString());

            facture.append(String.format("%-15s %-10d %-10.2f %-10.2f\n",
                    nom, qte, prix, total));

            totalHT += total;
        }

        double remise = (totalHT >= 100) ? totalHT * 0.30 : 0;
        double tva = (totalHT - remise) * 0.16;
        double net = (totalHT - remise) + tva;

        facture.append("\nTotal HT : ").append(String.format("%.2f $", totalHT));
        facture.append("\nRemise : ").append(String.format("%.2f $", remise));
        facture.append("\nTVA (16%) : ").append(String.format("%.2f $", tva));
        facture.append("\nNET À PAYER : ").append(String.format("%.2f $", net));

        // Affichage dans une boîte
        JTextArea area = new JTextArea(facture.toString());
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);

        JOptionPane.showMessageDialog(this, scroll, "Facture Finalisée", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new FacturationGUI();
    }
}
