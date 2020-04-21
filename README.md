# Introduction
**Discord bot for playing table-top RPG online.**
Supports various dice-rolling, Savage Worlds initiative cards, bennies, tokens, and other RPG stuff.

## Patreon
In case you like this bot so much - you can support development via Patreon: https://www.patreon.com/savagebot

## Installation
Click on the following link and authorize bot on your server: https://discordapp.com/oauth2/authorize?&client_id=448952545784758303&scope=bot&permissions=0

To know whether the bot is alive:
```
!ping
```

If that exclamation mark is an issue (conflict with another bot?), you can change it with `prefix` command followed by a symbol to use as prefix from now on:
```
!prefix #
```

`invite` command let you get this bot invite link, to share it with friends for their server.
```
!invite
```

## Help & Syntax
All commands starts with`!`.
Most commands can have their name shortened to speed things up.

To get help from a discord channel, just type `help` command:
```
!help
```

---
# Savage Worlds Dice Rolls
Let's first see the simpliest rolls for Savage Worlds Extra and Wild Cards. But, in the [Avanced](#advanced) section below, we will see more complex rolls as well as rolls for other systems, including D20 initiative.

## Simple rolls
To roll a single die (no Acing), you can use the `roll` (or `r` for short) command, or even simply use the die as command `d4`, `d6`, `d8`, `d10` or `d12`.

For example, you need to know in which direction a grenade deviates?
```
!r d12
```
or for short:
```
!d12
```

**Tips:** 
* In fact, you can just roll any die `!d20`, `!d100`, even very weird ones `!d73` if you feel like it!
* You can also directly include modifiers (after or before the roll), for example, here is a human running roll `!6+d6`.

## Trait rolls
Traits roll do Ace (if the die hits its max, you roll another one and add it, until no more die aces).
Follow the die with an `!`.

For example, lets roll a Fighting d6 for a bandit extra:
```
!d6!
```
The result will directly display the sum of the dices. You won't see each individual ones. 
Here, on a d4, we got 4, then 2:
```
> d4!: 6 = 6
```

**Tips** You can directly add modifiers to the roll, like a -2 (dim light) penalty to Shooting `!d6!-2`, or Combat Reflexes adding +2 to recover from Shaken `!d8!+2`. Untrained would be `!d4!-2`.

## Wildcard Trait rolls
Wild Cards do roll a "Wild Die" (usually a d6) next to their Trait and keep the highest of both. Use `s4`

For example, let's have Player Character Huey rolls for Persuasion:
```
!s8
```

This will not only display the highest total to keep, but also individual rolls, so you know whether you got Snake Eyes, or if you hit Innocent Bystanders.
```
> s8: [5, w4] = 5(1)
```

The number in parenthesis in the end, if the number of successes against a Target Number of 4 (which is usually the case for Trait rolls). 0 would be a failure, 1 a simple success, 2 a success and a raise, and so on.
Here we have a nice roll with 2 raises:
```
> s8: [13; w2] = 13 (3)
```

Oops, Snake Eyes!
```
> s12: [1; w1] = 1
```

**Tips:** You can put descriptive text before the roll (it will return to next line after each roll).
```
Huey's Persuasion is !s8
```
And modifiers are also supported. Let's take a Wild Card untrained Trait roll: `!s4-2`.

## Damage rolls
Pretty simple, back to standard `d` syntax. Damage dice ace.

You can roll multiple dice and sum them up.
Here is a knife (Str+d4) wielding bandit with d6 strength:
```
!d6!+d4!
```
Here is a bow (2d6) wielding assassin:
```
!2d6!
```

**Tips:** You roll multiple separate rolls on the same line, and put texts around as you like.
```
The assassin shoots at Huey !s8 Damage: !2d6!+1 Bonus damage (if raise): !d6!
```
Will display:
```
> The assassin shoots at Huey s8: [1; w3] = 3
> Damage: 2d6!+1: 5 + 1 + 1 = 7
> Bonus damage (if raise): d6!: 1 = 1
```

---
# Savage Worlds Initiative

