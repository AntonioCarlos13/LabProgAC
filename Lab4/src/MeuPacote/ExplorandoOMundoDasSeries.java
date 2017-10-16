package MeuPacote;

import java.util.Scanner;
/*	Aluno 01: Antônio Carlos
 * 	Aluno 02: Luis Thiago
 */
/**
 * Classe de Explorar o mundo das séries
 *
 *@author Antônio Carlos
 *@version 2.0 16 de Outubro de 2017
 */
public class ExplorandoOMundoDasSeries {
	int primeiro, razao;
	boolean paCriada = false, fiboCriada = false;
	Scanner ler = new Scanner(System.in);
	
	//métodos
	/**
	 * Mostra o menu de interação com o usuário
	 *
	 */

	public void menu() {
		int opcao;
		do {
			System.out.println("\nInforme a opcao desejada");
			System.out.println("1. Para criar uma progressão aritmética");
			System.out.println("2. Para criar uma série de Fibonacci");
			System.out.println("3. Para ver o termo \"n\" da sua PA");
			System.out.println("4. Para ver o termo \"n\" da serie de Fibonacci");
			System.out.println("5. Para mostrar os “n” primeiros termos da sua PA e da serie de Fibonacci");
			System.out.println("6. Para sair.");
			System.out.print("Opcao -> ");
			opcao = ler.nextInt();
			switch (opcao) {
			case 1:
				System.out.print("\nInforme o primeiro elemento da pa: ");
				primeiro = ler.nextInt();
				System.out.print("Informe a razao da pa: ");
				razao = ler.nextInt();
				System.out.println("Progressao Aritmetica criada com sucesso!");
				criarPa(primeiro, razao);
				break;
			case 2:
				criarFibonacci();
				System.out.println("Serie de Fibonacci criada com sucesso!");
				break;
			case 3:
				int termoPa = verTermoPa();
				if (termoPa == -1) {
					System.out.println("Crie uma Pa para poder ver os termos...");
				} else {
					System.out.println(termoPa);
				}
				break;
			case 4:
				int termoFibo = verTermoFibonacci();
				if (termoFibo == -1) {
					System.out.println("Crie uma Serie Fibonacci para poder ver os termos...");
				} else {
					System.out.println(termoFibo);
				}
				break;
			case 5: 
				mostrarSeries();
			break;
			case 6: 
				System.out.println("Saindo...");
			}
		} while (opcao != 6);
	}
	/**
	 * Cria uma Progressão aritmética.
	 * 
	 * @param primeiro
	 * 				O primeiro termo da progressao aritmetica. 
	 * @param razao
	 * 				A razão da progressao aritmetica.
	 * 	@return Uma Progressão aritmética.
	 * */
	public Object criarPa(int primeiro, int razao) {
		ProgressaoAritmetica pa = new ProgressaoAritmetica(primeiro, razao);
		paCriada = true;
		return pa;
	}
	/**
	 * Cria uma Progressão de Fibonacci.
	 * 
	 * 	@return Uma Progressão de Fibonacci.
	 */
	public Object criarFibonacci() {
		Fibonacci fibo = new Fibonacci();
		fiboCriada = true;
		return fibo;
	}
	/**
	 * Mostra um termo de uma Progressão aritmética.
	 * 
	 * @return O termo da Progressão aritmética solicitado pelo usuário. 
	 * */
	public int verTermoPa() {
		if (paCriada == true) {
			int termo;
			Object pa;
			pa = criarPa(primeiro, razao);
			System.out.print("Informe o termo \"n\" da sua PA: ");
			termo = ler.nextInt();
			System.out.printf("O termo[%d] da sua PA é: ", termo);
			return ((ProgressaoAritmetica) pa).termo(termo);
		} else {
			return -1;
		}
	}
	/**
	 * Mostra um termo de uma Progressão de Fibonacci.
	 * 
	 * @return O termo da Progressão de Fibonacci solicitado pelo usuário. 
	 * */
	public int verTermoFibonacci() {
		if (fiboCriada == true) {
			int termo;
			Object fibo;
			fibo = criarFibonacci();
			System.out.print("Informe o termo \"n\" da sua serie de Fibonacci: ");
			termo = ler.nextInt();
			System.out.printf("O termo[%d] da sua serie Fibonacci é: ", termo);
			return ((Fibonacci) fibo).termoFibonacci(termo);
		} else {
			return -1;
		}

	}
	/**
	 * Mostra a Progressão de aritmética e a Progressão de Fibonacci.
	 * */
	public void mostrarSeries(){
		if (paCriada == true && fiboCriada == true){
		Object fibo, pa;
		int quantidade;
		pa = criarPa(primeiro, razao);
		fibo = criarFibonacci();
		System.out.print("Informe a quantidade de termos a serem gerados: ");
		quantidade = ler.nextInt();
		System.out.println("Progressao Aritmética");
		((ProgressaoAritmetica) pa).geraTermos(quantidade);
		System.out.println("\nSerie de Fibonacci");
		((Fibonacci) fibo).geraTermoFibo(quantidade);
		}else{
			System.out.println("Crie uma Serie Fibonacci e uma PA para ver os \"n\" termos");
		}
	}
	/**
	 * Cria um objeto da classe de Explorar o mundo das séries para testar. 
	 * */
	public static void main(String[] args) {
		ExplorandoOMundoDasSeries j1 = new ExplorandoOMundoDasSeries();
		j1.menu();
	}
}