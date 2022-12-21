package net.archasmiel.thaumcraft.item.block.entityBlock;

import net.archasmiel.thaumcraft.item.block.ModBlockEntityRegister;
import net.archasmiel.thaumcraft.item.block.entitys.AuraNodeEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
public class AuraNode extends BlockWithEntity {


    public AuraNode(Settings settings) {
        super(settings);
    }
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AuraNodeEntity(ModBlockEntityRegister.AURANODEENTITY,pos,state);
    }
}
