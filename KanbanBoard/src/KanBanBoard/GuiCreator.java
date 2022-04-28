package KanBanBoard;

import static KanBanBoard.Main.*;
import java.awt.*;
import javax.swing.*;

public class GuiCreator {

    public static void GetPanelLocation() {
        //Math which finds the top left corner for 2nd panel to be centre  

        panelx = (winWidth - panelWidth) / 2;
        panely = (winHeight - panelHeight) / 2;
    }

    public static void GUICreater() {
        
        //<editor-fold desc="Home Frame initialization">
        winWidth = 1280;
        winHeight = 720;
        Homeframe.setSize(winWidth, winHeight);
        Homeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Homeframe.setLocationRelativeTo(null);

        Homeframe.add(pnlWindow);
        Homeframe.add(pnlLogin);
        Homeframe.add(pnlSignUp);
        Homeframe.add(pnlBckgrd);

        pnlBckgrd.setLayout(null);
        Homeframe.setResizable(false);

        //Assigning an image to a label which is used as background image.
        ImageIcon myImg = new ImageIcon("Mountain.jpg");
        myImg.setImage(myImg.getImage()
                .getScaledInstance(winWidth, winHeight, Image.SCALE_DEFAULT));
        JLabel bckImg = new JLabel(myImg);
        bckImg.setBounds(1, 1, winWidth, winHeight);
        Color c = new Color(0f, .5f, 1f, .85f);

        pnlLogin.setBackground(c);
        pnlWindow.setBackground(c);
        pnlSignUp.setBackground(c);
        pnlBckgrd.add(bckImg);
        pnlLogin.setVisible(false);
        pnlSignUp.setVisible(false);
        pnlWindow.setVisible(false);

        //</editor-fold>
        
        //creates object so that Login class can be called and used
        Login objLogin = new Login();
    }

    public static void GUIHomeScreen() {

        //calls Gui creator method
        GUICreater();
        //<editor-fold desc="GUI Creation">
        panelWidth = 250;
        panelHeight = 300;
        GetPanelLocation();
        pnlWindow.setLayout(null);
        pnlWindow.setBounds(panelx, panely, panelWidth, panelHeight);

        JLabel lblTitle = new JLabel("Please Select an Option:");
        lblTitle.setFont(new Font("Serif", Font.BOLD, 20));
        lblTitle.setBounds(30, 50, 220, 25);

        JButton btnLogin = new JButton("Log In");
        btnLogin.setFont(new Font ("Microsoft Sans Serif", Font.BOLD, 16));
        btnLogin.setBackground(Color.WHITE);
        btnLogin.setBounds(40, 150, 180, 25);

        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.setFont(new Font ("Sans Serif", Font.BOLD, 16));
        btnSignUp.setBackground(Color.WHITE);
        btnSignUp.setBounds(40, 180, 180, 25);

        //</editor-fold>
        btnLogin.addActionListener((e) -> {
            GUILogIn();
            pnlWindow.setVisible(false);
        });

        btnSignUp.addActionListener((e) -> {
            pnlWindow.setVisible(false);
            GUIBuildSignup();

        });

        pnlWindow.add(lblTitle);
        pnlWindow.add(btnLogin);
        pnlWindow.add(btnSignUp);

        pnlWindow.setVisible(true);
        Homeframe.setVisible(true);

    }

