/**
 * @name        Simple Java Calculator
 * @package     ph.calculator
 * @file        UI.java
 * @author      SORIA Pierre-Henry
 * @email       pierrehs@hotmail.com
 * @link        http://github.com/pH-7
 * @copyright   Copyright Pierre-Henry SORIA, All Rights Reserved.
 * @license     Apache (http://www.apache.org/licenses/LICENSE-2.0)
 * @create      2012-03-30
 *
 * @modifiedby  Achintha Gunasekara
 * @modifiedby  Kydon Chantzaridis
 * @modweb      http://www.achinthagunasekara.com
 * @modemail    contact@achinthagunasekara.com
 * @modemail    kchantza@csd.auth.gr
 */

package simplejavacalculator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.Calculator;

public class UI implements ActionListener {
    private final JFrame frame;
    private final JPanel panel;
    private final JTextArea text;
    private final JPanel type;
    private final JButton but[], butAdd, butMinus, butMultiply, butDivide,
            butEqual, butCancel, butSquareRoot, butSquare, butOneDevidedBy,
            butCos, butSin, butTan, butxpowerofy, butlog, butrate, butabs, 
            butStnd, butSciec;
    private final JButton btnDec, btnSign, btnArccos, btnArcsin, btnArctan, btnxrootofy;
    private final Calculator calc;

    private final String[] buttonValue = { "0", "1", "2", "3", "4", "5", "6",
            "7", "8", "9"};

    public UI() {
        frame = new JFrame("Calculator PH");
        frame.setResizable(false);
        panel = new JPanel(new FlowLayout());
        type = new JPanel(new FlowLayout());

        text = new JTextArea(2, 25);
        but = new JButton[10];
        for (int i = 0; i < 10; i++) {
            but[i] = new JButton(String.valueOf(i));
        }

        butStnd = new JButton("Standard");
        butSciec = new JButton("Scientific");
        
        butAdd = new JButton("+");
        butMinus = new JButton("-");
        butMultiply = new JButton("*");
        butDivide = new JButton("/");
        butEqual = new JButton("=");
        butSquareRoot = new JButton("âˆš");
        butSquare = new JButton("x*x");
        butOneDevidedBy = new JButton("1/x");
        butCos = new JButton("Cos");
        butSin = new JButton("Sin");
        butTan = new JButton("Tan");
        butxpowerofy = new JButton("x^y");
        butlog = new JButton("log10(x)");
        butrate = new JButton("x%");
        butabs = new JButton("abs(x)");
        btnxrootofy = new JButton("ysqr(x)");
        btnDec = new JButton(".");
        btnSign = new JButton("+/-");
        btnArccos = new JButton("Arccos");
        btnArcsin = new JButton("Arcsin");
        btnArctan = new JButton("Arctan");

        butCancel = new JButton("C");

        calc = new Calculator();
    }

