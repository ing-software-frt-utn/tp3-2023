Feature: Buscar Producto

  Como vendedor

  Quiero poder buscar un producto

  Para agregarlo a la línea de venta


  Scenario: Buscar producto existente

    Given que existen los siguientes productos:

      | código | color | talle | tipo de talle | marca  | stock | categoría | precio |

      | 001    | rojo  | S     | internacional | Nike   | 15    | remera    | $8000  |

      | 001    | rojo  | M     | internacional | Nike   | 10    | remera    | $9000  |

      | 002    | verde | L     | internacional | Puma   | 0     | remera    | $5000  |

      | 003    | verde | L     | internacional | Adidas | 6     | pantalón  | $6000  |

      | 003    | verde | S     | internacional | Adidas | 0     | pantalón  | $7000  |

    When se ingresa el código “001”

    Then el sistema muestra

      | código | color | talle | tipo de talle | marca | stock | categoría | precio |

      | 001    | rojo  | S     | internacional | Nike  | 15    | remera    | $8000  |

      | 001    | rojo  | M     | internacional | Nike  | 10    | remera    | $9000  |


  Scenario: Buscar producto inexistente

    Given que existen los siguientes productos:

      | código | color | talle | tipo de talle | marca  | stock | categoría | precio |

      | 001    | rojo  | S     | internacional | Nike   | 15    | remera    | $8000  |

      | 001    | rojo  | M     | internacional | Nike   | 10    | remera    | $9000  |

      | 002    | verde | L     | internacional | Puma   | 0     | remera    | $5000  |

      | 003    | verde | L     | internacional | Adidas | 6     | pantalón  | $6000  |

      | 003    | verde | S     | internacional | Adidas | 0     | pantalón  | $7000  |

    When se ingresa el código “004”
    Then el sistema muestra el siguiente mensaje de error "Producto no encontrado"

  Scenario: Buscar producto sin stock

    Given que existen los siguientes productos:

      | código | color | talle | tipo de talle | marca  | stock | categoría | precio |

      | 001    | rojo  | S     | internacional | Nike   | 15    | remera    | $8000  |

      | 001    | rojo  | M     | internacional | Nike   | 10    | remera    | $9000  |

      | 002    | verde | L     | internacional | Puma   | 0     | remera    | $5000  |

      | 003    | verde | L     | internacional | Adidas | 6     | pantalón  | $6000  |

      | 003    | verde | S     | internacional | Adidas | 0     | pantalón  | $7000  |

    When se ingresa el código “002”
    Then el sistema muestra el siguiente mensaje de error "Producto sin stock"