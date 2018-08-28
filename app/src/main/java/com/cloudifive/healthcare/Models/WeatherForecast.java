package com.cloudifive.healthcare.Models;

import java.util.ArrayList;

/**
 * Created by gopalakrishnan.s on 27-05-2016.
 */
public class WeatherForecast {

    public String getMyLocationName() {
        return myLocationName;
    }

    public void setMyLocationName(String myLocationName) {
        this.myLocationName = myLocationName;
    }

    public String getMyTemp() {
        return myTemp;
    }

    public void setMyTemp(String myTemp) {
        this.myTemp = myTemp;
    }

    public String getMyTempMin() {
        return myTempMin;
    }

    public void setMyTempMin(String myTempMin) {
        this.myTempMin = myTempMin;
    }

    public String getMyTempMax() {
        return myTempMax;
    }

    public void setMyTempMax(String myTempMax) {
        this.myTempMax = myTempMax;
    }

    public String getMyPressure() {
        return myPressure;
    }

    public void setMyPressure(String myPressure) {
        this.myPressure = myPressure;
    }

    public String getMyHumidity() {
        return myHumidity;
    }

    public void setMyHumidity(String myHumidity) {
        this.myHumidity = myHumidity;
    }

    public String getMyWeatherMain() {
        return myWeatherMain;
    }

    public void setMyWeatherMain(String myWeatherMain) {
        this.myWeatherMain = myWeatherMain;
    }

    public String getMyDescription() {
        return myDescription;
    }

    public void setMyDescription(String myDescription) {
        this.myDescription = myDescription;
    }

    String myLocationName = "";

    String myTemp = "";

    String myTempMin = "";

    String myTempMax = "";

    String myPressure = "";

    String myHumidity = "";

    String myWeatherMain = "";

    String myDescription = "";

    public String getMyDate() {
        return myDate;
    }

    public void setMyDate(String myDate) {
        this.myDate = myDate;
    }

    String myDate = "";

    public String getMyRainFall() {
        return myRainFall;
    }

    public void setMyRainFall(String myRainFall) {
        this.myRainFall = myRainFall;
    }

    String myRainFall = "";

    public String getMyCity() {
        return myCity;
    }

    public void setMyCity(String myCity) {
        this.myCity = myCity;
    }

    String myCity = "";

    public String getMyCityAddress() {
        return myCityAddress;
    }

    public void setMyCityAddress(String myCityAddress) {
        this.myCityAddress = myCityAddress;
    }

    String myCityAddress = "";

    public String getMyIcon() {
        return myIcon;
    }

    public void setMyIcon(String myIcon) {
        this.myIcon = myIcon;
    }

    String myIcon = "";


    private ArrayList<WeatherForecast> myWeatherDetails;

    public ArrayList<WeatherForecast> getMyWeatherDetails() {
        return myWeatherDetails;
    }

    public void setMyWeatherDetails(ArrayList<WeatherForecast> myWeatherDetails) {
        this.myWeatherDetails = myWeatherDetails;
    }


    //To set Values for location

    public ArrayList<WeatherForecast> getMyFirstLocation() {
        return myFirstLocation;
    }

    public void setMyFirstLocation(ArrayList<WeatherForecast> myFirstLocation) {
        this.myFirstLocation = myFirstLocation;
    }

    private ArrayList<WeatherForecast> myFirstLocation;

    public ArrayList<WeatherForecast> getMySecondLocation() {
        return mySecondLocation;
    }

    public void setMySecondLocation(ArrayList<WeatherForecast> mySecondLocation) {
        this.mySecondLocation = mySecondLocation;
    }

    private ArrayList<WeatherForecast> mySecondLocation;

    public ArrayList<WeatherForecast> getMyThirdLocation() {
        return myThirdLocation;
    }

    public void setMyThirdLocation(ArrayList<WeatherForecast> myThirdLocation) {
        this.myThirdLocation = myThirdLocation;
    }

    private ArrayList<WeatherForecast> myThirdLocation;


}
