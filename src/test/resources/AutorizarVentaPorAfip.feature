Feature: Autorizar venta por la AFIP
  Como vendedor
  Quiero autorizar la venta a traves de la AFIP
  Para cumplir con las normativas fiscales

  Scenario Outline: Autorizar Venta a traves de AFIP
    Given una venta en curso en estado pendiente
    When solicito autorizacion a la AFIP
    And recibo "<respuesta>"
    Then La venta pasa a "<estado>"
    Examples:
      | respuesta                          | estado    |
      | Aprobacion                         | APROBADA  |
      | Rechaza                            | RECHAZADA |
      | Solicitud de informacion adicional | RECHAZADA |
      | Proceso pendiente                  | RECHAZADA |
      | Consulta o aclaración              | RECHAZADA |

