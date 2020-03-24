package com.example.acmandroidchallengesecond;

public class item {
    String nam,addr,clg;

    public item(String nam, String addr, String clg) {
        this.nam = nam;
        this.addr = addr;
        this.clg = clg;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setClg(String clg) {
        this.clg = clg;
    }

    public String getNam() {
        return nam;
    }

    public String getAddr() {
        return addr;
    }

    public String getClg() {
        return clg;
    }
}
