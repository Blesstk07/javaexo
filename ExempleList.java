import java.util.ArrayList;

public class ExempleList {
    public static void main(String[] args) {

        ArrayList<String> noms = new ArrayList<>(); /*Déclare une variable noms de type ArrayList qui va contenir des objets de type String (chaînes de caractères).
Crée une nouvelle liste vide en mémoire.
Tu pourras ensuite ajouter, modifier, supprimer ou lire des chaînes dans cette liste. */

        // Ajouter des éléments
        noms.add("Alice");
        noms.add("Bob");
        noms.add("Charlie");

        // Accéder à un élément
        System.out.println(noms.get(1)); // Affiche Bob

        // Taille de la liste
        System.out.println(noms.size()); // 3

        // Modifier un élément
        noms.set(1, "Benoit"); // Remplace Bob par Benoit

        // Supprimer un élément
        noms.remove("Alice"); // ou remove(0)

        // Parcourir avec une boucle
        for(String nom : noms) {
            System.out.println(nom);
        }
    }
}
