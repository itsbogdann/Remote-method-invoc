package proiect;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface I_Calculator extends Remote {

    public void seteaza(double x) throws RemoteException;
    public void aduna(double x) throws RemoteException;
    public void scade(double x) throws RemoteException;
    public void inmulteste(double x) throws RemoteException;
    public void imparte(double x) throws RemoteException;
    public void putere(int x) throws RemoteException;
    public void inversare() throws RemoteException;
    public void sqrt() throws RemoteException;
    public void factorial() throws RemoteException;
    public void adunamem() throws RemoteException;
    public void scademem() throws RemoteException;
    public void copiazadinmem() throws RemoteException;
    public void seteazamem(double x) throws RemoteException;
    public void stergemem() throws RemoteException;
    double memorie() throws RemoteException;
    double rezultat() throws RemoteException;
}
