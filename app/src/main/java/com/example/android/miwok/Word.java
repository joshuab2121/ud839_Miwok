package com.example.android.miwok;

class Word {
    /** Default translation for the word */
    private String mDefaultTranslation;

    /** Miwok translation for the word */
    private String mMiwokTranslation;

    /** Image resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value to represent that no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    /** Audio resource ID for the word */
    private int mAudioResourceId;

    public Word(String mDefaultTranslation, String mMiwokTranslation, int mAudioResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mAudioResourceId = mAudioResourceId;
    }

    public Word(String mDefaultTranslation, String mMiwokTranslation, int imageResourceId, int mAudioResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mImageResourceId = imageResourceId;
        this.mAudioResourceId = mAudioResourceId;
    }

    /** @return the default translation of the word */
    String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /** @return the miwok translation of the word */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /** @return the image resource ID of the word */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /** @return whether or not there is an image for this word */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /** @return return the audio resource ID of the word */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}


