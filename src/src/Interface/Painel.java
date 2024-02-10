package Interface;

import Servico.DadosServicos;
import Servico.Servico;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Painel extends JPanel {
    DefaultListModel listaAuxiliar;
    JList<String> lista;
    Servico servicoSelecionado;
    public Painel(DadosServicos dados){
        super(new BorderLayout());
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
            listaAuxiliar.addElement(servicos.getNome());}
        lista = new JList<>(listaAuxiliar);
        this.add(lista, BorderLayout.CENTER);
    }
    private void adicionarBotoes(){
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(3,1));

        JButton novo = new JButton("Novo");
        painelBotoes.add(novo);

        JButton visualizarDetalhes = new JButton("Visualizar Detalhes");
        painelBotoes.add(visualizarDetalhes);
        visualizarDetalhes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaDetalhes telaDetalhes = new TelaDetalhes(servicoSelecionado);
                telaDetalhes.setVisible(true);
            }
        });
        JButton salvar = new JButton("Salvar");
        painelBotoes.add(salvar);



        this.add(painelBotoes,BorderLayout.EAST);
    }

}
