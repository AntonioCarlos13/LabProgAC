package MeuPacote;

import java.util.Scanner;

public class Jogo {
	private boolean ganhar = false;
	private int jogada = 1, linha = 0, coluna = 0, vitoriasJ1 = 0, vitoriasJ2 = 0;
	private char sinal;
	private char JogoVelha[][] = new char[3][3];
	Scanner ler = new Scanner(System.in);
	private String ganhador;

	public void ImprimirTabuleiro() {

		System.out.print("JOGO DA VELHA \n");
		for (linha = 0; linha < 3; linha++) {
			for (coluna = 0; coluna < 3; coluna++) {
				System.out.print(" " + JogoVelha[linha][coluna] + " " + "|");
			}
			if (linha < 3 - 1) {
				System.out.print("\n-------------\n");
			}
		}

	}

	public void JogarOJogo() {
		int x;
		x = ContinuarJogando();
		while (x == 1) {
			ImprimirTabuleiro();
			System.out.println("\nINSIRA AS COORDENADAS");
			if ((jogada % 2) == 1) {

				System.out.print("PLAYER 1\nLINHA: ");
				linha = ler.nextInt();
				System.out.print("COLUNA: ");
				coluna = ler.nextInt();
				sinal = 'X';

			} else {

				System.out.print("PLAYER 2\nLINHA: ");
				linha = ler.nextInt();
				System.out.print("COLUNA: ");
				coluna = ler.nextInt();
				sinal = 'O';
			}
			
			String posicao = VerificarPosicao();
			System.out.println(posicao);
			ganhador = VerificarGanhador();
			System.out.println(ganhador);
			if (ganhar == true) {
				jogada = 1;
				for (linha = 0; linha < 3; linha++)
					for (coluna = 0; coluna < 3; coluna++)
						JogoVelha[linha][coluna] = ' ';
				x = ContinuarJogando();
				ganhar = false;
			}
		}
	}

	public int ContinuarJogando() {
		System.out.println("APERTE (1) COMECAR UMA NOVA PARTIDA OU PARA APERTE (0) ENCERRAR O JOGO");
		Scanner input = new Scanner(System.in);
		int valorDigitado = input.nextInt();
		if (valorDigitado == 1) {
			valorDigitado = 1;
		} else {
			System.out.println("Jogo Finalizado.");
			System.out.printf("Vitórias do Jogador1: %d\n", vitoriasJ1);
			System.out.printf("Vitórias do Jogador2: %d\n", vitoriasJ2);
			valorDigitado = 0;
		}
		return valorDigitado;

	}

	public String VerificarGanhador() {
		String vencedor = " ";
		if ((JogoVelha[0][0] == 'X' && JogoVelha[0][1] == 'X' && JogoVelha[0][2] == 'X')
				|| (JogoVelha[1][0] == 'X' && JogoVelha[1][1] == 'X' && JogoVelha[1][2] == 'X')
				|| (JogoVelha[2][0] == 'X' && JogoVelha[2][1] == 'X' && JogoVelha[2][2] == 'X')
				|| (JogoVelha[0][0] == 'X' && JogoVelha[1][0] == 'X' && JogoVelha[2][0] == 'X')
				|| (JogoVelha[0][1] == 'X' && JogoVelha[1][1] == 'X' && JogoVelha[2][1] == 'X')
				|| (JogoVelha[0][2] == 'X' && JogoVelha[1][2] == 'X' && JogoVelha[2][2] == 'X')
				|| (JogoVelha[0][0] == 'X' && JogoVelha[1][1] == 'X' && JogoVelha[2][2] == 'X')
				|| (JogoVelha[0][2] == 'X' && JogoVelha[1][1] == 'X' && JogoVelha[2][0] == 'X')) {
			ganhar = true;
			ImprimirTabuleiro();
			vitoriasJ1++;
			vencedor = "\nJogador 1, VOCE VENCEU!!!";
		} else if ((JogoVelha[0][0] == 'O' && JogoVelha[0][1] == 'O' && JogoVelha[0][2] == 'O')
				|| (JogoVelha[1][0] == 'O' && JogoVelha[1][1] == 'O' && JogoVelha[1][2] == 'O')
				|| (JogoVelha[2][0] == 'O' && JogoVelha[2][1] == 'O' && JogoVelha[2][2] == 'O')
				|| (JogoVelha[0][0] == 'O' && JogoVelha[1][0] == 'O' && JogoVelha[2][0] == 'O')
				|| (JogoVelha[0][1] == 'O' && JogoVelha[1][1] == 'O' && JogoVelha[2][1] == 'O')
				|| (JogoVelha[0][2] == 'O' && JogoVelha[1][2] == 'O' && JogoVelha[2][2] == 'O')
				|| (JogoVelha[0][0] == 'O' && JogoVelha[1][1] == 'O' && JogoVelha[2][2] == 'O')
				|| (JogoVelha[0][2] == 'O' && JogoVelha[1][1] == 'O' && JogoVelha[2][0] == 'O')) {
			ganhar = true;
			ImprimirTabuleiro();
			vitoriasJ2++;
			vencedor = "\nJogador 2, VOCE VENCEU!!!";
		} else if (jogada > 9) {
			ganhar = true;
			ImprimirTabuleiro();
			vencedor = "\nPARTIDA EMPATADA";
		}
		return vencedor;
	}

	public String VerificarPosicao() {
		if (JogoVelha[linha][coluna] == 'X' || JogoVelha[linha][coluna] == 'O') {
			return "POSICAO JA UTILIZADA!";
		} else {
			JogoVelha[linha][coluna] = sinal;
			jogada++;
		}
		return "\n";
	}
}
