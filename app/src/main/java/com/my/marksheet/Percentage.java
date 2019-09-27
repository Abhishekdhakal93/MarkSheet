package com.my.marksheet;

import java.text.DecimalFormat;

public class Percentage {
    private double amarks,iotmarks,webmarks;
    private String status;
    DecimalFormat decimalFormat = new DecimalFormat("0.00");
    public Percentage(double amarks, double iotmarks, double webmarks) {
        this.amarks = amarks;
        this.iotmarks = iotmarks;
        this.webmarks = webmarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmarks() {
        return amarks;
    }

    public void setAmarks(double amarks) {
        this.amarks = amarks;
    }

    public double getIotmarks() {
        return iotmarks;
    }

    public void setIotmarks(double iotmarks) {
        this.iotmarks = iotmarks;
    }

    public double getWebmarks() {
        return webmarks;
    }

    public void setWebmarks(double webmarks) {
        this.webmarks = webmarks;
    }

    public String percentage() {

        double android = 0, iot = 0, web = 0, per = 0;
        android = Double.parseDouble(decimalFormat.format((amarks)));
        iot = Double.parseDouble(decimalFormat.format(iotmarks));
        web = Double.parseDouble(decimalFormat.format(webmarks));


        per = (android + iot + web) / 3;
        if ((android >= 40) && (iot >= 40) && (web >= 40)) {
            setStatus("pass");
        } else {
            setStatus("fail");
        }

        return decimalFormat.format(per);
    }
}
