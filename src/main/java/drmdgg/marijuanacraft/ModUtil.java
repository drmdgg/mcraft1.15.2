package drmdgg.marijuanacraft;

import java.util.Objects;

import javax.annotation.Nonnull;

import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.ReportedException;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class ModUtil {

	@Nonnull
	@SuppressWarnings("ConstantConditions")
	public static final Direction[] DIRECTIONS = Direction.values();
	public static <T> T _null() {
	
		return null;

	}
	public static <T extends TileEntity> T getTileEntityOrCrash(final PlayerInventory playerInventory, final PacketBuffer data, final Class<T> tileEntityClass) {
		Objects.requireNonNull(playerInventory, "playerInventory cannot be null!");
		Objects.requireNonNull(data, "data cannot be null!");
		Objects.requireNonNull(tileEntityClass, "tileEntityClass cannot be null!");
		final BlockPos pos = data.readBlockPos();
		final World world = playerInventory.player.world;
		final TileEntity tileAtPos = world.getTileEntity(pos);

		final Throwable error;
		if (tileAtPos == null)
			error = new NullPointerException("No TileEntity at position");
		else if (!tileEntityClass.isAssignableFrom(tileAtPos.getClass()))
			error = new ClassCastException(tileAtPos.getClass() + " is not a " + tileEntityClass);
		else
			return (T) tileAtPos;
		CrashReport crashReport = CrashReport.makeCrashReport(error, "Creating Container for a HeatCollectorTileEntity");
		CrashReportCategory category = crashReport.makeCategory("Block at position");
		CrashReportCategory.addBlockInfo(category, pos, world.getBlockState(pos));
		throw new ReportedException(crashReport);
	}



}