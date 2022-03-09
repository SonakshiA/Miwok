package com.example.android.miwok;

import android.media.Image;
import android.widget.ImageView;

public class Word {
    private String defaultTranslation;
    private String miwokTranslation;
    private int ImageResourceID = NO_IMAGE_PROVIDED;
    private int AudioResourceID;

    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String defaultTranslation, String miwokTranslation){
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
    }

    // multiple constructors

    public Word(String defaultTranslation, String miwokTranslation, int audioResourceID){
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.AudioResourceID = audioResourceID;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceID, int audioResourceID){
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.ImageResourceID = imageResourceID;
        this.AudioResourceID = audioResourceID;
    }

    public String getDefaultTranslation(){
        return this.defaultTranslation;
    }

    public String getMiwokTranslation(){
        return this.miwokTranslation;
    }

    public int getImageResourceId(){
        return this.ImageResourceID;
    }

    public int getAudioResourceID(){
        return this.AudioResourceID;
    }

    public boolean hasImage(){
        return this.ImageResourceID != NO_IMAGE_PROVIDED;
    }
}


/*
if there is no image, this.ImageResourceID is -1 and hasImage() returns False
which implies there is no image

 */
