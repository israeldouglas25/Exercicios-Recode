
public class Produto {
	private int id;
	private String descricao;
	private double valor;

	public Produto(int id, String descricao, double valor) {

		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
	}

	public Produto() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void atualizarValor(double percentual) {
		valor += (valor / 100 * percentual);
	}

}
