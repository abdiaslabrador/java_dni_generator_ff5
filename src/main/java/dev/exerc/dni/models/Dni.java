package dev.exerc.dni.models;

import java.util.Scanner;

public class Dni {
    char[] alphabet = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
    private boolean isInRank(int numb){
        return numb >= 0 && numb <= 99999999;
    }

    public int dniInput(Scanner scanner){
        boolean isIncorrect =  true;
        int dniNumber = -1;
        while(isIncorrect || !isInRank(dniNumber)){
            System.out.println("Introduce el número DNI");
            String input = scanner.nextLine().replaceAll("\\s", "");
            
            try {
                dniNumber = Integer.parseInt(input);
                isIncorrect = false;
                if(!isInRank(dniNumber)){
                    System.out.println("el número debe ser entre 0 y 99999999");
                }
            } catch (NumberFormatException e) {
                System.out.println("El dato introducido es incorrecto");
            }
        }
        return dniNumber;
       
    }
    public String getDniWithLetter(int numbDni){
            return String.valueOf(numbDni) + alphabet[numbDni % 23];
    }
}
