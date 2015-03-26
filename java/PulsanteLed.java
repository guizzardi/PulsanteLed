import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

public class PulsanteLed {

    public static void main(String args[]) throws InterruptedException {
        System.out.println("Lampeggio LED GPIO 12");
        
        //creo il controller
        final GpioController gpio = GpioFactory.getInstance();

        //imposto myButton come input dal pin 0 (GPIO11) e imposto pin come output sul pin 1 (GPIO12)
        final GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(RaspiPin.GPIO_00, PinPullResistance.PULL_DOWN);
       	final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.LOW);

        //mi metto in ascolto dello stato del pin in input (listener)
        myButton.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {

                System.out.println("PULSANTE: " + event.getState());
		pin.toggle(); //cambio di stato il LED
        	System.out.println("LED ACCESO");
		try {
 			Thread.sleep(1000); //attendo 1 sec.
		}
		catch (InterruptedException ie) {
 			//gestisci eccezzione
		}
            }
            
        });
        
        //creo un loop infinito solo per attendere l'evento (pulsante premuto)
        for (;;) {
            Thread.sleep(500);
        }
    }
}