# ExtraTweaker

CraftTweaker addon for something absent.

Current features:

Add recipe for Igneous Extruder from Thermal Expansion.

```
//mods.thermalexpansion.Extruder.addRecipeIgneous(IItemStack output, int lava, int water, int energy);
//mods.thermalexpansion.Extruder.addRecipeSedimentary(IItemStack output, int lava, int water, int energy);

import mods.thermalexpansion.Extruder;
Extruder.addRecipeIgneous(<minecraft:dirt>, 100, 100, 100);
Extruder.addRecipeSedimentary(<minecraft:dirt:1>, 100, 100, 100);
```