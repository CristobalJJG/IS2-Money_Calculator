package Interfaz;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class DisplayPanel extends JPanel{
    private JTextField txtExchange;
    
    public DisplayPanel(){
        initComponents();
        addComponents();
    }
    
    public void initComponents(){
        txtExchange = new JTextField(15);
        txtExchange.setText("0");
        txtExchange.setEditable(false);
    }
    
    public void addComponents(){
        add(txtExchange);
    }
    
    public void setExchange(double r) {
        txtExchange.setText(Double.toString(r));
    }
}
