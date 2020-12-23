package com.github.francomiranda19.finalreality.gui;

import com.github.francomiranda19.finalreality.controller.GameController;
import com.github.francomiranda19.finalreality.model.character.ICharacter;
import com.github.francomiranda19.finalreality.model.character.IEnemy;
import com.github.francomiranda19.finalreality.model.character.player.IPlayerCharacter;
import com.github.francomiranda19.finalreality.model.weapon.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Main entry point for the application.
 * <p>
 * The player is able to attack enemies and change weapons.
 * The enemies will attack automatically a random player character.
 * It will be shown when a character is in turn a when the game is over.
 *
 * @author Ignacio Slater Muñoz.
 * @author Franco Miranda Oyarzún
 */
public class FinalReality extends Application {
  private static final String RESOURCE_PATH = "src/main/resources/";

  private final GameController controller = new GameController();
  private final Group root = new Group();

  private Label nameLabel;
  private Label currentLifeLabel;
  private Label defenseLabel;
  private Label equippedWeaponLabel;
  private Label attackLabel;
  private Label stateLabel;
  private Label playerCharactersLabel;
  private Label enemiesLabel;
  private Label weaponsLabel;

  private Label turnLabel;
  private Label weaponLabel;

  private Label attackEnemiesLabel;
  private Label superWeaponsLabel;
  private Label megaWeaponsLabel;

  private Label gameOverLabel;

  private Button equipSuperAxe;
  private Button equipSuperBow;
  private Button equipSuperKnife;
  private Button equipSuperStaff;
  private Button equipSuperSword;
  private Button equipMegaAxe;
  private Button equipMegaBow;
  private Button equipMegaKnife;
  private Button equipMegaStaff;
  private Button equipMegaSword;

  private Button attackEnemy1;
  private Button attackEnemy2;
  private Button attackEnemy3;
  private Button attackEnemy4;
  private Button attackEnemy5;

  private IPlayerCharacter blackMage;
  private IPlayerCharacter engineer;
  private IPlayerCharacter knight;
  private IPlayerCharacter thief;
  private IPlayerCharacter whiteMage;

  private IEnemy enemy1;
  private IEnemy enemy2;
  private IEnemy enemy3;
  private IEnemy enemy4;
  private IEnemy enemy5;

  private IWeapon superAxe;
  private IWeapon superBow;
  private IWeapon superKnife;
  private IWeapon superStaff;
  private IWeapon superSword;
  private IWeapon megaAxe;
  private IWeapon megaBow;
  private IWeapon megaKnife;
  private IWeapon megaStaff;
  private IWeapon megaSword;

  public static void main(String[] args) {
    launch(args);
  }

