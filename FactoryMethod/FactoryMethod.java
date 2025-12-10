package FactoryMethod;

public class FactoryMethod {

    public interface DescuentoStrategy {
        double aplicarDescuento(double precio);
    }

    public static class DescuentoPorcentaje implements DescuentoStrategy {
        private double porcentaje;

        public DescuentoPorcentaje(double porcentaje) {
            this.porcentaje = porcentaje;
        }

        @Override
        public double aplicarDescuento(double precio) {
            return precio - (precio * porcentaje / 100.0);
        }
    }

    public static class DescuentoFijo implements DescuentoStrategy {
        private double monto;

        public DescuentoFijo(double monto) {
            this.monto = monto;
        }

        @Override
        public double aplicarDescuento(double precio) {
            return precio - monto;
        }
    }

    public static class SinDescuento implements DescuentoStrategy {
        @Override
        public double aplicarDescuento(double precio) {
            return precio;
        }
    }

    public static class Miscelanea {
        private DescuentoStrategy descuentoStrategy;

        public Miscelanea(DescuentoStrategy descuentoStrategy) {
            this.descuentoStrategy = descuentoStrategy;
        }

        public void setDescuentoStrategy(DescuentoStrategy descuentoStrategy) {
            this.descuentoStrategy = descuentoStrategy;
        }

        public double precioConDescuento(double precioOriginal) {
            return descuentoStrategy.aplicarDescuento(precioOriginal);
        }
    }

    public static void main(String[] args) {

        Miscelanea miscelanea = new Miscelanea(new SinDescuento());
        double precio = 100.0;

        System.out.println("precio sin el descuento: " + miscelanea.precioConDescuento(precio));

        miscelanea.setDescuentoStrategy(new DescuentoPorcentaje(20));
        System.out.println("precio con 20% descuento quedaría en: " + miscelanea.precioConDescuento(precio));

        miscelanea.setDescuentoStrategy(new DescuentoFijo(15));
        System.out.println("precio con el descuento fijo de 15: " + miscelanea.precioConDescuento(precio));
    }
}