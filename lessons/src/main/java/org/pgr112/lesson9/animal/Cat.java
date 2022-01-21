package org.pgr112.lesson9.animal;

public class Cat implements Animal, Pet{
    @Override
    public void animalSound() {

    }

    @Override
    public void sleep() {

    }

    @Override
    public boolean isIndoorPet() {
        return false;
    }

    @Override
    public String getChipId() {
        return null;
    }

    @Override
    public void setVeterinarian(String vetId) {

    }

    public void beCatLike(){
        System.out.println("v1 - no args");
    }

    public void beCatLike(String string){
        System.out.println("v2 - string arg " + string);
    }

    public void beCatLike(int integerCat){
        System.out.println("v3 - int arg " + integerCat);
    }
}
