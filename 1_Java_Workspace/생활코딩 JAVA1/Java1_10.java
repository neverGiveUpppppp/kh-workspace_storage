


import javax.swing.JOptionPane;

import org.opentutorials.iot.Elevator; 
import org.opentutorials.iot.Security;
import org.opentutorials.iot.Lighting;

public class Java1_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub



		String id = JOptionPane.showInputDialog("Enter a ID");
		String bright = JOptionPane.showInputDialog("Enter a Bright level");




		// Elevator call
		Elevator myElevator = new Elevator("JAVA APT 507");
		myElevator.callForup(1); 

		// Security off

		Security mySecurity = new Security("JAVA APT 507"); // 누구의 시큐리티인지 알리기해 ()작성
		mySecurity.off(); 

		// Light on
		Lighting hallLamp = new Lighting("JAVA APT 507 / Hall Lamp"); 
		hallLamp.on();

		Lighting floorLamp = new Lighting("JAVA APT 507 / floor Lamp");
		floorLamp.on();

		DimmingLights moodLamp = new DimmingLights(id+" moodLamp");
		moodLamp.setBright(Double.parseDouble(bright)); //setBright()가 실수만 받아서 str을 double로 
		moodLampe.on();                                 // 컨버팅하는 .parseDouble() 메소드사용
		
		
	}

}
