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
        if (b == 0) {
            return new int[]{a, 1, 0};  // MCD, x, y
        }
        int[] result = euclideEsteso(b, a % b);
        int mcd = result[0];
        int x1 = result[1];
        int y1 = result[2];

        return new int[]{mcd, y1, (x1 - (a / b) * y1)};
    }

    // Funzione per risolvere l'equazione diofantea ax + by = c
    public static void equazioneDiofantea(int a, int b, int c) {
        try {
            int[] result = euclideEsteso(a, b);
            int MCD = result[0];

            // Se c non è divisibile per MCD, non esistono soluzioni
            if (c % MCD != 0) {
                throw new ArithmeticException("Non esistono soluzioni intere per l'equazione " + a + "x + " + b + "y = " + c + " perché " + c + " non è divisibile per il MCD (" + MCD + ") di " + a + " e " + b + ".");
            }

            // Moltiplicazione dei coefficienti x e y per c / MCD
            int x = result[1] * (c / MCD);
            int y = result[2] * (c / MCD);

            System.out.println("Soluzioni: x = " + x + " y = " + y);
        } catch (ArithmeticException e) {
            System.err.println("Errore: " + e.getMessage());
        }
    }
}