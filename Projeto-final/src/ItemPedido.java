
public class ItemPedido {

	private int id;
	private int quantidade;
	private double valor;
	private Produto produto;

	public ItemPedido(int id, int quantidade, double valor, Produto produto) {

		this.id = id;
		this.quantidade = quantidade;
		this.valor = valor;
		this.produto = produto;
	}

	public ItemPedido() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double calcularItem() {
		return getValor() * getQuantidade();
	}
}
