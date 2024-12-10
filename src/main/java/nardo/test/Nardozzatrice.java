package nardo.test;

public class Nardozzatrice {

    public static int massimoComunDivisore(int a, int b) {

        //r0 è il primo resto
        int r0 = b;

        //r1 è il secondo resto
        int r1 = a % b;

        int MCD = b;

        while (r1 != 0) {
            MCD = r1;
            r1 = r0 % r1;
            r0 = MCD;
        }
        return MCD;
    }

    // Funzione per risolvere l'equazione diofantea ax + by = c
    public static int[] equazioneDiofantea(int a, int b, int c) {
        // Variabili per i coefficienti di Bézout
        int x0 = 1, y0 = 0; // Coefficienti iniziali per a
        int x1 = 0, y1 = 1; // Coefficienti iniziali per b
        int r0 = a, r1 = b; // Resti iniziali

        while (r1 != 0) {
            int q = r0 / r1; // Quoziente
            int temp = r1;
            r1 = r0 % r1;
            r0 = temp;

            // Aggiornamento dei coefficienti
            int tempX = x1;
            x1 = x0 - q * x1;
            x0 = tempX;

            int tempY = y1;
            y1 = y0 - q * y1;
            y0 = tempY;
        }

        int MCD = r0;

        // Controllo se c è divisibile per il MCD
        if (c % MCD != 0) {
            throw new ArithmeticException("Non esistono soluzioni intere per l'equazione " + a + "x + " + b + "y = " + c);
        }

        // Calcolo delle soluzioni scalando i coefficienti di Bézout
        int x = x0 * (c / MCD);
        int y = y0 * (c / MCD);

        return new int[]{x, y};
    }

}