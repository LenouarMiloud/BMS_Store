package com.example.bms_store;

import android.os.Parcel;
import android.os.Parcelable;

public class ResdelerView implements Parcelable {

    String FamilyName;
    String FirstName;
    String Adress;
    String PhoneNumber;
    String Description;

    public ResdelerView(String familyName, String firstName, String adress, String phoneNumber, String description) {
        FamilyName = familyName;
        FirstName = firstName;
        Adress = adress;
        PhoneNumber = phoneNumber;
        Description = description;
    }

    public String getFamilyName() {
        return FamilyName;
    }

    public void setFamilyName(String familyName) {
        FamilyName = familyName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    protected ResdelerView(Parcel in){
        FamilyName = in.readString();
        FirstName = in.readString();
        Adress = in.readString();
        PhoneNumber = in.readString();
        Description = in.readString();
    }

    public static final Creator<ResdelerView> CREATOR = new Creator<ResdelerView>() {
        @Override
        public ResdelerView createFromParcel(Parcel in) {
            return new ResdelerView(in);
        }

        @Override
        public ResdelerView[] newArray(int size) {
            return new ResdelerView[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(FamilyName);
        dest.writeString(FirstName);
        dest.writeString(Adress);
        dest.writeString(PhoneNumber);
        dest.writeString(Description);
    }
}
