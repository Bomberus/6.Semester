import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Client extends JFrame implements ActionListener, UIListener {
    private ClientModel model;
    private JLabel clockLabel;
    private JTable eventTable;
    private JButton submitEvent;
    private JTextField newEventDate;
    private JTextField newEventDesc;
    private JTextArea loggedEvents;
    private JButton refreshBtn;

    public Client() throws Exception{
        super("RMI Client");
        buildUI();
        //initDataBinding();
    }

    public static void main(String args[]) throws Exception {
        Client client = new Client();
        new LoginDialog(client);
    }

    private void buildUI(){
        //Close Connection
        Runtime.getRuntime().addShutdownHook(new Thread(this::closeDataBinding));

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Data Bindings Demo");
        this.getContentPane().setLayout(new BorderLayout());

        //Clock
        this.clockLabel = new JLabel("                                                                           ");
        this.clockLabel.setFont(new Font("TimesRoman", Font.PLAIN, 18));
        this.clockLabel.setHorizontalAlignment(JLabel.CENTER);
        this.clockLabel.setVerticalAlignment(JLabel.CENTER);

        this.add(this.clockLabel, BorderLayout.NORTH);

        //Events
        JPanel p = new JPanel(new BorderLayout());

        //Event Form
        JPanel edit = new JPanel();
        BoxLayout boxlayout = new BoxLayout(edit, BoxLayout.Y_AXIS);
        edit.setLayout(boxlayout);

        edit.add(new JLabel("Add a new Event"));
        edit.add(new JLabel("Date"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        this.newEventDate = new JTextField(sdf.format(new Date()));
        this.newEventDate.setMaximumSize(new Dimension(500,25));
        edit.add(this.newEventDate);
        edit.add(new JLabel("Description"));
        this.newEventDesc = new JTextField();
        this.newEventDesc.setMaximumSize(new Dimension(500,25));
        edit.add(this.newEventDesc);
        this.submitEvent = new JButton("Abschicken");
        this.submitEvent.addActionListener(this);
        edit.add(this.submitEvent);

        p.add(edit,BorderLayout.WEST);

        //Event Table
        JPanel view = new JPanel();
        boxlayout = new BoxLayout(view, BoxLayout.Y_AXIS);
        view.setLayout(boxlayout);

        view.add(new JLabel("Zukünftige Events:"));
        this.refreshBtn = new JButton("Refresh Tabelle");
        this.refreshBtn.addActionListener(this);
        view.add(refreshBtn);
        this.eventTable = new JTable();
        JScrollPane pane = new JScrollPane(this.eventTable);
        view.add(pane);

        p.add(view,BorderLayout.EAST);
        this.add(p,BorderLayout.CENTER);

        //Logs

        this.loggedEvents = new JTextArea();
        this.loggedEvents.setRows(6);

        JScrollPane sp = new JScrollPane(this.loggedEvents);
        this.add(sp,BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);
    }

    public boolean initDataBinding(String host, Integer port, Client client, String RMIName){
        try {
            this.model = new ClientModel(client);
            this.model.connect(host, port, RMIName);
            return true;
        } catch (Exception e) {

            System.out.println("Could not connect ;(");
            return false;
        }
    }

    public boolean closeDataBinding(){
        System.out.println("Closing client connection");
        try {
            this.model.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void actionPerformed (ActionEvent ae){
        if(ae.getSource() == this.submitEvent){
            DateFormat formatter ;
            Date date ;
            formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                date = formatter.parse(this.newEventDate.getText());
                this.model.addEvent(new Event(date, this.newEventDesc.getText()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.refreshTable();

        }

        if (ae.getSource() == this.refreshBtn){
            this.refreshTable();
        }
    }

    public void refreshTable() {
        ArrayList<Event> futureEvents = null;
        try {
            futureEvents = this.model.getFutureEvents();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object[][] data = new Object[futureEvents.size()][];
        for (int i = 0; i < futureEvents.size(); i++){
            Event row = futureEvents.get(i);
            data[i] = new Object[]{row.getDateTime().toString(), row.getDescription()};

        }
        this.eventTable.setModel(new DefaultTableModel(data,new Object[]{"Date", "Desc"}));
        this.eventTable.repaint();
    }

    @Override
    public void retrieveEvents() {
        String log = "";
        ArrayList<Event> loggedEvents = this.model.getLoggedEvents();
        for(int i = 0; i < loggedEvents.size(); i++){
            Event event = loggedEvents.get(i);
            log += event.toString() + "\n";
        }
        this.loggedEvents.setText(log);

        this.refreshTable();
    }

    @Override
    public void shouldRefreshUI() throws Exception{
        this.clockLabel.setText(this.model.getServerTime().toString());
    }
}
