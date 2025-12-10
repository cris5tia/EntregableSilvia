public class Main {
    public static void main(String[] args) {
        Configuracion c1 = Configuracion.getInstance();
        System.out.println(c1.getIdioma());

        c1.setIdioma(" inglés ");

        Configuracion c2 = Configuracion.getInstance();
        System.out.println(c2.getIdioma());

    }
}