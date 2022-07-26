package net.serenas.shitmod;


import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class testHammer extends PickaxeItem {

    protected testHammer(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    @Override
    public boolean canMine(BlockState blockState, World world, BlockPos pos, PlayerEntity player) {
        if (world.isClient){
            return true;
        }
        ItemStack mainHandStack = player.getMainHandStack();
        Vec3d vec3d_1 = player.getCameraPosVec(1);
        Vec3d vec3d_2 = player.getRotationVec(1);
        int range = 4;
        Vec3d vec3d_3 = vec3d_1.add(vec3d_2.x * range, vec3d_2.y * range, vec3d_2.z * range);
        BlockHitResult hitResult = world.raycast(new RaycastContext(vec3d_1, vec3d_3, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.ANY, player));
        Direction.Axis axis = hitResult.getSide().getAxis();
        for (int i = -1; i <= 1; i++)
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    BlockPos newPos = new BlockPos(axis == Axis.X ? pos.getX() : pos.getX() + i, axis == Axis.X ? pos.getY() + i : axis == Axis.Y ? pos.getY() : pos.getY() + j, axis != Axis.Z ? pos.getZ() + j : pos.getZ());
                    BlockState newState = world.getBlockState(newPos);
                    boolean canBreak = newState.getHardness(world, newPos) >= 0 || (!newState.isToolRequired() && mainHandStack.getMiningSpeedMultiplier(newState) > 1);
                    if (!canBreak)
                        continue;
                    world.breakBlock(newPos, true, player);
                }
            }
        return true;

    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        stack.addEnchantment(Enchantments.EFFICIENCY, 5);
    }
}
