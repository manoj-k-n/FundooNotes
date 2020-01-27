package com.bridgelabz.fundoonotes.response;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Response {
	private String name;
	private int Messagecode;
	private Object Token;

	public Response(String name, int error) {
		super();
		this.name = name;
		this.Messagecode = error;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMessagecode() {
		return Messagecode;
	}

	public void setMessagecode(int messagecode) {
		Messagecode = messagecode;
	}

	public Object getObj() {
		return Token;
	}

	public void setObj(Object Token) {
		this.Token = Token;
	}

}
