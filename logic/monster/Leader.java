package logic.monster;

import logic.attack.Attack;

public class Leader extends Monster {
    private int maxChargeTurns;
    private int currentChargeTurns;
    private boolean isGuard;

    public Leader(String name, int hp, int def, int sp_def, Attack attack, int chargeTurns) {
        super(name, hp, def, sp_def, attack);
        setMaxChargeTurns(chargeTurns);
        setCurrentChargeTurns(0);
    }

    public int getMaxChargeTurns() {
        return maxChargeTurns;
    }

    public void setMaxChargeTurns(int maxChargeTurns) {
        this.maxChargeTurns = maxChargeTurns;
    }

    public int getCurrentChargeTurns() {
        return currentChargeTurns;
    }

    public void setCurrentChargeTurns(int currentChargeTurns) {
        if (currentChargeTurns < 0) {
            this.currentChargeTurns = 0;
        } else if (currentChargeTurns > getMaxChargeTurns()) {
            this.currentChargeTurns = maxChargeTurns;
        } else {
            this.currentChargeTurns = currentChargeTurns;
        }
    }

    public boolean isReady() {
        if (getCurrentChargeTurns() >= getMaxChargeTurns()) {
            return true;
        } else {
            return false;
        }
    }

    public int takeDamage(Attack attack) {
        int damage = attack.calculateDamage(this);
        if (isGuard) {
            return 0;
        } else {
            if (attack.isLeader()) {
                setHp(getHp() - damage);
            } else {
                setHp((int) (getHp() - Math.ceil(damage * 0.5)));
            }
            if (getHp() <= 0) {
                setDead(true);
            }
            return damage;
        }
    }

    public boolean isGuard() {
        return isGuard;
    }

    public void setGuard(boolean guard) {
        isGuard = guard;
    }


}
