
// awal node 1
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainUI implements ActionListener {
    Frame f;
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, badd, bsub, bclr, bmul, bdiv, bdot, beq;
    Panel p;
    TextField t1;
    String s1 = "";
    String s2 = "";
    String operator = "";

    public MainUI() {
        f = new Frame("Calculator");
        f.setLayout(new FlowLayout());
        p = new Panel();
        t1 = new TextField(23);
        f.add(t1);

        // Membuat tombol untuk angka dan operator
        b0 = new Button("0");
        b1 = new Button("1");
        b2 = new Button("2");
        b3 = new Button("3");
        b4 = new Button("4");
        b5 = new Button("5");
        b6 = new Button("6");
        b7 = new Button("7");
        b8 = new Button("8");
        b9 = new Button("9");
        badd = new Button("+");
        bsub = new Button("-");
        bmul = new Button("*");
        bdiv = new Button("/");
        bdot = new Button(".");
        beq = new Button("=");
        bclr = new Button("CLR");

        // Menambahkan action listener ke setiap tombol
        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        badd.addActionListener(this);
        bsub.addActionListener(this);
        bmul.addActionListener(this);
        bdiv.addActionListener(this);
        bdot.addActionListener(this);
        beq.addActionListener(this);
        bclr.addActionListener(this);

        Dimension buttonSize = new Dimension(50, 50); // Misal semua tombol 50x50
        b0.setPreferredSize(buttonSize);
        b1.setPreferredSize(buttonSize);
        b2.setPreferredSize(buttonSize);
        b3.setPreferredSize(buttonSize);
        b4.setPreferredSize(buttonSize);
        b5.setPreferredSize(buttonSize);
        b6.setPreferredSize(buttonSize);
        b7.setPreferredSize(buttonSize);
        b8.setPreferredSize(buttonSize);
        b9.setPreferredSize(buttonSize);
        badd.setPreferredSize(buttonSize);
        bsub.setPreferredSize(buttonSize);
        bmul.setPreferredSize(buttonSize);
        bdiv.setPreferredSize(buttonSize);
        bdot.setPreferredSize(buttonSize);
        beq.setPreferredSize(buttonSize);
        bclr.setPreferredSize(new Dimension(180, 30));

        // Panel untuk tombol
        p.setLayout(new GridLayout(4, 4));
        p.add(b0);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(badd);
        p.add(bsub);
        p.add(bmul);
        p.add(bdiv);
        p.add(bdot);
        p.add(beq);
        p.add(bclr);

        Panel p2 = new Panel();
        p2.setLayout(new GridLayout(1, 1));
        p2.add(bclr);

        f.add(p);
        f.add(p2);
        f.setSize(270, 315);
        f.setVisible(true);
        f.setBackground(Color.PINK);

        Button[] buttons = { b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, badd, bsub, bmul, bdiv, bdot, beq, bclr };

        for (Button button : buttons) {
            button.setBackground(Color.LIGHT_GRAY);
            button.setForeground(Color.BLACK);
        }

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
        if (e.getSource() == bclr) { // node 2
            t1.setText(""); // node 3
            s1 = ""; // node 3
            operator = ""; // node 3
        } else if (e.getSource() == beq) { // node 4
            String result = ComputationEngine.processCalculation(s1, currentText, operator); // node 5
            t1.setText(result); // node 5
            s1 = ""; // node 5
            operator = ""; // node 5
        } else if (e.getSource() == bdot) { // node 6
            if (!currentText.contains(".")) { // node 7
                updateTextField("."); // node 8
            }
        } else if (e.getSource() == bsub) { // node 9
            if (currentText.isEmpty()) { // node 10
                t1.setText("-"); // node 11
            } else if (operator == null || operator.isEmpty()) { // node 12
                s1 = currentText; // node 13
                t1.setText(""); // node 13
                operator = "-"; // node 13
            } else {
                updateTextField("-"); // node 14
            }
        } else {
            if (e.getSource() == badd || e.getSource() == bmul || e.getSource() == bdiv) { // node 15
                s1 = currentText; // node 16
                t1.setText(""); // node 16
                operator = e.getActionCommand();
            } else {
                updateTextField(e.getActionCommand()); // node 17
            }
        }
    }

    public static void main(String[] args) {
        new MainUI();
    }

    public void setVisible(boolean b) {
        f.setVisible(b);
    }

    public void dispose() {
        f.dispose();
    }

    // Fungsi untuk mengupdate TextField dengan nilai baru
    private void updateTextField(String value) {
        String currentText = t1.getText();
        t1.setText(currentText + value);
    }

}
