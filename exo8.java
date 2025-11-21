import java.util.Scanner;

public class exo8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Saisie des 5 notes
        double[] notes = new double[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Entrez la note " + (i+1) + ": ");
            notes[i] = scanner.nextDouble();
        }
        
        // Calcul de la moyenne
        double somme = 0;
        for (double note: notes) {
            somme += note;
        }
        double moyenne = somme / 5;
        System.out.println("La moyenne est: " + moyenne);
        
        // Attribution de la mention
        String mention;
        if (moyenne < 10) {
            mention = "Insuffisant";
        } else if (moyenne >= 10 && moyenne < 12) {
            mention = "Passable";
        } else if (moyenne >= 12 && moyenne < 14) {
            mention = "Assez Bien";
        } else if (moyenne >= 14 && moyenne < 16) {
            mention = "Bien";
        } else {
            mention = "Très Bien";
        }
        
        System.out.println("Mention: " + mention);
        
        scanner.close();
    }
}

