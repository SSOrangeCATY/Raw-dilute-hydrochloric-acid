package net.archasmiel.thaumcraft.generation.block.entityBlock;

import net.archasmiel.thaumcraft.generation.block.ModBlockEntityRegister;
import net.archasmiel.thaumcraft.generation.block.entitys.*;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class Arcane_Workbench extends BlockWithEntity implements BlockEntityProvider{

    public Arcane_Workbench(Settings settings) {
        super(settings);
    }
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new Arcane_WorkbenchEntity(pos,state);
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient){
            return ActionResult.SUCCESS;
        }
        BlockEntity Entity = world.getBlockEntity(pos);
        if(Entity instanceof Arcane_WorkbenchEntity){
            player.openHandledScreen((Arcane_WorkbenchEntity) Entity);
        }
        return ActionResult.CONSUME;
    }
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.isOf(newState.getBlock())){
            return;
        }
        BlockEntity Entity = world.getBlockEntity(pos);
        if (Entity instanceof Arcane_WorkbenchEntity){
            ItemScatterer.spawn(world,pos, (Inventory) ((Object) Entity));
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
        return checkType(type, ModBlockEntityRegister.ARCANE_WORKBENCHENTITY, Arcane_WorkbenchEntity::tick);
    }
}
