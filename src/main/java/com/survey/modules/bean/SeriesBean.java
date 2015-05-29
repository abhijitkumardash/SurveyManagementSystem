package com.survey.modules.bean;


import org.codehaus.jackson.annotate.JsonProperty;


public class SeriesBean {
     @JsonProperty("data")
    private double[] data;


    public SeriesBean(double[] data) {
     this.data = data;
    }


	public double[] getData() {
        return data;
    }

    public void setData(double[] data) {
        this.data = data;
    }
}
