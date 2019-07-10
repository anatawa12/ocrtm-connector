package jp.ngt.rtm.electric

import net.minecraft.tileentity.TileEntity

/**
 * get or set signal value. get/set is called from the insulator.
 * implement from [TileEntity].
 * see RTM source.
 */
interface IProvideElectricity {
    /**
     * get sending signal level
     */
    fun getElectricity(): Int

    /**
     * set receiving signal level
     */
    fun setElectricity(x: Int, y: Int, z: Int, level: Int)
}