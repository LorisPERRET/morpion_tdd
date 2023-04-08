package Morpion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import javax.naming.directory.InvalidAttributesException;

import org.junit.jupiter.api.Test;

class GrilleTest {

	@Test
	void constructeur() throws InvalidAttributesException {
		assertInstanceOf(Grille.class, new Grille());
		assertInstanceOf(Grille.class, new Grille(3));
		assertThrows(InvalidAttributesException.class,() -> new Grille(-1));
		assertThrows(InvalidAttributesException.class,() -> new Grille(2));
		assertThrows(InvalidAttributesException.class,() -> new Grille(Integer.MAX_VALUE));
		assertThrows(InvalidAttributesException.class,() -> new Grille(11));
		assertThrows(InvalidAttributesException.class,() -> new Grille(-1));
		
		
		Random random = new Random();
		int x = random.nextInt(7 + 1) + 3;
		assertInstanceOf(Grille.class, new Grille(x));		
	}
	
	@Test
	void initGrille() {
		Grille g = new Grille();
		g.initGrille();
		assertEquals(0, g.grille[0][0]);
		assertEquals(0, g.grille[1][1]);
	}
	
	@Test
	void getSize() throws InvalidAttributesException {
		assertEquals("3-3", new Grille().getSize());
		assertEquals("10-10", new Grille(10).getSize());
		
		Random random = new Random();
		int x = random.nextInt(7 + 1) + 3;
		
		String res = x + "-" + x;
		assertEquals(res, new Grille(x).getSize());		
	}
	
	@Test
	void setPosition() throws InvalidAttributesException  {
		Grille g = new Grille();
		g.initGrille();
		g.grille[0][1] = 1;
		assertTrue(g.setPosition(0, 0, 1));
		
		g = new Grille();
		g.initGrille();
		g.grille[0][1] = 1;
		assertFalse(g.setPosition(0, 1, 1));
		
		assertThrows(InvalidAttributesException.class,() -> new Grille().setPosition(11, 11, 1));
		assertThrows(InvalidAttributesException.class,() -> new Grille().setPosition(-1, -1, 1));
		
		Random random = new Random();
		int x = random.nextInt(7 + 1) + 3;
		g = new Grille(x);
		
		int i = random.nextInt(x);
		int j = random.nextInt(x);
		
		g.initGrille();
		g.grille[0][1] = 1;
		
		boolean res = false;
		if(g.grille[i][j] == 0) res = true;

		assertEquals(res, g.setPosition(i, j, 1));
	}
	
	@Test
	void isLine() throws InvalidAttributesException {
		// Ligne 0
		Grille g = new Grille();
		g.initGrille();
		g.grille[0][0] = 1;
		g.grille[0][1] = 1;
		g.grille[0][2] = 1;
		
		assertEquals(1, g.isLine());
		
		g = new Grille();
		g.initGrille();
		g.grille[0][0] = 2;
		g.grille[0][1] = 2;
		g.grille[0][2] = 2;
		
		assertEquals(2, g.isLine());
		
		// Ligne 1
		
		g = new Grille();
		g.initGrille();
		g.grille[1][0] = 1;
		g.grille[1][1] = 1;
		g.grille[1][2] = 1;
		
		assertEquals(1, g.isLine());
		
		g = new Grille();
		g.initGrille();
		g.grille[1][0] = 2;
		g.grille[1][1] = 2;
		g.grille[1][2] = 2;
		
		assertEquals(2, g.isLine());
		
		// Ligne 2
		
		g = new Grille();
		g.initGrille();
		g.grille[2][0] = 1;
		g.grille[2][1] = 1;
		g.grille[2][2] = 1;
		
		assertEquals(1, g.isLine());
		
		g = new Grille();
		g.initGrille();
		g.grille[2][0] = 2;
		g.grille[2][1] = 2;
		g.grille[2][2] = 2;
		
		assertEquals(2, g.isLine());
		
		g = new Grille();
		g.initGrille();
		
		//assertNull(g.isLine());
		
		Random random = new Random();
		int x = random.nextInt(7 + 1) + 3;
		int res = random.nextInt(1 + 1) + 1;
		g = new Grille(x);
		g.initGrille();
		
		for(int i = 0; i<x; i++) {
			g.grille[0][i]=res;
		}
		
		assertEquals(res, g.isLine());
	}
	
