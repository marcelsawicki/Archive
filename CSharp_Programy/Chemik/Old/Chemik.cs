using System;
using System.Windows.Forms;

public class MainForm: Form
{
	private void OnWyswietlKomunikat(object sender, EventArgs ea)
	{
		MessageBox.Show("Program Chemik s³u¿y do nauki symboli pierwiastków chemicznych.\nAutor: Marcel Sawicki \nRok produkcji: 2017", "Pomoc");
	}

	private void OnReset(object sender, EventArgs ea)
	{
		i=0;
		dobrze=0;
		zle=0;
		pytania.Text="Proszê wpisaæ symbol pierwiastka w polu tekstowym,\na nastêpnie klikn¹æ przycisk <SprawdŸ>.\nPrzycisk <Nauka> po jednym 		naciœniêciu 	wyœwietla\nlistê nazw i symboli pierwiastków.\nPo ponownym naciœnieciu przycisku <Nauka> lista znika. ";
		label.Text = nazwy[i];
		MessageBox.Show("Zresetowano licznik!", "Komunikat");
	}

	private void OnWyjdz(object sender, EventArgs ea)
	{
		Application.Exit();
	}

	//Definiowanie obiektów
	private Label label = new Label();
	private Label pytania = new Label();
	private Button button1 = new Button();
	private Button button2 = new Button();
	private ListBox cb = new ListBox();
	private TextBox text1 = new TextBox();
	int i = 0;
	int dobrze = 0;
	int zle = 0;

	//Tworzê tablicê symboli
	string[] symbole = {
	"H","He","Li", "Be", "B", "C", "N", "O", "F","Ne","Na","Mg","Al","Si","P","S","Cl","Ar","K","Ca","Sc","Ti","V","Cr","Mn","Fe","Co","Ni","Cu","Zn",
	"Ga","Ge","As","Se","Br","Kr","Rb","Sr","Y","Zr","Nb","Mo","Tc","Ru","Rh","Pd","Ag","Cd","In","Sn","Sb","Te","I","Xe","Cs","Ba","Hf","Ta","W","Re",
	"Os","Ir","Pt","Au","Hg","Tl","Pb","Bi","Po","At","Rn","Fr","Ra","Rf","Db","Sg","Bh","Hs","Mt","Ds","Cn","Uut","Fl","Uup","Lv","Uus","Uuo"
	};

	//Tworzê tablicê nazw
	string[] nazwy = {
"Wodór","Hel","Lit","Beryl","Bor","Wêgiel","Azot","Tlen","Fluor","Neon","Sód","Magnez","Glin","Krzem","Fosfor","Siarka","Chlor","Argon","Potas","Wapñ",
"Skand","Tytan","Wanad","Chrom","Mangan","¯elazo","Kobalt","Nikiel","MiedŸ","Cynk","Gal","German","Arsen","Selen","Brom","Krypton","Rubid","Stront",
"Itr","Cyrkon","Niob","Molibden","Technet","Ruten","Rod","Pallad","Srebro","Kadm","Ind","Cyna","Antymon","Tellur","Jod","Ksenon","Cez","Bar","Hafn",
"Tantal","Wolfram","Ren","Osm","Iryd","Platyna","Z³oto","Rtêæ","Tal","O³ów","Bizmut","Polon","Astat","Radon","Frans","Rad","Rutherford","Dubn",
"Seaborg","Bohr","Has","Meitner","Darmstadt","Kopernik","Ununtri","Flerow","Ununpent","Livermor","Unusept","Ununokt"

	};	
	//Zdarzenia
	private void OnButtonClick(object sender, EventArgs ea)
	{
	if(cb.Visible == true){cb.Visible = false;}else{cb.Visible = true;};

	}
/* ----------------------------------------------------------------------------------------------------------------------- */
	private void OnButtonClickStart(object sender, EventArgs ea)
	{

	if(i<87)
	{
		if(i==86){}else{i++;};
		label.Text = nazwy[i];
        	if(text1.Text==symbole[i-1])
		{dobrze++;}
		else
		{zle++;MessageBox.Show("Zle! Prawid³owa odpowiedŸ to: "+symbole[i-1]+" - "+nazwy[i-1], 	"Komunikat");};

	}
	else
	{
		MessageBox.Show("Koniec!", "Komunikat");
	}
	pytania.Text =  "Pytanie nr "+i+" \nDobrych odpowiedzi: " +dobrze+" \nZ³ych odpowiedzi:" +zle;
	}

