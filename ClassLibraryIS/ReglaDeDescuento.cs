using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClassLibraryIS
{
    public class ReglaDeDescuento
    {

        private double porcentajeMenor = 0.03d;
        private double porcentajeIntermedio = 0.05d;
        private double porcentajeMayor = 0.10d;


        public double Calcular(double total)
        {
            if (total <= 0)
                throw new Exception("El total debe ser mayor a 0");

            if (total > 5000 && total <= 10000)
            {
                return total * porcentajeMenor;
            }
            if (total > 10000 && total <= 25000)
            {
                return total * porcentajeIntermedio;
            }
            else if (total > 25000)
            {
                return total * porcentajeMayor;
            }
            return 0;
        }
    }
}
