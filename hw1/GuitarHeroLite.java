import synthesizer.GuitarString;

/** A client that uses the synthesizer package to replicate a plucked guitar string sound */
public class GuitarHeroLite {
    private static final double CONCERT_A = 440.0;
    private static final double CONCERT_B = CONCERT_A * Math.pow(6, 4.0 / 16.0);
    private static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);
    private static final double CONCERT_D = CONCERT_A * Math.pow(10, 3.0 / 12.0);

    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */
        GuitarString stringA = new GuitarString(CONCERT_A);
        GuitarString stringB = new GuitarString(CONCERT_B);
        GuitarString stringC = new GuitarString(CONCERT_C);
        GuitarString stringD = new GuitarString(CONCERT_D);
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (key == 'a') {
                    stringA.pluck();
                } else if (key == 'c') {
                    stringC.pluck();
                } else if (key == 'b') {
                    stringB.pluck();
                } else if(key == 'd') {
                    stringD.pluck();
                }
            }

        /* compute the superposition of samples */
            double sample = stringA.sample() + stringC.sample() + stringB.sample() + stringD.sample();

        /* play the sample on standard audio */
            StdAudio.play(sample);

        /* advance the simulation of each guitar string by one step */
            stringA.tic();
            stringB.tic();
            stringC.tic();
            stringD.tic();
        }
    }
}

