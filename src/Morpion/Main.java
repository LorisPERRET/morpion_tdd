package Morpion;

import java.util.Scanner;

import javax.naming.directory.InvalidAttributesException;

public class Main {
	public static void main(String[] args) {
		System.out.println("Partie de morpion !!");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Type de grille :\n1: Par defaut (3-3)\n2: Personnalisée");
		int choix = scanner.nextInt();
		Grille grille = new Grille();
		int taille = 3;
		if(choix == 2) {
			System.out.println("Definissez la taille de la grille : ");
			int input = scanner.nextInt();
			
			try {
				grille = new Grille(input);
				taille = input;
			} catch (InvalidAttributesException e) {
				System.err.println("La taille doit etre comprise entre 3 et 10 !!");
			}
		}
		if(choix != 1 && choix != 2) System.err.println("choix invalid !!");
		
		System.out.println("La taille de la grille est " + grille.getSize());
		
		System.out.println("Début de la partie");
		grille.initGrille();
		
		int joueur = 1;
		while(grille.isLine() == null && grille.isColonne() == null && grille.isDiag() == null && !grille.isFull()) {
			
			// Affichage
			for(int i = 0; i<taille; i++) {
				for(int j = 0; j<taille; j++) {
					System.out.print("|" + grille.grille[i][j]);
				}
				System.out.println("|");
			}
			
			System.out.println("C'est au tour du joueur " + joueur);
			System.out.println("Choisissez un ligne en 0 et " + (taille-1));
			int ligne = scanner.nextInt();
			System.out.println("Choisissez un colonne en 0 et " + (taille-1));
			int colonne = scanner.nextInt();
			try {
				if(!grille.setPosition(ligne, colonne, joueur)) {
					System.err.println("La case n'est pas disponible !!");
				}
			} catch (InvalidAttributesException e) {
				System.err.println("Les coordonnées sont erronées !!");
			}
			
			joueur = joueur == 1 ? 2 : 1;
		}
		
		// Affichage
		for(int i = 0; i<taille; i++) {
			for(int j = 0; j<taille; j++) {
				System.out.print("|" + grille.grille[i][j]);
			}
			System.out.println("|");
		}

		System.out.println("La partie est terminée");
		if(grille.isFull()) System.out.println("Il y a égalité");
		else System.out.println("Le gagnant est le joueur " + joueur);
		System.out.println("Merci <3");
	}
}
