package com.spacebank.insurancecenter;

import java.time.Year;
import java.util.HashMap;
import java.util.Iterator;

public class RetirementGoalProcessor {
	
//	public static HashMap<Integer, ClassB> getSample1(){
//		HashMap<Integer, ClassB> map = new HashMap<Integer, ClassB>();
//		
//		ClassB classB = new ClassB("qwrete", 1234);
//		map.put(1, classB);
//		return map;
//	}
//	
	
//	public static HashMap<Integer, YearMatrix> getComputationGoalAndPremium(
//			Integer goalYear, Float goalBenefit, Integer ageNow, Float accountScore) {
//
//		HashMap<Integer, YearMatrix> map = new HashMap<Integer, YearMatrix>();
//		
//		String yearNow = Year.now().toString();
//		
//		Goal
//		
//		
//		return map;
//	}
//	
	public static HashMap<Integer, YearMatrix> getComputationGoalAndPremium(
			 Integer goalBenefit, Integer goalAge, Integer ageNow, Double accountScore) {

		HashMap<Integer, YearMatrix> map = new HashMap<Integer, YearMatrix>();
		
		Integer yearNow = Integer.valueOf(Year.now().toString());
		
		Integer yearsToPay = goalAge - ageNow;
		
		Double annualPremium = (goalBenefit / yearsToPay)/ accountScore;

		
		for (int year = 1; year <= yearsToPay; year++) {
			YearMatrix matrix = new YearMatrix();
			matrix.setAnnualPremium(annualPremium.intValue());
			
			// policy value is the running amount you paid to your policy
			matrix.setPolicyValue(year * annualPremium.intValue());
			
			// claimable is amount starts in the 3rd year
			if(year >= 3) {
				matrix.setClaimable(matrix.getPolicyValue());
			}else {
				matrix.setClaimable(0);
			}
			
			// insuredAge is your age for that particular year
			matrix.setInsuredAge(ageNow + year);
			
			// life insurance is your benefitGoal
			Double lifeInsuranceDou = matrix.getPolicyValue() * accountScore;
			matrix.setLifeInsurance(lifeInsuranceDou.intValue());
			matrix.setDisabilityInsurance(matrix.getLifeInsurance());
			
			map.put(year, matrix);
			System.out.println("year : " +year +" -- "+ matrix.toString());
		}
//		System.out.print(map.toString());
		return map;	
	}

	public static YearMatrix[] getComputationGoalAndPremiumInArr(
			 Integer goalBenefit, Integer goalAge, Integer ageNow, Double accountScore) {

//		HashMap<Integer, YearMatrix> map = new HashMap<Integer, YearMatrix>();
		
		Integer yearNow = Integer.valueOf(Year.now().toString());
		
		Integer yearsToPay = goalAge - ageNow;
		
		Double annualPremium = (goalBenefit / yearsToPay)/ accountScore;

		YearMatrix arr[ ]= new YearMatrix[yearsToPay];
		for (int year = 1; year <= yearsToPay; year++) {
			YearMatrix matrix = new YearMatrix();
			matrix.setAnnualPremium(annualPremium.intValue());
			
			// policy value is the running amount you paid to your policy
			matrix.setPolicyValue(year * annualPremium.intValue());
			
			// claimable is amount starts in the 3rd year
			if(year >= 3) {
				matrix.setClaimable(matrix.getPolicyValue());
			}else {
				matrix.setClaimable(0);
			}
			
			// insuredAge is your age for that particular year
			matrix.setInsuredAge(ageNow + year);
			
			// life insurance is your benefitGoal
			Double lifeInsuranceDou = matrix.getPolicyValue() * accountScore;
			matrix.setLifeInsurance(lifeInsuranceDou.intValue());
			matrix.setDisabilityInsurance(matrix.getLifeInsurance());
			
			matrix.setYear(year);
			
//			map.put(year, matrix);
			arr[year-1] = matrix;
			System.out.println("year : " +year +" -- "+ matrix.toString());
		}
//		System.out.print(map.toString());
		return arr;	
	}

}
