    public class prob1 {
        public static void print(Object x){
            System.out.println(x);
        }
        public static void intOverFlow() {
            int x = 2147483647;
            System.out.println(x);
            x += 1;
            System.out.println(x);
        }

        public static void intUnderFlow(){
            int x = -2147483648;
            System.out.println(x);
            x -=1;
            System.out.println(x);
        }

        public static void printFloatIEEE754(float value) {
        int bits = Float.floatToIntBits(value);

        System.out.println("Float value: " + value);
        System.out.println("IEEE 754 (32-bit):");

        for (int i = 3; i >= 0; i--) {
            int byteVal = (bits >> (i * 8)) & 0xFF;
            System.out.printf("Byte %d: %8s (0x%02X)%n",
                    3 - i,
                    String.format("%8s", Integer.toBinaryString(byteVal)).replace(' ', '0'),
                    byteVal);
        }
    }


        public static void byteOverFlow(){
            byte x =  127;
            x+=1;
            System.out.println(x);
        }

        public static void shortUnderFlow(){
            short x = -32768;
            x+=-1;
            System.out.println(x);
        }

        public static void charOverFlow(){
            char x = 65535;
            System.out.println(x);
            x+=1;
            System.out.println(x);
        }

        public static void booleanValidation(){
            boolean x = true;
            print(x);
        }

        public static void prePostIncrement(){
            int x = 1;
            print(x++);
            print(++x);
        }

        public static void longOverUnderFlow(){
            long x = Long.MAX_VALUE;
            x=x+1;
            print(x);
        }

        public static Number preventOverflow(int x,int y){
            long z = (long)x+y;
            if(z>Integer.MAX_VALUE){
                return z;
            }
            return (int)z;
        }

        public static void main(String[] args) {
            intOverFlow();
            intUnderFlow();
            byteOverFlow();
            shortUnderFlow();
            charOverFlow();
            booleanValidation();
            prePostIncrement();
            longOverUnderFlow();
            Number res = preventOverflow(2147483634, 8977877);
            print("res: "+res);
            printFloatIEEE754(6.78f);
        }
    }