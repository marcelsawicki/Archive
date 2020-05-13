using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Lab2Hurtownie
{
    public partial class Form1 : Form
    {
        SqlConnection connection;
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            OdzytajPlik(textBox1.Text);
        }

        public void OdzytajPlik(string nazwa)
        {
            listBox1.Items.Clear();
            listBox2.Items.Clear();
            listBox3.Items.Clear();
            listBox4.Items.Clear();
            listBox5.Items.Clear();
            listBox6.Items.Clear();
            listBox7.Items.Clear();
 
            string text = System.IO.File.ReadAllText(nazwa);

            string lineOfText;
            int lineCounter = 0;
            var filestream = new System.IO.FileStream(nazwa,
                                          System.IO.FileMode.Open,
                                          System.IO.FileAccess.Read,
                                          System.IO.FileShare.ReadWrite);

            var file = new System.IO.StreamReader(filestream, System.Text.Encoding.UTF8, true, 128);
            while ((lineOfText = file.ReadLine()) != null)
            {
                listBox1.Items.Add(lineOfText);
                PrzetwarzanieLinii(lineOfText, ref lineCounter);
                
            }
            label1.Text = lineCounter.ToString();
            file.Close();
        }

        public string[] PrzetwarzanieLinii(string linia, ref int lineCounter)
        {
            
            string[] splitedLine = linia.Split(',');
            
            if (splitedLine.Length > 1 && splitedLine.Length == 6 && linia.Contains("/"))
            {
                listBox2.Items.Add(splitedLine[0]);
                listBox3.Items.Add(splitedLine[1]);
                listBox4.Items.Add(splitedLine[2]);
                listBox5.Items.Add(splitedLine[3]);
                listBox6.Items.Add(splitedLine[4]);
                listBox7.Items.Add(splitedLine[5]);
                lineCounter++;
                string czas = splitedLine[2];
                string czasWyciety = czas.Substring(0,8);

                ZapisDoBazy(splitedLine[0], splitedLine[1].Replace('/','-'), czasWyciety, splitedLine[3], splitedLine[4], splitedLine[5]);
            }
            

            return splitedLine;
        }

        public void OdczytajElement(ref string linia)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            openFileDialog1.ShowDialog();
            string sciezka = openFileDialog1.FileName;
            textBox1.Text = sciezka;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Form2 m = new Form2();
            m.Show();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            WyszukajPliki(textBox2.Text);
        }

        public void WyszukajPliki(string sciezka)
        {
            
            OtworzPolaczenie();
            
            string[] filePaths = Directory.GetFiles(sciezka,"*.txt");
            int licznikPlikow = 0;
            foreach (string f in filePaths)
            {
                OdzytajPlik(f);
                int wszystkichPlikow = filePaths.Length;
                licznikPlikow++;

                // Display the ProgressBar control.
                progressBar1.Visible = true;
                // Set Minimum to 1 to represent the first file being copied.
                progressBar1.Minimum = 0;
                // Set Maximum to the total number of files to copy.
                progressBar1.Maximum = wszystkichPlikow;
                // Set the initial value of the ProgressBar.
                progressBar1.Value = licznikPlikow;
                // Set the Step property to a value of 1 to represent each file being copied.
                progressBar1.Step = 1;

                
                progressBar1.Value.Equals(licznikPlikow / wszystkichPlikow);
            }
            label2.Text = licznikPlikow.ToString();
            ZamknijPolaczenie();
        }

        public void ZapisDoBazy(string typ, string DataColumn, string Czas, string AdresWe, string AdresWy, string Protokol)
        {

            string commandText = "INSERT INTO [dbo].[ZoneAlarmLog]([Zdarzenie],[Data],[Czas],[Source],[Destination],[Transport])VALUES('"
                 + typ + "','" + DataColumn + "','" + Czas + "','" + AdresWe + "','" + AdresWy + "','" + Protokol + "');";

            SqlCommand command = new SqlCommand(commandText, connection);
            try
            {
                int wyn = command.ExecuteNonQuery();
            }
            catch
            {

                throw;
            }
        }

        public void OtworzPolaczenie()
        {
            //string connectionString = @"Data Source=localhost\SQLEXPRESS;Initial Catalog=OMHurtowaniaLab;Integrated Security=True";
            connection = new SqlConnection(connectionString);
            connection.Open();

            string commandText1 = "DELETE FROM [OMHurtowaniaLab].[dbo].[ZoneAlarmLog]";

            SqlCommand command1 = new SqlCommand(commandText1, connection);
            try
            {
                int wyn = command1.ExecuteNonQuery();
            }
            catch
            {

                throw;
            }

        }

        public void ZamknijPolaczenie()
        {
            connection.Close();
        }
    }
}
