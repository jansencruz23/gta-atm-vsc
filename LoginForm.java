import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private BankAccount bankAccount;

    private JButton btnCancel;
    private JButton btnEnter;
    private JEditorPane jEditorPane1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JScrollPane jScrollPane1;
    private JPasswordField txtPin;

    public LoginForm() {
        initComponents();
        setLocationRelativeTo(null);
        bankAccount = new BankAccount();
    }
    
    public LoginForm(BankAccount bankAccount) {
        initComponents();
        this.bankAccount = bankAccount;
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        jEditorPane1 = new JEditorPane();
        jLabel1 = new JLabel();
        btnCancel = new JButton();
        btnEnter = new JButton();
        txtPin = new JPasswordField();
        jLabel6 = new JLabel();
        jLabel5 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new Color(255, 255, 255));
        setMinimumSize(new Dimension(850, 460));
        setResizable(false);
        setSize(new Dimension(850, 460));
        getContentPane().setLayout(null);

        jLabel1.setFont(new Font("Pricedown Bl", 0, 24)); 
        jLabel1.setForeground(new Color(51, 51, 51));
        jLabel1.setIcon(new ImageIcon(getClass().getResource("/img/pin.png"))); 
        getContentPane().add(jLabel1);
        jLabel1.setBounds(280, 140, 300, 30);

        btnCancel.setBackground(new Color(255, 102, 102));
        btnCancel.setFont(new Font("Pricedown Bl", 0, 18)); 
        btnCancel.setForeground(new Color(255, 255, 255));
        btnCancel.setIcon(new ImageIcon(getClass().getResource("/img/cancel.png"))); 
        btnCancel.setMaximumSize(new Dimension(72, 23));
        btnCancel.setMinimumSize(new Dimension(72, 23));
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel);
        btnCancel.setBounds(440, 270, 150, 40);

        btnEnter.setBackground(new Color(153, 255, 153));
        btnEnter.setFont(new Font("Pricedown Bl", 0, 18)); 
        btnEnter.setForeground(new Color(51, 51, 51));
        btnEnter.setIcon(new ImageIcon(getClass().getResource("/img/enter.png")));
        btnEnter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnter);
        btnEnter.setBounds(270, 270, 150, 40);

        txtPin.setFont(new Font("Arial Rounded MT Bold", 0, 14)); 
        txtPin.setHorizontalAlignment(JTextField.CENTER);
        getContentPane().add(txtPin);
        txtPin.setBounds(280, 170, 300, 50);

        jLabel6.setIcon(new ImageIcon(getClass().getResource("/img/logo2.png"))); 
        getContentPane().add(jLabel6);
        jLabel6.setBounds(-30, 280, 320, 180);

        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setIcon(new ImageIcon(getClass().getResource("/img/sub.png")));
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 20, 850, 33);

        jLabel2.setFont(new Font("Pricedown", 0, 48)); 
        jLabel2.setForeground(new Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setIcon(new ImageIcon(getClass().getResource("/img/logo.png"))); 
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 30, 850, 90);

        jLabel3.setIcon(new ImageIcon(getClass().getResource("/img/gta2.jpg"))); 
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, -10, 850, 460);

        jLabel4.setFont(new Font("Pricedown", 0, 48)); 
        jLabel4.setForeground(new Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setIcon(new ImageIcon(getClass().getResource("/img/logo.png"))); 
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 30, 850, 90);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnterActionPerformed(ActionEvent evt) {
        String password = String.valueOf(txtPin.getPassword());
        
        if (password.equals(bankAccount.getPinNumber())) {
            this.dispose();
            new MenuForm(bankAccount).setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(this, "Incorrect PIN. Try again.");
        }
    }

    private void btnCancelActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }
}
