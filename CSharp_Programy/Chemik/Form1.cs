using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
   
                Text = "Chemik";
                Width = 640;
                Height = 480;

                MainMenu mm = new MainMenu();

                MenuItem miPlik = new MenuItem("Plik");

                MenuItem miWyswietlKomunikat = new MenuItem("Pomoc");
                MenuItem miReset = new MenuItem("Reset");
                MenuItem miWyjdz = new MenuItem("Wyjdz");

                miWyswietlKomunikat.Click += new EventHandler(OnWyswietlKomunikat);
                miReset.Click += new EventHandler(OnReset);

                miWyjdz.Click += new EventHandler(OnWyjdz);

                miPlik.MenuItems.Add(miWyswietlKomunikat);
                miPlik.MenuItems.Add(miReset);
                miPlik.MenuItems.Add(miWyjdz);

                mm.MenuItems.Add(miPlik);
                Menu = mm;

                //Glówne okno
                label.Text = "Wodór";
                label.AutoSize = true;
                label.Left = (ClientSize.Width - label.Width) / 2;
                label.Top = (ClientSize.Height - label.Height) / 8;
                Controls.Add(label);

                //Label z pytaniami
                pytania.AutoSize = true;
                pytania.Left = (ClientSize.Width - pytania.Width) / 2;
                pytania.Top = 200;
                pytania.Text = "Prosze wpisac symbol pierwiastka w polu tekstowym,\na nastepnie kliknac przycisk <Sprawdz>.\nPrzycisk <Nauka> po jednym nacisnieciu 	wyswietla\nliste nazw i symboli pierwiastków.\nPo ponownym nacisnieciu przycisku <Nauka> lista znika. ";
                Controls.Add(pytania);



                //Główne okno, widoczny przycisk
                button1.Text = "Sprawdz";
                button1.Left = (ClientSize.Width - button1.Width) / 2;
                button1.Top = (ClientSize.Height - button1.Height) / 3;
                button1.Click += new EventHandler(OnButtonClickStart);
                Controls.Add(button1);

                //Główne okno, widoczny przycisk
                button2.Text = "Nauka";
                button2.Left = (ClientSize.Width + button1.Width + button2.Width) / 2;
                button2.Top = (ClientSize.Height - button1.Height) / 3;
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
                "C - Wegiel",
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
                "Ca - Wapn",
                "Sc - Skand",
                "Ti - Tytan",
                "V - Wanad",
                "Cr - Chrom",
                "Mn - Mangan",
                "Fe - ¯elazo",
                "Co - Kobalt",
                "Ni - Nikiel",
                "Cu - Miedz",
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
                "Au - Zloto",
                "Hg - Rtec",
                "Tl - Tal",
                "Pb - Olów",
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
                });

                cb.Left = 20;
                cb.Top = 20;
                cb.Height = ClientSize.Height - 40;
                cb.Visible = false;

                Controls.Add(cb);

                text1.Left = (ClientSize.Width - text1.Width) / 2;
                text1.Top = (ClientSize.Height - text1.Height) / 6;
                Controls.Add(text1);

            InitializeComponent();
        }
    }
}
