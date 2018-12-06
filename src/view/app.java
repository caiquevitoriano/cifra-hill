package view;

import java.util.Scanner;
import util.CifradorHill;

public class app {
	
	public static void main(String[] args) {
                Scanner src = new  Scanner(System.in);
                
		System.out.println("Didite a plavra: ");  
		String palavra = src.nextLine();
		
		int[][] key = {{2, 3},
                              {1, 5}};
		
		int blocoSize = 2;
		
		CifradorHill encriptador = new CifradorHill(key, blocoSize);
                
		String cifrado = encriptador.cifrar(palavra);
		
		System.out.println("Palavra cifrada: "+cifrado);
		
		
		
	}

}
