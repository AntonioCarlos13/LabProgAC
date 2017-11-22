package MeuPacote;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*Antonio Carlos*/
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaCD {
	private String artista = "Jose";
	private String titulo = "Segredo";
	private final int numFaixas = 5;
	private CD cd;

	@Before
	public void criaObjetos() {
		cd = new CD(artista, titulo, numFaixas);
	}

	@Test
	public void TestaCriaCD() {
		try {
			new CD(null, "peixe");
			Assert.fail("Esperava excecao, pois o artista é nulo.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Titulo ou artista nulo", e.getMessage());
		}

		try {
			new CD("joao", null);
			Assert.fail("Esperava excecao, pois o titulo é nulo.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Titulo ou artista nulo", e.getMessage());
		}

		try {
			new CD(null, null);
			Assert.fail("Esperava excecao, pois o artista e o titulo são nulos.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Titulo ou artista nulo", e.getMessage());
		}

		try {
			new CD("", "peixe");
			Assert.fail("Esperava excecao, pois o artista é vazio.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Titulo ou artista vazios", e.getMessage());
		}

		try {
			new CD("joaquim", "");
			Assert.fail("Esperava excecao, pois o titulo é vazio.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Titulo ou artista vazios", e.getMessage());
		}

		try {
			new CD("maria", "peixe", -1);
			Assert.fail("Esperava excecao, pois o numero de faixas é negativo.");
		} catch (Exception e) {
			Assert.assertEquals("Mensagem errada", "Quantidade de faixas inválido", e.getMessage());
		}
	}

	@Test
	public void TestaProcuraPosicao() {
		assertEquals("Segredo", cd.getTitulo());
		cd.cadastroMusica("jurema");
		cd.cadastroMusica("bed of roses");
		//CDs.add(cd);
		//assertTrue(CDs.contains(cd));
		assertEquals("jurema", cd.procuraPosicao(0));
		assertEquals("bed of roses", cd.procuraPosicao(1));
	}

	@Test
	public void TestaCadastroMusica() {
		assertTrue(cd.cadastroMusica("jurema"));
		assertTrue(cd.cadastroMusica("In these arms"));
		assertTrue(cd.cadastroMusica("always"));
		assertTrue(cd.cadastroMusica("you give love a bad name"));
		assertTrue(cd.cadastroMusica("daniela"));
		assertFalse(cd.cadastroMusica("juliana"));
		assertFalse(cd.cadastroMusica("daniela"));
		assertFalse(cd.cadastroMusica("these days"));
	}
	
	@Test
	public void TestaToString() {
		assertEquals("Artista: " + artista + "\nTitulo: " + titulo + 
				"\nNumero de faixas: " + numFaixas , cd.toString());
	}
	@Test
	public void TestaSetTrilhaPrincipal() {
		assertEquals(null, cd.getTrilhaPrincipal());
		cd.setTrilhaPrincipal("Hoje a noite");
		assertEquals("Hoje a noite", cd.getTrilhaPrincipal());
		cd.setTrilhaPrincipal("always");
		assertEquals("always", cd.getTrilhaPrincipal());
	}

	@Test
	public void testaEquals() {
		CD outroCD = null;
		try {
			outroCD = new CD(artista, titulo, 5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(cd.equals(outroCD));
		cd.cadastroMusica("jurema");
		Assert.assertFalse(cd.equals(outroCD));
		outroCD.cadastroMusica("jurema");
		Assert.assertTrue(cd.equals(outroCD));
		
		cd.cadastroMusica("always");
		Assert.assertFalse(cd.equals(outroCD));
		outroCD.cadastroMusica("always");
		Assert.assertTrue(cd.equals(outroCD));
		
		cd.cadastroMusica("In these arms");
		Assert.assertFalse(cd.equals(outroCD));
		outroCD.cadastroMusica("In these arms");
		Assert.assertTrue(cd.equals(outroCD));
	}
}