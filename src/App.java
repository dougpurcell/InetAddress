import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class App {
    private JPanel mainPanel;
    private JButton dQuadToSymButton;
    private JButton symToDQuadButton;
    private JLabel dQuadLabel;
    private JLabel symbolicLabel;
    private JTextField symbolicText;
    private JTextField dQuadText;

    public App() {

        // controls for dQuad to symbolic button
        dQuadToSymButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    symbolicText.setText(dQuadInet(dQuadText.getText()));
                    System.out.println("symbolic is " + dQuadInet(dQuadText.getText()));

                } catch (UnknownHostException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // controls for symbolic to dQuad button
        symToDQuadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dQuadText.setText(symbolicInet(symbolicText.getText()));
                    System.out.println("dQuad is " + symbolicInet(symbolicText.getText()));

                } catch (UnknownHostException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    // dQuad Input (127.01.01.01), Symbolic output
    public String dQuadInet(String s) throws UnknownHostException {
        try {
            InetAddress dQuadInet = InetAddress.getByName(s);
            String s1 = dQuadInet.getHostName();
            return s1;
        }
        catch (UnknownHostException ex) {
            return "Couldn't find that Host Name.";
        }
    }

    // Symbolic Input (www.example.com), DQuad output
    public String symbolicInet(String s) throws UnknownHostException {
        try {
            InetAddress symbolicInet = InetAddress.getByName(s);
            String s1 = symbolicInet.toString();
            String s2 = s1.substring(s1.indexOf("/") + 1);
            return s2;
        }
        catch (UnknownHostException ex) {
            return "Couldn't find that URL.";
        }
    }

    // Main Method
    public static void main(String[] args) {
        JFrame frame = new JFrame("InetAddress");
        frame.setContentPane(new App().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,400);
        frame.setVisible(true);
    }
}
