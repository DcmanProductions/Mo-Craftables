package net.chaselabs.Mo_Craftables.GUI.Container;

import static net.chaselabs.Mo_Craftables.utilities.References.UNCRAFTING_TABLE_CONTAINER;

import net.chaselabs.Mo_Craftables.lists.BlockList;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class UnCraftingTableContainer extends Container {

	TileEntity tileEntity;
	PlayerEntity player;
	IItemHandler inventory;

	public UnCraftingTableContainer(int id, World world, BlockPos pos, PlayerInventory inventory) {
		super(UNCRAFTING_TABLE_CONTAINER, id);
		tileEntity = world.getTileEntity(pos);
		this.player = Minecraft.getInstance().player;
		this.inventory = new InvWrapper(inventory);

		// Input
		tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
			addSlot(h, 0, 28, 30);

			// Top Row
			addSlot(h, 1, 106, 18);
			addSlot(h, 2, 124, 18);
			addSlot(h, 3, 142, 18);

			// Middle Row
			addSlot(h, 4, 106, 37);
			addSlot(h, 5, 124, 37);
			addSlot(h, 6, 142, 37);

			// Bottom Row
			addSlot(h, 7, 106, 55);
			addSlot(h, 8, 124, 55);
			addSlot(h, 9, 142, 55);

//			// Top Row
//			addSlot(new Slot(inventory, 1, 106, 18));
//			addSlot(new Slot(inventory, 2, 124, 18));
//			addSlot(new Slot(inventory, 3, 142, 18));
//
//			// Middle Row
//			addSlot(new Slot(inventory, 4, 106, 37));
//			addSlot(new Slot(inventory, 5, 124, 37));
//			addSlot(new Slot(inventory, 6, 142, 37));
//
//			// Bottom Row
//			addSlot(new Slot(inventory, 7, 106, 55));
//			addSlot(new Slot(inventory, 8, 124, 55));
//			addSlot(new Slot(inventory, 9, 142, 55));
		});

		layoutPlayerinventorySlots(8, 83);

	}

	@Override
	public void putStackInSlot(int slotID, ItemStack stack) {
		if (slotID == 0) {
			if (stack == Items.FURNACE.getDefaultInstance()) {
				putStackInSlot(1, Items.COBBLESTONE.getDefaultInstance());
				putStackInSlot(2, Items.COBBLESTONE.getDefaultInstance());
				putStackInSlot(3, Items.COBBLESTONE.getDefaultInstance());
				putStackInSlot(4, Items.COBBLESTONE.getDefaultInstance());
				putStackInSlot(6, Items.COBBLESTONE.getDefaultInstance());
				putStackInSlot(7, Items.COBBLESTONE.getDefaultInstance());
				putStackInSlot(8, Items.COBBLESTONE.getDefaultInstance());
				putStackInSlot(9, Items.COBBLESTONE.getDefaultInstance());
			}
		}
		super.putStackInSlot(slotID, stack);
	}

	@Override
	public boolean canInteractWith(PlayerEntity player) {
		return false;
//		return isWithinUsableDistance(IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos()), player, BlockList.uncrafting_table.getBlock().get(0));
	}

	public void addSlot(IItemHandler handler, int index, int x, int y) {
		addSlot(new SlotItemHandler(handler, index, x, y));
	}

	public int addSlotRange(IItemHandler handler, int index, int x, int y, int amount, int dx) {
		for (int i = 0; i < amount; i++) {
			addSlot(handler, index, x, y);
			x += dx;
			index++;
		}
		return index;
	}

	public int addSlotBox(IItemHandler handler, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
		for (int i = 0; i < verAmount; i++) {
			index = addSlotRange(handler, index, x, y, i, dx);
			y += dy;
		}
		return index;
	}

	protected void layoutPlayerinventorySlots(int leftCol, int topRow) {
		addSlotBox(inventory, 9, leftCol, topRow, 9, 18, 3, 18);
		topRow += 58;
		addSlotRange(inventory, 0, leftCol, topRow, 9, 18);
	}

}
