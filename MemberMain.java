package library;

import library.ui.KioskUI;

public class MemberMain {

	public static void main(String[] args) {
	
		try {
				new KioskUI().execute();
		} catch(Exception e) {
			e.printStackTrace();
		}		
		}
	}


