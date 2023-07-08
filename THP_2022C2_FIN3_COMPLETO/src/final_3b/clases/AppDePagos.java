package final_3b.clases;

public class AppDePagos {

	private Usuario usuario;

	public AppDePagos() {
		this.usuario = null;
	}

	/**
	 * Agrega saldo de caja (disponible para pagar servicios). Debe ser mayor que
	 * cero.
	 * 
	 * @param monto - El monto a agregar
	 * @return El resultado de la operacion
	 */
	public Resultado agregarSaldo(double monto) {
		Resultado resultado = Resultado.ERROR_EN_MONTO;
		if (monto > 0) {
			if (usuario == null) {
				resultado = Resultado.USUARIO_SIN_ASIGNAR;
			} else {
				resultado = usuario.agregarSaldo(monto);
			}
		}
		return resultado;
	}

	/**
	 * Agrega un servicio a pagar. Debe chequearse que el mismo no exista en la
	 * lista de impagos. En caso de que exista debe devolver SERVICIO DUPLICADO
	 * (sino OK).
	 * 
	 * @param nombre      - El nombre del servicio
	 * @param comprobante - El nro de comprobante
	 * @param importe     - El importe a pagar
	 * @return El resultado de la operacion
	 */
	public Resultado agregarServicioAPagar(String nombre, int comprobante, double importe) {
		Resultado resultado = Resultado.USUARIO_SIN_ASIGNAR;
		if (usuario != null) {
			resultado = usuario.agregarServicioAPagar(nombre, comprobante, importe);
		}
		return resultado;
	}

	private void mostrarErrorSinUsuario() {
		System.out.println("No hay usuario asignado");
	}

	/**
	 * Mostrar los servicios pagados por el usuario. Debe mostrar, al final, el
	 * monto total de lo abonado. Cuando la aplicacion no tiene usuario asignado
	 * muestra el mensaje relacionado a esto.
	 */
	public void mostrarServiciosPagados() {
		if (usuario != null) {
			usuario.mostrarServiciosPagados();
		} else {
			mostrarErrorSinUsuario();
		}
	}

	/**
	 * Pagar un servicio, chequeando que tanto el usuario como el servicio existan y
	 * que alcance el saldo. En caso de fallar debe devolver el codigo de error
	 * correspondiente; en caso de realizar correctamente el pago ademas del OK el
	 * servicio debe quedar entre los pagados.
	 * 
	 * @param nombreServicio - El nombre del servicio a pagar
	 * @return El resultado de la operacion.
	 */
	public Resultado pagarServicio(String nombreServicio) {
		Resultado resultado = Resultado.USUARIO_SIN_ASIGNAR;
		if (usuario != null) {
			resultado = usuario.pagoServicio(nombreServicio);
		}
		return resultado;
	}

	/**
	 * Asigna el usuario que usa la aplicacion: debe crearlo siempre y cuando no
	 * haya otro usuario registrado previamente. En caso de que la aplicacion ya
	 * tenga un usuario registrado el debe devolver el mensaje de error
	 * correspondiente.
	 * 
	 * @param cuil - CUIL/CUIT del usuario
	 * @param nombre - Nombre del usuario
	 * @return El resultado de la operacion.
	 */
	public Resultado registrarUsuario(String cuil, String nombre) {
		return registrarUsuario(cuil, nombre, 0);
	}

	/**
	 * Asigna el usuario que usa la aplicacion: debe crearlo siempre y cuando no
	 * haya otro usuario registrado previamente. En caso de que la aplicacion ya
	 * tenga un usuario registrado el debe devolver el mensaje de error
	 * correspondiente.
	 * 
	 * @param cuil - CUIL/CUIT del usuario
	 * @param nombre - Nombre del usuario
	 * @param saldoInicial - Dinero depositado inicialmente
	 * @return El resultado de la operacion.
	 */
	public Resultado registrarUsuario(String cuil, String nombre, double saldoInicial) {
		Resultado resultado = Resultado.USUARIO_YA_EXISTENTE;
		if (usuario == null) {
			usuario = new Usuario(cuil, nombre, saldoInicial);
			resultado = Resultado.OPERACION_OK;
		}
		return resultado;
	}

}