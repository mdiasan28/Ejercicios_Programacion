package Programacion;

public class carta {
	private int valor;
	private String tipo;
	private String id;
	/**
	 * @param valor
	 * @param tipo
	 * @param id
	 */
	public carta(int valor, String tipo, String id) {
		super();
		this.valor = valor;
		this.tipo = tipo;
		this.id = id;
	}
	/**
	 * @return the valor
	 */
	public int getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	
}
