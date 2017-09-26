package MeuPacote;

import java.util.Scanner;

/*Aluno 01: Antonio Carlos */
public class PedraPapelTesoura {

	public static void main(String[] args) {
		int n = 3, i, j;
		Scanner ler = new Scanner(System.in);

		while (true) {
			System.out.print("Pedra (1), Papel (2), Tesoura (3)?");
			i = ler.nextInt();
			System.out.print("Pedra (1), Papel (2), Tesoura (3)?");
			j = ler.nextInt();
			if (i == -1 || j == -1) {
				break;
			} else {
				if (i == 1)
					System.out.print("PEDRA - ");
				else if (i == 2)
					System.out.print("PAPEL - ");
				else if (i == 3)
					System.out.print("TESOURA - ");
				if (j == 1)
					System.out.print("PEDRA\n");
				else if (j == 2)
					System.out.print("PAPEL\n");
				else if (j == 3)
					System.out.print("TESOURA\n");
				CalculaGanhador(i, j, n);
			}
		}
	}

	public static String CalculaGanhador(int i, int j, int n) {
		String res1 = " ";
		int res = Math.abs(((3 + i - j) % 3));
		if (res < n / 2.0 && res > 0) {
			res1 = "JOGADOR 1 GANHOU\n";
		} else if (res > n / 2.0) {
			res1 = "JOGADOR 2 GANHOU\n";
		} else if (res == 0) {
			res1 = "EMPATE\n";
		}
		System.out.println(res1);
		return res1;
	}
}
