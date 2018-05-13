package uebung4.aufgabe24;

import java.util.Scanner;

public class DiskreterLogarithmus {
	
	private int A;
	private int g;
	private int alpha;
	private int modulo;
	private long[] tabelleSchritt3;
	private long[] tabelleSchritt4;
	private int indexJ;
	private int indexI;
	
	/**
	 * A = g^alpha mod p
	 * @param A
	 * @param g
	 * @param alpha
	 * @param p
	 */
	public DiskreterLogarithmus(int A, int g, int alpha, int p) {
		this.A = A;
		this.g = g;
		this.alpha = alpha;
		this.modulo = p;
		indexJ = -1;
		indexI = -1;
		tabelleSchritt3 = new long[wurzelAusPhi()];
		tabelleSchritt4 = new long[tabelleSchritt3.length];
	}
	
	/**
	 * Schritt 3 im Algorythmus
	 */
	public void schritt3() {
		
		// Zu berechnen: g^alpha
		for (int i = 0; i < tabelleSchritt3.length; i++) {
			tabelleSchritt3[i] = (int) Math.pow(g, i);//.berechneModuloWerte(i);
		}
	}
	
	/**
	 * Schritt 4 im Algorythmus
	 * @return
	 */
	
	public void schritt4() {
		
		int multi = (int) Math.pow(g, berechnePhi()-wurzelAusPhi());
		
		int indexTabelle4 = 0;
		
		// erstelle neue Zabelle
		for (int i = 0; i < tabelleSchritt4.length; i++) {
			tabelleSchritt4[i] = (A * (int)Math.pow(multi, i));
		}
	}
	
	public void findeIundJ() {
		// suche die Arrays ab.
		
		for (int i = 0; i < tabelleSchritt4.length; i++) {
			for (int j = 0; j < tabelleSchritt3.length; j++) {
				if(tabelleSchritt4[i] == tabelleSchritt3[j]) {
					indexJ = j;
					indexI = i;
					System.out.println("ZAHLEN GEFUNDEN!!!");
					return;
				}
			}
		}
	}
	
	public void gebeIMJ() {
		System.out.println("a = (i * m + j) = " + indexI + " * " + wurzelAusPhi() + " + " + indexJ + " = " + (indexI * wurzelAusPhi() + indexJ));
	}
	
	public int berechneGrossePotenz() {
		return 1;
	}
	
	public int berechnePhi() {
		return modulo-1;
	}
	
	/**
	 * Berechne die Wurzel aus Phi
	 * @return
	 */
	public int wurzelAusPhi() {
		return (int) (Math.sqrt(berechnePhi())+1);
	}
	
	/**
	 * Berechne den Modulo Wert
	 * @param index
	 * @return
	 */
	public int berechneModuloWerte(int index) {
		return ((int)(Math.pow(g, alpha)) % modulo);
	}
	
	/**
	 * Seq. SUche im Array
	 * @param wert zu suchender Wert
	 * @param tabelleSchritt3 durchzusuchendes Array
	 * @return Position des Arrays, bei negativer Suche wird -1 zurückgegeben
	 */
	
	public int sucheInTabelle(int wert) {
		
		for (int i = 0; i < tabelleSchritt3.length; i++) {
			if (wert == tabelleSchritt3[i])
				return i;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		DiskreterLogarithmus ds;
		int A;
		int g;
		int alpha;
		int p;
		
		Scanner sc = new Scanner(System.in);
		
		//Eingabe von Alpha notwendig?
		//i und j bleiben -1
		
		System.out.print("Bitte geben Sie A ein: ");
		A = sc.nextInt();
		A = 3;
		System.out.print("Bitte geben Sie g ein: ");
		g = sc.nextInt();
		g = 11;
		System.out.print("Bitte geben Sie alpha ein: ");
		alpha = sc.nextInt();
		alpha = 1;
		System.out.print("Bitte geben Sie p ein: ");
		p = sc.nextInt();
		p = 29;
		
		System.out.println("Ihre Formel lautet: " + A + " = " + g + "^" + alpha + " mod " + p);
		
		ds = new DiskreterLogarithmus(A, g, alpha, p);
		
		ds.schritt3();
		ds.printArray3();
		ds.printArray4();
		ds.schritt4();
		ds.findeIundJ();
		ds.gebeIMJ();
		
	}
	
	public void printArray3() {
		for (long i : tabelleSchritt3)
			System.out.print(i + ", ");
		System.out.println();
	}
	
	public void printArray4() {
		for (long i : tabelleSchritt4)
			System.out.print(i + ", ");
		System.out.println();
	}

}
