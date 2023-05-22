import java.util.Stack;

public class Hanoi {

    private int numDiscos;
    private Stack<Integer> torreA;
    private Stack<Integer> torreB;
    private Stack<Integer> torreC;
    private int movimientosRealizados;

    public Hanoi(int numDiscos) {
        this.numDiscos = numDiscos;
        this.movimientosRealizados = 0;
        iniciarTorres();
    }

    private void iniciarTorres() {
        torreA = new Stack<>();
        torreB = new Stack<>();
        torreC = new Stack<>();

        for (int i = numDiscos; i >= 1; i--) {
            torreA.push(i);
        }
    }

    public int getNumDiscos() {
        return numDiscos;
    }

    public int getMovimientosRealizados() {
        return movimientosRealizados;
    }

    public Stack<Integer> getTorreA() {
        return torreA;
    }

    public Stack<Integer> getTorreB() {
        return torreB;
    }

    public Stack<Integer> getTorreC() {
        return torreC;
    }

    public boolean moverDisco(Torre origen, Torre destino) {
        Stack<Integer> torreOrigen = getTorre(origen);
        Stack<Integer> torreDestino = getTorre(destino);

        if (torreOrigen.isEmpty()) {
            return false; // La torre de origen está vacía
        }

        if (!torreDestino.isEmpty() && torreOrigen.peek() > torreDestino.peek()) {
            return false; // El disco del origen es más grande que el disco del destino
        }

        int disco = torreOrigen.pop();
        torreDestino.push(disco);
        movimientosRealizados++;

        return true;
    }

    private Stack<Integer> getTorre(Torre torre) {
        if (torre == Torre.TORRE_A) {
            return torreA;
        } else if (torre == Torre.TORRE_B) {
            return torreB;
        } else {
            return torreC;
        }
    }

    public enum Torre {
        TORRE_A,
        TORRE_B,
        TORRE_C
    }

}