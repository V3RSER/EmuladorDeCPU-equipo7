package co.com.sofka.cpu;

import java.util.Objects;

public class CPU {

    private String[][] registros;

    public CPU() {
        this.registros = new String[43][2];

        for (int i = 0; i < this.registros.length; i++) {
            if (i < 10) {
                this.registros[i][0] = "R0" + i;
            } else {
                this.registros[i][0] = "R" + i;
            }
            this.registros[i][1] = "0";
        }
    }

    /**
     * @param valorDelRegistro1 Rxx o entero positivo
     * @param valorDelRegistro2 Ryy
     * @return
     */
    public void copiarValor(String valorDelRegistro1, String valorDelRegistro2) {

    }

    /**
     * @param valorDelRegistro1 Rxx
     * @param valorDelRegistro2 Ryy
     * @return
     */
    public void sumarValor(String valorDelRegistro1, String valorDelRegistro2) {

        float valorASumar1 = 0;
        float valorASumar2 = 0;
        int p = 0;
        for (int i = 0; i < this.registros.length; i++) {
            if (this.registros[i][0].equals(valorDelRegistro1)) {
                p=i;
                valorASumar1 = Float.parseFloat(this.registros[i][1]);
            }
            else if (this.registros[i][0].equals(valorDelRegistro2)) {
                valorASumar2 = Float.parseFloat(this.registros[i][1]);
            }
        }
        this.registros[p][1] = Float.toString(valorASumar1+valorASumar2);
    }

    /**
     * @param valorDelRegistro Rxx
     * @return
     */
    public void decrementarValor(String valorDelRegistro) {
        
        float valorRegistro = 0; 

        for (int i = 0; i < this.registros.length; i++) {
            if (this.registros[i][0].equals(valorDelRegistro)) {
                valorRegistro = Float.parseFloat(this.registros[i][1]); 

                if (valorRegistro >= 1){
                    valorRegistro = valorRegistro - 1; 
                } else {
                    valorRegistro = Math.pow(2,32)-1;
                }
        
                this.registros[i][1] = Float.toString(valorRegistro);
            }


        }


    }

    /**
     * @param valorDelRegistro Rxx
     * @return
     */
    public void incrementarValor(String valorDelRegistro) {

        float valorRegistro = 0; 

        for (int i = 0; i < this.registros.length; i++) {
            if (this.registros[i][0].equals(valorDelRegistro)) {
                valorRegistro = Float.parseFloat(this.registros[i][1]); 

                if (valorRegistro => Math.pow(2,32)-1){
                    valorRegistro = 0;
                } else if (valorRegistro < Math.pow(2,32)-1) {
                    valorRegistro = valorRegistro + 1;
                }
        
                this.registros[i][1] = Float.toString(valorRegistro);
            }


        }


    }

    /**
     * @param valorDelRegistro Rxx
     * @return
     */
    public void invertirRegistro(String valorDelRegistro) {
        for (int i = 0; i < registros.length; i++) {
            int register = 0;
            if (registros[i][0].equals(valorDelRegistro)) {
                register = Integer.parseInt(this.registros[i][0]);
                register = ~register;
            }
            String result = Integer.toString(register);
        }return;

    }

    /**
     *
     * @return
     */
    public Boolean saltoCondicional() {
        if (Integer.parseInt(this.registros[0][1]) > 0) {
            return false;
        } else {
            return true;
        }
    }

    public void mostrarRegistros() {
        for (int i = 0; i < this.registros.length; i++) {
            System.out.println(this.registros[i][0] + " : " + this.registros[i][1]);
        }
    }

    public String getRegistros(int numeroRegistro) {
        return this.registros[numeroRegistro][1];
    }
}
