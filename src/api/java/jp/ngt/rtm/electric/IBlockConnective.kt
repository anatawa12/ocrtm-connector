package jp.ngt.rtm.electric

import net.minecraft.block.Block
import net.minecraft.world.World

/**
 * an interface which makes a Block be able to push an I/O insulator.
 * implement from [Block].
 * see RTM source.
 */
interface IBlockConnective {
    fun canConnect(world: World?, x: Int, y: Int, z: Int): Boolean
}