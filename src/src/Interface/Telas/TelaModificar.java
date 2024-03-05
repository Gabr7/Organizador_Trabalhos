package Interface.Telas;
import Interface.PainelPrincipal;
import Servico.Servico;
import javax.swing.*;
import Servico.DadosServicos;
import java.awt.*;


public class TelaModificar extends JFrame {
    private  JTextField campoNome;
    private  JComboBox<String> campoSituacao;
    private  JTextField campoValor;
    private  JTextField campoRecebido;
    DadosServicos dadosServicos;
    Servico servicoModificar;
    PainelPrincipal painelPrincipal;
    Campos campos;
    public TelaModificar(PainelPrincipal painelPrincipal){
        super("Modificar");
        this.servicoModificar = painelPrincipal.getServicoSelecionado();
        this.setSize(300,300);
        this.setLayout(new GridLayout(7,1));
        this.dadosServicos = painelPrincipal.getDados();
        this.painelPrincipal = painelPrincipal;
        this.campos = new Campos(TelaModificar.this);

        campos.camposTelaModificar(servicoModificar);
        JButton salvar = campos.criarBotaoSalvar(painelPrincipal);
        this.add(salvar);

    }



}

