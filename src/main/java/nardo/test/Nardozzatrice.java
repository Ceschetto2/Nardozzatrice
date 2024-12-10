package nardo.test;

public class Nardozzatrice {

    public static int[] bezoutCoeffAndMCD(int a, int b) {

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
        return new int[]{r0, x0,x1};
    }

    // Funzione per risolvere l'equazione diofantea ax + by = c
    public static int[] equazioneDiofantea(int a, int b, int c) {


        int MCD, x0, y0;
        int[] res = bezoutCoeffAndMCD(a, b);
        MCD = res[0];
        x0 = res[1];
        y0 = res[2];

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