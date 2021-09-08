package br.com.KeziaAmaral.view;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.ParseException;

public class Calculadora {
    private JLabel jLabelResultado;
    private JLabel jLabelValorA;
    private JLabel jLabelValorB;

    private JTextField jTextFieldValorA;
    private JTextField jTextFieldValorB;

    private JButton jButtonAdd;
    private JButton jButtonSub;
    private JButton jButtonMul;
    private JButton jButtonDiv;
    private JButton jButtonClear;

    public Calculadora() throws ParseException {
        JFrame jFrameTelaPrincipal = new JFrame("Calculadora Simples");
        jFrameTelaPrincipal.setLayout(null);
        jFrameTelaPrincipal.setSize(300,400);

        jTextFieldValorA = new JTextField();
        jTextFieldValorB = new JTextField();

        jLabelResultado = new JLabel();
        jLabelValorA =  new JLabel("Valor A");
        jLabelValorB=  new JLabel("Valor A");

        jButtonAdd = new JButton("+");
        jButtonSub = new JButton("-");
        jButtonMul = new JButton("*");
        jButtonDiv = new JButton("/ ");
        jButtonClear = new JButton("Limpar");


        jLabelResultado.setBounds(10,10,280,20);
        jLabelResultado.setBackground(new Color(255, 0, 0));

        jLabelValorA.setBounds(10,30,50,20);
        jTextFieldValorA.setBounds(65, 30, 220, 20);

        jLabelValorB.setBounds(10,55,50,20);
        jTextFieldValorB.setBounds(65, 55, 220, 20);

        jButtonAdd.setBounds(60,80,50,50);
        jButtonSub.setBounds(110,80,50,50);
        jButtonMul.setBounds(160,80,50,50);
        jButtonDiv.setBounds(210,80,50,50);

        jButtonClear.setBounds(60,135,200,50);

        jButtonClear.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        acaoBotaoLimpar();
                    }
                }
        );

        jButtonAdd.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        executarOperacao("+");
                    }
                }
        );

        jButtonDiv.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        executarOperacao("/");
                    }
                }
        );

        jButtonMul.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        executarOperacao("*");
                    }
                }
        );

        jButtonSub.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        executarOperacao("-");
                    }
                }

        );


        jFrameTelaPrincipal.add(jLabelResultado);
        jFrameTelaPrincipal.add(jLabelValorA);
        jFrameTelaPrincipal.add(jLabelValorB);
        jFrameTelaPrincipal.add(jTextFieldValorA);
        jFrameTelaPrincipal.add(jTextFieldValorB);
        jFrameTelaPrincipal.add(jButtonAdd);
        jFrameTelaPrincipal.add(jButtonDiv);
        jFrameTelaPrincipal.add(jButtonMul);
        jFrameTelaPrincipal.add(jButtonSub);
        jFrameTelaPrincipal.add(jButtonClear);
        jFrameTelaPrincipal.setResizable(false);
        jFrameTelaPrincipal.setVisible(true);
        jFrameTelaPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private void executarOperacao(String actionCommand) {
        BigDecimal valorA;
        BigDecimal valorB;
        try{
            valorA = new BigDecimal(jTextFieldValorA.getText());
            valorB = new BigDecimal(jTextFieldValorB.getText());
        }
        catch(Exception e) {
            acaoBotaoLimpar();
            jLabelResultado.setText("Por favor insira números válidos.");
            return;
        }

        BigDecimal resultado;

        switch (actionCommand){
            case "+":
                resultado = valorA.add(valorB);
                jLabelResultado.setText("" + resultado);
                break;
            case "-":
                resultado = valorA.subtract(valorB);
                jLabelResultado.setText("" + resultado);
                break;

            case "*":
                resultado = valorA.multiply(valorB);
                jLabelResultado.setText("" + resultado);
                break;
            case "/":
                resultado = valorA.divide(valorB);
                jLabelResultado.setText("" + resultado);
                break;

        }
    }

    private void acaoBotaoLimpar(){
        jLabelResultado.setText("Informe os valores para realizar a operação");
        jTextFieldValorA.setText("");
        jTextFieldValorB.setText("");
        jLabelValorA.setText("");
        jLabelValorB.setText("");
    }
}

