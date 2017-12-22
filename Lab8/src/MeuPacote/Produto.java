package MeuPacote;

import java.util.ArrayList;
/**
 * Classe Produto
 *
 * @author Antônio Carlos
 * @version 1.0 22 de Dezembro de 2017
 */
public class Produto {
	private ArrayList<Opiniao> todasOpinioes;
	private Estrategias estrategia;

	public Produto() {
		todasOpinioes = new ArrayList<Opiniao>();
		estrategia = new EstrategiaSimples();
	}

	public ArrayList<Opiniao> getTodasOpinioes() {
		return todasOpinioes;
	}

	public void cadastrarOpiniao(Opiniao opiniao) {
		todasOpinioes.add(opiniao);
	}

	public void removerOpiniao(Opiniao opiniao) {
		todasOpinioes.remove(opiniao);
	}

	public String visualizarOpinioes() {
		String resultado = "";
		for (Opiniao opiniao : todasOpinioes) {
			resultado += opiniao.toString();
		}
		return resultado;
	}

	public int maiorNota() {
		if (todasOpinioes.isEmpty()) {
			throw new IllegalArgumentException("Não existe opiniao");
		}

		int resultado = -3;
		for (Opiniao opiniao : todasOpinioes) {
			if (opiniao.getNotaOpiniao() > resultado) {
				resultado = opiniao.getNotaOpiniao();
			}
		}
		return resultado;
	}

	public String comentarioMaiorNota() {
		String resultado = "";
		for (Opiniao op : todasOpinioes) {
			if (op.getNotaOpiniao() == maiorNota()) {
				resultado = op.getComentario();
				return resultado;
			}
		}
		return resultado;
	}

	public int menorNota() {
		if (todasOpinioes.isEmpty()) {
			throw new IllegalArgumentException("Não existe opiniao");
		}
		int resultado = 3;
		for (Opiniao opiniao : todasOpinioes) {
			if (opiniao.getNotaOpiniao() < resultado) {
				resultado = opiniao.getNotaOpiniao();
			}
		}
		return resultado;
	}

	public String comentarioMenorNota() {
		String resultado = "";
		for (Opiniao op : todasOpinioes) {
			if (op.getNotaOpiniao() == menorNota()) {
				resultado = op.getComentario();
				return resultado;
			}
		}
		return resultado;
	}

	public int quantidadeDeOpinioes() {
		return todasOpinioes.size();
	}

	public double notaNaMosca() {
		return estrategia.notaNaMosca(this);
	}

	public String comentariosMaisRelevantes() {
		return estrategia.comentariosMaisRelevantes(this);
	}

	public void setEstrategia(Estrategias estrategia) {
		this.estrategia = estrategia;
	}
}
