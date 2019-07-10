package com.anatawa12.ocrtm.blcoks.signalOCConnector

import jp.ngt.rtm.electric.IProvideElectricity
import li.cil.oc.api.Network
import li.cil.oc.api.machine.Arguments
import li.cil.oc.api.machine.Callback
import li.cil.oc.api.machine.Context
import li.cil.oc.api.network.Visibility
import li.cil.oc.api.prefab.TileEntityEnvironment
import net.minecraft.util.EnumFacing
import net.minecraft.util.math.BlockPos

/**
 * Created by anatawa12 on 2018/08/05.
 */
class SignalOCConnectorTileEntity : TileEntityEnvironment(), IProvideElectricity {
    private var signal = 0
    private val signals = mutableListOf<SignalInfo>()

    @Callback
    fun getSignals(context: Context, args: Arguments): Array<Any?> {
        return arrayOf(signals.map { mapOf("signal" to it.signal, "facing" to it.facing?.ordinal, "pos" to mapOf("x" to it.pos.x, "y" to it.pos.y, "z" to it.pos.z)) }.toTypedArray())
    }

    @Callback
    fun getMinSignal(context: Context, args: Arguments): Array<Any?>? {
        if (signals.isEmpty()) return null
        var sig = Integer.MAX_VALUE
        for (signal in signals) {
            if (sig > signal.signal)
                sig = signal.signal
        }
        return arrayOf(sig)
    }

    @Callback
    fun getMaxSignal(context: Context, args: Arguments): Array<Any?>? {
        if (signals.isEmpty()) return null
        var sig = 0
        for (signal in signals) {
            if (sig < signal.signal)
                sig = signal.signal
        }
        return arrayOf(sig)
    }

    @Callback
    fun setSignal(context: Context, args: Arguments): Array<Any?>? {
        signal = args.checkInteger(0)
        return null
    }

    override fun getElectricity(): Int = signal

    override fun setElectricity(x: Int, y: Int, z: Int, level: Int) {
        val inPos = BlockPos(x, y, z)
        val index = signals.indexOfFirst { it.pos == inPos }
        if (index != -1) signals.removeAt(index)
        val facing = when (inPos) {
            pos -> null
            pos.down() -> EnumFacing.DOWN
            pos.up() -> EnumFacing.UP
            pos.east() -> EnumFacing.EAST
            pos.west() -> EnumFacing.WEST
            pos.north() -> EnumFacing.NORTH
            pos.up() -> EnumFacing.NORTH
            else -> null
        }
        if (level != 0) signals.add(SignalInfo(level, facing, inPos))
    }

    init {
        node = Network.newNode(this, Visibility.Network)
                .withComponent("rtm_signal")
                .create()
    }

    private class SignalInfo(val signal: Int, val facing: EnumFacing?, val pos: BlockPos)
}