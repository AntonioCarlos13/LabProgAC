package MeuPacote;

import static org.junit.Assert.*;
import java.util.ArrayList;
// Antonio Carlos

import org.junit.Before;
import org.junit.Test;

public class TestaMinhaCDteca {
	private String artista = "Jose";
	private String titulo = "Segredo";
	private final int numFaixas = 5;
	private CD cd;
	private MinhaCDteca discografia;
	private ArrayList<CD> colecaoDeCDs;

	@Before
	public void criaObjetos() {
		cd = new CD(artista, titulo, numFaixas);
		discografia = new MinhaCDteca();
		colecaoDeCDs = new ArrayList<CD>();
	}

	@Test
	public void TestaAdicionaCD() {
		assertTrue(discografia.numeroDeCDs() == 0);
		discografia.adicionaCD("bon jovi", "bed of roses", 10);
		assertTrue(discografia.numeroDeCDs() == 1);
		discografia.adicionaCD("bon jovi", "always", 10);
		assertTrue(discografia.numeroDeCDs() == 2);
		discografia.adicionaCD("bon jovi", "always", 10);
		assertTrue(discografia.numeroDeCDs() == 3);
	}

	@Test
	public void TestaAdicionaCDs() {
		assertEquals(0, colecaoDeCDs.size());
		CD cd2 = new CD(artista, titulo, numFaixas);
		colecaoDeCDs.add(cd);
		colecaoDeCDs.add(cd2);
		discografia.adicionaCDs(colecaoDeCDs);
		assertTrue(discografia.numeroDeCDs() == 2);
		colecaoDeCDs.add(cd);
		/*
		 * a colecao está com 3 CDs agora e como ja tinha adicionado 2 CDs
		 * anteriormente e agora adicionando a mesma colecao com 3 CDs, A outra
		 * colecao vai ficar 5.
		 */
		discografia.adicionaCDs(colecaoDeCDs);
		assertTrue(discografia.numeroDeCDs() == 5);
	}

	@Test
	public void TestaRemoveCD() {
		assertTrue(discografia.numeroDeCDs() == 0);
		discografia.adicionaCD("bon jovi", "bed of roses", 10);
		assertTrue(discografia.numeroDeCDs() == 1);
		assertFalse(discografia.numeroDeCDs() == 0);
		discografia.removeCD("bed of roses");
		assertTrue(discografia.numeroDeCDs() == 0);
		discografia.adicionaCD("bon jovi", "always", 10);
		discografia.adicionaCD("bon jovi", "always", 10);
		assertTrue(discografia.numeroDeCDs() == 2);
	}

	@Test
	public void TestaRemoveCDs() {
		assertEquals(0, colecaoDeCDs.size());
		ArrayList<CD> outraColecao = new ArrayList<CD>();

		CD cd2 = new CD("maria", "rua nova", 5);
		CD cd3 = new CD("zeca baleiro", "telegrama", 5);

		colecaoDeCDs.add(cd);
		colecaoDeCDs.add(cd2);
		discografia.adicionaCDs(colecaoDeCDs);
		assertTrue(discografia.numeroDeCDs() == 2);
		discografia.removeCDs(colecaoDeCDs);
		assertTrue(discografia.numeroDeCDs() == 0);

		discografia.adicionaCDs(colecaoDeCDs);
		outraColecao.add(cd);
		outraColecao.add(cd3);
		discografia.removeCDs(outraColecao);
		assertTrue(discografia.numeroDeCDs() == 1);
	}

	@Test
	public void TestaPesquisaCD() {
		CD cd1 = new CD("bon jovi", "bed of roses", 10);
		CD cd2 = new CD("bon jovi", "always", 10);
		assertTrue(discografia.numeroDeCDs() == 0);
		discografia.adicionaCD("bon jovi", "bed of roses", 10);
		assertTrue(discografia.numeroDeCDs() == 1);
		discografia.adicionaCD("bon jovi", "always", 10);
		assertTrue(discografia.numeroDeCDs() == 2);
		discografia.adicionaCD("bon jovi", "lixo", 10);
		assertTrue(discografia.numeroDeCDs() == 3);
		assertEquals(cd1, discografia.pesquisaCD("bed of roses"));
		assertEquals(cd2, discografia.pesquisaCD("always"));
		assertEquals(null, discografia.pesquisaCD("amor animal"));
		assertEquals(null, discografia.pesquisaCD("amor animal 2.0"));
	}

	@Test
	public void TestaNumeroDeCDs() {
		assertTrue(discografia.numeroDeCDs() == 0);
		discografia.adicionaCD("bon jovi", "bed of roses", 10);
		assertTrue(discografia.numeroDeCDs() == 1);
		discografia.adicionaCD("bon jovi", "always", 10);
		assertTrue(discografia.numeroDeCDs() == 2);
		discografia.adicionaCD("bon jovi", "lixo", 10);
		assertTrue(discografia.numeroDeCDs() == 3);
		discografia.removeCD("bed of roses");
		assertTrue(discografia.numeroDeCDs() == 2);
		discografia.removeCD("bed of rosas");
		assertTrue(discografia.numeroDeCDs() == 2);
		discografia.removeCD("bed of roses");
		assertTrue(discografia.numeroDeCDs() == 2);
		discografia.removeCD("always");
		assertTrue(discografia.numeroDeCDs() == 1);
		discografia.removeCD("lixo");
		assertTrue(discografia.numeroDeCDs() == 0);
	}

	@Test
	public void TestaToString() {
		CD cd1 = new CD("bon jovi", "bed of roses");
		CD cd2 = new CD("bon jovi", "bed of rosas");
		ArrayList<CD> colecao = new ArrayList<CD>();
		colecao.add(cd1);
		colecao.add(cd2);
		discografia.adicionaCDs(colecao);
		
		String resultadoEsperado = "Artista: " + cd1.getArtista() + "\nTitulo: " + cd1.getTitulo() + "\n" +
				"Artista: " + cd2.getArtista() + "\nTitulo: " + cd2.getTitulo() + "\n";
		assertEquals(resultadoEsperado, discografia.toString());
	}
}
