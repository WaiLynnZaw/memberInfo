package com.dhammaschool.memberinfo;

/**
 * Created by WaiLynnZaw on 10/8/15.
 */
public class Member {
    public int id;
    public String name;
    public String email;
    public String phone;
    public String address;

    public Member(int id, String name,String email,String phone, String address){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}
