import model.Banco;
import ui.MenuUI;

public class Main {
	public static void main(String[] args) {
		Banco banco = new Banco("Banco DesafioDio");
		MenuUI menu = new MenuUI(banco);
		menu.iniciar();
	}
}
