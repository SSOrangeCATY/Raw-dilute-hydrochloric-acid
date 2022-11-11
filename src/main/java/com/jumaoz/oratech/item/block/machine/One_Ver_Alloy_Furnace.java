package com.jumaoz.oratech.item.block.machine;

import com.jumaoz.oratech.OraTech;
import com.jumaoz.oratech.item.block.entitys.EarthBlastFurnaceEntity;
import com.jumaoz.oratech.item.block.entitys.OneVerAlloyFurnaceEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class One_Ver_Alloy_Furnace  extends BlockWithEntity implements BlockEntityProvider {
    public One_Ver_Alloy_Furnace(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
        setDefaultState(this.stateManager.getDefaultState().with(Properties.LIT, false));
    }
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
        stateManager.add(Properties.LIT);
    }
    @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new OneVerAlloyFurnaceEntity(pos,state);
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient){
            return ActionResult.SUCCESS;
        }
        BlockEntity oneVerAlloyFurnaceEntity = world.getBlockEntity(pos);
        if(oneVerAlloyFurnaceEntity instanceof OneVerAlloyFurnaceEntity){
            player.openHandledScreen((OneVerAlloyFurnaceEntity) oneVerAlloyFurnaceEntity);
        }
        return ActionResult.CONSUME;
    }
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(Properties.HORIZONTAL_FACING,ctx.getPlayerFacing().getOpposite());
    }
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.isOf(newState.getBlock())){
            return;
        }
        BlockEntity oneVerAlloyFurnaceEntity = world.getBlockEntity(pos);
        if (oneVerAlloyFurnaceEntity instanceof OneVerAlloyFurnaceEntity){
            ItemScatterer.spawn(world,pos, (Inventory) ((Object) oneVerAlloyFurnaceEntity));
            world.updateComparators(pos,this);
        }
        super.onStateReplaced(state, world, pos, newState, moved);
    }
    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }
    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }

    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, OraTech.ONE_VER_ALLOY_FURNACE_ENTITY,OneVerAlloyFurnaceEntity::tick);
    }
}
