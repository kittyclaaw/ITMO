import java.util.Arrays;

public class lab1 {
    public static void main(String[] args){
        long c[] = new long[12];
        for(int i=4; i<16; i++) {
            c[i-4] = i+1;
        }

        double x[] = new double[13];
        for(int i=0; i<12; i++) {
            x[i] = Math.random() * 15 - 6; // (8 - (-6) + 1) + (-6)
        }
`
        double[][] new_c = new double[12][13];
        for(int i=0; i<=11; i++) {
            for(int j=0; j<=12; j++) {
                if (c[i]==10) {
                    new_c[i][j] = (Math.pow(Math.pow((0.25 * (Math.pow(x[j], 0.25/x[j]) + 1)) , Math.cos(x[j])) / 3 , 2));
                } else if (c[i]==6 | c[i]==8 | c[i]==11 | c[i]==12 | c[i]==13 | c[i]==14) {
                    new_c[i][j] = Math.asin(Math.pow(Math.pow(((x[j]+1)/14) , 2) , 2));
                } else {
                    new_c[i][j] = Math.tan(Math.pow(Math.E, Math.sin(Math.cbrt(x[j]))));                    
                }
            }
        }

        for(int i=0; i<=11; i++) {
            for(int j=0; j<=12; j++) {
                double g = new_c[i][j];
                    if (g == g){
                        System.out.printf("%10.5f", new_c[i][j]);
                    } else {
                        System.out.printf("          ");
                    }
                new_c[0] = new int[3][];
            }
            System.out.printf("\n");
        }
    }
}
