package logic.attack;

import logic.monster.Monster;

public class SPAttack extends Attack {
    public SPAttack(int power, String name, boolean isLeader) {
        super(power, name, isLeader);
    }

    public int calculateDamage(Monster target) {
        int damage = getPower() - target.getSpecialDefense();
        if (damage < 0) {
            return 0;
        } else {
            return damage;
        }
    }
}
