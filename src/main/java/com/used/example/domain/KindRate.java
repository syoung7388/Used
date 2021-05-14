package com.used.example.domain;

public class KindRate {
	
	private String kind;
	private int  kindrate;
	@Override
	public String toString() {
		return "KindRate [kind=" + kind + ", kindrate=" + kindrate + "]";
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getKindrate() {
		return kindrate;
	}
	public void setKindrate(int kindrate) {
		this.kindrate = kindrate;
	}
	
	
	
}
