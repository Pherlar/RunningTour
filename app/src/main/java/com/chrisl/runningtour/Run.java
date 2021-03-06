package com.chrisl.runningtour;

//class to handle the Run object which holds all the attributes and data
//of each run in the app
public class Run
{

    private String mRunName;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mImageResourceID = NO_IMAGE_PROVIDED;
    private String mNavigationString;
    private double mRunDistance;
    private String mRunType;

    //Create new Run Object
    public Run(String runName, double runDistance, int imageResourceID, String runType ,String navigationString)
    {
        mRunName = runName;
        mRunDistance = runDistance;
        mImageResourceID = imageResourceID;
        mRunType = runType;
        mNavigationString = navigationString;
    }
//public getter methods
    public String getRunName(){return mRunName;}

    public double getRunDistance(){return mRunDistance;}

    public int getImageResourceID(){return mImageResourceID;}

    public String getNavigationString(){return mNavigationString;}

    public String getRunType(){return  mRunType;}



}
