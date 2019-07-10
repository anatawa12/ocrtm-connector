package com.anatawa12.ocrtm.blcoks.signalOCConnector

import net.minecraft.item.ItemBlock

/**
 * Created by anatawa12 on 2018/08/05.
 */
object SignalOCConnectorItemBlock : ItemBlock(SignalOCConnectorBlock) {
    init {
        unlocalizedName = SignalOCConnectorBlock.ID
        setRegistryName(SignalOCConnectorBlock.ID)
    }
}