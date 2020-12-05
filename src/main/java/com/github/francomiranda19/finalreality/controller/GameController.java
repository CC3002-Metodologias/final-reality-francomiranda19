package com.github.francomiranda19.finalreality.controller;

import com.github.francomiranda19.finalreality.model.character.Enemy;
import com.github.francomiranda19.finalreality.model.character.ICharacter;
import com.github.francomiranda19.finalreality.model.character.IEnemy;
import com.github.francomiranda19.finalreality.model.character.player.IPlayerCharacter;
import com.github.francomiranda19.finalreality.model.character.player.classes.*;
import com.github.francomiranda19.finalreality.model.weapon.*;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * A class that holds all the information of the game controller.
 *
 * @author Franco Miranda Oyarzún
 */
public class GameController {

  private final BlockingQueue<ICharacter> turnsQueue;
  private final List<IPlayerCharacter> party;
  private final List<IEnemy> enemies;
  private final List<IWeapon> inventory;

  private final IEventHandler characterEndsTurnHandler;
  private final IEventHandler enemyEndsTurnHandler;

  /**
   * Creates a game controller.
   */
  public GameController() {
    turnsQueue = new LinkedBlockingQueue<>();
    party = new ArrayList<>();
    enemies = new ArrayList<>();
    inventory = new ArrayList<>();

    characterEndsTurnHandler = new CharacterEndsTurnHandler(this);
    enemyEndsTurnHandler = new EnemyEndsTurnHandler(this);
  }

  /**
   * Creates a black mage
   * @param name of the black mage
   * @param maxLife of the black mage
   * @param defense of the black mage
   * @param mana of the black mage
   */
  public IPlayerCharacter createBlackMage(String name, int maxLife, int defense, int mana) {
    IPlayerCharacter blackMage = new BlackMage(name, turnsQueue, maxLife, defense, mana);
    blackMage.addListener(characterEndsTurnHandler);
    party.add(blackMage);
    blackMage.waitTurn();
    return blackMage;
  }

  /**
   * Creates an engineer
   * @param name of the engineer
   * @param maxLife of the engineer
   * @param defense of the engineer
   */
  public IPlayerCharacter createEngineer(String name, int maxLife, int defense) {
    IPlayerCharacter engineer = new Engineer(name, turnsQueue, maxLife, defense);
    engineer.addListener(characterEndsTurnHandler);
    party.add(engineer);
    engineer.waitTurn();
    return engineer;
  }

  /**
   * Creates a knight
   * @param name of the knight
   * @param maxLife of the knight
   * @param defense of the knight
   */
  public IPlayerCharacter createKnight(String name, int maxLife, int defense) {
    IPlayerCharacter knight = new Knight(name, turnsQueue, maxLife, defense);
    knight.addListener(characterEndsTurnHandler);
    party.add(knight);
    knight.waitTurn();
    return knight;
  }

  /**
   * Creates a thief
   * @param name of the thief
   * @param maxLife of the thief
   * @param defense of the thief
   */
  public IPlayerCharacter createThief(String name, int maxLife, int defense) {
    IPlayerCharacter thief = new Thief(name, turnsQueue, maxLife, defense);
    thief.addListener(characterEndsTurnHandler);
    party.add(thief);
    thief.waitTurn();
    return thief;
  }

  /**
   * Creates a white mage
   * @param name of the white mage
   * @param maxLife of the white mage
   * @param defense of the white mage
   * @param mana of the white mage
   */
  public IPlayerCharacter createWhiteMage(String name, int maxLife, int defense, int mana) {
    IPlayerCharacter whiteMage = new WhiteMage(name, turnsQueue, maxLife, defense, mana);
    whiteMage.addListener(characterEndsTurnHandler);
    party.add(whiteMage);
    whiteMage.waitTurn();
    return whiteMage;
  }

  /**
   * Creates an enemy
   * @param name of the enemy
   * @param weight of the enemy
   * @param maxLife of the enemy
   * @param defense of the enemy
   * @param attack of the enemy
   */
  public IEnemy createEnemy(String name, int weight, int maxLife, int defense, int attack) {
    IEnemy enemy = new Enemy(name, weight, turnsQueue, maxLife, defense, attack);
    if (getEnemiesSize() < 5) {
      enemy.addListener(enemyEndsTurnHandler);
      enemies.add(enemy);
      enemy.waitTurn();
    }
    return enemy;
  }

