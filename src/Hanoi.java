import java.util.Stack;

public class Hanoi {
    private Stack<String> torreI;
    private Stack<String> torreP;
    private Stack<String> torreD;
    private int numDiscos;
    private int minIntentos;
    private int cantIntentos;


    public Hanoi(){
        cantIntentos = 0;
        numDiscos = 0;
        torreI = new Stack<>();
        torreP = new Stack<>();
        torreD = new Stack<>();
    }
    public int getMinIntentos() {
        return minIntentos;
    }

    public void setMinIntentos() {
        this.minIntentos = ((int)Math.pow(2, numDiscos))-1;
    }

    public int getCantIntentosIntentos() {
        return cantIntentos;
    }

    public void setCantIntentosIntentos(int intentos) {
        this.cantIntentos = intentos;
    }

    public Stack<String> getTorreI() {
        return torreI;
    }

    public Stack<String> getTorreP() {
        return torreP;
    }

    public Stack<String> getTorreD() {
        return torreD;
    }

    public void setNumDiscosDiscos(int nDiscos) {
        this.numDiscos = nDiscos;
    }

    public int getNumDiscosDiscos() {
        return numDiscos;
    }

}


