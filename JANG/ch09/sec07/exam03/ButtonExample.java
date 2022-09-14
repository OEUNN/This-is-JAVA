package ch09.sec07.exam03;

import ch09.sec07.exam03.Button.ClickListener;
public class ButtonExample {

	public static void main(String[] args) {
		//Button 객체 생성
		Button btnOk = new Button();
		Button btnCancle=new Button();
		
		
		//Button 객체에 Click Event 처리 객체 설정
		btnOk.setClickListener(new ClickListener() {			
			@Override
			public void onClick() {
				System.out.println("ok button");
			}
		});
		btnCancle.setClickListener(new ClickListener() {			
			@Override
			public void onClick() {			
				System.out.println("cancle button");
			}
		});
		
		//Button이 클릭 되었을 때
		btnOk.click();
		btnCancle.click();
	}

}
