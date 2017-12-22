import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import MeuPacote.Opiniao;

/**
 * Classe OpiniaoTest
 *
 * @author Antônio Carlos
 * @version 1.0 22 de Dezembro de 2017
 */
class OpiniaoTest {
	private int notaOpiniao;
	private String comentario;
	private String dataOpiniao;
	private Opiniao opiniao;

	@Before
	public void criaOpiniao() {
		opiniao = new Opiniao(notaOpiniao, comentario, dataOpiniao);
	}

	@Test
	public void TestaCriaOpiniao() {
		try {
			new Opiniao(-3, "hasd", "2017");
			Assert.fail("Esperava excecao, pois a nota da opiniao está fora do intevalo.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Nota da opiniao fora do intervalo de avaliacao", e.getMessage());
		}

		try {
			new Opiniao(3, "hasd", "2017");
			Assert.fail("Esperava excecao, pois a nota da opiniao está fora do intevalo.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Nota da opiniao fora do intervalo de avaliacao", e.getMessage());
		}

		try {
			new Opiniao(2, null, "2017");
			Assert.fail("Esperava excecao, pois o comentario é nulo.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Comentario nulo", e.getMessage());
		}

		try {
			new Opiniao(2, "", "2017");
			Assert.fail("Esperava excecao, pois o comentario é vazio.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Comentario vazio", e.getMessage());
		}

		try {
			new Opiniao(2,
					"Fdhuhfrhfuherhuheruhetggehgtuhgrhgfuhjurubebafdgufguegugreugzefafgdjgljdkjhkdhfghkgjhhtrtrhigertyiuwrteresashdfsdertuiyertyerçtoyoppprtpotriouwretweyrew8yyweruyty",
					"2017");
			Assert.fail("Esperava excecao, pois o comentario excede os limites de caracteres.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada",
					"Comentario com o tamanho de caracteres acima da quantidade estabelecida", e.getMessage());
		}

		try {
			new Opiniao(2, "hasd", null);
			Assert.fail("Esperava excecao, pois a data da opiniao é nula.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Data da opiniao nula", e.getMessage());
		}

		try {
			new Opiniao(2, "hasd", "");
			Assert.fail("Esperava excecao, pois a data da opiniao é vazia.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Data da opiniao vazia", e.getMessage());
		}

	}

	@Test
	public void TestaToString() {
		Opiniao opiniao = new Opiniao(0, "I am the Batman", "01/12/2017");
		String resultadoEsperado = "Nota da opiniao: " + opiniao.getNotaOpiniao() + "\nComentario: "
				+ opiniao.getComentario() + "\nData da opiniao: " + opiniao.getDataOpiniao() + "\n";
		assertEquals(resultadoEsperado, opiniao.toString());
	}

	@Test
	public void testaEquals() {
		Opiniao outraOpiniao = null;
		Opiniao outraOpiniao2 = null;
		Opiniao outraOpiniao3 = null;
		try {
			opiniao = new Opiniao(1, "Teste massa", "23/12/2017");
			outraOpiniao = new Opiniao(1, "bom produto", "01/12/2017");
			outraOpiniao2 = new Opiniao(1, "bom prod", "01/12/2017");
			outraOpiniao3 = new Opiniao(1, "bom produto", "01/12/2017");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertFalse(opiniao.equals(outraOpiniao2));
		Assert.assertFalse(outraOpiniao2.equals(outraOpiniao));
		Assert.assertTrue(outraOpiniao3.equals(outraOpiniao));
		Assert.assertFalse(outraOpiniao2.equals(outraOpiniao3));
	}

}
