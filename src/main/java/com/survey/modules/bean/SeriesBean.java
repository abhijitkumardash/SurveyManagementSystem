package com.survey.modules.bean;


import org.codehaus.jackson.annotate.JsonProperty;


public class SeriesBean {
    @JsonProperty("name")
    private String name;
    @JsonProperty("data")
    private double[] data;


    public SeriesBean(String name,  double[] data) {
      this.name = name;
      this.data = data;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double[] getData() {
        return data;
    }

    public void setData(double[] data) {
        this.data = data;
    }
}
