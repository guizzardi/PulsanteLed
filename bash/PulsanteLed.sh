
#!/bin/bash

echo "Lampeggio GPIO LED 12"

# imposto GPIO12 (BCM 18) come output (LED)
echo 18 > /sys/class/gpio/export
echo out > /sys/class/gpio/gpio18/direction
echo 0 > /sys/class/gpio/gpio18/value

# imposto GPIO11 (BCM 17) come input (pulsante)
echo 17 > /sys/class/gpio/export
echo in > /sys/class/gpio/gpio17/direction

while :
do
   if [[ "$(cat /sys/class/gpio/gpio17/value)" == 0 ]]; then
      echo "$(echo 1 > /sys/class/gpio/gpio18/value)"
      echo "LED Acceso"
      sleep 0.5
   else
      echo "$(echo 0 > /sys/class/gpio/gpio18/value)"
      echo "LED Spento"
      sleep 0.5
   fi
done