#include <stdio.h>
#include <wiringPi.h>

//vedi tabella pin della GPIO, colonna wiringPi
#define LED12 1 //alla variabile LED12 assegno il pin 0
#define PULSANTE11 0 //alla variabile PULSANTE11 assegno il pin 1

int main(void)
{
	printf("Lampeggio LED GPIO 12\n");

	wiringPiSetup(); //inizializzo la libreria

	pinMode(LED12,OUTPUT); //essendo un LED lo imposto come "output"
	pinMode(PULSANTE11,INPUT); //essendo un pulsante lo imposto come "input"

	for (;;) //ciclo infinito
	{
		if (digitalRead(PULSANTE11)==LOW) //premuto il pulsante
		{
			printf("LED ACCESO\n");
			digitalWrite(LED12,HIGH); //accendo il LED
			delay(1000); //acceso per 1 sec.
		}
		printf("LED spento\n");
		digitalWrite(LED12,LOW); //spengo il LED
		delay(1000); //rallento un po'
	}
return 0; //chiudo main
}

