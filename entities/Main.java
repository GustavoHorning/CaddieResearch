package entities;

public class Main {
    public static void main(String[] args) {
        // Chama a interface gráfica para cadastrar usuários
        CadastroUsuarioGUI cadastroUsuarioGUI = new CadastroUsuarioGUI();
        cadastroUsuarioGUI.setVisible(true);
    }
}