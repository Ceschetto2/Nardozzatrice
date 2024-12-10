package nardo.test;

public class Nardozzatrice {

    public static int massimoComunDivisore(int a, int b){

        //r0 è il primo resto
        int r0 = b;

        //r1 è il secondo resto
        int r1 = a%b;

        int MCD = b;

        while(r1 != 0)
        {
            MCD = r1;
            r1 = r0 % r1;
            r0 = MCD;
        }
        return MCD;
    }

}