    public void init() {
        frame.setVisible(true);
        frame.setSize(330, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);       
        
        type.add(butStnd);
        type.add(butSciec);
        
        butStnd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		writer(calc.reset());
        		initStandard();
        	}       	
        });
        
        butSciec.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		writer(calc.reset());
        		initScientific();
        	}       	
        });
        
        for (int i = 0; i < 10; i++) {
        	but[i].addActionListener(this);
        }

        butAdd.addActionListener(this);
        butMinus.addActionListener(this);
        butMultiply.addActionListener(this);
        butDivide.addActionListener(this);
        butSquare.addActionListener(this);
        butSquareRoot.addActionListener(this);
        butOneDevidedBy.addActionListener(this);
        butCos.addActionListener(this);
        butSin.addActionListener(this);
        butTan.addActionListener(this);
        butxpowerofy.addActionListener(this);
        butlog.addActionListener(this);
        butrate.addActionListener(this);
        butabs.addActionListener(this);
        
        btnxrootofy.addActionListener(this);
        btnDec.addActionListener(this);
        btnSign.addActionListener(this);
        btnArccos.addActionListener(this);
        btnArcsin.addActionListener(this);
        btnArctan.addActionListener(this);

        butEqual.addActionListener(this);
        butCancel.addActionListener(this);
        
        initStandard();
    }
    
    public void initStandard() {
    	panel.removeAll();
    	panel.updateUI();
    	
        panel.add(text);
        panel.add(type);
        
        for (int i = 0; i < 10; i++) {
            panel.add(but[i]);
        }
//        panel.add(but[0]);
//        but[0].addActionListener(this);

        panel.add(butAdd);
        panel.add(butMinus);
        panel.add(butMultiply);
        panel.add(butDivide);
        panel.add(butSquare);
        panel.add(butSquareRoot);
        panel.add(butOneDevidedBy);
        panel.add(butrate);
        panel.add(btnDec);
        panel.add(btnSign);

        panel.add(butEqual);
        panel.add(butCancel);
    }
    
    public void initScientific() {
    	panel.removeAll();
    	panel.updateUI();
    	
        panel.add(text);
        panel.add(type);
        
        for (int i = 0; i < 10; i++) {
            panel.add(but[i]);
        }
        
        panel.add(butAdd);
        panel.add(butMinus);
        panel.add(butMultiply);
        panel.add(butDivide);
        panel.add(butSquare);
        panel.add(butSquareRoot);
        panel.add(butOneDevidedBy);
        panel.add(butCos);
        panel.add(butSin);
        panel.add(butTan);
        panel.add(btnArccos);
        panel.add(btnArcsin);
        panel.add(btnArctan);
        panel.add(butxpowerofy);
        panel.add(butlog);
        panel.add(butrate);
        panel.add(butabs);
        panel.add(btnxrootofy);
        panel.add(btnDec);
        panel.add(btnSign);
        
        panel.add(butEqual);
        panel.add(butCancel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final Object source = e.getSource();

        for (int i = 0; i < 10; i++) {
            if (source == but[i]) {
                text.replaceSelection(buttonValue[i]);
                return;
            }
        }

        if (source == butAdd) {
            writer(calc.calculateBi(Calculator.BiOperatorModes.add, reader()));
        }

        if (source == butMinus) {
            writer(calc.calculateBi(Calculator.BiOperatorModes.minus, reader()));
        }

        if (source == butMultiply) {
            writer(calc.calculateBi(Calculator.BiOperatorModes.multiply,
                reader()));
        }

        if (source == butDivide) {
            writer(calc
                .calculateBi(Calculator.BiOperatorModes.divide, reader()));
        }
        if (source == butxpowerofy) {
            writer(calc
                .calculateBi(Calculator.BiOperatorModes.xpowerofy, reader()));
        }

        if (source == butSquare) {
            writer(calc.calculateMono(Calculator.MonoOperatorModes.square,
                reader()));
        }

        if (source == butSquareRoot) {
            writer(calc.calculateMono(Calculator.MonoOperatorModes.squareRoot,
                reader()));
        }

        if (source == butOneDevidedBy) {
            writer(calc.calculateMono(
                    Calculator.MonoOperatorModes.oneDevidedBy, reader()));
        }

        if (source == butCos) {
            writer(calc.calculateMono(Calculator.MonoOperatorModes.cos,
                reader()));
        }

        if (source == butSin) {
            writer(calc.calculateMono(Calculator.MonoOperatorModes.sin,
                reader()));
        }

        if (source == butTan) {
            writer(calc.calculateMono(Calculator.MonoOperatorModes.tan,
                reader()));
        }
        
        if (source == btnArccos) {
            writer(calc.calculateMono(Calculator.MonoOperatorModes.arccos,
                reader()));
        }

        if (source == btnArcsin) {
            writer(calc.calculateMono(Calculator.MonoOperatorModes.arcsin,
                reader()));
        }

        if (source == btnArctan) {
            writer(calc.calculateMono(Calculator.MonoOperatorModes.arctan,
                reader()));
        }
        
        if (source == butlog) {
            writer(calc.calculateMono(Calculator.MonoOperatorModes.log,
                reader()));
        }
         if (source == butrate) {
            writer(calc.calculateMono(Calculator.MonoOperatorModes.rate,
                reader()));
        }
         if(source == butabs){
             writer(calc.calculateMono(Calculator.MonoOperatorModes.abs, reader()));
         }
        if(source == btnxrootofy) {
        	writer(calc.calculateBi(Calculator.BiOperatorModes.xrootofy, reader()));
        }
         
        if(source == btnDec) {
        	text.replaceSelection(".");
            return;
        }
        if(source == btnSign) {
        	String str = text.getText();
        	if(str.startsWith("-")) {
        		text.setText(str.replace("-", ""));
        		return;
        	} else {
        		text.setText("-" + str);
        		return;
        	}
        }

        if (source == butEqual) {
            writer(calc.calculateEqual(reader()));
        }

        if (source == butCancel) {
            writer(calc.reset());
        }

        text.selectAll();
    }

    public Double reader() {
        Double num;
        String str;
        str = text.getText();
        if(str.startsWith(".")) {
        	str = "0" + str;
        }
        num = Double.valueOf(str);

        return num;
    }

    public void writer(final Double num) {
        if (Double.isNaN(num)) {
            text.setText("");
        } else {
            text.setText(Double.toString(num));
        }
    }
}
