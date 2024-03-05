package Interface;
import Servico.DadosServicos;

import  javax.swing.JFrame;
import java.awt.*;

public class TelaPrincipal extends JFrame {
    private PainelPrincipal painelPrincipal;
    public TelaPrincipal(DadosServicos dados){
        super("Organizador de serviços");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(400,500));
        painelPrincipal = new PainelPrincipal(dados);
        add(painelPrincipal);
    }
    public void mostrarTela(){

        this.setVisible(true);

    }

}
