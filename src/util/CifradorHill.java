package util;

import java.util.ArrayList;

public class CifradorHill {
	
	int[][] key;
	int blocoSize;
	
	public CifradorHill(int[][] key, int blocoSize) {	
		this.key = key;		
		this.blocoSize = blocoSize;
	}
	
	public String cifrar(String palavra) {
		
		// Quebrando palavra em blocos		
		String[] subPalavras = quebrarPalavra(palavra);
		
		// Transformando blocos de letras em matriz de valores		
		ArrayList<int[][]> valores = ConversorPalavraMatriz.toMatriz(subPalavras);
		
		// Multiplicando matriz de valores pela chave		
		ArrayList<int[][]> criptValores = MultiplicadorDeMatriz.multiplicar(key, valores);
		
		// Transformando valores gerados em blocos de letras		
		String[] criptSubPalavras = ConversorPalavraMatriz.toLetras(criptValores);
		
		// formando palavra cifrada apartir dos blocos cifrados
		String cript = formarPalavra(criptSubPalavras);
		
		return cript;
	}
	

	
	// quebra palavra em blocos de tamanho blocoSize
	public String[] quebrarPalavra(String palavra) {
			
		String palavraCompleta = completarPalavra(palavra);
		
		int quantBloco = palavraCompleta.length() / this.blocoSize;
		String[] blocos = new String[quantBloco];
		
		int beginIndex = 0;
		int endIndex = blocoSize;
		for(int i = 0; i < quantBloco; i++) {
			blocos[i] = palavraCompleta.substring(beginIndex, endIndex);
			beginIndex += blocoSize;
			endIndex += blocoSize;
		}
		
		return blocos;
	}	
	
	private String formarPalavra(String[] subPalavras) {
		String result = "";
		for(String subPalavra : subPalavras) {
			result += subPalavra;
		}
		return result;
	}
	
	private String completarPalavra(String palavra) {
		
		int mod = palavra.length() % this.blocoSize;
		if(mod == 0) {
			return palavra;
		}
		
		String newPalavra = palavra;
		for(int i = 0; i < this.blocoSize - mod; i++) {
			newPalavra += "h";
		}
		return newPalavra;
		
	}	
	
	
}
