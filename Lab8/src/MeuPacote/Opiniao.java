package MeuPacote;

/**
 * Classe Opiniao
 *
 * @author Antônio Carlos
 * @version 1.0 22 de Dezembro de 2017
 */
public class Opiniao {

	private int notaOpiniao;
	private String comentario;
	private String dataOpiniao;

	public Opiniao(int notaOpiniao, String comentario, String dataOpiniao) {

		if (notaOpiniao < -2 || notaOpiniao > 2) {
			throw new IllegalArgumentException("Nota da opiniao fora do intervalo de avaliacao");
		}

		if (dataOpiniao == null) {
			throw new NullPointerException("Data da opiniao nula");
		}

		if (dataOpiniao.trim().equals("")) {
			throw new IllegalArgumentException("Data da opiniao vazia");
		}

		if (comentario == null) {
			throw new NullPointerException("Comentario nulo");
		}

		if (comentario.trim().equals("")) {
			throw new IllegalArgumentException("Comentario vazio");
		}

		if (comentario.split("").length > 140) {
			throw new IllegalArgumentException(
					"Comentario com o tamanho de caracteres acima da quantidade estabelecida");
		}

		this.notaOpiniao = notaOpiniao;
		this.comentario = comentario;
		this.dataOpiniao = dataOpiniao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result + ((dataOpiniao == null) ? 0 : dataOpiniao.hashCode());
		result = prime * result + notaOpiniao;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Opiniao other = (Opiniao) obj;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (dataOpiniao == null) {
			if (other.dataOpiniao != null)
				return false;
		} else if (!dataOpiniao.equals(other.dataOpiniao))
			return false;
		if (notaOpiniao != other.notaOpiniao)
			return false;
		return true;
	}

	public int getNotaOpiniao() {
		return notaOpiniao;
	}

	public String getComentario() {
		return comentario;
	}

	public String getDataOpiniao() {
		return dataOpiniao;
	}

	@Override
	public String toString() {
		String result = "Nota da opiniao: " + notaOpiniao + "\nComentario: " + comentario + "\nData da opiniao: "
				+ dataOpiniao + "\n";
		return result;
	}

}
