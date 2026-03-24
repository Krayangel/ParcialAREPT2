# AREP PAR T2
# Conjetura de Collatz
La conjetura de Collatz dice que si usted crea una secuencia de números, a partir de cualquier entero positivo, siguiendo las reglas descritas abajo, siempre la secuencia terminará en le número 1. Esta conjetura aún no se ha demostrado.
 
Las reglas son:
 f(n)=n/2
 si n es par.
f(n)=3n+1
 si n es impar.
La secuencia se construye a partir de un número dado k
 así:
a0=k
ai=f(ai−1)
Por ejemplo, dato el número k=13
  la secuencia sería:

13→40→20→10→5→16→8→4→2→1

## Arch

![alt text](Images/arch.png)

## Endpoints principales

http://localhost:8080/math/collatz?value=7

En value se agrega el numero desde el cual se quiere calcular la conjetura
![alt text](<Images/Prueba base postman.png>)
![alt text](<Images/Prueba adicional.png>)

## Ejecucion en EC2

Esto despues d eagregarlo al a instnacia se eejcuta dentro de la carpeta
![alt text](<Images/ejecucion server ec2.png>)
![alt text](<Images/Prueba en EC2.png>)

Video: https://pruebacorreoescuelaingeduco-my.sharepoint.com/?view=8&photosData=%2Fphoto%2F01ZBAKNLDFXCM226DPNVEI4GXITBGFTDXN%3Fview%3Dall






