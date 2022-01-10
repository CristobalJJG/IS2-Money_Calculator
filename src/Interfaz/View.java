package Interfaz;

import Modelo.Currencies;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.UnsupportedLookAndFeelException;

public class View extends javax.swing.JFrame{
    private JTextField txtAmount;
    private JComboBox comboFrom;
    private JComboBox comboTo;
    
    private JTextField txtExchange;
    private JLabel lblSimbolo;
    
    public View(){
        initComponents();
        addListeners();
        setVisible(true);
    }
    
    private void initComponents(){
        //https://github.com/JFormDesigner/FlatLaf/tree/main/flatlaf-intellij-themes
        try{
            javax.swing.UIManager.setLookAndFeel(com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme.class.getName());
        }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e){
            e.getMessage();
        }
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Money_Calculator");
        
        setLayout(new BorderLayout());
        
        txtAmount = new JTextField(10);
        comboFrom = new JComboBox<>();
        comboTo = new JComboBox<>();
        
        JPanel dialogPanel = new JPanel();
        dialogPanel.add(txtAmount);
        dialogPanel.add(comboFrom);
        dialogPanel.add(comboTo);
        
        txtExchange = new JTextField(15);
        txtExchange.setText("0");
        txtExchange.setEditable(false);
        lblSimbolo = new JLabel();
        
        JPanel displayPanel = new JPanel();
        displayPanel.add(txtExchange);
        displayPanel.add(lblSimbolo);
        
        fillComboBoxes(); 
        
        add(dialogPanel, BorderLayout.NORTH);
        add(displayPanel, BorderLayout.SOUTH);
        pack();
    }
    
    private void addListeners(){
        txtAmount.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                updateNumber();
            }
        });
        
        comboFrom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                updateFromTo();
            }
        });
        
        comboTo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                updateFromTo();
            }
        });
    }
    
    private void updateNumber() {
        if((getAmount() + "").matches("[0-9]+\\.[0-9]*")){
            
            double n = Controlador.Controller.update(getAmount(), getFrom(), getTo());
            setExchange(n);
        }
    }
    
    private void updateFromTo() {
        double n = Controlador.Controller.update(getAmount(), getFrom(), getTo());
        setExchange(n);
    }
    
    public double getAmount() {
        String amount = txtAmount.getText();
        if(amount.isBlank()) return 0.;
        return Double.parseDouble(amount);
    }
    
    public String getFrom() {
        return comboFrom.getSelectedItem().toString();
    }
    
    public String getTo() {
        return comboTo.getSelectedItem().toString();
    }
    
    private void fillComboBoxes() {
        Currencies c = new Currencies();
        String[] divisas = c.getCurrencies();
        for (String divisa : divisas) {
            comboTo.addItem(divisa);
            comboFrom.addItem(divisa);
        }
    }
    
    public void setExchange(double r) {
        txtExchange.setText(r + "");
    }
}
