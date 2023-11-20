Feature: Autorizar venta por AFIP
  Yo como vendedor
  Quiero autoriza la venta a traves del AFIP
  Para finalizar la venta

  Scenario Outline: Autorizar Venta a traves de AFIP
    Given una venta en curso en estado pendiente
    When solicito autorizacion a la AFIP
    And recibo "<respuesta>"
    Then La venta pasa a "<estado>"
    Examples:
      | respuesta               | estado                   |
      | Aprueba                 | Aprobada                 |
      | Rechaza                 | Rechazada                |
      | ApruebaConObservaciones | AprobadaConObservaciones |

