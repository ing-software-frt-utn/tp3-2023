Feature: Pago en Efectivo
Como vendedor 
Quiero registrar un pago en efectivo 
Para concretar una venta 


Scenario: Monto sea inferior a $92700
Given una venta con los datos:
  |numero|  fecha   |     estado      |
  |1     |15/02/2023|Pendiente de pago|
And el monto total de la venta es 52320.0
When selecciono pago en efectivo
Then la venta pasa al estado "Pagada"


