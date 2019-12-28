using System;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        private void OnWyswietlKomunikat(object sender, EventArgs ea)
        {
            MessageBox.Show("Program Chemik sluzy do nauki symboli pierwiastków chemicznych.\nAutor: Marcel Sawicki \nRok produkcji: 2017", "Pomoc");
        }

        private void OnReset(object sender, EventArgs ea)
        {
            i = 0;
            dobrze = 0;
            zle = 0;
            pytania.Text = "Proszę wpisać symbol pierwiastka w polu tekstowym,\na następnie kliknąć przycisk <Sprawdź>.\nPrzycisk <Nauka> po jednym 		naciśnięciu 	wyświetla\nlistę nazw i symboli pierwiastków.\nPo ponownym nacięnieciu przycisku <Nauka> lista znika. ";
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

        //Tworze tablice symboli
        string[] symbole = {
                    "H","He","Li", "Be", "B", "C", "N", "O", "F","Ne","Na","Mg","Al","Si","P","S","Cl","Ar","K","Ca","Sc","Ti","V","Cr","Mn","Fe","Co","Ni","Cu","Zn",
                    "Ga","Ge","As","Se","Br","Kr","Rb","Sr","Y","Zr","Nb","Mo","Tc","Ru","Rh","Pd","Ag","Cd","In","Sn","Sb","Te","I","Xe","Cs","Ba","Hf","Ta","W","Re",
                    "Os","Ir","Pt","Au","Hg","Tl","Pb","Bi","Po","At","Rn","Fr","Ra","Rf","Db","Sg","Bh","Hs","Mt","Ds","Cn","Uut","Fl","Uup","Lv","Uus","Uuo"
                    };

        //Tworze tablice nazw
        string[] nazwy = {
                "Wodór","Hel","Lit","Beryl","Bor","Węgiel","Azot","Tlen","Fluor","Neon","Sód","Magnez","Glin","Krzem","Fosfor","Siarka","Chlor","Argon","Potas","Wapn",
                "Skand","Tytan","Wanad","Chrom","Mangan","Zelazo","Kobalt","Nikiel","Miedz","Cynk","Gal","German","Arsen","Selen","Brom","Krypton","Rubid","Stront",
                "Itr","Cyrkon","Niob","Molibden","Technet","Ruten","Rod","Pallad","Srebro","Kadm","Ind","Cyna","Antymon","Tellur","Jod","Ksenon","Cez","Bar","Hafn",
                "Tantal","Wolfram","Ren","Osm","Iryd","Platyna","Z³oto","Rtêæ","Tal","Olów","Bizmut","Polon","Astat","Radon","Frans","Rad","Rutherford","Dubn",
                "Seaborg","Bohr","Has","Meitner","Darmstadt","Kopernik","Ununtri","Flerow","Ununpent","Livermor","Unusept","Ununokt" };
        //Zdarzenia
        private void OnButtonClick(object sender, EventArgs ea)
        {
            if (cb.Visible == true) { cb.Visible = false; } else { cb.Visible = true; };

        }
        /* ----------------------------------------------------------------------------------------------------------------------- */
        private void OnButtonClickStart(object sender, EventArgs ea)
        {

            if (i < 87)
            {
                if (i == 86) { } else { i++; };
                label.Text = nazwy[i];
                if (text1.Text == symbole[i - 1])
                { dobrze++; }
                else
                { zle++; MessageBox.Show("Zle! Prawidlowa odpowiedz to: " + symbole[i - 1] + " - " + nazwy[i - 1], "Komunikat"); };

            }
            else
            {
                MessageBox.Show("Koniec!", "Komunikat");
            }
            pytania.Text = "Pytanie nr " + i + " \nDobrych odpowiedzi: " + dobrze + " \nZlych odpowiedzi:" + zle;
        }

        private void OnCbSelect(object sender, EventArgs ea)
        {
            string s = ((ComboBox)sender).SelectedItem.ToString();
            MessageBox.Show("Wybrano element: " + s, "Komunikat");
        }
        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Text = "Form1";
        }

        #endregion
    }
}

