/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practivas;

/**
 *
 * @author ramssrez
 */
public class BuggyMysteryClass {

    public String doStuff(String s) {
        String result = "";
        for (int i = s.length(); i > 0; i--) {
            result += s.charAt(i);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = null;
        BuggyMysteryClass rs = new BuggyMysteryClass();
        if (args.length < 1) {
            System.out.println("No input parameter");
            return;
        } else {
            s = args[0];
        }
        System.out.println(s);
        System.out.println(rs.doStuff(s));
        return;
    }

}