  /**
   * Shows the application to the user.
   * The user can interact with it.
   * @param primaryStage stage of the application
   * @throws FileNotFoundException when an image is not found
   */
  @Override
  public void start(@NotNull Stage primaryStage) throws FileNotFoundException {
    primaryStage.setTitle("Final Reality");
    primaryStage.setResizable(false);
    Scene scene = createScene();
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void initializeCharactersAndWeapons() {
    superAxe = controller.createAxe("Super Axe", 25, 4);
    superBow = controller.createBow("Super Bow", 20, 3);
    superKnife = controller.createKnife("Super Knife", 30, 5);
    superStaff = controller.createStaff("Super Staff", 10, 1, 30);
    superSword = controller.createSword("Super Sword", 15, 2);

    megaAxe = controller.createAxe("Mega Axe", 35, 2);
    megaBow = controller.createBow("Mega Bow", 10, 1);
    megaKnife = controller.createKnife("Mega Knife", 20, 1);
    megaStaff = controller.createStaff("Mega Staff", 25, 2, 25);
    megaSword = controller.createSword("Mega Sword", 30, 3);

    blackMage = controller.createBlackMage("CJ", 100, 5, 10, superKnife);
    engineer = controller.createEngineer("Leon", 120, 10, superAxe);
    knight = controller.createKnight("Mario", 75, 20, superSword);
    thief = controller.createThief("Crash", 90, 10, superBow);
    whiteMage = controller.createWhiteMage("Homer", 150, 1, 50, superStaff);

    enemy1 = controller.createEnemy("Big Smoke", 3, 100, 10, 20);
    enemy2 = controller.createEnemy("Nemesis", 2, 120, 10, 15);
    enemy3 = controller.createEnemy("Bowser", 3, 90, 15, 25);
    enemy4 = controller.createEnemy("Neo Cortex Doctor", 4, 150, 5, 20);
    enemy5 = controller.createEnemy("Mr. Burns", 5, 75, 15, 25);
  }

  private void quantityLabels(int x, int y) {
    playerCharactersLabel = createLabel(x, y);
    enemiesLabel = createLabel(x, y + 15);
    weaponsLabel = createLabel(x, y + 30);
  }

  private void dataLabels(int x, int y) {
    nameLabel = createLabel(x, y);
    currentLifeLabel = createLabel(x, y + 15);
    defenseLabel = createLabel(x, y + 30);
    attackLabel = createLabel(x, y + 45);
    equippedWeaponLabel = createLabel(x, y + 60);
  }

  private @NotNull Scene createScene() throws FileNotFoundException {
    initializeCharactersAndWeapons();
    Scene scene = new Scene(root, 600, 600);

    dataLabels(10, 0);
    stateLabel = createLabel(250, 0);
    quantityLabels(460, 0);

    turnLabel = createLabel(315, 280);
    weaponLabel = createLabel(265, 295);

    gameOverLabel = createLabel(265, 320);

    superWeaponsLabel = createLabel(20, 80);
    superWeaponsLabel.setText("Super Weapons");
    equipSuperAxeButton(10, 100);
    equipSuperBowButton(10, 195);
    equipSuperKnifeButton(10, 290);
    equipSuperStaffButton(10, 385);
    equipSuperSwordButton(10, 480);

    megaWeaponsLabel = createLabel(140, 80);
    megaWeaponsLabel.setText("Mega Weapons");
    equipMegaAxeButton(130, 100);
    equipMegaBowButton(130, 195);
    equipMegaKnifeButton(130, 290);
    equipMegaStaffButton(130, 385);
    equipMegaSwordButton(130, 480);

    attackEnemiesLabel = createLabel(495, 80);
    attackEnemiesLabel.setText("Enemies");
    attackEnemy1Button(465, 100);
    attackEnemy2Button(465, 195);
    attackEnemy3Button(470, 290);
    attackEnemy4Button(440, 385);
    attackEnemy5Button(465, 480);

    enemiesImages();
    superWeaponsImages();
    megaWeaponsImages();

    startAnimator();
    return scene;
  }

  private void startAnimator() {
    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(final long now) {
        gameOverLabel.setVisible(false);

        int playerCharactersAlive = controller.getPartySize();
        int enemiesAlive = controller.getEnemiesSize();
        int weaponsAvailable = controller.getInventorySize();
        playerCharactersLabel.setText("Player characters alive: " + playerCharactersAlive);
        enemiesLabel.setText("Enemies alive: " + enemiesAlive);
        weaponsLabel.setText("Weapons available: " + weaponsAvailable);

        ICharacter character = controller.getTurnsQueue().peek();
        String currentCharacterName = controller.getCharacterName(character);
        turnLabel.setText("Now it's " + currentCharacterName + "'s turn!");

        int currentCharacterLife = controller.getLife(character);
        int currentCharacterDefense = controller.getDefense(character);
        int currentCharacterAttack = controller.getAttack(character);
        nameLabel.setText("Current character name: " + currentCharacterName);
        currentLifeLabel.setText("Current character life: " + currentCharacterLife);
        defenseLabel.setText("Current character defense: " + currentCharacterDefense);
        attackLabel.setText("Current character attack: " + currentCharacterAttack);

        String currentState = controller.getStateName();
        stateLabel.setText("Current state: " + currentState);

        if (controller.getParty().contains(character)) {
          int damage = controller.getAttack(character);
          weaponLabel.setText(currentCharacterName + " has a weapon with " + damage + " damage");
          weaponLabel.setVisible(true);

          String currentEquippedWeapon = controller.getWeaponName(controller.getEquippedWeapon((IPlayerCharacter) character));
          equippedWeaponLabel.setText("Equipped weapon: " + currentEquippedWeapon);
          equippedWeaponLabel.setVisible(true);
        } else {
          weaponLabel.setVisible(false);
          equippedWeaponLabel.setVisible(false);

          controller.tryToAttack((IEnemy) character);
        }

        if (controller.enemiesIsEmpty()) {
          gameOverLabel.setVisible(true);
          gameOverLabel.setText("GAME OVER! YOU HAVE WON :D");
        } else if (controller.partyIsEmpty()) {
          gameOverLabel.setVisible(true);
          gameOverLabel.setText("GAME OVER! You lost :c");
        }
      }
    };
    timer.start();
  }

