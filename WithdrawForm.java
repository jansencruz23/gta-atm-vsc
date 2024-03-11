import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawForm extends JFrame {
    private BankAccount bankAccount;
    private String balanceType;

    private JButton btn1000;
    private JButton btn2000;
    private JButton btn3000;
    private JButton btnCancel;
    private JButton btnClear;
    private JButton btnEnter;
    private JLabel jLabel1;
    private JLabel lblTitle;
    private JTextField txtWithdraw;
    
    public WithdrawForm(BankAccount bankAccount, String balanceType) {
        initComponents();
        setLocationRelativeTo(null);
        
        this.bankAccount = bankAccount;
        this.balanceType = balanceType;
    }

    private void initComponents() {

        txtWithdraw = new JTextField();
        btnCancel = new JButton();
        btn3000 = new JButton();
        btnClear = new JButton();
        btnEnter = new JButton();
        btn1000 = new JButton();
        btn2000 = new JButton();
        lblTitle = new JLabel();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(850, 460));
        setPreferredSize(new Dimension(850, 460));
        setResizable(false);
        getContentPane().setLayout(null);

        txtWithdraw.setFont(new Font("Pricedown Bl", 0, 36)); 
        txtWithdraw.setHorizontalAlignment(JTextField.CENTER);
        getContentPane().add(txtWithdraw);
        txtWithdraw.setBounds(281, 136, 300, 50);

        btnCancel.setBackground(new Color(255, 102, 102));
        btnCancel.setIcon(new ImageIcon(getClass().getResource("/img/cancel.png"))); 
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel);
        btnCancel.setBounds(530, 230, 110, 40);

        btn3000.setBackground(new Color(102, 102, 102));
        btn3000.setIcon(new ImageIcon(getClass().getResource("/img/3000.png"))); 
        btn3000.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn3000ActionPerformed(evt);
            }
        });
        getContentPane().add(btn3000);
        btn3000.setBounds(530, 300, 110, 40);

        btnClear.setBackground(new Color(255, 255, 102));
        btnClear.setIcon(new ImageIcon(getClass().getResource("/img/clear.png"))); 
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear);
        btnClear.setBounds(380, 230, 110, 40);

        btnEnter.setBackground(new Color(153, 255, 153));
        btnEnter.setIcon(new ImageIcon(getClass().getResource("/img/enter.png"))); 
        btnEnter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnter);
        btnEnter.setBounds(230, 230, 110, 40);

        btn1000.setBackground(new Color(102, 102, 102));
        btn1000.setIcon(new ImageIcon(getClass().getResource("/img/1000.png"))); 
        btn1000.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn1000ActionPerformed(evt);
            }
        });
        getContentPane().add(btn1000);
        btn1000.setBounds(230, 300, 110, 40);

        btn2000.setBackground(new Color(102, 102, 102));
        btn2000.setIcon(new ImageIcon(getClass().getResource("/img/2000.png"))); 
        btn2000.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn2000ActionPerformed(evt);
            }
        });
        getContentPane().add(btn2000);
        btn2000.setBounds(380, 300, 110, 40);

        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setIcon(new ImageIcon(getClass().getResource("/img/withdrawbig.png"))); 
        getContentPane().add(lblTitle);
        lblTitle.setBounds(0, 30, 850, 50);

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/img/gta4.png"))); 
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-3, 0, 850, 460);

        pack();
    }

    private void btnCancelActionPerformed(ActionEvent evt) {
        this.dispose();
        new MenuForm(bankAccount).setVisible(true);
    }

    private void btn3000ActionPerformed(ActionEvent evt) {
        txtWithdraw.setText("3000");
    }

    private void btnEnterActionPerformed(ActionEvent evt) {
       try {
            double money = Double.parseDouble(txtWithdraw.getText());
            double accountBalance = balanceType.equals("CURRENT") 
                    ? bankAccount.getCurrentBalance() 
                    : bankAccount.getSavingsBalance();

            if (accountBalance >= money) {
                if (balanceType.equals("CURRENT")) {
                    bankAccount.setCurrentBalance(accountBalance - money);
                } 
                else {
                    bankAccount.setSavingsBalance(accountBalance - money);
                }
                
                promptReceipt(money);
                promptNewTransaction();
            } 
            else {
                JOptionPane.showMessageDialog(this, "Balance is insufficient.");
            }
        } 
       catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid withdrawal amount.");
        }
    }

    private void promptReceipt(double amount) {
        int optionReceipt = JOptionPane.showConfirmDialog(this, "Do you want to print a receipt?",
                "Print Receipt", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (optionReceipt == JOptionPane.YES_OPTION) {
            new ReceiptForm(bankAccount, balanceType, "WITHDRAW", amount).setVisible(true);
        }
    }
    
    private void promptNewTransaction() {
        int optionNew = JOptionPane.showConfirmDialog(this, "Do you want another transaction?",
            "Withdraw Successful", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (optionNew == JOptionPane.YES_OPTION) {
            this.dispose();
            new MenuForm(bankAccount).setVisible(true);
        }
        else {
            this.dispose();
            new LoginForm(bankAccount).setVisible(true);
        }
    }
    
    private void btn1000ActionPerformed(ActionEvent evt) {
        txtWithdraw.setText("1000");
    }

    private void btn2000ActionPerformed(ActionEvent evt) {
        txtWithdraw.setText("2000");
    }

    private void btnClearActionPerformed(ActionEvent evt) {
        txtWithdraw.setText("");
    }
}
