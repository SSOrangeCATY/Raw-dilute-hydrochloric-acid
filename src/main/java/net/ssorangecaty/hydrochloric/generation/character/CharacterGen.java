package net.ssorangecaty.hydrochloric.generation.character;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.ssorangecaty.hydrochloric.generation.screen.RoleScreenHandler;
import net.ssorangecaty.hydrochloric.network.data.ModEvents;
import net.ssorangecaty.hydrochloric.util.EntityGameDataSaver;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CharacterGen extends Item implements NamedScreenHandlerFactory {
    public String[] skillName = new String[]{"name1","name2","name3"};
    public int skillDuration = 12*20;
    public int triggerTime = 200;
    public boolean auto = false;
    public int maxChargingTimes = 1;
    public int quality;
    public String simpleSkillInfo = "技能介绍:如果你看到这条文字代表没有写";
    public String[] skillInfo = new String[]{"技能详情:如果你看到这条文字代表没有写","技能详情:如果你看到这条文字代表没有写"};
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
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(context.getPlayer().isSneaking()) {
            context.getPlayer().openHandledScreen(this);
            context.getPlayer().playSound(ModEvents.MIZUKI_MUSIC1_SOUNDEVENT, SoundCategory.PLAYERS, 1, 1);
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
            setNbt(stack,this.triggerTime);
        }
        if(this.quality == 1){
            tooltip.add(Text.literal(this.simpleSkillInfo));
        }else if (this.quality == 2){
            tooltip.add(Text.literal(this.simpleSkillInfo).formatted(Formatting.GREEN));
        }else if (this.quality == 3){
            tooltip.add(Text.literal(this.simpleSkillInfo).formatted(Formatting.BLUE));
        }else if (this.quality == 4){
            tooltip.add(Text.literal(this.simpleSkillInfo).formatted(Formatting.LIGHT_PURPLE));
        }else if (this.quality == 5){
            tooltip.add(Text.literal(this.simpleSkillInfo).formatted(Formatting.GOLD));
        }else if (this.quality == 6){
            tooltip.add(Text.literal(this.simpleSkillInfo).formatted(Formatting.RED));
        }
            tooltip.add(Text.literal("按下shift以查看详情").formatted(Formatting.DARK_GRAY));
    }
    @Override
    public Text getDisplayName() {
        return Text.literal("character");
    }
    public Text getNextTriggerTime(ItemStack stack){
        if(this.triggerTime != -1){
            if(stack.getNbt().getInt("skillTick") > 0){
                return (Text.literal("持续时间: ").formatted(Formatting.DARK_AQUA))
                        .append(Text.literal(String.valueOf(stack.getNbt().getInt("skillTick")/20)).formatted(Formatting.AQUA));
            }
                return (Text.literal(stack.getNbt().getInt("characterTick")/20+"SP").formatted(Formatting.GOLD))
                        .append(Text.literal(" / ").formatted(Formatting.GREEN))
                        .append(Text.literal(triggerTime/20+"SP").formatted(Formatting.GOLD))
                        .append(Text.literal("  |  ").formatted(Formatting.DARK_AQUA))
                        .append(Text.literal("充能: ").formatted(Formatting.YELLOW))
                        .append(Text.literal(String.valueOf(stack.getNbt().getInt("canUseTimes"))).formatted(Formatting.YELLOW))
                        .append(Text.literal(" / "+this.maxChargingTimes).formatted(Formatting.YELLOW));
        }else return Text.literal("持续时间: 无限").formatted(Formatting.DARK_AQUA);

    }
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            this.updateTick(stack);
            int ct = stack.getNbt().getInt("characterTick");
            if(this.triggerTime == -1){
                triggerSkill(stack, world, (LivingEntity) entity);
            }else {
                if(stack.getNbt().getInt("skillTick") == 0) {
                    resetSkillEffect(entity);
                    if(this.auto){
                        if (ct >= triggerTime) {
                            stack.getNbt().putInt("characterTick", 0);
                            triggerSkill(stack, world, (LivingEntity) entity);
                        }
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
        if(stack.getNbt().getInt("canUseTimes") < this.maxChargingTimes && stack.getNbt().getInt("skillTick") == 0) {
            if (stack.getNbt().getInt("characterTick") < this.triggerTime) {
                stack.getNbt().putInt("characterTick", stack.getNbt().getInt("characterTick") + 1);
            } else {
                stack.getNbt().putInt("canUseTimes", stack.getNbt().getInt("canUseTimes") + 1);
                stack.getNbt().putInt("characterTick", 0);
            }
        }
    }
    public void triggerSkill(ItemStack stack, World world, LivingEntity entity){
        entity.sendMessage(Text.literal("触发了 "+this.cnName+" 的技能但是没有写功能.").formatted(Formatting.GRAY));
    }
    public void setNbt(ItemStack stack,int triggerTime){
        NbtCompound nbt = new NbtCompound();
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
        return new RoleScreenHandler(syncId,playerInventory);
    }
}
