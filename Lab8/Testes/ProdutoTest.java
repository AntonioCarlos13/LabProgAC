import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import MeuPacote.EstrategiaSazonal;
import MeuPacote.Opiniao;
import MeuPacote.Produto;

/**
 * Classe ProdutoTest
 *
 * @author Antônio Carlos
 * @version 1.0 22 de Dezembro de 2017
 */
class ProdutoTest {
		private Opiniao opiniao = new Opiniao(0,"I am the Batman", "01/12/2017");
		private Opiniao opiniao2 = new Opiniao(2, "bom produto", "05/05/2016");
		private Opiniao opiniao3 = new Opiniao(-1, "produto lixo", "18/06/2002");
		private Opiniao opiniao4 = new Opiniao(2, "produto bom", "06/05/2016");
		
		
		@Test
		public void TestaCadastrarOpiniao() {
			Produto produto = new Produto(); 

			assertTrue(produto.quantidadeDeOpinioes() == 0);
			produto.cadastrarOpiniao(opiniao);
			assertFalse(produto.quantidadeDeOpinioes() == 0);
			assertTrue(produto.quantidadeDeOpinioes() == 1);
			produto.cadastrarOpiniao(opiniao2);
			assertTrue(produto.quantidadeDeOpinioes() == 2);
			produto.cadastrarOpiniao(opiniao3);
			assertFalse(produto.quantidadeDeOpinioes() == 2);
			assertTrue(produto.quantidadeDeOpinioes() == 3);
		}
		
		@Test
		public void TestaMaiorNota(){
			Produto produto = new Produto(); 
			try {
				produto.maiorNota();
				Assert.fail("Esperava excecao, pois não existe nenhuma nota de opiniao.");
			} catch (Exception e) {
				Assert.assertEquals("Mensagem errada", "Não existe opiniao", e.getMessage());
			}
			produto.cadastrarOpiniao(opiniao);
			produto.cadastrarOpiniao(opiniao2);
			produto.cadastrarOpiniao(opiniao3);
			assertEquals(2, produto.maiorNota());
			produto.removerOpiniao(opiniao2);
			assertEquals(0, produto.maiorNota());
		}
		
		@Test
		public void TestaMenorNota(){
			Produto produto = new Produto(); 
			try {
				produto.maiorNota();
				Assert.fail("Esperava excecao, pois não existe nenhuma nota de opiniao.");
			} catch (Exception e) {
				Assert.assertEquals("Mensagem errada", "Não existe opiniao", e.getMessage());
			}
			produto.cadastrarOpiniao(opiniao);
			produto.cadastrarOpiniao(opiniao2);
			produto.cadastrarOpiniao(opiniao3);
			assertEquals(-1, produto.menorNota());
			produto.removerOpiniao(opiniao3);
			assertEquals(0, produto.menorNota());
		}
		
		@Test
		public void TestaNotaNaMoscaEstrategiaSimples() {
			Produto produto = new Produto();
			produto.cadastrarOpiniao(opiniao);
			produto.cadastrarOpiniao(opiniao2);
			produto.cadastrarOpiniao(opiniao4);
			double mediaAritimetica = (opiniao4.getNotaOpiniao() + opiniao2.getNotaOpiniao() + opiniao.getNotaOpiniao())/3.0;
			
			assertEquals(mediaAritimetica, produto.notaNaMosca(),0.1);  
			produto.removerOpiniao(opiniao4);
			produto.removerOpiniao(opiniao2);
			assertEquals(opiniao.getNotaOpiniao(), produto.notaNaMosca(),0.1);
		}
		
		@Test
		public void TestaComentariosMaisRelevantesEstrategiaSimples() {
			Produto produto = new Produto();
			produto.cadastrarOpiniao(opiniao);
			produto.cadastrarOpiniao(opiniao2);
			produto.cadastrarOpiniao(opiniao3);
			produto.cadastrarOpiniao(opiniao4);
			// comentários mais relevantes são o da opinião que tem a maior nota e o da opinião 
			//que tem a menor nota para aquele produto.Caso haja mais de uma opinião com a maior
			//ou com a menor nota, o mais relevante torna-se o mais antigo entre os que tem a 
			//mesma nota. 
			assertEquals(produto.comentarioMaiorNota() + "\n" + produto.comentarioMenorNota(), 
					produto.comentariosMaisRelevantes());
			
			//Caso haja apenas uma opinião, apenas o comentário desta opinião será o mais relevante.  
			produto.removerOpiniao(opiniao4);
			produto.removerOpiniao(opiniao3);
			produto.removerOpiniao(opiniao2);
			assertEquals(opiniao.getComentario(), 
					produto.comentariosMaisRelevantes());
		}
		
		@Test
		public void TestaNotaNaMoscaEstrategiaSazional() {
			Produto produto = new Produto();
			produto.cadastrarOpiniao(opiniao);
			produto.cadastrarOpiniao(opiniao2);
			produto.cadastrarOpiniao(opiniao3);
			produto.cadastrarOpiniao(opiniao4);
			produto.setEstrategia(new EstrategiaSazonal());
			
			double mediaAritimetica = (opiniao2.getNotaOpiniao() + opiniao3.getNotaOpiniao() + opiniao4.getNotaOpiniao())/3.0;
			assertEquals(mediaAritimetica, produto.notaNaMosca(),0.1);  
			
			produto.removerOpiniao(opiniao4);
			produto.removerOpiniao(opiniao3);
			produto.removerOpiniao(opiniao2);
			assertEquals(opiniao.getNotaOpiniao(), produto.notaNaMosca(),0.1);
			produto.removerOpiniao(opiniao);
			
			produto.cadastrarOpiniao(opiniao2);
			produto.cadastrarOpiniao(opiniao3);
			
			double mediaAritimetica2 = (opiniao2.getNotaOpiniao() + opiniao3.getNotaOpiniao()) / 2.0; 
			assertEquals(mediaAritimetica2, produto.notaNaMosca(),0.1);  
		}
		
		@Test
		public void TestaComentariosMaisRelevantesEstrategiaSazonal() {
			Produto produto = new Produto();
			produto.cadastrarOpiniao(opiniao);
			produto.cadastrarOpiniao(opiniao2);
			produto.cadastrarOpiniao(opiniao3);
			produto.cadastrarOpiniao(opiniao4);
			produto.setEstrategia(new EstrategiaSazonal());
			/*Os comentários mais relevantes nesse caso são sempre os das duas opiniões mais
			 *recentes cadastradas para o produto (ou apenas da última, caso haja apenas uma
			 *opinião cadastrada). 
			 */ 
			assertEquals(opiniao3.getComentario() +"\n"+ opiniao4.getComentario(), 
					produto.comentariosMaisRelevantes());
			
			//Caso haja apenas uma opinião, apenas o comentário desta opinião será o mais relevante.  
			produto.removerOpiniao(opiniao4);
			produto.removerOpiniao(opiniao3);
			produto.removerOpiniao(opiniao2);
			assertEquals(opiniao.getComentario(), 
					produto.comentariosMaisRelevantes());
		}
		
		@Test
		public void TestaVisualizarOpinioes() {
			Produto produto = new Produto();
			produto.cadastrarOpiniao(opiniao);
			produto.cadastrarOpiniao(opiniao2);
			produto.cadastrarOpiniao(opiniao3);
			produto.cadastrarOpiniao(opiniao4);
			
			assertEquals(opiniao.toString() + opiniao2.toString() + opiniao3.toString() +
					opiniao4.toString(), produto.visualizarOpinioes());
		}

}

