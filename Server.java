package proiect;

import java.rmi.registry.*;
import java.util.Scanner;


public class Server {


    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.print("Portul : ");
        int port = sc.nextInt();
        CalculatorNou Ob = new CalculatorNou();
        Registry reg = LocateRegistry.createRegistry(port);
        reg.bind("Ob", Ob);
        System.out.println("Serverul a pornit!");


    }

}
  