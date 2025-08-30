package com.xinyihl.whimcraft.common.block.base;

import com.xinyihl.whimcraft.common.title.base.TitleMEAspectBus;
import com.xinyihl.whimcraft.common.title.base.TitleMEAspectBusMMCE;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public abstract class BlockMEBase extends BlockTitleBase {

    public BlockMEBase(String name) {
        super(name);
    }

    @Override
    public boolean onBlockActivated(@Nonnull World world, @Nonnull BlockPos blockPos, @Nonnull IBlockState iBlockState, @Nonnull EntityPlayer entityPlayer, @Nonnull EnumHand enumHand, @Nonnull EnumFacing enumFacing, float v, float v1, float v2) {
        return false;
    }

    public void onBlockPlacedBy(@Nonnull World world, @Nonnull BlockPos pos, @Nonnull IBlockState state, @Nonnull EntityLivingBase placer, @Nonnull ItemStack stack) {
        super.onBlockPlacedBy(world, pos, state, placer, stack);
        if (!world.isRemote) {
            TileEntity te = world.getTileEntity(pos);
            if (te instanceof TitleMEAspectBus && placer instanceof EntityPlayer) {
                TitleMEAspectBus tn = (TitleMEAspectBus) te;
                tn.setOwner((EntityPlayer) placer);
                tn.getActionableNode();
            }
            if (te instanceof TitleMEAspectBusMMCE && placer instanceof EntityPlayer) {
                TitleMEAspectBusMMCE tn = (TitleMEAspectBusMMCE) te;
                tn.setOwner((EntityPlayer) placer);
                tn.getActionableNode();
            }
        }
    }
}
