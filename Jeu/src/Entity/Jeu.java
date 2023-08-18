package Entity;
import java.util.Random;
import java.util.Scanner;

public class Jeu {
    private String[] mots;
    private Random random;

    public Jeu() {
        this.mots = new String[]{"Maison", "Etablissement", "Anticorps","Togo","Banalisation"};
        this.random = new Random();
    }
    public String motAleatoire() {
        int indexMot = random.nextInt(mots.length);
        return mots[indexMot];
    }

    public String initialiserMotAffiche(String mot) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < mot.length(); i++) {
            if (i == 0 || i == 3) {
                sb.append(mot.charAt(i)); // Ajout des deux premières lettres du mot
            } else {
                sb.append("_"); // Ajout d'une barre pour les autres lettres
            }
        }

        return sb.toString();
    }
    public boolean verifierCaractere(String mot, char caractere) {
        return mot.indexOf(caractere) != -1; // Vérifie si le caractère est présent dans le mot
    }
    public String mettreAJourMotAffiche(String mot, String motAffiche, char caractere) {
        StringBuilder sb = new StringBuilder(motAffiche);

        for (int i = 0; i < mot.length(); i++) {
            if (mot.charAt(i) == caractere) {
                sb.setCharAt(i, caractere);
            }
        }

        return sb.toString();
    }
    public char obtenirLettreSupplementaire(String mot, String motAffiche) {
        for (int i = 0; i < mot.length(); i++) {
            if (motAffiche.charAt(i) == '_') {
                return mot.charAt(i);
            }
        }

        return ' ';
    }
}
