package com.khoai.oto;

/**
 * Created by TruDu on 7/27/17.
 */

public class Detail {
    String _id;
    String image;
    String moden;
    String recieve;
    String type;
    String source;
    String costdp;
    String costny;
    String engine;
    String capacity;
    String torque;

    public Detail(){
    }
    public Detail(String moden, String recieve, String type, String source, String cost_ny, String cost_dp,
                  String engine, String capacity, String torque){
        this.moden = moden;
        this.recieve = recieve;
        this.type = type;
        this.source = source;
        this.costny = cost_ny;
        this.costdp = cost_dp;
        this.engine = engine;
        this.capacity = capacity;
        this.torque = torque;
    }
    public Detail(String id, String moden, String recieve, String type, String source, String cost_ny, String cost_dp,
                  String engine, String capacity, String torque){
        this._id = id;
        this.moden = moden;
        this.recieve = recieve;
        this.type = type;
        this.source = source;
        this.costny = cost_ny;
        this.costdp = cost_dp;
        this.engine = engine;
        this.capacity = capacity;
        this.torque = torque;
    }
    public String getID(){ return this._id; }
    public String getImage(){ return this.image; }
    public String getModen(){ return this.moden; }
    public String getRecieve(){ return this.recieve; }
    public String getType(){ return this.type; }
    public String getSource(){ return this.source; }
    public String getCostNY(){ return this.costny; }
    public String getCostDP(){ return this.costdp; }
    public String getEngine(){ return this.engine; }
    public String getCapacity(){ return this.capacity; }
    public String getTorque(){ return this.torque; }

    public void setID(String id) { this._id = id; }
    public void setImage(String image) { this.image = image; }
    public void setModen(String moden) { this.moden = moden; }
    public void setRecieve(String recieve){ this.recieve = recieve; }
    public void setType(String type) { this.type = type; }
    public void setSource(String source) { this.source = source; }
    public void setCostNY(String cost_ny) { this.costny = cost_ny; }
    public void setCostDP(String cost_dp) { this.costdp = cost_dp; }
    public void setEngine(String engine) { this.engine = engine; }
    public void setCapacity(String capacity) { this.capacity = capacity; }
    void setTorque(String torque) { this.torque = torque; }


}
