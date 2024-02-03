package Interface;

import Servico.DadosServicos;
import Servico.Servico;

import javax.swing.*;
import java.awt.*;

public class Painel extends JPanel {
    DefaultListModel listaAuxiliar;
    JList<String> lista;
    public Painel(DadosServicos dados){
        super(new BorderLayout());
        listaAuxiliar = new DefaultListModel<>();

        for(Servico servicos: dados.getServicos()){
            listaAuxiliar.addElement(servicos.getNome());
        }
        lista = new JList<>(listaAuxiliar);
        this.add(lista, BorderLayout.CENTER);
    }

}
