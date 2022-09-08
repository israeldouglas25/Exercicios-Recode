
import java.util.Date;

public class Principal {

	public static void main(String[] args) {

		// Criando os objetos das classes cliente, vendedor e produto

		Cliente cliente = new Cliente(001, "Flavio", "2706274525");
		Vendedor vendedor = new Vendedor(001, "Joao", 3000, 10);
		Produto prod1 = new Produto(001, "Camisa", 50);
		Produto prod2 = new Produto(002, "Sapato", 150);
		Produto prod3 = new Produto(003, "Meia", 15);
		Produto prod4 = new Produto(004, "Vestido", 120);
		Produto prod5 = new Produto(005, "Bermuda", 85);

		// Criando os objetos das classes item e pedido

		ItemPedido item1 = new ItemPedido(001, 5, 85, prod5);
		ItemPedido item2 = new ItemPedido(002, 2, 50, prod2);
		ItemPedido item3 = new ItemPedido(003, 2, 120, prod4);
		ItemPedido item4 = new ItemPedido(004, 8, 120, prod4);

		Pedido pedido = new Pedido(001, new Date(), cliente, vendedor);

		pedido.AdicionaItem(item1);
		pedido.AdicionaItem(item2);
		pedido.AdicionaItem(item3);
		pedido.AdicionaItem(item4);

		System.out.println("==== Dados do pedido ============");
		System.out.println("Cliente:" + pedido.getCliente().getNome());
		System.out.println("Vendedor:" + pedido.getVendedor().getNome());
		System.out.println("Data:" + pedido.getData());

		System.out.println("===== Itens do pedido ===========");

		pedido.calcularPedido();
		pedido.mostrarPedido();

		System.out.println("");
		System.out.println("Total do pedido: " + pedido.getTotal());

	}

}
