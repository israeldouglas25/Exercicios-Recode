
import java.util.ArrayList;
import java.util.Date;

public class Pedido {
	private int id;
	private Date data;
	private double total;
	private Cliente cliente;
	private Vendedor vendedor;

	private ArrayList<ItemPedido> itens = new ArrayList<ItemPedido>();

	public Pedido(int id, Date data, Cliente cliente, Vendedor vendedor) {

		this.id = id;
		this.data = data;
		this.cliente = cliente;
		this.vendedor = vendedor;

	}

	public Pedido() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public void AdicionaItem(ItemPedido item) {
		itens.add(item);
	}

	public void RemoveItem(ItemPedido item) {
		itens.remove(item);
	}

	public ArrayList<ItemPedido> getItens() {
		return itens;
	}

//    public void RelatorioPedido() {
//        
//    }    

	public void calcularPedido() {
		for (ItemPedido item : itens) {
			this.total += item.calcularItem();
		}

	}

	public void mostrarPedido() {
		for (ItemPedido item : itens) {
			System.out.println("Id: " + item.getId() + " QTD: " + item.getQuantidade() + " Valor unitario: "
					+ item.getValor() + " Total: " + item.calcularItem());

		}

	}

}
