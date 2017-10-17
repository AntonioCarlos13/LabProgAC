package MeuPacote;

/*	Aluno 01: Antônio Carlos
 */
/**
 * Classe de progressão aritmética
 *
 *@author Antônio Carlos
 *@version 2.0 16 de Outubro de 2017
 */

public class ProgressaoAritmetica extends java.lang.Object {
	private int primeiro, razao, atual, termo;
	
	// construtor
	/** Cria uma progressão aritmética a partir do primeiro termo e de uma razão.
	 * @param primeiro
	 * 				O primeiro termo da progressao aritmetica. 
	 * @param razao
	 * 				A razão da progressao aritmetica.
	 */

	public ProgressaoAritmetica(int primeiro, int razao) {
		this.primeiro = primeiro;
		this.razao = razao;
	}
	// métodos
	/**Recupera a razão da progressão aritmética.
	 * 
	 * @return a razão da progressão aritmética.
	 */
	public int getRazao() {
		return razao;
	}

	/**
	 * Calcula o primeiro termo da progressão aritmética.
	 * 
	 * @return O valor atual da progressão aritmética.
	 */
	public int primeiro() {
		atual = primeiro;
		return atual;
	}

	/**
	 * Calcula o proximo termo da progressão aritmética.
	 * 
	 * @return O próximo elemento da progressão aritmética.
	 */
	public int proximo() {
		int proximo;
		proximo = atual + getRazao();
		atual = proximo;
		return proximo;
	}

	/**
	 * Calcula o n-esimo termo da progessao aritmetica.
	 * 
	 * @param n
	 * 			O termo n a ser mostrado.
	 * @return O termo atual da progressão aritmética que vai ser o termo solicitado.
	 */
	public int termo(int n) {
		if (n <= 0) {
			return primeiro;
		}
		termo = primeiro + (n - 1) * razao;
		atual = termo;
		return atual;
	}

	/**
	 * Gera os "n" primeiros termos (1 .. n) da progressão aritmética em uma
	 * String.
	 * 
	 * @param n
	 * 			A quantidade de termos a serem gerados.
	 * @return Os termos "n" da progressão aritmética.
	 */
	public java.lang.String geraTermos(int n) {
		String transformada;
		if (n <= 0) {
			transformada = Integer.toString(primeiro);
			return transformada;
		}
		for (int i = 0; i < n; i++) {
			System.out.printf("Termo[%d]: %d\n", i + 1, termo(i+1));
		}
		atual = termo(n);
		return "";
	}
}
