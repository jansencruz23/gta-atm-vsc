import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BalanceForm extends JFrame {
    private BankAccount bankAccount;
    private String balanceType;

    private JButton btnBack;
    private JButton btnCancel;
    private JLabel jLabel1;
    private JLabel lblTitle;
    private JTextField txtBalance;
    
    public BalanceForm(BankAccount bankAccount, String balanceType) {
        initComponents();
        setLocationRelativeTo(null);
        
        this.bankAccount = bankAccount;
        this.balanceType = balanceType;
        displayBalance();
    }
    
    private void displayBalance() {
        if (balanceType.equals("CURRENT")) {
            lblTitle.setIcon(new ImageIcon(getClass().getResource("/img/currentbalance.png")));
            txtBalance.setText(bankAccount.getCurrentBalance() + "");
        }
        else {
            lblTitle.setIcon(new ImageIcon(getClass().getResource("/img/savingsbalance.png")));
            txtBalance.setText(bankAccount.getSavingsBalance() + "");
        }
    }

    private void initComponents() {

        lblTitle = new JLabel();
        txtBalance = new JTextField();
        btnBack = new JButton();
        btnCancel = new JButton();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(850, 460));
        setPreferredSize(new Dimension(850, 460));
        setResizable(false);
        getContentPane().setLayout(null);

        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setIcon(new ImageIcon(getClass().getResource("/img/currentbalance.png"))); 
        getContentPane().add(lblTitle);
        lblTitle.setBounds(0, 30, 850, 50);

        txtBalance.setEditable(false);
        txtBalance.setFont(new Font("Pricedown Bl", 0, 36)); 
        getContentPane().add(txtBalance);
        txtBalance.setBounds(281, 136, 300, 50);

        btnBack.setBackground(new Color(204, 204, 204));
        btnBack.setIcon(new ImageIcon(getClass().getResource("/img/back.png"))); 
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(270, 230, 150, 40);

        btnCancel.setBackground(new Color(255, 102, 102));
        btnCancel.setIcon(new ImageIcon(getClass().getResource("/img/cancel.png"))); 
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel);
        btnCancel.setBounds(440, 230, 150, 40);

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/img/gta5.png"))); 
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-3, 0, 860, 460);

        pack();
    }

    private void btnBackActionPerformed(ActionEvent evt) {
        this.dispose();
        new AccountForm(bankAccount, "BALANCE").setVisible(true);
    }

    private void btnCancelActionPerformed(ActionEvent evt) {
        this.dispose();
        new LoginForm(bankAccount).setVisible(true);
    }
}
