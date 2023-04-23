package net.ssorangecaty.hydrochloric.generation.item.character;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.ssorangecaty.hydrochloric.generation.screen.RoleScreenHandler;
import net.ssorangecaty.hydrochloric.network.data.HydrochloricEvents;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CharacterGen extends Item implements ExtendedScreenHandlerFactory {
    public String[] skillName;
    public int level = 0;
    public int stageLevel = 0;
    public boolean canGacha = true;
    public int skillDuration = 12*20;
    public int triggerTime = 200;
    public boolean auto = false;
    public boolean attackTrigger = false;
    public int maxChargingTimes = 1;
    public int quality;
    public String firstSimpleSkillInfo = "技能介绍:如果你看到这条文字代表没有写";
    public String secondSimpleSkillInfo = "技能介绍:如果你看到这条文字代表没有写";
    public String thirdSimpleSkillInfo = "技能介绍:如果你看到这条文字代表没有写";
    public String[] firstSkillInfo = new String[]{"技能详情:如果你看到这条文字代表没有写","技能详情:如果你看到这条文字代表没有写"};
    public String[] secondSkillInfo = new String[]{"技能详情:如果你看到这条文字代表没有写","技能详情:如果你看到这条文字代表没有写"};
    public String[] thirdSkillInfo = new String[]{"技能详情:如果你看到这条文字代表没有写","技能详情:如果你看到这条文字代表没有写"};
    public String cnName;
    public String enName;
    public String characteristic;
    public Identifier image;
    public CharacterIdentifier identifier;
    public CharacterGen(String[][] arkData, int number, CharacterIdentifier identifier){
        super(new FabricItemSettings().maxCount(1));
        this.identifier = identifier;
        this.cnName = arkData[number][0];
        this.enName = arkData[number][1];
        this.characteristic = arkData[number][3];
        this.quality = Integer.parseInt(arkData[number][4]);
        this.image = identifier.getImage();
        this.skillName = new String[]{"item."+this.identifier.getName()+".skill_name1","item."+this.identifier.getName()+".skill_name2","item."+this.identifier.getName()+".skill_name3"};
        getMaxChargingTimes(1);
        GachaData.inputCharacter(this);
    }
    public void getMaxChargingTimes(int count){
        if(this.attackTrigger){
            this.maxChargingTimes = 0;
        }else this.maxChargingTimes = count;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(context.getStack().getNbt() == null){
            this.setNbt(context.getStack());
        }
        if(context.getPlayer().isSneaking()) {
            context.getPlayer().openHandledScreen(this);
            context.getPlayer().playSound(HydrochloricEvents.MIZUKI_MUSIC1_SOUNDEVENT, SoundCategory.PLAYERS, 1, 1);
        }else{
            int canUseTimes = context.getStack().getNbt().getInt("canUseTimes");
            if (context.getStack().getNbt().getInt("skillTick") == 0) {
                if (!this.auto) {
                    if (canUseTimes > 0 && canUseTimes <= maxChargingTimes) {
                        context.getStack().getNbt().putInt("canUseTimes", canUseTimes - 1);
                        context.getStack().getNbt().putInt("skillTick", skillDuration);
                    }
                }
            }
        }
        return ActionResult.SUCCESS;
    }
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        if (stack.getNbt() == null){
            setNbt(stack);
        }
        if(this.quality == 1){
            tooltip.add(Text.translatable(this.skillToolTipsCheck(stack)));
        }else if (this.quality == 2){
            tooltip.add(Text.translatable(this.skillToolTipsCheck(stack)).formatted(Formatting.GREEN));
        }else if (this.quality == 3){
            tooltip.add(Text.translatable(this.skillToolTipsCheck(stack)).formatted(Formatting.BLUE));
        }else if (this.quality == 4){
            tooltip.add(Text.translatable(this.skillToolTipsCheck(stack)).formatted(Formatting.LIGHT_PURPLE));
        }else if (this.quality == 5){
            tooltip.add(Text.translatable(this.skillToolTipsCheck(stack)).formatted(Formatting.GOLD));
        }else if (this.quality == 6){
            tooltip.add(Text.translatable(this.skillToolTipsCheck(stack)).formatted(Formatting.RED));
        }
            tooltip.add(Text.translatable("item.itemInfoTips").formatted(Formatting.DARK_GRAY));
    }
    public String skillToolTipsCheck(ItemStack stack){
        assert stack.getNbt() != null;
        return switch (stack.getNbt().getInt("selectSkill")) {
            case 1 -> "item." + this.identifier.getName() + ".secondSimpleSkillInfo";
            case 2 -> "item." + this.identifier.getName() + ".thirdSimpleSkillInfo";
            default -> "item." + this.identifier.getName() + ".firstSimpleSkillInfo";
        };
    }


    @Override
    public Text getDisplayName() {
        return Text.literal("character");
    }
    public ItemStack getItemStack(){
        ItemStack itemStack = new ItemStack(this,1);
        itemStack.getOrCreateNbt();
        setNbt(itemStack);
        return itemStack;
    }
    public Text getNextTriggerTime(ItemStack stack){
        if(this.triggerTime != -1){
            if(stack.getNbt().getInt("skillTick") > 0){
                return (Text.literal("持续时间: ").formatted(Formatting.DARK_AQUA))
                        .append(Text.literal(String.valueOf(stack.getNbt().getInt("skillTick")/20)).formatted(Formatting.AQUA));
            } else if (attackTrigger) {
                return (Text.literal(stack.getNbt().getInt("characterTick")+"sp").formatted(Formatting.GOLD))
                        .append(Text.literal(" / ").formatted(Formatting.GREEN))
                        .append(Text.literal(triggerTime+"sp").formatted(Formatting.GOLD))
                        .append(Text.literal("  |  ").formatted(Formatting.DARK_AQUA))
                        .append(Text.literal("充能: ").formatted(Formatting.YELLOW))
                        .append(Text.literal(String.valueOf(stack.getNbt().getInt("canUseTimes"))).formatted(Formatting.YELLOW))
                        .append(Text.literal(" / "+this.maxChargingTimes).formatted(Formatting.YELLOW));
            }
            return (Text.literal(stack.getNbt().getInt("characterTick")/20+"sp").formatted(Formatting.GOLD))
                        .append(Text.literal(" / ").formatted(Formatting.GREEN))
                        .append(Text.literal(triggerTime/20+"sp").formatted(Formatting.GOLD))
                        .append(Text.literal("  |  ").formatted(Formatting.DARK_AQUA))
                        .append(Text.literal("充能: ").formatted(Formatting.YELLOW))
                        .append(Text.literal(String.valueOf(stack.getNbt().getInt("canUseTimes"))).formatted(Formatting.YELLOW))
                        .append(Text.literal(" / "+this.maxChargingTimes).formatted(Formatting.YELLOW));
        }else return Text.literal("持续时间: 无限").formatted(Formatting.DARK_AQUA);

    }
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            int ct = 0;
            if (stack.getNbt() == null) {
                setNbt(stack);
            }
            this.updateTick(stack);
            ct = stack.getNbt().getInt("characterTick");
            if(this.triggerTime == -1){
                triggerSkill(stack, world, (LivingEntity) entity);
            }else {
                if(stack.getNbt().getInt("skillTick") == 0) {
                    resetSkillEffect(entity);
                    if(this.auto && !attackTrigger){
                        if (ct >= triggerTime) {
                            stack.getNbt().putInt("characterTick", 0);
                            triggerSkill(stack, world, (LivingEntity) entity);
                        }
                    } else if (attackTrigger){
                        triggerSkill(stack, world, (LivingEntity) entity);
                    }
                }else {
                    stack.getNbt().putInt("skillTick",stack.getNbt().getInt("skillTick") - 1);
                    triggerSkill(stack, world, (LivingEntity) entity);
                }
            }
        }
    }

    public void resetSkillEffect(Entity entity){
    }
    public void updateTick(ItemStack stack){
        if(!attackTrigger) {
            if (stack.getNbt().getInt("canUseTimes") < this.maxChargingTimes && stack.getNbt().getInt("skillTick") == 0) {
                if (stack.getNbt().getInt("characterTick") < this.triggerTime) {
                    stack.getNbt().putInt("characterTick", stack.getNbt().getInt("characterTick") + 1);
                } else {
                    stack.getNbt().putInt("canUseTimes", stack.getNbt().getInt("canUseTimes") + 1);
                    stack.getNbt().putInt("characterTick", 0);
                }
            }
        }
    }
    public void triggerSkill(ItemStack stack, World world, LivingEntity entity){
        if(this.quality > 3){
            switch (stack.getNbt().getInt("selectSkill")){
                case 0 : this.firstSkill(stack,world,entity);
                case 1 : this.secondSkill(stack,world,entity);
                case 2 : this.thirdSkill(stack,world,entity);
            }
        }else{
            this.firstSkill(stack,world,entity);
        }
    }
    public void firstSkill(ItemStack stack, World world, LivingEntity entity){
        entity.sendMessage(Text.literal("触发了 "+this.cnName+" 的一技能但是没有写功能.").formatted(Formatting.GRAY));
    }
    public void secondSkill(ItemStack stack, World world, LivingEntity entity){
        entity.sendMessage(Text.literal("触发了 "+this.cnName+" 的二技能但是没有写功能.").formatted(Formatting.GRAY));
    }
    public void thirdSkill(ItemStack stack, World world, LivingEntity entity){
        entity.sendMessage(Text.literal("触发了 "+this.cnName+" 的三技能但是没有写功能.").formatted(Formatting.GRAY));
    }
    public void setNbt(ItemStack stack){
        NbtCompound nbt;
        if(stack.getNbt() == null){
            nbt = new NbtCompound();
        }else{
            nbt = stack.getNbt();
        }
        nbt.putInt("level",0);
        nbt.putInt("stageLevel",0);
        nbt.putInt("selectSkill",0);
        nbt.putInt("characterTick",0);
        nbt.putInt("skillTick",0);
        nbt.putInt("canUseTimes",0);
        stack.setNbt(nbt);
    }

    public Item registerItem(){
        return Registry.register(Registries.ITEM,this.identifier.getItemId(),this);
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        PacketByteBuf data = PacketByteBufs.create();
        return new RoleScreenHandler(syncId,playerInventory,data);
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
    }
}
