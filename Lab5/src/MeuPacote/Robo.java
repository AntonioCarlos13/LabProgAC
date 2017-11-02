package MeuPacote;

/*Antonio Carlos*/
public class Robo {
	/**
	 * Classe Rob�
	 *
	 * @author Ant�nio Carlos
	 * @version 1.0 31 de Outubro de 2017
	 */
	private Sala sala;
	private Integer energia;
	private Integer linha;
	private Integer coluna;
	private Integer passos = 0;

	// construtor
	/**
	 * Cria um rob� a partir de uma sala e de sua energia.
	 * 
	 * @param sala
	 *            Corresponde a sala que o rob� ficar�.
	 * @param energia
	 *            Corresponde a quantidade de energia do rob�.
	 */
	public Robo(Sala sala, int energia) {
		if (sala == null) {
			throw new NullPointerException("Sala vazia.");
		}
		if (salaCheia(sala)) {
			throw new IllegalArgumentException("Sala cheia.");
		}
		if (energia <= 0) {
			throw new IllegalArgumentException("Robo sem energia.");
		}

		this.sala = sala;
		this.energia = energia;
		iniciaRobo();
	}

	// m�todos
	/**
	 * Movimenta o Rob� para a frente.
	 * 
	 * @param linha
	 *            Corresponde a linhas da sala que deseja caminhar.
	 * @param coluna
	 *            Corresponde a coluna da sala que deseja caminhar.
	 * @param energia
	 *            Corresponde a energia do rob�.
	 * @param sala
	 *            Corresponde a sala que o rob� est�.
	 * @return Se conseguiu movimentar o rob� para frente.
	 */
	public boolean andarParaFrente() {
		boolean result = false;
		if (sala.posicaoValida(linha + 1, coluna) && sala.isPosicaoLivre(linha + 1, coluna) && energia > 0) {
			result = true;
			sala.setPosicao(linha + 1, coluna, Sala.OCUPADO);
			sala.setPosicao(linha, coluna, Sala.LIVRE);
			linha += 1;
			energia -= 1;
			passos += 1;

		}

		return result;
	}

	/**
	 * Movimenta o Rob� para tr�s.
	 * 
	 * @param linha
	 *            Corresponde a linhas da sala que deseja caminhar.
	 * @param coluna
	 *            Corresponde a coluna da sala que deseja caminhar.
	 * @param energia
	 *            Corresponde a energia do rob�.
	 * @param sala
	 *            Corresponde a sala que o rob� est�.
	 * @return Se conseguiu movimentar o rob� para tr�s.
	 */

	public boolean andarParaTras() {
		boolean result = false;
		if (sala.posicaoValida(linha - 1, coluna) && sala.isPosicaoLivre(linha - 1, coluna) && energia > 0) {
			result = true;
			sala.setPosicao(linha - 1, coluna, Sala.OCUPADO);
			sala.setPosicao(linha, coluna, Sala.LIVRE);
			linha -= 1;
			energia -= 1;
			passos += 1;

		}

		return result;
	}

	/**
	 * Movimenta o Rob� para a esquerda.
	 * 
	 * @param linha
	 *            Corresponde a linhas da sala que deseja caminhar.
	 * @param coluna
	 *            Corresponde a coluna da sala que deseja caminhar.
	 * @param energia
	 *            Corresponde a energia do rob�.
	 * @param sala
	 *            Corresponde a sala que o rob� est�.
	 * @return Se conseguiu movimentar o rob� para esquerda.
	 */
	public boolean andarParaEsquerda() {
		boolean result = false;

		if (sala.posicaoValida(linha, coluna - 1) && sala.isPosicaoLivre(linha, coluna - 1) && energia > 0) {
			result = true;
			sala.setPosicao(linha, coluna - 1, Sala.OCUPADO);
			sala.setPosicao(linha, coluna, Sala.LIVRE);
			coluna -= 1;
			energia -= 1;
			passos += 1;

		}

		return result;
	}

	/**
	 * Movimenta o Rob� para a direita.
	 * 
	 * @param linha
	 *            Corresponde a linhas da sala que deseja caminhar.
	 * @param coluna
	 *            Corresponde a coluna da sala que deseja caminhar.
	 * @param energia
	 *            Corresponde a energia do rob�.
	 * @param sala
	 *            Corresponde a sala que o rob� est�.
	 * @return Se conseguiu movimentar o rob� para direita.
	 */
	public boolean andarParaDireita() {
		boolean result = false;

		if (sala.posicaoValida(linha, coluna + 1) && sala.isPosicaoLivre(linha, coluna + 1) && energia > 0) {
			result = true;
			sala.setPosicao(linha, coluna + 1, Sala.OCUPADO);
			sala.setPosicao(linha, coluna, Sala.LIVRE);
			coluna += 1;
			energia -= 1;
			passos += 1;
		}

		return result;
	}

	/**
	 * Recupera o numero de linhas da sala que o rob� ocupa.
	 * 
	 * @return o numero de linhas da sala.
	 */
	public Integer getLinha() {
		return linha;
	}

	/**
	 * Recupera o numero de linhas da sala que o rob� ocupa.
	 * 
	 * @return o numero de linhas da sala.
	 */
	public Integer getColuna() {
		return coluna;
	}

	/**
	 * Recupera a energia do rob�.
	 * 
	 * @return a quantidade de energia do rob�.
	 */
	public int getEnergia() {
		return energia;
	}

	/**
	 * Recupera o numero de passos do rob�.
	 * 
	 * @return o numero de passos.
	 */
	public int getPassos() {
		return passos;
	}

	/**
	 * Coloca o rob� na primeira posi��o livre.
	 * 
	 * @return Se conseguiu colocar o rob� na sala ou n�o.
	 */

	private boolean iniciaRobo() {
		boolean result = false;

		for (int i = 0; i < this.sala.getNumPosicoesHorizontais(); i++) {
			for (int j = 0; j < this.sala.getNumPosicoesVerticais(); j++) {
				if (this.sala.isPosicaoLivre(i, j)) {
					this.sala.setPosicao(i, j, Sala.OCUPADO);
					this.linha = i;
					this.coluna = j;
					result = true;
					break;
				}
			}

			if (result) {
				break;
			}
		}

		return result;
	}

	/**
	 * Verifica se a sala est� cheia
	 * 
	 * @param sala
	 *            Corresponde a sala que ser� verificada.
	 * @return Se a sala est� cheia ou n�o.
	 */
	private boolean salaCheia(Sala sala) {
		boolean result = true;

		for (int i = 0; i < sala.getNumPosicoesHorizontais(); i++) {
			for (int j = 0; j < sala.getNumPosicoesVerticais(); j++) {
				if (sala.isPosicaoLivre(i, j)) {
					result = false;
					break;
				}
			}

			if (!result) {
				break;
			}
		}

		return result;
	}

	public boolean equals(Robo outroRobo, Sala outraSala) {
		return sala.equals(outraSala) && (linha == outroRobo.linha) && (coluna == outroRobo.coluna);
	}

}
