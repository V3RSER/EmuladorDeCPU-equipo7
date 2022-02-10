package co.com.sofka.cpu;

public class Emulador {

    public static void main(String[] args) {

        String[] subrutina = {
                "MOV 5,R00",
                "MOV 10,R01",
                "JZ 7",
                "ADD R02,R01",
                "DEC R00",
                "JMP 3",
                "MOV R02,R42"};

        String[][] registros = new String[43][2];

        for (int i = 0; i < registros.length; i++) {
            if (i < 10) {
                registros[i][0] = "R0" + i;
            } else {
                registros[i][0] = "R" + i;
            }
            registros[i][1] = "0";
        }

        /*for (int i = 0; i < registros.length; i++) {
                System.out.println(registros[i][0] + " : " + registros[i][1]);
        }*/

    }

    public static String[][] ejecutarSubrutina(String[][] registros, String instruccion) {

        String comando = instruccion.split(" ")[0];
        String parametros = instruccion.split(" ")[1];

        switch (instruccion) {
            case "MOV":
                return copiarValor(registros, , );
            case "ADD":
                return sumarValor(registros, , );
            case "DEC":
                return decrementarValor(registros, );
            case "INC":
                return incrementarValor(registros, );
            case "INV":
                return invertirRegistro(registros, );
            case "JMP":
                return saltarInstruccion(registros, );
            case "JZ":
                return saltoCondicional(registros, );
            case "NOP":
                return registros;
        }
        return registros;
    }

    /**
     * @param registros
     * @param valorDelRegistro1 Rxx or valor constante
     * @param valorDelRegistro2 Ryy
     * @return
     */
    public static String[][] copiarValor(String[][] registros, String valorDelRegistro1, String valorDelRegistro2) {

        return registros;
    }

    /**
     * @param registros
     * @param valorDelRegistro1 Rxx
     * @param valorDelRegistro2 Ryy
     * @return
     */
    public static String[][] sumarValor(String[][] registros, String valorDelRegistro1, String valorDelRegistro2) {

        return registros;
    }

    /**
     * @param registros
     * @param valorDelRegistro Rxx
     * @return
     */
    public static String[][] decrementarValor(String[][] registros, String valorDelRegistro) {

        return registros;
    }

    /**
     * @param registros
     * @param valorDelRegistro Rxx
     * @return
     */
    public static String[][] incrementarValor(String[][] registros, String valorDelRegistro) {

        return registros;
    }

    /**
     * @param registros
     * @param valorDelRegistro Rxx
     * @return
     */
    public static String[][] invertirRegistro(String[][] registros, String valorDelRegistro) {

        return registros;
    }

    /**
     * @param registros
     * @param numeroInstruccion x
     * @return
     */
    public static String[][] saltarInstruccion(String[][] registros, int numeroInstruccion) {

        return registros;
    }

    /**
     * @param registros
     * @param numeroInstruccion x
     * @return
     */
    public static String[][] saltoCondicional(String[][] registros, int numeroInstruccion) {

        return registros;
    }

}
