package com.mycompany.isleofchaos;

public class Main {

    public static void main(String[] args) {
        Game game = Game.getInstance();
        EnemyInitializer EI = EnemyInitializer.getInstance();
        HeroInitializer HI = HeroInitializer.getInstance();

        Level level1 = new Level();
        level1.addToEnemyList(EI.getEnemy("Skeleton"));
        level1.addToEnemyList(EI.getEnemy("Hell Hound"));
        game.addLevel(level1);
        Level level2 = new Level();
        level2.addToEnemyList(EI.getEnemy("Black Knight"));
        level2.addToEnemyList(EI.getEnemy("Cultist"));
        game.addLevel(level2);
        Level level3 = new Level();
        level3.addToEnemyList(EI.getEnemy("Shadow Fiend"));
        game.addLevel(level3);

        Item hp_item = new HP_Item("HP Potion", 100, "Restores 100HP", 100);
        Item mp_item = new MP_Item("MP Potion", 200, "Restores 100MP", 100);
        Item attackBuff_item = new AttackBuff_Item("ATK Elixir", 200, "Increases STR by 10 points", 10);
        Item defenseBuff_item = new DefenseBuff_Item("DEF Elixir", 200, "Increases DEF by 10 points", 10);

        Shop shop = Shop.getInstance();
        shop.addItemToShop(hp_item);
        shop.addItemToShop(mp_item);
        shop.addItemToShop(attackBuff_item);
        shop.addItemToShop(defenseBuff_item);
        Game.getInstance().run();
    }
}
