package entities;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame implements ComparacaoResearchs {
    private JTextField nomeField, cpfField, dataNascimentoField, valorInvestidoField;
    private JButton cadastrarButton, selecionarArquivoButton;
    private JFileChooser fileChooser;
    private JButton sairButton;
    private List<Researchs> pesquisaList;
    private int usuariosCadastrados;
    private int fileCount = 0;
    private Usuario usuario1;
    private Usuario usuario2;
    private Usuario usuario3;
    private double retornoPorcentagemResearch1 = 0;
    private double retornoPorcentagemResearch2 = 0;
    private double retornoPorcentagemResearch3 = 0;
    private double confirmacaoSair = 0;

    public Main() {
        setTitle("Cadastro de Usuário e Seleção de Arquivo");
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
        selecionarArquivoButton = new JButton("Selecionar Arquivo");
        fileChooser = new JFileChooser();
        pesquisaList = new ArrayList<>();

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarUsuario();
            }
        });

        selecionarArquivoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selecionarArquivo();
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
        add(selecionarArquivoButton);
        add(sairButton);

        usuariosCadastrados = 0;

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
            confirmacaoSair += 1;
            if (confirmacaoSair == 2){
                sairButton.setEnabled(true);
            }
        }

        System.out.println("Usuário cadastrado: " + nome + " (CPF: " + cpf + ", Data de Nascimento: " + dataNascimentoStr + ", Valor Investido: " + valorInvestido + ")");

        nomeField.setText("");
        cpfField.setText("");
        dataNascimentoField.setText("");
        valorInvestidoField.setText("");
    }

    private void exibirMensagemLimiteAtingido() {
        JOptionPane.showMessageDialog(this, "Limite de três usuários atingido.", "Limite Atingido", JOptionPane.INFORMATION_MESSAGE);
    }

    private void selecionarArquivo() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos CSV", "csv");
        fileChooser.setFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);

        int resultado = fileChooser.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {

            if (fileCount < 3) {
                List<Double> retornoResearch1 = new ArrayList<>();
                List<Double> retornoResearch2 = new ArrayList<>();
                List<Double> retornoResearch3 = new ArrayList<>();
                BancoCentralFicticio bancoCentralFicticio = new BancoCentralFicticio("Banco central ficticio");


                    List<Researchs> researchsList = new ArrayList<>();

                    try {
                        BufferedReader br = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
                        String line;

                        while ((line = br.readLine()) != null) {
                            String[] data = line.split(";");

                            if (data.length >= 6) {
                                String ticket = data[0];
                                String nomeEmpresa = data[1];
                                double valorInvestido = extrairValor(data[2]);
                                int tempoTrading = Integer.parseInt(data[3]);
                                double retorno = extrairPorcentagem(data[4]);
                                double resultadoFinanceiro = extrairValor(data[5]);

                                Researchs research = new Researchs(new Ativo(ticket, nomeEmpresa), valorInvestido, tempoTrading, retorno, resultadoFinanceiro);
                                researchsList.add(research);
                            }
                        }

                        br.close();

                        if (!researchsList.isEmpty()) {
                            for (Researchs research : researchsList) {
                                System.out.println("Ticket: " + research.getAtivo().getTicket());
                                System.out.println("Nome da Empresa: " + research.getAtivo().getNomeEmpresa());
                                System.out.println("Valor Investido: " + research.getValorInvestido());
                                System.out.println("Tempo de Trading: " + research.getTempoTranding());
                                System.out.println("Retorno: " + research.getRetorno());
                                System.out.println("Resultado Financeiro: " + research.getResultadoFinanceiro());
                                System.out.println();
                                System.out.printf("Calculo de taxa de corretagem do(a) empresa: %s - (ticket: %s): ",
                                        research.getAtivo().getNomeEmpresa(), research.getAtivo().getTicket());
                                System.out.printf("%.2f\n", bancoCentralFicticio.calculoTaxaCorretagem(research.getValorInvestido()));
                                System.out.printf("Calculo de imposto do(a) empresa: %s - (ticket: %s): ",
                                        research.getAtivo().getNomeEmpresa(), research.getAtivo().getTicket());
                                System.out.printf("%.2f %%\n", bancoCentralFicticio.calculoImposto(research.getTempoTranding(), research.getResultadoFinanceiro()));


                                System.out.println();

                                if (fileCount == 0) {
                                    retornoResearch1.add(research.getRetorno());
                                    retornoPorcentagemResearch1 += research.getRetorno();
                                } else if (fileCount == 1) {
                                    retornoResearch2.add(research.getRetorno());
                                    retornoPorcentagemResearch2 += research.getRetorno();
                                } else if (fileCount == 2) {
                                    retornoResearch3.add(research.getRetorno());
                                    retornoPorcentagemResearch3 += research.getRetorno();
                                }
                            }
                            fileCount++;
                        }

                        if (fileCount == 3) {
                            JOptionPane.showMessageDialog(null, "Limite de arquivos atingido.");
                            confirmacaoSair += 1;
                            if (confirmacaoSair == 2){
                                sairButton.setEnabled(true);
                            }
                        }

                        if (fileCount >= 3) {
                            selecionarArquivoButton.setEnabled(false);
                            System.out.printf("%.2f\n", retornoPorcentagemResearch1);
                            System.out.printf("%.2f\n", retornoPorcentagemResearch2);
                            System.out.printf("%.2f\n", retornoPorcentagemResearch3);


                            int melhorResearch = maiorValor(retornoPorcentagemResearch1, retornoPorcentagemResearch2, retornoPorcentagemResearch3);

                            if (melhorResearch == 0) {
                                System.out.println("Research 1 ganhou");
                            } else if (melhorResearch == 1) {
                                System.out.println("Research 2 ganhou");
                            } else {
                                System.out.println("Research 3 ganhou");
                            }

                        }

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

            } else {
                JOptionPane.showMessageDialog(null, "Limite de arquivos atingido.");
            }
        }
    }

    private double extrairValor(String valorStr) {
        valorStr = valorStr.replace("R$ ", "").replace(".", "").replace(",", ".");
        return Double.parseDouble(valorStr);
    }

    private double extrairPorcentagem(String porcentagemStr) {
        porcentagemStr = porcentagemStr.replace("%", "").replace(",", ".");
        return Double.parseDouble(porcentagemStr);
    }

    private void encerrarJanela() {
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    @Override
    public int maiorValor(double valor1, double valor2, double valor3) {
        int melhorResearch = 0;
        if ((valor1 > valor2) && (valor1 > valor3)) {
            melhorResearch = 0;
        }
        else if ((valor2 > valor1) && (valor2 > valor3)) {
            melhorResearch = 1;
        }
        else if ((valor3 > valor1) && (valor3 > valor2)) {
            melhorResearch = 2;
        }
        return melhorResearch;
    }

}