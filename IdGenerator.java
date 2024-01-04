import java.util.Random;

public class IdGenerator {
    public static String generateUserId() {
        int randomUserId = new Random().nextInt(9999) + 1;

        return String.format("%06d", randomUserId);
    }

    public static String generateOtp() {
        int otp = new Random().nextInt(9999) + 1;

        return String.format("%04d", otp);
    }
}
