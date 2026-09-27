package stage.ifm;

import java.net.InetAddress;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Hostname : " + localHost.getHostName());
            System.out.println("Adresse IP : " + localHost.getHostAddress());
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}