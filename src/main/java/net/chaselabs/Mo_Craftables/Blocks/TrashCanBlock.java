package net.chaselabs.Mo_Craftables.Blocks;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class TrashCanBlock extends Block {
	public final VoxelShape SHAPE;

	public TrashCanBlock() {
		super(Block.Properties.create(Material.IRON));
		SHAPE = generateShape();
	}

	private VoxelShape generateShape() {
		List<VoxelShape> shapes = new ArrayList<>();
		shapes.add(Block.makeCuboidShape(0.125, 0.125, 0.125, 0.875, 0.438, 0.875)); // BODY
		shapes.add(Block.makeCuboidShape(0.062, 0.438, 0.062, 0.938, 0.5, 0.938)); // BOTTOM_TOPSECTION
		shapes.add(Block.makeCuboidShape(0.188, 0.5, 0.188, 0.812, 0.562, 0.812)); // MIDDLE_TOPSECTION
		shapes.add(Block.makeCuboidShape(0.375, 0.562, 0.375, 0.625, 0.625, 0.625)); // TOP_TOPSECTION
		shapes.add(Block.makeCuboidShape(0.188, 0, 0.188, 0.312, 0.125, 0.312)); // LEG_1
		shapes.add(Block.makeCuboidShape(0.188, 0, 0.688, 0.312, 0.125, 0.812)); // LEG_2
		shapes.add(Block.makeCuboidShape(0.688, 0, 0.688, 0.812, 0.125, 0.812)); // LEG_3
		shapes.add(Block.makeCuboidShape(0.688, 0, 0.188, 0.812, 0.125, 0.312)); // LEG_3

		VoxelShape result = VoxelShapes.empty();
		for (VoxelShape shape : shapes) {
			result = VoxelShapes.combine(result, shape, IBooleanFunction.OR);
		}
		return result.simplify();
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}
//
//	@Override
//	public VoxelShape getRenderShape(BlockState state, IBlockReader reader, BlockPos pos) {
//		return SHAPE;
//	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}
	
	
}
