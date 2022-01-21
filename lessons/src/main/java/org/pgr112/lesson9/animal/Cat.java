package org.pgr112.lesson9.animal;

public class Cat implements Animal, Pet{
    @Override
    public void animalSound() {
        System.out.println("It's mjau, isn't it? you want me to say mjau.");
    }

    @Override
    public void sleep() {
        System.out.println("ZZZzzzZZZzz");
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
