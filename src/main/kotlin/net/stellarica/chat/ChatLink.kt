package net.stellarica.chat

import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.server.DedicatedServerModInitializer

class ChatLink : DedicatedServerModInitializer {
	override fun onInitializeServer(mod: ModContainer?) {
		println("Hello from the server!")
	}
}