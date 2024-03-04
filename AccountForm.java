import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountForm extends JFrame {
    private BankAccount bankAccount;
    private String action;
    
    private JButton btnBack;
    private JButton btnCancel;
    private JButton btnCurrent;
    private JButton btnSavings;
    private JLabel jLabel1;

    public AccountForm(BankAccount bankAccount, String action) {
        initComponents();
        setLocationRelativeTo(null);
        
        this.bankAccount = bankAccount;
        this.action = action;
    }

    private void initComponents() {

        btnSavings = new JButton();
        btnCurrent = new JButton();
        btnCancel = new JButton();
        btnBack = new JButton();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new Dimension(850, 460));
        setMinimumSize(new Dimension(850, 460));
        setPreferredSize(new Dimension(850, 460));
        setResizable(false);
        setSize(new Dimension(850, 460));
        getContentPane().setLayout(null);

        btnSavings.setIcon(new ImageIcon(getClass().getResource("/img/savings.png"))); 
        btnSavings.setText("   ");
        btnSavings.setHorizontalAlignment(SwingConstants.LEFT);
        btnSavings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSavingsActionPerformed(evt);
            }
        });
        getContentPane().add(btnSavings);
        btnSavings.setBounds(90, 210, 510, 50);

        btnCurrent.setIcon(new ImageIcon(getClass().getResource("/img/current.png"))); 
        btnCurrent.setText("   ");
        btnCurrent.setHorizontalAlignment(SwingConstants.LEFT);
        btnCurrent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCurrentActionPerformed(evt);
            }
        });
        getContentPane().add(btnCurrent);
        btnCurrent.setBounds(90, 130, 510, 50);

        btnCancel.setBackground(new Color(255, 102, 102));
        btnCancel.setForeground(new Color(255, 102, 102));
        btnCancel.setIcon(new ImageIcon(getClass().getResource("/img/cancel.png"))); 
        btnCancel.setToolTipText("");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel);
        btnCancel.setBounds(640, 330, 120, 40);

        btnBack.setBackground(new Color(204, 204, 204));
        btnBack.setIcon(new ImageIcon(getClass().getResource("/img/back.png"))); 
        btnBack.setMaximumSize(new Dimension(75, 23));
        btnBack.setMinimumSize(new Dimension(75, 23));
        btnBack.setPreferredSize(new Dimension(75, 23));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(490, 330, 120, 40);

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/img/acc.png"))); 
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-3, 0, 860, 460);

        pack();
    }

    private void btnBackActionPerformed(ActionEvent evt) {
        this.dispose();
        new MenuForm(bankAccount).setVisible(true);
    }

    private void btnCancelActionPerformed(ActionEvent evt) {
        this.dispose();
        new LoginForm(bankAccount).setVisible(true);
    }

    private void btnCurrentActionPerformed(ActionEvent evt) {
        openForm("CURRENT");
    }

    private void btnSavingsActionPerformed(java.awt.event.ActionEvent evt) {
        openForm("SAVINGS");
    }

    private void openForm(String balanceType) {
        this.dispose();
        
        switch (action) {
            case "DEPOSIT":
                new DepositForm(bankAccount, balanceType).setVisible(true);
                break;
            case "WITHDRAW":
                new WithdrawForm(bankAccount, balanceType).setVisible(true);
                break;
            case "BALANCE":
                new BalanceForm(bankAccount, balanceType).setVisible(true);
                break;
        }
    }
}
