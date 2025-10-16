// Structure de base d'un programme Java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        direBonjour(); // on appelle la méthode

        // création d’un objet
        Voiture maVoiture = new Voiture();

        // donner des valeurs aux attributs
        maVoiture.couleur = "Rouge";
        maVoiture.modele = "Toyota";z
        maVoiture.annee = 2025;

        // utiliser les méthodes
        maVoiture.demarrer();
        maVoiture.afficherInfos();
    }

    public static void direBonjour() {
        System.out.println("Bonjour Bless !");
    }
}

// Classe Voiture à l'extérieur de Main
class Voiture {
    String couleur;
    String modele;
    int annee;

    public void demarrer() {
        System.out.println("La voiture démarre !");
    }

    public void afficherInfos() {
        System.out.println("Modèle : " + modele + ", Couleur : " + couleur + ", Année : " + annee);
    }
}