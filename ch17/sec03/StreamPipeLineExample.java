package ch17.sec03;

import java.util.List;

public class StreamPipeLineExample {

	public static void main(String[] args) {
		List<Student> list=List.of(
				new Student("홍길동",10),
				new Student("김길동",20),
				new Student("서길동",30)
				);
		
		double avg=list.stream()
				.mapToInt(student->student.getScore())//중간처리,매핑,int타입
				.average()//최종처리
				.getAsDouble();//double 값을 위해 호출
		System.out.println("평균점수: "+avg);
		
		//학생의 이름만 출력
		list.stream()
		.map(student->student.getName())//매핑,string타입
		.forEach(name->System.out.println(name));//하나씩 출력
				
	}

}
