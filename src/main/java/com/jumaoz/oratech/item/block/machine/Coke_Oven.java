package com.jumaoz.oratech.item.block.machine;

import com.jumaoz.oratech.OraTech;
import com.jumaoz.oratech.item.block.entitys.CokeOvenEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class Coke_Oven extends BlockWithEntity implements BlockEntityProvider{
    public static final IntProperty FLUID_VALUE = IntProperty.of("fluid_value",0,10);
    public Coke_Oven(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
        setDefaultState(this.stateManager.getDefaultState().with(Properties.LIT, false));
    }
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(FLUID_VALUE);
        stateManager.add(Properties.HORIZONTAL_FACING);
        stateManager.add(Properties.LIT);
    }
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(Properties.HORIZONTAL_FACING,ctx.getPlayerFacing().getOpposite());
    }
    @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CokeOvenEntity(pos,state);
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient){
            return ActionResult.SUCCESS;
        }
        BlockEntity cokeOvenEntity = world.getBlockEntity(pos);
            if (player.getMainHandStack().getItem() == Items.BUCKET) {
                if (world.getBlockState(pos).get(FLUID_VALUE) >= 1) {
                    world.setBlockState(pos, state.with(FLUID_VALUE, world.getBlockState(pos).get(FLUID_VALUE) - 1));
                    player.getMainHandStack().setCount(player.getMainHandStack().getCount()-1);
                    player.giveItemStack(new ItemStack(OraTech.CREOSOTE_OIL, 1));
                    return ActionResult.CONSUME;
                }
            }
        if(cokeOvenEntity instanceof CokeOvenEntity){
            player.openHandledScreen((CokeOvenEntity) cokeOvenEntity);
        }
        return ActionResult.CONSUME;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.isOf(newState.getBlock())){
            return;
        }
        BlockEntity cokeOvenEntity = world.getBlockEntity(pos);
        if (cokeOvenEntity instanceof CokeOvenEntity){
            ItemScatterer.spawn(world,pos, (Inventory) ((Object) cokeOvenEntity));
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
        return checkType(type, OraTech.COKE_OVEN_ENTITY,CokeOvenEntity::tick);
    }
}

