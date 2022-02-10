package co.com.sofka.cpu;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Objects;

public class app {
    public static void main(String[] args) {
        String[] subrutina = {
                "MOV 5,R00",
                "MOV 10,R01",
                "JZ 7",
                "ADD R02,R01",
                "DEC R00",
                "JMP 3",
                "MOV R02,R42"
        };
        System.out.println("El resultado es: " + emulacion(subrutina));
    }

    public static String emulacion(String[] subrutina) {

        String comando;
        String parametros;
        String parametro1;
        String parametro2;
        int numeroInstruccion = 0;
        int numeroEjecucion = 0;
        CPU micpu = new CPU();

        while ((Objects.equals(micpu.getRegistros(42), "0")) || (numeroInstruccion >= 1023) || (numeroEjecucion >= 5e4)) {

            comando = subrutina[numeroInstruccion].split(" ")[0];
            parametros = "";
            parametro1 = "";
            parametro2 = "";
            if (subrutina[numeroInstruccion].split(" ").length > 1) {
                parametros = subrutina[numeroInstruccion].split(" ")[1];
                parametro1 = parametros.split(",")[0];

                if (parametros.split(",").length > 1) {
                    parametro2 = parametros.split(",")[1];
                }
            }

            switch (comando) {
                case "MOV":
                    micpu.copiarValor(parametro1, parametro2);
                    break;
                case "ADD":
                    micpu.sumarValor(parametro1, parametro2);
                    break;
                case "DEC":
                    micpu.decrementarValor(parametro1);
                    break;
                case "INC":
                    micpu.incrementarValor(parametro1);
                    break;
                case "INV":
                    micpu.invertirRegistro(parametro1);
                    break;
                case "JMP":
                    numeroInstruccion = Integer.parseInt(parametro1) - 2;
                    break;
                case "JZ":
                    if (Boolean.TRUE.equals(micpu.saltoCondicional())) {
                        numeroInstruccion = Integer.parseInt(parametro1) - 2;
                    }
                    break;
                case "NOP":
                    break;
            }
            numeroInstruccion++;
            numeroEjecucion++;
        }

        //micpu.mostrarRegistros();

        return micpu.getRegistros(42);
    }
}