## Start a fight
To start a fight use the `fight` or `f` command:
```
!f
```
This shuffles deck and resets (clears) initiative tracker.

## Deal cards
To deal cards to one or more characters, use `di` followed by the characters' names. Those are not the discord names of the players, but really the character names or nicknames, and NPC names.
```
!di Huey Dewey Bandits Wolves
```
**Tips**: Remove spaces from their name (or they will be considered multiple characters). Keep the character names short, like one word, you might have to type them more than once.

## Quick, Level Headed, and Hesitant
For characters with such Edges/Hindrances, when dealing cards to them, follow their name with -q (for Quick), -l (for Level Headed), -i (for Improved Level Headed), or -h (for Hesistant).
```
!di Huey -q Dewey Bandits -h Assassin -i
```

**Tips**: When a player has Level Headed and Improved Level Headed, you only add `-i`.

## Tactician, Card for a Benny
If you need to deal a new card to a character, because of an Edge, or they spend a benny, or whatever reason, use `card` command.
```
!card Dewey
```

## Show Initiative
When you need to pick again at the initiative tracker, run the `init` command (init for initiative, not for initialize!) :
```
!init
```

## New Round
`round` let's you move into next round of combat. This will remove cards from the initiative tracker, shuffle the deck if a Joker was dealt on previous round. By default, all characters are also removed from the tracker. However, if you add `+` after the command, you keep the characters and deal them new cards (applying their edges if they had).
```
!rd +
```

## Add new characters
A new contendent joins the frey? Well, simply deal them a card with `di`.
```
!di Scrooge
```

## Remove characters
Someone is dead or fled? You made a typo in their name? Whenever you need to remove someone from the initiative tracker, use `drop` followed by the character names.
```
!drop Huey Bandits
```

Oh, you can also do that when you start a new round, by adding the character names prefixed by `-` to the `rd` command.
```
!rd + -Bandits
```

---
# Bennies
## Grant a Benny
To give a Benny to a player (or character), use the `!give` command.
```
!give Huey
```

To grant multiple Bennies at once, add the number of Bennies after the character name.
```
!give Huey 3
```

You can give Bennies to multiple persons at once, for example when a Joker is dealt.
This gives 2 to Huey, one to Louie, and 3 to Dewey.
```
!give Huey 2 Louie Dewey 3
```

## Spend a Benny
When a player wants to spend a Benny, the Game Master `take` it from them (or they take it away from themselves).
```
!take Huey
```

You can take away from multiple players, multiple Bennies in a single line.
```
!take Huey Louie 2 Dewey 2
```

