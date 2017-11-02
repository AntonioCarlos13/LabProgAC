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

		// Criar um robô com energia negativa e ver que uma exceção é lançada
		try {
			new Robo(sala, -1);
			Assert.fail("Esperava excecao, pois a quantidade de energia é negativa.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Robo sem energia.", e.getMessage());
		}

		// Criar um robô com energia zero e ver que uma exceção é lançada
		try {
			new Robo(sala, 0);
			Assert.fail("Esperava excecao, pois a quantidade de energia é zero.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Robo sem energia.", e.getMessage());
		}

		// Criar um robô com uma sala null e ver que uma exceção é lançada
		try {
			new Robo(null, 10);
			Assert.fail("Esperava excecao, pois a sala do robô é vazia.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Sala vazia.", e.getMessage());
		}

		// Criar um robô com uma sala cheia e ver que uma exceção é lançada
		try {
			sala = new Sala(numLinhas, numColunas);
			for (int i = 0; i < sala.getNumPosicoesHorizontais(); i++) {
				for (int j = 0; j < sala.getNumPosicoesVerticais(); j++) {
					sala.inserirObstaculo(i, j);
				}
			}
			robo = new Robo(sala, energia);
			Assert.fail("Esperava excecao, pois a sala do robô é cheia.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Sala cheia.", e.getMessage());
		}

		// (i) a posição inicial do robô é (0,0)
		// (ii) a sala não está livre na posição (0,0)
		sala = new Sala(numLinhas, numColunas);
		robo = new Robo(sala, energia);
		Assert.assertTrue((robo.getLinha() == 0) && (robo.getColuna() == 0));
		Assert.assertFalse(sala.isPosicaoLivre(0, 0));
	}
		
		@Test
		public void testaMovimentosDoRobo() {

		// Criar um robô com energia 10 e verificar que:
		// o robô não pode subir, o robô não pode ir para a esquerda.
		Assert.assertFalse(robo.andarParaTras());
		Assert.assertFalse(robo.andarParaEsquerda());

		// Depois de tentar fazer o robô subir e tentar fazer o robô ir para a
		// esquerda
		// a energia do robô deve continuar sendo 10 e o número de passos dados
		// 0,
		// já que o robô de fato não se movimentou
		Assert.assertTrue(robo.getEnergia() == 10);
		Assert.assertTrue(robo.getPassos() == 0);

		// Deve ser possível fazer o robô descer (verificar isso) e
		// verificar que a posição nova do robô é (1,0)
		Assert.assertTrue(robo.andarParaFrente());
		Assert.assertTrue((robo.getLinha() == 1) && (robo.getColuna() == 0));

		// Deve ser possível fazer o robô ir para a direita (verificar isso)
		// e verificar que a posição nova do robô é (1,1)
		Assert.assertTrue(robo.andarParaDireita());
		Assert.assertTrue((robo.getLinha() == 1) && (robo.getColuna() == 1));

		// Realize testes semelhantes aos acima movimentando o robô para cima e
		// para a esquerda
		Assert.assertTrue(robo.andarParaTras());
		Assert.assertTrue((robo.getLinha() == 0) && (robo.getColuna() == 1));
		Assert.assertTrue(robo.andarParaEsquerda());
		Assert.assertTrue((robo.getLinha() == 0) && (robo.getColuna() == 0));
	}

	@Test
	public void testaMovimentosComObstaculos() {
		// Crie um robô com energia 10 em uma sala vazia
		// Insira obstáculos nas posições (1,0) e (0,2) da sala
		sala.inserirObstaculo(1, 0);
		sala.inserirObstaculo(0, 2);

		// Faça o robô descer – isso não deve ser possível, já que a posição
		// está ocupada –
		// teste que a energia e a posição do robô não alteraram
		Assert.assertFalse(robo.andarParaFrente());
		Assert.assertTrue(robo.getEnergia() == 10);
		Assert.assertTrue((robo.getLinha() == 0) && (robo.getColuna() == 0));

		// Faça o robô ir para a direita – isso deve ser possível. Teste que a
		// nova posição
		// do robô é (0,1) e teste que o número de passos dados pelo robô foi 1
		// e a energia é 9.
		Assert.assertTrue(robo.andarParaDireita());
		Assert.assertTrue((robo.getLinha() == 0) && (robo.getColuna() == 1));
		Assert.assertTrue(robo.getPassos() == 1);
		Assert.assertTrue(robo.getEnergia() == 9);
		
		// Faça o robô ir para a direita e verifique que ele não se movimentou
		// (seu número
		// de passos deve ser 1 e energia deve ser 9)
		Assert.assertFalse(robo.andarParaDireita());
		Assert.assertTrue(robo.getPassos() == 1);
		Assert.assertTrue(robo.getEnergia() == 9);

		// Faça o robô descer. Verifique que a nova posição é (1,1), o número de
		// passos foi
		// 2 e a energia está em 8
		Assert.assertTrue(robo.andarParaFrente());
		Assert.assertTrue((robo.getLinha() == 1) && (robo.getColuna() == 1));
		Assert.assertTrue(robo.getPassos() == 2);
		Assert.assertTrue(robo.getEnergia() == 8);

		// Faça o robô ir para a direita e verifique que a nova posição é (1,2),
		// a energia
		// é 7 e numero de passos 3
		Assert.assertTrue(robo.andarParaDireita());
		Assert.assertTrue((robo.getLinha() == 1) && (robo.getColuna() == 2));
		Assert.assertTrue(robo.getEnergia() == 7);
		Assert.assertTrue(robo.getPassos() == 3);

		// Continue realizando testes de forma que o obstáculo (1,0) seja
		// alcançado e impeça
		// o robô de se movimentar para uma dada direção
		Assert.assertTrue(robo.andarParaEsquerda());
		Assert.assertTrue(robo.andarParaFrente());
		Assert.assertTrue(robo.andarParaEsquerda());
		Assert.assertFalse(robo.andarParaTras());
	}
	@Test
	public void testaAtributos(){
		// Crie um robô com uma sala vazia e faça ele se movimentar. À medida
		// que vai se
		// movimentando teste se o número de passos, a posição e o nível de
		// energia estão corretos
		Assert.assertTrue(robo.andarParaDireita());
		Assert.assertTrue(robo.getPassos() == 1);
		Assert.assertTrue((robo.getLinha() == 0) && (robo.getColuna() == 1));
		Assert.assertTrue(robo.getEnergia() == 9);

	}

	// Você precisa testar se o robô obedece as regras quando ele está nas
	// “quinas”
	// da sala. Por exemplo, se uma sala tem 3 linhas e 3 colunas, teste os
	// movimentos
	// possíveis quando o robô está na posição (0,2), (2,0) e (2,2) (a posição
	// 0,0 já foi testada)
	@Test
	public void testaQuinas() {
		sala = new Sala(3, 3);
		robo = new Robo(sala, energia);

		// teste os movimentos possíveis quando o robô está na posição (0,2)
		Assert.assertTrue(robo.andarParaDireita());
		Assert.assertTrue(robo.andarParaDireita());
		Assert.assertTrue((robo.getLinha() == 0) && (robo.getColuna() == 2));
		Assert.assertFalse(robo.andarParaDireita());
		Assert.assertFalse(robo.andarParaTras());

		// teste os movimentos possíveis quando o robô está na posição (2,2)
		Assert.assertTrue(robo.andarParaFrente());
		Assert.assertTrue(robo.andarParaFrente());
		Assert.assertTrue((robo.getLinha() == 2) && (robo.getColuna() == 2));
		Assert.assertFalse(robo.andarParaDireita());
		Assert.assertFalse(robo.andarParaFrente());
		
		// teste os movimentos possíveis quando o robô está na posição (2,0)
		Assert.assertTrue(robo.andarParaEsquerda());
		Assert.assertTrue(robo.andarParaEsquerda());
		Assert.assertTrue((robo.getLinha() == 2) && (robo.getColuna() == 0));
		Assert.assertFalse(robo.andarParaEsquerda());
		Assert.assertFalse(robo.andarParaFrente());

	}

	// Você precisa testar que dois robôs são iguais se e somente se eles
	// tiverem
	// uma sala idêntica e estiverem na mesma posição da sala.
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
