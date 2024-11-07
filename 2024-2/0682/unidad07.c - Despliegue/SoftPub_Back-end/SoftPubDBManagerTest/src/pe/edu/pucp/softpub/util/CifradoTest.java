package pe.edu.pucp.softpub.util;

public class CifradoTest {

    public static void main(String[] args) {
        //prueba del crifrado de la contraseña
        String contraseña = "Programacion3";
        String contraseña_cifrada = Cifrado.cifrarMD5(contraseña);
        String contraseña_descifrada = Cifrado.descifrarMD5(contraseña_cifrada);
        System.out.println(contraseña);
        System.out.println(contraseña_cifrada);
        System.out.println(contraseña_descifrada);                         
    }

}
