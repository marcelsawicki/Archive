public class Tablica { 
   
    int ilosc; // zmienna ilosc do okreslenia liczby elementow tablicy
    int[] tabl; // moja tablica
  
    public Tablica(int ilosc) { // setter - metoda ustawiajaca pole obiektu
        this.ilosc=ilosc;
    }
    
    public int[] utworz(){ // getter - metoda odczytujaca stan obieku, ta metoda tworzy tablice o liczbie elementow "ilosc"
      
      this.tabl=new int[this.ilosc]; // tworze obiekt tablicowy o liczbie elementow "ilosc"
     
      for(int i=0; i<ilosc;i++){ //wypelniam elementy tablicy
           this.tabl[i]=(int)(Math.random()*ilosc); //losuje wartosci tablicy
      }
      return this.tabl; // zwracam tablice o nazwi tabl
    }
    
    
    public void wypisz(){ // ta metoda wyswietla elementy tablicy
    	
        System.out.println("Elementy tablicy : ");
        for(int i=0;i<this.tabl.length;i++){
                    System.out.print(tabl[i]+" ");
        }
            System.out.println();
    }
   
    public void suma(){ // ta metoda sumuje elementy tablicy
        int sum=0;
        System.out.print("Suma : ");
        for(int i=0;i<this.tabl.length;i++){
                    sum+=tabl[i];
        }
            System.out.println(sum);
    }
   
    public void maxElement(){ // metoda szukajaca najwiekszego elementu tablicy
        int tmp=0;
        System.out.println("Maksymalna wartoœæ w tablicy : ");
        for(int i=0;i<this.tabl.length;i++){
                    if(tabl[i]>=tmp) tmp=tabl[i];
        }
            System.out.println(tmp);
    }

    public void maxIndeks(){
        int tmp=0;
        System.out.println("Indeks maksymalnej wartoœci : ");
        for(int i=0;i<this.tabl.length;i++){
                    if(tabl[i]>tmp) tmp=i;
        }
            System.out.println(tmp);
    }
  
   
    public void sprawdzWystepowanie(int min, int max, int test){
        int tmp = 0;
        System.out.println("Sprawdzanie czy liczba : " + test + " zawiera siê w przedziale [" + min +","+max+"]");
        for(int i=min;i<max;i++){
                    if(tabl[i]==test) {
                        System.out.println("Liczba : " + test + " wystêpuje pod indeksem [" + i +"]");
                        tmp++;
                    }
        }
        if (tmp==0) System.out.println("Liczba : " + test + " nie wystêpuje w tablicy");
    }
   
    public void sprawdzCzyRoznowat(){
        int tmp = 0;
        System.out.println("Sprawdzanie czy tablica jest roznowartosciowa");
        for(int i=0;i<this.tabl.length;i++){
                for(int j=0;j<this.tabl.length;j++){
                    if(tabl[j]==tabl[i])
                        tmp++;
                    }
            }
        if (tmp>ilosc) System.out.println("Tablica nie jest ró¿nowartoœciowa");
        else System.out.println("Tablica jest ró¿nowartoœciowa");
     }
   
    public int[] usunZtablicy(int usun){
      System.out.println("Usun (wyzeruj) z tablicy liczby :" +usun);
      for(int i=0; i<ilosc;i++){
           if(tabl[i]==usun) {
               tabl[i]=0;}
      }
      return this.tabl; 
    }
}