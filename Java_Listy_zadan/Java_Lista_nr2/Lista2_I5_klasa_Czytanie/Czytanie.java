import java.io.*;
import java.util.*;
public class Czytanie
{
    // Prosta ilustracja wczytywania danych tekstowych: metoda realizuje wczytywanie kolejnych wierszy tekstu
    // a¿ do napotkania wiersza z tekstem "koniec"
    public static void czytanieTekstu()
    {
        BufferedReader wej= new BufferedReader( new InputStreamReader(System.in));
        System.out.println("Maszyna do pisania");
        String buf="";
        try {
            while (!"koniec".equals(buf)){
                buf=wej.readLine();
                System.out.println("=>"+buf);
            }
            System.out.println("Koniec");
        }
        catch (IOException e){e.getMessage();}
    }

    // Prosta metoda do wczytywania danych liczbowych. Wprowadzenie danych w niepoprawnym formacie
    // powoduje wyswietlenie komunikatu o b³êdzie
    public static double czytajDouble(String s)
    {
        Scanner sc=new Scanner(System.in);
        String tx="";
        boolean dalej=false;
        double x=0;
        while (!dalej) {
         try {
            System.out.print(s);
            tx=sc.nextLine();
            x=Double.parseDouble(tx);
            dalej=true;
         }
         catch (java.lang.NumberFormatException e) {
            System.out.println("Niepoprawny format liczby");
            dalej=false;
         }
        } //while
        return x;
    }

    public static void main(String[] args)
    {
        // Przyklad uzycia metody czytajDouble(.)
        double a;
        a=czytajDouble("a=");
        System.out.println("wczytano a="+a);
        int b;
        b=(int) czytajDouble("b=");
        System.out.println("wczytano b="+b);
        czytanieTekstu();
    }

}