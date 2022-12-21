package net.archasmiel.thaumcraft.generation.block.entityBlock;

import net.archasmiel.thaumcraft.generation.block.ModBlockEntityRegister;
import net.archasmiel.thaumcraft.generation.block.entitys.AuraNodeEntity;
import net.archasmiel.thaumcraft.generation.item.ModItemRegister;
import net.archasmiel.thaumcraft.generation.item.wand.Wand;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AuraNode extends BlockWithEntity implements BlockEntityProvider {
    int wind=0;
    int earth=0;
    int fire=0;
    int water=0;
    int order=0;
    int chaos=0;
    int isWriteElements = 1;

    public AuraNode(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AuraNodeEntity(pos,state);
    }
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if(((AuraNodeEntity)world.getBlockEntity(pos)).checkElements()){
            ((AuraNodeEntity)world.getBlockEntity(pos)).setElements();
        }
    }
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient){
            return ActionResult.FAIL;
        }
        if(player.getMainHandStack().getItem() == ModItemRegister.TESTWAND){
            readElements(ModBlockEntityRegister.AURANODEENTITY.get(world,pos).writeElementNbt(new NbtCompound()));
            player.giveItemStack(new ItemStack(Items.WHITE_WOOL));
            setElements(player,ModBlockEntityRegister.AURANODEENTITY.get(world,pos).writeElementNbt(new NbtCompound()),world,pos);
        }
        return ActionResult.FAIL;
    }
    public void readElements(NbtCompound nbt){
        wind = nbt.getInt("wind");
        earth = nbt.getInt("earth");
        fire = nbt.getInt("fire");
        water = nbt.getInt("water");
        order = nbt.getInt("order");
        chaos = nbt.getInt("chaos");
    }
    public void setElements(PlayerEntity player,NbtCompound nbt,World world, BlockPos pos){

        if(wind !=0 && Wand.addWindElement(player.getMainHandStack(),1)) wind = wind-1;
        else if(earth !=0 && Wand.addEarthElement(player.getMainHandStack(),1)) earth = earth-1;
        else if(fire !=0 && Wand.addFireElement(player.getMainHandStack(),1)) fire = fire-1;
        else if(water !=0 && Wand.addWaterElement(player.getMainHandStack(),1)) water = water-1;
        else if(order !=0 && Wand.addOrderElement(player.getMainHandStack(),1)) order = order-1;
        else if(chaos !=0 && Wand.addChaosElement(player.getMainHandStack(),1)) chaos = chaos-1;

        ModBlockEntityRegister.AURANODEENTITY.get(world,pos).readElements(writeElementNbt(nbt));
    }
    public NbtCompound writeElementNbt(NbtCompound nbt){
        nbt.putInt("wind",wind);
        nbt.putInt("earth",earth);
        nbt.putInt("fire",fire);
        nbt.putInt("water",water);
        nbt.putInt("order",order);
        nbt.putInt("chaos",chaos);
        nbt.putInt("isWriteElements",isWriteElements);
        return nbt;
    }
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.isOf(newState.getBlock())){
            return;
        }
        BlockEntity Entity = world.getBlockEntity(pos);
        if (Entity instanceof AuraNodeEntity){
            ItemScatterer.spawn(world,pos, (Inventory) ((Object) Entity));
            world.updateComparators(pos,this);
        }
        super.onStateReplaced(state, world, pos, newState, moved);
    }
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntityRegister.AURANODEENTITY, AuraNodeEntity::tick);
    }
}
