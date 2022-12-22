package com.mycompany.isleofchaos;

public class EnemyInitializer {

    private static EnemyInitializer enemyInitializer;

    private EnemyInitializer() {

    }

    static EnemyInitializer getInstance() {
        if(enemyInitializer == null)
            enemyInitializer = new EnemyInitializer();
        return  enemyInitializer;
    }

    Enemy getEnemy(String s) {
        if(s.equals("Skeleton"))
            return initSkeleton();
        else if (s.equals("Bandit"))
            return  initBandit();
        else if(s.equals("Hell Hound"))
            return  initHellHound();
        else if(s.equals("Black Knight"))
            return initBlackKnight();
        else if(s.equals("Shadow Fiend"))
            return initShadowFiend();
        else if (s.equals("Cultist"))
            return initCultist();
        return null;
    }

    private Enemy initSkeleton() {
        Enemy e = new Enemy("Skeleton", "Undead", "strike", "", 100, 100, 20, 30, 10);
        Skill s = new EnemyPhysicalAttack(e, "Sword Swing", "SingleTarget", "Medium Physical Damage to one foe", 10, "slash", 1);
        e.setSkill(s);
        return e;
    }

    private Enemy initBandit() {
        Enemy e = new Enemy("Bandit", "Human", "slash", "fire", 200, 100, 45, 30, 20);
        Skill s = new EnemyMagicalAttack(e, "Frost Blade", "SingleTarget", "Medium Ice Damage to one foe", 10, "ice", 5);
        e.setSkill(s);
        return  e;
    }

    private Enemy initHellHound() {
        Enemy e = new Enemy("Hell Hound", "Demon", "", "ice", 500, 100, 50, 30, 20);
        Skill s = new EnemyMagicalAttack(e, "Fire Ball", "SingleTarget", "Medium Fire Damage to one foe", 10, "fire", 5);
        e.setSkill(s);
        return e;
    }

    private Enemy initBlackKnight() {
        Enemy e = new Enemy("Black Knight", "Possessed Armor", "strike", "electric", 4000, 2000, 50, 40, 10);
        Skill s = new EnemyPhysicalAttack(e, "Violent Whirlwind", "AllTarget", "High Slash Damage to all foes", 50, "slash", 4);
        e.setSkill(s);
        return e;
    }

    private Enemy initShadowFiend() {
        Enemy e = new Enemy("Shadow Fiend", "Cthonian", "strike", "light", 10000, 2000, 100, 20, 10);
        Skill s = new EnemyMagicalAttack(e, "Chaos Space", "AllTarget", "High Dark Damage to all foes", 50, "dark", 3);
        e.setSkill(s);
        return e;
    }

    private  Enemy initCultist() {
        Enemy e = new Enemy("Cultist", "Dark Elf", "slash", "", 4000, 2000, 150, 10, 10);
        Skill s = new EnemyMagicalAttack(e, "Sever Bolt", "SingleTarget", "High Lightning Damage to one foe", 50, "electric", 4);
        e.setSkill(s);
        return e;
    }


}
