package entities;

public class Main {
    public static void main(String[] args) {
        CadastroUsuarioGUI cadastroUsuarioGUI = new CadastroUsuarioGUI();
        cadastroUsuarioGUI.setVisible(true);

        // Aguarda o cadastro dos três usuários
        while (cadastroUsuarioGUI.getUsuariosCadastrados() < 3) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        Usuario usuario1 = cadastroUsuarioGUI.getUsuario1();
        Usuario usuario2 = cadastroUsuarioGUI.getUsuario2();
        Usuario usuario3 = cadastroUsuarioGUI.getUsuario3();

        System.out.println("Usuário 1: " + usuario1.getNome());
        System.out.println("Usuário 2: " + usuario2.getNome());
        System.out.println("Usuário 3: " + usuario3.getNome());


    }
}