    public static void GUILogIn() {
        
        //<editor-fold desc="GuiCreation">
        panelWidth = 375;
        panelHeight = 250;
        GetPanelLocation();
        pnlLogin.setBounds(panelx, panely, panelWidth, panelHeight);

        pnlLogin.setLayout(null);

        JLabel lblUser = new JLabel("Username");
        lblUser.setFont(new Font("Sans", Font.BOLD, 16));
        lblUser.setBounds(((panelWidth-80)/2), 20, 80, 25);
        pnlLogin.add(lblUser);

        JTextField txtUser = new JTextField(20);
        txtUser.setBounds(100, 45, 165, 25);
        pnlLogin.add(txtUser);
        txtUser.setText("");

        JLabel lblPWord = new JLabel("Password");
        lblPWord.setFont(new Font("Sans", Font.BOLD, 16));
        lblPWord.setBounds(((panelWidth-80)/2), 70, 80, 25);
        pnlLogin.add(lblPWord);

        JPasswordField txtPWord = new JPasswordField();
        txtPWord.setBounds(100, 95, 165, 25);
        txtPWord.setEchoChar('*');
        pnlLogin.add(txtPWord);
        txtPWord.setText("");

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(((panelWidth-80)/2), 130, 80, 25);
        btnLogin.setBackground(Color.WHITE);
        pnlLogin.add(btnLogin);

        JButton btnBack = new JButton("Home");
        btnBack.setBounds(panelWidth-100, panelHeight-50, 75, 25);
        btnBack.setBackground(Color.WHITE);
        pnlLogin.add(btnBack);
        
        JCheckBox btnShowPw = new JCheckBox("SHOW");
        btnShowPw.setBounds(270, 95, 75, 25);
        btnShowPw.setBackground(Color.WHITE);
        pnlLogin.add(btnShowPw);

       
        //</editor-fold>
        
        btnShowPw.addChangeListener((e) -> {
          if (btnShowPw.isSelected() == true) {
            txtPWord.setEchoChar((char)0);
        } else if (btnShowPw.isSelected() == false) {
            txtPWord.setEchoChar('*');
        }

        });
        
    
        btnLogin.addActionListener((e) -> {
            inptUn = txtUser.getText();
            inptPw = txtPWord.getText();

            Login.returnloginStatus();
        });

        btnBack.addActionListener((e) -> {
            pnlLogin.setVisible(false);
            pnlWindow.setVisible(true);

        });

        pnlLogin.setVisible(true);

    }

    public static void GUIBuildSignup() {

        //<editor-fold desc="GuiCreation">
        panelWidth = 375;
        panelHeight = 250;
        GetPanelLocation();
        pnlSignUp.setBounds(panelx, panely, 375, 250);

        pnlSignUp.setLayout(null);

        JLabel lblUser = new JLabel("Username");
        lblUser.setBounds(10, 20, 165, 25);
        pnlSignUp.add(lblUser);

        JTextField txtUser = new JTextField(5);
        txtUser.setBounds(100, 20, 165, 25);
        pnlSignUp.add(txtUser);
        txtUser.setText("");

        JLabel lblPWord = new JLabel("Password");
        lblPWord.setBounds(10, 50, 80, 25);
        pnlSignUp.add(lblPWord);

        JPasswordField txtPword = new JPasswordField();
        txtPword.setText("");
        txtPword.setBounds(100, 50, 165, 25);
        txtPword.setEchoChar('*');
        pnlSignUp.add(txtPword);

        JLabel lblFirstName = new JLabel("First Name");
        lblFirstName.setBounds(10, 80, 80, 25);
        pnlSignUp.add(lblFirstName);

        JTextField txtFname = new JTextField(20);
        txtFname.setBounds(100, 80, 165, 25);
        pnlSignUp.add(txtFname);

        JLabel lblSurname = new JLabel("Surname");
        lblSurname.setBounds(10, 110, 80, 25);
        pnlSignUp.add(lblSurname);

        JTextField txtSurname = new JTextField(20);
        txtSurname.setBounds(100, 110, 165, 25);
        pnlSignUp.add(txtSurname);

        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.setBounds(30, 140, 80, 25);
        btnSignUp.setBackground(Color.WHITE);
        pnlSignUp.add(btnSignUp);

        JCheckBox btnShowPw = new JCheckBox("SHOW");
        btnShowPw.setBounds(270, 50, 75, 25);
        btnShowPw.setBackground(Color.WHITE);
        pnlSignUp.add(btnShowPw);

        JButton btnHome = new JButton("Home");
        btnHome.setBounds(270, 180, 75, 25);
        pnlSignUp.add(btnHome);

        //</editor-fold>
        
        btnShowPw.addChangeListener((e) -> {

        if (btnShowPw.isSelected() == true) {
            txtPword.setEchoChar((char)0);
        } else if (btnShowPw.isSelected() == false) {
            txtPword.setEchoChar('*');
        }

        });

        btnSignUp.addActionListener((var e) -> {
            inptPw = txtPword.getText();
            inptUn = txtUser.getText();
            inptFn = txtFname.getText();
            inptSurname = txtSurname.getText();

            Login.registerUser();
        });

        btnHome.addActionListener((e) -> {
            pnlSignUp.setVisible(false);
            pnlWindow.setVisible(true);
        });

        pnlSignUp.setVisible(true);
    }
}
