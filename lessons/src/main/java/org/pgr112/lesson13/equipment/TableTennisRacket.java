package org.pgr112.lesson13.equipment;

public class TableTennisRacket extends Equipment {

    private boolean newFace;
    public TableTennisRacket(int id){
        super(id);
        this.newFace = false;
    }

    public boolean needsNewFace() {
        return newFace;
    }

    public void setNewFace(boolean newFace) {
        this.newFace = newFace;
    }
}
