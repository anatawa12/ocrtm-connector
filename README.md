# OCRTM Connector

the mod to control [RTM](https://www.curseforge.com/minecraft/mc-mods/realtrainmod/files) signal from [OpenComputers](https://www.curseforge.com/minecraft/mc-mods/opencomputers)

## How to use

This mod adds a block which is a component into the Redstone tab.
1. Contact Signal OC Connector and Computer. 
1. push I/O insulator into Signal OC Connector.
1. you can get or control output signal!

## API Reference

Component name: `rtm_signal` <br>
Functions:<br>
`getSignals(): signal[]` returns all signals which are caught by this block.<br>
`getMinSignal(): number | nil` returns the minimum signal value of signals which are caught by this block. If this block doesn't catch any signals, this returns `nil`.<br>
`getMaxSignl(): number | nil` returns the maximal signal value of signals which are caught by this block. If this block doesn't catch any signals, this returns `nil`.<br>
`setSignal(sig: number)`sets the signal value to output. <br>
Type:
```
signal {
    signal: number, //value of signal
    facing: number, //side of insulator see https://ocdoc.cil.li/api:sides
    pos: {x: number, y: number, z: number} //position of the insulator 
}
```

## Restrictions

- RTM has no way to control the output signal by direction. So we can't do it.
- RTM is not open source software so you must download the RTM yourself.

## Repository

[github.com/anatawa12/ocrtm-connector](https://github.com/anatawa12/ocrtm-connector)

## Contribution

please give me a pull-request. 
Before sending a pull request, please format source code with IDEA default settings.

## Third-perties

This software is using Kotlin, a programming language and library made by Jetbrains and contributors released under Apache License 2.0. 
