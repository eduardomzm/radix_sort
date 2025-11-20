import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestingFiles{

    public static void printIntArray(int[] array){
        // Verifica si el arreglo es null o vacío antes de imprimir
        if (array == null || array.length == 0) {
            System.out.println("[] (Arreglo vacío o nulo)");
            return;
        }
        System.out.print("[");
        for (int i=0; i<array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void printStringArray(String[] array){
        if (array == null || array.length == 0) {
            System.out.println("[] (Arreglo vacío o nulo)");
            return;
        }
        System.out.print("[");
        for (int i=0; i<array.length; i++) {
            System.out.print("\"" + array[i] + "\"");
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) throws IOException{
        Files files = new Files();
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        
        // Arreglos para la lectura de archivos
        int[]  numerosA = new int[0]; 
        int[]  numerosB = new int[0]; 
        String[] songs;
        
        // Arreglo para la escritura inicial
        int[] numerosIniciales = {27, 29, 33, 68, 10, 1, 15, 87, 95}; 

        System.out.println("--------------------------------------");
        System.out.println("Programa que lee archivos y calcula la suma");
        System.out.println("--------------------------------------");
        
        // --- 1. Lectura de dos archivos de números para sumarlos ---
        
        System.out.println("Escribe el nombre del primer archivo de numeros a leer : ");
        fileName = bufer.readLine();
        numerosA = files.fileToIntArray(fileName); // Lee el primer archivo
        System.out.println("Contenido del PRIMER arreglo : ");
        printIntArray(numerosA);
        
        System.out.println("\nEscribe el nombre del segundo archivo de numeros a leer: ");
        fileName = bufer.readLine();
        numerosB = files.fileToIntArray(fileName); // Lee el segundo archivo
        System.out.println("Contenido del SEGUNDO arreglo : ");
        printIntArray(numerosB);
        
        // Suma de los arreglos y escritura en nuevo archivo
        System.out.println("\nEscribe el nombre del archivo para guardar la suma: ");
        fileName = bufer.readLine();
        files.sumIntArraysAndWriteToFile(fileName, numerosA, numerosB);
        
        
        System.out.println("Escribe el nombre del archivo de strings a leer: ");
        fileName = bufer.readLine();
        songs = files.fileToStringArray(fileName);
        System.out.println("Contenido del arreglo de Strings: ");
        printStringArray(songs);


        
        System.out.println("Escribe el nombre del nuevo archivo de numeros iniciales: ");
        fileName = bufer.readLine();
        files.writeIntArrayToFile(fileName, numerosIniciales);

        System.out.println("FIN DEL PROGRAMA");
    }
}