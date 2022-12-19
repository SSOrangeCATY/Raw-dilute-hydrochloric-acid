package net.archasmiel.thaumcraft.item.block.entitys;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.item.block.ModBlockEntityRegister;
import net.archasmiel.thaumcraft.screen.handler.Arcane_WorkbenchScreenHandler;
import net.archasmiel.thaumcraft.util.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class Arcane_WorkbenchEntity extends BlockEntity implements NamedScreenHandlerFactory , ImplementedInventory {
    private DefaultedList<ItemStack> inv = DefaultedList.ofSize(11,ItemStack.EMPTY);

    public Arcane_WorkbenchEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityRegister.ARCANE_WORKBENCHENTITY, blockPos, blockState);
    }

    public DefaultedList<ItemStack> getItems() {
        return this.inv;
    }
    @Override
    public Text getDisplayName() {
        return Text.translatable("block.thaumcraft.arcane_workbench.GUI");
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new Arcane_WorkbenchScreenHandler(syncId,inv,this);
    }
    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt,inv);
    }
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt,inv);
    }
    public static <E extends BlockEntity> void tick(World world, BlockPos blockPos, BlockState blockState, Arcane_WorkbenchEntity entity) {
        if(world.isClient()) {
            return;
        }
    }
}