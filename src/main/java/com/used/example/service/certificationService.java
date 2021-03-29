package com.used.example.service;


import java.util.HashMap;

import com.used.example.controller.*;
import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class certificationService {
	
	
	public void certifiedPhoneNumber(String phoneNumber, String cerNum) {
		String api_key= "NCS5GW8B7QDXQERY";
		String api_secret="FBJNABLR68IVRK5LM5JTBIP5MUMK9AVA";
		Message coolsms= new Message(api_key, api_secret);
		
		HashMap<String, String> params= new HashMap<String, String>();
		params.put("to", phoneNumber);
		params.put("from", "01083747388");
		params.put("type", "SMS");
		params.put("text", "[Used]인증번호:"+"["+cerNum+"]"+"입니다");
		params.put("app_version", "test app 1.2");
		
		
		try {
			JSONObject obj= (JSONObject)coolsms.send(params);
			System.out.println(obj.toString());
		}catch (CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
		}
		
	}
	

}
