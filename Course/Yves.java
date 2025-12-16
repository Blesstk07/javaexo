

import java.util.Scanner;

public class Yves {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // --- Informations du client ---
        System.out.print("Entrez le nom du client : ");
        String nomClient = sc.nextLine();

        System.out.print("Entrez le numéro de téléphone du client : ");
        String telephone = sc.nextLine();

        System.out.print("Entrez le nombre d'articles achetés : ");
        int nombreArticles = sc.nextInt();
        sc.nextLine(); // consomme le saut de ligne restant

        // Tableaux pour stocker les informations des articles
        String[] nomsArticles = new String[nombreArticles];
        int[] quantites = new int[nombreArticles];
        double[] prixUnitaires = new double[nombreArticles];

        // --- Saisie des articles ---
        for (int i = 0; i < nombreArticles; i++) {
            System.out.println("\nArticle " + (i + 1) + " :");

            System.out.print("Nom de l'article : ");
            nomsArticles[i] = sc.nextLine();

            System.out.print("Quantité : ");
            quantites[i] = sc.nextInt();
            sc.nextLine(); // consomme le saut de ligne restant

            System.out.print("Prix unitaire : ");
            prixUnitaires[i] = sc.nextDouble();
            sc.nextLine(); // consomme le saut de ligne restant
        }

        // --- Calcul du total hors taxe ---
        double totalHT = 0;
        for (int i = 0; i < nombreArticles; i++) {
            totalHT += quantites[i] * prixUnitaires[i];
        }

        // --- Calcul de la remise ---
        double remise = 0;
        if (totalHT >= 100) {
            remise = totalHT * 0.05; // 5%
        }

        // --- Calcul de la TVA (16%) ---
        double tva = (totalHT - remise) * 0.16;

        // --- Calcul du net à payer ---
        double netAPayer = (totalHT - remise) + tva;

        // --- Affichage du résumé ---
        System.out.println("\n===== FACTURE =====");
        System.out.println("Client : " + nomClient);
        System.out.println("Téléphone : " + telephone);

        System.out.println("\nArticles achetés :");
        System.out.printf("%-20s %-10s %-12s %-10s%n", "Nom", "Quantité", "Prix Unitaire", "Total");

        for (int i = 0; i < nombreArticles; i++) {
            double totalArticle = quantites[i] * prixUnitaires[i];
            System.out.printf("%-20s %-10d %-12.2f %-10.2f%n",
                    nomsArticles[i], quantites[i], prixUnitaires[i], totalArticle);
        }

        System.out.printf("%nTotal Hors Taxe : %.2f $%n", totalHT);
        System.out.printf("Remise : %.2f $%n", remise);
        System.out.printf("TVA (16%%) : %.2f $%n", tva);
        System.out.printf("Net à payer : %.2f $%n", netAPayer);

        sc.close();
    }
}