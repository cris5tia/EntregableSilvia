public class Configuracion {
    private static Configuracion instancia;
    private String idioma;

    private Configuracion() {
        idioma = "  español ";
    }

    public static Configuracion getInstance() {
        if (instancia == null) {
            instancia = new Configuracion();
        }
        return instancia;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}
