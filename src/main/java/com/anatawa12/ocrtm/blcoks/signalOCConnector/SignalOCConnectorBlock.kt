package com.anatawa12.ocrtm.blcoks.signalOCConnector

import jp.ngt.rtm.electric.IBlockConnective
import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.EnumBlockRenderType
import net.minecraft.world.World

/**
 * Created by anatawa12 on 2018/08/05.
 */
object SignalOCConnectorBlock : BlockContainer(Material.IRON), IBlockConnective {
    val ID = "signal_oc_connector"

    init {
        unlocalizedName = ID
        setRegistryName(ID)
        setCreativeTab(CreativeTabs.REDSTONE)
    }

    override fun canConnect(world: World?, x: Int, y: Int, z: Int): Boolean = true

    @Suppress("OverridingDeprecatedMember")
    override fun getRenderType(state: IBlockState?): EnumBlockRenderType = EnumBlockRenderType.MODEL

    override fun createNewTileEntity(worldIn: World, meta: Int): TileEntity? = SignalOCConnectorTileEntity()
}