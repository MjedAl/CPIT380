
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mjed
 */
public class pg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(nextSkewedBoundedDouble(0,1,1,8));
        System.out.println(nextSkewedBoundedDouble(0,1,1,8));
        System.out.println(nextSkewedBoundedDouble(0,1,1,8));
        System.out.println(nextSkewedBoundedDouble(0,1,1,8));
        System.out.println(nextSkewedBoundedDouble(0,1,1,8));
        System.out.println(nextSkewedBoundedDouble(0,1,1,8));
        System.out.println(nextSkewedBoundedDouble(0,1,1,8));
        System.out.println(nextSkewedBoundedDouble(0,1,1,8));
        System.out.println(nextSkewedBoundedDouble(0,1,1,8));
        
        
        
    }
    final static public Random RANDOM = new Random(System.currentTimeMillis());

    static public double nextSkewedBoundedDouble(double min, double max, double skew, double bias) {
        double range = max - min;
        double mid = min + range / 2.0;
        double unitGaussian = RANDOM.nextGaussian();
        double biasFactor = Math.exp(bias);
        double retval = mid + (range * (biasFactor / (biasFactor + Math.exp(-unitGaussian / skew)) - 0.5));
        return retval;
    }

}
