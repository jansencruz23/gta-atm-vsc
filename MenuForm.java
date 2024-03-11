import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuForm extends JFrame {
    private BankAccount bankAccount;
    
    private JButton btnBalance;
    private JButton btnCancel;
    private JButton btnDeposit;
    private JButton btnWithdraw;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;

    public MenuForm(BankAccount bankAccount) {
        initComponents();
        setLocationRelativeTo(null);
        this.bankAccount = bankAccount;
    }

    private void initComponents() {

        btnBalance = new JButton();
        btnDeposit = new JButton();
        btnWithdraw = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        btnCancel = new JButton();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(850, 460));
        setPreferredSize(new Dimension(850, 460));
        setResizable(false);
        getContentPane().setLayout(null);

        btnBalance.setIcon(new ImageIcon(getClass().getResource("/img/alance.png"))); 
        btnBalance.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        btnBalance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnBalanceActionPerformed(evt);
            }
        });
        getContentPane().add(btnBalance);
        btnBalance.setBounds(580, 110, 180, 180);

        btnDeposit.setIcon(new ImageIcon(getClass().getResource("/img/deposit3.png"))); 
        btnDeposit.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        btnDeposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnDepositActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeposit);
        btnDeposit.setBounds(110, 110, 180, 180);

        btnWithdraw.setIcon(new ImageIcon(getClass().getResource("/img/www.png")));
        btnWithdraw.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        btnWithdraw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnWithdrawActionPerformed(evt);
            }
        });
        getContentPane().add(btnWithdraw);
        btnWithdraw.setBounds(345, 110, 180, 180);

        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setIcon(new ImageIcon(getClass().getResource("/img/deposit.png")));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(110, 310, 180, 20);

        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setIcon(new ImageIcon(getClass().getResource("/img/ww.png"))); 
        getContentPane().add(jLabel2);
        jLabel2.setBounds(350, 305, 170, 30);

        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setIcon(new ImageIcon(getClass().getResource("/img/b.png"))); 
        getContentPane().add(jLabel3);
        jLabel3.setBounds(590, 300, 160, 40);

        btnCancel.setBackground(new Color(255, 102, 102));
        btnCancel.setIcon(new ImageIcon(getClass().getResource("/img/cancel.png"))); 
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel);
        btnCancel.setBounds(640, 363, 120, 40);

        jLabel4.setFont(new Font("Pricedown", 0, 48)); 
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setIcon(new ImageIcon(getClass().getResource("/img/menu.png"))); 
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 20, 850, 70);

        jLabel5.setIcon(new ImageIcon(getClass().getResource("/img/enu.png"))); 
        getContentPane().add(jLabel5);
        jLabel5.setBounds(-3, -4, 860, 470);

        pack();
    }

    private void btnDepositActionPerformed(ActionEvent evt) {
        this.dispose();
        new AccountForm(bankAccount, "DEPOSIT").setVisible(true);
    }

    private void btnWithdrawActionPerformed(ActionEvent evt) {
        this.dispose();
        new AccountForm(bankAccount, "WITHDRAW").setVisible(true);
    }

    private void btnBalanceActionPerformed(ActionEvent evt) {
        this.dispose();
        new AccountForm(bankAccount, "BALANCE").setVisible(true);
    }

    private void btnCancelActionPerformed(ActionEvent evt) {
        this.dispose();
        new LoginForm(bankAccount).setVisible(true);
    }
}
