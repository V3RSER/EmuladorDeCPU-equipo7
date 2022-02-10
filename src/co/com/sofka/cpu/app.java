package co.com.sofka.cpu;

public class app {
    public static void main(String[] args) {
        String[] subrutina = {
                "NOP",
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

        while(micpu.getRegistros(43) || (numeroInstruccion <= 1024) || (numeroEjecucion <= 5e4)) {
            comando = subrutina[numeroInstruccion].split(" ")[0];
            parametros = subrutina[numeroInstruccion].split(" ")[1];

            switch (comando) {
                case "MOV":
                    micpu.copiarValor("R01", "R02");
                case "ADD":
                    micpu.sumarValor("R03", "R04");
                case "DEC":
                    micpu.decrementarValor("R05");
                case "INC":
                    micpu.incrementarValor("R06");
                case "INV":
                    micpu.invertirRegistro("R07");
                case "JMP":
                    numeroInstruccion =  - 1;
                case "JZ":
                    if(micpu.saltoCondicional()){
                        numeroInstruccion =  - 1;
                    }
                case "NOP":
                    break;
            }
            numeroInstruccion++;
            numeroEjecucion++;
        }
    }
}
