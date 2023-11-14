Feature: Asociar Cliente

  Scenario: Asociar cliente existente
    Given una venta con IdVenta 1:
      | IdVenta | LineaDeVenta |
      | 1       | 123          |    
      | 1       | 124          |

    And un cliente registrado con el dni 9999
    When el vendedor asocia el cliente con DNI: 9999 a la venta con idVenta: 1
    Then se muestra la venta 1 con el cliente 9999 asociado
    | IdVenta | LineaDeVenta | Cliente |
    | 1       | 123          | 9999    |
    | 1       | 124          | 9999    |



  Scenario: Asociar cliente que no existe
    Given una venta con IdVenta 1:
      | IdVenta | LineaDeVenta |
      | 1       | 123          |    
      | 1       | 124          |

    And los cliente registrados:
    | dni  |
    | 9999 |

    When el vendedor intenta asociar el cliente con DNI: 1111 a la venta con idVenta: 1
    Then se muestra mensaje de error que el cliente con DNI 1111 no existe