  private void image(String name, int x, int y, double scale) throws FileNotFoundException {
    var image = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + name)));
    image.setScaleX(scale);
    image.setScaleY(scale);
    image.setX(x);
    image.setY(y);
    root.getChildren().add(image);
  }

  private void enemiesImages() throws FileNotFoundException {
    image("enemy1.jpg", 305, -65, 0.14);
    image("enemy2.jpg", 425, 175, 0.4);
    image("enemy3.png", 260, 135, 0.15);
    image("enemy4.jpg", 405, 355, 0.34);
    image("enemy5.jpg", 325, 370, 0.2);
  }

  private void superWeaponsImages() throws FileNotFoundException {
    image("superAxe.png", -140, -105, 0.12);
    image("superBow.png", -140, -42, 0.14);
    image("superKnife.png", -220, 135, 0.15);
    image("superStaff.png", -60, 309, 0.25);
    image("superSword.png", -230, 335, 0.15);
  }

  private void megaWeaponsImages() throws FileNotFoundException {
    image("megaAxe.png", -70, -90, 0.14);
    image("megaBow.png", 40, 17, 0.14);
    image("megaKnife.png", -110, 180, 0.2);
    image("megaStaff.png", -30, 155, 0.11);
    image("megaSword.png", -70, 302, 0.15);
  }

  private void equipSuperAxeButton(int x, int y) {
    equipSuperAxe = new Button("Equip Super Axe");
    equipSuperAxe.setLayoutX(x);
    equipSuperAxe.setLayoutY(y);
    equipSuperAxe.setOnAction(event -> controller.tryToEquip(superAxe));
    root.getChildren().add(equipSuperAxe);
  }

  private void equipSuperBowButton(int x, int y) {
    equipSuperBow = new Button("Equip Super Bow");
    equipSuperBow.setLayoutX(x);
    equipSuperBow.setLayoutY(y);
    equipSuperBow.setOnAction(event -> controller.tryToEquip(superBow));
    root.getChildren().add(equipSuperBow);
  }

  private void equipSuperKnifeButton(int x, int y) {
    equipSuperKnife = new Button("Equip Super Knife");
    equipSuperKnife.setLayoutX(x);
    equipSuperKnife.setLayoutY(y);
    equipSuperKnife.setOnAction(event -> controller.tryToEquip(superKnife));
    root.getChildren().add(equipSuperKnife);
  }

  private void equipSuperStaffButton(int x, int y) {
    equipSuperStaff = new Button("Equip Super Staff");
    equipSuperStaff.setLayoutX(x);
    equipSuperStaff.setLayoutY(y);
    equipSuperStaff.setOnAction(event -> controller.tryToEquip(superStaff));
    root.getChildren().add(equipSuperStaff);
  }

  private void equipSuperSwordButton(int x, int y) {
    equipSuperSword = new Button("Equip Super Sword");
    equipSuperSword.setLayoutX(x);
    equipSuperSword.setLayoutY(y);
    equipSuperSword.setOnAction(event -> controller.tryToEquip(superSword));
    root.getChildren().add(equipSuperSword);
  }

  private void equipMegaAxeButton(int x, int y) {
    equipMegaAxe = new Button("Equip Mega Axe");
    equipMegaAxe.setLayoutX(x);
    equipMegaAxe.setLayoutY(y);
    equipMegaAxe.setOnAction(event -> controller.tryToEquip(megaAxe));
    root.getChildren().add(equipMegaAxe);
  }

  private void equipMegaBowButton(int x, int y) {
    equipMegaBow = new Button("Equip Mega Bow");
    equipMegaBow.setLayoutX(x);
    equipMegaBow.setLayoutY(y);
    equipMegaBow.setOnAction(event -> controller.tryToEquip(megaBow));
    root.getChildren().add(equipMegaBow);
  }

  private void equipMegaKnifeButton(int x, int y) {
    equipMegaKnife = new Button("Equip Mega Knife");
    equipMegaKnife.setLayoutX(x);
    equipMegaKnife.setLayoutY(y);
    equipMegaKnife.setOnAction(event -> controller.tryToEquip(megaKnife));
    root.getChildren().add(equipMegaKnife);
  }

  private void equipMegaStaffButton(int x, int y) {
    equipMegaStaff = new Button("Equip Mega Staff");
    equipMegaStaff.setLayoutX(x);
    equipMegaStaff.setLayoutY(y);
    equipMegaStaff.setOnAction(event -> controller.tryToEquip(megaStaff));
    root.getChildren().add(equipMegaStaff);
  }

  private void equipMegaSwordButton(int x, int y) {
    equipMegaSword = new Button("Equip Mega Sword");
    equipMegaSword.setLayoutX(x);
    equipMegaSword.setLayoutY(y);
    equipMegaSword.setOnAction(event -> controller.tryToEquip(megaSword));
    root.getChildren().add(equipMegaSword);
  }

  private void attackEnemy1Button(int x, int y) {
    attackEnemy1 = new Button("Attack " + controller.getCharacterName(enemy1));
    attackEnemy1.setLayoutX(x);
    attackEnemy1.setLayoutY(y);
    attackEnemy1.setOnAction(event -> controller.tryToAttack(enemy1));
    root.getChildren().add(attackEnemy1);
  }

  private void attackEnemy2Button(int x, int y) {
    attackEnemy2 = new Button("Attack " + controller.getCharacterName(enemy2));
    attackEnemy2.setLayoutX(x);
    attackEnemy2.setLayoutY(y);
    attackEnemy2.setOnAction(event -> controller.tryToAttack(enemy2));
    root.getChildren().add(attackEnemy2);
  }

  private void attackEnemy3Button(int x, int y) {
    attackEnemy3 = new Button("Attack " + controller.getCharacterName(enemy3));
    attackEnemy3.setLayoutX(x);
    attackEnemy3.setLayoutY(y);
    attackEnemy3.setOnAction(event -> controller.tryToAttack(enemy3));
    root.getChildren().add(attackEnemy3);
  }

  private void attackEnemy4Button(int x, int y) {
    attackEnemy4 = new Button("Attack " + controller.getCharacterName(enemy4));
    attackEnemy4.setLayoutX(x);
    attackEnemy4.setLayoutY(y);
    attackEnemy4.setOnAction(event -> controller.tryToAttack(enemy4));
    root.getChildren().add(attackEnemy4);
  }

  private void attackEnemy5Button(int x, int y) {
    attackEnemy5 = new Button("Attack " + controller.getCharacterName(enemy5));
    attackEnemy5.setLayoutX(x);
    attackEnemy5.setLayoutY(y);
    attackEnemy5.setOnAction(event -> controller.tryToAttack(enemy5));
    root.getChildren().add(attackEnemy5);
  }

  private @NotNull Label createLabel(int x, int y) {
    Label label = new Label();
    label.setLayoutX(x);
    label.setLayoutY(y);
    root.getChildren().add(label);
    return label;
  }
}