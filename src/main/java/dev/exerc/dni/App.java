package dev.exerc.dni;

import java.util.Scanner;

import dev.exerc.dni.models.Dni;

public final class App {
    private App() {
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dni dniWithLetter = new Dni();
        System.out.println(dniWithLetter.getDniWithLetter(dniWithLetter.dniInput(scanner)));
        scanner.close();
    }
}
