package com.chrisl.runningtour;

public class Run
{

    private String mRunName;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mImageResourceID = NO_IMAGE_PROVIDED;
    private String mNavigationString;
    private double mRunDistance;

    //Create new Run Object
    public Run(String runName, double runDistance, int imageResourceID, String navigationString)
    {
        mRunName = runName;
        mRunDistance = runDistance;
        mImageResourceID = imageResourceID;
        mNavigationString = navigationString;
    }

    public String getRunName(){return mRunName;}

    public double getRunDistance(){return mRunDistance;}

    public int getImageResourceID(){return mImageResourceID;}

    public String getNavigationString(){return mNavigationString;}



}
