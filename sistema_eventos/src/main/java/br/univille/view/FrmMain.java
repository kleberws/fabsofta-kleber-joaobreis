package br.univille.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrmMain extends JFrame {

    private JLabel lblId, lblNome, lblEndereco;
    private JTextField txtId, txtNome, txtEndereco;

    public FrmMain(){
        setSize(500, 500);
        setTitle("Minha janelinha");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        painelCampos();

        setVisible(true);
    }

    private void painelCampos(){
        JPanel painel = new JPanel();
        lblId = new JLabel("ID");
        painel.add(lblId);
        txtId = new JTextField(5);
        painel.add(txtId);

        lblNome = new JLabel("Nome");
        painel.add(lblNome);
        txtNome = new JTextField(15);
        painel.add(txtNome);

        lblEndereco = new JLabel("Endereco");
        painel.add(lblEndereco);
        txtEndereco = new JTextField(15);
        painel.add(txtEndereco);

        getContentPane().add(painel);
    }
}
