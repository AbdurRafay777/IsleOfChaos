package com.mycompany.isleofchaos;

public class HeroInitializer {

    private static HeroInitializer heroInitializer;

    private HeroInitializer() {

    }

    static HeroInitializer getInstance() {
        if(heroInitializer == null)
            heroInitializer = new HeroInitializer();
        return heroInitializer;
    }

    Character getHero(String s) {
        if(s.equals("Warrior"))
            return initWarrior();
        else if (s.equals("Sorcerer"))
            return  initSorcerer();
        else if(s.equals("Assassin"))
            return  initAssassin();
        else if(s.equals("Templar"))
            return initTemplar();
        return null;
    }

    private Hero initWarrior() {
        Hero h = new Hero("Warrior", "Human", "slash", "fire", 2500, 200, 30, 50, 10);

        Skill s1 = new PhysicalAttack(h, "Tempest Slash", "SingleTarget", "Heavy Slash Damage to one foe",  20,"slash", 3);
        Skill s2 = new PhysicalAttack(h, "Earthshaker", "AllTarget", "Medium Strike Damage to all foes", 20, "strike", 2);
        Skill s3 = new DefenseBuff(h, "Stalwart Defense", "SingleTarget", "Buff Defense of oneself", 10, 50);

        h.addSkill(s1);
        h.addSkill(s2);
        h.addSkill(s3);

        return h;
    }

    private Hero initTemplar() {
        Hero h = new Hero("Templar", "Human", "strike", "electric", 1500, 200, 20, 20, 10);

        Skill s1 = new Heal(h, "Life Regen", "SingleTarget", "Heals one ally", 20, 200 );
        Skill s2 = new RestoreMP(h, "Mana Charge", "SingleTarget", "Restore MP of one ally", 50, 50 );
        Skill s3 = new AttackBuff(h, "Power Surge", "SingleTarget", "Buff Attack of one ally", 40, 10);
        Skill s4 = new DefenseBuff(h, "Divine Defense", "SingleTarget", "Buff Defense of one ally", 40, 10);

        h.addSkill(s1);
        h.addSkill(s2);
        h.addSkill(s3);
        h.addSkill(s4);

        return h;
    }

    private Hero initAssassin() {
        Hero h = new Hero("Assassin", "Human", "", "ice", 1000, 250, 50, 50, 10);

        Skill s1 = new PhysicalAttack(h, "Twin Fangs", "SingleTarget", "Medium Slash Damage to one foe", 30, "slash", 3);
        Skill s2 = new PhysicalAttack(h, "Blade Shower", "AllTarget", "Low Slash Damage to all Enemies", 30, "slash", 2);
        Skill s3 = new LifeSteal(h, "Vampire Knives", "SingleTarget", "Steal health from one Enemy", 30, 2);


        h.addSkill(s1);
        h.addSkill(s2);
        h.addSkill(s3);

        return h;

    }

    private Hero initSorcerer() {
            Hero h = new Hero("Sorcerer", "Elf", "slash", "dark", 750, 400, 40, 20, 20);

            Skill s1 = new MagicalAttack(h,"Holy Arrow", "SingleTarget", "Heavy Light Damage to one foe", 40, "light", 4);
            Skill s2 = new MagicalAttack(h, "Glacial Impact", "AllTarget", "Medium Ice Damage to all foes", 40, "ice", 2);
            Skill s3 = new MagicalAttack(h, "Flamewall", "SingleTarget", "Medium Fire Damage to one foe", 30, "fire", 3);
            Skill s4 = new MagicalAttack(h, "Plasma Grenade", "AllTarget", "Heavy Lightning Damage to all foes", 60, "electric", 6);

            h.addSkill(s1);
            h.addSkill(s2);
            h.addSkill(s3);
            h.addSkill(s4);

            return h;
    }
}
