package net.chaselabs.Mo_Craftables.commands;

import com.mojang.brigadier.CommandDispatcher;

import net.chaselabs.Mo_Craftables.utilities.Cache;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

public class MoCommands {

	public MoCommands() {
	}

	public void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(Commands.literal("test").executes(context -> test(context.getSource())));
	}

	private int test(CommandSource source) {
		Cache.Init();
		return 0;
	}

}
