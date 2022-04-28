package KanBanBoard;

import static KanBanBoard.Main.*;
import javax.swing.JOptionPane;

public class Login {

    public static Boolean LoginUser(String un, String pw) {

        boolean flagUn, flagPw;
        flagPw = false;
        flagUn = false;
        int icatch = 0;

        int i;

        for (i = 0; i < arrUn.size(); i++) {

            if ((arrUn.get(i)).equals(inptUn)) {
                flagUn = true;
                if (arrPw.get(i).equals(inptPw)) {
                    flagPw = true;
                    icatch = i;
                    break;
                }
            } else {
                flagPw = false;
                flagUn = false;
            }
        }

        inptFn = arrFname.get(icatch);
        inptSurname = arrSurnames.get(icatch);

        if (flagPw == true && flagUn == true) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    public static Boolean checkUserName(String un) {
        //Parameters
        final int LENGTH = 5;

        //Vars which will be intialied from input
        boolean Underscore = Boolean.FALSE;
        int unLength;

        unLength = un.length();

        //Checks for Underscore
        if (un.contains("_")) {
            Underscore = Boolean.TRUE;
        }

        if (unLength <= LENGTH && Underscore == Boolean.TRUE) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    public static Boolean checkPasswordComplexity(String pw) {
        //Password Parameters
        final int UPPCASE = 1;
        final int LENGTH = 8;
        final int DIGITS = 1;
        final int SPECIAL = 1;

        //Declaring varibles which will be checked against parameters
        int numUpper = 0;
        int pswLength = 0;
        int numDigits = 0;
        int numSpecial = 0;

        pswLength = pw.length();

        //Loop through each character of password
        for (int i = 0; i < pswLength; i++) {

            char ch = pw.charAt(i);

            /*if the selected character is one of the parameters the 
            int count increases for that parameter*/
            if (Character.isUpperCase(ch)) {
                numUpper++;
            } else if (Character.isDigit(ch)) {
                numDigits++;
            } else if (containsSpecialCharacter(Character.toString(ch))) {
                numSpecial++;
                //Calls check special character method and then adds to count 
                //if true
            }
        }

        /*Checking if the amount of each parameter in the inputted password
          satisfies the requirements*/
        if (numUpper >= UPPCASE && pswLength >= LENGTH && numDigits >= DIGITS
                && numSpecial >= SPECIAL) {
            return (Boolean.TRUE);

        } else {
            return (Boolean.FALSE);
        }
    }

    public static void registerUser() {

        if (checkUserName(inptUn) == Boolean.TRUE) {
            JOptionPane.showMessageDialog(null, "Username successfully captured");

        } else {

            JOptionPane.showMessageDialog(null, "Username not correctly "
                    + "formatted, please ensure"
                    + " that your username contains an underscore and is no"
                    + "more than 5 Characters in length");

        }

        if (checkPasswordComplexity(inptPw) == Boolean.TRUE) {
            JOptionPane.showMessageDialog(null, "Password successfully captured");

        } else {
            JOptionPane.showMessageDialog(null, "Password not correctly formatted,"
                    + " please ensure"
                    + " that your password contains at least 8 characters, a "
                    + "capital letter, a number, and a special character.");

        }

        if (checkPasswordComplexity(inptPw) == Boolean.TRUE && checkUserName(inptUn)
                == Boolean.TRUE) {
            Main.pnlWindow.setVisible(true);
            Main.pnlSignUp.setVisible(false);

            writetoarray();
        }

    }

    public static void returnloginStatus() {
        if (LoginUser(inptUn, inptPw) == Boolean.TRUE) {
            JOptionPane.showMessageDialog(null, "Welcome " + inptFn + ","
                    + inptSurname + " it is great to see u again.");
            Main.pnlLogin.setVisible(false);
            Main.pnlWindow.setVisible(true);

        } else if (LoginUser(inptUn, inptPw) == Boolean.FALSE) {
            JOptionPane.showMessageDialog(null, "Incorrect username or password");
        }
    }

}