/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author nobjt
 */
public class User implements Serializable{
    private int id;
    private String name;
    private String ign;
    private String password;
    private String sdt;
    private String email;
    private String vaitro;
    private String mota;

    public User() {
        super();
    }

    public User(int id, String name, String ign, String password, String sdt, String email, String vaitro, String mota) {
        super();
        this.id = id;
        this.name = name;
        this.ign = ign;
        this.password = password;
        this.sdt = sdt;
        this.email = email;
        this.vaitro = vaitro;
        this.mota = mota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIgn() {
        return ign;
    }

    public void setIgn(String ign) {
        this.ign = ign;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVaitro() {
        return vaitro;
    }

    public void setVaitro(String vaitro) {
        this.vaitro = vaitro;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
    public String toString() {
    	if(!this.getIgn().isEmpty()&&!this.getPassword().isEmpty()) {
    	return (this.getId()+this.getIgn()+this.getPassword()+this.getName());
    	}else{
    		return "false";
    	}
    }
}
