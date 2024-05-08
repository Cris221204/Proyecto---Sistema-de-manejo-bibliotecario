public class MenuController {
    String texto;
    Controller controller;
    public Controller getController() {
        return controller;
    }
    public void setController(Controller controller) {
        this.controller = controller;
    }
    public MenuController(String texto, Controller controller) {
        this.texto = texto;
        this.controller = controller;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
}
