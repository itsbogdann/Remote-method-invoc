//CLIENT

package proiect;

import java.rmi.*;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) throws RemoteException {

        int val;
        double X = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Adresa server si port : ");
        String adresa = sc.next();
        int port = sc.nextInt();
        I_CalculatorNou Ob = null;
        I_Calculator Server_obiect = null;
        String url = "rmi://" + adresa + ":" + port + "/Ob";

        try {
            Ob = (I_CalculatorNou) Naming.lookup(url);
        } catch (Exception e) {
            System.out.println("Conectare esuata!");
            System.out.println(url);
            System.exit(0);
        }


        try {
            Server_obiect = Ob.Calculator_serv();
        } catch (Exception e) {
            System.out.println("Not Working");
        }

        System.out.print("Meniu:\n " +
                "1.Adunare\n " +
                "2.Scadere\n " +
                "3.Inmultire\n " +
                "4.Impartire\n " +
                "5.Inversare rezultat\n " +
                "6.Radical\n " +
                "7.Ridicare la putere\n" +
                " 8.Factorial\n " +
                "9.Aduna la memorie\n " +
                "10.Scade din memorie\n " +
                "11.Copiaza din memorie\n " +
                "12.Seteaza memoria\n " +
                "13.Sterge memoria\n " +
                "14.Memorie\n " +
                "15.Rezultat\n " +
                "16.Exit\n" +
                " 17.Seteaza X\n");


        System.out.print("X=");
        val = sc.nextInt();
        Server_obiect.aduna(val);

        while (true) {
            System.out.print("Alegeti operatia: ");
            try {
                int Operatie = sc.nextInt();


                if (Operatie == 1) {
                    System.out.print(Server_obiect.rezultat() + " + ");
                    try {
                        X = sc.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Nu ati dat un numar!");
                    }
                    Server_obiect.aduna(X);
                    System.out.println(" = " + Server_obiect.rezultat());
                }

                if (Operatie == 2) {
                    System.out.print(Server_obiect.rezultat() + " - ");
                    try {
                        X = sc.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Nu ati dat un numar!");
                    }
                    Server_obiect.scade(X);
                    System.out.println(" = " + Server_obiect.rezultat());
                }

                if (Operatie == 3) {
                    System.out.print(Server_obiect.rezultat() + " * ");
                    try {
                        X = sc.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Nu ati dat un numar!");
                    }
                    Server_obiect.inmulteste(X);
                    System.out.println(" = " + Server_obiect.rezultat());
                }

                if (Operatie == 4) {
                    System.out.print(Server_obiect.rezultat() + " / ");

                            try {
                                X = sc.nextDouble();
                            } catch (Exception e) {
                                System.out.println("Nu ati dat un numar!");
                            }

                    Server_obiect.imparte(X);
                    if (Server_obiect.rezultat() == -99999.0) {
                        System.out.println("Impartire la 0, Try again!");
                        System.out.print("X = ");
                        X = sc.nextDouble();
                        Server_obiect.seteaza(X);
                    } else {
                        System.out.println(" = " + Server_obiect.rezultat());
                    }
                }


                if (Operatie == 5) {
                    if (Server_obiect.rezultat() == 0.0) {
                        System.out.println("Impartire la 0, try again!");
                        System.out.print("X = ");
                        try {
                            X = sc.nextDouble();
                        } catch (Exception e) {
                            System.out.println("Nu ati dat un numar!");
                        }
                        Server_obiect.aduna(X);
                    } else {
                        System.out.print(Server_obiect.rezultat() + "^(-1) = ");
                        Server_obiect.inversare();
                        System.out.print(Server_obiect.rezultat());
                        System.out.println();
                    }


                }

                if (Operatie == 6) {
                    if (Server_obiect.rezultat() < 0) {
                        System.out.println("Numar negativ, try again!");
                        System.out.print("X = ");
                        try {
                            X = sc.nextDouble();
                        } catch (Exception e) {
                            System.out.println("Nu ati dat un numar!");
                        }
                        Server_obiect.aduna(X);
                    } else {
                        Server_obiect.sqrt();
                        System.out.println("sqrt(" + X + ") = " + Server_obiect.rezultat());
                    }
                }

                if (Operatie == 7) {
                    System.out.println("Introduceti puterea:");

                       int V = sc.nextInt();

                    System.out.print(Server_obiect.rezultat() + "^" + V + " = ");
                    Server_obiect.putere(V);
                    System.out.print(Server_obiect.rezultat());
                    System.out.println();


                }


                if (Operatie == 8) {
                    if (Server_obiect.rezultat() < 0) {
                        System.out.println("Numar negativ, try again!");
                        System.out.print("X = ");
                        try {
                            X = sc.nextDouble();
                        } catch (Exception e) {
                            System.out.println("Nu ati dat un numar!");
                        }
                        Server_obiect.aduna(val - Server_obiect.rezultat());
                    } else if (Server_obiect.rezultat() > 0) {
                        if (Server_obiect.rezultat() > 12)
                            System.out.println("Atentie! Rezultat de ordinul miliardelor!");
                        System.out.print("factorial(" + Server_obiect.rezultat() + ") = ");
                        Server_obiect.factorial();
                        System.out.print(Server_obiect.rezultat());
                        System.out.println();
                    } else {
                        System.out.println("factorial(0) = 1");
                        System.out.print("X = ");
                        try {
                            X = sc.nextDouble();
                        } catch (Exception e) {
                            System.out.println("Nu ati dat un numar!");
                        }
                        Server_obiect.seteaza(X);
                    }


                }

                if (Operatie == 9) {
                    Server_obiect.adunamem();
                    System.out.println(Server_obiect.rezultat());
                }
                if (Operatie == 10) {
                    Server_obiect.scademem();
                    System.out.println(Server_obiect.rezultat());
                }
                if (Operatie == 11) {
                    Server_obiect.copiazadinmem();
                    System.out.println(Server_obiect.rezultat());
                }
                if (Operatie == 12) {
                    Server_obiect.seteazamem(Server_obiect.rezultat());
                    System.out.print("MEM = ");
                    try {
                        X = sc.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Nu ati dat un numar!");
                    }
                    Server_obiect.aduna(val);
                }
                if (Operatie == 13) {
                    Server_obiect.stergemem();
                }
                if (Operatie == 14) {
                    System.out.println(Server_obiect.memorie());
                }
                if (Operatie == 15) {
                    System.out.println(Server_obiect.rezultat());
                }
                if (Operatie == 16) {
                    break;
                }

                if (Operatie == 17) {
                    System.out.print("X = ");
                    try {
                        X = sc.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Nu ati dat un numar!");
                    }
                    Server_obiect.seteaza(X);
                }


            } catch (Exception e) {
                System.out.println("Dati un numar!");
                break;
            }
        }
    }
}


