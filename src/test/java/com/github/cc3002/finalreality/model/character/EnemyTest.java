package com.github.cc3002.finalreality.model.character;

import com.github.francomiranda19.finalreality.model.character.Enemy;
import com.github.francomiranda19.finalreality.model.character.player.CharacterClass;
import com.github.francomiranda19.finalreality.model.character.player.PlayerCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnemyTest extends AbstractCharacterTest {

  private static final String ENEMY_NAME = "Goblin";
  private static final int LIFE = 100;
  private static final int DEFENSE = 30;
  private static final int ATTACK = 15;
  private Enemy enemy;

  @BeforeEach
  void setUp() {
    basicSetUp();

    enemy = new Enemy(ENEMY_NAME, 10, turns, LIFE, DEFENSE, ATTACK);
    testCharacters.add(new Enemy(ENEMY_NAME, 10, turns, LIFE, DEFENSE, ATTACK));
  }

  @Test
  void constructorTest() {
    checkConstruction(new Enemy(ENEMY_NAME, 10, turns, LIFE, DEFENSE, ATTACK),
        testCharacters.get(0),
        new Enemy(ENEMY_NAME, 11, turns, LIFE, DEFENSE, ATTACK),
        new PlayerCharacter(ENEMY_NAME, turns, CharacterClass.THIEF, LIFE, DEFENSE));
  }

  @Test
  void equalsHashTest() {
    assertEquals(enemy, enemy);
  }

  @Test
  void attackTest() {
    Enemy enemy = new Enemy(ENEMY_NAME, 10, turns, LIFE, DEFENSE, ATTACK);
    assertEquals(15, enemy.getAttack());
  }
}