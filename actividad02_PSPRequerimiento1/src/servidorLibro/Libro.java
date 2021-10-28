package servidorLibro;

public class Libro {
	
	private String isbn;
	private String autor;
	private String titulo;
	private int precio;
	
	public Libro(String isbn, String autor, String titulo, int precio) {
		super();
		this.isbn = isbn;
		this.autor = autor;
		this.titulo = titulo;
		this.precio = precio;
		
	}

	public Libro() {
		// TODO Auto-generated constructor stub
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "libro [isbn=" + isbn + ", autor=" + autor + ", titulo=" + titulo + ", precio=" + precio + "]";
	}
	
	
	
	
	
	

}
