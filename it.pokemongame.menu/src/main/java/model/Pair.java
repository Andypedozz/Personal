package model;

public class Pair<T1,T2> {
	private T1 first;
	private T2 second;
	
	public Pair(T1 first, T2 second) {
		this.first = first;
		this.second = second;
	}
	
	public T1 getFirst() {
		return this.first;
	}


	public T2 getSecond() {
		return this.second;
	}


	public void setFirst(T1 x) {
		this.first = x;
	}


	public void setSecond(T2 x) {
		this.second = x;
	}
	
	public boolean equals(Object o) {
		return this.first.equals(((Pair)o).getFirst()) &&
				this.second.equals(((Pair)o).getSecond());
	}

}
