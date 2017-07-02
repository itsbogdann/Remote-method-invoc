package proiect;

import java.rmi.Remote;

public interface I_CalculatorNou extends Remote {

    I_Calculator Calculator_serv() throws Exception;
}
