/* wskazniki */
#include <iostream>
using namespace std;

main()
{
	int ti[6];
	float tf[6];
	
	int *wi;
	float *wf;
		wi = &ti[0];
		wf = &tf[0];
		
		cout << "Oto jak przy inkrementacji wskaznik\n"
		<< "zmieniaja sie ukryte w nich adresy:\n";
		
		for(int i=0; i<6; i++, wi++, wf++)
		{
			cout << "i= " << i
			<< ") wi= "
			<< wi
			<< ", wf= "
			<< wf << endl;
		}
}