	private void OnCbSelect(object sender, EventArgs ea)
	{
	string s = ((ComboBox)sender).SelectedItem.ToString();
	MessageBox.Show("Wybrano element: " +s, "Komunikat");
	}

public MainForm()
	{
	Text = "Chemik";
	Width = 640;
	Height = 480;
	
	MainMenu mm = new MainMenu();

	MenuItem miPlik = new MenuItem("Plik");

	MenuItem miWyswietlKomunikat = new MenuItem("Pomoc");
	MenuItem miReset = new MenuItem("Reset");
	MenuItem miWyjdz = new MenuItem("WyjdŸ");
	
	miWyswietlKomunikat.Click += new EventHandler(OnWyswietlKomunikat);
	miReset.Click += new EventHandler(OnReset);
	
	miWyjdz.Click += new EventHandler(OnWyjdz);

	miPlik.MenuItems.Add(miWyswietlKomunikat);
	miPlik.MenuItems.Add(miReset);
	miPlik.MenuItems.Add(miWyjdz);
	
	mm.MenuItems.Add(miPlik);
	Menu = mm;

	//G³ówne okno
	label.Text = "Wodór";
	label.AutoSize = true;
	label.Left =(ClientSize.Width - label.Width)/2;
	label.Top = (ClientSize.Height - label.Height)/8;
	Controls.Add(label);
	
	//Label z pytaniami
	pytania.AutoSize = true;
	pytania.Left =(ClientSize.Width - pytania.Width)/2;
	pytania.Top = 200;
	pytania.Text="Proszê wpisaæ symbol pierwiastka w polu tekstowym,\na nastêpnie klikn¹æ przycisk <SprawdŸ>.\nPrzycisk <Nauka> po jednym naciœniêciu 	wyœwietla\nlistê nazw i symboli pierwiastków.\nPo ponownym naciœnieciu przycisku <Nauka> lista znika. ";
	Controls.Add(pytania);



	//G³ówne okno, widoczny przycisk
	button1.Text = "SprawdŸ";
	button1.Left = (ClientSize.Width - button1.Width)/2;
	button1.Top = (ClientSize.Height - button1.Height)/3;
	button1.Click += new EventHandler(OnButtonClickStart);
	Controls.Add(button1);

	//G³ówne okno, widoczny przycisk
	button2.Text = "Nauka";
	button2.Left = (ClientSize.Width + button1.Width+button2.Width)/2;
	button2.Top = (ClientSize.Height - button1.Height)/3;
	button2.Click += new EventHandler(OnButtonClick);
	Controls.Add(button2);

	//Lista pierwiastków
	cb.Items.AddRange
	(
	new object[]
	{
	"H - Wodór",
	"He - Hel",
	"Li - Lit",
	"Be - Beryl",
	"B - Bor",
	"C - Wêgiel",
	"N - Azot",
	"O - Tlen",
	"F - Fluor",
	"Ne - Neon",
	"Na - Sód",
	"Mg - Magnez",
	"Al - Glin",
	"Si - Krzem",
	"P - Fosfor",
	"S - Siarka",
	"Cl - Chlor",
	"Ar - Argon",
	"K - Potas",
	"Ca - Wapñ",
	"Sc - Skand",
	"Ti - Tytan",
	"V - Wanad",
	"Cr - Chrom",
	"Mn - Mangan",
	"Fe - ¯elazo",
	"Co - Kobalt",
	"Ni - Nikiel",
	"Cu - MiedŸ",
	"Zn - Cynk",
	"Ga - Gal",
	"Ge - German",
	"As - Arsen",
	"Se - Selen",
	"Br - Brom",
	"Kr - Krypton",
	"Rb - Rubid",
	"Sr - Stront",
	"Y - Itr",
	"Zr - Cyrkon",
	"Nb - Niob",
	"Mo - Molibden",
	"Tc - Technet",
	"Ru - Ruten",
	"Rh - Rod",
	"Pd - Pallad",
	"Ag - Srebro",
	"Cd - Kadm",
	"In - Ind",
	"Sn - Cyna",
	"Sb - Antymon",
	"Te - Tellur",
	"I - Jod",
	"Xe - Ksenon",
	"Cs - Cez",
	"Ba - Bar",
	"Hf - Hafn",
	"Ta - Tantal",
	"W - Wolfram",
	"Re - Ren",
	"Os - Osm",
	"Ir - Iryd",
	"Pt - Platyna",
	"Au - Z³oto",
	"Hg - Rtêæ",
	"Tl - Tal",
	"Pb - O³ów",
	"Bi - Bizmut",
	"Po - Polon",
	"At - Astat",
	"Rn - Radon",
	"Fr - Frans",
	"Ra - Rad",
	"Rf - Rutherford",
	"Db - Dubn",
	"Sg - Seaborg",
	"Bh - Bohr",
	"Hs - Has",
	"Mt - Meitner",
	"Ds - Darmstadt",
	"Cn - Kopernik",
	"Uut - Ununtri",
	"Fl - Flerow",
	"Uup - Ununpent",
	"Lv - Livermor",
	"Uus - Unusept",
	"Uuo - Ununokt"
	}
	);
	cb.Left = 20;
	cb.Top = 20;
	cb.Height = ClientSize.Height - 40;
	cb.Visible = false;
	//cb.DropDownWidth = 200;
	//cb.DropDownHeight = 400;
	//cb.SelectedIndexChanged +=OnCbSelect;
	Controls.Add(cb);
	
	text1.Left = (ClientSize.Width - text1.Width)/2;
	text1.Top = (ClientSize.Height - text1.Height)/6;
	Controls.Add(text1);


	}

	public static void Main()
	{
	Application.Run(new MainForm());
	}
}