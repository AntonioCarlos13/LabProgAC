package MeuPacote;

// Antonio Carlos
import java.util.ArrayList;

/**
 * Classe MinhaCDteca
 *
 * @author Ant�nio Carlos
 * @version 1.0 21 de Novembro de 2017
 */
public class MinhaCDteca {
	private ArrayList<CD> CDs = new ArrayList<CD>();

	/**
	 * Adiciona um CD a cole��o.
	 * 
	 * @param artista
	 *            Corresponde ao nome do artista do CD.
	 * @param titulo
	 *            Corresponde ao t�tulo do CD.
	 * @param numFaixas
	 *            Corresponde a quantidade de faixas que o CD tem.
	 */
	public void adicionaCD(String artista, String titulo, int numFaixas) {
		CD cd = new CD(artista, titulo, numFaixas);
		CDs.add(cd);
	}

	/**
	 * Adiciona uma cole��o de CDs dentro de outra cole��o de CDs.
	 * 
	 * @param colecaoCD
	 *            Corresponde a cole��o que vai ser inserida em outra cole��o de
	 *            CDs.
	 */
	public void adicionaCDs(ArrayList<CD> colecaoCD) {
		CDs.addAll(colecaoCD);
	}

	/**
	 * Remove um CD da cole��o.
	 * 
	 * @param titulo
	 *            Corresponde ao t�tulo do CD.
	 * @return O CD removido ou null se n�o encontrar.
	 */
	public CD removeCD(String titulo) {
		for (CD cd : CDs) {
			if (cd.getTitulo().equals(titulo))
				CDs.remove(cd);
			return cd;
		}
		return null;
	}

	/**
	 * Remove uma cole��o CD de outra cole��o de CDs.
	 * 
	 * @param colecaoCD
	 *            Corresponde a cole��o que vai ser removida de outra cole��o de
	 *            CDs.
	 * @return Se o CD foi removido ou n�o.
	 */
	public boolean removeCDs(ArrayList<CD> colecaoCD) {
		boolean result = false;
		if(CDs.containsAll(colecaoCD)){
			CDs.removeAll(colecaoCD);
		}
		for (CD cd : this.CDs) {
			for (CD cd1 : colecaoCD) {
				if(cd.equals(cd1)){
					this.CDs.remove(cd);
					result = true;
				}
			}
		}
		return result;
	}

	/**
	 * Procura um CD da cole��o.
	 * 
	 * @param titulo
	 *            Corresponde ao t�tulo do CD.
	 * @return O CD procurado ou null;.
	 */
	public CD pesquisaCD(String titulo) {
		for (CD cd : CDs) {
			if (cd.getTitulo().equals(titulo))
				return cd;
		}
		return null;
	}

	/**
	 * Calcular o numero de CDs da cole��o.
	 * 
	 * @return O n�mero de CDs existentes na cole��o.
	 * 
	 */
	public int numeroDeCDs() {
		return CDs.size();
	}

	/**
	 * Concatena��o das informa��es dos CDs da cole��o.
	 * 
	 * @return Uma String que representa a cole��o de CDs
	 * 
	 */
	@Override
	public String toString() {
		String resultado = "";
		for (CD cd : CDs) {
			resultado += "Artista: " + cd.getArtista() + "\nTitulo: " + cd.getTitulo() + "\n";
		}
		return resultado;
	}

}
