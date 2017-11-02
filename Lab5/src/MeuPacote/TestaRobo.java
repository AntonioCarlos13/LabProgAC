package MeuPacote;
/*Antonio Carlos*/
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaRobo {
	private final int numLinhas = 10;
	private final int numColunas = 10;
	private final int energia = 10;
	private Robo robo;
	private Sala sala;

	@Before
	public void criaObjetos() throws Exception {
		sala = new Sala(numLinhas, numColunas);
		robo = new Robo(sala, energia);
	}

	@Test
	public void testaCriaRobo() {

		// Criar um rob� com energia negativa e ver que uma exce��o � lan�ada
		try {
			new Robo(sala, -1);
			Assert.fail("Esperava excecao, pois a quantidade de energia � negativa.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Robo sem energia.", e.getMessage());
		}

		// Criar um rob� com energia zero e ver que uma exce��o � lan�ada
		try {
			new Robo(sala, 0);
			Assert.fail("Esperava excecao, pois a quantidade de energia � zero.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Robo sem energia.", e.getMessage());
		}

		// Criar um rob� com uma sala null e ver que uma exce��o � lan�ada
		try {
			new Robo(null, 10);
			Assert.fail("Esperava excecao, pois a sala do rob� � vazia.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Sala vazia.", e.getMessage());
		}

		// Criar um rob� com uma sala cheia e ver que uma exce��o � lan�ada
		try {
			sala = new Sala(numLinhas, numColunas);
			for (int i = 0; i < sala.getNumPosicoesHorizontais(); i++) {
				for (int j = 0; j < sala.getNumPosicoesVerticais(); j++) {
					sala.inserirObstaculo(i, j);
				}
			}
			robo = new Robo(sala, energia);
			Assert.fail("Esperava excecao, pois a sala do rob� � cheia.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Sala cheia.", e.getMessage());
		}

		// (i) a posi��o inicial do rob� � (0,0)
		// (ii) a sala n�o est� livre na posi��o (0,0)
		sala = new Sala(numLinhas, numColunas);
		robo = new Robo(sala, energia);
		Assert.assertTrue((robo.getLinha() == 0) && (robo.getColuna() == 0));
		Assert.assertFalse(sala.isPosicaoLivre(0, 0));
	}
		
		@Test
		public void testaMovimentosDoRobo() {

		// Criar um rob� com energia 10 e verificar que:
		// o rob� n�o pode subir, o rob� n�o pode ir para a esquerda.
		Assert.assertFalse(robo.andarParaTras());
		Assert.assertFalse(robo.andarParaEsquerda());

		// Depois de tentar fazer o rob� subir e tentar fazer o rob� ir para a
		// esquerda
		// a energia do rob� deve continuar sendo 10 e o n�mero de passos dados
		// 0,
		// j� que o rob� de fato n�o se movimentou
		Assert.assertTrue(robo.getEnergia() == 10);
		Assert.assertTrue(robo.getPassos() == 0);

		// Deve ser poss�vel fazer o rob� descer (verificar isso) e
		// verificar que a posi��o nova do rob� � (1,0)
		Assert.assertTrue(robo.andarParaFrente());
		Assert.assertTrue((robo.getLinha() == 1) && (robo.getColuna() == 0));

		// Deve ser poss�vel fazer o rob� ir para a direita (verificar isso)
		// e verificar que a posi��o nova do rob� � (1,1)
		Assert.assertTrue(robo.andarParaDireita());
		Assert.assertTrue((robo.getLinha() == 1) && (robo.getColuna() == 1));

		// Realize testes semelhantes aos acima movimentando o rob� para cima e
		// para a esquerda
		Assert.assertTrue(robo.andarParaTras());
		Assert.assertTrue((robo.getLinha() == 0) && (robo.getColuna() == 1));
		Assert.assertTrue(robo.andarParaEsquerda());
		Assert.assertTrue((robo.getLinha() == 0) && (robo.getColuna() == 0));
	}

	@Test
	public void testaMovimentosComObstaculos() {
		// Crie um rob� com energia 10 em uma sala vazia
		// Insira obst�culos nas posi��es (1,0) e (0,2) da sala
		sala.inserirObstaculo(1, 0);
		sala.inserirObstaculo(0, 2);

		// Fa�a o rob� descer � isso n�o deve ser poss�vel, j� que a posi��o
		// est� ocupada �
		// teste que a energia e a posi��o do rob� n�o alteraram
		Assert.assertFalse(robo.andarParaFrente());
		Assert.assertTrue(robo.getEnergia() == 10);
		Assert.assertTrue((robo.getLinha() == 0) && (robo.getColuna() == 0));

		// Fa�a o rob� ir para a direita � isso deve ser poss�vel. Teste que a
		// nova posi��o
		// do rob� � (0,1) e teste que o n�mero de passos dados pelo rob� foi 1
		// e a energia � 9.
		Assert.assertTrue(robo.andarParaDireita());
		Assert.assertTrue((robo.getLinha() == 0) && (robo.getColuna() == 1));
		Assert.assertTrue(robo.getPassos() == 1);
		Assert.assertTrue(robo.getEnergia() == 9);
		
		// Fa�a o rob� ir para a direita e verifique que ele n�o se movimentou
		// (seu n�mero
		// de passos deve ser 1 e energia deve ser 9)
		Assert.assertFalse(robo.andarParaDireita());
		Assert.assertTrue(robo.getPassos() == 1);
		Assert.assertTrue(robo.getEnergia() == 9);

		// Fa�a o rob� descer. Verifique que a nova posi��o � (1,1), o n�mero de
		// passos foi
		// 2 e a energia est� em 8
		Assert.assertTrue(robo.andarParaFrente());
		Assert.assertTrue((robo.getLinha() == 1) && (robo.getColuna() == 1));
		Assert.assertTrue(robo.getPassos() == 2);
		Assert.assertTrue(robo.getEnergia() == 8);

		// Fa�a o rob� ir para a direita e verifique que a nova posi��o � (1,2),
		// a energia
		// � 7 e numero de passos 3
		Assert.assertTrue(robo.andarParaDireita());
		Assert.assertTrue((robo.getLinha() == 1) && (robo.getColuna() == 2));
		Assert.assertTrue(robo.getEnergia() == 7);
		Assert.assertTrue(robo.getPassos() == 3);

		// Continue realizando testes de forma que o obst�culo (1,0) seja
		// alcan�ado e impe�a
		// o rob� de se movimentar para uma dada dire��o
		Assert.assertTrue(robo.andarParaEsquerda());
		Assert.assertTrue(robo.andarParaFrente());
		Assert.assertTrue(robo.andarParaEsquerda());
		Assert.assertFalse(robo.andarParaTras());
	}
	@Test
	public void testaAtributos(){
		// Crie um rob� com uma sala vazia e fa�a ele se movimentar. � medida
		// que vai se
		// movimentando teste se o n�mero de passos, a posi��o e o n�vel de
		// energia est�o corretos
		Assert.assertTrue(robo.andarParaDireita());
		Assert.assertTrue(robo.getPassos() == 1);
		Assert.assertTrue((robo.getLinha() == 0) && (robo.getColuna() == 1));
		Assert.assertTrue(robo.getEnergia() == 9);

	}

	// Voc� precisa testar se o rob� obedece as regras quando ele est� nas
	// �quinas�
	// da sala. Por exemplo, se uma sala tem 3 linhas e 3 colunas, teste os
	// movimentos
	// poss�veis quando o rob� est� na posi��o (0,2), (2,0) e (2,2) (a posi��o
	// 0,0 j� foi testada)
	@Test
	public void testaQuinas() {
		sala = new Sala(3, 3);
		robo = new Robo(sala, energia);

		// teste os movimentos poss�veis quando o rob� est� na posi��o (0,2)
		Assert.assertTrue(robo.andarParaDireita());
		Assert.assertTrue(robo.andarParaDireita());
		Assert.assertTrue((robo.getLinha() == 0) && (robo.getColuna() == 2));
		Assert.assertFalse(robo.andarParaDireita());
		Assert.assertFalse(robo.andarParaTras());

		// teste os movimentos poss�veis quando o rob� est� na posi��o (2,2)
		Assert.assertTrue(robo.andarParaFrente());
		Assert.assertTrue(robo.andarParaFrente());
		Assert.assertTrue((robo.getLinha() == 2) && (robo.getColuna() == 2));
		Assert.assertFalse(robo.andarParaDireita());
		Assert.assertFalse(robo.andarParaFrente());
		
		// teste os movimentos poss�veis quando o rob� est� na posi��o (2,0)
		Assert.assertTrue(robo.andarParaEsquerda());
		Assert.assertTrue(robo.andarParaEsquerda());
		Assert.assertTrue((robo.getLinha() == 2) && (robo.getColuna() == 0));
		Assert.assertFalse(robo.andarParaEsquerda());
		Assert.assertFalse(robo.andarParaFrente());

	}

	// Voc� precisa testar que dois rob�s s�o iguais se e somente se eles
	// tiverem
	// uma sala id�ntica e estiverem na mesma posi��o da sala.
	@Test
	public void testaEquals() {
		Sala outraSala = new Sala(numLinhas, numColunas);
		Robo outroRobo = new Robo(outraSala, energia);

		Assert.assertTrue(robo.equals(outroRobo, outraSala));

		robo.andarParaFrente();
		Assert.assertFalse(robo.equals(outroRobo));
		outroRobo.andarParaFrente();
		Assert.assertTrue(robo.equals(outroRobo, outraSala));

		robo.andarParaTras();
		Assert.assertFalse(robo.equals(outroRobo));
		outroRobo.andarParaTras();
		Assert.assertTrue(robo.equals(outroRobo, outraSala));

		robo.andarParaDireita();
		Assert.assertFalse(robo.equals(outroRobo));
		outroRobo.andarParaDireita();
		Assert.assertTrue(robo.equals(outroRobo, outraSala));

		robo.andarParaEsquerda();
		Assert.assertFalse(robo.equals(outroRobo));
		outroRobo.andarParaEsquerda();
		Assert.assertTrue(robo.equals(outroRobo, outraSala));
	}
}
