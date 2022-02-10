package co.com.sofka.cpu;

import java.util.Objects;

public class CPU {

    private String[][] registros = new String[43][2];

    public CPU() {
        for (int i = 0; i < this.registros.length; i++) {
            if (i < 10) {
                this.registros[i][0] = "R0" + i;
            } else {
                this.registros[i][0] = "R" + i;
            }
            this.registros[i][1] = "0";
        }
    }

    /**MOV
     * @param valorDelRegistro1 Rxx o entero positivo
     * @param valorDelRegistro2 Ryy
     * @return
     */
    public void copiarValor(String valorDelRegistro1, String valorDelRegistro2) {

    }

    /**ADD
     * @param valorDelRegistro1 Rxx
     * @param valorDelRegistro2 Ryy
     * @return
     */
    public void sumarValor(String valorDelRegistro1, String valorDelRegistro2) {


    }

    /**DEC
     * @param valorDelRegistro Rxx
     * @return
     */
    public void decrementarValor(String valorDelRegistro) {


    }

    /**INC
     * @param valorDelRegistro Rxx
     * @return
     */
    public void incrementarValor(String valorDelRegistro) {


    }

    /**INV
     * @param valorDelRegistro Rxx
     * @return
     */
    public void invertirRegistro(String valorDelRegistro) {


    }

    /**
     * JMP and JZ
     * @return
     */
    public Boolean saltar(int val) {
        int registro = Integer.parseInt(this.registros[0][1]);
        if (registro) {
            return false;
        } else
            return true;
    }

    public void mostrarRegistros() {
        for (int i = 0; i < this.registros.length; i++) {
            if(Objects.equals(this.registros[i][0], "R20")) {
                System.out.println(this.registros[i][0] + " : " + this.registros[i][1]);
            }
        }
    }

    public String getRegistros(int numeroRegistro) {
        return this.registros[numeroRegistro][1];
    }
}
