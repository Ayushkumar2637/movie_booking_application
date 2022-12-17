package com.ayushkumar.moviebooking.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

// This dto class is we are using is almost same as entity class
// The reason behind creation of this class is from f.e to b.e or App1 to App2 the data is transfer over the network
// is called Dto's the java take dto in the form of obj do action with this and return in form of obj later convert in
// Json on f.e

public class DemoDto {

    @JsonProperty("demo_id")
    private int demoId;
    @JsonProperty("demo_name")
    private String demoName;
    @JsonProperty("demo_desc")
    private String demoDescription;

    public DemoDto(){}

    public DemoDto(int demoId,String demoName,String demoDescription) {
        this.demoId = demoId;
        this.demoName = demoName;
        this.demoDescription = demoDescription;
    }

    public int getDemoId() {
        return demoId;
    }

    public String getDemoName() {
        return demoName;
    }

    public String getDemoDescription() {
        return demoDescription;
    }

    public void setDemoId(int demoId) {
        this.demoId = demoId;
    }

    public void setDemoName(String demoName) {
        this.demoName = demoName;
    }

    public void setDemoDescription(String demoDescription) {
        this.demoDescription = demoDescription;
    }

    @Override
    public String toString() {
        return "DemoDto{" +
                "demoId=" + demoId +
                ", demoName='" + demoName + '\'' +
                ", demoDescription='" + demoDescription + '\'' +
                '}';
    }
}
