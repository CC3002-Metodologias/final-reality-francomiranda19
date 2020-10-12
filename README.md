Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

---

For this game, I supposed that the player will never try to equip a weapon to a character that can't equip that weapon, also, only the Staff has the capacity to do magic damage, and only the mages can have Mana (In other words, other weapons will not have an atribute magicDamage = 0, or other characters will have mana = 0, because neither of them will have that atribute). Another thing I supposed is that the initial equipped weapon for a player character will be null, and the enemy's equipped weapon will always be null.

For the hierarchy of the characters, there is a public interface ICharacter and an abstract class AbstractCharacter that contain the methods for all the characters of the game, then, the classes PlayerCharacter and Enemy inherit from the AbstractClass, Enemy has it own attributes while PlayerCharacter is subdivided in every character of the game, Knight, Engineer, Thief, and an abstract class Abstract Mage which subclasses are BlackMage and WhiteMage, each of this characters has its own methods to equip weapon, method to know if two characters are equal, and the hash function. On the other hand, we have the relationship between the weapons of the game. First of all, there is a public interface IWeapon and the Weapon class, which is subdivided by every weapon of the game, Knife, Staff, Axe, Bow and Sword, as in the characters, each weapon has its own methods to get the damage, to know if two weapons are equal, and the hash function.
