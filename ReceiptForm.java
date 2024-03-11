import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ReceiptForm extends JFrame {
    private BankAccount bankAccount;
    private String balanceType;
    private String transactionMode;
    private double amount;

    private JPanel jPanel1;
    private JLabel lblAmount;
    private JLabel lblBalance;
    private JLabel lblDate;
    private JLabel lblMode;
    private JLabel lblRef;
    private JLabel lblTime;
    private JLabel lblTitle10;
    private JLabel lblTitle3;
    private JLabel lblTitle7;
    private JLabel lblType;
    private JProgressBar progressBar;
    
    public ReceiptForm(BankAccount bankAccount,
            String balanceType,
            String transactionMode,
            double amount) {
        this.bankAccount = bankAccount;
        this.balanceType = balanceType;
        this.transactionMode = transactionMode;
        this.amount = amount;
        
        initComponents();
        setLocationRelativeTo(null);
        initializeReceipt();
        timer();
    }

    private void initializeReceipt() {
        lblDate.setText("DATE  :" + getCurrentDate());
        lblTime.setText("TIME  :" + getCurrentTime());
        lblMode.setText(transactionMode);
        lblType.setText(balanceType);
        lblAmount.setText("AMOUNT :" + amount);
        lblRef.setText("REF  #:" + getRefNumber());
        
        if (balanceType.equals("SAVINGS")) {
            lblBalance.setText("BALANCE:" + bankAccount.getSavingsBalance());
        }
        else {      
            lblAmount.setText("AMOUNT :" + amount);
            lblBalance.setText("BALANCE:" + bankAccount.getCurrentBalance());
        }
    }
    
    private String getRefNumber() {
        var random = new Random();
        var ref = random.nextInt(99999999);
        
        return ref + "";
    }
    
    private String getCurrentDate() {
        var currentDate = LocalDate.now();
        var dateFormat = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        
        return currentDate.format(dateFormat);
    }
    
    private String getCurrentTime() {
        var currentTime = LocalTime.now();
        var timeFormat = DateTimeFormatter.ofPattern("h:mm:ss a");
        
        return currentTime.format(timeFormat);
    }
    
    private void timer() {
        var timer = new Timer(100, new ActionListener() {
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                progressBar.setValue(count * 100);
                if (count == 30) {
                    ((Timer) e.getSource()).stop();
                    dispose();
                }
            }
        });
        
        timer.start();
    }
    
    private void initComponents() {

        jPanel1 = new JPanel();
        lblMode = new JLabel();
        lblBalance = new JLabel();
        lblTitle3 = new JLabel();
        lblRef = new JLabel();
        lblDate = new JLabel();
        lblTime = new JLabel();
        lblTitle7 = new JLabel();
        lblType = new JLabel();
        lblAmount = new JLabel();
        lblTitle10 = new JLabel();
        progressBar = new JProgressBar();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new Color(255, 255, 255));
        setMinimumSize(new Dimension(400, 510));
        setPreferredSize(new Dimension(400, 510));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setLayout(null);

        lblMode.setFont(new Font("Fake Receipt", 0, 18)); 
        lblMode.setForeground(new Color(16, 16, 16));
        lblMode.setText("WITHDRAW");
        jPanel1.add(lblMode);
        lblMode.setBounds(30, 37, 350, 23);

        lblBalance.setFont(new Font("Fake Receipt", 0, 18)); 
        lblBalance.setForeground(new Color(16, 16, 16));
        lblBalance.setHorizontalAlignment(SwingConstants.LEFT);
        lblBalance.setText("balance:");
        jPanel1.add(lblBalance);
        lblBalance.setBounds(30, 367, 230, 23);

        lblTitle3.setFont(new Font("Fake Receipt", 0, 18)); 
        lblTitle3.setForeground(new Color(16, 16, 16));
        lblTitle3.setText("acct #: 1234567890");
        jPanel1.add(lblTitle3);
        lblTitle3.setBounds(30, 67, 288, 23);

        lblRef.setFont(new Font("Fake Receipt", 0, 18)); 
        lblRef.setForeground(new Color(16, 16, 16));
        lblRef.setText("ref  #: ");
        jPanel1.add(lblRef);
        lblRef.setBounds(30, 97, 311, 23);

        lblDate.setFont(new Font("Fake Receipt", 0, 18)); 
        lblDate.setForeground(new Color(16, 16, 16));
        lblDate.setText("date  :");
        jPanel1.add(lblDate);
        lblDate.setBounds(30, 167, 350, 23);

        lblTime.setFont(new Font("Fake Receipt", 0, 18)); 
        lblTime.setForeground(new Color(16, 16, 16));
        lblTime.setText("time  :");
        jPanel1.add(lblTime);
        lblTime.setBounds(30, 197, 341, 23);

        lblTitle7.setFont(new Font("Fake Receipt", 0, 18)); 
        lblTitle7.setForeground(new Color(16, 16, 16));
        lblTitle7.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle7.setText("thank you!");
        jPanel1.add(lblTitle7);
        lblTitle7.setBounds(0, 421, 380, 23);

        lblType.setFont(new Font("Fake Receipt", 0, 18)); 
        lblType.setForeground(new Color(16, 16, 16));
        lblType.setHorizontalAlignment(SwingConstants.LEFT);
        lblType.setText("savings");
        jPanel1.add(lblType);
        lblType.setBounds(30, 307, 230, 23);

        lblAmount.setFont(new Font("Fake Receipt", 0, 18)); 
        lblAmount.setForeground(new Color(16, 16, 16));
        lblAmount.setHorizontalAlignment(SwingConstants.LEFT);
        lblAmount.setText("amount :");
        jPanel1.add(lblAmount);
        lblAmount.setBounds(30, 337, 230, 23);

        lblTitle10.setFont(new Font("Fake Receipt", 0, 18)); 
        lblTitle10.setForeground(new Color(16, 16, 16));
        lblTitle10.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle10.setText("chity chity bang bank");
        jPanel1.add(lblTitle10);
        lblTitle10.setBounds(0, 267, 380, 23);

        progressBar.setBackground(new Color(0, 51, 153));
        progressBar.setMaximum(3000);
        progressBar.setBorder(null);
        progressBar.setBorderPainted(false);
        jPanel1.add(progressBar);
        progressBar.setBounds(0, 0, 400, 19);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 470);

        pack();
    }
}
