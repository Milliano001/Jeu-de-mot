import Entity.Jeu;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Jeu j=new Jeu();
        Scanner s=new Scanner(System.in);
        boolean continuer=true;
        while (continuer) {
            String motChoisi = j.motAleatoire();
            String motAffiche = j.initialiserMotAffiche(motChoisi);
            System.out.println("Voici le mot à deviner : " + motAffiche);
            int essaie = 0;

            while (!motAffiche.equals(motChoisi) && essaie < 3) {
                System.out.print("Entrez un caractère : ");
                char saisie = s.next().charAt(0);

                if (j.verifierCaractere(motChoisi, saisie)) {
                    motAffiche = j.mettreAJourMotAffiche(motChoisi, motAffiche, saisie);
                    System.out.println("Mot trouvé : " + motAffiche);
                } else {
                    essaie++;
                    System.out.println(
                            "Ce caractère n'est pas présent dans le mot à trouver. Il vous reste " + (3 - essaie)
                                    + " essai(s).");
                }
            }
            if (motAffiche.equals(motChoisi)) {
                System.out.println("Waoh !! Vous avez réussi. Félicitations !");
            } else {
                System.out.println("Désolé, vous avez échoué.");
                char lettreSupplementaire = j.obtenirLettreSupplementaire(motChoisi, motAffiche);
                System.out.println("Voici la lettre que vous auriez dû trouver : " + lettreSupplementaire);
                System.out.println("Lettres manquantes : " + j.obtenirLettreSupplementaire(motChoisi, motAffiche));
                System.out.println("Mot complet : " + motChoisi);
            }

            System.out.print("Voulez-vous rejouer ? (Oui/Non) : ");
            String choix = s.next().toLowerCase();
            if (choix.equals("non")) {
                continuer = false;
                System.out.println("Merci d'avoir joué. Au revoir !");
            }
       }
    }
}