  /**
   * Creates an axe
   * @param name of the axe
   * @param damage of the axe
   * @param weight of the axe
   */
  public IWeapon createAxe(String name, int damage, int weight) {
    IWeapon axe = new Axe(name, damage, weight);
    inventory.add(axe);
    return axe;
  }

  /**
   * Creates a bow
   * @param name of the bow
   * @param damage of the bow
   * @param weight of the bow
   */
  public IWeapon createBow(String name, int damage, int weight) {
    IWeapon bow = new Bow(name, damage, weight);
    inventory.add(bow);
    return bow;
  }

  /**
   * Creates a knife
   * @param name of the knife
   * @param damage of the knife
   * @param weight of the knife
   */
  public IWeapon createKnife(String name, int damage, int weight) {
    IWeapon knife = new Knife(name, damage, weight);
    inventory.add(knife);
    return knife;
  }

  /**
   * Creates a staff
   * @param name of the staff
   * @param damage of the staff
   * @param weight of the staff
   * @param magicDamage of the staff
   */
  public IWeapon createStaff(String name, int damage, int weight, int magicDamage) {
    IWeapon staff = new Staff(name, damage, weight, magicDamage);
    inventory.add(staff);
    return staff;
  }

  /**
   * Creates a sword
   * @param name of the sword
   * @param damage of the sword
   * @param weight of the sword
   */
  public IWeapon createSword(String name, int damage, int weight) {
    IWeapon sword = new Sword(name, damage, weight);
    inventory.add(sword);
    return sword;
  }

  /**
   * Returns all the available player characters.
   */
  public List<IPlayerCharacter> getParty() {
    return party;
  }

  /**
   * Returns all the available enemies.
   */
  public List<IEnemy> getEnemies() {
    return enemies;
  }

  /**
   * Cheks if a character is an available character
   * @param character to be checked
   */
  public boolean isAValidCharacter(ICharacter character) {
    return party.contains(character) || enemies.contains(character);
  }

  /**
   * Returns the number of available player characters
   */
  public int getPartySize() {
    return party.size();
  }

  /**
   * Returns the number of available enemies
   */
  public int getEnemiesSize() {
    return enemies.size();
  }

  /**
   * Returns true if there are no available player characters
   */
  public boolean partyIsEmpty() {
    return party.isEmpty();
  }

  /**
   * Returns true if there are no available enemies
   */
  public boolean enemiesIsEmpty() {
    return enemies.isEmpty();
  }

  /**
   * Returns a character name
   * null if the character is not valid
   * @param character who's name is wanted
   */
  public String getCharacterName(ICharacter character) {
    if (isAValidCharacter(character)) {
      return character.getName();
    }
    return null;
  }

  /**
   * Returns a character current life
   * -1 if the character is not valid
   * @param character who's life is wanted
   */
  public int getLife(ICharacter character) {
    if (isAValidCharacter(character)) {
      return character.getCurrentLife();
    }
    return -1;
  }

  /**
   * Returns a character defense
   * -1 if the character is not valid
   * @param character who's defense is wanted
   */
  public int getDefense(ICharacter character) {
    if (isAValidCharacter(character)) {
      return character.getDefense();
    }
    return -1;
  }

  /**
   * Returns a character attack
   * -1 if the character is not valid
   * @param character who's attack is wanted
   */
  public int getAttack(ICharacter character) {
    if (isAValidCharacter(character)) {
      return character.getAttack();
    }
    return -1;
  }

  /**
   * Returns the equipped weapon of a player character
   * @param character who's equipped weapon is wanted
   */
  public IWeapon getEquippedWeapon(IPlayerCharacter character) {
    return character.getEquippedWeapon();
  }

  /**
   * Returns the weight of an enemy
   * -1 if the enemy is not valid
   * @param enemy who's weight is wanted
   */
  public int getEnemyWeight(IEnemy enemy) {
    if (isAValidCharacter(enemy)) {
      return enemy.getWeight();
    }
    return -1;
  }

  /**
   * True if the current life of a character is les or equal to 0
   * @param character to check if it is dead
   */
  public boolean isDead(ICharacter character) {
    return character.getCurrentLife() <= 0;
  }

