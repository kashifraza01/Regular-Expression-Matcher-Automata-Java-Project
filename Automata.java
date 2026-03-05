package kashif;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;

public class Automata extends JFrame{
    private final JTextField regf;
    private final JTextField inputf;
    private final JLabel rl;

    public Automata(){
        setTitle("regular expression matcher");
        setSize(450,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,2));

        JPanel regp=new JPanel();
        regp.add(new JLabel("enter R.E :   "));
        regf=new JTextField(20);
        regp.add(regf);
        add(regp);

        JPanel ip=new JPanel();
        ip.add(new JLabel("enter string :"));
        inputf=new JTextField(20);
        ip.add(inputf);
        add(ip);

        JPanel bp=new JPanel();
        JButton mb=new JButton("match");
        bp.add(mb);
        add(bp);

        JPanel rp=new JPanel();
        rl=new JLabel("result will appear here...");
        rl.setFont(new Font("arial", Font.BOLD, 14));
        rp.add(rl);
        add(rp);

        mb.addActionListener(e -> performmatching());
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void performmatching(){
        try{
            String pt=regf.getText();
            String it=inputf.getText();

            Pattern p=Pattern.compile(pt);
            Matcher m=p.matcher(it);

            if(m.matches()){
                rl.setText("✔ match found");
                rl.setForeground(Color.GREEN.darker());
            }else{
                rl.setText("✖ no match");
                rl.setForeground(Color.RED);
            }
        }catch(Exception ex){
            rl.setText("invalid regular expression");
            rl.setForeground(Color.ORANGE);
        }
    }
    public static void main(String[] args){
        new Automata();
    }
}
