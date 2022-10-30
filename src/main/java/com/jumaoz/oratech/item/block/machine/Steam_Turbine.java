package com.jumaoz.oratech.item.block.machine;

import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class Steam_Turbine extends BlockWithEntity {
    public Steam_Turbine(Settings settings) {
        super(settings);

    }
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return null;

    }
}
