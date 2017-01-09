package emt.command;

import emt.util.EMTEssentiasOutputs;
import emt.util.EMTTextHelper;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import thaumcraft.api.aspects.Aspect;

import java.util.Collection;
import java.util.List;

public class CommandOutputs extends CommandBase {

    public String text;

    @Override
    public String getCommandName() {
        return "emt_outputs";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return "/emt_outputs";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender par1iCommandSender) {
        return true;
    }

    @Override
    public List addTabCompletionOptions(ICommandSender command, String[] stringArray) {
        return null;
    }

    @Override
    public int compareTo(Object object) {
        if (object instanceof ICommand) {
            return this.compareTo((ICommand) object);
        } else {
            return 0;
        }
    }

    @Override
    public void processCommand(ICommandSender command, String[] astring) {
        text = EMTTextHelper.localize("gui.EMT.book.aspect.output.essentia.eu") + ": ";
        Collection<Aspect> aspectCollection = Aspect.aspects.values();
        for (Aspect aspect : aspectCollection) {
            String text2 = addStrings(text, (aspect.getTag() + ": " + String.valueOf(EMTEssentiasOutputs.outputs.get(aspect.getTag())) + "\n"));
            text = text2;
        }
        addOutputsBook(EMTTextHelper.localize("gui.EMT.book.aspect.output.eu.title"), text, command, astring);
    }

    public void addOutputsBook(String title, String text, ICommandSender command, String[] astring) {
        ItemStack book = new ItemStack(Items.written_book);
        book.setTagInfo("author", new NBTTagString("Tombenpotter"));
        book.setTagInfo("title", new NBTTagString(title));
        NBTTagCompound nbttagcompound = book.getTagCompound();
        NBTTagList bookPages = new NBTTagList();

        bookPages.appendTag(new NBTTagString(text.substring(0, 237)));
        bookPages.appendTag(new NBTTagString(text.substring(237, 476)));
        bookPages.appendTag(new NBTTagString(text.substring(476, 709)));
        bookPages.appendTag(new NBTTagString(text.substring(709)));

        nbttagcompound.setTag("pages", bookPages);

        System.out.println(text.length());

        if (!command.getEntityWorld().getPlayerEntityByName(command.getCommandSenderName()).inventory.addItemStackToInventory(book))
            command.getEntityWorld().getPlayerEntityByName(command.getCommandSenderName()).entityDropItem(book, 0);
    }

    public String addStrings(String string1, String string2) {
        String result = string1 + string2;
        return result;
    }
}
