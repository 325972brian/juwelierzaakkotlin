enum class LootType{
   ARMOR, WEAPON
}

class Loot(val name: String, val lootType: LootType) {

    override fun toString(): String {
        return "$name is a $lootType"
    }
}
