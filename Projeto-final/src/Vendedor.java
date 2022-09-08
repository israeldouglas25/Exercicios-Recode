
public class Vendedor {
	private int id;
	private String nome;
	private double salario;
	private double comissao;

	public Vendedor(int id, String nome, double salario, double comissao) {

		this.id = id;
		this.nome = nome;
		this.salario = salario;
		this.comissao = comissao;
	}

	public Vendedor() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	public double caucularComissao() {
		return this.comissao = salario * 0.07;
	}

}
