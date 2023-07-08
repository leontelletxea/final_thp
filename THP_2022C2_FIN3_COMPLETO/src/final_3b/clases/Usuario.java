package final_3b.clases;

import java.util.ArrayList;

public class Usuario {

	private String nombre;
	private String cuil;
	private double saldo;
	private ArrayList<Servicio> serviciosPagados;
	private ArrayList<Servicio> serviciosAPagar;

	public Usuario(String cuit, String nombre, double saldo) {
		this.setCuil(cuit);
		this.setNombre(nombre);
		this.setSaldo(saldo);
		this.serviciosPagados = new ArrayList<Servicio>();
		this.serviciosAPagar = new ArrayList<Servicio>();
	}

	// actualizar saldo
	private void actualizarSaldo(double monto) {
		saldo += monto;
	}

	// agregar saldo de caja (debe ser mayor que cero)
	public Resultado agregarSaldo(double monto) {
		Resultado resultado = Resultado.ERROR_EN_MONTO;
		if (monto > 0) {
			this.actualizarSaldo(monto);
			resultado = Resultado.OPERACION_OK;
		}
		return resultado;

	}

	// agregar servicio a pagar
	public Resultado agregarServicioAPagar(String nombre, int comprobante, double importe) {
		Resultado resultado = Resultado.SERVICIO_DUPLICADO;
		Servicio servicio = this.buscarServicioAPagar(nombre);
		if (servicio == null) {
			servicio = new Servicio(nombre, comprobante, importe);
			this.serviciosAPagar.add(servicio);
			resultado = Resultado.OPERACION_OK;
		}
		return resultado;
	}

	// buscar servicio
	private Servicio buscarServicio(ArrayList<Servicio> servicios, String nombre) {
		Servicio servicioBuscado = null;
		int pos = 0;
		while (pos < servicios.size() && !servicios.get(pos).getNombre().equalsIgnoreCase(nombre))
			pos++;
		if (pos < servicios.size())
			servicioBuscado = servicios.get(pos);
		return servicioBuscado;
	}
	
	// buscar servicio a pagar
	private Servicio buscarServicioAPagar(String nombre) {
		return buscarServicio(serviciosAPagar, nombre);
	}

	public boolean mismoCuil(String cuil) {
		return this.cuil.equalsIgnoreCase(cuil);
	}

	// mostrar que servicios se pagaron y cuanto se gasto en total
	public void mostrarServiciosPagados() {
		double total = 0;
		for (Servicio servicio : serviciosPagados) {
			System.out.println("Servicio pagado: " + servicio.getNombre());
			total += servicio.getImporte();
		}
		System.out.println("Total pagado: " + total);

	}

	// Pagar servicio si hay saldo
	public Resultado pagoServicio(String nombre) {
		Resultado resultado = Resultado.SALDO_INSUFICIENTE;
		Servicio servicio = buscarServicioAPagar(nombre);

		if (servicio == null) {
			resultado = Resultado.SERVICIO_SIN_PENDIENTES;
		} else if (servicio.getImporte() <= this.saldo) {
			resultado = Resultado.OPERACION_OK;
			this.actualizarSaldo(-servicio.getImporte());
			this.serviciosPagados.add(servicio);
			this.serviciosAPagar.remove(servicio);
		}
		return resultado;
	}

	private void setCuil(String cuil) {
		this.cuil = cuil;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", cuil=" + cuil + ", saldo=" + saldo + ", serviciosPagados="
				+ serviciosPagados + ", serviciosAPagar=" + serviciosAPagar.size() + "]";
	}

}
