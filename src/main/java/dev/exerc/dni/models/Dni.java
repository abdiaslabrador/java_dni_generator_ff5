package dev.exerc.dni.models;

import java.util.Scanner;

public class Dni {
    char[] alphabet = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
    Scanner scanner = new Scanner(System.in);
    
    public int dniInput(){
        int dniNumber = -1;
        boolean flag =  false;
        while(!flag || dniNumber < 0 || dniNumber > 99999999){
            System.out.println("introduce el número DNI ( el número debe ser entre 0 y 99999999)");
            try{
                dniNumber = Integer.parseInt(scanner.nextLine());
                flag = true;
            }catch (NumberFormatException ex) {
                System.out.println("el dato introducido es incorrecto");
            }
        }
        return dniNumber;
    }
    public String getDniWithLetter(int numbDni){
        if( numbDni >= 0 && numbDni <= 99999999){
            return String.valueOf(numbDni) + alphabet[numbDni % 23];
        }
        return null;
    }
}
