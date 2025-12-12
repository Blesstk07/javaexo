import java.util.Scanner;

public class tableau1 {
    public static Object nextLine;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nombre_etudiant = 0;
        System.out.println(" Liste de présence");
        System.out.println("--------------------\n");
        System.out.println("Taper le nombre d'étudiants:");
        nombre_etudiant=scan.nextInt();
            if (nombre_etudiant<1) {
                System.out.println("Le nombre est incorrect");
            }
        String [] noms= new String[nombre_etudiant];
        for (int i=0; i< noms.length; i++){
         noms[i]=scan.nextLine();
        }
    }
}
