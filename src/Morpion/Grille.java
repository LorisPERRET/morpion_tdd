package Morpion;

import java.util.function.BooleanSupplier;
import java.util.stream.IntStream;

import javax.naming.directory.InvalidAttributesException;

public class Grille {
	private int taille;
	public int[][] grille;

	public Grille(int i) throws InvalidAttributesException {
		if(i == -1) throw new InvalidAttributesException();
		if(i == 2) throw new InvalidAttributesException();
		if(i == Integer.MAX_VALUE) throw new InvalidAttributesException();
		if(i == 11) throw new InvalidAttributesException();
		if(i > 10) throw new InvalidAttributesException();
		if(i < 3) throw new InvalidAttributesException();
		taille = i;
		grille = new int[taille][taille];
	}

	public Grille() {
		taille = 3;
		grille = new int[taille][taille];
	}
	
	public void initGrille() {
		for(int k = 0; k<taille-1; k++) {
			for(int l = 0; l<taille-1; l++) {
				grille[k][l] = 0;
			}
		}
	}

	public Object getSize() {
		if(taille == 3)return "3-3";
		if(taille == 10)return "10-10";
		return taille + "-" + taille;
	}

	public Boolean setPosition(int i, int j, int joueur) throws InvalidAttributesException {
		if(i == 11 && j == 11) throw new InvalidAttributesException();
		if(i == -1 && j == -1) throw new InvalidAttributesException();
		if(i >= 11 && j >= 11) throw new InvalidAttributesException();
		if(i >= taille && j >= taille) throw new InvalidAttributesException();
		if(grille[i][j] != 0) return false;
		if(i == 0 && j == 0 && grille[0][0] == 0) grille[0][0] = joueur;
		
		if(grille[i][j] == 0) grille[i][j] = joueur;
		return true;
	}

	public Integer isLine() {
		if(grille[0][0] == 1 && grille[0][1] == 1 && grille[0][2] == 1 && taille == 3) return 1;
		if(grille[0][0] == 2 && grille[0][1] == 2 && grille[0][2] == 2 && taille == 3) return 2;
		if(grille[1][0] == 1 && grille[1][1] == 1 && grille[1][2] == 1 && taille == 3)return 1;
		if(grille[1][0] == 2 && grille[1][1] == 2 && grille[1][2] == 2 && taille == 3)return 2;
		if(grille[2][0] == 1 && grille[2][1] == 1 && grille[2][2] == 1 && taille == 3)return 1;
		if(grille[2][0] == 2 && grille[2][1] == 2 && grille[2][2] == 2 && taille == 3)return 2;
		
		
		for(int i = 0; i<taille; i++) {
			int last = grille[i][0];
			int cpt = 0;
			if(last == 0) {
				continue;
			} else {
				cpt++;
			}
			
			for(int j = 1; j<taille; j++) {
				if(grille[i][j] == last) cpt++;
				else continue;
			}
			if(cpt == taille) return last;
		}
		
		return null;
	}

	public Integer isColonne() {
		if(grille[0][0] == 1 && grille[1][0] == 1 && grille[2][0] == 1 && taille == 3)return 1;
		if(grille[0][0] == 2 && grille[1][0] == 2 && grille[2][0] == 2 && taille == 3)return 2;
		if(grille[0][1] == 1 && grille[1][1] == 1 && grille[2][1] == 1 && taille == 3)return 1;
		if(grille[0][1] == 2 && grille[1][1] == 2 && grille[2][1] == 2 && taille == 3)return 2;
		if(grille[0][2] == 1 && grille[1][2] == 1 && grille[2][2] == 1 && taille == 3)return 1;
		if(grille[0][2] == 2 && grille[1][2] == 2 && grille[2][2] == 2 && taille == 3)return 2;
		
		for(int j = 0; j<taille; j++) {
			int last = grille[0][j];
			int cpt = 0;
			if(last == 0) {
				continue;
			} else {
				cpt++;
			}
			
			for(int i = 1; i<taille; i++) {
				if(grille[i][j] == last) cpt++;
				else continue;
			}
			if(cpt == taille) return last;
		}
		
		return null;
	}

	public Integer isDiag() {
		if(grille[0][0] == 1 && grille[1][1] == 1 && grille[2][2] == 1 && taille == 3)return 1;
		if(grille[0][0] == 2 && grille[1][1] == 2 && grille[2][2] == 2 && taille == 3)return 2;
		if(grille[0][2] == 1 && grille[1][1] == 1 && grille[2][0] == 1 && taille == 3)return 1;
		if(grille[0][2] == 2 && grille[1][1] == 2 && grille[2][0] == 2 && taille == 3)return 2;
		
		int last = grille[0][0];
		int cpt = 0;
		if(last != 0) {
			cpt++;
		}
		for(int i = 1; i<taille; i++) {
			if(grille[i][i] == last) {
				cpt++;
				last = grille[i][i];
			}
			else {
				cpt = 0;
				break;
			}
		}

		if(cpt == taille) return last;
		
		last = grille[0][taille-1];
		cpt = 0;
		if(last != 0) {
			cpt++;
		}
		for(int i = 1; i<taille; i++) {
			if(grille[i][taille-1-i] == last) {
				cpt++;
				last = grille[i][taille-1-i];
			}
			else {
				cpt = 0;
				break;
			}
		}
		
		if(cpt == taille) return last;
		
		return null;
	}

	public Boolean isFull() {
		for(int i = 0; i<taille; i++) {
			for(int j = 0; j<taille; j++) {
				if(grille[i][j] == 0) return false;
			}
		}
		return true;
	}
}
