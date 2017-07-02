package proiect;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorNou extends UnicastRemoteObject implements I_CalculatorNou {

    static int nr;

    CalculatorNou() throws RemoteException {
    }

    public I_Calculator Calculator_serv() throws Exception {
        return new Calculator(0, nr++);
    }
}
