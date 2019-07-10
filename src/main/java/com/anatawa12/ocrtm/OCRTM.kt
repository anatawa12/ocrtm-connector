package com.anatawa12.ocrtm

import com.anatawa12.ocrtm.blcoks.signalOCConnector.SignalOCConnectorBlock
import com.anatawa12.ocrtm.blcoks.signalOCConnector.SignalOCConnectorItemBlock
import com.anatawa12.ocrtm.blcoks.signalOCConnector.SignalOCConnectorTileEntity
import net.minecraft.block.Block
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.registry.GameRegistry.registerTileEntity

/**
 * Created by anatawa12 on 2018/08/05.
 */
@Mod(modid = OCRTM.ID, version = Constants.version)
object OCRTM {
    @Mod.EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(this)
    }

    @SubscribeEvent
    fun registerBlocks(event: RegistryEvent.Register<Block>) {
        event.registry.register(SignalOCConnectorBlock)
        registerTileEntity(SignalOCConnectorTileEntity::class.java, ResourceLocation(ID, SignalOCConnectorBlock.ID))
    }

    @SubscribeEvent
    fun registerItems(event: RegistryEvent.Register<Item>) {
        event.registry.register(SignalOCConnectorItemBlock)
    }

    @SubscribeEvent
    fun registerModels(event: ModelRegistryEvent) {
        ModelLoader.setCustomModelResourceLocation(SignalOCConnectorItemBlock, 0, ModelResourceLocation(SignalOCConnectorBlock.registryName!!, "normal"))
    }

    @Mod.InstanceFactory
    @Deprecated("_InstanceFactory", level = DeprecationLevel.HIDDEN)
    @JvmStatic
    fun _InstanceFactory() = this

    const val ID = "oc_rtm"
}
