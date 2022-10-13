package insuranceco;

import java.time.LocalDate;

public class CarComputationHelper {

	public static double getFairMarketValue(int assetValue, int yearModel) {
		int depreciationYr = LocalDate.now().getYear() - yearModel;

        double depreciationPercent = getDeprecationPercentage(depreciationYr);
        double depreciationAmount = assetValue * depreciationPercent;

        double newAssetValue = assetValue - depreciationAmount;
        double additionalValue = newAssetValue * 0.03;

        return newAssetValue + additionalValue;
	}
	
	
	public static double getDeprecationPercentage(int year) {
	
		if(year >=0 && year <=1) {
			return 10 / 100.0;
		}
		else if(year >=1 && year <=2) {
			return 15 / 100.0;
		}
		else if(year >=2 && year <=3) {
			return 20 / 100.0;
		}
		else if(year >=3 && year <=4) {
			return 25 / 100.0;
		}
		else if(year >=4 && year <=5) {
			return 30 / 100.0;
		}
		else if(year >=6 && year <=7) {
			return 35 / 100.0;
		}
		else if(year >=7 && year <=8) {
			return 40 / 100.0;
		}
		else if(year >=8 && year <=9) {
			return 45 / 100.0;
		}
		else if(year >=10 && year <=10 ) {
			return 50 / 100.0;
		}
		else {
			return 5 / 100.0;
		}
	}
	
	public static double getDeprecationFee(int year, String primaryUsed) {

        if(year >=3 && year <=4) {
            return "private".equalsIgnoreCase(primaryUsed) ? (20 / 100.0) : (25 / 100.0);
        }
        else if(year >=4 && year <=5) {
            return "private".equalsIgnoreCase(primaryUsed) ? (25 / 100.0) : (30 / 100.0);
        }
        else if(year >=5 && year <=6) {
            return "private".equalsIgnoreCase(primaryUsed) ? (30 / 100.0) : (35 / 100.0);
        }
        else if(year >=6 && year <=7) {
            return "private".equalsIgnoreCase(primaryUsed) ? (35 / 100.0) : (40 / 100.0);
        }
        else if(year >=8) {
            return "private".equalsIgnoreCase(primaryUsed) ? (45 / 100.0) : (50 / 100.0);
        }
        else {
            return 0;
        }
    }
}
