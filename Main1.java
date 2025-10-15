class Voiture {
    String couleur;
    String modele;
    int annee;

    // constructeur
    public Voiture(String c, String m, int a) {
        couleur = c;
        modele = m;
        annee = a;
    }

    public void afficherInfos() {
        System.out.println("Modèle : " + modele + ", Couleur : " + couleur + ", Année : " + annee);
    }
}

public class Main1 {
    public static void main(String[] args) {
        Voiture maVoiture = new Voiture("Bleu", "Honda", 2023);
        maVoiture.afficherInfos();
    }
}