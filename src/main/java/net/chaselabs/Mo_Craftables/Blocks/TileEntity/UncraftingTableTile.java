package net.chaselabs.Mo_Craftables.Blocks.TileEntity;

import net.chaselabs.Mo_Craftables.GUI.Container.UnCraftingTableContainer;
import net.chaselabs.Mo_Craftables.utilities.References;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class UncraftingTableTile extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

	LazyOptional<ItemStackHandler> handler = LazyOptional.of(this::createHandler);

	public UncraftingTableTile() {
		super(References.UNCRAFTING_TABLE_TILE);
	}

	@Override
	public void tick() {
	}

	@Override
	public void read(CompoundNBT tag) {
		CompoundNBT invTag = tag.getCompound("inv");
		handler.ifPresent(h -> ((INBTSerializable<CompoundNBT>) h).deserializeNBT(invTag));
		createHandler().deserializeNBT(invTag);
		super.read(tag);
	}

	@Override
	public CompoundNBT write(CompoundNBT tag) {
		handler.map(h -> ((INBTSerializable<CompoundNBT>) h).serializeNBT());
		handler.ifPresent(h -> {
			CompoundNBT nbt = ((INBTSerializable<CompoundNBT>) h).serializeNBT();
			tag.put("inv", nbt);

		});
		return super.write(tag);

	}

	ItemStackHandler createHandler() {
		return new ItemStackHandler(1) {
			@Override
			public boolean isItemValid(int slot, ItemStack stack) {
				return true;
			}

			@Override
			public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
				return super.insertItem(slot, stack, simulate);
			}

		};
	}

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return handler.cast();
		return super.getCapability(cap, side);
	}

	@Override
	public Container createMenu(int id, PlayerInventory inv, PlayerEntity player) {
		return new UnCraftingTableContainer(id, world, pos, inv);
	}

	@Override
	public ITextComponent getDisplayName() {
		return new StringTextComponent("UnCrafting Table");
	}

}