	@Test
	void isColonne() throws InvalidAttributesException {
		// Colonne 0 
		
		Grille g = new Grille();
		g.initGrille();
		g.grille[0][0] = 1;
		g.grille[1][0] = 1;
		g.grille[2][0] = 1;
		
		assertEquals(1, g.isColonne());
		
		g = new Grille();
		g.initGrille();
		g.grille[0][0] = 2;
		g.grille[1][0] = 2;
		g.grille[2][0] = 2;
		
		assertEquals(2, g.isColonne());
		
		// Colonne 1 
		
		g = new Grille();
		g.initGrille();
		g.grille[0][1] = 1;
		g.grille[1][1] = 1;
		g.grille[2][1] = 1;
		
		assertEquals(1, g.isColonne());
		
		g = new Grille();
		g.initGrille();
		g.grille[0][1] = 2;
		g.grille[1][1] = 2;
		g.grille[2][1] = 2;
		
		assertEquals(2, g.isColonne());
		
		// Colonne 2
		
		g = new Grille();
		g.initGrille();
		g.grille[0][2] = 1;
		g.grille[1][2] = 1;
		g.grille[2][2] = 1;
		
		assertEquals(1, g.isColonne());
		
		g = new Grille();
		g.initGrille();
		g.grille[0][2] = 2;
		g.grille[1][2] = 2;
		g.grille[2][2] = 2;
		
		assertEquals(2, g.isColonne());
		
		g = new Grille();
		g.initGrille();
		
		assertNull(g.isColonne());
		
		Random random = new Random();
		int x = random.nextInt(7 + 1) + 3;
		int res = random.nextInt(1 + 1) + 1;
		g = new Grille(x);
		g.initGrille();
		
		for(int i = 0; i<x; i++) {
			g.grille[i][0]=res;
		}
		
		assertEquals(res, g.isColonne());
	}
	
	@Test
	void isDiag() throws InvalidAttributesException {
		// Diago droite
		
		Grille g = new Grille();
		g.initGrille();
		g.grille[0][0] = 1;
		g.grille[1][1] = 1;
		g.grille[2][2] = 1;
		
		assertEquals(1, g.isDiag());
		
		g = new Grille();
		g.initGrille();
		g.grille[0][0] = 2;
		g.grille[1][1] = 2;
		g.grille[2][2] = 2;
		
		assertEquals(2, g.isDiag());
		
		// Diago gauche
		
		g = new Grille();
		g.initGrille();
		g.grille[0][2] = 1;
		g.grille[1][1] = 1;
		g.grille[2][0] = 1;
		
		assertEquals(1, g.isDiag());
		
		g = new Grille();
		g.initGrille();
		g.grille[0][2] = 2;
		g.grille[1][1] = 2;
		g.grille[2][0] = 2;
		
		assertEquals(2, g.isDiag());
		
		// Vide
		
		g = new Grille();
		g.initGrille();
		
		assertNull(g.isDiag());
		
		// diago droite taille aléatoire
		
		Random random = new Random();
		int x = random.nextInt(7 + 1) + 3;
		int res = random.nextInt(1 + 1) + 1;
		g = new Grille(x);
		g.initGrille();
		
		for(int i = 0; i<x; i++) {
			g.grille[i][i]=res;
		}
		
		assertEquals(res, g.isDiag());
		
		// diago gauche taille aléatoire
		
		x = random.nextInt(7 + 1) + 3;
		res = random.nextInt(1 + 1) + 1;
		g = new Grille(x);
		g.initGrille();
		
		for(int i = 0; i<x; i++) {
			g.grille[i][x-1-i]=res;
		}
		
		assertEquals(res, g.isDiag());
	}
	
	@Test
	void isFull() throws InvalidAttributesException {
		Grille g = new Grille();
		g.initGrille();
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				g.setPosition(i, j, 1);
			}
		}
		assertTrue(g.isFull());
		
		g = new Grille();
		g.initGrille();
		assertFalse(g.isFull());
		
		Random random = new Random();
		int x = random.nextInt(7 + 1) + 3;
		g = new Grille(x);
		g.initGrille();
		
		for(int i = 0; i<x; i++) {
			for(int j = 0; j<x; j++) {
				g.setPosition(i, j, random.nextInt(1 + 1) + 1);
			}
		}
		
		assertTrue(g.isFull());
	}
}
