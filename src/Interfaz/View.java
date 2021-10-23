package Interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPanel;


public class View extends javax.swing.JFrame{
    
    private JTextField txtAmount;
    private JTextField txtExchange;
    private JComboBox comboFrom;
    private JComboBox comboTo;
    
    public View(){
        initComponents();
        setVisible(true);
    }
    
    private void initComponents(){
        txtAmount = new JTextField(10);
        txtExchange = new JTextField(15);
        comboFrom = new JComboBox<>();
        comboTo = new JComboBox<>();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Money_Calculator");
        
        JPanel dialogPanel = new JPanel();
        JPanel displayPanel = new JPanel();
        
        dialogPanel.add(txtAmount);
        dialogPanel.add(comboFrom);
        dialogPanel.add(comboTo);
        displayPanel.add(txtExchange);
        
        fillComboBoxes(); 
        comboFrom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                fillComboTo((String) getFrom());
            }
        });
        
        setLayout(new BorderLayout());
        this.add(dialogPanel, BorderLayout.NORTH);
        this.add(displayPanel, BorderLayout.SOUTH);
        
        pack();
    }
    
    public double getAmount() {
        return Double.parseDouble(txtAmount.getText());
    }
    
    public String getFrom() {
        return comboFrom.getSelectedItem().toString();
    }
    
    public String getTo() {
        return comboTo.getSelectedItem().toString();
    }
    
    public void setExchange(double r) {
        txtExchange.setText(Double.toString(r));
    }
    
    private void fillComboBoxes(){
        fillComboFrom();
        fillComboTo((String) getFrom());
    }
    
    private void fillComboFrom() {
        String[] divisas = new String[]{"EUR", "USD", "GBP", "BTC", "ETH"};
        for (String divisa : divisas) {
            comboFrom.addItem(divisa);
        }
    }
    
    private void fillComboTo(String selectedItem) {
        String[] divisas = new String[]{};
        comboTo.removeAllItems();
        switch(selectedItem){
            case "USD": divisas = new String[]{"EUR", "GBP", "BTC", "ETH"}; break;
            case "EUR": divisas = new String[]{"USD", "GBP", "BTC", "ETH"}; break;
            case "GBP": divisas = new String[]{"EUR", "USD", "BTC", "ETH"}; break;
            case "BTC": divisas = new String[]{"EUR", "GBP", "USD", "ETH"}; break;
            case "ETH": divisas = new String[]{"EUR", "GBP", "BTC", "USD"}; break;
        }

        for (String divisa : divisas) {
            comboTo.addItem(divisa);
        }
    } 
}
