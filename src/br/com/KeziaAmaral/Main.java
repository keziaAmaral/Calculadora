package br.com.KeziaAmaral;

import br.com.KeziaAmaral.view.Calculadora;

import javax.swing.*;
import java.text.ParseException;

public class Main {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Calculadora();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
