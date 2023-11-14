namespace ReglaDescuentoConsigna
{
    public class ReglaDeDescuento
    {
        private static readonly double PorcentajeMenor = 0.03d;
        private static readonly double PorcentajeIntermedio = 0.05d;
        private static readonly double PorcentajeMayor = 0.10d;

        public double Calcular(double total)
        {
            if (total <= 0)
            {
                throw new ArgumentException("El total debe ser mayor a 0");
            }

            if (total > 5000 && total <= 10000)
            {
                return total * PorcentajeMenor;
            }
            else if (total > 10000 && total <= 25000)
            {
                return total * PorcentajeIntermedio;
            }
            else if (total > 25000)
            {
                return total * PorcentajeMayor;
            }

            return 0;
        }
    }

}