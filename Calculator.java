package proiect;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public  class Calculator extends UnicastRemoteObject implements I_Calculator {

    double rezultat;
    double memorie;
    private int val, nr_ordine;

    public Calculator(int i, int nr) throws RemoteException {
        rezultat = 0;
        memorie = 0;
        val = i;
        nr_ordine = nr;
    }

    public void seteaza(double x) throws RemoteException{
        rezultat = x;
    }
    public void aduna(double x) throws RemoteException {
        rezultat += x;
    }

    public void scade(double x) throws RemoteException {
        rezultat -= x;
    }

    public void inmulteste(double x) throws RemoteException {
        rezultat *= x;
    }

    public void imparte(double x) throws RemoteException {
        if (x != 0) {
            rezultat /= x;
        } else rezultat=-99999.0;
    }

    public double rezultat() throws RemoteException {
        return rezultat;
    }

    public double memorie() throws RemoteException {
        return memorie;
    }

    public void inversare() throws RemoteException {
        rezultat = 1 / rezultat;
    }

    public void sqrt() throws RemoteException {
        rezultat = Math.sqrt(rezultat);
    }

    public void putere(int n) throws RemoteException {
        rezultat = Math.pow(rezultat, n);
    }


    public void factorial() throws RemoteException {
        int temp = 1;
        Double nrDouble = new Double(rezultat);
        int k = nrDouble.intValue();
        for (int i = 1; i <= k; i++) {
            temp *= i;
        }
        rezultat = temp;
    }

    public void adunamem() throws RemoteException {
        memorie += rezultat;
        rezultat = memorie ;
    }

    public void scademem() throws RemoteException {
        memorie -= rezultat;
        rezultat = memorie ;
    }

    public void copiazadinmem() throws RemoteException {
        memorie = rezultat;
    }

    public void seteazamem(double num) throws RemoteException {
        memorie = num;
        rezultat = 0;
    }

    public void stergemem() throws RemoteException {
        memorie = 0;
    }
}
