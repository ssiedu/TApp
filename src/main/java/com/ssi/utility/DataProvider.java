package com.ssi.utility;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
	
	public static List<String> getVehicleBrands(){
		List<String> brands=new ArrayList<String>();
		brands.add("Tata");
		brands.add("Eicher");
		brands.add("Mazda");
		brands.add("Mahindra");
		return brands;
	}

	public static List<String> getVehicleTypes(){
		List<String> vtypes=new ArrayList<String>();
		vtypes.add("Mini-Truck");
		vtypes.add("Tanker");
		vtypes.add("Dumper");
		vtypes.add("Container");
		return vtypes;
	}

}
