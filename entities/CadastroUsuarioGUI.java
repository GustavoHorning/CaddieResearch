package entities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CadastroUsuarioGUI extends JFrame {
    private JTextField nomeField, cpfField, dataNascimentoField, valorInvestidoField;
    private JButton cadastrarButton;
    private JButton sairButton;

    private Usuario usuario1;
    private Usuario usuario2;
    private Usuario usuario3;
    private int usuariosCadastrados;

    private List<Researchs> pesquisaList; // Adicione a lista de pesquisas

    public CadastroUsuarioGUI() {
        setTitle("Cadastro de Usuário");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField(20);

        JLabel cpfLabel = new JLabel("CPF:");
        cpfField = new JTextField(20);

        JLabel dataNascimentoLabel = new JLabel("Data de Nascimento (AAAA-MM-DD):");
        dataNascimentoField = new JTextField(20);

        JLabel valorInvestidoLabel = new JLabel("Valor Total Investido:");
        valorInvestidoField = new JTextField(20);

        cadastrarButton = new JButton("Cadastrar");

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarUsuario();
            }
        });

        sairButton = new JButton("Sair");
        sairButton.setEnabled(false);

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encerrarJanela();
            }
        });

        add(nomeLabel);
        add(nomeField);
        add(cpfLabel);
        add(cpfField);
        add(dataNascimentoLabel);
        add(dataNascimentoField);
        add(valorInvestidoLabel);
        add(valorInvestidoField);
        add(new JLabel());
        add(cadastrarButton);
        add(new JLabel());
        add(sairButton);

        usuariosCadastrados = 0;
        pesquisaList = new ArrayList<>(); // Inicialize a lista no construtor
        pack();
        setLocationRelativeTo(null);
    }

    private void cadastrarUsuario() {
        String nome = nomeField.getText();
        String cpf = cpfField.getText();
        String dataNascimentoStr = dataNascimentoField.getText();
        double valorInvestido = Double.parseDouble(valorInvestidoField.getText());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);

        if (usuariosCadastrados == 0) {
            usuario1 = new Usuario(nome, cpf, dataNascimento, valorInvestido);
        } else if (usuariosCadastrados == 1) {
            usuario2 = new Usuario(nome, cpf, dataNascimento, valorInvestido);
        } else if (usuariosCadastrados == 2) {
            usuario3 = new Usuario(nome, cpf, dataNascimento, valorInvestido);
        }

        usuariosCadastrados++;

        if (usuariosCadastrados == 3) {
            cadastrarButton.setEnabled(false);
            exibirMensagemLimiteAtingido();
        }

        System.out.println("Usuário cadastrado: " + nome + " (CPF: " + cpf + ", Data de Nascimento: " + dataNascimentoStr + ", Valor Investido: " + valorInvestido + ")");

        nomeField.setText("");
        cpfField.setText("");
        dataNascimentoField.setText("");
        valorInvestidoField.setText("");
    }

    private void exibirMensagemLimiteAtingido() {
        JOptionPane.showMessageDialog(this, "Limite de três usuários atingido.", "Limite Atingido", JOptionPane.INFORMATION_MESSAGE);
        sairButton.setEnabled(true);
    }

    private void encerrarJanela() {
        dispose();

        SelecionarArquivoGUI selecionarArquivoGUI = new SelecionarArquivoGUI();
        selecionarArquivoGUI.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CadastroUsuarioGUI().setVisible(true);
            }
        });
    }

    // Método para adicionar uma pesquisa à lista
    public void adicionarPesquisa(Researchs pesquisa) {
        pesquisaList.add(pesquisa);
    }

    // Método para obter a lista de pesquisas
    public List<Researchs> getResearchsList() {
        return pesquisaList;
    }

    public int getUsuariosCadastrados() {
        return usuariosCadastrados;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public Usuario getUsuario2() {
        return usuario2;
    }

    public Usuario getUsuario3() {
        return usuario3;
    }
}
