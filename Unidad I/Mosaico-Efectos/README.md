# Mosaico de imagenes con efectos

## Datos
* Version y fecha: 1.0 20/04/2020
* Autor: CRUZ MEJÍA CONRADO
* IDE: ECLIPSE-WORKSPACE

Programa alojado en el repositorio [Conradrc27](https://github.com/conradrc27/Graphics_Exercises/tree/master/Unidad%20I/Mosaico-Efectos)

Códigos de efectos, obtenido de [Princeton](https://algs4.cs.princeton.edu/code/)

## Descripcion:
* La clase Efects contiene todos los posibles efectos que se pueden aplicar a una imagen, 
cada método es publico, estático y devuelven un elemento de tipo Picture, todos los métodos 
resiven como parámetro la imagen a la cual se le aplicará el efecto y algunos otros parámetros 
mas ya que es necesario que el usuario indique cierto valor.
    
Por ejemplo: En el efecto rotation, el usuario debe indicar el grado de
rotacián de la imagen o el efecto zoom, etc.
    
* En la clase Cliente, se hace un test sobre cada método.
* Se asignan los valores para las filas y columnas.
* Se prepara un elemento de tipo Picture para mostrar.
* Muy importante, para que no haya problemas con el tamaño de las imágenes que se utilicen, 
  se utiliza el método scale, el cual redimensiona las imagenes a la misma escala, de esta 
  forma, todas las imágenes obtienen el mismo tamaño.
* Las imagenes se agregan a un arreglo.
* Una vez ajustado el tamaño, se aplican los efectos a cada imagen.
* En un ciclo se recorren las imagenes y se colocan en las distintas posiciones.

## Requisitos:
Este SDK de Java funciona en las siguientes plataformas:
* Java 8+

## Instrucciones: 
Compilación y Ejecución
```bash
javac Cliente.java
java Cliente
```
