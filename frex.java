import java.util.Scanner;
import java.util.ArrayList;

public class frex {
    public static void main(String[] args) {
        System.out.println(
            "---------------Bienvenue Chez nous---------------"
            +"\nVeuillez nous donner les informations suivantes:"
        );
        Scanner C = new Scanner(System.in);
        System.out.print("*Votre nom: ");
        String nom_client = C.nextLine();
        System.out.print("*Votre adresse: ");
        String Adresse_client = C.nextLine();
        System.out.print("*Votre numéro de téléphone: ");
        String Numero_client = C.nextLine();
        String  [][]produits = {
            {"Banane", "Ananas", "Orange", "Avocat", "Mangue"},
            {"Porc", "Vache", "Poulet", "Lapin", "Chèvre"},
            {"Matembele", "Pondu", "Haricot", "Mbika", "Ndunda"},
            {"Tilapia", "Chinchard", "Poisson chat", "Mpiodi", "Makayabu"}
        };
        int [][] prix={
            {1200, 1500, 800, 2000, 1000},
            {1500, 1900, 1400, 3000, 2500},
            {890, 2700, 2050, 1000, 1200},
            {600, 1850, 1300, 1900, 3000}
        };
        System.out.println("Voulez vous acheté quelque chose oui/non: ");
        String valider = C.nextLine().trim(); // supprimer les espaces avant et après
        System.out.println(valider);

        if (valider.equalsIgnoreCase("oui")) {
            double total = 0.0;

            ArrayList<String> produitList = new ArrayList<>();
            ArrayList<Integer> nombreList = new ArrayList<>();
            ArrayList<Integer> prixUnitaireList = new ArrayList<>();
            ArrayList<Integer> prixTotalList = new ArrayList<>();

            boolean start = true;
            while (start) {
                System.out.println(
                    "Veuillez choisir vos produits: \n"+
                    "1.Fruits\n"+
                    "2.Viandes\n"+
                    "3.Légumes\n"+
                    "4.Poisson\n"+
                    "Faites votre choix :"
                );
                int choix = C.nextInt();
                C.nextLine(); // consommer le retour à la ligne
                if (choix >= 1 && choix <= 4) {
                    int cat = choix - 1;
                    System.out.println(
                        "1."+produits[cat][0]+" "+ prix[cat][0]+"fc\n"+
                        "2."+produits[cat][1]+" "+ prix[cat][1]+"fc\n"+
                        "3."+produits[cat][2]+" "+ prix[cat][2]+"fc\n"+
                        "4."+produits[cat][3]+" "+ prix[cat][3]+"fc\n"+
                        "5."+produits[cat][4]+" "+ prix[cat][4]+"fc"
                    );
                    System.out.print("Votre choix (1-5): ");
                    int choix2 = C.nextInt();
                    System.out.print("Tu en prends combien: ");
                    int nbr = C.nextInt();
                    C.nextLine(); // consommer le saut de ligne avant nextLine() suivant

                    if (choix2 >= 1 && choix2 <= 5) {
                        int prodIdx = choix2 - 1;
                        String produit_client = produits[cat][prodIdx];
                        int prix_unitaire = prix[cat][prodIdx];
                        int prix_total = prix_unitaire * nbr;
                        double tva = prix_total * 0.16;
                        double prix_ttc = prix_total + tva;

                        produitList.add(produit_client);
                        nombreList.add(nbr);
                        prixUnitaireList.add(prix_unitaire);
                        prixTotalList.add(prix_total);

                        total += prix_ttc;
                    } else {
                        System.out.println("Tu as mal choisi (choix produit).");
                    }
                } else {
                    System.out.println("Tu as mal choisi (catégorie).");
                }

                System.out.println("C'est tout? oui/non : ");
                String option = C.nextLine().trim();
                if (option.equalsIgnoreCase("oui")) {
                    start = false;
                } else {
                    start = true;
                }
            }

            System.out.println(
                "------------------------- Facture -------------------------\n "+
                "Nom client: "+nom_client+" \n"+
                "Adresse: "+Adresse_client+" \n"+
                "Numeros: "+Numero_client+" \n"+
                "-----------------------------------------------------------\n"+
                "--Produits-----nombre-----prix unitaire-----total-----------\n"+
                "-----------------------------------------------------------"
            );
            for (int j = 0; j < produitList.size(); j++) {
                System.out.println(
                    produitList.get(j)+"  :         "+
                    nombreList.get(j)+"          "+
                    prixUnitaireList.get(j)+"               "+
                    prixTotalList.get(j)
                );
            }
            System.out.println("Montant total (TTC approximatif) : " + total + " fc");
        } else if (valider.equalsIgnoreCase("non")) {
            System.out.println("Bon débarras, on aura d'autres clients");
        } else {
            System.out.println("Erreur d'entrée");
        }

        C.close();
    }
}