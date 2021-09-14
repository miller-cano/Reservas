package bean;

public class BMenu {

	private int   codigo_menu;
	private String nombre_menu;
	private int   dependencia;
	private String formulario;
	private String estado;
	private int    orden;

	public BMenu() 
	{
	this.codigo_menu = 0;
	this.nombre_menu = "";
	this.dependencia = 0;
	this.formulario  = "";
	this.estado      = "I";
	this.orden       = 1;
	}

	public int getCodigo_menu() {
		return codigo_menu;
	}

	public void setCodigo_menu(int codigo_menu) {
		this.codigo_menu = codigo_menu;
	}

	public String getNombre_menu() {
		return nombre_menu;
	}

	public void setNombre_menu(String nombre_menu) {
		this.nombre_menu = nombre_menu;
	}

	public int getDependencia() {
		return dependencia;
	}

	public void setDependencia(int dependencia) {
		this.dependencia = dependencia;
	}

	public String getFormulario() {
		return formulario;
	}

	public void setFormulario(String formulario) {
		this.formulario = formulario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

}
