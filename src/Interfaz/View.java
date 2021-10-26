package Interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends javax.swing.JFrame{
    //private final DialogPanel dialogPanel = new DialogPanel();
    //private final DisplayPanel displayPanel = new DisplayPanel();
    private JTextField txtAmount;
    private JComboBox comboFrom;
    private JComboBox comboTo;
    private JTextField txtExchange;
    
    public View(){
        initComponents();
        setVisible(true);
    }
    
    private void initComponents(){
        txtAmount = new JTextField(10);
        txtAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                update(evt);
            }
        });
        comboFrom = new JComboBox<>();
        comboTo = new JComboBox<>();
        
        txtAmount.setText("0");
        
        txtExchange = new JTextField(15);
        txtExchange.setText("0");
        txtExchange.setEditable(false);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Money_Calculator");
        
        setLayout(new BorderLayout());
        
        JPanel dialogPanel = new JPanel();
        dialogPanel.add(txtAmount);
        dialogPanel.add(comboFrom);
        dialogPanel.add(comboTo);
        
        JPanel displayPanel = new JPanel();
        displayPanel.add(txtExchange);
        
        fillComboBoxes(); 
        comboFrom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                fillComboTo((String) getFrom());
            }
        });
        
        
        add(dialogPanel, BorderLayout.NORTH);
        add(displayPanel, BorderLayout.SOUTH);
        pack();
    }
    
    private void update(java.awt.event.KeyEvent evt) {
        String s = getAmount() + "";
        if(!s.equals("") && s.matches("[0-9]+\\.[0-9]*")){
            double n = Controlador.Controller.update(getAmount(), getFrom(), getTo());
            setExchange(n);
        }
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
    
    public void setExchange(double r) {
        txtExchange.setText(r + "");
    }
}
