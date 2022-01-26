package org.pgr112.lesson9b;

class Healer{
    private String heal = "Restores for 100hp";
    public void heal(){
        System.out.println(">> Heal " + heal);
    }

    //Getter & Setter
    public String getHeal() {
        return heal;
    }
    public void setHeal(String heal) {
        this.heal = heal;
    }
}

class Paladin extends Healer{
    public void heal(){
        setHeal(" Restores for 60hp");
        System.out.println(">> Flash of Light " + getHeal());
    }
}

class Priest extends Healer{
    public void heal(){
        System.out.println(">> Flash Heal" + getHeal());
    }
}
class Druid extends Healer{
    //Inherits Heal by default
}
