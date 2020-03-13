package com.SolarProject.Models;

public class Login {

	private String message;

    public Login(String message) {
        this.message = message;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Login [message=" + message + "]";
	}
    
	
}