## Who has what?
The `list`command lets you check how many Bennies each character has. (it also shows states, see [Managing character states](#states) below).
```
!list
```

Here is what the result looks like:
```
> NAME                TOKENS    STATES                             
> Huey                2                                            
> Dewey               4                                            
> Louie               2              
```

## New session
When you start a new session and want to reset all Bennies to default 3 (or more with Edges), first use the `clear` command to remove all remaining Bennies, and then, `give` each character what they deserve.

Here, our group with Huey, Louie, and Dewey, and Louie has the Luck Edge:
```
!clear
!give Huey 3 Louie 4 Dewey 3
```

## Removing characters
Once you gave a Benny to a character, it remains in the `list`, even if they reach 0 Benny. It's ok when it's a player, at some point they will regain some Benny, but for Wild Card NPCs, you might want to `remove` them from the list.
```
!remove Assassin
```

**Tips:** You can remove multiple characters at one: `!remove LordDenak GoblinWarlord EliteSentinel`

---
# Characters

## Add characters
Users often ask *how do I add players to my game?*. Well, you don't. Players (and characters) are automatically added if you deal them an initiative card, a Benny (or a state see [Managing character states](#states) below).

## Who is playing?
Use `list` to have the list of players/characters currently in the game. It shows their name, Bennies (tokens), and states.
```
!list
```

## Remove characters
Since the `list` holds players and characters, and since some characters might just have to leave (defeated, passing by npc, ...), you can `remove` characters:
```
!remove BigBadEvilBoss BigBagLieutnant
```

## Character Sheets
At the moment, Savage Bot does not manage Character Sheets. You can't roll `!persuasion` or `!fighting`.

Players or GMs usually keep the character sheets on paper in front of them, or use online sites such as [Savaged.us](http://savaged.us), or Virtual TableTop softwares with Character Sheets abilities. Whatever works for you. The simpler the better. Fast! Fun! Furious!

---
# States
In Savage Worlds, states are effects that affects a character for some time, like being Shaken, Distracted, or Vulnerable.

Savage Bot allows you to track the following states: Shaken, Stunned, Entangled, Bound, Distracted and Vulnerable.

## Apply State to Character
When a character is Shaken, or Entangled, or whatnot, use the `state` command to track it.
```
!state Huey +Vulnerable
```

**Tips:** You can use the shortened version of each state: Shaken → sha, Stunned → stn, Entangled → ent, Bound → bnd, Distracted → dis and Vulnerable → vul. You can also apply a state to multiple characters at once.
```
!state Huey +stn Dewey +dis Louie +bnd
```

## Remove State from Character
Use `state` again, with a minus sign.
```
!state Huey -vul
```

To remove all states from a character, add `clear` after their name. This removes all states from Huey:
```
!state Huey clear
```

**Tips:** You can apply and remove states to a single character at once. You omit the `+` sign, it is still considered a "add/apply". This adds Stunned and Distracted to Huey while also removing Distracted, add Distracted to Dewey but also adds Entangled, and clears everything from Louie. Yeah, we know some nasty GMs!
```
!state Huey +stunned -vul dis Dewey dis -ent Louie clear
```

## How Are You Doing?
Want to see if a character is Shaken or Distracted?
```
!list
> NAME                TOKENS    STATES                             
> Huey                1         STUNNED                            
> Assassin            2         DISTRACTED                         
> Dewey               1         SHAKEN                             
> Louie               3                                            
> Bandits             0                                    
```

---
# Advanced Savage Worlds

## Advanced Rolls

### Variable Target Number (Fighting vs Parry)
For rolls where the Target Number is not the standard 4, you can add a `t` parameter after the `s` savage roll.
For example, Huery attacks in melee a Parry 6 bandit:
```
Huey Fighting vs Bandit: !s10t6
```

The number of success and raises is calculated accordingly:
```
> Huey Fighting vs Bandit: s10t6: [9; w3] = 9 (1; TN: 6)
```

**Not yet:** You can't compare damage to toughness and read the number of wounds. `!2d6!t8` isn't available yet.

### Custom Wild Die
If a character has an Edge such as Master, they get to roll a Wild Die higher than d6. You can add `w` to the Savage roll to tell which Wild Die to use.
Here is Master d12+2, using a d10 for Wild Die.
```
!s12w10+2
```

**Tips:** You can combine with specific target number, but if you add modifiers, you must also add parenthesis.
This rolls d12+2, with a d10 for Wild Die, against Parry 8.
```
!(s12w10t8)+2
```

### Multi-dice
Weapons with a Rate of Fire, Frenzy, Work the Room, there are situations where you need to roll multiple Trait dice for a single action (and a single Wild Die if you are a Wild Card). 

As an extra, prefix with the number of dice to roll and a x (for *times*)
```
!2xd6!
```

As a wild card, the syntax is simpler, prefix your savage die with the number of dice to roll:
```
!2s6
```

**Tips:** This also works with Custom Wild Die and Modifiers, e.g. `!3s12w10+2`. But not (yet) with Target Numbers (Parry): `!3s6t2` (TN 2 is ignored here).

### Group Rolls
Group Rolls are used in Savage Worlds to simulate an average result for a group of extra (e.g. when they all sneak on the party, all attempt to notice something, or evaluate how well they survive their journey through the desert). It is resolved using a single Trait roll plus a standard d6 Wild Die. So simply use the `s` Savage Die!
```
!s6
```

**Tips:** Groups rolls are not used in combat. You'll have to roll each extra action one by one. However, you can roll multiple dice at once like this: `!5d6!` (5 extra rolling a d6 Trait).

### Custom Rolls
For a specific setting or house-rule you need something even more specific? Here are a few tricks that can be useful.

**Raise step other than 4**
If you need to count number of success and raises in step of 3 or 6 (instead of the standard 4):
```
!s8r6
> s8r6: [10; w1] = 10 (2; raise step: 6)
```

With specific target number:
```
!s12t8r6
> s12t8r6: [16; w1] = 16 (2; TN: 8; raise step: 6)
```

When target number and raise steps are the same:
```
!s12tr6
> s12tr6: [9; w3] = 9 (1; TN: 6; raise step: 6)
```

And with custom Wild Die too:
```
!s12w8t5r3
> s12w8t5r3: [7; w2] = 7 (1; TN: 5; raise step: 3)
```

**Limit roll results**
You will roll and sum up multiple dice, but you want the result to be not too extreme? You can put a lower and higher limit on your rolls. Here, we want the result to be between 6 and 30 (24+6).
```
!r (3d8!+d6!)[6:24+6]
```
This used in our house-rule for damage rolls for Savage Worlds.

## Dramatic Tasks
When running a Dramatic Tasks, players must collect a given amount of tokens in a set number of rounds.
To track those tokens, we will use the Benny commands (`give`, `take`, and `list`) and a virtual character, we will call... Miss Task!

### Start a Dramatic Task
Well, in case you had a previous task running, to start out fresh, start by removing MsTask from characters.
```
!remove MsTask
!list
```

**Notes:** We don't want to use `clear`, it would remove all Bennies from all players. This makes players unhappy. Not good.

### Gain Task Tokens
When players gain Task Token, deal them to MsTask.
```
!give MsTask 2
```

Same if they Snake Eye, and lose a Task Token:
```
!take MsTask 1
```

## Mass Battles
Same as with Dramatic Tasks, use the bennies commands to deal and take from two virtual characters. Let's call them TheHeroes and TheVillains (we give them names which starts the same, so that they end up next to eachother in the characters list).

### Set up a Mass Battle
Decide which side has the maximum number of tokens (10), and how many tokens the other side gets. Then deal those amounts of tokens to our mass battle avatars. In case you had a previous Mass Battle running, don't forget to remove the avatars before giving them new tokens.

```
!remove TheHeroes TheVillains
!give TheHeroes 7 TheVillains 10
```

### Morale and Casualties
At the end of each round of Mass Battles, `give` or `take` tokens from each sides.

```
!take TheVillains 2
!give TheHeroes 1
```

## Social Conflicts
Same as with Mass Battles and Dramatic Tasks, deal bennies to virtual characters to track the Social Conflict progress. Here let's call it MsInfluence.

### Start a Social Conflict
In case you already had a Social Conflict running, remove MsInfluence from the character list.
```
!remove MsInfluence
!list
```

### Gain Influence
Simply `give` Bennies to MsInfluence each time your arguments have gained you some influence.
```
!give MsInfluence 1
```

At the end of the three rounds, check how many influence MsInfluence has gained:
```
!list
```

## Deadland Bennies
Deadlands uses a pool of colored Bennies. Each color has its own uses. Characters draw Bennies at random from the pool.
This will use complete different command than regular Bennies. We assume Bennies are drawn (`benny`) from a `hat` and placed in the character's `pocket` until they `use` them. Do NOT use `clear`, `give`, or `take` for Deadlands bennies.

**Trivia:** Savage Bot started out aimed for Deadlands players. That's why the `benny` command is for Deadlands Bennies and not for standard Savage Worlds bennies.

Those Deadlands Bennies commands might get a rework to put them more in line with standard Benny features.

### New Deadlands session
Fill your hat with 20 white Bennies, 10 red Bennies, 5 blue Bennies (and no Golden ones):
```
!hat fill
```

### Grant Deadlands Bennies
Use `benny` to draw a random Benny from the hand and deal it to a single character.
```
!benny Huey
```

**Note:** as of now, there is no way to draw multiple Deadlands Bennies at once, and no way to deal to multiple players at once.

### Spend Deadlands Bennies
The `use` command lets you spend a Benny of a given color from a character.
```
!use white Huey
```

### What's in your pocket?
To check a character's pocket for Deadlands Bennies, use `pocket`.
```
!pocket Huey
```

**Note:** at the moment, there is no way to check for all characters' pockets at once.

### Reward a Golden Benny
While the hat seems able to have golden bennies, there is no feature right now to add Golden Bennies to the pot, or give a Golden Benny to a player.

However, if you don't use the standard Bennies commands, you could use them to stand for Golden Bennies.

### What's left in the hat?
Using `hat` command without the `fill` argument, you simply check how many Bennies of each color are left in the hat.
```
!hat
```

---
# Other Systems

## Worlds of Darkness
`!Nw[+1/+2]` - West End Games D6 System roll. Rolls N d6's one of which is 'wild': it explodes on 6 and subtracts highest number on 1.

`!6d6s4` - WoD, Lady Blackbird roll - rolls 6 d6 and returns how many dice rolled 4 or more

`!12d10s7` - roll 12 d10s, each 7+ result is a success, shows count of successes

`!12d10f1s7` - roll 12 d10s, each 7+ result is a success, each 1- result is a failure, shows (successes-failures)

`!12d10s7f1` -  same as above (you can provide success or failure condition in any order)

`!28d6!f1s10` - roll 28 open-ended d6s, each 10+ is a success, each 1- is a failure, show (successes-failures)

`!6x4d6k3` - roll 4 dice keeping 3 highest 6 times

## Coriolis

`!d66` - rolls two d6 and returns values from 11 to 66 to support random choice from 6x6 table (for example in Coriolis)

## Fate/Fudge
`!4dF` - rolls four Fudge/FATE dice

## D&D
### Roll with Advantage
`!d20adv+2` - advantage roll in DnD5. You can roll any dice with advantage: `!3d6adv`
### Roll with Disadvantage
`!d20dis+2` - disadvantage roll in DnD5e. You can roll any dice with disadvantage: `!3d8dis`
### Initiative
`!rs    [<heading_1>] <expression_1> ... [<heading_N>] <expression_N>`    rolls multiple dice and print them out sorted.
This is mostly useful for rolling initiative as a single command.
```
> !rs Huey d20 Dewey d20 Louie d20 
Dewey 14
Huey 10
Louie 5
```

## Carcosa
`!dC` - Carcosa roll. First d20 is rolled to determine size of dice - then this dice is rolled.

---
# Other tricks

## Some Other Kind of Rolls
Currently supported dice codes are:

`!3d6` - roll 3 6-sided dice, show sum

`!2d8!` - roll 2 'exploding' 8-sided dice, show sum. 'Exploding' means that if die come up with maximum value - it will be rolled again and summed up 

`!4d6k3` - roll 4 6-sided dice, keep 3 highest

`!6x4d6k3` - repeat 6 times: roll 4 6-sided dice, keep 3 highest 

`!2d10kl1` - roll 2 10-sided dice keep 1 lowest

## Roll Statistics
`!rh    <expression_1> ... <expressionN>`    creates data for histogram: rolls dice multiple times and shows resulting distribution. 
Example: `!rh 1000x2d6` - rolls 2d6 1000 times and shows results table.

## Cards
Here are a few commands to manipulate a standard deck of 54 cards.
This feature is pretty old and quite limited. It might get a rework later on.

### Deal Cards
`deal` or `dl` deals cards in secret to you. Each player must use this command themselves. You can't deal to another person. The cards dealt are sent by direct message to you.

This deals a hand of 5 cards:
```
!dl 5
```

### What's my Hand?
`show` or `sh` displays your current hand of cards.
```
!show
> 3 :spades: Q :hearts: 2 :hearts: 10 :spades: 4 :hearts:
```

### Draw to the Table
`put` does draw a card from the deck and put it on the table for everyone to see.

This draws three cards, and drop them on the table.
```
!put 3
```

### Shuffle
Grabs every cards back and shuffle into a new fresh deck.
```
!shuffle
```
