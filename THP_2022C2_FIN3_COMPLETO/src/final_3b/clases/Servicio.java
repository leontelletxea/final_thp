package final_3b.clases;

public class Servicio {

	private String nombre;
	private int comprobante;
	private double importe;

	public Servicio(String nombre, int comprobante, double importe) {
		this.setNombre(nombre);
		this.setComprobante(comprobante);
		this.setImporte(importe);
	}
	public double getComprobante() {
		return comprobante;
	}
	public double getImporte() {
		return importe;
	}
	public String getNombre() {
		return nombre;
	}
	private void setComprobante(int comprobante) {
		this.comprobante = comprobante;
	}
	private void setImporte(double importe) {
		this.importe = importe;
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String toString() {
		return "Servicio [nombre=" + nombre + ", comprobante=" + comprobante + ", importe=" + importe + "]";
	}
}
