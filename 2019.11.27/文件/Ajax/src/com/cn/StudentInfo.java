package com.cn;
//StudentInfo������
public class StudentInfo {
	private String sname;
	private String sdate;
	private String email;	
	//���췽��
	public StudentInfo(String name, String date, String email) {
		this.sname = name;
		this.sdate = date;
		this.email = email;
	}	
	public String toJsonString() {
		String s = "{\"sname\": \"" + sname + "\", \"sdate\": \"" + sdate + "\", \"email\": \"" + email + "\" }";
		System.out.println(s);
		return s;
		
	}
}
