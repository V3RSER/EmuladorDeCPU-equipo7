package co.com.sofka.cpu;

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

        int numeroInstruccion = 0;
        int numeroEjecucion = 0;
        CPU micpu = new CPU();
        String comando = subrutina[numeroInstruccion].split(" ")[0];
        String parametros = subrutina[numeroInstruccion].split(" ")[1];
        //if parametros = subrutina[numeroInstruccion].split();

        while((Objects.equals(micpu.getRegistros(42), "0")) || (numeroInstruccion <= 1024) || (numeroEjecucion <= 5e4)) {
            comando = subrutina[numeroInstruccion].split(" ")[0];
            parametros = subrutina[numeroInstruccion].split(" ")[1];

            switch (comando) {
                case "MOV":
                    micpu.copiarValor("R01", "R02");
                    break;
                case "ADD":
                    micpu.sumarValor("R03", "R04");
                    break;
                case "DEC":
                    micpu.decrementarValor("R05");
                    break;
                case "INC":
                    micpu.incrementarValor("R06");
                    break;
                case "INV":
                    micpu.invertirRegistro("R07");
                    break;
                case "JMP":
                    numeroInstruccion =  - 1;
                    break;
                case "JZ":
                    if(micpu.saltoCondicional()){
                        numeroInstruccion =  - 1;
                    }
                    break;
                case "NOP":
                    break;
            }
            numeroInstruccion++;
            numeroEjecucion++;
        }
    }
}
