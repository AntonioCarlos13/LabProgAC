package MeuPacote;
/*	Aluno 01: Antônio Carlos
 */
/**
 * Classe da progressão de Fibonacci
 *
 *@author Antônio Carlos
 *@version 2.0 16 de Outubro de 2017
 */
public class Fibonacci {
	private int atual = 0, anterior = 0;
	//Metodos
	/**
	 * Calcula o n-esimo termo da progressão de Fibonacci.
	 * 
	 * @param elementos
	 * 				O termo n a ser mostrado.
	 * @return O termo atual da progressão de Fibonacci que vai ser o termo solicitado.
	 * */
	public int termoFibonacci(int elementos) {

		for (int i = 0; i < elementos; i++) {
			if (i == 1) {
				atual = 1;
				anterior = 0;
			} else {
				atual = atual + anterior;
				anterior = atual - anterior;
			}
		}
		return atual;
	}
	/**Gera os "n" primeiros termos (1 .. n) da progressão de Fibonacci
	 * @param n
	 * 			A quantidade de termos a serem gerados.
	 * @return Os termos "n" da progressão de Fibonacci.
	 * */
	public void geraTermoFibo(int n){
		if (n <= 0){
			System.out.println("Informe um valor positivo maior que zero.");
		}else{
			for (int i = 0; i < n; i++) {
				System.out.printf("Termo[%d]: %d\n", i + 1, termoFibonacci(i+1));
			}
		}
	}
}
