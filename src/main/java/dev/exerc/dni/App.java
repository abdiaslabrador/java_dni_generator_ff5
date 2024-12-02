package dev.exerc.dni;

import java.util.Scanner;

import dev.exerc.dni.models.Dni;

public final class App {
    private App() {
    }
    public static void main(String[] args) {

        Dni dniLetter = new Dni();
        System.out.println(dniLetter.getDniLetter(dniLetter.dniInput()));

    }
}
