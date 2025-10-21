public class Voiture {
    String couleur;
    String modele;
    int annee;

    // constructeur par défaut
    public Voiture() {
        this.couleur = "Inconnue"; 
        this.modele = "Inconnu";
        this.annee = 0;
    }

    // constructeur complet
    public Voiture(String c, String m, int a) {
        couleur = c;
        modele = m;
        annee = a;
    }

    public void demarrer() {
        System.out.println("La voiture démarre !");
    }

    public void afficherInfos() {
        System.out.println("Modèle : " + modele + ", Couleur : " + couleur + ", Année : " + annee);
    }
}
