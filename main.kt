fun main(args: Array<String>) {
    val ANSI_RED = "\u001B[31m"
    val ANSI_RESET = "\u001B[0m"
    val ANSI_CYAN = "\u001b[0;96m"
    val ANSI_PURPLE = "\u001b[35m"
    val ANSI_YELLOW = "\u001b[1;33m"
    val ANSI_VIBRANT_YELLOW = "\u001b[1;93m"
    val ANSI_GREEN = "\u001b[1;92m"

    println("Welkom bij "+ ANSI_PURPLE + "Juwilier Overval" + ANSI_RESET + "Succes met het ontsnappen...")

    println("\nWhat is your name?")
    var username = readLine()


    while (username!!.isBlank()) {
        println("Please enter a valid username")
        username = readLine()
    }
    val player = Player("$username", 4, 30)
    // Begin items
    val fistSwordItem = Weapon("Fist", 8)
    val fistItem = Loot("Fist", LootType.WEAPON)

    val cloak = Loot("Cloak", LootType.ARMOR)
    val redPotion = Loot("Health Potion", LootType.POTION)

    val wapenStok = Weapon("Wapen Stok", 16)
    val wapenStokItem = Loot("Wapen stok", LootType.WEAPON)

    // Begin Items
    player.inventory.add(cloak)
    player.weapon = fistSword
    player.inventory.add(redPotion)
    player.inventory.add(fistSwordItem)

    // Begin var
    var level1 = true
    var buffedBoss = true
    // World 2
    var level12 = true

    // Enemies
    val bodyguard = Bodyguard("Bodyguard", 10,1, 5)
    val guard1 = Waakhond("Waakhond", 12,1, 5)


    // Game start
    println("$username Heeft een overval gepleegd in een juwelierzaak, hij heeft zijn hand opengesneden door een diamand maar heeft het verzorgd met een EHBO kit ")
    println("Nu moet hij nog ontsnappen...")
    println("\n\n$username Is in de opslagruimte en ziet twee  " + ANSI_PURPLE + "deuren die naar de uitgang leiden" + ANSI_RESET + " in deur 1 zit een bodyguard"+ ANSI_RED + "\nen in deur 2 ook" + ANSI_RESET)
    println("Press enter to continue text")
    readLine()

    println("\nKies een van de twee deuren...")
    println("Type 1 voor deur 1")
    println("Type 2 voor deur 2")


    //------------------End of the start------------------
    var playing = true
    var world = 1
    while (world == 1) {

        fun level1() {
            println("In de kamer ziet $username een bodyguard naar hem toe lopen\nSta klaar om te vechten")
            println("Type in 1 om te vechten...")
            while (level1) {
                var fight = readLine()
                if (fight == "1") {
                    bodyguard.takeDamage(player.weapon.damageInflicted)
                    if (bodyguard.lives < 1) {
                        println("Bodyguard is defeated by $username.")
                        println(ANSI_GREEN + "Oh?" + ANSI_CYAN + "$username" + ANSI_GREEN + " heeft een wapenstok gevonden!'" + ANSI_RESET)
                        player.weapon = wapenStok
                        player.inventory.add(wapenStokItem)
                        println("Press enter to leave the room")
                        readLine()
                        level1 = false
                    } else {
                        player.takeDamage(bodyguard.damageInflicted)
                    }
                    } else {
                        println("Sorry, ik begrijp je niet. Type 1 om te vechten.")
                }
            }
        }

            fun level2() {
                println(ANSI_YELLOW + "In kamer 2 zit een buffed bodyguard.." + ANSI_RESET + "\n$username" + ANSI_YELLOW + " moet de som oplossen om de enemy te verslaan!")
                while (buffedBoss) {
                    println(ANSI_YELLOW + "Los de som op")
                    println(ANSI_VIBRANT_YELLOW + "Wat is: 56+14+31")
                    var choosemummy = readLine()
                    if (choosemummy == "101") {
                        println(ANSI_GREEN + "Dat is correct, de buffed bodyguard is verslagen!")
                        println(ANSI_RESET + "Je kan nu door naar level 2")
                        buffedBoss = false
                        world = 2
                    } else {
                        println(ANSI_RED + "Verkeerde antwoord, probeer het opnieuw")
                        println(ANSI_VIBRANT_YELLOW + "voordat de buffed bodyguard je verslaat!\n")
                    }

                }


            }
            fun repeatText1() {
                println("\nKies een van de twee deuren...")
                println("Type 1 voor deur 1")
                println("Type 2 voor deur 2")
            }


            val userInput: List<String> = playerInput().split(delimiters = *charArrayOf(' ')).map { it.toUpperCase() }

            when (userInput.first()) {
                "QUIT", "EXIT", "Q" -> System.exit(0)
                "1" -> level1()
                "2" -> level2()
                "HELP" -> showHelp()
                "INVENTORY", "INV" -> player.showInventory()
                "AGAIN" -> repeatText1()
                else -> {
                    println("You can type in 'help' to see a list of commands")
                }
            }
        }

    //world 2

    println("Je bent bijna bij de uitgang\nAlleen staat er een agresieve waakhond voor de uitgang.")
    println("\nType 1 om het gevecht te starten")
    while (world == 2) {

        fun level12() {
            println("Je ziet de waakhond, versla hem om de game te winnen!")
            println("Type in 1 to fight.")
            while (level12) {
                var fight = readLine()
                if (fight == "1") {
                    guard1.takeDamage(player.weapon.damageInflicted)
                    if (guard1.lives < 1) {
                        println("De waakhond is verslagen door $username. Je hebt de game verslagen en bent ontsnapt!")
                        println("Type 'Quit' om het spel te verlaten...)
                        readLine()

                        level12 = false
                    } else {
                        player.takeDamage(guard1.damageInflicted)
                    }
                } else {
                    println("The player typed something that doesn't work maybe type in 1 to hit the enemy.")
                }

            }
        }

        fun repeatText2() {
            println("\nType 1 om het gevecht te starten")
        }


        val userInput: List<String> = playerInput().split(delimiters = *charArrayOf(' ')).map { it.toUpperCase() }

        when (userInput.first()) {
            "QUIT", "EXIT", "Q" -> System.exit(0)
            "1" -> level12()
            "HELP" -> showHelp()
            "INVENTORY", "INV" -> player.showInventory()
            "AGAIN" -> repeatText2()
            else -> {
                println("You can type in 'help' to see a list of commands")
            }
        }
    }
            }


// Fun out of main

fun showHelp() {
    println("-------------------------------------------")
    println("Type q, exit or quit to quit the game.")
    println("\nYou can right click and clear all text.")
    println("\nType in inventory or inv to see your inventory.")
    println("\nType in again to repeat the room guide text.")
    println("--------------------TIPS-------------------")
    println("\nYou automatically use the best weapon in your inventory.")
    println("-------------------------------------------")
}

fun playerInput(): String {
    var input: String? = null
    while (input == null) {
        print("> ")
        input = readLine()
    }
    return input.toLowerCase()
}


///////////////// Archive /////////////////
//val mummyBoss = Mummy("Mummy", 30, 2)

//fun level1() {
//    var world1 = false
//    println("Fucking ghost's I hate ghost's")
//}

//    println("Enter a string :")
//    val userInputString = readLine()
//
//    println("You have entered : $userInputString")