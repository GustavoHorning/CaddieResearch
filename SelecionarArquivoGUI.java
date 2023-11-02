package entities;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SelecionarArquivoGUI extends JFrame {
    private JButton selecionarArquivoButton;
    private JFileChooser fileChooser;
    private int fileCount = 0;
    private JButton sairButton;

    private CadastroUsuarioGUI cadastroUsuarioGUI;

    public SelecionarArquivoGUI() {
        setTitle("Selecionar Arquivo CSV");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Clique em 'Selecionar Arquivo' para adicionar uma Research."));

        selecionarArquivoButton = new JButton("Selecionar Arquivo");
        fileChooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos CSV (*.csv)", "csv");
        fileChooser.setFileFilter(filter);

        fileChooser.setAcceptAllFileFilterUsed(false);

        selecionarArquivoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileCount < 3) {
                    int resultado = fileChooser.showOpenDialog(null);

                    if (resultado == JFileChooser.APPROVE_OPTION) {
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
                                }

                                fileCount++; // Incrementa o contador após a leitura bem-sucedida.
                            }

                            if (fileCount == 3) {
                                sairButton.setEnabled(true);
                                JOptionPane.showMessageDialog(null, "Limite de arquivos atingido.");
                            }

                            if (fileCount >= 3) {
                                selecionarArquivoButton.setEnabled(false);
                            }

                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Limite de arquivos atingido.");
                }
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

        add(selecionarArquivoButton);
        add(sairButton);
        pack();
        setLocationRelativeTo(null);
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
                new SelecionarArquivoGUI().setVisible(true);
            }
        });
    }
}