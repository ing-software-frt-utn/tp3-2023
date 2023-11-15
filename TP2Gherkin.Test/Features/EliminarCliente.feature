Feature: EliminarCliente

A short summary of the feature

@tag1
Scenario: ClienteEliminadoConExito
	Given  existen los siguientes clientes:
	| CUIT/CUIL			   | Nombre		| Apellido		| Direccion		| Razon Social   |
	| 20-11.222.444-0      | Juan		| Perez			| Jujuy 4000    | Monotributista |
	| 27-11.222.333-1      | Maria		| del Valle     | Calle 10      | Responsable I  |
	When se introduce el CUIT "20-11.222.444-0" para su eliminacion
	Then el sistema muestra el siguiente mensaje: "Cliente eliminado con exito"
