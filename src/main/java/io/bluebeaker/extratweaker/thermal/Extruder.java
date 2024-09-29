package io.bluebeaker.extratweaker.thermal;

import cofh.thermalexpansion.util.managers.machine.ExtruderManager;
import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import io.bluebeaker.extratweaker.ExtraTweaker;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("mods.thermalexpansion.Extruder")
@ModOnly("thermalexpansion")
public class Extruder {
    @ZenMethod
    public static void addRecipeIgneous(IItemStack output, int lava, int water, int energy) {
        ExtraTweaker.LATE_ADDITIONS.add(new ExtruderRecipe(output, lava, water, energy, false));
    }

    @ZenMethod
    public static void addRecipeSedimentary(IItemStack output, int lava, int water, int energy) {
        ExtraTweaker.LATE_ADDITIONS.add(new ExtruderRecipe(output, lava, water, energy, true));
    }

    public static class ExtruderRecipe implements IAction{
        IItemStack output;
        int lava;
        int water;
        int energy;
        boolean isSedimentary;
        public ExtruderRecipe(IItemStack output, int lava, int water, int energy, boolean isSedimentary){
            this.output=output;
            this.lava=lava;
            this.water=water;
            this.energy=energy;
            this.isSedimentary=isSedimentary;
        }
        @Override
        public void apply() {
            if(!this.isSedimentary){
                ExtruderManager.addRecipeIgneous(energy, CraftTweakerMC.getItemStack(output),
                new FluidStack(FluidRegistry.LAVA, lava), new FluidStack(FluidRegistry.WATER, water));
            }else{
                ExtruderManager.addRecipeSedimentary(energy, CraftTweakerMC.getItemStack(output),
                new FluidStack(FluidRegistry.LAVA, lava), new FluidStack(FluidRegistry.WATER, water));
            }
        }
        @Override
        public String describe() {
            return "Adding "+(this.isSedimentary?"Sedimentary":"Igneous")+"Extruder recipe: Lava*"+lava+"+ Water*"+water+"+"+energy+"RF = "+output.getDisplayName();
        }
    }
}
