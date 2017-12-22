package MeuPacote;

/**
 * Classe EstrategiaSimples
 *
 * @author Antônio Carlos
 * @version 1.0 22 de Dezembro de 2017
 */
public class EstrategiaSimples implements Estrategias {

	@Override
	public String comentariosMaisRelevantes(Produto produtos) {
		String comentarioMaisRelevante = "";
		if (produtos.quantidadeDeOpinioes() == 0) {
			comentarioMaisRelevante = "";
		} else {
			if (produtos.comentarioMaiorNota().equals(produtos.comentarioMenorNota())) {
				comentarioMaisRelevante = produtos.comentarioMaiorNota();
			} else {
				comentarioMaisRelevante = produtos.comentarioMaiorNota() + "\n" + produtos.comentarioMenorNota();
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
			for (Opiniao op : produtos.getTodasOpinioes()) {
				result += op.getNotaOpiniao();
			}
			result = result / produtos.quantidadeDeOpinioes();
		}
		return result;
	}
}
