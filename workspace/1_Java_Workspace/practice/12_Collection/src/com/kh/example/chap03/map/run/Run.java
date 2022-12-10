package com.kh.example.chap03.map.run;

import com.kh.example.chap03.map.compare.SnackComparator;
import com.kh.example.chap03.map.controller.MapController;

public class Run {

	public static void main(String[] args) {

		MapController mc = new MapController();
		mc.doMap();
		
//		SnackComparator sc = new SnackComparator();
		mc.doProperties();
		
	}

}
