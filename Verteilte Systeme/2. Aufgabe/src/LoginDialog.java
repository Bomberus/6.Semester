import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginDialog extends JFrame implements ActionListener {

    private boolean isConnected;

    private JButton connectButton;
    private JButton disconnectButton;
    private JTextField hostText;
    private JTextField portText;
    private JTextField rmiText;
    private JLabel statusLabel;

    private Client client;

    public LoginDialog(Client client){
        super("Login into Service");
        this.setSize(300, 200);

        JPanel panel = new JPanel();
        this.add(panel);
        placeComponents(panel);

        this.client = client;

        this.setVisible(true);
    }

    private void placeComponents(JPanel panel) {

        panel.setLayout(null);

        JLabel hostLabel = new JLabel("Host");
        hostLabel.setBounds(10, 10, 80, 25);
        panel.add(hostLabel);

        hostText = new JTextField(20);
        hostText.setText("localhost");
        hostText.setBounds(100, 10, 160, 25);
        panel.add(hostText);

        JLabel portLabel = new JLabel("Port");
        portLabel.setBounds(10, 40, 80, 25);
        panel.add(portLabel);

        portText = new JTextField(20);
        portText.setText("7575");
        portText.setBounds(100, 40, 160, 25);
        panel.add(portText);

        JLabel rmiLabel = new JLabel("RMI-Name");
        rmiLabel.setBounds(10, 70, 80, 25);
        panel.add(rmiLabel);

        rmiText = new JTextField(20);
        rmiText.setText("RMIServer");
        rmiText.setBounds(100, 70, 160, 25);
        panel.add(rmiText);

        connectButton = new JButton("On");
        connectButton.setBounds(10, 110, 80, 25);
        connectButton.addActionListener(this);
        panel.add(connectButton);

        disconnectButton = new JButton("Off");
        disconnectButton.setBounds(180, 110, 80, 25);
        disconnectButton.addActionListener(this);
        panel.add(disconnectButton);

        statusLabel = new JLabel("Nicht verbunden");
        statusLabel.setBounds(10, 140, 180, 25);
        panel.add(statusLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.connectButton) {
            if (this.client.initDataBinding(this.hostText.getText(), Integer.parseInt(this.portText.getText()), this.client, this.rmiText.getText())) {
                this.statusLabel.setText("Connected");
            }
            else{
                this.statusLabel.setText("Error while connecting");
            }
        }
        if (e.getSource() == this.disconnectButton) {
            if (this.client.closeDataBinding()) {
                this.statusLabel.setText("Disconnected");
            }
            else{
                this.statusLabel.setText("Error while disconnecting");
            }
        }
    }
}
