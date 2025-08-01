package interview.chapter1;

import java.util.Random;

class MakeArray {
    public static final int ARRAY_LENGTH = 4000;
    public static final int THRESHOLD = 47;

    public static int[] makeArray() {
        Random random = new Random();
        int[] result = new int[ARRAY_LENGTH];

        for (int i = 0; i < ARRAY_LENGTH; i++) {
            result[i] = random.nextInt(ARRAY_LENGTH *3);

        }

        return result;
    }
}
