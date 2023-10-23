import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.NumberFormat;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class App extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField schueler;
    JTextField geschlecht;
    JTextField noten;
    JButton submit;
    JButton close;
    JLabel output_label;

    public App() {
        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);
        
        this.addWindowListener(new WindowListener() {
            public void windowClosed(WindowEvent we) {}
            public void windowClosing (WindowEvent we) {
                System.exit(0);
            }
            public void windowActivated(WindowEvent we) {}
            public void windowDeactivated(WindowEvent we) {}
            public void windowDeiconified(WindowEvent we) {}
            public void windowIconified(WindowEvent we) {}
            public void windowOpened(WindowEvent we) {}
        } );


        JLabel schueler_label = new JLabel("Name der/des Schüler/in:");
        JLabel geschlecht_label = new JLabel("Geschlecht: m / w");
        JLabel noten_label = new JLabel("<html>Noten: Die jeweilige Anzahl der 1er, 2er, 3er usw.<br> " +
        "mit Beistrichen trenne z.B. 2,1,3,0,0</html>");
        JLabel output_label = new JLabel();

        JButton submit = new JButton("Anzeigen");
        JButton close = new JButton("Schließen");

        schueler = new JTextField();
        geschlecht = new JTextField();
        noten = new JTextField();

        schueler_label.setSize(400, 25);
        schueler_label.setLocation(10, 10);

        geschlecht_label.setSize(400, 25);
        geschlecht_label.setLocation(10, 55);

        noten_label.setSize(400, 50);
        noten_label.setLocation(10, 95);

        output_label.setSize(400, 50);
        output_label.setLocation(10, 200);

        schueler.setBounds(10, 35, 200, 20);
        geschlecht.setBounds(10, 80, 200, 20);
        noten.setBounds(10, 140, 200, 20);

        submit.setBounds(10, 170, 130, 20);
        close.setBounds(150, 170, 130, 20);

        contentPane.add(schueler_label);
        contentPane.add(geschlecht_label);
        contentPane.add(noten_label);
        contentPane.add(output_label);

        contentPane.add(schueler);
        contentPane.add(geschlecht);
        contentPane.add(noten);

        contentPane.add(submit);
        contentPane.add(close);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                show_grade_average();
            }
        });

        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                quit();
            }
        });

        this.pack();
        this.setBounds(10, 10, 400, 300);
    }

    protected void show_grade_average() {
        String schueler_data = schueler.getText();
        String geschlecht_data = geschlecht.getText();
        String[] noten_strings = noten.getText().split(",");

        int[] noten_numbers = new int[noten_strings.length];
        for (int i=0; i<noten_numbers.length; i++) {
            try {
                noten_numbers[i] = Integer.parseInt(noten_strings[i]);
            } catch (NumberFormatException nfe) {
                noten_numbers[i] = 0;
            }
        }

        int noten_sum = Arrays.stream(noten_numbers).sum();
        output_label.setText(
            (noten_sum > 0) ? String.format("Es wurden %d Noten eingegeben.", noten_sum) : "Es wurde 1 Note eingegeben."
        );
        Arrays.copyOfRange(noten_numbers, 2, noten_numbers.length-1);

        if (noten_numbers[i] > 0 &&
        
    }

    protected void quit() {
        System.exit(0);
    }
}