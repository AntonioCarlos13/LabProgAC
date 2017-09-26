package meuPacote;

import java.util.Scanner;

public class MaxMin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [ ] n = {0,0,0} ;
		int maior, menor;
		
		System.out.print("Insira o primeiro valor: ");
		n[0] = sc.nextInt();
		System.out.print("Insira o segundo valor: ");
		n[1] = sc.nextInt();
		System.out.print("Insira o terceiro valor: ");
		n[2] = sc.nextInt();
		maior =  menor =  n[0];
		for (int i = 0; i < n.length; i++) {
			if (maior <= n[i]){
				maior = n[i];
			}else if(menor >= n[i]){
				menor = n[i];
			}
		}
		System.out.printf("O maior valor é: %d\n", maior);
		System.out.printf("O menor valor é: %d\n", menor);
	}
}
