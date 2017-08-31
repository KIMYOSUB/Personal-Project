package practice;

public class AStack<T> {     		//AStack이라는 Generic 클래스를 만든다. 
	                         		//<Type> 타입에는 내가 원하는 타입을 넣을것이고 이것은 스택을 위한 클래스이다. 즉 int형, String등등 모두 가능  
	int tos;                 		//순서대로 넣고 꺼낼 때 변하는 index
	Object [] stack;         		//객체 배열 선언
	
	public AStack() {        		//생성자 : AStack 객체가 생성이 되면
		tos = 0;					//tos는 0으로 초기화 되고
		stack = new Object[10];     //객체배열 stack은 10개의 공간을 가지도록 초기화 된다
	}
	
    
	
	public void push(T a) {         //넣을 때 메소드다.
		if(tos == 10) {             //배열이 꽉차면 넣을 수 있는 공간이 없기 때문에 그냥 리턴 한다.
			System.out.println("배열이 꽉찼습니다.");
			return;
		}
		stack[tos] = (T)a;          //T타입의 매개변수 a를 저장한다.
		tos++;
	}
	
	public void pop() {
		if(tos == 0) {
			System.out.println("배열이 비어있어 더 이상 pop할 수 없습니다.");
			return;
		}
		tos--;
		stack[tos] = null;
		
	}
	
	public void show() {
		for(int i=0; i<stack.length; i++) {
			if(stack[i] == null) {
				continue;
			}
			System.out.print(stack[i]+" ");
		}
		System.out.print("\n");

	}
	
}
