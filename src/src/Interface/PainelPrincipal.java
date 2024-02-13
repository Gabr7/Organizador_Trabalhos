package Interface;

import Interface.Telas.TelaDetalhes;
import Interface.Telas.TelaNovo;
import Servico.DadosServicos;
import Servico.Servico;
import utils.EscritorJson;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PainelPrincipal extends JPanel {
    DadosServicos dados;
    DefaultListModel listaAuxiliar;
    JList<String> lista;
    Servico servicoSelecionado;
    public PainelPrincipal(DadosServicos dados){
        super(new BorderLayout());
        this.dados = dados;
        iniciarLista(dados);
        adicionarSeletor(dados);
        adicionarBotoes();
    }

    private void adicionarSeletor(DadosServicos dados) {
        lista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    String nomeSelecionado = lista.getSelectedValue();
                    for(Servico servico: dados.getServicos()){
                        if(servico.getNome().equals(nomeSelecionado)){
                            servicoSelecionado = servico;
                            break;
                        }

                    }
                }
            }
        });
    }

    private  void iniciarLista(DadosServicos dados){
        listaAuxiliar = new DefaultListModel<>();
        for(Servico servicos: dados.getServicos()){
            listaAuxiliar.addElement(servicos.getNome());
        }
        lista = new JList<>(listaAuxiliar);
        this.add(lista, BorderLayout.CENTER);
    }
    private void adicionarBotoes(){
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(2,1));

/////////      Botao Novo       ///////

        JButton novo = new JButton("Novo");
        painelBotoes.add(novo);
        novo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaNovo telaNovo = new TelaNovo(PainelPrincipal.this);
                telaNovo.setVisible(true);
            }
        });

/////////    Botao Detalhes    ///////

        JButton visualizarDetalhes = new JButton("Visualizar Detalhes");
        painelBotoes.add(visualizarDetalhes);
        visualizarDetalhes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaDetalhes telaDetalhes = new TelaDetalhes(PainelPrincipal.this);
                telaDetalhes.setVisible(true);
            }
        });


        this.add(painelBotoes,BorderLayout.EAST);
    }

    public void atualizarLista(){
        listaAuxiliar.clear();
        for(Servico servicos: dados.getServicos()){
            listaAuxiliar.addElement(servicos.getNome());
        }
        try {
            EscritorJson escritor = new EscritorJson();
            escritor.EscreverArquivo(dados);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ERRO DE LEITURA");
        }
    }

    public DadosServicos getDados() {
        return dados;
    }

    public Servico getServicoSelecionado() {
        return servicoSelecionado;
    }
}
