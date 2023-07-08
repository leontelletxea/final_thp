package final_3b;

import final_3b.clases.AppDePagos;

public class Test {

	public static void main(String[] args) {
		AppDePagos miAppDePagos = new AppDePagos();
		
		registrarUsuario(miAppDePagos, "12-12345678-8", "Albert Essen", 10000.00);
		registrarUsuario(miAppDePagos, "12-87654321-8", "Albin Otinto", 50000.00);
		
		agregarSaldo(miAppDePagos, 3000.00);
		agregarSaldo(miAppDePagos, -3000.00);
		
		agregarServicioAPagar(miAppDePagos, "AYSA", 123, 335.45);
		agregarServicioAPagar(miAppDePagos, "FLOW", 583, 6254.80);
		agregarServicioAPagar(miAppDePagos, "FLOW", 583, 6254.80);
		agregarServicioAPagar(miAppDePagos, "AYSA", 123, 335.45);
		agregarServicioAPagar(miAppDePagos, "AYSA", 123, 335.45);

		pagarServicio(miAppDePagos, "FLOW");
		pagarServicio(miAppDePagos, "FLOW");
		pagarServicio(miAppDePagos, "PATENTE");
		
		miAppDePagos.mostrarServiciosPagados();
	}

	private static void agregarServicioAPagar(AppDePagos appDePagos, String servicio, int comprobante, double importe) {
		System.out.println("Agregar " + servicio);
		System.out.println(appDePagos.agregarServicioAPagar(servicio, comprobante, importe));
		System.out.println();
	}

	private static void pagarServicio(AppDePagos appDePagos, String servicio) {
		System.out.println("Pagar " + servicio);
		System.out.println(appDePagos.pagarServicio(servicio));		
		System.out.println();
	}

	private static void agregarSaldo(AppDePagos appDePagos, double saldo) {
		System.out.println("Agregando saldo (" + saldo +")");
		System.out.println(appDePagos.agregarSaldo(saldo));
		System.out.println();
	}

	private static void registrarUsuario(AppDePagos appDePagos, String cuil, String nombre, double saldo) {
		System.out.println("Registrando al usuario con cuil " + cuil);
		System.out.println("Nombre: " + nombre + ", Saldo: " + saldo);
		System.out.println(appDePagos.registrarUsuario(cuil, nombre, saldo));
		System.out.println();
	}

}
