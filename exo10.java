
import java.util.Scanner;

public class exo10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Création du tableau 
        int taille = 5;
        int[] tableau = new int[taille];
        
        // Saisie des éléments
        System.out.println("Entrez les " + taille + " éléments du tableau:");
        for (int i = 0; i < taille; i++) {
            System.out.print("Élément " + (i+1) + ": ");
            tableau[i] = scanner.nextInt();
        }
        
        // Affichage 
        System.out.print("Tableau original: ");
        for (int elem: tableau) {
            System.out.print(elem + " ");
        }
        System.out.println();
        
        // Inversion en place
        for (int i = 0; i < taille / 2; i++) {
            int temp = tableau[i];
            tableau[i] = tableau[taille - 1 - i];
            tableau[taille - 1 - i] = temp;
        }
        
        // Affichage inversé
        System.out.print("Tableau inversé: ");
        for (int elem: tableau) {
            System.out.print(elem + " ");
        }
        System.out.println();
        
        scanner.close();
    }
}
