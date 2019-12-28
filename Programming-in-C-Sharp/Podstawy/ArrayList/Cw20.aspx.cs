using System;
using System.Web.UI.WebControls;
using System.Collections;

public class Klasa20: System.Web.UI.Page
{
protected Label Lab;
protected Label Lab2;
protected ListBox ListB1;
protected ListBox ListB2;
private ArrayList Miasta;

private void NewLista()
{
	Miasta = new ArrayList(); 
}

protected void AddElementy()
{
	Miasta.Add("Warszawa");
	Miasta.Add("��d�");
	Miasta.Add("Pozna�");
	Miasta.Add("Krak�w");
	Miasta.Add("Wroc�aw");
	Miasta.Add("Szczecin");
	Miasta.Add("Konstantyn�w ��dzki");
}

public void RemoveElementNumer(int Poz)
{
	Miasta.RemoveAt(Poz);
}

public void RemoveElementNumer(int Poz1, int Poz2)
{
	Miasta.RemoveRange(Poz1,Poz2);
}

public void ClearElementy()
{
	Miasta.Clear();
}

public void InsertElementy(int Poz, string Nazwa)
{
	Miasta.Insert(Poz, Nazwa);
}

public string ReadElementPoz(string Nazwa)
{
	return (1+Miasta.IndexOf(Nazwa)).ToString();
}

protected void Page_Load(Object obj, EventArgs e)
{
	if(!IsPostBack)
		{
		NewLista();
		AddElementy();
		
		ListB1.DataSource=Miasta;
		ListB1.DataBind();
		
		ListB2.DataSource=Miasta;
		ListB2.DataBind();
		
		Lab2.Text="<h3>Prawa kontrolka zawiera: " + Miasta.Count.ToString() + " pozycje ";
		
		Lab2.Text += " *** August�w jest na pozycji: " + ReadElementPoz("August�w") + "<br>";
		
		Lab2.Text += " Pojemno�� kolekcji wynosi: " + Miasta.Capacity + "</h3>";
		
		ClearElementy();
		}
}

protected void WybierzL(Object obj, EventArgs e)
{
if(ListB1.SelectedIndex>-1){Lab.Text="<h3>Wybra�e�: " + ListB1.SelectedItem.Text +"</h3>";}
}

protected void WybierzP(Object obj, EventArgs e)
{
    if (ListB2.SelectedIndex > -1) { Lab.Text = "<h3>Wybra�e�: " + ListB2.SelectedItem.Text + "</h3>"; }
}

}