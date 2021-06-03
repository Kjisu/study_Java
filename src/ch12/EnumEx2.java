package ch12;

enum Direction2 { 
	
	EAST(1,">"), SOUTH(2,"V") , WEST(3,"<"), NORTH(4,"^");
	
	// �������� ��� �߰��� ���� ���� ���� ������ �ν��Ͻ� ������ �����ڸ� �߰��� ��� ��.
	private final int value;
	private final String symbol;
	
	private static final Direction2[] DIR_ARR = Direction2.values();
	
	Direction2(int value,String symbol) {
		this.value = value;
		this.symbol = symbol;
	}
	
	
	int getValue() {
		return value;
	}
	
	String getSymbol() {
		return symbol;
	}
	
	public static Direction2 of(int dir) {
		
		if(dir<1 || dir>4) {
			throw new IllegalArgumentException("Invalid value : "+dir);
		}
		
		return DIR_ARR[dir-1];
	} // of()
	
	
	// ������ ȸ����Ű�� �޼���. num�� ����ŭ 90���� �ð�������� ȸ���Ѵ�.
	public Direction2 rotate(int num) {
		
		num = num%4;
		
		System.out.println(">>>>????"+num);
		
		if(num<0) num +=4; // num�� ������ ���� �ð�ݴ� �������� ȸ��
		
		System.out.println("????????2222>>>>"+(value-1+num)%4);
		
		return DIR_ARR[(value-1+num)%4];
		
	}//rotate()
	
	
	public String toString() {
		return name()+getSymbol();
	}//toString()

}//enum Direction2 



public class EnumEx2 {
	
	public static void main(String[] args) {
		
		for(Direction2 d : Direction2.values()) {
			System.out.printf("%s=%d%n",d.name(),d.getValue());
		}
		
		Direction2 d1 = Direction2.EAST;
		Direction2 d2 = Direction2.of(1);
		
		System.out.printf("d1=%s, %d%n",d1.name(),d1.getValue());
		System.out.printf("d2=%s, %d%n",d2.name(),d2.getValue());
		
		System.out.println();
		
		System.out.println(Direction2.EAST.rotate(1));
		
	}

}