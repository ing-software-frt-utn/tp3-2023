Feature: BuscarProducto

A short summary of the feature

@tag1
Scenario: BuscarProductoExistente
	Given existen los siguientes productos:
	| codigo | color	| talle | stock |
	| 100	 | Naranja	| M		| 10	|
	| 200	 | Rojo		| L		| 5		|
	| 300	 | Naranja	| M		| 3		|
	When se introduce el codigo 100
	Then el sistema muestra :
	| 100	 | Naranja	| M		| 10	|


Scenario: BuscarProductoInexistente
	Given existen los siguientes productos:
	| codigo | color	| talle | stock |
	| 100	 | Naranja	| M		| 10	|
	| 200	 | Rojo		| L		| 5		|
	| 300	 | Naranja	| M		| 3		|
	When se introduce el codigo 101
	Then el sistema muestra el siguiente mensaje de error: "Producto inexistente"