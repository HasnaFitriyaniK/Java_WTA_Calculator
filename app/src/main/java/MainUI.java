import java.awt.*;
import java.awt.event.*;

public class MainUI implements ActionListener {
    Frame f;
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, badd, bsub, bmul, bdiv, beq, bclr;
    Panel p;
    TextField t1;
    String s1, s2, operator;

    public MainUI() {
        f = new Frame("Calculator");
        f.setLayout(new FlowLayout());
        p = new Panel();
        t1 = new TextField(20);
        f.add(t1);

        // Membuat tombol untuk angka dan operator
        b0 = new Button("0"); b1 = new Button("1"); b2 = new Button("2"); b3 = new Button("3");
        b4 = new Button("4"); b5 = new Button("5"); b6 = new Button("6"); b7 = new Button("7");
        b8 = new Button("8"); b9 = new Button("9"); badd = new Button("+");
        bsub = new Button("-"); bmul = new Button("*"); bdiv = new Button("/");
        beq = new Button("="); bclr = new Button("CLR");

        // Menambahkan action listener ke setiap tombol
        b0.addActionListener(this); b1.addActionListener(this); b2.addActionListener(this); b3.addActionListener(this);
        b4.addActionListener(this); b5.addActionListener(this); b6.addActionListener(this); b7.addActionListener(this);
        b8.addActionListener(this); b9.addActionListener(this); badd.addActionListener(this);
        bsub.addActionListener(this); bmul.addActionListener(this); bdiv.addActionListener(this);
        beq.addActionListener(this); bclr.addActionListener(this);

        // Panel untuk tombol
        p.setLayout(new GridLayout(4, 4));
        p.add(b0); p.add(b1); p.add(b2); p.add(b3); p.add(b4); p.add(b5); p.add(b6); p.add(b7);
        p.add(b8); p.add(b9); p.add(badd); p.add(bsub); p.add(bmul); p.add(bdiv); p.add(beq); p.add(bclr);

        f.add(p);
        f.setSize(200, 180);
        f.setVisible(true);
        f.setBackground(Color.LIGHT_GRAY);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String currentText = t1.getText();

        if (e.getSource() == bclr) {
            t1.setText("");
        } else if (e.getSource() == beq) {
            String result = ComputationEngine.processCalculation(s1, currentText, operator);
            t1.setText(result);
        } else {
            if (e.getSource() == badd || e.getSource() == bsub || e.getSource() == bmul || e.getSource() == bdiv) {
                s1 = currentText;
                t1.setText("");
                operator = e.getActionCommand();
            } else {
                t1.setText(currentText + e.getActionCommand());
            }
        }
    }

    public static void main(String[] args) {
        new MainUI();
    }
}
