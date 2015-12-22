package com.localhost.shobhitjain.songza;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by shobhitjain on 16/12/15.
 */
public class Song implements Parcelable {

    Long id;
    String title;
    Long playtime;
    String thumbnail;
    String fileName;
    String stream;
    String dl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPlaytime() {
        return playtime;
    }

    public void setPlaytime(Long playtime) {
        this.playtime = playtime;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getDl() {
        return dl;
    }

    public void setDl(String dl) {
        this.dl = dl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.title);
        dest.writeValue(this.playtime);
        dest.writeString(this.thumbnail);
        dest.writeString(this.fileName);
        dest.writeString(this.stream);
        dest.writeString(this.dl);
    }

    public Song() {
    }

    protected Song(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.title = in.readString();
        this.playtime = (Long) in.readValue(Long.class.getClassLoader());
        this.thumbnail = in.readString();
        this.fileName = in.readString();
        this.stream = in.readString();
        this.dl = in.readString();
    }

    public static final Parcelable.Creator<Song> CREATOR = new Parcelable.Creator<Song>() {
        public Song createFromParcel(Parcel source) {
            return new Song(source);
        }

        public Song[] newArray(int size) {
            return new Song[size];
        }
    };
}
