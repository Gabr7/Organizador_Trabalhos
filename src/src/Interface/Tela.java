package Interface;
import Servico.DadosServicos;

import  javax.swing.JFrame;
import java.awt.*;

public class Tela extends JFrame {
    private Painel painel;
    public Tela(DadosServicos dados){
        super("Organizador de serviços");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(1000,500));
        painel = new Painel(dados);
        add(painel);
    }
    public void mostrarTela(){

        this.setVisible(true);

    }

}
