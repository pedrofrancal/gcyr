package argent_matter.gcyr.common.data.material;

import argent_matter.gcyr.GCYR;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.registry.registrate.entry.MaterialRegistryEntry;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.*;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.attribute.FluidAttributes;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.GENERATE_PLATE;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.SHINY;
import static argent_matter.gcyr.api.registries.GCYRRegistries.REGISTRATE;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

@SuppressWarnings("unused")
public class GCYRMaterials {

    public static MaterialRegistryEntry PotassiumChloride;
    public static MaterialRegistryEntry Bisalloy400;
    public static MaterialRegistryEntry ChromicAcid;
    public static MaterialRegistryEntry Trinaquadalloy;
    public static MaterialRegistryEntry Fluorite;
    public static MaterialRegistryEntry IronOxide;
    public static MaterialRegistryEntry MartianRockDust;
    public static MaterialRegistryEntry Methylbenzaldehyde;
    public static MaterialRegistryEntry AluminiumTrichloride;
    public static MaterialRegistryEntry FiberGlass;
    public static MaterialRegistryEntry PyromelliticDianhydride;
    public static MaterialRegistryEntry Durene;
    public static MaterialRegistryEntry Dimethylformamide;
    public static MaterialRegistryEntry Oxydianiline;
    public static MaterialRegistryEntry OxydianilineSludge;
    public static MaterialRegistryEntry KaptonK;
    public static MaterialRegistryEntry ParaXylene;
    public static MaterialRegistryEntry BisTrichloromethylBenzene;
    public static MaterialRegistryEntry TerephthalicAcid;
    public static MaterialRegistryEntry TerephthaloylChloride;
    public static MaterialRegistryEntry Nitroaniline;
    public static MaterialRegistryEntry ParaPhenylenediamine;
    public static MaterialRegistryEntry ParaAramid;

    public static void init() {
        PotassiumChloride = REGISTRATE.material("potassium_chloride", b -> b
                    .dust(1)
                    .color(0xF6F1AE)
                    .components(Potassium, 1, Chlorine, 1));

        Bisalloy400 = REGISTRATE.material("bisalloy_400", b -> b
                    .ingot(5).fluid()
                    .color(0x0ca819)
                    .components(Carbon, 3, Manganese, 4, Silicon, 2, Chromium, 3, Molybdenum, 1, Iron, 11)
                    .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_LONG_ROD,
                            MaterialFlags.GENERATE_GEAR, MaterialFlags.GENERATE_FRAME)
                    .toolStats(ToolProperty.Builder.of(70.0f, 2.25f, 1296, 5).build())
                    .blastTemp(10800, BlastProperty.GasTier.HIGHER));

        ChromicAcid = REGISTRATE.material("chromic_acid", b -> b
                    .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                    .color(0xE5D8F2)
                    .components(Hydrogen, 2, Chromium, 1, Oxygen, 4));

