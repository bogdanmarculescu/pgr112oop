package org.pgr112.lesson12.exam2021.equipment;

public abstract class Equipment {
    private int equipId;
    private String location;
    private boolean replace;

    public Equipment(int id){
        this.equipId = id;
    }

    public int getEquipId() {
        return equipId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isReplace() {
        return replace;
    }

    public void setReplace(boolean replace) {
        this.replace = replace;
    }
}
