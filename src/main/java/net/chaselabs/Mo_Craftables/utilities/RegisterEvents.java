package net.chaselabs.Mo_Craftables.utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.chaselabs.Mo_Craftables.Main;
import net.chaselabs.Mo_Craftables.Items.armor.EnderArmor;
import net.chaselabs.Mo_Craftables.lists.ItemList;
import net.chaselabs.Mo_Craftables.utilities.References.LogTypes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@SuppressWarnings("all")
//@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegisterEvents {
//
//	@SubscribeEvent
//	public static void onLivingHurt(LivingHurtEvent event) {
//		Main.Log(LogTypes.Debug, "YUP");
//		if (event.getEntity() instanceof PlayerEntity) {
//			PlayerEntity player = (PlayerEntity) event.getEntity();
//			if (event.getSource().getTrueSource() instanceof Entity) {
//				Entity attacker = event.getSource().getTrueSource();
//				Main.Log(LogTypes.Debug, attacker.getDisplayName().getString() + " attacked " + player.getDisplayName().getString());
//				for (ItemStack stack : player.getArmorInventoryList()) {
//					if (stack.getItem() instanceof EnderArmor) {
//						Main.Log(LogTypes.Debug, attacker.getDisplayName().getString() + " attacked " + player.getDisplayName().getString() + " wearing " + stack.getDisplayName().getString());
//					}
//				}
//			}
//		}
//	}
//
//	@SubscribeEvent
//	public static void addDropForType(HarvestDropsEvent event) {
////		event.setCanceled(true);
//		Block block = event.getState().getBlock();
//		Item item = event.getHarvester().getHeldItemMainhand().getItem();
//		System.out.println("harvested " + block + " with " + item);
//		event.getDrops().add(new ItemStack(Blocks.DIAMOND_BLOCK));
//	}
//
//	public static void registerEnchantments() {
//		Map<Enchantment, Integer> map = new HashMap<Enchantment, Integer>();
//		map.put(Enchantments.SILK_TOUCH, 1);
//		addEnchanements(ItemList.plastic_shovel.getItem(), map);
//	}
//
//	private static void addEnchanements(Item item, Map<Enchantment, Integer> map) {
//		ItemStack stack = item.getDefaultInstance();
//
//		for (Enchantment e : map.keySet()) {
//			Main.Log(LogTypes.Warn, "Adding " + e.getDisplayName(map.get(e)).getFormattedText() + " Level " + map.get(e) + " to " + stack.getDisplayName().getFormattedText());
//		}
//		EnchantmentHelper.setEnchantments(map, stack);
//		CompoundNBT root = new CompoundNBT();
//		ListNBT listnbt = new ListNBT();
//
//		for (Entry<Enchantment, Integer> entry : map.entrySet()) {
//			Enchantment enchantment = entry.getKey();
//			if (enchantment != null) {
//				int level = entry.getValue();
//				Main.Log(LogTypes.Debug, "Attempting to Add Enchantment " + enchantment.getName() + " Level " + level + " to " + stack.getDisplayName().getString());
//				try {
//					CompoundNBT compoundnbt = new CompoundNBT();
//					compoundnbt.putString("id", String.valueOf((Object) Registry.ENCHANTMENT.getKey(enchantment)));
//					compoundnbt.putShort("lvl", (short) level);
//					listnbt.add(compoundnbt);
//
//					if (stack.getItem() == Items.ENCHANTED_BOOK) {
//						EnchantedBookItem.addEnchantment(stack, new EnchantmentData(enchantment, level));
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//					Main.Log(LogTypes.Error, "ERROR: " + e.getStackTrace());
//				}
//			} else
//				Main.Log(LogTypes.Error, "Enchantment = null");
//		}
//		root.put("Enchantments", listnbt);
//		root.putInt("RepairCost", 1);
//
//		CompoundNBT wrote = stack.write(root);
//		Main.Log(LogTypes.Debug, "NBT List was written: \n{\n  " + wrote.toFormattedComponent().getString() + "  \n}\n");
//		stack.setTag(root);
////		if (listnbt.isEmpty()) {
////			Main.Log(LogTypes.Debug, "NBT List was empty");
////			stack.removeChildTag("Enchantments");
////		} else if (stack.getItem() != Items.ENCHANTED_BOOK) {
////		}
//
//	}
}
