import java.util.Scanner;
public class exercice1 {
    public static Object nextInt;

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Bienvenue dans notre calculatrice");
            int valeur;
            do{ System.out.println("Saisir un nombre entier :");
             valeur = scan.nextInt();
             if (valeur <1) {
                System.out.println("Taper un nombre supérieur à 1");
             } else if (valeur %2==1) {
                System.out.println("Taper un nombre divisible par 2");
             }
            }while(valeur < 0 || valeur % 2 !=0);
            
            System.out.println("\nTable de multiplication par " + valeur);
            System.out.println("------------------------------------------");
        //System.out.println(valeur);
        for (int i=0;i<=10;i++){  
            int resultat=valeur*i;
            System.out.println(valeur + "x" +i+ "=" + resultat);
        }   System.out.println("------------------------------------------");
        } catch (Exception e) {
            System.out.println("Tu as commis une erreur au moment de la saisie de ton nombre, recommence!");
        }

    }
}
