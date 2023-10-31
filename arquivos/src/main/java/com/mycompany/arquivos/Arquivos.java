/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arquivos;

import java.io.*;

/**
 *
 * @author dam2
 */
import java.io.File;
import java.io.IOException;

public class Arquivos {

    // Método para verificar si una cadena corresponde a un directorio
    public static void eDirectorio(String cadena) {
        File directorio = new File(cadena);
        if (directorio.isDirectory()) {
            System.out.println("Es un directorio");
        } else {
            System.out.println("No es un directorio");
        }
    }

    // Método para comprobar si una cadena corresponde a un archivo
    public static void eFicheiro(String cadena) {
        File archivo = new File(cadena);
        if (archivo.isFile()) {
            System.out.println("Es un fichero");
        } else {
            System.out.println("No es un fichero");
        }
    }

    // Método para crear un directorio si no existe
    public static void creaDirectorio(String rutaDirectorio) {
        File directorio = new File(rutaDirectorio);
        if (!directorio.exists()) {
            if (directorio.mkdir()) {
                System.out.println("Directorio creado con éxito");
            } else {
                System.out.println("No se pudo crear el directorio");
            }
        } else {
            System.out.println("El directorio ya existe");
        }
    }

    // Método para crear un archivo en una ruta si no existe
    public static void creaFicheiro(String dirName, String fileName) {
        File archivo = new File(dirName, fileName);
        if (!archivo.exists()) {
            try {
                if (archivo.createNewFile()) {
                    System.out.println("Archivo creado con éxito");
                } else {
                    System.out.println("No se pudo crear el archivo");
                }
            } catch (IOException e) {
                System.out.println("Error al crear el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo ya existe");
        }
    }

    // Método para verificar los modos de acceso (lectura y escritura) de un archivo
    public static void modoAcceso(String dirName, String fileName) {
        File archivo = new File(dirName, fileName);
        if (archivo.canRead()) {
            System.out.println("Lectura sí");
        } else {
            System.out.println("Lectura no");
        }
        if (archivo.canWrite()) {
            System.out.println("Escritura sí");
        } else {
            System.out.println("Escritura no");
        }
    }

    // Método para calcular la longitud de un archivo en bytes
    public static void calculaLonxitude(String dirName, String fileName) {
        File archivo = new File(dirName, fileName);
        System.out.println("Longitud del archivo: " + archivo.length() + " bytes");
    }

    // Método para hacer un archivo de solo lectura
    public static void mLectura(String dirName, String fileName) {
        File archivo = new File(dirName, fileName);
        if (archivo.setReadOnly()) {
            System.out.println("Archivo establecido como solo lectura");
        } else {
            System.out.println("No se pudo establecer como solo lectura");
        }
    }

    // Método para hacer posible escribir en un archivo
    public static void mEscritura(String dirName, String fileName) {
        File archivo = new File(dirName, fileName);
        if (archivo.setWritable(true)) {
            System.out.println("Escritura habilitada en el archivo");
        } else {
            System.out.println("No se pudo habilitar la escritura en el archivo");
        }
    }

    // Método para borrar un archivo si existe
    public static void borraFicheiro(String dirName, String fileName) {
        File archivo = new File(dirName, fileName);
        if (archivo.exists()) {
            if (archivo.delete()) {
                System.out.println("Archivo eliminado con éxito");
            } else {
                System.out.println("No se pudo eliminar el archivo");
            }
        } else {
            System.out.println("El archivo no existe");
        }
    }

    // Método para borrar un directorio si existe
    public static void borraDirectorio(String rutaDirectorio) {
        File directorio = new File(rutaDirectorio);
        if (directorio.exists()) {
            if (directorio.isDirectory()) {
                if (directorio.delete()) {
                    System.out.println("Directorio eliminado con éxito");
                } else {
                    System.out.println("No se pudo eliminar el directorio");
                }
            } else {
                System.out.println("La ruta no corresponde a un directorio");
            }
        } else {
            System.out.println("El directorio no existe");
        }
    }

    // Método para listar archivos y directorios de primer nivel en una ruta
    public static void mContido(String dirName) {
        File directorio = new File(dirName);
        if (directorio.exists() && directorio.isDirectory()) {
            String[] contenido = directorio.list();
            System.out.println("Contenido de " + dirName + ":");
            for (String elemento : contenido) {
                System.out.println(elemento);
            }
        } else {
            System.out.println("La ruta no corresponde a un directorio válido");
        }
    }

    public static void main(String[] args) {
        
        String dirName = "/home/dam2/Escritorio/arquivos";
        String fileName = "archivo.txt";
        eDirectorio(dirName);
        eFicheiro(dirName + "/" + fileName);
        creaDirectorio(dirName);
        creaFicheiro(dirName, fileName);
        modoAcceso(dirName, fileName);
        calculaLonxitude(dirName, fileName);
        mLectura(dirName, fileName);
        mEscritura(dirName, fileName);
        borraFicheiro(dirName, fileName);
        borraDirectorio(dirName);
        mContido(dirName);
    }
}











