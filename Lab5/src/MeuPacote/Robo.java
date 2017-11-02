package MeuPacote;

/*Antonio Carlos*/
public class Robo {
	/**
	 * Classe Robô
	 *
	 * @author Antônio Carlos
	 * @version 1.0 31 de Outubro de 2017
	 */
	private Sala sala;
	private Integer energia;
	private Integer linha;
	private Integer coluna;
	private Integer passos = 0;

	// construtor
	/**
	 * Cria um robô a partir de uma sala e de sua energia.
	 * 
	 * @param sala
	 *            Corresponde a sala que o robô ficará.
	 * @param energia
	 *            Corresponde a quantidade de energia do robô.
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

	// métodos
	/**
	 * Movimenta o Robô para a frente.
	 * 
	 * @param linha
	 *            Corresponde a linhas da sala que deseja caminhar.
	 * @param coluna
	 *            Corresponde a coluna da sala que deseja caminhar.
	 * @param energia
	 *            Corresponde a energia do robô.
	 * @param sala
	 *            Corresponde a sala que o robô está.
	 * @return Se conseguiu movimentar o robô para frente.
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
	 * Movimenta o Robô para trás.
	 * 
	 * @param linha
	 *            Corresponde a linhas da sala que deseja caminhar.
	 * @param coluna
	 *            Corresponde a coluna da sala que deseja caminhar.
	 * @param energia
	 *            Corresponde a energia do robô.
	 * @param sala
	 *            Corresponde a sala que o robô está.
	 * @return Se conseguiu movimentar o robô para trás.
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
	 * Movimenta o Robô para a esquerda.
	 * 
	 * @param linha
	 *            Corresponde a linhas da sala que deseja caminhar.
	 * @param coluna
	 *            Corresponde a coluna da sala que deseja caminhar.
	 * @param energia
	 *            Corresponde a energia do robô.
	 * @param sala
	 *            Corresponde a sala que o robô está.
	 * @return Se conseguiu movimentar o robô para esquerda.
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
	 * Movimenta o Robô para a direita.
	 * 
	 * @param linha
	 *            Corresponde a linhas da sala que deseja caminhar.
	 * @param coluna
	 *            Corresponde a coluna da sala que deseja caminhar.
	 * @param energia
	 *            Corresponde a energia do robô.
	 * @param sala
	 *            Corresponde a sala que o robô está.
	 * @return Se conseguiu movimentar o robô para direita.
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
	 * Recupera o numero de linhas da sala que o robô ocupa.
	 * 
	 * @return o numero de linhas da sala.
	 */
	public Integer getLinha() {
		return linha;
	}

	/**
	 * Recupera o numero de linhas da sala que o robô ocupa.
	 * 
	 * @return o numero de linhas da sala.
	 */
	public Integer getColuna() {
		return coluna;
	}

	/**
	 * Recupera a energia do robô.
	 * 
	 * @return a quantidade de energia do robô.
	 */
	public int getEnergia() {
		return energia;
	}

	/**
	 * Recupera o numero de passos do robô.
	 * 
	 * @return o numero de passos.
	 */
	public int getPassos() {
		return passos;
	}

	/**
	 * Coloca o robô na primeira posição livre.
	 * 
	 * @return Se conseguiu colocar o robô na sala ou não.
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
	 * Verifica se a sala está cheia
	 * 
	 * @param sala
	 *            Corresponde a sala que será verificada.
	 * @return Se a sala está cheia ou não.
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
