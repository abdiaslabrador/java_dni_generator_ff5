package dev.exerc.dni.models;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DniTest {
    private Scanner scanner;
    Dni dniWithLetter;
    char[] alphabet = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        dniWithLetter = new Dni();
    }

    @Test
    void testDniInput_Incorrect_Number() {
        String simulatedInput = "1111w\n12345678\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        scanner = new Scanner(System.in);
        dniWithLetter.dniInput(scanner);
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("El dato introducido es incorrecto"));
    }

    @Test
    void testDniInput_Correct_Number() {
        String simulatedInput = "12345678\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        scanner = new Scanner(System.in);
        int result = dniWithLetter.dniInput(scanner);
        assertEquals(12345678, result);
    }
    @Test
    void testDniInput_Is_Less_Number_OutRank() {
        String simulatedInput = "-1\n12345678\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        scanner = new Scanner(System.in);
        dniWithLetter.dniInput(scanner);
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("el número debe ser entre 0 y 99999999"));
    }

    @Test
    void testDniInput_Is_Bigger_Number_OutRank() {
        String simulatedInput = "1234567891\n12345678\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        scanner = new Scanner(System.in);
        dniWithLetter.dniInput(scanner);
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("el número debe ser entre 0 y 99999999"));
    }

    @Test
    void testGetDniWithLetter() {
        int dni = 12345678;
        dniWithLetter.getDniWithLetter(dni);
        assertThat(String.class, is(dniWithLetter.getDniWithLetter(dni).getClass()));
    }
}
