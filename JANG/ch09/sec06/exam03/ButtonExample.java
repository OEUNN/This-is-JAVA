package ch09.sec06.exam03;

public class ButtonExample {

	public static void main(String[] args) {
		//Button 객체 생성
		Button btnOk = new Button();
		Button btnCancle=new Button();
		
		//Button Click Event 처리 클래스 (Listener 클래스) 선언
		class OkListener implements Button.ClickListener{
			@Override
			public void onClick() {
				System.out.println("Ok버튼을 클릭 했습니다.");		
			}
		}
		class CancleListener implements Button.ClickListener{
			@Override
			public void onClick() {
				System.out.println("Cancle버튼을 클릭 했습니다.");	
			}	
		}
		//Button 객체에 Click Event 처리 객체 설정
		btnOk.setClickListener(new OkListener());
		btnCancle.setClickListener(new CancleListener());
		
		//Button이 클릭 되었을 때
		btnOk.click();
		btnCancle.click();
	}

}
