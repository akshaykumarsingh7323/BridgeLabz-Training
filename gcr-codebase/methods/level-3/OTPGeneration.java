public class OTPGeneration{

    public static int generateOTP(){
      return 100000 + (int)(Math.random() * 900000);
    }

    public static boolean areOTPsUnique(int[] otps){
        for(int i = 0; i < otps.length; i++){
            for(int j = i + 1; j < otps.length; j++){
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){

        int[] otps = new int[10];

        for(int i = 0; i < otps.length; i++){
            otps[i] = generateOTP();
        }

        System.out.println("Generated OTPs:");
        for (int otp : otps){
            System.out.println(otp);
        }

        boolean result = areOTPsUnique(otps);

        System.out.println("Are all OTPs unique? " + result);
    }
}
