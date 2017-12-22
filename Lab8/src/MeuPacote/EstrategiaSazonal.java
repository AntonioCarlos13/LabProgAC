package MeuPacote;

/**
 * Classe EstrategiaSazonal
 *
 * @author Antônio Carlos
 * @version 1.0 22 de Dezembro de 2017
 */
public class EstrategiaSazonal implements Estrategias {

	@Override
	public String comentariosMaisRelevantes(Produto produtos) {
		String comentarioMaisRelevante = "";
		if (produtos.quantidadeDeOpinioes() == 0) {
			comentarioMaisRelevante = "";
		} else {
			if (produtos.quantidadeDeOpinioes() == 1) {
				comentarioMaisRelevante = produtos.getTodasOpinioes().get(0).getComentario();
			}
			if (produtos.quantidadeDeOpinioes() >= 2) {
				comentarioMaisRelevante = produtos.getTodasOpinioes().get(produtos.quantidadeDeOpinioes() - 2)
						.getComentario() + "\n"
						+ produtos.getTodasOpinioes().get(produtos.quantidadeDeOpinioes() - 1).getComentario();
			}
		}
		return comentarioMaisRelevante;

	}

	@Override
	public double notaNaMosca(Produto produtos) {
		double result = 0;
		if (produtos.quantidadeDeOpinioes() == 0) {
			result = 0;
		} else {
			if (produtos.quantidadeDeOpinioes() >= 3) {
				for (int i = produtos.quantidadeDeOpinioes() - 3; i < produtos.quantidadeDeOpinioes(); i++) {
					result += produtos.getTodasOpinioes().get(i).getNotaOpiniao();
				}
				result /= 3;
			} else {
				for (int i = 0; i < produtos.quantidadeDeOpinioes(); i++) {
					result += produtos.getTodasOpinioes().get(i).getNotaOpiniao();
				}
				result /= produtos.quantidadeDeOpinioes();
			}

		}
		return result;
	}
}
