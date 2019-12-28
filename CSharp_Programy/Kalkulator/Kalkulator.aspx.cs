using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;



public partial class Calculator : System.Web.UI.Page
{
    Kalk mojKalk = new Kalk();
    protected void Page_Load(object sender, EventArgs e)
    {
    }


    protected void Button1_Click(object sender, EventArgs e)
    {

        mojKalk.Dodaj(Int32.Parse(TextBox1.Text), Int32.Parse(TextBox2.Text));

        int wynik = mojKalk.Dodaj(Int32.Parse(TextBox1.Text), Int32.Parse(TextBox2.Text));
        Label1.Text = "Equals " +wynik;
    }
    protected void Button2_Click(object sender, EventArgs e)
    {
        int wynik = mojKalk.Odejmij(Int32.Parse(TextBox1.Text), Int32.Parse(TextBox2.Text));
        Label1.Text = "Equals " + wynik;
    }
    protected void Button3_Click(object sender, EventArgs e)
    {
        int wynik = mojKalk.Mnoz(Int32.Parse(TextBox1.Text), Int32.Parse(TextBox2.Text));
        Label1.Text = "Equals " + wynik;
    }
    protected void Button4_Click(object sender, EventArgs e)
    {
        float wynik = mojKalk.Dziel(Int32.Parse(TextBox1.Text), Int32.Parse(TextBox2.Text));
        Label1.Text = "Equals " + wynik;
    }
}

public  interface IKalk
{
int Dodaj(int l1, int l2);
int Odejmij(int l1, int l2);
int Mnoz(int l1, int l2);
float Dziel(float l1, float l2);
}

public class Kalk: IKalk 
{

    public int Dodaj(int l1, int l2)
    { return l1 + l2; }

    public int Odejmij(int l1, int l2)
    { return l1 - l2; }

    public int Mnoz(int l1, int l2)
    { return l1 * l2; }

    public float Dziel(float l1, float l2)
    {
        try
        {
            float wynik = l1 / l2;
            if (l2 == 0)
                throw new DivideByZeroException();
            return wynik;
        }
        catch (DivideByZeroException)
        {
            return 0;
        }
    }

    public Kalk()
    {
        //konstruktor klasy
    }
}


//try
//            {
//                float wynik = kalkulator.dziel(
//                Int32.Parse(TextBox1.Text), Int32.Parse(TextBox2.Text));
//                if (wynik == 0) throw new DzielZero();
//                Label1.Text = "Wynik " + wynik;
//            }

//            catch (DzielZero)
//            {
//                Label1.Text = "Wynik " + "Dzielenie przez zero!";
//            }
            
//            //catch(DivideByZeroException) { 
//            //    Label1.Text = "Wynik " + "Dzielenie przez zero!";
//            //}
            
//            catch (FormatException)
//            {
//                Label1.Text = "Wynik " + "Podaj liczbe!";
//            }
//            catch (OverflowException)
//            {
//                Label1.Text = "Wynik " + "Przekroczono!";
//            }
//        }