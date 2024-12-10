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

    // Algoritmo di Euclide Esteso per trovare il MCD e i coefficienti x e y
    private static int[] euclideEsteso(int a, int b) {
        int x0 = 1, y0 = 0; // x0 e y0 sono i coefficienti di a
        int x1 = 0, y1 = 1; // x1 e y1 sono i coefficienti di b
        int r0 = a, r1 = b; // r0 e r1 sono i resti

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

        // Restituisce MCD, x, y
        return new int[]{r0, x0, y0};
    }

    // Funzione per risolvere l'equazione diofantea ax + by = c
    public static int[] equazioneDiofantea(int a, int b, int c) {
        int[] result = euclideEsteso(a, b);
        int MCD = result[0];

        // Moltiplicazione dei coefficienti x e y per c / MCD
        int x = result[1] * (c / MCD);
        int y = result[2] * (c / MCD);

        return new int[]{x, y};
    }
}