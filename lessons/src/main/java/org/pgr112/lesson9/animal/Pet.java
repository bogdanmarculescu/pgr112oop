package org.pgr112.lesson9.animal;

public interface Pet {
    /***
     * This method will provide info...
     * @return true if indoor pet. False otherwise.
     */
    boolean isIndoorPet();

    String getChipId();

    void setVeterinarian(String vetId);

}
