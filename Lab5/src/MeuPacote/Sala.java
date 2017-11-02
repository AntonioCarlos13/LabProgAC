package MeuPacote;

/*Antonio Carlos*/
import java.util.Arrays;

/**
 * Classe Sala
 *
 * @author Antônio Carlos
 * @version 1.0 31 de Outubro de 2017
 */
public class Sala {

	private int numLinhas;
	private int numColunas;
	public static final String OCUPADO = "1";
	public static final String LIVRE = "0";
	private Object[][] arraySala;

	// construtor
	/**
	 * Cria uma sala a partir do numero de linhas e do numero de colunas.
	 * 
	 * @param numLinhas
	 *            Corresponde a quantidade de linhas da sala.
	 * @param numColunas
	 *            Corresponde a quantidade de colunas da sala.
	 */
	public Sala(int numLinhas, int numColunas) {
		if (numLinhas <= 0 || numColunas <= 0) {
			throw new IllegalArgumentException("Parametros incorretos para a criacao da sala."
					+ " As dimensoes da sala devem ser representadas por valores positivos maiores que zero");
		}

		this.numLinhas = numLinhas;
		this.numColunas = numColunas;
		arraySala = new Object[numLinhas][numColunas];
	}

	// métodos
	/**
	 * Recupera o numero de linhas da sala.
	 * 
	 * @return o numero de linhas da sala.
	 */
	public int getNumPosicoesHorizontais() {
		return numLinhas;
	}

	/**
	 * Recupera o numero de colunas da sala.
	 * 
	 * @return o numero de colunas da sala.
	 */
	public int getNumPosicoesVerticais() {
		return numColunas;
	}

	/**
	 * Verifica se a sala está vazia.
	 * 
	 * @return Se a sala está vazia ou não.
	 */
	public boolean isVazia() {
		boolean result = true;

		for (int i = 0; i < numLinhas; i++) {
			for (int j = 0; j < numColunas; j++) {
				if (arraySala[i][j] != null) {
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

	/**
	 * Insere um obstáculo na sala.
	 * 
	 * @param linhas
	 *            Corresponde ao numero da linha da sala que deseja inserir o
	 *            obstáculo.
	 * @param colunas
	 *            Corresponde ao numero da coluna da sala que deseja inserir o
	 *            obstáculo.
	 * @return Se conseguiu inserir o obstáculo ou não.
	 */
	public boolean inserirObstaculo(int linhas, int colunas) {
		boolean result = false;

		if (posicaoValida(linhas, colunas)) {
			result = true;
			this.arraySala[linhas][colunas] = Sala.OCUPADO;
		}

		return result;
	}

	/**
	 * Verifica se a posição é válida.
	 * 
	 * @param linhas
	 *            Corresponde ao numero da linha da sala que deseja verificar se
	 *            é válida.
	 * @param colunas
	 *            Corresponde ao numero da coluna da sala que deseja verificar
	 *            se é válida.
	 * @return Se a posição é válida ou não.
	 */
	public boolean posicaoValida(int linhas, int colunas) {
		boolean result = true;

		if (linhas < 0 || linhas > this.numLinhas - 1) {
			result = false;
		}
		if (colunas < 0 || colunas > this.numColunas - 1) {
			result = false;
		}

		return result;
	}

	/**
	 * Verifica se a posição é livre.
	 * 
	 * @param linhas
	 *            Corresponde ao numero da linha da sala que deseja verificar se
	 *            é livre.
	 * @param colunas
	 *            Corresponde ao numero da coluna da sala que deseja verificar
	 *            se é livre.
	 * @return Se a posição é livre ou não.
	 */
	public boolean isPosicaoLivre(int linhas, int colunas) {
		if (!posicaoValida(linhas, colunas)) {
			throw new IllegalArgumentException("Posicao inexistente.");
		}

		boolean result = false;

		if (this.arraySala[linhas][colunas] == null || this.arraySala[linhas][colunas] == Sala.LIVRE) {
			result = true;
		}

		return result;
	}

	/**
	 * Muda o estado de uma posição.
	 * 
	 * @param linhas
	 *            Corresponde ao numero da linha da sala que deseja mudar o
	 *            estado.
	 * @param colunas
	 *            Corresponde ao numero da coluna da sala que deseja mudar o
	 *            estado.
	 * @param ocupado
	 *            Corresponde ao estado da sala que deseja colocar.
	 * @return Se conseguiu mudar o estado da sala ou não.
	 */
	public boolean setPosicao(int linhas, int colunas, String ocupado) {
		boolean result = false;

		if (posicaoValida(linhas, colunas)) {
			result = true;
			this.arraySala[linhas][colunas] = ocupado;
		}

		return result;
	}

	/**
	 * Muda o id do objeto para ficar comparável.
	 * 
	 * @return O id do objeto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numColunas;
		result = prime * result + numLinhas;
		result = prime * result + Arrays.deepHashCode(arraySala);
		return result;
	}

	/**
	 * Deixa o objeto comparável.
	 * 
	 * @param obj
	 *            Corresponde ao o objeto à ser comparável.
	 * 
	 * @return Se o objeto comparável ou não.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		if (numColunas != other.numColunas)
			return false;
		if (numLinhas != other.numLinhas)
			return false;
		if (!Arrays.deepEquals(arraySala, other.arraySala))
			return false;
		return true;
	}

}
