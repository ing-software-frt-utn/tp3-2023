Feature: Solicitar Autorizacion de venta a AFIP

  como vendedor
  quiero solicitar autorizacion a AFIP
  para realizar legalmente la venta

  Scenario Outline: Solicitar autorizacion a AFIP
    Given una venta en estado pendiente
    When solicito autorizacion de AFIP
    And recibo una respuesta <respuesta>
    Then la venta cambia a estado <estado>
    Examples:
      |    respuesta      | estado   |
      |     Aprobada      | Aprobado |
      | Aprobada con obs  | Aprobado |
      |    Rechazado      | Rechazado|