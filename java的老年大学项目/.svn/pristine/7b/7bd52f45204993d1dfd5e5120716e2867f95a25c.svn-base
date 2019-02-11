package com.drcl.traincore.util;

import java.math.BigDecimal;

/**
 * 经纬度计算
 * 
 * @author twang 20161207
 * 
 */
public class EarthComputeUtil {
	private static double EARTH_RADIUS = 6378.137; // 地球半径

	private static double rad(double d) {
		return d * Math.PI / 180.0; // 计算弧长
	}

	public static String GetDistance(double Lat1, double Lon1, double Lat2, double Lon2) {
		double radLat1 = rad(Lat1);
		double radLat2 = rad(Lat2);
		double a = radLat1 - radLat2;
		double b = rad(Lon1) - rad(Lon2);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		BigDecimal bg = new BigDecimal(s);
		double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()*1000;
		if(f1<50) return "50米";
		else if(f1<300) return "300米以内";
		else if(f1<500) return "500米以内";
		else if(f1<1000) return "1km以内";
		else if(f1<2000) return "2km以内";
		else if(f1<3000) return "3km以内";
		else if(f1<5000) return "5km以内";
		else 
			return "5km以外";
	}
}