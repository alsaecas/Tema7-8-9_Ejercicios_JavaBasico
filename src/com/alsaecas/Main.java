package com.alsaecas;


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Muestra en pantalla Ejercicio 0
        System.out.println(reverse("hola mundo"));

        //Muestra en pantalla Ejercicio 1
        ejer1();

        //Muestra en pantalla Ejercicio 2
        ejer2();

        //Muestra en pantalla Ejercicio 3
        ejer3();

        //Muestra en pantalla Ejercicio 4
        System.out.println("El problema de utilizar un Vector con la capacidad por defecto es que comienza con" +
                "capacidad 10 y cada vez que, al añadir nuevos elementos, sobrepasemos este tamaño, internamente" +
                "el programa crea un nuevo vector con capacidad *2, copia los elementos del vector anterior y destrye" +
                "el viejo. Este proceso es muy costoso computacionalmente. ");

        //Muestra en pantalla Ejercicio 5
        ejer5();

        //Muestra en pantalla Ejercicio 6
        ejer6();

        //Muestra en pantalla Ejercicio 7
        try {
            System.out.println(DividePorCero(5,0));
        }catch (ArithmeticException e){
            System.out.println("Esto no puede hacerse");
        }finally {
            System.out.println("Demo de código");
        }

        //Muestra en pantalla Ejercicio 8
        ejer8("filein.txt","fileout.txt");

        //Muestra en pantalla Ejercicio 9
        ejer9();


    }
/*
Ejercicio 0
Dada la función:
public static String reverse(String texto) {
}
Escribe el código que devuelva una cadena al revés. Por ejemplo, la cadena "hola mundo", debe retornar "odnum aloh".
 */
    public static String reverse(String texto) {
        String revtext= "";
        for (int i = texto.length()-1;i>=0;i--) {
            revtext += texto.charAt(i);
        }
        return revtext;
    }

/*
Ejercicio 1
Crea un array unidimensional de Strings y recórrelo, mostrando únicamente sus valores.
 */
    public static void ejer1() {
        String array[] = new String[5];
        array[0]="Hola";
        array[1]="como";
        array[2]="esta";
        array[3]="todo";
        array[4]="hoy";
        for (int i=0;i<array.length;i++) {
            System.out.println("Valor actual: " + array[i]);
        }
    }

/*
Ejercicio 2
Crea un array bidimensional de enteros y recórrelo, mostrando la posición y el valor de cada elemento en ambas
dimensiones.
 */
    public static void ejer2() {
        int array[][] = new int[2][5];
        array[0][0] = 1;
        array[0][1] = 2;
        array[0][2] = 3;
        array[0][3] = 4;
        array[0][4] = 5;
        array[1][0] = 10;
        array[1][1] = 20;
        array[1][2] = 30;
        array[1][3] = 40;
        array[1][4] = 50;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println("Posicion actual: " + i + "-" + j + ". Valor actual: " + array[i][j]);
            }
        }
    }

/*
Ejercicio 3
Crea un "Vector" del tipo de dato que prefieras, y añádele 5 elementos. Elimina el 2o y 3er elemento y muestra el
resultado final.
 */
        public static void ejer3() {
            Vector<Integer> vector = new Vector<Integer>();
            System.out.println(vector.capacity());
            vector.add(50);
            vector.add(100);
            vector.add(150);
            vector.add(200);
            vector.add(250);
            vector.remove(1);
            vector.remove(1);
            System.out.println(vector);

    }

/*
Ejercicio 5
Crea un ArrayList de tipo String, con 4 elementos. Cópialo en una LinkedList. Recorre ambos mostrando únicamente el
valor de cada elemento.
*/
    public static void ejer5() {
        ArrayList<String> arraylist = new ArrayList<String>(4);
        arraylist.add("Elemento 1");
        arraylist.add("Elemento 2");
        arraylist.add("Elemento 3");
        arraylist.add("Elemento 4");
        LinkedList<String> linkedlist=new LinkedList<String>(arraylist);

        for (String elemento:arraylist) {
            System.out.println("Elemento actual del ArrayList: " + elemento);
        }
        for (String elemento:linkedlist) {
            System.out.println("Elemento actual de la LinkedList: " +elemento);
        }
    }

/*
Ejercicio 6
Crea un ArrayList de tipo int, y, utilizando un bucle rellénalo con elementos 1..10. A continuación, con otro bucle,
recórrelo y elimina los numeros pares. Por último, vuelve a recorrerlo y muestra el ArrayList final. Si te atreves,
puedes hacerlo en menos pasos, siempre y cuando cumplas el primer "for" de relleno.
*/
    public static void ejer6() {
        ArrayList<Integer> arraylist = new ArrayList<Integer>(9);

        for (int i=1; i<=10; i++) {
            arraylist.add(i);
        }
        for (int i=0; i<arraylist.size(); i++) {
            if ((arraylist.get(i) & 1) == 0 ) {
                arraylist.remove(i);
            }
        }
        for (int i=0; i<arraylist.size(); i++) {
            System.out.println("Elemento actual de la ArrayList: " + arraylist.get(i));
        }
    }

/*
Ejercicio 7
Crea una función DividePorCero. Esta, debe generar una excepción ("throws") a su llamante del tipo ArithmeticException
que será capturada por su llamante (desde "main", por ejemplo). Si se dispara la excepción, mostraremos el mensaje
"Esto no puede hacerse". Finalmente, mostraremos en cualquier caso: "Demo de código".
*/
    public static int DividePorCero(int a , int b) throws ArithmeticException{
        int resultado=0;
        try {
            resultado=a/b;
        }catch(ArithmeticException e){
            throw new ArithmeticException();
        }
        return resultado;
    }

/*
Ejercicio 8
Utilizando InputStream y PrintStream, crea una función que reciba dos parámetros: "fileIn" y "fileOut". La tarea de la
función será realizar la copia del fichero dado en el parámetro "fileIn" al fichero dado en "fileOut".
*/
    public static void ejer8(String filein , String fileout){
        try {
            String currentPath = new java.io.File(".").getCanonicalPath();
            InputStream in = new FileInputStream(currentPath + "/src/com/alsaecas/" + filein);
            byte []datos = in.readAllBytes();
            in.close();
            PrintStream out = new PrintStream(currentPath + "/src/com/alsaecas/" + fileout);
            out.write(datos);
            out.close();
            System.out.println("Fichero " + filein + " copiado en " + fileout);
        }catch (Exception e){
            System.out.println("Execpcion: " + e);

        }
    }

/*
Ejercicio 9
Sorpréndenos creando un programa de tu elección que utilice InputStream, PrintStream, excepciones, un HashMap y un
ArrayList, LinkedList o array.
*/
    public static void ejer9() {
        String completo="";
        HashMap<String, Double> dic = new HashMap<>();
        try {
            String currentPath = new java.io.File(".").getCanonicalPath();
            InputStream inputstream = new FileInputStream(currentPath + "/src/com/alsaecas/Lista.csv");

            byte []datos = inputstream.readAllBytes();
            inputstream.close();
            for(byte dato:datos){
                completo += (char)dato;
            }
            String[] array=completo.split("\\n");
            for (String elemento : array){
                dic.put(elemento.split(";")[0], Double.parseDouble(elemento.split(";")[1]));
            }

        }catch (Exception e){
            System.out.println("Excepcion: " + e);
        }
        for(Map.Entry elemento: dic.entrySet()){
            System.out.println("La clave del elemento es: " + elemento.getKey() + " y su valor es: " + elemento.getValue());

        }

    }
}
