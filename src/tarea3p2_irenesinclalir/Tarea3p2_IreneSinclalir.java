package tarea3p2_irenesinclalir;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Tarea3p2_IreneSinclalir {

    private static ArrayList<Integer> lista1 = new ArrayList<>();
    private static ArrayList<Integer> lista2 = new ArrayList<>();
    private static ArrayList<Integer> lista3 = new ArrayList<>();

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int caso = 0;
        boolean repetir = true;
        while (repetir) {
            String opciones = JOptionPane.showInputDialog(
                    "-------MENU-------\n"
                    + "1. Llenar lista 1 y 2.\n"
                    + "2. Ordenas y mostrar la lista 1 y 2. "
                    + "3. Calcula la lista 3. \n"
                    + "4. Realizar operaciones entre lista.\n"
                    + "5.Encontrar diferencias entre listas.\n"
                    + "6. Salir\n"
                    + " Elige una opcion: "
            );
            caso = Integer.parseInt(opciones);

            switch (caso) {
                case 1:
                    llenarListasConAleatorios();
                    break;
                case 2:
                    ordenarYMostrarListas();
                    break;
                case 3:
                    calcularLista3();
                    break;
                case 4:
                    break;
                case 5:
                    encontrarDiferenciaEntreListas();
                    break;
                case 6:
                    System.out.println("Finalizo.");
                    repetir = false;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }

    public static void llenarListasConAleatorios() {
        Random rand = new Random();

        lista1.clear();
        lista2.clear();

        for (int i = 0; i < 100; i++) {
            lista1.add(rand.nextInt(100));
            lista2.add(rand.nextInt(100));
        }

        JOptionPane.showMessageDialog(null, "Listas llenadas con 100 números aleatorios cada una.");
    }

    public static void ordenarYMostrarListas() {
        Collections.sort(lista1);
        Collections.sort(lista2);

        String mensaje = "Lista 1 ordenada:\n" + lista1 + "\n\nLista 2 ordenada:\n" + lista2;
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public static void calcularLista3() {
        // Encuentra los números primos en ambas listas
        ArrayList<Integer> primosLista1 = encontrarNumerosPrimos(lista1);
        ArrayList<Integer> primosLista2 = encontrarNumerosPrimos(lista2);

        lista3.clear();
        for (int numero : primosLista1) {
            if (primosLista2.contains(numero)) {
                lista3.add(numero);
            }
        }

        Collections.sort(lista3);

        String mensaje = "Lista 3 (Intersección de Números Primos):\n" + lista3;
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static ArrayList<Integer> encontrarNumerosPrimos(ArrayList<Integer> lista) {
        ArrayList<Integer> primos = new ArrayList<>();
        for (int numero : lista) {
            if (esPrimo(numero)) {
                primos.add(numero);
            }
        }
        return primos;
    }

    private static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i * i <= numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void encontrarDiferenciaEntreListas() {
        lista3.clear(); // Limpiar la lista3 antes de calcular la diferencia

        for (Integer elemento : lista1) {
            if (!lista2.contains(elemento)) {
                lista3.add(elemento);
            }
        }

        for (Integer elemento : lista2) {
            if (!lista1.contains(elemento)) {
                lista3.add(elemento);
            }
        }

        String mensaje = "Diferencia entre Listas:\n" + lista3;
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
