import RPi.GPIO as GPIO         # carica la libreria per gestire la PGIO
from time import sleep          # importa sleep da time per gestire la pausa
GPIO.setmode(GPIO.BCM)          # settiamo BCM come numerico
GPIO.setup(17, GPIO.IN)         # settiamo GPIO25 come input (pulsante)
GPIO.setup(18, GPIO.OUT)        # settiamo GPIO24 come output (LED)

try:
    while True:                 # eseguiamo fino a che non si preme CTRL+C
        if GPIO.input(17):      # se la porta 17 == 1 ho premuto il pulsante
            print "Porta 18 settata a 1, LED SPENTO"
            GPIO.output(18, 0)  # settiamo la porta a 1
        else:
            print "Porta 18 settata a 0, LED ACCESO"
            GPIO.output(18, 1)  # settiamo la porta a 0
        sleep(1)                # attende 1 second0

finally:                        # * vedi testo
    GPIO.cleanup()              # pulisce gli stati

