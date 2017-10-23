package com.meredithbayne.earthquaketracker;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by meredithbayne on 10/23/17
 * Implementation of data in a row for an Earthquake
 */

public class Earthquake {

    @SerializedName("datetime")
    @Expose
    private String datetime;

    @SerializedName("depth")
    @Expose
    private Integer depth;

    @SerializedName("lng")
    @Expose
    private Double lng;

    @SerializedName("src")
    @Expose
    private String src;

    @SerializedName("eqid")
    @Expose
    private String eqid;

    @SerializedName("magnitude")
    @Expose
    private Double magnitude;

    @SerializedName("lat")
    @Expose
    private Double lat;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getEqid() {
        return eqid;
    }

    public void setEqid(String eqid) {
        this.eqid = eqid;
    }

    public Double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Double magnitude) {
        this.magnitude = magnitude;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}