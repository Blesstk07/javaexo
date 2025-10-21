/* créer une classe */
public class renumeration {
   /* attributs prives */
   private int nombreHeures;
   private String grade;
   private int tauxHoraire;

   /* methodes publiques */
   public int determinertaux () {
      if (grade.equalsIgnoreCase("A")) {
         tauxHoraire = 5;
      } else if (grade.equalsIgnoreCase("CT")) {
         tauxHoraire = 7;
      } else if (grade.equalsIgnoreCase("PA")) {
         tauxHoraire = 10;
      } else if (grade.equalsIgnoreCase("PF")) {
         tauxHoraire = 12;
      } else if (grade.equalsIgnoreCase("PO")) {
         tauxHoraire = 15;
      } else if (grade.equalsIgnoreCase("PE")) {
         tauxHoraire = 17;
      } else {
         tauxHoraire = 0; // valeur par défaut si grade inconnu
      }
      return tauxHoraire;
   }

   public int calculerRem(){
      return nombreHeures * tauxHoraire;
   }

   public  renumeration(int nH, String gr) {
      nombreHeures = nH;
      grade = gr;
      tauxHoraire = determinertaux();
   }
}

/* interface graphique (définie dans InterfaceRenumeration.java) */