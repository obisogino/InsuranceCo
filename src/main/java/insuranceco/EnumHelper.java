package insuranceco;

public class EnumHelper {
	
	enum PaymentOptions {
		ONE_TIME, THREE_MONTHS, SIX_MONTHS, TWELVE_MONTHS
	}
	
	
	public static int getPaymentOptionValue(PaymentOptions option) {
		switch (option) {
		case ONE_TIME:
			return 1;
		case THREE_MONTHS:
			return 3;
		case SIX_MONTHS:
			return 6;
		case TWELVE_MONTHS:
			return 12;
		default:
			return 1;
		}
	}
}
