package entities;

import java.util.List;

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

        List<Researchs> pesquisas = cadastroUsuarioGUI.getResearchsList();
        for (Researchs pesquisa : pesquisas) {
            // Faça o que for necessário com as pesquisas
            System.out.println("Ticket: " + pesquisa.getAtivo().getTicket());
            System.out.println("Nome da Empresa: " + pesquisa.getAtivo().getNomeEmpresa());
            System.out.println("Valor Investido: " + pesquisa.getValorInvestido());
            System.out.println("Tempo de Trading: " + pesquisa.getTempoTranding());
            System.out.println("Retorno: " + pesquisa.getRetorno());
            System.out.println("Resultado Financeiro: " + pesquisa.getResultadoFinanceiro());
            System.out.println();
        }
    }
}