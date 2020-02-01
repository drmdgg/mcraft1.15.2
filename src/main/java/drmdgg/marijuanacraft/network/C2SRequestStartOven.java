package drmdgg.marijuanacraft.network;



import java.util.function.Supplier;

import drmdgg.marijuanacraft.init.blocks.tileentities.VacuumOvenTileEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.NetworkEvent;

public class C2SRequestStartOven {

    public BlockPos pos;
    
 
	public C2SRequestStartOven(BlockPos pos) 
	{
		this.pos = pos;
	}

	public static void encode(C2SRequestStartOven msg, PacketBuffer buf) {
    	buf.writeBlockPos(msg.pos);
    	
	}
	public static C2SRequestStartOven decode(PacketBuffer buf) {
		return new C2SRequestStartOven(buf.readBlockPos());
	    }
	
	
	

			public static void handle(C2SRequestStartOven msg, Supplier<NetworkEvent.Context> ctx) {
		    ctx.get().enqueueWork(() -> {
		        // Work that needs to be threadsafe (most work)
		        TileEntity sender = ctx.get().getSender().getServerWorld().getTileEntity(msg.pos); // the client that sent this packet
		        // do stuff
		        if(sender instanceof VacuumOvenTileEntity)
		        {
		        	{
		        		((VacuumOvenTileEntity)sender).maxFuelBurnTime = 200;
		        		((VacuumOvenTileEntity)sender).fuelBurnTimeLeft = 200;
		        		

		        		
		        		//what to put here?
					}
		        }
		    });
		    ctx.get().setPacketHandled(true);
		}
	}

