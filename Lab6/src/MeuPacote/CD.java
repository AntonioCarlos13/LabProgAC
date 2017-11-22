package MeuPacote;

import java.util.ArrayList;

//Aluno: Antonio Carlos
/**
 * Classe CD
 *
 * @author Antônio Carlos
 * @version 1.0 21 de Novembro de 2017
 */
public class CD {

	private String artista;
	private String titulo;
	private String trilhaPrincipal;
	private int numFaixas;
	private ArrayList<String> musicas;
	// construtor
		/**
		 * Cria um CD a partir de um artista, do título do CD e da quantidade de faixas.
		 * 
		 * @param artista
		 *            Corresponde ao nome do artista do CD.
		 * @param titulo
		 *            Corresponde ao título do CD.
		 * @param faixas
		 * 			  Corresponde a quantidade de faixas que o CD tem.
		 */
	public CD(String artista, String titulo, int faixas) {
		if (titulo == null || artista == null) {
			throw new NullPointerException("Titulo ou artista nulo");
		}
		if (artista.trim().equals("") || titulo.trim().equals("")) {
			throw new IllegalArgumentException("Titulo ou artista vazios");
		}
		if (faixas <= 0) {
			throw new IllegalArgumentException("Quantidade de faixas inválido");
		}

		this.artista = artista;
		this.titulo = titulo;
		this.numFaixas = faixas;
		this.musicas = new ArrayList<String>();
	}
	//Construtor
	/**
	 * Cria um CD a partir de um artista e do título do CD.
	 * 
	 * @param titulo
	 *            Corresponde ao título do CD.
	 * @param artista
	 *            Corresponde ao nome do artista do CD.
	 */
	public CD(String titulo, String artista) {
		if (titulo == null || artista == null) {
			throw new NullPointerException("Titulo ou artista nulo");
		}
		if (artista.trim().equals("") || titulo.trim().equals("")) {
			throw new IllegalArgumentException("Titulo ou artista vazios");
		}

		this.artista = artista;
		this.titulo = titulo;
		this.numFaixas = 10;
		this.musicas = new ArrayList<String>();
	}
	// métodos
		/**
		 * Recupera a trilha principal de um CD.
		 * 
		 * @return O nome da trilha principal do CD.
		 */
	public String getTrilhaPrincipal() {
		return trilhaPrincipal;
	}
	/**
	 * Altera a trilha principal de um CD.
	 * 
	 */
	public void setTrilhaPrincipal(String trilhaPrincipal) {
		this.trilhaPrincipal = trilhaPrincipal;
	}
	/**
	 * Recupera o artista de um CD.
	 * 
	 * @return O nome do artista de um CD.
	 */
	public String getArtista() {
		return artista;
	}
	/**
	 * Recupera o titulo de um CD.
	 * 
	 * @return O nome do titulo de um CD.
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * Recupera o numero de faixas de um CD.
	 * 
	 * @return A quantidade de faixas que um CD possui.
	 */
	public int getNumFaixas() {
		return numFaixas;
	}
	/**
	 * Procura a i-ésima faixa de um CD.
	 * 
	 * @return A i-ésima faixa do CD.
	 */
	public String procuraPosicao(Integer i) {
		if (i >= 0 && getNumFaixas() >= i) {
			return musicas.get(i);
		} else {
			return null;
		}
	}
	/**
	 * Cadastro das faixas de músicas do CD.
	 * 
	 * @param nomeFaixa
	 *            Corresponde ao nome da faixa a ser adicionada na lista de CDs.
	 * @return Se conseguiu inserir a faixa no CD ou não.
	 */
	public boolean cadastroMusica(String nomeFaixa) {
		boolean result = false;
		if (musicas.size() < getNumFaixas() && !musicas.contains(nomeFaixa)) {
			musicas.add(nomeFaixa);
			result = true;
		}
		return result;
	}

	/**
	 * Concatenação das informações de CD.
	 * 
	 * @return Uma String que apresenta as informações do CD.
	 * */
	@Override
	public String toString() {
		String result = "Artista: " + artista + "\nTitulo: " + titulo + 
					"\nNumero de faixas: " + numFaixas;
		return result;
	}
	//equals: para comparar dois CDs. CDs são considerados iguais se tiverem o mesmo autor e título;
	/**
	 * Muda o id do objeto para ficar comparável.
	 * 
	 * @return O id do objeto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((musicas == null) ? 0 : musicas.hashCode());
		result = prime * result + numFaixas;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		result = prime * result + ((trilhaPrincipal == null) ? 0 : trilhaPrincipal.hashCode());
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
		CD other = (CD) obj;
		if (artista == null) {
			if (other.artista != null)
				return false;
		} else if (!artista.equals(other.artista))
			return false;
		if (musicas == null) {
			if (other.musicas != null)
				return false;
		} else if (!musicas.equals(other.musicas))
			return false;
		if (numFaixas != other.numFaixas)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (trilhaPrincipal == null) {
			if (other.trilhaPrincipal != null)
				return false;
		} else if (!trilhaPrincipal.equals(other.trilhaPrincipal))
			return false;
		return true;
	}
}