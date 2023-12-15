package tp3_soft;

public class Producto {
	
    private String codigo;
    private String talle;
    private String color;
    private int stock;

    public Producto(String codigo, String talle, String color, int stock) {
        this.codigo = codigo;
        this.talle = talle;
        this.color = color;
        this.stock = stock;
    }

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}