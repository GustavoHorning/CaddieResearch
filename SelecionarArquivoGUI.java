package entities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SelecionarArquivoGUI extends JFrame {
    private JButton selecionarArquivoButton;
    private JFileChooser fileChooser;
    private int fileCount = 0;

    public SelecionarArquivoGUI() {
        setTitle("Selecionar Arquivo CSV");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        selecionarArquivoButton = new JButton("Selecionar Arquivo");
        fileChooser = new JFileChooser();

        selecionarArquivoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileCount < 3) {
                    int resultado = fileChooser.showOpenDialog(null);

                    if (resultado == JFileChooser.APPROVE_OPTION) {
                        try {
                            BufferedReader br = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
                            String line;

                            while ((line = br.readLine()) != null) {
                                String[] data = line.split(";");

                                if (data.length >= 6) { // Verifica se a linha tem dados suficientes
                                    String ticket = data[0];
                                    String nomeEmpresa = data[1];
                                    double valorInvestido = extrairValor(data[2]);
                                    int tempoTrading = Integer.parseInt(data[3]);
                                    double retorno = extrairPorcentagem(data[4]);
                                    double resultadoFinanceiro = extrairValor(data[5]);

                                    // Aqui você pode criar objetos das classes Research com base nos dados lidos
                                    if (fileCount == 0) {
                                        Researchs research1 = new Researchs(new Ativo(ticket, nomeEmpresa), valorInvestido, tempoTrading, retorno, resultadoFinanceiro);
                                        System.out.println(research1.getAtivo().getTicket());
                                        System.out.println(research1.getAtivo().getNomeEmpresa());
                                    } else if (fileCount == 1) {
                                        Researchs research2 = new Researchs(new Ativo(ticket, nomeEmpresa), valorInvestido, tempoTrading, retorno, resultadoFinanceiro);
                                        System.out.println(research2.getAtivo().getTicket());
                                        System.out.println(research2.getAtivo().getNomeEmpresa());
                                    } else if (fileCount == 2) {
                                        Researchs research3 = new Researchs(new Ativo(ticket, nomeEmpresa), valorInvestido, tempoTrading, retorno, resultadoFinanceiro);
                                        System.out.println(research3.getAtivo().getTicket());
                                        System.out.println(research3.getAtivo().getNomeEmpresa());
                                    }
                                    fileCount++;

                                    if (fileCount == 3) {
                                        JOptionPane.showMessageDialog(null, "Limite de arquivos atingido.");
                                        dispose(); // Fecha a interface após atingir o limite
                                        break;
                                    }
                                }
                            }

                            br.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Limite de arquivos atingido.");
                }
            }
        });

        add(selecionarArquivoButton);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SelecionarArquivoGUI().setVisible(true);
            }
        });
    }
}