  /**
   * Checks if a weapon is an available weapon
   * @param weapon to check weapon
   */
  public boolean isAValidWeapon(IWeapon weapon) {
    return inventory.contains(weapon);
  }

  /**
   * Returns the available weapons
   */
  public List<IWeapon> getInventory() {
    return inventory;
  }

  /**
   * Returns the number of available weapons
   */
  public int getInventorySize() {
    return inventory.size();
  }

  /**
   * Returns true if there are no available weapons
   */
  public boolean inventoryIsEmpty() {
    return inventory.isEmpty();
  }

  /**
   * Returns the name of a weapon
   * null if the weapon is not valid
   * @param weapon who's name is wanted
   */
  public String getWeaponName(IWeapon weapon) {
    if (isAValidWeapon(weapon)) {
      return weapon.getName();
    }
    return null;
  }

  /**
   * Returns the damage of a weapon
   * -1 if the weapon is not valid
   * @param weapon who's damage is wanted
   */
  public int getDamage(IWeapon weapon) {
    if (isAValidWeapon(weapon)) {
      return weapon.getDamage();
    }
    return -1;
  }

  /**
   * Returns the weight of a weapon
   * -1 if the weapon is not valid
   * @param weapon who's weight is wanted
   */
  public int getWeaponWeight(IWeapon weapon) {
    if (isAValidWeapon(weapon)) {
      return weapon.getWeight();
    }
    return -1;
  }

  /**
   * Equips a weapon to a character only if the character can equip the weapon.
   * If a character equips a weapon, that weapon will be removed from the inventory
   * and the previous equipped weapon will be added there.
   * @param weapon that is going to be equipped
   * @param character that will try to equip the weapon
   */
  public void equip(IWeapon weapon, IPlayerCharacter character) {
    IWeapon equippedWeapon = character.getEquippedWeapon();
    if (isAValidWeapon(weapon)) {
      character.equip(weapon);
      if (equippedWeapon != getEquippedWeapon(character)) {
        inventory.remove(weapon);
        if (equippedWeapon != null) {
          inventory.add(weapon);
        }
      }
    }
  }

  /**
   * A player character attacks an enemy
   * @param character attacker
   * @param enemy rival
   */
  public void characterAttack(IPlayerCharacter character, IEnemy enemy) {
    character.attack(enemy);
    character.waitTurn();
  }

  /**
   * An enemy attacks a player character
   * @param enemy attacker
   * @param character rival
   */
  public void enemyAttack(IEnemy enemy, IPlayerCharacter character) {
    enemy.attack(character);
    enemy.waitTurn();
  }

  public ICharacter nextTurn() {
    return turnsQueue.poll();
  }

  /**
   * Notifies when a player character's turn is over
   * @param character who's turn is over
   * @param enemy attacked by the character
   */
  public void characterTurnPlayed(IPlayerCharacter character, IEnemy enemy) {
    System.out.println(character.getName() + " turn is over.");
    if (isDead(enemy)) {
      enemyDeath(enemy);
    }
  }

  /**
   * Notifies when an enemy's turn is over
   * @param enemy who's turn is over
   * @param character attacked by the enemy
   */
  public void enemyTurnPlayed(IEnemy enemy, IPlayerCharacter character) {
    System.out.println(enemy.getName() + " turn is over.");
    if (isDead(character)) {
      characterDeath(character);
    }
  }

  /**
   * Notifies when a player character is dead
   * If there are no more player characters available, the player loses the game
   * @param character who's dead
   */
  public void characterDeath(IPlayerCharacter character) {
    System.out.println(character.getName() + " is dead!");
    party.remove(character);
    turnsQueue.remove(character);
    if (partyIsEmpty()) {
      System.out.println("You lost the game uwu");
    }
  }

  /**
   * Notifies when an enemy is dead
   * If there are no more enemies available, the player wins the game
   * @param enemy who's dead
   */
  public void enemyDeath(IEnemy enemy) {
    System.out.println(enemy.getName() + " is dead!");
    enemies.remove(enemy);
    turnsQueue.remove(enemy);
    if (enemiesIsEmpty()) {
      System.out.println("You won the game :D");
    }
  }

}
