package Aula10;


public class No {
	
	private Integer elemento;
	private No proximo;
	private No anterior;
	
	
	
	public No(Integer elemento) {
		super();
		this.elemento = elemento;
		this.proximo = null;
		this.anterior = null;
		
	}
	
	
	
	public Integer getElemento() {
		return elemento;
	}
	public void setElemento(Integer elemento) {
		this.elemento = elemento;
	}
	public No getProximo() {
		return proximo;
	}
	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
	public No getAnterior() {
		return anterior;
	}
	public void setAnterior(No anterior) {
		this.anterior = anterior;
	}
	
	

}
