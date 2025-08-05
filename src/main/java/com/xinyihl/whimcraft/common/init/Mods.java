package com.xinyihl.whimcraft.common.init;

import net.minecraftforge.fml.common.Loader;

public enum Mods {
    AE2FC("ae2fc"),
    AE2("appliedenergistics2"),
    AST("astralsorcery"),
    BOTANIA("botania"),
    EXU2("extrautils2"),
    GUGU("gugu-utils"),
    IC2("ic2"),
    MEKENG("mekeng"),
    MMCE("modularmachinery"),
    MOBUTILS("mob_grinding_utils"),
    NAE2("nae2"),
    NATURE("naturesaura"),
    TCOM("tcomplement"),
    TMF("tinymobfarm"),
    TC6("thaumcraft"),
    IE("immersiveengineering"),
    TCO("tconstruct"),
    FORESTRY("forestry"),
    MMADDONS("modularmachineryaddons"),
    MODTW("modtweaker"),
    ;

    public final String modid;
    private final boolean loaded;

    Mods(String modid) {
        this.modid = modid;
        this.loaded = Loader.isModLoaded(this.modid);
    }

    public boolean isLoaded() {
        return loaded;
    }
}
