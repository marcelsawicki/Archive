using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Lab2Hurtownie
{
    public partial class Form1 : Form
    {
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
    }
}
