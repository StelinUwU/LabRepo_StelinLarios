/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labrepo_stelinlarios;

import java.util.Scanner;

/**
 *
 * @author stelinlarios
 */
public class LabRepo_StelinLarios {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("1. Dungeons and Dragons");
            System.out.println("2. Laberinto");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Never gonna give you up\n"
                            + "Never gonna let you down\n"
                            + "Never gonna run around and desert you\n"
                            + "Never gonna make you cry\n"
                            + "Never gonna say goodbye\n"
                            + "Never gonna tell a lie and hurt you");

                    break;
                case 2:
                    iniciarLaberinto();
                    break;
                case 3:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opción no invalida");
            }
        } while (opcion != 3);

    }

    public static void iniciarLaberinto() {
        char[][] laberinto = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', 'C', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', '#', ' ', '#', '#', '#', ' ', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', '#'},
            {'#', ' ', '#', ' ', '#', '#', ' ', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
        };
        int salidaX = 5;
        int salidaY = 9;

        int jugadorX = 1;
        int jugadorY = 1;
        boolean jugando = true;

        while (jugando) {
            imprimirLaberinto(laberinto);
            System.out.print("Ingrese un movimiento (w/a/s/d): ");
            String movimiento = scanner.nextLine();
            if (!movimiento.isEmpty()) {
                char direccion = movimiento.charAt(0);
                int[] nuevaPosicion = moverJugador(jugadorX, jugadorY, direccion, laberinto);
                jugadorX = nuevaPosicion[0];
                jugadorY = nuevaPosicion[1];

                if (jugadorX == salidaX && jugadorY == salidaY) {
                    System.out.println("Ganaste");
                    jugando = false;
                }
            }
        }
    }

    public static void imprimirLaberinto(char[][] laberinto) {
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[i].length; j++) {
                System.out.print(laberinto[i][j]);
            }
            System.out.println();
        }
    }

    public static int[] moverJugador(int x, int y, char direccion, char[][] laberinto) {
        int nuevoX = x;
        int nuevoY = y;

        switch (direccion) {
            case 'w':
                nuevoX--;
                break;
            case 'a':
                nuevoY--;
                break;
            case 's':
                nuevoX++;
                break;
            case 'd':
                nuevoY++;
                break;
        }

        if (puedeMoverse(nuevoX, nuevoY, laberinto)) {
            laberinto[x][y] = ' ';
            laberinto[nuevoX][nuevoY] = 'C';
            x = nuevoX;
            y = nuevoY;
        } else {
            System.out.println("Movimiento invalido");
        }

        return new int[]{x, y};
    }

    public static boolean puedeMoverse(int x, int y, char[][] laberinto) {
        boolean dentroDeLimitesVerticales = x >= 0 && x < laberinto.length;

        boolean dentroDeLimitesHorizontales = y >= 0 && y < laberinto[0].length;

        boolean noEsPared = dentroDeLimitesVerticales && dentroDeLimitesHorizontales && laberinto[x][y] != '#';

        return noEsPared;
    }
}
