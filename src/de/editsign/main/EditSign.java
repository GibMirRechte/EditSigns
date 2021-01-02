package de.editsign.main;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.BlockIterator;

public class EditSign implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String args[]) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("§cYou must be a player to use this command!");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(!p.hasPermission("editsign.use")) {
			sender.sendMessage("§cYou don't have the permissions to use this command!");
			return true;
		}
		
		if(args.length < 2) {
			p.sendMessage("§cPlease use /editsign <Line> <Message>");
			return true;
		}

		List<Material> signs = new ArrayList<>();
		signs.add(Material.ACACIA_SIGN);
		signs.add(Material.ACACIA_WALL_SIGN);
		signs.add(Material.BIRCH_SIGN);
		signs.add(Material.BIRCH_WALL_SIGN);
		signs.add(Material.CRIMSON_SIGN);
		signs.add(Material.CRIMSON_WALL_SIGN);
		signs.add(Material.DARK_OAK_SIGN);
		signs.add(Material.DARK_OAK_WALL_SIGN);
		signs.add(Material.JUNGLE_SIGN);
		signs.add(Material.JUNGLE_WALL_SIGN);
		signs.add(Material.OAK_SIGN);
		signs.add(Material.OAK_WALL_SIGN);
		signs.add(Material.SPRUCE_SIGN);
		signs.add(Material.SPRUCE_WALL_SIGN);
		signs.add(Material.WARPED_SIGN);
		signs.add(Material.WARPED_WALL_SIGN);
		
	    BlockIterator iter = new BlockIterator(p, 10);

	    Block lastBlock = iter.next();

	    while (iter.hasNext()) {

	        lastBlock = iter.next();

	        if (lastBlock.getType() == Material.AIR) {
	            continue;
	        }
	        break;
	    }
	    Location loc = lastBlock.getLocation();
		
		if(!signs.contains(p.getWorld().getBlockAt(loc).getType())) {
			p.sendMessage("§cYou must look at a sign!");
			return true;
		}
		
		Sign sign = (Sign) lastBlock.getState();
		
		String msg = "";
	      for (int i = 1; i < args.length; i++)
	        msg = String.valueOf(msg) + args[i] + " ";
		
		switch(args[0]) {
		case "1":
			sign.setLine(0, msg.replace("&", "§"));
			sign.update();
			break;
		case "2":
			sign.setLine(1, msg.replace("&", "§"));
			sign.update();
			break;
		case "3":
			sign.setLine(2, msg.replace("&", "§"));
			sign.update();
			break;
		case "4":
			sign.setLine(3, msg.replace("&", "§"));
			sign.update();
			break;
			default:
				p.sendMessage("§cPlease use a number between 1 and 4.");
				break;
		}
		
		p.sendMessage("§aThe line was changed.");
		return false;
	}

}