        Trinaquadalloy = REGISTRATE.material("trinaquadalloy", b -> b
                    .ingot().fluid()
                    .color(0x281832).iconSet(MaterialIconSet.BRIGHT)
                    .flags(GENERATE_PLATE, GENERATE_DENSE)
                    .components(Trinium, 6, Naquadah, 2, Carbon, 1)
                    .blastTemp(8747, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.ZPM], 1200));

        Fluorite = REGISTRATE.material("fluorite", b -> b
                    .gem().ore()
                    .color(0x0c9949).iconSet(MaterialIconSet.DIAMOND)
                    .components(Calcium, 1, Fluorine, 2));

        IronOxide = REGISTRATE.material("iron_oxide", b -> b
                    .dust()
                    .color(0xBD3514)
                    .flags(DECOMPOSITION_BY_CENTRIFUGING)
                    .components(Iron, 2, Oxygen, 3));

        MartianRockDust = REGISTRATE.material("martian_rock_dust", b -> b
                    .dust()
                    .color(0xAB2C0E));

        Methylbenzaldehyde = REGISTRATE.material("methylbenzaldehyde", b -> b
                    .fluid()
                    .colorAverage()
                    .components(Carbon, 8, Hydrogen, 8, Oxygen, 1));

        AluminiumTrichloride = REGISTRATE.material("aluminium_trichloride", b -> b
                    .dust()
                    .colorAverage()
                    .components(Aluminium, 1, Chlorine, 3));

        FiberGlass = REGISTRATE.material("fiberglass", b -> b
                    .polymer(1)
                    .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(1531))
                    .color(0xC7D9D1).iconSet(SHINY)
                    .flags(GENERATE_FINE_WIRE, GENERATE_PLATE, GENERATE_FOIL, NO_SMASHING, NO_WORKING)
                    .components(Epoxy, 2, SiliconDioxide, 7));

        PyromelliticDianhydride = REGISTRATE.material("pyrometillic_dianhydride", b -> b
                    .dust()
                    .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(493))
                    .color(0xB48C63)
                    .components(Carbon, 10, Hydrogen, 2, Oxygen, 6)
                    .formula("C6H2(C2O3)2", true));

        Durene = REGISTRATE.material("durene", b -> b
                    .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(493))
                    .color(0xB48C63)
                    .components(Carbon, 10, Hydrogen, 14)
                    .formula("C6H2(CH3)4", true));

        Dimethylformamide = REGISTRATE.material("dimethylformamide", b -> b
                    .fluid()
                    .color(0x554469)
                    .flags(DISABLE_DECOMPOSITION)
                    .components(Carbon, 3, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                    .formula("(CH3)2NC(O)H", true));

        Oxydianiline = REGISTRATE.material("oxydianiline", b -> b
                    .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(493))
                    .color(0xfAAEE0)
                    .components(Carbon, 12, Hydrogen, 12, Nitrogen, 2, Oxygen, 1));

        OxydianilineSludge = REGISTRATE.material("oxydianiline_sludge", b -> b
                    .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(493))
                    .color(0xD9CCBF)
                    .flags(DISABLE_DECOMPOSITION)
                    .components(Oxydianiline, 1, Dimethylformamide, 1));

        KaptonK = REGISTRATE.material("kapton_k", b -> b
                    .polymer(1)
                    .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(493))
                    .color(0x915A23)
                    .appendFlags(STD_METAL, GENERATE_FOIL)
                    .components(PyromelliticDianhydride, 1, Oxydianiline, 1));

        ParaXylene = REGISTRATE.material("para_xylene", b -> b
                    .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(493))
                    .colorAverage()
                    .components(Carbon, 8, Hydrogen, 10));

        BisTrichloromethylBenzene = REGISTRATE.material("bis_trichloromethyl_benzene", b -> b
                    .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(493))
                    .color(0xB48C63)
                    .components(Carbon, 8, Hydrogen, 4, Chlorine, 6)
                    .formula("C6H4(CCl3)2", true));

        TerephthalicAcid = REGISTRATE.material("therephthalic_acid", b -> b
                    .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                    .color(0xDB9374)
                    .components(Carbon, 6, Hydrogen, 4, CarbonDioxide, 2, Hydrogen, 2)
                    .formula("C6H4(CO2H)2", true));

        TerephthaloylChloride = REGISTRATE.material("terephthaloyl_chloride", b -> b
                    .fluid()
                    .color(0xB883DE)
                    .components(Carbon, 8, Hydrogen, 4, Chlorine, 2, Oxygen, 2));

        Nitroaniline = REGISTRATE.material("nitroaniline", b -> b
                    .fluid()
                    .colorAverage()
                    .components(Carbon, 8, Hydrogen, 4, Chlorine, 2, Oxygen, 2));

        ParaPhenylenediamine = REGISTRATE.material("para_phenylenediamine", b -> b
                    .fluid()
                    .color(0xC3DE83)
                    .components(Nitrochlorobenzene, 1, Ammonia, 1));

        ParaAramid = REGISTRATE.material("para_aramid", b -> b
                    .polymer(2)
                    .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(493))
                    .color(0xE6ED7B)
                    .appendFlags(STD_METAL, GENERATE_FOIL)
                    .components(ParaPhenylenediamine, 1, TerephthaloylChloride, 1)
                    .fluidPipeProperties(1500, 450, true, true, true, false));
    }

    public static void modifyMaterials() {
        // Add flags to base GT materials
        Iron.get().addFlags(GENERATE_FOIL);
        IronMagnetic.get().addFlags(GENERATE_FOIL);
        TitaniumTungstenCarbide.get().addFlags(GENERATE_ROD);
        Titanium.get().setProperty(PropertyKey.ORE, new OreProperty());

        GTMaterials.Hydrogen.get().getProperty(PropertyKey.FLUID)
                .enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder());
    }
}
